package br.forum.DAO.DAOManager;

import br.forum.DAO.IDAOManager.ITopicoManager;
import br.forum.DAO.IDAOManager.IDAOManager;
import br.forum.DAO.DAO.AssuntoDAO;
import br.forum.DAO.DAO.TopicoDAO;
import br.forum.Model.Assunto;
import br.forum.Model.Topico;
import java.util.List;

public class TopicoManager implements ITopicoManager{

    @Override
    public Topico cadastrar(Topico topico) {
        IDAOManager manager = new DAOManager();
        try{
            manager.iniciar();
            TopicoDAO ad = manager.getTopicoDAO();
            ad.inserir(topico);
            manager.confirmarTransação();
            manager.encerrar();
            return topico;
        }catch(Exception ex){
            manager.abortarTransação();
            throw ex;
        }
    }

    @Override
    public Topico procurarID(Integer id) {
        IDAOManager manager = new DAOManager();
        try{
            manager.iniciar();
            TopicoDAO td = manager.getTopicoDAO();
            Topico t = td.findById(id);
            manager.confirmarTransação();
            manager.encerrar();
            return t;
        }catch(Exception ex){
            manager.abortarTransação();
            throw ex;
        }
    }

    @Override
    public List<Topico> procurarALLByAssunto(Integer id) {
        IDAOManager manager = new DAOManager();
        try{
            manager.iniciar();
            TopicoDAO td = manager.getTopicoDAO();
            List<Topico> ts = td.findAllByAssunto(id);
            manager.confirmarTransação();
            manager.encerrar();
            return ts;
        }catch(Exception ex){
            manager.abortarTransação();
            throw ex;
        }
    }
    
}
