package br.forum.DAO.dao;
import br.forum.Model.Assunto;
import java.util.*;

public interface IAssuntoDAO {
    public Assunto inserir(Assunto assunto);
    public Assunto findById(Integer id);
    public List<Assunto> findAll();
}  
