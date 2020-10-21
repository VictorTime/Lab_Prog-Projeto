package com.example.portifolio.controllers;

import java.util.List;


import com.example.portifolio.dto.AtividadeDTO;
import com.example.portifolio.Entidade.Atividade;
import com.example.portifolio.Service.AtividadeService;
import com.example.portifolio.Service.exceptions.RegraPortifolioRunTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        try {
            Atividade ativ = Atividade.builder()
                                    .tipo(dto.getTipo())
                                    .docente_relac(dto.getDocente_relac()).build();

            Atividade salvo = service.salvar(ativ);
            return new ResponseEntity(salvo, HttpStatus.CREATED);
        }
        catch (RegraPortifolioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    /*
    @PutMapping("{id}") // Receber um Objeto mas atualizando este
    public ResponseEntity atualizar(@PathVariable("id") Long idAtividade,
                                    @RequestBody AtividadeDTO dto) {
        try {
            Atividade ativ = Atividade.builder()
                                            .id(idAtividade)
                                            .nome(dto.getNome())
                                            .usuario(Usuario.builder().id(dto.getIdUsuario()).build())
                                            .build();
            Atividade salvo = service.atualizar(ativ);
            return ResponseEntity.ok(salvo);
        }
        catch (RegraPortifolioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }                                        

    }
    */

    @DeleteMapping("{id}") // Recebe o id do Atividade, separado do Atividade em si
    public ResponseEntity remover(@PathVariable("id") Long idAtividade) {
        try {
            Atividade ativ = Atividade.builder().id_atv(idAtividade).build();
            service.remover(ativ);
            return ResponseEntity.ok(HttpStatus.NO_CONTENT);
        }
        catch(RegraPortifolioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/obter")
    public ResponseEntity buscarAtividade(
                        @RequestParam(value="tipo", required=true) String tipo,
                        @RequestParam(value="docente", required=false) String docente_relac){

        Atividade filtro = Atividade.builder()
                                                .tipo(tipo)
                                                .docente_relac(docente_relac).build();
        List<Atividade> Atividades = service.buscar(filtro);

        return ResponseEntity.ok(Atividades);
    }

}
