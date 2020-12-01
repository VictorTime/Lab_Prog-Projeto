package com.example.Portifolio.controller;

import com.example.Portifolio.Service.AtividadeService;
import com.example.Portifolio.Service.exceptions.RegraPortifolioRunTime;
import com.example.Portifolio.model.dto.AtividadeDTO;
import com.example.Portifolio.model.entidade.Atividade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/atividades")
public class AtividadeController {
    @Autowired
    AtividadeService service;
    
    public AtividadeController(AtividadeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody AtividadeDTO dto) {
        Atividade atividade = Atividade.builder()
                                    .titulo(dto.getTitulo())
                                    .tipo_atv(dto.getTipo_atv())
                                    .resumo(dto.getResumo())
                                    .link(dto.getLink()).build();
        try {
            Atividade salvo = service.salvar(atividade);
            return new ResponseEntity(salvo, HttpStatus.CREATED);
        }
        catch (RegraPortifolioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
