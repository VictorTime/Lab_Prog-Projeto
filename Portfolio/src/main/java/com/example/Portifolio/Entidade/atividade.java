package com.example.Portifolio.Entidade;

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
public class atividade {
    //Precisa de um Id?
    @Id
    @Column (name = "id_atv")
    private long id_atv;
    @Column (name = "resumo")
    private String resumo;
    @Column (name = "link")
    private String link;
    
}
