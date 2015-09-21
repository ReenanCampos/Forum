package br.forum.Model;
import java.util.Date;
import java.util.List;
public class Topico {
    private Integer idTopico;
    private String nome;
    private String autor;
    private Date dataCriacao;
    
    private Assunto assunto;
    private List<Post> posts;
    
    public Topico() {}
    public Integer getIdTopico() {
        return idTopico;
    }
    public void setIdTopico(Integer idTopico) {
        this.idTopico = idTopico;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public Date getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    public Assunto getAssunto() {
        return assunto;
    }
    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }
    public List<Post> getPosts() {
        return posts;
    }
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    @Override
    public String toString() {
        return "Topico{" + "idTopico=" + idTopico + ", nome=" + nome + ", autor=" + autor + ", dataCriacao=" + dataCriacao + ", assunto=" + assunto + '}';
    }
    
    
    
    
}
