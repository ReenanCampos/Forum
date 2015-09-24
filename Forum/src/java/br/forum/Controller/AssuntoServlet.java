package br.forum.Controller;
import br.forum.DAO.DAOManager.AssuntoManager;
import br.forum.DAO.DAOManager.TopicoManager;
import br.forum.Model.Assunto;
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
        if(assuntos.isEmpty()){
            request.setAttribute("msg", "Não há assuntos disponíveis");
        }else{
            request.setAttribute("msg", "");
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
