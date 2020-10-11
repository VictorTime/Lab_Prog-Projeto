package com.example.Portifolio.service;


//import java.util.List;
import java.util.Optional;

import com.example.Portifolio.Entidade.usuario;
import com.example.Portifolio.Repositorios.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// toda camada tem uma chamada para informar qual a funcionalidade dela, neste caso é o Service
@Service // diz ao springboot que é uma camada com funcionalidades, por isso necessita do contexto do spring
public class UsuarioService {
    
    @Autowired // Implementa uma instancia do Usuariorepository
    // UsuarioRepository é uma interface enão ha nenhuma implementação dela  
    UsuarioRepository repository; // Para ter acesso aos dados  do usuario

   // Para cada função ha necessidade de validação

    public boolean efetuarLogin(String email, String senha) {
        Optional<usuario> user = repository.findByEmail(email); // findbyemail ainda n esta implementado
                                                               //  Optional<Usuario> = Existe ou n um usuario nela
        // Adicionar em UsuarioRepository a função findByEmail (repositorio/UsuarioRepository)
        /*
        if (!usr.isPresent())
            throw new RegraNegocioRunTime("Erro de autenticação. Email informado não encontrado");    
        if (!usr.get().getSenha().equals(senha))
            throw new RegraNegocioRunTime("Erro de autenticação. Senha inválida");    
        */
        return true;
    }

    @Transactional // Todos os inserts sejam capsulados em um BD, se esta transação foi corretamente executada doinicio ao fim, ela 
                   // é comitada no BD
    public usuario salvar(usuario user) {
        verificarUsuario(user);
        return repository.save(user);
    }
/*
    public List<InvestimentoSaldo> obterSaldos(Usuario usuario) {
        verficarId(usuario);
        return repository.obterSaldosInvestimentos(usuario);
    }

    public List<InvestimentoSaldo> obterSaldos(Long idUsuario) {
        Optional<Usuario> usuario = repository.findById(idUsuario);
        if (usuario.isPresent())
            return repository.obterSaldosInvestimentos(usuario.get());
        throw new RegraNegocioRunTime("Usuario inválido");
    }


    private void verficarId(Usuario usuario) {
        if ((usuario == null) || (usuario.getId() == null))
            throw new RegraNegocioRunTime("Usuario inválido");
    }
*/
    private void verificarUsuario(usuario usuario) {
        /*
        if (usuario == null)
            throw new RegraNegocioRunTime("Um usuário válido deve ser informado");    
            
        if ((usuario.getNome() == null) || (usuario.getNome().equals("")))
            throw new RegraNegocioRunTime("Nome do usuário deve ser informado");    

        if ((usuario.getEmail() == null) || (usuario.getEmail().equals("")))
            throw new RegraNegocioRunTime("Email deve ser informado");    
        
        boolean teste = repository.existsByEmail(usuario.getEmail());
        if (teste)
            throw new RegraNegocioRunTime("Email informado já existe na base");   
            
        if ((usuario.getSenha() == null) || (usuario.getSenha().equals("")))
            throw new RegraNegocioRunTime("Usuário deve possui senha");
        */ 
        return;   
    }
}
