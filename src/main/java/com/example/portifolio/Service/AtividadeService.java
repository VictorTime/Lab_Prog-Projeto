package com.example.portifolio.Service;

import java.util.List;
import java.util.Optional;

import com.example.portifolio.Entidade.*;
import com.example.portifolio.Repositorio.*;
import com.example.portifolio.Service.exceptions.RegraPortifolioRunTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

@Service
public class AtividadeService {
    
    @Autowired
    AtividadeRepositorio repository;

    @Autowired
    UsuarioRepositorio usuarioRep;

    @Autowired
    CurriculoRepositorio curricRep;

    Long var = null;

    public Atividade salvar(Atividade ativ) {    
        verificaAtividade(ativ);
        return repository.save(ativ);
    }

    public Atividade atualizar(Atividade ativ) {
        verificarId(ativ);
        return salvar(ativ);
    }

    public void remover(Atividade ativ) {        
        verificarId(ativ);
        repository.delete(ativ);
    }

    public void remover(long idAtividade) {        
        Optional<Atividade> ativ = repository.findById(idAtividade);
        remover(ativ.get());
    }

    public List<Atividade> buscar (Atividade filtro) {
        Example<Atividade> example = 
        Example.of(filtro, ExampleMatcher.matching()
                                        .withIgnoreCase()
                                        .withStringMatcher(StringMatcher.CONTAINING)
                                        );

        return repository.findAll(example);                                                           
    }
    

    private void verificarId(Atividade ativ) {
        if ((ativ == null) || (ativ.getId_atv() == var))
            throw new RegraPortifolioRunTime("Atividade sem id");
    }

    
    private void verificaAtividade(Atividade ativ) {
        if(ativ == null)
            throw new RegraPortifolioRunTime("Um Atividade válido deve ser informado");

        if ((ativ.getDocente_relac() == null) 
            || (ativ.getDocente_relac().equals("")))
        throw new RegraPortifolioRunTime("Nome do Atividade precisa ser preenchido");
    }
    

}
