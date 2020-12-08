package com.example.Portifolio.model.repositorio;

import java.util.List;
import java.util.Optional;

import com.example.Portifolio.model.entidade.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
        boolean existsByEmail(String email);
        Optional<Usuario> findByEmail(String email);
        Optional<Usuario> findById(Long id);

        @Query("SELECT u FROM Usuario u WHERE u.email = :email ")
                Usuario ObterUsuario(@Param("email") String email); 
        
}
