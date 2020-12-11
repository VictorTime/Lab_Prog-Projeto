package com.example.Portifolio.Service;

import java.util.Optional;
import com.example.Portifolio.model.repositorio.UsuarioRepositorio;
import com.example.Portifolio.model.entidade.Usuario;
import com.example.Portifolio.Service.exceptions.RegraPortifolioRunTime;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    UsuarioRepositorio repository;

   
    public List<Usuario> obterUsuarios() {
        return repository.findAll();
    }

    public Optional<Usuario> obterUsuario(String email) {
        Optional<Usuario> usuario;
        usuario = repository.findByEmail(email);
    
        return usuario;
    }

    public Optional<Usuario> obterUsuario_m(Long matricula) {
        Optional<Usuario> usuario;
        usuario = repository.findById(matricula);
    
        return usuario;
    }

    public Usuario efetuarLogin(String email, String senha) {
        Optional<Usuario> usr = repository.findByEmail(email);
        if (!usr.isPresent())
            throw new RegraPortifolioRunTime("Erro de autenticação. Email informado não encontrado");
        if (!usr.get().getSenha().equals(senha))
            throw new RegraPortifolioRunTime("Erro de autenticação. Senha inválida");
        Usuario user = repository.ObterUsuario(email);
        return user;
    }

    @Transactional
    public Usuario salvar(Usuario usuario) {
        verificarUsuario(usuario);
        return repository.save(usuario);
    }


    private void verficarMatricula(Usuario usuario) {
        if ((usuario == null) || (usuario.getMatricula() == 0))
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
