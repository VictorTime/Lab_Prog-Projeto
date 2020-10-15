package lab.portifolio.repositorio;

//import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import lab.portifolio.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByEmailAndNome(String email, String nome);
    Optional<Usuario> findByNomeContaining(String nome);
    boolean existsByEmail(String email);
    void deleteByNome(String nome);
    long countByNome(String nome);
}