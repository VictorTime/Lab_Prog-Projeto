package com.example.Portifolio.model.entidade;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "curriculo_atividade")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurriculoAtividade {
    
    @EmbeddedId
    CurriculoAtividadePK id;


    @ManyToOne 
    @MapsId("id_curriculo") 
    @JoinColumn(name = "id_curriculo")
    private Curriculo curriculo;

    @ManyToOne
    @MapsId("id_atv") 
    @JoinColumn(name = "id_atv")
    private Atividade atividade;

}
