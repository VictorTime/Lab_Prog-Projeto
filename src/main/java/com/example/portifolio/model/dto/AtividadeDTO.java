package com.example.portifolio.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data // Para n precisar implementar os requests posts e etc 
@Builder
@AllArgsConstructor
public class AtividadeDTO {
	// na ordem que está no JSON
    private String tipo;
    private String titulo;
    private String tema;
    private String docente_relac;
}
