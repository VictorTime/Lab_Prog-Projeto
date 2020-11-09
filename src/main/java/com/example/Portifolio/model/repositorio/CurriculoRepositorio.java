package com.example.portifolio.model.repositorio;

import com.example.portifolio.model.entidade.Curriculo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculoRepositorio extends JpaRepository <Curriculo, Long> {
    
}
