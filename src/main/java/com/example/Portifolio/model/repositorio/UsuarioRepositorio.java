package com.example.Portifolio.model.repositorio;

import java.util.List;
import java.util.Optional;

import com.example.Portifolio.model.entidade.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
        boolean existsByEmail(String email);
        Optional<Usuario> findByEmail(String email);

        @Query("SELECT u FROM Usuario u WHERE u.tipo = 1")
        List<Usuario> todosOsProfessores();
}
