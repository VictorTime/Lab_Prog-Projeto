package com.example.Portifolio.Service.exceptions;

// Só faz o tratamento da mensagem de erro
public class RegraPortifolioRunTime extends RuntimeException{

    public RegraPortifolioRunTime(String msg) {
        super(msg);
    }
}
