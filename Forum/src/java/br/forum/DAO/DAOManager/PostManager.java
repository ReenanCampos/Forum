package br.forum.DAO.DAOManager;
import br.forum.DAO.DAO.*;
import br.forum.DAO.IDAOManager.IDAOManager;
import br.forum.DAO.IDAOManager.IPostManager;
import br.forum.Model.Assunto;
import br.forum.Model.Post;
import java.util.List;
public class PostManager implements IPostManager{

    @Override
    public Post cadastrar(Post post) {
        IDAOManager manager = new DAOManager();
        try{
            manager.iniciar();
            PostDAO ad = manager.getPostDAO();
            ad.inserir(post);
            manager.confirmarTransação();
            manager.encerrar();
            return post;
        }catch(Exception ex){
            manager.abortarTransação();
            throw ex;
        }
    }

    @Override
    public Post procurarID(Integer id) {
        IDAOManager manager = new DAOManager();
        try{
            manager.iniciar();
            PostDAO ad = manager.getPostDAO();
            Post a = ad.findById(id);
            manager.confirmarTransação();
            manager.encerrar();
            return a;
        }catch(Exception ex){
            manager.abortarTransação();
            throw ex;
        }
    }

    @Override
    public List<Post> procurarALLByTopico(Integer id) {
        IDAOManager manager = new DAOManager();
        try{
            manager.iniciar();
            PostDAO ad = manager.getPostDAO();
            List<Post> as = ad.findAllByTopico(id);
            manager.confirmarTransação();
            manager.encerrar();
            return as;
        }catch(Exception ex){
            manager.abortarTransação();
            throw ex;
        }
    }
    
}
