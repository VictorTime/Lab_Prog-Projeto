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


@ExtendWith(SpringExtension.class)
@SpringBootTest // Inserindo a anotação @SpringBootTest para importar Junit
@ActiveProfiles("test") // classe será configurada por o perfil H2 no POM.xml e no
                        // application-test.properties
public class CurriculoServiceTest {
    @Autowired
    CurriculoRepositorio rep;

    @Autowired
    CurriculoService service;

    
    @Test
    public void deveRetornarTodosCurriculos() throws ParseException {

        Curriculo curriculo1 = Curriculo.builder().id_curriculo(123566)
                                                  .escolaridade("Superior")
                                                  .formacao("Direito").build();
                                                  

        Curriculo curriculo2 = Curriculo.builder().id_curriculo(993566)
                                                  .escolaridade("Superior-Incompleto")
                                                  .formacao("Letras").build();

        Curriculo salvo1 = rep.save(curriculo1);
        Curriculo salvo2 = rep.save(curriculo2);

        // ação
        List<Curriculo> curriculosEncontrados = service.obterCurriculos();

        Assertions.assertEquals(curriculosEncontrados.size(), 2);

        rep.delete(salvo1);
        rep.delete(salvo2);
    }
}