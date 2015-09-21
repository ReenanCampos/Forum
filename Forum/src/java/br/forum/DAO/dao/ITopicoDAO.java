package br.forum.DAO.dao;
import br.forum.Model.Topico;
import java.util.*;
public interface ITopicoDAO {
    public Topico inserir(Topico topico);
    public Topico findById(Integer id);
    public List<Topico> findAllByAssunto(Integer id);
}
