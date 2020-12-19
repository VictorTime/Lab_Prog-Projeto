package com.example.Portifolio.controller;

import com.example.Portifolio.model.dto.UsuarioDTO;
import com.example.Portifolio.model.entidade.Usuario;
import com.example.Portifolio.model.repositorio.UsuarioRepositorio;

import java.util.List;
import com.example.Portifolio.Service.UsuarioService;
import com.example.Portifolio.Service.exceptions.RegraPortifolioRunTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

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

    /*
    UsuarioController():  Construtor da classe, apenas inicializa o service do Usuario 
    Param1 <UsuarioService>   :  serviço do usuario usado para inicialização 
    Retorno <> : sem retorno
    */
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    
    /*
    salvar()              : Responsavel por Salvar controlar o arquivamento dos objetos usuários
    Param1 <UsuarioDTO>   : Parametro que representaa abstração dos elementos principais da entidade 
    Retorno <> : Retorna, apos fazer um tratamento de excessão, o estado da requisição HTTP
    */
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

   /*
    autenticar()          : Controlador para trabalhar com as autenticação de usuarios  
    Param1 <UsuarioDTO>   : Parametro que representaa abstração dos elementos principais da entidade 
    Retorno <> : Retorna, apos fazer um tratamento de excessão, o estado da requisição HTTP para a autenticação
    */
    @PostMapping("/autenticar")
    public ResponseEntity autenticar(@RequestBody UsuarioDTO dto) {

        try {
            Usuario autenticado = service.efetuarLogin(dto.getEmail(), dto.getSenha());
            return new ResponseEntity(autenticado, HttpStatus.OK);
            
        } catch(RegraPortifolioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /*
    obterUsuarios() : Lista de todos os usuarios salvos
    Param1 <>   : 
    Retorno <> : Retorna uma lista com todos os usuarios no banco
    */
    @GetMapping("/allusuarios")
    public List <Usuario> obterUsuarios() {
        return this.repository.findAll();
    }
    
}
