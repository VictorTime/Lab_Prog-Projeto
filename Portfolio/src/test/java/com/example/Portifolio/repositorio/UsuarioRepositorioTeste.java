package com.example.Portifolio.repositorio;

import java.util.Optional;

import com.example.Portifolio.Entidade.Usuario;
import com.example.Portifolio.Repositorio.UsuarioRepositorio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UsuarioRepositorioTeste {

    @Autowired
    UsuarioRepositorio repositorio;

    @Test
    public void deveVerificarSalvarUsuario() {
        // Cenário
        Usuario user = Usuario.builder().nome("jonas").email("jonas@jonin.com").id_curriculo(1).matricula(2016948134)
                .build();
        // Ação
        Usuario salvo = repositorio.save(user);

        // Verificação
        Assertions.assertNotNull(salvo);
        Assertions.assertEquals(user.getNome(), salvo.getNome());
        Assertions.assertEquals(user.getEmail(), salvo.getEmail());
        Assertions.assertEquals(user.getMatricula(), salvo.getMatricula());
        Assertions.assertEquals(user.getId_curriculo(), salvo.getId_curriculo());
    }

    @Test
    public void deveVerificarRemoverUsuario() {
        //cenário
        Usuario user = Usuario.builder().nome("jonas")
                    .email("jonas@jonin.com")
                    .id_curriculo(1).matricula(2016948134).build();
        //ação
        Usuario salvo = repositorio.save(user);  //salva
        Long id = salvo.getMatricula();
        repositorio.deleteById(salvo.getMatricula());
        //verificação
        Optional<Usuario> temp = repositorio.findById(id);
        Assertions.assertFalse(temp.isPresent());
    }
}