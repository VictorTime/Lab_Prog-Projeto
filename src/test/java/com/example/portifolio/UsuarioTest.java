package com.example.Portifolio;

import com.example.Portifolio.Entidade.usuario;
import com.example.Portifolio.Repositorios.UsuarioRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class) // precisa do contexto
@SpringBootTest  //Inserindo a anotação @SpringBootTest para importar Junit
@ActiveProfiles("test") // classe será configurada por o perfil H2 no POM.xml e no application-test.properties
public class UsuarioTest {
  @Autowired // O atributo deve ser anotado com @Autowired
  UsuarioRepository repository;


  @Test
  public void deveVerificarSalvarUsuario() {
    //cenário
    usuario user = usuario.builder().nome("Teste")
                                        .matricula(999999999)
                                        .id_curriculo(0001234)
                                        .nome("C3PO")
                                        .email("teste@teste.com")
                                        .senha("123").build();
    //ação
    usuario salvo = repository.save(user);  //salva

    //verificação?
    Assertions.assertNotNull(salvo);
    Assertions.assertEquals(user.getMatricula(), salvo.getMatricula());
    Assertions.assertEquals(user.getId_curriculo(), salvo.getId_curriculo());
    Assertions.assertEquals(user.getNome(), salvo.getNome());
    Assertions.assertEquals(user.getEmail(), salvo.getEmail());
    Assertions.assertEquals(user.getSenha(), salvo.getSenha());
  }
}
/*
Lembrar:
Deseja-se criar um usuário qualquer --> cenário

Inserir --> ação

Checar se está no banco --> verificação

Instalar o Java Test Report para auxiliar
*/
 @Test
    public void deveVerificarRemoverUsuario() {
        //cenário
        Usuario user = Usuario.builder().nome("Teste")
                    .email("teste1@teste.com")
                    .senha("123").build();
        //ação
        Usuario salvo = repository.save(user);  //salva
        Long id = salvo.getId();
        repository.deleteById(salvo.getId());

        //verificação
        Optional<Usuario> temp = repository.findById(id);        
        Assertions.assertFalse(temp.isPresent());
        repository.delete(salvo);
    }   

    @Test
    public void deveVerificarSaldoInvestimentos() {
        //cenário
        Usuario user = Usuario.builder().nome("Teste")
                .email("teste@teste.com")
                .senha("123").build();
        Usuario salvo = repository.save(user);
        
        Investimento inv1 = Investimento.builder().nome("Primeiro").usuario(salvo).build();

        Investimento inv1Salvo = investimentoRep.save(inv1);
        
        Posicao p1 = Posicao.builder().valor(500.0).data(new Date()).investimento(inv1Salvo).build();
        Posicao p2 = Posicao.builder().valor(500.0).data(new Date()).investimento(inv1Salvo).build();

        Posicao p1salvo = posicaoRep.save(p1);
        Posicao p2salvo = posicaoRep.save(p2);

        //ação
        List<InvestimentoSaldo> res = repository.obterSaldosInvestimentos(salvo);

        //verificação
        Assertions.assertNotNull(res);
        Assertions.assertEquals(1000.0,res.get(0).valor);

        posicaoRep.delete(p1salvo);
        posicaoRep.delete(p2salvo);

        investimentoRep.delete(inv1Salvo);

        repository.delete(salvo);
        
    }
    