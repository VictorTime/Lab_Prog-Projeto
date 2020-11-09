package com.example.portifolio.controller;




import com.example.portifolio.model.dto.UsuarioDTO;
import com.example.portifolio.model.entidade.Usuario;
import com.example.portifolio.service.UsuarioService;
import com.example.portifolio.service.exceptions.RegraPortifolioRunTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody UsuarioDTO dto) {
        Usuario usuario = Usuario.builder()
                                    .nome(dto.getNome())
                                    .email(dto.getEmail())
                                    .senha(dto.getSenha()).build();
        try {
            Usuario salvo = service.salvar(usuario);
            return new ResponseEntity(salvo, HttpStatus.CREATED);
        }
        catch (RegraPortifolioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/autenticar")
    public ResponseEntity autenticar(@RequestBody UsuarioDTO dto) {

        try {
            service.efetuarLogin(dto.getEmail(), dto.getSenha());
            return ResponseEntity.ok(true);
            
        } catch(RegraPortifolioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
