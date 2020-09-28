package com.example.Portifolio.Entidade;

import javax.persistence.Entity;

@Entity
public class curriculo {
    private long id_curriculo;
    private long[] id_atvs;
    private String qualificacoes;

    public long[] getId_atvs() {
        return id_atvs;
    }

    public long getId_curriculo() {
        return id_curriculo;
    }

    public String getQualificacoes() {
        return qualificacoes;
    }

    public void setId_atvs(long[] id_atvs) {
        this.id_atvs = id_atvs;
    }

    public void setId_curriculo(long id_curriculo) {
        this.id_curriculo = id_curriculo;
    }

    public void setQualificacoes(String qualificacoes) {
        this.qualificacoes = qualificacoes;
    }
}
