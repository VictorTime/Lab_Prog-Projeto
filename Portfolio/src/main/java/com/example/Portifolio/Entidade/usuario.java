package com.example.Portifolio.Entidade;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@EntityScan
@Table(value = "usuario")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @Column (value = "matricula")
    private long matricula;
    @Column (value = "id_curriculo")
    private long id_curriculo;
    @Column (value = "nome")
    private String nome;
    @Column (value = "email")
    private String email;
    //@Column(name="senha")
    //@JsonIgnore
    //private String senha;

    @OneToOne
    @JoinColumn (name="id_curriculo")
    private Curriculo curriculo;

}
