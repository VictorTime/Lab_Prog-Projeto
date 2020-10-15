package lab.portifolio.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lab.portifolio.model.Atividade;
import lab.portifolio.model.Curriculo;

public interface AtividadeRepositorio extends JpaRepository <Atividade, Long> {
    public List<Atividade> findByUsuario(Curriculo curriculo);
}
