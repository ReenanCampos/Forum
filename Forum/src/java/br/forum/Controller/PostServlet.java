package br.forum.Controller;

import br.forum.DAO.DAOManager.*;
import br.forum.Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
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
        System.out.println(posts);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/posts.jsp");
        rd.forward(request, response);
        
        
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
    }
    
}
