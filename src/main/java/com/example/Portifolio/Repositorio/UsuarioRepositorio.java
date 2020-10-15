package com.example.Portifolio.Repositorio;

import java.util.Optional;

import com.example.Portifolio.Entidade.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
        boolean existsByEmail(String email);
        Optional<Usuario> findByEmail(String email);

}