/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

/**
 *
 * @author cliente
 */
public class UsuarioDao {
    public static boolean inserirUsuario(Usuario u){
        boolean sucesso = false;
        
        try(Connection conn = Conexao.abrirConexao()){
            PreparedStatement stmn = conn.prepareStatement("insert into bloco_estudos.usuario (email, senha, nome) values (?, ?, ?)");
            
            stmn.setString(1, u.getEmail());
            stmn.setString(2, u.getSenha());
            stmn.setString(3, u.getNome());
            
            int rowsAffected = stmn.executeUpdate();
            
            if(rowsAffected == 1){
                sucesso = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return sucesso;
    }
    public static Usuario buscarUsuario(String email, String senha){
        Usuario u = null;
        
        try(Connection conn = Conexao.abrirConexao()){
            PreparedStatement stmn = conn.prepareStatement("select * from bloco_estudos.usuario where email = ? and senha = ?");
            
            stmn.setString(1, email);
            stmn.setString(2, senha);
            
            ResultSet rs = stmn.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                
                u = new Usuario();
                u.setId(id);
                u.setEmail(email);
                u.setSenha(senha);
                u.setNome(nome);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return u;
    }
}
