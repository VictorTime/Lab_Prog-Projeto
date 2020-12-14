package com.example.Portifolio.Service;

import java.util.List;
import java.util.Optional;

import com.example.Portifolio.model.entidade.Atividade;
import com.example.Portifolio.model.entidade.Curriculo;
import com.example.Portifolio.model.repositorio.AtividadeRepositorio;
import com.example.Portifolio.model.repositorio.CurriculoRepositorio;
import com.example.Portifolio.model.repositorio.UsuarioRepositorio;
import com.example.Portifolio.Service.exceptions.RegraPortifolioRunTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

@Service
public class CurriculoService {
    
    @Autowired
    AtividadeRepositorio repository;

    @Autowired
    UsuarioRepositorio usuarioRep;

    @Autowired
    CurriculoRepositorio curricRep;

    public List<Curriculo> obterCurriculos() {
        return curricRep.findAll();
    }


    public Curriculo salvar(Curriculo curriculo) {    
        verificaCurriculo(curriculo);
        return curricRep.save(curriculo);
    }

    public Curriculo atualizar(Curriculo curriculo) {
        verificarId(curriculo);
        return salvar(curriculo);
    }

    public void remover(Curriculo curriculo) {        
        verificarId(curriculo);
        curricRep.delete(curriculo);
    }

    public void remover(long idCurriculo) {        
        Optional<Curriculo> curriculo = curricRep.findById(idCurriculo);
        remover(curriculo.get());
    }

    public List<Curriculo> buscar (Curriculo filtro) {
        Example<Curriculo> example = 
        Example.of(filtro, ExampleMatcher.matching()
                                        .withIgnoreCase()
                                        .withStringMatcher(StringMatcher.CONTAINING)
                                        );

        return curricRep.findAll(example);                                                           
    }
    

    private void verificarId(Curriculo curriculo) {
        if ((curriculo == null) || (curriculo.getId_curriculo() == 0))
            throw new RegraPortifolioRunTime("Curriculo sem id");
    }

    //Adicionar as verificações das atividade e do usuario
    private void verificaCurriculo(Curriculo curriculo) {
        if (curriculo == null)
            throw new RegraPortifolioRunTime("Um curriculo válido deve ser informado");
        if ((curriculo.getEscolaridade() == null) || (curriculo.getEscolaridade().equals("")))
            throw new RegraPortifolioRunTime("Sem escolaridade informada no curriculo");
        if ((curriculo.getFormacao() == null) || (curriculo.getFormacao().equals("")))
            throw new RegraPortifolioRunTime("Sem formacao academica informada no curriculo");
        verificarId(curriculo);
    }
    

}
