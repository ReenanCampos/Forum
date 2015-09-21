package br.forum.DAO.dao;
import br.forum.Model.Assunto;
import br.forum.Model.Topico;
import br.forum.DAO.DAOException;
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
            stmt = conexão.prepareStatement("INSERT INTO topico (nome, autor, dataCriacao) values (?, ?, ?)");
            stmt.setString(1, topico.getNome());
            stmt.setString(2, topico.getAutor());
            stmt.setDate(3, new java.sql.Date(topico.getDataCriacao().getTime()));
            stmt.executeUpdate();
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
                topicos.add(t);
            }
            return topicos;
        } catch (Exception ex) {
            throw new DAOException("Ocorreu um erro ao procurar ALL em Topico");
        }
    }
}
