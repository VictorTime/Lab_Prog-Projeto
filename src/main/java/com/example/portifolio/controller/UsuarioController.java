package com.example.Portifolio.controller;

import com.example.Portifolio.model.dto.UsuarioDTO;
import com.example.Portifolio.model.entidade.Usuario;
import com.example.Portifolio.model.repositorio.UsuarioRepositorio;

import java.util.List;

import javax.validation.Valid;

import com.example.Portifolio.Service.UsuarioService;
import com.example.Portifolio.Service.exceptions.RegraPortifolioRunTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService service;

    @Autowired
    UsuarioRepositorio repository;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    
    @PostMapping(value = "/salvar",
    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity salvar( @RequestBody UsuarioDTO dto) {
        
        Usuario usuario = Usuario.builder()
                                    .matricula(dto.getMatricula())
                                    .nome(dto.getNome())
                                    .email(dto.getEmail())
                                    .tipo(dto.getTipo())
                                    .senha(dto.getSenha()).build();
        try {
            Usuario salvo = service.salvar(usuario);
            return new ResponseEntity(salvo, HttpStatus.CREATED);
        }
        catch (RegraPortifolioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping(value = "/autenticar",
    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity autenticar(@RequestBody UsuarioDTO dto) {
        
        try {
            Usuario autenticado = service.efetuarLogin(dto.getEmail(), dto.getSenha());
            return new ResponseEntity(autenticado, HttpStatus.OK);
            
        } catch(RegraPortifolioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/allusuarios")
    public List <Usuario> obterUsuarios() {
   
        return this.repository.findAll();
    }
    
}
