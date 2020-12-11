package com.example.portifolio.model.entidade;


import com.example.Portifolio.model.entidade.*;
import com.example.Portifolio.model.repositorio.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest // Inserindo a anotação @SpringBootTest para importar Junit
@ActiveProfiles("test") // classe será configurada por o perfil H2 no POM.xml e no
                        // application-test.properties
public class CurriculoTest {

	@Autowired // O atributo deve ser anotado com @Autowired
    CurriculoRepositorio repo;


	 @Test
  public void deveVerificarSalvarCurriculo() {
    // cenário
    
    Curriculo curr = Curriculo.builder().escolaridade("Testando123")
                                        .id_curriculo(999199399)
                                        .formacao("Agricultor").build();
    //ação
    Curriculo salvo = repo.save(curr); // salva

    //verificação?
    Assertions.assertNotNull(salvo);
    Assertions.assertEquals(curr.getEscolaridade(), salvo.getEscolaridade());
    Assertions.assertEquals(curr.getId_curriculo(), salvo.getId_curriculo());
    Assertions.assertEquals(curr.getFormacao(), salvo.getFormacao());
  }
}
