package br.forum.DAO.DAO;
import br.forum.DAO.IDAO.IPostDAO;
import br.forum.Exceptions.DAOException;
import br.forum.Model.Post;
import br.forum.Model.Topico;
import java.sql.*;
import java.util.*;
public class PostDAO implements IPostDAO{
    private Connection conexão;
    
    public PostDAO(Connection conexão) {
        this.conexão = conexão;
    }
    
    @Override
    public Post inserir(Post post){
        PreparedStatement stmt;
        try {
            stmt = conexão.prepareStatement("INSERT INTO post (autor, texto, dataCriacao, idTopicoFK) values (?, ?, ?, ?)");
            stmt.setString(1, post.getAutor());
            stmt.setString(2, post.getTexto());
            stmt.setDate(3, new java.sql.Date(post.getDataCriacao().getTime()));
            stmt.setInt(4, post.getTopico().getIdTopico());
            stmt.executeUpdate();
            return post;
        } catch (Exception ex) {
            throw new DAOException("Ocorreu um erro ao inserir Post");
        }
    }
    
    @Override
    public Post findById(Integer id){
        PreparedStatement stmt;
        ResultSet rs;
        try {
            stmt = conexão.prepareStatement("SELECT * FROM post WHERE idPost=? ");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Post p = null;
            Topico t = null;
            if(rs.next()){
                p = new Post();
                t = new Topico();
                p.setAutor(rs.getString("autor"));
                p.setTexto(rs.getString("texto"));
                t.setIdTopico(rs.getInt("idTopicoFK")); p.setTopico(t);
                p.setIdPost(id);
                p.setDataCriacao(rs.getDate("dataCriacao"));
            }else throw new Exception("Ocorreu um erro ao procurar o ID "+ id +" em Post");
            return p;
        } catch (Exception ex) {
            throw new DAOException("Ocorreu um erro ao procurar o ID "+ id +" em Post");
        }
    }

    @Override
    public List<Post> findAllByTopico(Integer id){
        PreparedStatement stmt;
        ResultSet rs;
        try {
            stmt = conexão.prepareStatement("SELECT * FROM post WHERE idTopicoFK=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Post p = null;
            Topico t = null;
            List<Post> posts = new ArrayList<Post>();
            while(rs.next()){
                p = new Post();
                t = new Topico();
                p.setAutor(rs.getString("autor"));
                p.setTexto(rs.getString("texto"));
                t.setIdTopico(rs.getInt("idTopicoFK")); p.setTopico(t);
                p.setIdPost(rs.getInt("idPost"));
                p.setDataCriacao(rs.getDate("dataCriacao"));
                posts.add(p);
            }
            return posts;
        } catch (Exception ex) {
            throw new DAOException("Ocorreu um erro ao procurar ALL em Post");
        }
    }
}
