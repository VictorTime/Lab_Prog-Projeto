package com.example.Portifolio.Entidade;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@EntityScan
@Table (value = "atividade")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class atividade{
    @Id
    @Column (value = "id_atv")
    private long id_atv;
    @Column (value = "Tipo de atividade")
    private String tipo_atv;
    @Column (value = "Resumo")
    private String resumo;
    @Column (value = "Link_ext")
    private String link;

}

