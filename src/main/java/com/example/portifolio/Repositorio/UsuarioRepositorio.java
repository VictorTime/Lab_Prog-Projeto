package com.example.portifolio.Repositorio;

import java.util.Optional;

//import com.example.Portifolio.Entidade.Usuario;
import com.example.portifolio.Entidade.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
        boolean existsByEmail(String email);
        Optional<Usuario> findByEmail(String email);

        /*
       Pegar todas as posições juntar com investimento, onde os investimentodos dos usuarios tenham
       sido selecionados;
       */
       /*
       // Query explicita usando JPQL: Java Persistence Query Language
        @Query("select new com.example.portifolio.dto.InvestimentoSaldo(i, sum(p.valor)) " +  // retorna um new investimento 
                "from Posicao p join p.investimento i "+ // P é a posição pra investimento
                "where i.usuario = :usuario " + // soma todas as posições
                "group by i") // faz um agrupamento por investimento
        List<InvestimentoSaldo> obterSaldosInvestimentos(
                                        @Param("usuario") Usuario usuario); // Usuario é o parametro para filtragem

        */
}
