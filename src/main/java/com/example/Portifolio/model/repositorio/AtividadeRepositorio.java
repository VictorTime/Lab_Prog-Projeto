package com.example.portifolio.model.repositorio;

import com.example.portifolio.model.entidade.Atividade;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadeRepositorio extends JpaRepository <Atividade, Long> {
    
}
