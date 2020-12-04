package com.example.Portifolio.controller;




import com.example.Portifolio.model.dto.UsuarioDTO;
import com.example.Portifolio.model.entidade.Usuario;
import com.example.Portifolio.Service.UsuarioService;
import com.example.Portifolio.Service.exceptions.RegraPortifolioRunTime;

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
            return new ResponseEntity<>(salvo, HttpStatus.CREATED);
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

     @PutMapping("{id}")
    public ResponseEntity atualizar(@PathVariable("id") Long idUsuario,
                                    @RequestBody UsuarioDTO dto) {
        try {
            Usuario user = Usuario.builder()
                                            .id(idUsuario)
                                            .nome(dto.getNome())
                                            .usuario(Usuario.builder().id(dto.getIdUsuario()).build())
                                            .build();
            Usuario salvo = service.atualizar(inv);
            return ResponseEntity.ok(salvo);
        }
        catch (RegraNegocioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }                                        

    }

    @DeleteMapping("{id}")
    public ResponseEntity remover(@PathVariable("id") Long idUsuario) {
        try {
            Usuario inv = Usuario.builder().id(idUsuario).build();
            service.remover(inv);
            return ResponseEntity.ok(HttpStatus.NO_CONTENT);
        }
        catch(RegraNegocioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/obter")
    public ResponseEntity buscarUsuario(
                        @RequestParam(value="usuario", required=true) Long idUsuario,
                        @RequestParam(value="nome", required=false) String nome){

        Usuario filtro = Usuario.builder()
                                            .nome(nome)
                                            .usuario(Usuario.builder().id(idUsuario).build())
                                            .build();
        List<Usuario> Usuarios = service.buscar(filtro);

        return ResponseEntity.ok(Usuarios);

}
