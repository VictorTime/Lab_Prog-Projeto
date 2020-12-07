package com.example.Portifolio.controller;

import java.util.List;

import com.example.Portifolio.Service.CurriculoService;
import com.example.Portifolio.Service.exceptions.RegraPortifolioRunTime;
import com.example.Portifolio.model.dto.CurriculoDTO;
import com.example.Portifolio.model.entidade.Curriculo;
import com.example.Portifolio.model.entidade.Usuario;
import com.example.Portifolio.model.repositorio.CurriculoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/curriculo")
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

    @GetMapping("/obter")
    public ResponseEntity buscarCurriculo(
                        @RequestParam(value="matricula", required=true) Long Matricula){

        Curriculo filtro = Curriculo.builder()
                                            .usuario(Usuario.builder().matricula(Matricula).build())
                                            .build();
        List<Curriculo> curriculos = service.buscar(filtro);

        return ResponseEntity.ok(curriculos);
    }   
}

