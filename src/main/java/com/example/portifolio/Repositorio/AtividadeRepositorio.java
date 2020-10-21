package com.example.portifolio.Repositorio;

import java.util.Optional;

import com.example.portifolio.Entidade.atividade;

import org.springframework.data.jpa.repository.JpaRepository;



public interface AtividadeRepositorio extends JpaRepository<atividade, Long> {
        boolean existsByEmail(String email);
        Optional<atividade> findByEmail(String email);

}