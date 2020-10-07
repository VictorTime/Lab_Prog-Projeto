package com.example.Portifolio.Entidade;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@EntityScan
@Table (value = "Curriculo")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Curriculo {
    @Id
    @Column (value = "id_curriculo")
    private long id_curriculo;
    @Column (value = "id_atv")
    private long id_atvs;
    @Column (value = "escolaridade")
    private String escolaridade;
    @Column (value = "formacao")
    private String formacao;

    @OneToMany
    @JoinColumn (name="id_atv")
    private Atividade atividade;
}
