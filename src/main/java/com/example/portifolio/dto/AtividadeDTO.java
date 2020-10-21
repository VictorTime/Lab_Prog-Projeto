package com.example.portifolio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data // Para n precisar implementar os requests posts e etc 
@Builder
@AllArgsConstructor
public class AtividadeDTO {
	// na ordem que está no JSON
    private String tipo;
    private String tema;
    private String docente_relac;
}
