/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.lucasoliveira.core.dao;

import br.com.lucasoliveira.core.dao.conexao.conexaoJDBC;
import  br.com.lucasoliveira.core.entity.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author lucas
 */
public class UsuarioDAO {
    public void inserir( Usuario usuario){
    //comandos do banco de dados
    PreparedStatement ps;
    String sql = "INSERT INTO usuario (nome, login, senha, email) values (?,?,?,?)";
        try {
            ps = conexaoJDBC.getConexao().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getEmail());
            ps.execute();
            
        } catch (SQLException e ) {
            e.printStackTrace();
        }
    
     
    
    
    }
    



    public static boolean validarLoginSenha(String login, String senha) {
        
        String sql = "SELECT id FROM usuario WHERE login = ? AND senha = ?";
        
        try (PreparedStatement preparedStatement = conexaoJDBC.getConexao().prepareStatement(sql)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, senha);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            return resultSet.next();
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
    }
}
