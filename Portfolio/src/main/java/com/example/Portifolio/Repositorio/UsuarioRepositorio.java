package com.example.Portifolio.Repositorio;

import com.example.Portifolio.Entidade.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface usuarioRepositorio extends JpaRepository<Usuario, Long>{
}