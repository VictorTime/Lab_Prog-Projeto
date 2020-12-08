package com.example.Portifolio.model.dto;

import java.util.Set;
import com.example.Portifolio.model.entidade.Atividade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Para n precisar implementar os requests posts e etc 
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurriculoDTO {
   
    private long id_curriculo;
    private String escolaridade;
    private String formacao;
    private long matricula;
    Set<Atividade> curAtividades;
}
