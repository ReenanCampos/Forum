package br.forum.DAO.dao;
import br.forum.DAO.DAOException;
import br.forum.Model.Assunto;
import java.sql.*;
import java.util.*;
public class AssuntoDAO implements IAssuntoDAO{
    private Connection conexão;
    
    public AssuntoDAO(Connection conexão) {
        this.conexão = conexão;
    }
    
    @Override
    public Assunto inserir(Assunto assunto){
        PreparedStatement stmt;
        try {
            stmt = conexão.prepareStatement("INSERT INTO assunto (nome, descricao) values (?, ?)");
            stmt.setString(1, assunto.getNome());
            stmt.setString(2, assunto.getDescricao());
            stmt.executeUpdate();
            return assunto;
        } catch (Exception ex) {
            throw new DAOException("Ocorreu um erro ao inserir Assunto");
        }
    }

    @Override
    public Assunto findById(Integer id){
        PreparedStatement stmt;
        ResultSet rs;
        try {
            stmt = conexão.prepareStatement("SELECT * FROM assunto WHERE idAssunto=? ");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Assunto a = null;
            if(rs.next()){
                a = new Assunto();
                a.setNome(rs.getString("nome"));
                a.setDescricao(rs.getString("descricao"));
                a.setIdAssunto(id);
            }else throw new Exception("Ocorreu um erro ao procurar o ID "+ id +" em Assunto");
            return a;
        } catch (Exception ex) {
            throw new DAOException("Ocorreu um erro ao procurar o ID "+ id +" em Assunto");
        }
    }

    @Override
    public List<Assunto> findAll(){
        PreparedStatement stmt;
        ResultSet rs;
        try {
            stmt = conexão.prepareStatement("SELECT * FROM assunto");
            rs = stmt.executeQuery();
            Assunto a = new Assunto();
            List<Assunto> assuntos = new ArrayList<Assunto>();
            while(rs.next()){
                a.setNome(rs.getString("nome"));
                a.setDescricao(rs.getString("descricao"));
                a.setIdAssunto(rs.getInt("idAssunto"));
                assuntos.add(a);
            }
            return assuntos;
        } catch (Exception ex) {
            throw new DAOException("Ocorreu um erro ao procurar ALL em Assunto");
        }
    }

}
