package com.example.Portifolio.Entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
    @Column (name = "id_atv")
    private long id_atvs;
    @Column (name = "escolaridade")
    private String escolaridade;
    @Column (name = "formacao")
    private String formacao;

    @OneToMany
    @JoinColumn (name="id_atv")
    private Atividade atividade;
}
