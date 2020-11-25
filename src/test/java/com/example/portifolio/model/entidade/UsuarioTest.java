package com.example.portifolio.model.entidade;

import java.util.Optional;

import com.example.Portifolio.model.repositorio.UsuarioRepositorio;
import com.example.Portifolio.model.entidade.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class) // precisa do contexto
@SpringBootTest // Inserindo a anotação @SpringBootTest para importar Junit
@ActiveProfiles("test") // classe será configurada por o perfil H2 no POM.xml e no
                        // application-test.properties
public class UsuarioTest {
 
  @Autowired // O atributo deve ser anotado com @Autowired
  UsuarioRepositorio repository;

  @Test
  public void deveVerificarSalvarUsuario() {
    // cenário
    
    Usuario user = Usuario.builder().nome("Teste")
                                        .matricula(999999999)
                                        .nome("C3PO")
                                        .email("teste@teste.com")
                                        .senha("123").build();
    //ação
    Usuario salvo = repository.save(user); // salva

    //verificação?
    Assertions.assertNotNull(salvo);
    Assertions.assertEquals(user.getMatricula(), salvo.getMatricula());
    Assertions.assertEquals(user.getNome(), salvo.getNome());
    Assertions.assertEquals(user.getEmail(), salvo.getEmail());
    Assertions.assertEquals(user.getSenha(), salvo.getSenha());
  }

  @Test
  public void deveVerificarRemoverUsuario() {
      //cenário
      Usuario user = Usuario.builder().nome("Teste")
                  .matricula(11)
                  .email("teste@teste.com")
                  .senha("123").build();

      //ação
      Usuario salvo = repository.save(user);  //salva
      Long id = salvo.getMatricula();
      repository.deleteById(id);

      //verificação
      Optional<Usuario> temp = repository.findById(id);        
      Assertions.assertFalse(temp.isPresent());
      repository.delete(salvo);
  }   
  
}
           