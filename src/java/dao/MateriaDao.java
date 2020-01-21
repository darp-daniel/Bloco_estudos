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
import model.Materia;

/**
 *
 * @author cliente
 */
public class MateriaDao {
    public static boolean inserirMateria(Materia m){
        boolean sucesso = false;
        
        try(Connection conn = Conexao.abrirConexao()){
            PreparedStatement stmn = conn.prepareStatement("insert into bloco_estudos.materia (nome, id_u) values (?, ?)");
            
            stmn.setString(1, m.getNome());
            stmn.setInt(2, m.getId_u());
            
            int rowsAffected = stmn.executeUpdate();
            
            if(rowsAffected == 1){
                sucesso = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return sucesso;
    }
    public static ArrayList<Materia> buscarMaterias(int id_u){
        ArrayList<Materia> mt = new ArrayList();
        
        try(Connection conn = Conexao.abrirConexao()){
            PreparedStatement stmn = conn.prepareStatement("select * from bloco_estudos.materia where id_u = ?");
            
            stmn.setInt(1, id_u);
            
            ResultSet rs = stmn.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                
                Materia m = new Materia();
                m.setId(id);
                m.setNome(nome);
                m.setId_u(id_u);
                
                mt.add(m);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return mt;
    }
    public static boolean excluirMateria(String nome, int id_u){
        boolean sucesso = false;
        
        try(Connection conn = Conexao.abrirConexao()){
            PreparedStatement stmn = conn.prepareStatement("delete from bloco_estudos.materia where nome = ? and id_u = ?");
            
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
