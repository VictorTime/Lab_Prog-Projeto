package com.example.portifolio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data // Para n precisar implementar os requests posts e etc 
@Builder
@AllArgsConstructor
public class UsuarioDTO {
	// na ordem que está no JSON
    private String nome;
    private String email;
    private String senha;
    private long   matricula;
    private long   id_curriculo;
}
