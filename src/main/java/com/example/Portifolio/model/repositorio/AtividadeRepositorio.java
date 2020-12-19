package com.example.Portifolio.model.repositorio;

import java.util.List;

import com.example.Portifolio.model.entidade.Atividade;
import com.example.Portifolio.model.entidade.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadeRepositorio extends JpaRepository <Atividade, Long> {

	List<Atividade> findByUsuario(Usuario usuario);
   
}
