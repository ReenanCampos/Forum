package br.forum.Controller;

import br.forum.DAO.DAOManager.*;
import br.forum.Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class PostServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Integer aux = new Integer(request.getParameter("idTopico"));
        Integer aux2 = new Integer(request.getParameter("idAssuntoFK"));
        request.setAttribute("idTopico", aux);
        request.setAttribute("idAssuntoFK", aux2);
        PostManager pm = new PostManager();
        List<Post> posts = pm.procurarALLByTopico(aux);
        if(posts.isEmpty()){
            request.setAttribute("msg", "Não há Posts disponíveis");
        }else{
            request.setAttribute("msg", "");
        }
        request.setAttribute("posts", "");
        request.setAttribute("posts", posts);
        
        TopicoManager tm = new TopicoManager();
        tm.addVisitas(aux);
        
        String redirect = request.getServletPath();
        if(redirect.contains("novo")){
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/novoPost.jsp");
            rd.forward(request, response);
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/posts.jsp");
            rd.forward(request, response);
        }   
        
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String autor = request.getParameter("autor"), texto = request.getParameter("texto");
        Date d = new Date();
        Integer idTopico = new Integer (request.getParameter("idTopico"));
        Integer idAssuntoFK = new Integer (request.getParameter("idAssuntoFK"));
        
        request.setAttribute("idTopico", idTopico);
        request.setAttribute("idAssuntoFK", idAssuntoFK);
        
        Post post = new Post();
        Topico topico = new Topico();
        post.setAutor(autor);
        post.setDataCriacao(d);
        post.setTexto(texto);
        topico.setIdTopico(idTopico); post.setTopico(topico);
        PostManager pm = new PostManager();
        pm.cadastrar(post);
        
        response.setHeader("Refresh","2");
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/posts.jsp");
        request.setAttribute("msg", "Recarregando pagina, por favor, aguarde");
        rd.forward(request, response);
        
    }
    
}
