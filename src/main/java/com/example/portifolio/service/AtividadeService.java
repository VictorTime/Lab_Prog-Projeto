package com.example.Portifolio.Service;

import java.util.List;
import java.util.Optional;

import com.example.Portifolio.model.entidade.*;
import com.example.Portifolio.model.repositorio.*;
import com.example.Portifolio.Service.exceptions.RegraPortifolioRunTime;

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

    public List<Atividade> obterAtividades() {
        return repository.findAll();
    }

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
        if ((ativ == null) || (ativ.getId_atv() == 0))
            throw new RegraPortifolioRunTime("Atividade sem id");
    }

    public boolean validar(Long matricula, Atividade ativ){
        verificarId(ativ);
        if( matricula != ativ.getUsuario().getMatricula() )
            throw new RegraPortifolioRunTime("usuario invalido para validar");
        return true;


    }
    
    private void verificaAtividade(Atividade ativ) {
        if(ativ == null)
            throw new RegraPortifolioRunTime("Um Atividade válido deve ser informado");

        if ((ativ.getTitulo() == null) 
            || (ativ.getTitulo().equals("")))
        throw new RegraPortifolioRunTime("Nome do Atividade precisa ser preenchido");
    }
    

}
