package com.example.Portifolio.Repositorios;

//import java.util.List;
import java.util.Optional;

import com.example.Portifolio.Entidade.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;


public interface UsuarioRepository extends JpaRepository<usuario, Long>{
        boolean existsByEmail(String email);
        Optional<usuario> findByEmail(String email);

       /*
       Pegar todas as posições juntar com investimento, onde os investimentodos dos usuarios tenham
       sido selecionados;
       */
       // Query explicita usando JPQL: Java Persistence Query Language

       // Aprender a implementar isso
       /*
        @Query("select new com.labprog.patrimonio.model.dto.InvestimentoSaldo(i, sum(p.valor)) " +  // retorna um new investimento 
                "from Posicao p join p.investimento i "+ // P é a posição pra investimento
                "where i.usuario = :usuario " + // soma todas as posições
                "group by i") // faz um agrupamento por investimento
        List<InvestimentoSaldo> obterSaldosInvestimentos(
                                        @Param("usuario") Usuario usuario); // Usuario é o parametro para filtragem
       */
}