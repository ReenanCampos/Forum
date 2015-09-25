package br.forum.Model;
import java.util.List;
public class Assunto {
    private Integer idAssunto;
    private String nome;
    private String descricao;
    private Integer numTopico;
    private Integer numTotalRespostas;
    private Post ultimoPost;
    private List<Topico> topicos;

    public Assunto(){}
    public Integer getIdAssunto() {
        return idAssunto;
    }
    public void setIdAssunto(Integer idAssunto) {
        this.idAssunto = idAssunto;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public List<Topico> getTopicos() {
        return topicos;
    }
    public void setTopicos(List<Topico> topicos) {
        this.topicos = topicos;
    }
    
    public Integer getNumTopico() {
        return numTopico;
    }
    public void setNumTopico(Integer numTopico) {
        this.numTopico = numTopico;
    }
    public Post getUltimoPost() {
        return ultimoPost;
    }
    public void setUltimoPost(Post ultimoPost) {
        this.ultimoPost = ultimoPost;
    }
    public Integer getNumTotalRespostas() {
        return numTotalRespostas;
    }
    public void setNumTotalRespostas(Integer numTotalRespostas) {
        if(this.numTotalRespostas == null) this.numTotalRespostas = 0;
        this.numTotalRespostas += numTotalRespostas;
    }
    @Override
    public String toString() {
        return "Assunto{" + "idAssunto=" + idAssunto + ", nome=" + nome + ", descricao=" + descricao + '}';
    }
    
    
    
}
