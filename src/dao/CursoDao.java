package dao;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Curso;
import model.Faculdade;

/**
 *
 * @author Tawan Rodrigues e Emilly Horta 
 */
public class CursoDao {
    
     public Connection con;

    public CursoDao() {
        this.con = new Conexao().getConnection();;
    }

    /**método boleano pra inserir dados ,atualizar e exluir

    **/
    public boolean inserir(Curso curso) {

        String comando = "INSERT INTO curso(nome,duracao,codigoFaculdade) VALUES (?,?,?);";
        try {
            PreparedStatement declaracao = this.con.prepareStatement(comando);
            //declaracao.setInt(1, curso.getCodigoCurso());
            declaracao.setString(1, curso.getNome());
            declaracao.setString(2, curso.getDuracao());
            declaracao.setInt(3, curso.getCodigoFaculdade());
            declaracao.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }

    public boolean atualizar(Curso curso) {

        String comando = "update curso set nome = ?, duracao = ? where codigoCurso =?;";
        try {
            PreparedStatement declaracao = this.con.prepareStatement(comando);
            declaracao.setString(1, curso.getNome());
            declaracao.setString(2, curso.getDuracao());
            declaracao.setInt(3, curso.getCodigoCurso());
            declaracao.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }

    public boolean excluir(Curso curso) {

        String comando = "delete from curso where codigoCurso=?;";
        try {
            PreparedStatement declaracao = this.con.prepareStatement(comando);
            //declaracao.setString(1, curso.getNome());
            declaracao.setInt(1, curso.getCodigoCurso());
            declaracao.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }
    /**seleciona o curso e coloca dentro da lista

    **/

    public List<Curso> getlist(int codigo) {
    List<Curso> curso = new ArrayList<>();
    String comando = "select * from curso where codigoFaculdade ="+codigo;
    try {
    PreparedStatement declaracao = this.con.prepareStatement(comando);
    ResultSet set = declaracao.executeQuery();
    while (set.next()) {
    Curso c = new Curso();
    c.setCodigoCurso(set.getInt("codigoCurso"));//coluna Codigo
    c.setNome(set.getString("nome"));//coluna nome
    c.setDuracao(set.getString("duracao"));//coluna Faculdade
    c.setCodigoFaculdade(set.getInt("codigoFaculdade"));//coluna Faculdade
    curso.add(c);
    }
    declaracao.close();
    set.close();
    con.close();
    } catch (SQLException e) {
    System.out.println("LISTA NÂO ENCONTRADA");
    return null;
    }
    return curso;
    }
    /**método getList do curso 

    **/
    
    public List<Curso> getlist() {
    List<Curso> curso = new ArrayList<>();
    String comando = "select * from curso";
    try {
    PreparedStatement declaracao = this.con.prepareStatement(comando);
    ResultSet set = declaracao.executeQuery();
    while (set.next()) {
    Curso c = new Curso();
    c.setCodigoCurso(set.getInt("codigoCurso"));//coluna Codigo
    c.setNome(set.getString("nome"));//coluna nome
    c.setDuracao(set.getString("duracao"));//coluna Faculdade
    curso.add(c);
    }
    declaracao.close();
    set.close();
    con.close();
    } catch (SQLException e) {
    System.out.println("LISTA NÂO ENCONTRADA");
    return null;
    }
    return curso;
    }
    
   
}
