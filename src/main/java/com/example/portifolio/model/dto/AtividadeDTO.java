package com.example.Portifolio.model.dto;

import java.util.Set;

import com.example.Portifolio.model.entidade.Curriculo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Para n precisar implementar os requests posts e etc 
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AtividadeDTO 
{
    // na ordem que está no JSON
    private long id_atv;
    private String tipo_atv;
    private String resumo;
    private String link;
    private String titulo;
    private long matricula;
    Set<Curriculo> aCurriculos;

}
