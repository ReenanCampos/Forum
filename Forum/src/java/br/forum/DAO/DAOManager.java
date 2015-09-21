package br.forum.DAO;
import br.forum.DAO.dao.TopicoDAO;
import br.forum.DAO.dao.AssuntoDAO;
import br.forum.DAO.dao.PostDAO;
import java.sql.*;
public class DAOManager implements IDAOManager{
    private Connection conexão;
    private AssuntoDAO assuntoDAO;
    private TopicoDAO topicoDAO;
    private PostDAO postDAO;
    public DAOManager(){}
    
    @Override
    public void iniciar()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url;
            url = "jdbc:mysql://localhost:3306/forum";
            conexão = DriverManager.getConnection(url, "root", "root");
            conexão.setAutoCommit(false);
            assuntoDAO = new AssuntoDAO(conexão);
            topicoDAO = new TopicoDAO(conexão);
            postDAO = new PostDAO(conexão);
        }
        catch( Exception ex )
        {
            throw new DAOException("Ocorreu um erro ao conectar ao banco de dados:" + ex.getMessage());
        }
    }

    @Override
    public void encerrar() 
    {
        try {
            if(!conexão.isClosed()) conexão.close();
        } catch (SQLException ex) {
            
        }
    }

    @Override
    public void confirmarTransação(){
        try {
            conexão.commit();
        } catch (SQLException ex) {
            throw new DAOException("Ocorreu um erro ao confirmar a transação");
        }
    }

    @Override
    public void abortarTransação(){
        try {
            conexão.rollback();
        } catch (SQLException ex) {
            throw new DAOException("Ocorreu um erro ao abordar a transição");
        }
    }

    @Override
    public AssuntoDAO getAssuntoDAO() {
        return assuntoDAO;
    }

    @Override
    public TopicoDAO getTopicoDAO() {
        return topicoDAO;
    }
    
    @Override
    public PostDAO getPostDAO() {
        return postDAO;
    }
}
