package br.forum.DAO.DAOManager;

import br.forum.DAO.IDAOManager.IAssuntoManager;
import br.forum.DAO.IDAOManager.IDAOManager;
import br.forum.DAO.DAO.AssuntoDAO;
import br.forum.Model.Assunto;
import java.util.List;
public class AssuntoManager implements IAssuntoManager{

    @Override
    public Assunto cadastrar(Assunto assunto) {
        IDAOManager manager = new DAOManager();
        try{
            manager.iniciar();
            AssuntoDAO ad = manager.getAssuntoDAO();
            ad.inserir(assunto);
            manager.confirmarTransação();
            manager.encerrar();
            return assunto;
        }catch(Exception ex){
            manager.abortarTransação();
            throw ex;
        }
    }

    @Override
    public Assunto procurarID(Integer id) {
        IDAOManager manager = new DAOManager();
        try{
            manager.iniciar();
            AssuntoDAO ad = manager.getAssuntoDAO();
            Assunto a = ad.findById(id);
            manager.confirmarTransação();
            manager.encerrar();
            return a;
        }catch(Exception ex){
            manager.abortarTransação();
            throw ex;
        }
    }

    @Override
    public List<Assunto> procurarALL() {
        IDAOManager manager = new DAOManager();
        try{
            manager.iniciar();
            AssuntoDAO ad = manager.getAssuntoDAO();
            List<Assunto> as = ad.findAll();
            manager.confirmarTransação();
            manager.encerrar();
            return as;
        }catch(Exception ex){
            manager.abortarTransação();
            throw ex;
        }
    }
    
    
    
    
}
