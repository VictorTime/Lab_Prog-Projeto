package com.example.portifolio.Service;

import java.text.ParseException;
import java.util.List;

import com.example.Portifolio.Service.*;
import com.example.Portifolio.model.entidade.*;
import com.example.Portifolio.model.repositorio.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.test.context.ActiveProfiles;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest // Inserindo a anotação @SpringBootTest para importar Junit
@ActiveProfiles("test") // classe será configurada por o perfil H2 no POM.xml e no
                        // application-test.properties
public class UsuarioServiceTest {
    @Autowired
    UsuarioRepositorio rep;

    @Autowired
    UsuarioService service;

    @Test
    public void deveRetornarTodosUsuarios() throws ParseException {

        Usuario usuario1 = Usuario.builder().matricula(Long.valueOf(123566))
                                                  .nome("Augusto")
                                                  .email("abc@gmail.com")
                                                  .senha("abc123").build();


        Usuario usuario2 = Usuario.builder().matricula(123567)
                                                  .nome("Pedro")
                                                  .email("ab3@gmail.com")
                                                  .senha("123abc").build();

        Usuario salvo1 = rep.save(usuario1);
        Usuario salvo2 = rep.save(usuario2);

        // ação
        List<Usuario> usuariosEncontrados = service.obterUsuarios();

        Assertions.assertEquals(usuariosEncontrados.size(), 2);

        rep.delete(salvo1);
        rep.delete(salvo2);
    }

    @Test
    public void deveRetornarUsuario() throws ParseException {

        Usuario usuario1 = Usuario.builder().matricula(123566)
                                           .nome("Teodor")
                                           .email("abc@gmail.com")
                                           .senha("abcdef").build();

        Usuario salvo1 = rep.save(usuario1);

        // ação
        Optional<Usuario> encontrado1 = service.obterUsuario_m(Long.valueOf(123));
        Optional<Usuario> encontrado2 = service.obterUsuario("abc@gmail.com");

        Assertions.assertEquals(encontrado1, encontrado2);

        rep.delete(salvo1);
    }
}
