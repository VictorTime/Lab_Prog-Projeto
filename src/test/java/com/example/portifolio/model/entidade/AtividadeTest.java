package com.example.portifolio.model.entidade;

import com.example.Portifolio.model.entidade.*;
import com.example.Portifolio.model.repositorio.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest 
// Inserindo a anotação @SpringBootTest para importar Junit
@ActiveProfiles("test") // classe será configurada por o perfil H2 no POM.xml e no
                        // application-test.properties
public class AtividadeTest {

	@Autowired // O atributo deve ser anotado com @Autowired
    AtividadeRepositorio repo;


	@Test
    /*
    deveVerificarSalvarAtividade(): Faz um teste se os parametros da requisição da atividade estão corretos  
    Param1 <Atividade> : Parametros para criar o objeto atv que contem informações das atividades de teste
    Retorno <> : A função não tem retorno, apenas testes internos de comparação da atividade salva no repositorio com os parametros da atividade
                 criada originalmente
    */
    
  public void deveVerificarSalvarAtividade() {
    Atividade ativ = Atividade.builder().titulo("Testando123")
                                        .id_atv(Long.valueOf(123566))
                                        .tipo_atv("R2D2")
                                        .resumo("coisas absurdas acontecem").build();
    //ação
    Atividade salvo = repo.save(ativ); // salva

  
    Assertions.assertNotNull(salvo);
    Assertions.assertEquals(ativ.getTitulo(), salvo.getTitulo());
    Assertions.assertEquals(ativ.getTipo_atv(), salvo.getTipo_atv());
    Assertions.assertEquals(ativ.getId_atv(), salvo.getId_atv());
    Assertions.assertEquals(ativ.getResumo(), salvo.getResumo());
  }
}
