package com.example.portifolio.Entidade;

// O JPA hibernate-jpa
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "atividade")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Atividade {
    //Precisa de um Id?
    @Id
    @Column (name = "id_atv")
    private long id_atv;
    @Column (name = "resumo")
    private String resumo;
    @Column (name = "link")
    private String link;
    @Column (name="tipo")
    private String tipo;
    @Column (name="tema")
    private String tema;
    @Column (name="docente")
    private String docente_relac;
    
}
