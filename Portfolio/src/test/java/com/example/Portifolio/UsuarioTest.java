package com.example.Portifolio;

import com.example.Portifolio.Entidade.usuario;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UsuarioTest {
  @Autowired
  usuario user;
  @Test
  public void deveVerificarSalvarUsuario() {
    //cenário ?
    //ação?
    //verificação?
  }
}
