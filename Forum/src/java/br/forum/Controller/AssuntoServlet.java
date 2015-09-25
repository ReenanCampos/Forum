package br.forum.Controller;
import br.forum.DAO.DAOManager.AssuntoManager;
import br.forum.DAO.DAOManager.PostManager;
import br.forum.DAO.DAOManager.TopicoManager;
import br.forum.Model.Assunto;
import br.forum.Model.Post;
import br.forum.Model.Topico;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
public class AssuntoServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AssuntoManager am = new AssuntoManager();
        List<Assunto> assuntos = am.procurarALL();
        if(assuntos.size() < 1){
            request.setAttribute("msg", "Não há assuntos disponíveis");
        }else{
        }
        
        TopicoManager tm = new TopicoManager();
        PostManager pm = new PostManager();
        List<Post> auxPosts = null;
        List<Topico> topicos = null;
        
        for(int i=0; i<assuntos.size(); i++){
            topicos = tm.procurarALLByAssunto(assuntos.get(i).getIdAssunto());
            assuntos.get(i).setNumTopico(topicos.size());
            for(int i2=0; i2<topicos.size(); i2++){
                auxPosts = pm.procurarALLByTopico(topicos.get(i2).getIdTopico());
                topicos.get(i2).setPosts(auxPosts);
                System.out.println("\n qqq = " + topicos.size() + "\nvalor do i:" + i + "\nvalor do i2:" + i2);
                assuntos.get(i).setTopicos(topicos);
                if(topicos.get(i2).getPosts().size() > 0){
                    topicos.get(i2).getNumPost();
                    assuntos.get(i).setNumTotalRespostas(topicos.get(i2).getNumPost());
                    assuntos.get(i).setUltimoPost(topicos.get(i2).getPosts().get(topicos.get(i2).getPosts().size()-1));
                }else{
                    if(assuntos.get(i).getUltimoPost() == null){
                        topicos.get(i2).setNumPost(0);
                        Post p = new Post();
                        p.setAutor("Não há respostas");
                        p.setDataCriacao(null);
                        assuntos.get(i).setUltimoPost(p);
                    }
                }
            }
            if(assuntos.get(i).getNumTotalRespostas() == null){
                assuntos.get(i).setNumTotalRespostas(0);
            }
            if(assuntos.get(i).getUltimoPost() == null){
                Post p = new Post();p.setAutor("Não há respostas");p.setDataCriacao(null);
                assuntos.get(i).setUltimoPost(p);
            }
           
        }
        
        
        request.setAttribute("assuntos", "");
        request.setAttribute("assuntos", assuntos);
        System.out.println(assuntos);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/home.jsp");
        rd.forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
