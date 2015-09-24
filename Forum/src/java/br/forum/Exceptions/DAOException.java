package br.forum.Exceptions;
public class DAOException extends RuntimeException{
    public DAOException(String mensagem) {
        super(mensagem);
    }
}
