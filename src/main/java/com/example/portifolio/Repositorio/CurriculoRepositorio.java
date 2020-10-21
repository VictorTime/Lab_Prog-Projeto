package com.example.portifolio.Repositorio;

import java.util.Optional;

import com.example.portifolio.Entidade.curriculo;

import org.springframework.data.jpa.repository.JpaRepository;



public interface CurriculoRepositorio extends JpaRepository<curriculo, Long> {
        boolean existsByEmail(String email);
        Optional<curriculo> findByEmail(String email);

}