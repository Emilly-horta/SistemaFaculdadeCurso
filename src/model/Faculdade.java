package model;

/**
 *
 * @author Tawan Rodrigues
 */
public class Faculdade {
    public int codigo;
    public String nome;
    public String localidade;
    public String uf;

    public Faculdade() {
    }

    public Faculdade(String nome, String localidade,String uf) {
        this.nome  = nome;
        this.localidade  = localidade;
        this.uf  = uf;
    }

    public Faculdade(int codigo, String nome,String localidade, String uf) {
        this.codigo = codigo;
        this.nome = nome;
        this.localidade= localidade;
        this.uf = uf;
        
    }
    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

   

    
}
