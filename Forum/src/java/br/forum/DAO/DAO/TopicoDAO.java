package br.forum.DAO.DAO;
import br.forum.DAO.IDAO.ITopicoDAO;
import br.forum.Model.Assunto;
import br.forum.Model.Topico;
import br.forum.Exceptions.DAOException;
import java.sql.*;
import java.util.*;
public class TopicoDAO implements ITopicoDAO{
    private Connection conexão;
    
    public TopicoDAO(Connection conexão) {
        this.conexão = conexão;
    }
    
    @Override
    public Topico inserir(Topico topico){
        PreparedStatement stmt;
        try {
            stmt = conexão.prepareStatement("INSERT INTO topico (nome, autor, dataCriacao, idAssuntoFK, visitas) values (?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, topico.getNome());
            stmt.setString(2, topico.getAutor());
            stmt.setDate(3, new java.sql.Date(topico.getDataCriacao().getTime()));
            stmt.setInt(4, topico.getAssunto().getIdAssunto());
            stmt.setInt(5, 0);
            stmt.executeUpdate();
            
            Integer idRetorno = -1;
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                idRetorno = rs.getInt(1);
            }
            topico.setIdTopico(idRetorno);
            return topico;
        } catch (Exception ex) {
            throw new DAOException("Ocorreu um erro ao inserir Topico");
        }
    }
    
    @Override
    public Topico findById(Integer id){
        PreparedStatement stmt;
        ResultSet rs;
        try {
            stmt = conexão.prepareStatement("SELECT * FROM topico WHERE idTopico=? ");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Topico t = null;
            Assunto a = null;
            if(rs.next()){
                t = new Topico();
                a = new Assunto();
                t.setNome(rs.getString("nome"));
                t.setAutor(rs.getString("autor"));
                t.setDataCriacao(rs.getDate("dataCriacao"));
                t.setIdTopico(rs.getInt("idTopico"));
                a.setIdAssunto(rs.getInt("idAssuntoFK")); t.setAssunto(a);
                t.setVisitas(rs.getInt("visitas"));
            }else throw new Exception("Ocorreu um erro ao procurar o ID "+ id +" em Topico");
            return t;
        } catch (Exception ex) {
            throw new DAOException("Ocorreu um erro ao procurar o ID "+ id +" em Topico");
        }
    }

    @Override
    public List<Topico> findAllByAssunto(Integer id){
        PreparedStatement stmt;
        ResultSet rs;
        try {
            stmt = conexão.prepareStatement("SELECT * FROM topico WHERE idAssuntoFK = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Topico t = null;
            Assunto a = null;
            List<Topico> topicos = new ArrayList<Topico>();
            while(rs.next()){
                t = new Topico();
                a = new Assunto();
                t.setNome(rs.getString("nome"));
                t.setAutor(rs.getString("autor"));
                t.setDataCriacao(rs.getDate("dataCriacao"));
                t.setIdTopico(rs.getInt("idTopico"));
                a.setIdAssunto(rs.getInt("idAssuntoFK")); t.setAssunto(a);
                t.setVisitas(rs.getInt("visitas"));
                topicos.add(t);
            }
            return topicos;
        } catch (Exception ex) {
            throw new DAOException("Ocorreu um erro ao procurar ALL em Topico");
        }
    }

    @Override
    public void contadorVisitas(Integer id) {
        PreparedStatement stmt;
        try {
            stmt = conexão.prepareStatement("UPDATE topico set visitas=visitas +1 WHERE idTopico=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return;
        } catch (Exception ex) {
            throw new DAOException("Ocorreu um erro ao inserir Topico");
        }
    }
}
