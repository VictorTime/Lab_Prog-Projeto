package com.example.portifolio.Service;

import java.text.ParseException;
import java.util.List;

/*
Importação das classes de Serviço e os modelos de entidade e repositorio
*/
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
public class AtividadeServiceTest {
    @Autowired
    AtividadeRepositorio rep;

    @Autowired
    AtividadeService service;

    @Test
    /*
    deveRetornarTodosAtividades(): Faz um teste se a requisição de todas as atividades salvas esta funcionando
    Param1 <Atividade> : Parametros para criar o objeto atv que contem informações das atividades de teste
    Retorno <> : A função não tem retorno, apenas um teste interno de comparação de tamanho do tamanho da lista de atividades encontrados
                 com o tamanho da lista de atividades realmente criados 
    */
    public void deveRetornarTodosAtividades() throws ParseException {

        Atividade atv1 = Atividade.builder().id_atv(33333)
                                                  .titulo("Sobre os poblemas...")
                                                  .tipo_atv("optativa")
                                                  .resumo("questão 1: optativa")
                                                  .link("33333").build();


       Atividade atv2 = Atividade.builder().id_atv(33334)
                                                  .titulo("Sobre todos os poblemas...")
                                                  .tipo_atv("dissertativa")
                                                  .resumo("questão 2: dissertativa")
                                                  .link("33334").build();

        Atividade salvo1 = rep.save(atv1);
        Atividade salvo2 = rep.save(atv2);

        // ação
        List<Atividade> atvEncontradas = service.obterAtividades();

        Assertions.assertEquals(atvEncontradas.size(), 2);

        rep.delete(salvo1);
        rep.delete(salvo2);
    }

}
