/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.lucasoliveira.core.dao.conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author lucas
 */
public class conexaoJDBC {
    
    private static final String URL = "jdbc:mysql://localhost:3306/mapa";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    
    public static Connection conn;
    
    public static Connection getConexao(){
    
        try {
            if(conn == null){
                
           conn = DriverManager.getConnection(URL,USER,PASSWORD);
            return conn;
            }
            
            else return conn;
        } catch (SQLException e ) {
            JOptionPane.showMessageDialog(null, "Houve um erro ao conectar ao banco de dados");
            return null;
        }
}
    
            
    
    
}
