package com.example.Portifolio.Repositorio;

import java.util.Optional;

import com.example.Portifolio.Entidade.Atividade;

import org.springframework.data.jpa.repository.JpaRepository;



public interface AtividadeRepositorio extends JpaRepository<Atividade, Long> {
        boolean existsByEmail(String email);
        Optional<Atividade> findByEmail(String email);

}