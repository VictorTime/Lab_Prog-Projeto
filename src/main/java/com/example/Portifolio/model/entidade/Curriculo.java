package com.example.Portifolio.model.entidade;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "curriculo")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Curriculo {
    
    @Id
    @Column (name = "id_curriculo")
    private long id_curriculo;
    @Column (name = "escolaridade")
    private String escolaridade;
    @Column (name = "formacao")
    private String formacao;

    @OneToOne
    @JoinColumn(name = "matricula")
    private Usuario usuario;

    
}

