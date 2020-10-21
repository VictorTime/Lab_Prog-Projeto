package com.example.portfolio.controller;

import java.util.List;

import com.example.portfolio.model.dto.InvestimentoSaldo;
import com.example.portfolio.model.dto.UsuarioDTO;
import com.example.portfolio.model.entidades.Usuario;
import com.example.portfolio.service.UsuarioService;
import com.example.portfolio.service.exceptions.RegraPortifolioRunTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Controler é só um endpoint para comunicação

// @Controller -> Da o contexto do Springbot para ser possivel a contrução de aplicações web em cima do contexto
@RestController // Uma controller limitada em que todos os tramites vão ocorrer em JSON (força a entrada e saida em JSON)
@RequestMapping("/api/usuarios") // Interessante por os metodos em comum em um só contextode endereçamento, Request mapping cria um endpoint
public class UsuarioController {  // Endereço raiz = "/api/usuarios"
    @Autowired
    UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // Quando alguem enviar uma mensagem do tipo POST pela url  "/api/usuarios" irá chamar esta função
    @PostMapping
    public ResponseEntity salvar(@RequestBody UsuarioDTO dto) { // @RequestBody =  Transforma o body da mensagme no UsuarioDTO
                                                                // EX: Quando enviar um arquivo JSON com email,usuario e senha, este será convertido para UsuarioDTO
        Usuario usuario = Usuario.builder()
                                    .nome(dto.getNome())
                                    .email(dto.getEmail())
                                    .senha(dto.getSenha())
                                    .matricula(dto.getMatricula())
                                    .id_curriculo(dto.getid_curriculo()).build();
        try {
            Usuario salvo = service.salvar(usuario); // Se deu tudo certo  retorna um nio new ResponseEntity
            return new ResponseEntity(salvo, HttpStatus.CREATED); //
        }
        catch (RegraPortifolioRunTime e) { // Se caiu em uma excessão, não precisa saber qual é 
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

    //@GetMapping
    
}
