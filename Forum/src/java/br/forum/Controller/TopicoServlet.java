package br.forum.Controller;
import br.forum.DAO.DAOManager.*;
import br.forum.Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TopicoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer aux = new Integer(request.getParameter("idAssunto"));
        TopicoManager tm = new TopicoManager();
        List<Topico> topicos = tm.procurarALLByAssunto(aux);
        if(topicos.isEmpty()){
            request.setAttribute("msg", "Não há tópicos disponíveis");
        }else{
            request.setAttribute("msg", "Este Assunto possui "+topicos.size()+" topico(s)");
        }
        
        PostManager pm = new PostManager();
        List<Post> auxPosts = null;
        for(int i=0; i<topicos.size(); i++){
            auxPosts = pm.procurarALLByTopico(topicos.get(i).getIdTopico());
            topicos.get(i).setPosts(auxPosts);
            if(topicos.get(i).getPosts().size() > 0){
                topicos.get(i).getNumPost();
                topicos.get(i).setUltimoPost(topicos.get(i).getPosts().get(topicos.get(i).getPosts().size()-1));
            }else{
                topicos.get(i).setNumPost(0);
                Post p = new Post();
                p.setAutor("Não há respostas");
                p.setDataCriacao(null);
                topicos.get(i).setUltimoPost(p);
            }
        }
        
           
        
        
                
                
        request.setAttribute("topicos", "");
        request.setAttribute("topicos", topicos);
        request.setAttribute("idAssunto", aux);
        String redirect = request.getServletPath();
        if(redirect.contains("novo")){
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/novoTopico.jsp");
            rd.forward(request, response);
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/topicos.jsp");
            rd.forward(request, response);
        }
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String autor = request.getParameter("autor"), texto = request.getParameter("texto"), titulo = request.getParameter("nome");
        Date d = new Date();
        Integer idAssunto = new Integer (request.getParameter("idAssunto"));
        
        TopicoManager tm = new TopicoManager();
        Topico t = new Topico();
        Assunto a = new Assunto(); a.setIdAssunto(idAssunto);
        t.setAutor(autor); t.setDataCriacao(d); t.setNome(titulo); t.setAssunto(a);
        t = tm.cadastrar(t);
        
        PostManager pm = new PostManager();
        Post p = new Post();
        p.setAutor(autor);
        p.setDataCriacao(d);
        p.setTexto(texto);
        p.setTopico(t);
        pm.cadastrar(p);
        
        request.setAttribute("idTopico", t.getIdTopico());
        request.setAttribute("idAssunto", idAssunto);
        
        response.setHeader("Refresh","2");
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/topicos.jsp");
        request.setAttribute("msg2", "Recarregando pagina, por favor, aguarde");
        rd.forward(request, response);
        
        
    }
}
