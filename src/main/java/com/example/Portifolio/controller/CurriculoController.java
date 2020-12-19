package com.example.Portifolio.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import com.example.Portifolio.Service.CurriculoService;
import com.example.Portifolio.Service.exceptions.RegraPortifolioRunTime;
import com.example.Portifolio.model.dto.CurriculoDTO;
import com.example.Portifolio.model.dto.UsuarioDTO;
import com.example.Portifolio.model.entidade.Curriculo;
import com.example.Portifolio.model.entidade.Usuario;
import com.example.Portifolio.model.repositorio.CurriculoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    /*
    salvar()              : Responsavel por Salvar controlar o arquivamento dos objetos curriculo
    Param1 <CurriculoDTO> : Parametro que representaa abstração dos elementos principais da entidade 
    Retorno <> : Retorna, apos fazer um tratamento de excessão, o estado da requisição HTTP
    */
    @PostMapping(value = "/salvar",
    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
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


    @PutMapping("/atualizar")
    public ResponseEntity atualizar(@RequestParam(value="id", required=true) Long idCurriculo,
                                    @RequestBody CurriculoDTO dto) throws ParseException {
        try {
            Curriculo curriculo = Curriculo.builder().id_curriculo(dto.getId_curriculo())
                    .escolaridade(dto.getEscolaridade()).formacao(dto.getFormacao())
                    .usuario(Usuario.builder().matricula(dto.getMatricula()).build()).build();

            Curriculo salvo = service.atualizar(curriculo);
            return ResponseEntity.ok(salvo);
        } catch (RegraPortifolioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    /*
    obter()               : Responsavel por Salvar controlar o arquivamento dos objetos curriculo
    Retorno <> : Retorna o estado de "ok" da entidade curriculo
    */
    @PostMapping("/obter")
    public ResponseEntity buscarCurriculo(
                        @RequestBody UsuarioDTO dto){

        Curriculo filtro = Curriculo.builder()
                                            .usuario(Usuario.builder().matricula(dto.getMatricula()).build())
                                            .build();
        
        try {
            List<Curriculo> curriculos = service.buscar(filtro);
            return ResponseEntity.ok(curriculos);
        } catch (RegraPortifolioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    
}

