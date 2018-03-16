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
 * @author Tawan Rodrigues
 */
public class FaculdadeDao {

    public Connection con;

    public FaculdadeDao() {
        this.con = new Conexao().getConnection();;
    }
     public boolean inserir(Faculdade faculdade) {

        String comando = "INSERT INTO faculdade(nome,localidade,uf) VALUES (?,?,?);";
        try {
            PreparedStatement declaracao = this.con.prepareStatement(comando);
            declaracao.setString(1, faculdade.nome);
            declaracao.setString(2, faculdade.localidade);
            declaracao.setString(3, faculdade.uf);
            declaracao.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }

    public boolean atualizar(Faculdade faculdade) {

        String comando = "update faculdade set nome = ?,localidade =?,uf = ? where codigo =?;";
        try {
            PreparedStatement declaracao = this.con.prepareStatement(comando);
            declaracao.setString(1, faculdade.getNome());
            declaracao.setString(2, faculdade.getLocalidade());
            declaracao.setString(3, faculdade.getUf());
            declaracao.setInt(4, faculdade.getCodigo());
            declaracao.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }

    public boolean excluir(Faculdade faculdade) {

        String comando = "delete from faculdade where codigo=?;";
        try {
            PreparedStatement declaracao = this.con.prepareStatement(comando);
            declaracao.setInt(1, faculdade.getCodigo());
            declaracao.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }

    public List<Faculdade> getlist() {
        List<Faculdade> faculdade = new ArrayList<>();
        String comando = "select codigo,nome,localidade,uf from faculdade";
        //String comando2 = "select  from faculdade";
        try {
            PreparedStatement declaracao = this.con.prepareStatement(comando);
            ResultSet set = declaracao.executeQuery();
            while (set.next()) {
                Faculdade f = new Faculdade();
                f.setCodigo(set.getInt("codigo"));//coluna codigo
                f.setNome(set.getString("nome"));//coluna nome
                f.setLocalidade(set.getString("localidade"));//coluna localidade
                f.setUf(set.getString("uf"));//coluna uf
                faculdade.add(f);
            }
            declaracao.close();
            set.close();
            con.close();
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("LISTA NÂO ENCONTRADA");
            return null;
        }
        return faculdade;
    }

    public void excluir(Curso cursoEsclhido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
