package com.example.Portifolio.model.repositorio;

import com.example.Portifolio.model.entidade.Atividade;
import com.example.Portifolio.model.entidade.CurriculoAtividade;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculoAtividadeRepositorio extends JpaRepository<CurriculoAtividade, Long> {
    
}
