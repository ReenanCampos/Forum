package br.forum.DAO;
import br.forum.Model.Assunto;
import java.util.List;
public interface IAssuntoManager {
    Assunto cadastrar(Assunto assunto);
    Assunto procurarID(Integer id);
    List<Assunto> procurarALL();
}
