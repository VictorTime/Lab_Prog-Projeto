package com.example.Portifolio.model.repositorio;

import java.util.List;

import com.example.Portifolio.model.entidade.Curriculo;
import com.example.Portifolio.model.entidade.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculoRepositorio extends JpaRepository <Curriculo, Long> {
    
    List<Curriculo> findByUsuario(Usuario usuario);

}
