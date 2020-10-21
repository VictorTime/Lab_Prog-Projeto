package com.example.portifolio.service;

import java.util.List;
import java.util.Optional;

//import com.example.portifolio.entidades.atividade;
//import com.example.portifolio.entidades.Posicao;
//import com.example.portifolio.entidades.Usuario;
//import com.example.portifolio.repositorio.curriculo;
//import com.example.portifolio.repositorio.PosicaoRepository;
//import com.example.portifolio.repositorio.UsuarioRepository;
//import com.example.portifolio.Service.exceptions.RegraPortigolioRunTime;
import com.example.portifolio.Entidade.*;
import com.example.portifolio.Repositorio.*;
import com.example.portifolio.service.exceptions.*;


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

    public atividade salvar(atividade ativ) {    
        verificaAtividade(ativ);
        return repository.save(ativ);
    }

    public atividade atualizar(atividade ativ) {
        verificarId(ativ);
        return salvar(ativ);
    }

    public void remover(atividade ativ) {        
        verificarId(ativ);
        repository.delete(ativ);
    }

    public void remover(long idAtividade) {        
        Optional<atividade> ativ = repository.findById(idAtividade);
        remover(ativ.get());
    }


    public List<atividade> buscar (atividade filtro) {
        Example<atividade> example = 
        Example.of(filtro, ExampleMatcher.matching()
                                        .withIgnoreCase()
                                        .withStringMatcher(StringMatcher.CONTAINING)
                                        );

        return repository.findAll(example);                                                           
    }

    private void verificarId(atividade ativ) {
        if ((ativ == null) || (ativ.getId() == null))
            throw new RegraPortifolioRunTime("atividade sem id");
    }

    private void verificaAtividade(atividade ativ) {
        if(ativ == null)
            throw new RegraNegocioRunTime("Um atividade válido deve ser informado");

        if ((ativ.getNome() == null) 
            || (ativ.getNome().equals("")))
        throw new RegraNegocioRunTime("Nome do atividade precisa ser preenchido");

        if(ativ.getUsuario() == null)
            throw new RegraNegocioRunTime("Um atividade deve estar atrelado a um usuário válido");

        Optional<Usuario> temp = usuarioRep.findById(ativ.getUsuario().getId());
            if (!temp.isPresent())
                throw new RegraNegocioRunTime("Usuário informado não consta na base");

    }

}
