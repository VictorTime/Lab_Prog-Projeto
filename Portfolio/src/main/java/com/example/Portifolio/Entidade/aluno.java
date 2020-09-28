package com.example.Portifolio.Entidade;

import javax.persistence.Entity;

@Entity
public class aluno {
    private long matricula;
    private long id_curriculo;
    private String nome;
    private String email;

    public aluno(long matricula, long id_curriculo, String nome, String email){
        this.email = email;
        this.id_curriculo = id_curriculo;
        this.nome = nome;
        this.matricula = matricula;
    }
    public String getEmail() {
        return email;
    }
    public long getId_curriculo() {
        return id_curriculo;
    }
    public long getMatricula() {
        return matricula;
    }
    public String getNome() {
        return nome;
    }

    //sets
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId_curriculo(long id_curriculo) {
        this.id_curriculo = id_curriculo;
    }
    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
