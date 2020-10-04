package com.example.Portifolio.Repositorio;

import com.example.Portifolio.Entidade.usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<usuario, Long>{  
}