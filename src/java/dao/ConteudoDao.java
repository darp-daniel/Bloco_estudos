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
import java.util.ArrayList;
import model.Conteudo;

/**
 *
 * @author cliente
 */
public class ConteudoDao {
    public static boolean inserirConteudo(Conteudo c){
        boolean sucesso = false;
        
        try(Connection conn = Conexao.abrirConexao()){
            PreparedStatement stmn = conn.prepareStatement("insert into bloco_estudos.conteudo (nome, assunto, nom_mat, id_u) values (?, ?, ?, ?)");
            
            stmn.setString(1, c.getNome());
            stmn.setString(2, c.getAssunto());
            stmn.setString(3, c.getNom_mat());
            stmn.setInt(4, c.getId_u());
            
            int rowsAffected = stmn.executeUpdate();
            
            if(rowsAffected == 1){
                sucesso = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return sucesso;
    }
    public static ArrayList<Conteudo> buscarConteudo(String nom_mat, int id_u){
        ArrayList<Conteudo> ct = new ArrayList();
        
        try(Connection conn = Conexao.abrirConexao()){
            PreparedStatement stmn = conn.prepareStatement("select * from bloco_estudos.conteudo where nom_mat = ? and id_u = ?");
            
            stmn.setString(1, nom_mat);
            stmn.setInt(2, id_u);
            
            ResultSet rs = stmn.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String assunto = rs.getString("assunto");
                
                Conteudo c = new Conteudo();
                c.setId(id);
                c.setNome(nome);
                c.setAssunto(assunto);
                c.setNom_mat(nom_mat);
                c.setId_u(id_u);
                
                ct.add(c);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ct;
    }
    public static boolean editarAssunto(Conteudo c, String assunto){
        boolean sucesso = false;
        
        try(Connection conn = Conexao.abrirConexao()){
            PreparedStatement stmn = conn.prepareStatement("update bloco_estudos.conteudo set assunto = ? where nome = ? , nom_materia = ? and id_u = ?");
            
            stmn.setString(1, assunto);
            stmn.setString(2, c.getNome());
            stmn.setString(3,c.getNom_mat());
            stmn.setInt(4, c.getId_u());
            
            int rowsAffected = stmn.executeUpdate();
            
            if(rowsAffected == 1){
                sucesso = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return sucesso;
    }
    public static boolean excluirConteudo(String nome, int id_u){
        boolean sucesso = false;
        
        try(Connection conn = Conexao.abrirConexao()){
            PreparedStatement stmn = conn.prepareStatement("delete from bloco_estudos.conteudo where nome = ? and id_u = ?");
            
            stmn.setString(1, nome);
            stmn.setInt(2, id_u);
            
            int rowsAffected = stmn.executeUpdate();
            
            if(rowsAffected == 1){
                sucesso = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return sucesso;
    }
}
