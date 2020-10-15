package Portifolio.serviceTeste;

import com.example.Portifolio.Entidade.Usuario;
import com.example.Portifolio.Repositorio.UsuarioRepositorio;
import com.example.Portifolio.Service.UsuarioService;
import com.example.Portifolio.Service.exceptions.RegraNegocioRunTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles()
public class UsuarioServiceTeste {

    @Autowired
    UsuarioService service;

    @Autowired
    UsuarioRepositorio repository;


    @Test
    public void deveSalvarUsuario() {
        Usuario usuario = Usuario.builder()
            .nome("Teste")
            .email("123@teste.com")
            .senha("123").build();

        Usuario salvo = service.salvar(usuario);

        Assertions.assertNotNull(salvo);
        Assertions.assertNotNull(salvo.getMatricula());

        repository.delete(salvo);
    }

    @Test
    public void deveGerarErroAoTentarSalvarSemNome() {
        Usuario usr = Usuario.builder()
                                    .email("teste")
                                    .senha("123")
                                    .build();
        Assertions.assertThrows(RegraNegocioRunTime.class, 
                                                      () -> service.salvar(usr), "Nome do usuário deve ser informado");
    }

    @Test
    public void deveGerarErroAoTentarSalvarSemSenha() {
        Usuario usr = Usuario.builder()
                                    .nome("teste")
                                    .email("teste")
                                    .build();
        Assertions.assertThrows(RegraNegocioRunTime.class, 
                                                      () -> service.salvar(usr), "Usuário deve possui senha");
    }

    @Test
    public void deveGerarErroAoTentarSalvarSemEmail() {
        Usuario usr = Usuario.builder()
                                    .nome("teste")
                                    .senha("teste")
                                    .build();
        Assertions.assertThrows(RegraNegocioRunTime.class, 
                                                      () -> service.salvar(usr), "Email deve ser informado");
    }

    @Test()
    public void deveGerarErroSalvarUsuarioComMesmoEmail() {
        Usuario usuario = Usuario.builder().nome("Teste")
                                        .email("123@teste.com")
                                        .senha("123").build();

        Usuario salvo = service.salvar(usuario);
        Assertions.assertThrows(RegraNegocioRunTime.class, 
                                                      () -> service.salvar(usuario)); 
        repository.delete(salvo);
    } 

    @Test
    public void deveAutenticarUsuario() {

        Usuario usuario = Usuario.builder().nome("Teste")
                                        .email("123@teste.com")
                                        .senha("123").build();
        Usuario salvo = repository.save(usuario);
        boolean resposta = service.efetuarLogin("123@teste.com", "123");
        Assertions.assertTrue(resposta); 
                repository.delete(salvo);
    }

    @Test
    public void deveGerarErroEmailaoTentarAutenticarUsuario() { 

        Assertions.assertThrows(RegraNegocioRunTime.class,
                                                      () -> service.efetuarLogin("não existe", "123")
                                                      ,"Erro de autenticação. Email informado não encontrado");
    }

    @Test
    public void deveGerarErroSenhalaoTentarAutenticarUsuario() {

        Usuario usuario = Usuario.builder().nome("Teste")
                                        .email("123@teste.com")
                                        .senha("123").build();
        Usuario salvo = repository.save(usuario);
        Assertions.assertThrows(RegraNegocioRunTime.class, 
                                                      () -> service.efetuarLogin("123@teste.com", "aaa")
                                                      ,"Erro de autenticação. Senha inválida");   
        repository.delete(salvo);
    }    
}


