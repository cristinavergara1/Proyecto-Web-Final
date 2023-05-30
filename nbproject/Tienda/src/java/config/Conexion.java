/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class Conexion {
    public Connection getConexion() throws ClassNotFoundException{
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/tbl_tienda"
            ,"root","root");
            System.out.println("conexión exitosa");
            return conexion;
        
        }catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }
        
    }
    
}