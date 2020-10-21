package com.example.portifolio.Repositorio;

import java.util.Optional;

import com.example.portifolio.Entidade.Curriculo;

import org.springframework.data.jpa.repository.JpaRepository;



public interface CurriculoRepositorio extends JpaRepository<Curriculo, Long> {
        boolean existsByEmail(String email);
        Optional<Curriculo> findByEmail(String email);

}