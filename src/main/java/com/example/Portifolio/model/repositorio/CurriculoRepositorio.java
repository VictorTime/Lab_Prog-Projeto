package com.example.Portifolio.model.repositorio;

import java.util.Optional;

import com.example.Portifolio.model.entidade.Curriculo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculoRepositorio extends JpaRepository <Curriculo, Long> {
   
}
