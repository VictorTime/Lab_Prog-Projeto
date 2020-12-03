package com.example.Portifolio.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data // Para n precisar implementar os requests posts e etc 
@Builder
@AllArgsConstructor
public class CurriculoDTO {
   
    private long id_curriculo;
    private String escolaridade;
    private String formacao;
    private long matricula;
}
