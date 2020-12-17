package com.example.Portifolio.controller;

import java.util.List;

import com.example.Portifolio.Service.AtividadeService;
import com.example.Portifolio.Service.exceptions.RegraPortifolioRunTime;
import com.example.Portifolio.model.dto.AtividadeDTO;
import com.example.Portifolio.model.dto.UsuarioDTO;
import com.example.Portifolio.model.entidade.Atividade;
import com.example.Portifolio.model.entidade.Curriculo;
import com.example.Portifolio.model.entidade.CurriculoAtividade;
import com.example.Portifolio.model.entidade.Usuario;
import com.example.Portifolio.model.repositorio.AtividadeRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
    @Autowired
	AtividadeRepositorio repository;

    /*
    salvar()              : Responsavel por Salvar controlar o arquivamento dos objetos atividade
    Param1 <AtividadeDTO> : Parametro que representaa abstração dos elementos principais da entidade 
    Retorno <> : Retorna, apos fazer um tratamento de excessão, o estado da requisição HTTP
    */
    @PostMapping(value = "/salvar",
    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity salvar(@RequestBody AtividadeDTO dto) {
        
        Atividade atividade = Atividade.builder()
                                    .id_atv(dto.getId_atv())
                                    .titulo(dto.getTitulo())
                                    .tipo_atv(dto.getTipo_atv())
                                    .resumo(dto.getResumo())
                                    .link(dto.getLink())
                                    .usuario(Usuario.builder().matricula(dto.getMatricula()).build())
                                    .build();

        CurriculoAtividade relacao = CurriculoAtividade.builder()
                                    .curriculo(Curriculo.builder().id_curriculo(dto.getId_curriculo()).build())
                                    .atividade(Atividade.builder().id_atv(dto.getId_curriculo()).build())
                                    .build();
        
        try {
            Atividade salvo = service.salvar(atividade, relacao);
            return new ResponseEntity(salvo, HttpStatus.CREATED);
        }
        catch (RegraPortifolioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /*
    atualizar()              : Responsavel por atualizar e controlar o arquivamento dos objetos atividade
    Param1 <AtividadeDTO> : Parametro que representaa abstração dos elementos principais da entidade 
    Retorno <> : Retorna, apos fazer um tratamento de excessão, o estado da requisição HTTP
    */
    @PutMapping("{id}")
    public ResponseEntity atualizar(@PathVariable("id") Long idAtividade,
                                    @RequestBody AtividadeDTO dto) {
        try {
            Atividade pos = Atividade.builder()
                                            .titulo(dto.getTitulo())
                                            .tipo_atv(dto.getTipo_atv())
                                            .resumo(dto.getResumo())
                                            .link(dto.getLink())
                                            .usuario(Usuario.builder().matricula(dto.getMatricula()).build())
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
    
     /*
    remover()             : Responsavel pela remoção   dos objetos atividade
    Param1 <idAtividade>  : Codigo unico da atividade 
    Retorno <> : Retorna, apos fazer um tratamento de excessão, o estado da requisição HTTP
    */
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

    /*
    validar()             : Responsavel pela validação dos objetos atividade
    Param1 <AtividadeDTO> : Parametro que representaa abstração dos elementos principais da entidade 
    Retorno <> : Retorna, apos fazer um tratamento de excessão, o estado da requisição HTTP
    */
    @PostMapping("/validar")
    public ResponseEntity validar(@PathVariable("matricula") Long matricula,
                                @RequestBody AtividadeDTO dto) {
        
    
        Atividade filtro = Atividade.builder()
                                    .tipo_atv(dto.getTipo_atv())
                                    .usuario(Usuario.builder().matricula(dto.getMatricula()).build())
                                    .build();
        try {
            service.validar(matricula, filtro);
            return new ResponseEntity(HttpStatus.OK);
            
        } catch(RegraPortifolioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/allatvs")
    public List <Atividade> obterAtividades() {
        return this.repository.findAll();
    }
}
