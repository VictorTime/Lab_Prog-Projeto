package com.example.Portifolio.Entidade;

import javax.persistence.Entity;

@Entity
public class docente {
    private long id_docente;
    private String nome;
    private long id_curriculo;
    private String email;

    private docente(long id_curriculo, long id_docente, String nome, String email){
        this.id_docente = id_docente;
        this.email = email;
        this.id_curriculo = id_curriculo;
        this.nome = nome;

    }

    public String getEmail() {
        return email;
    }

    public long getId_curriculo() {
        return id_curriculo;
    }

    public long getId_docente() {
        return id_docente;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId_curriculo(long id_curriculo) {
        this.id_curriculo = id_curriculo;
    }

    public void setId_docente(long id_docente) {
        this.id_docente = id_docente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
