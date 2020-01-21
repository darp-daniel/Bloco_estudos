/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cliente
 */
public class Conexao {
    private static Driver driver = null;
    
    public static Connection abrirConexao() throws SQLException {
        registrarDriver();
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC", "root", "");
        
        return conn;
    }
    private static void registrarDriver() throws SQLException{
        if(driver==null){
            Driver d = new Driver();
            DriverManager.registerDriver(d);
            driver = d;
        }
    }
}
