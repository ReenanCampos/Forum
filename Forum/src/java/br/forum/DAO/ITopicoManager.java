
package br.forum.DAO;

import br.forum.Model.Topico;
import java.util.*;

public interface ITopicoManager {
    Topico cadastrar(Topico topico);
    Topico procurarID(Integer id);
    List<Topico> procurarALLByAssunto(Integer id);
}
