package com.example.Portifolio.Entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aluno")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class aluno {
    @Id
    @Column (name = "matricula")
    private long matricula;
    @Column (name = "id_curriculo")
    private long id_curriculo;
    @Column (name = "nome")
    private String nome;
    @Column (name = "email")
    private String email;
    @Column(name="senha")
    @JsonIgnore
    private String senha;

    @OneToOne
    @JoinColumn (name="id_curriculo")
    private curriculo curriculo;

}
