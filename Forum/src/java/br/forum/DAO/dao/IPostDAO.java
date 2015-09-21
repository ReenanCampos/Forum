package br.forum.DAO.dao;
import br.forum.Model.Post;
import java.util.*;
public interface IPostDAO {
    public Post inserir(Post post);
    public Post findById(Integer id);
    public List<Post> findAll();
}
