package br.forum.DAO.IDAOManager;

import br.forum.DAO.DAO.TopicoDAO;
import br.forum.DAO.DAO.AssuntoDAO;
import br.forum.DAO.DAO.PostDAO;

public interface IDAOManager {
    void iniciar();
    void encerrar();
    void confirmarTransação();
    void abortarTransação();//

    AssuntoDAO getAssuntoDAO();
    TopicoDAO getTopicoDAO();
    PostDAO getPostDAO();
    
}
