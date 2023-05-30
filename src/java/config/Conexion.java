
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class Conexion {
    Connection conectar = null;

    public Connection estableceConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda?serverTimezone=UTC", "root", "root");
            System.out.println("Conexión establecida");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexión a la base de datos. Error: " + e.toString());
        }

        return conectar;
    }
}
        
    
