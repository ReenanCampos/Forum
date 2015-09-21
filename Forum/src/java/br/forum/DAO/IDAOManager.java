package br.forum.DAO;

import br.forum.DAO.dao.TopicoDAO;
import br.forum.DAO.dao.AssuntoDAO;
import br.forum.DAO.dao.PostDAO;

public interface IDAOManager {
    void iniciar();
    void encerrar();
    void confirmarTransação();
    void abortarTransação();//

    AssuntoDAO getAssuntoDAO();
    TopicoDAO getTopicoDAO();
    PostDAO getPostDAO();
    
}
