package br.forum.Model;
import java.util.Date;
public class Post {
    private Integer idPost;
    private String autor;
    private String texto;
    private Date dataCriacao;
    
    private Topico topico;
    
    public Post() {}
    public Integer getIdPost() {
        return idPost;
    }
    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public Date getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    public Topico getTopico() {
        return topico;
    }
    public void setTopico(Topico topico) {
        this.topico = topico;
    }
    @Override
    public String toString() {
        return "Post{" + "idPost=" + idPost + ", autor=" + autor + ", texto=" + texto + ", dataCriacao=" + dataCriacao + ", topico=" + topico + '}';
    }
    
    
}
