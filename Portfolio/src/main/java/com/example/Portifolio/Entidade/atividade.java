package com.example.Portifolio.Entidade;

import javax.persistence.Entity;

@Entity
public class atividade {
    private long id_atv;
    private String resumo;
    private String link;

    public long getId_atv() {
        return id_atv;
    }

    public String getLink() {
        return link;
    }

    public String getResumo() {
        return resumo;
    }

    public void setId_atv(long id_atv) {
        this.id_atv = id_atv;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
    
}
