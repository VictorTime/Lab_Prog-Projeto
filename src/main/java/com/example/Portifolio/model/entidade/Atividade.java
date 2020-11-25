package com.example.portifolio.model.entidade;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "atividade")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Atividade {

    @Id
    @Column (name = "id_atv")
    private long id_atv;
    @Column (name = "titulo")
    private String titulo;
    @Column (name = "Tipo de atividade")
    private String tipo_atv;
    @Column (name = "Resumo")
    private String resumo;
    @Column (name = "Link_ext")
    private String link;

    @OneToOne
    @JoinColumn(name = "matricula")
    private Usuario usuario;
    
    @ManyToMany(mappedBy = "curAtividades")
    Set<Curriculo> aCurriculos;

    
}

