package com.example.Portifolio.Service.exceptions;

// Só faz o tratamento da mensagem de erro
public class RegraPortifolioRunTime extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 2536768328771532190L;

    public RegraPortifolioRunTime(String msg) {
        super(msg);
    }
}
