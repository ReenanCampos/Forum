package br.forum.Controller;
import br.forum.DAO.DAOManager.TopicoManager;
import br.forum.Model.Topico;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TopicoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ÉOQ");
        Integer aux = new Integer(request.getParameter("idAssunto"));
        System.out.println(aux);
        TopicoManager tm = new TopicoManager();
        List<Topico> topicos = tm.procurarALLByAssunto(aux);
        if(topicos.isEmpty()){
            request.setAttribute("msg", "Não há tópicos disponíveis");
        }else{
            request.setAttribute("msg", "");
        }
        request.setAttribute("topicos", "");
        request.setAttribute("topicos", topicos);
        System.out.println(topicos);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/topicos.jsp");
        rd.forward(request, response);
        
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        
    }
}
