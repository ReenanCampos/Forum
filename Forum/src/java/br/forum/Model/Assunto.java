package br.forum.Model;
import java.util.List;
public class Assunto {
    private Integer idAssunto;
    private String nome;
    private String descricao;
    
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
    @Override
    public String toString() {
        return "Assunto{" + "idAssunto=" + idAssunto + ", nome=" + nome + ", descricao=" + descricao + '}';
    }
    
    
    
}
