package com.example.Portifolio.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Para n precisar implementar os requests posts e etc

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    // na ordem que está no JSON
    private long matricula;
    private String email;
    private String nome;
    private int tipo;
    private String senha;
   
}
