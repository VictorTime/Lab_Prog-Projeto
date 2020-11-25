package com.example.Portifolio.model.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "id_atv")
    private Atividade atividade;
}

