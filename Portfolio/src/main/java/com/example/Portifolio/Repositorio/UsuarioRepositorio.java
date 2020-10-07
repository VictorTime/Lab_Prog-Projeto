package com.example.Portifolio.Repositorio;

import com.example.Portifolio.Entidade.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
}