package com.example.Portifolio.Service;

import java.util.Optional;
import com.example.Portifolio.Service.Exceptions.RegraNegocioRunTime;
import com.example.Portifolio.Entidade.usuario;
import com.example.Portifolio.Repositorio.usuarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class UsuarioService {
    @Autowired
    usuarioRepositorio repository;

    public boolean efetuarLogin(String email, Long matricula) throws RegraNegocioRunTime {
        Optional<usuario> usr = repository.findById(matricula);
        if (!usr.isPresent())
            throw new RegraNegocioRunTime("Erro de autenticação. Email informado não encontrado");    
        if (!(usr.get().getMatricula()==matricula))
            throw new RegraNegocioRunTime("Erro de autenticação. matricula inválida");
        return true;
    }
    @Transactional
    public usuario salvar(usuario usuario) throws RegraNegocioRunTime {
        verificarUsuario(usuario);
        return repository.save(usuario);
    }


    private void verificarUsuario(usuario usuario) throws RegraNegocioRunTime {
        if (usuario == null)
            throw new RegraNegocioRunTime("Um usuário válido deve ser informado");
        if ((usuario.getNome() == null) || (usuario.getNome().equals("")))
            throw new RegraNegocioRunTime("Nome do usuário deve ser informado");
        if ((usuario.getEmail() == null) || (usuario.getEmail().equals("")))
            throw new RegraNegocioRunTime("Email deve ser informado");
        boolean teste = repository.existsByEmail(usuario.getEmail());
        if (teste)
            throw new RegraNegocioRunTime("Email informado já existe na base");
        //if ((usuario.getSenha() == null) || (usuario.getSenha().equals("")))
            //throw new RegraNegocioRunTime("Usuário deve possui senha");
    }
}