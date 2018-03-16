package model;

/**
 *
 * @author Tawan Rodrigues
 */
public class Curso {
    public int CodigoCurso;
    
    public String nome;
    public String duracao;
    public int codigoFaculdade;

     public Curso() {
    }
     

    public Curso(String periodo, String nome, int codigoFaculdade) {
        this.duracao = periodo;
        this.nome = nome;
        this.codigoFaculdade =codigoFaculdade;
    }

    public Curso(int CodigoCurso, String nome, String duracao) {
        this.CodigoCurso = CodigoCurso;
        this.nome = nome;
        this.duracao = duracao;
    }

    public Curso(String duracao, String nome) {
        this.duracao = duracao;
        this.nome = nome;
    }

    public int getCodigoCurso() {
        return CodigoCurso;
    }

    public void setCodigoCurso(int CodigoCurso) {
        this.CodigoCurso = CodigoCurso;
    }


    
    
     
     
  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigoFaculdade() {
        return codigoFaculdade;
    }

    public void setCodigoFaculdade(int codigoFaculdade) {
        this.codigoFaculdade = codigoFaculdade;
    }
    public int mostar(Faculdade faculdade){
        this.codigoFaculdade = faculdade.getCodigo();
        return codigoFaculdade;
        
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
   
    
}
