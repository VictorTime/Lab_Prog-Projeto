package com.example.Portifolio.controller;

import com.example.Portifolio.Service.CurriculoService;
import com.example.Portifolio.Service.exceptions.RegraPortifolioRunTime;
import com.example.Portifolio.model.dto.CurriculoDTO;
import com.example.Portifolio.model.entidade.Curriculo;
import com.example.Portifolio.model.entidade.Usuario;
import com.example.Portifolio.model.repositorio.CurriculoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CurriculoController {
    
    @Autowired
    CurriculoRepositorio curricRep;

    @Autowired
    CurriculoService service;

    @PostMapping
    public ResponseEntity salvar(@RequestBody CurriculoDTO dto) {
        Curriculo curriculo = Curriculo.builder()
                                    .id_curriculo(dto.getId_curriculo())
                                    .escolaridade(dto.getEscolaridade())
                                    .formacao(dto.getFormacao())
                                    .usuario(Usuario.builder().matricula(dto.getMatricula()).build())
                                    .build();
        try {
            Curriculo salvo = service.salvar(curriculo);
            return new ResponseEntity(salvo, HttpStatus.CREATED);
        }
        catch (RegraPortifolioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

