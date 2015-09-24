package br.forum.DAO.IDAOManager;
import br.forum.Model.*;
import java.util.*;
public interface IPostManager {
    Post cadastrar(Post post);
    Post procurarID(Integer id);
    List<Post> procurarALLByTopico(Integer id);
}
