package Portifolio.repositorioTeste;

import com.example.Portifolio.Entidade.Curriculo;
import com.example.Portifolio.Repositorio.CurriculoRepositorio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class) // precisa do contexto
@Configuration
public class CurriculoTest {
    @Autowired // O atributo deve ser anotado com @Autowired
    CurriculoRepositorio repository;

    @Test
    public void deveVerificarSalvarCurriculo() {
        // cenário

        Curriculo user = Curriculo.builder().id_curriculo(0001234)
                                          .escolaridade("Ensino Superior")
                                          .formacao("Mestre Jedi")
                                          .id_atvs(123456).build();
      //ação
      Curriculo salvo = repository.save(user); // salva

      //verificação?
      Assertions.assertNotNull(salvo);
      Assertions.assertEquals(user.getId_curriculo(), salvo.getId_curriculo());
      Assertions.assertEquals(user.getEscolaridade(), salvo.getEscolaridade());
      Assertions.assertEquals(user.getFormacao(), salvo.getFormacao());
      Assertions.assertEquals(user.getId_atvs(), salvo.getId_atvs());
    }


}

