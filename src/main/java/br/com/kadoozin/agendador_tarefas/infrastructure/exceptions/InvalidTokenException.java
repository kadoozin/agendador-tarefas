package br.com.kadoozin.agendador_tarefas.infrastructure.exceptions;

public class InvalidTokenException extends RuntimeException{
    public InvalidTokenException(String message){
        super(message);
    }

    public InvalidTokenException(String message, Throwable cause){
        super(message, cause);
    }
}
