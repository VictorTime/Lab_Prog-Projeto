package com.example.portifolio.service;

import java.util.Optional;

import javax.transaction.Transactional;

import com.example.portifolio.model.entidade.Usuario;
import com.example.portifolio.model.repositorio.UsuarioRepositorio;
import com.example.portifolio.service.exceptions.RegraPortifolioRunTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class UsuarioService {
    Long test_var = null;

    @Autowired
    UsuarioRepositorio repository;

    public boolean efetuarLogin(String email, String senha) {
        Optional<Usuario> usr = repository.findByEmail(email);
        if (!usr.isPresent())
            throw new RegraPortifolioRunTime("Erro de autenticação. Email informado não encontrado");
        if (!usr.get().getSenha().equals(senha))
            throw new RegraPortifolioRunTime("Erro de autenticação. Senha inválida");

        return true;
    }

    @Transactional
    public Usuario salvar(Usuario usuario) {
        verificarUsuario(usuario);
        return repository.save(usuario);
    }


    private void verficarMatricula(Usuario usuario) {
        if ((usuario == null) || (usuario.getMatricula() == test_var))
            throw new RegraPortifolioRunTime("Usuario inválido");
    }

    private void verificarUsuario(Usuario usuario) {
        if (usuario == null)
            throw new RegraPortifolioRunTime("Um usuário válido deve ser informado");
        if ((usuario.getNome() == null) || (usuario.getNome().equals("")))
            throw new RegraPortifolioRunTime("Nome do usuário deve ser informado");
        if ((usuario.getEmail() == null) || (usuario.getEmail().equals("")))
            throw new RegraPortifolioRunTime("Email deve ser informado");
        boolean teste = repository.existsByEmail(usuario.getEmail());
        verficarMatricula(usuario);
        if (teste)
            throw new RegraPortifolioRunTime("Email informado já existe na base");
        if ((usuario.getSenha() == null) || (usuario.getSenha().equals("")))
            throw new RegraPortifolioRunTime("Usuário deve possui senha");
        
    }
}
