package lab.portifolio.repositorioTeste;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lab.portifolio.model.Usuario;
import lab.portifolio.repositorio.UsuarioRepositorio;

@ExtendWith(SpringExtension.class) // precisa do contexto
@SpringBootTest
public class UsuarioTest {
    @Autowired // O atributo deve ser anotado com @Autowired
    UsuarioRepositorio repository;

    @Test
    public void deveVerificarSalvarUsuario() {
        // cenário

        Usuario user = Usuario.builder().nome("Teste")
                                          .matricula(999999999)
                                          .id_curriculo(0001234)
                                          .nome("C3PO")
                                          .email("teste@teste.com")
                                          .senha("123").build();
      //ação
      Usuario salvo = repository.save(user); // salva

      //verificação?
      Assertions.assertNotNull(salvo);
      Assertions.assertEquals(user.getMatricula(), salvo.getMatricula());
      Assertions.assertEquals(user.getId_curriculo(), salvo.getId_curriculo());
      Assertions.assertEquals(user.getNome(), salvo.getNome());
      Assertions.assertEquals(user.getEmail(), salvo.getEmail());
      Assertions.assertEquals(user.getSenha(), salvo.getSenha());
    }
}
