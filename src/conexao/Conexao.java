package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tawan Rodrigues e Emilly Horta
 */
public class Conexao {
    private static final String USUARIO = "root";
    private static final String SENHA = "1234";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String BANCO = "sistema";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    public Connection getConnection(){
        try {
           // System.out.println("Conectado");
            return DriverManager.getConnection(URL+BANCO,USUARIO,SENHA);
        } catch (SQLException ex) {
            System.out.println("ERRO, NÃO CONECTADO");
            throw new RuntimeException(ex);
        }
        
    
    }
    
}
