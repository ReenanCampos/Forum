package br.forum.DAO;
public class DAOException extends RuntimeException{
    public DAOException(String mensagem) {
        super(mensagem);
    }
}
