package com.example.Portifolio.controller;

import com.example.Portifolio.Service.AtividadeService;
import com.example.Portifolio.Service.exceptions.RegraPortifolioRunTime;
import com.example.Portifolio.model.dto.AtividadeDTO;
import com.example.Portifolio.model.entidade.Atividade;
import com.example.Portifolio.model.entidade.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/atividades")

public class AtividadeController {
    @Autowired
    AtividadeService service;

    @PostMapping
    public ResponseEntity salvar(@RequestBody AtividadeDTO dto) {
        
        Atividade atividade = Atividade.builder()
                                    .titulo(dto.getTitulo())
                                    .tipo_atv(dto.getTipo_atv())
                                    .resumo(dto.getResumo())
                                    .link(dto.getLink())
                                    .usuario(Usuario.builder().matricula(dto.getMatricula()).build())
                                    .build();
        try {
            Atividade salvo = service.salvar(atividade);
            return new ResponseEntity(salvo, HttpStatus.CREATED);
        }
        catch (RegraPortifolioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity atualizar(@PathVariable("id") Long idAtividade,
                                    @RequestBody AtividadeDTO dto) {
        try {
            Atividade pos = Atividade.builder()
                                        .id_atv(idAtividade)
                                        .tipo_atv(dto.getTipo_atv())
                                        .link(dto.getLink())
                                        .titulo(dto.getTitulo())
                                        .build();
            Atividade salvo = service.atualizar(pos);
            return ResponseEntity.ok(salvo);
        }
        catch (RegraPortifolioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (ParseException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity remover(@PathVariable("id") Long idAtividade) {
        try {
            Atividade pos = Atividade.builder().id_atv(idAtividade).build();
            service.remover(pos);
            return ResponseEntity.ok(HttpStatus.NO_CONTENT);
        }
        catch(RegraPortifolioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
