
package modelo;
import config.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ProductosDao {
Connection conexion;
    public ProductosDao() throws ClassNotFoundException {
        Conexion con = new Conexion();
        conexion = con.getConexion();
        
    }

public List<Productos> listarProductos() {
        PreparedStatement ps;
        ResultSet rs;
        List<Productos> lista = new ArrayList<>();

        try {
            if (conexion != null) { // Verificar que la conexión no sea nula antes de utilizarla
                ps = conexion.prepareStatement("SELECT art_categoria, art_nombre, art_descripcion, art_precio FROM tbl_tienda");
                rs = ps.executeQuery();

                while (rs.next()) {
                    String categoria = rs.getString("art_categoria");
                    String nombre = rs.getString("art_nombre");
                    String descripcion = rs.getString("art_descripcion");
                    int precio = rs.getInt("art_precio");

                    Productos producto = new Productos(categoria, nombre, descripcion, precio);
                    lista.add(producto); 
                }
            }
            
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    
public Productos mostrarProductos(String _categoria){
PreparedStatement ps;
ResultSet rs;
Productos producto = null;


try{
    ps=conexion.prepareStatement("SELECT art_categoria,art_nombre,art_descripcion,art_precio WHERE art_categoria=?");
    ps.setString(1,_categoria);
    rs=ps.executeQuery();
    
    while(rs.next()){
        String categoria=rs.getString("art_categoria");
        String nombre=rs.getString("art_nombre");
        String descripcion=rs.getString("art_descripcion");
        int precio=rs.getInt("art_precio");
        
       producto= new Productos(categoria,nombre,descripcion,precio);
                
        
        
    }
    return producto;
}catch(SQLException e){
    System.out.println(e.toString());
    return null;
}

}


public boolean insertar(Productos producto){
PreparedStatement ps;



try{
    ps=conexion.prepareStatement("INSERT INTO productos(categoria,nombre,descripcion,precio)VALUES (?,?,?,?)");
    ps.setString(1,producto.getCategoria());
    ps.setString(2,producto.getNombre());
    ps.setString(3,producto.getDescripcion());
    ps.setInt(4,producto.getPrecio());
    ps.execute();
    return true;
    
   
                
        
        
    }
catch(SQLException e){
    System.out.println(e.toString());
    return false;
}
}

public boolean actualizar(Productos producto){
PreparedStatement ps;



try{
    ps=conexion.prepareStatement("UPDATE productos SET  categoria=?,nombre=?,descripcion=?,precio=?) WHERE categoria=?");
    ps.setString(1,producto.getCategoria());
    ps.setString(2,producto.getNombre());
    ps.setString(3,producto.getDescripcion());
    ps.setInt(4,producto.getPrecio());
    ps.execute();
    return true;
    
   
                
        
        
    }
catch(SQLException e){
    System.out.println(e.toString());
    return false;
}
}

public boolean eliminar(String _categoria){
PreparedStatement ps;



try{
    ps=conexion.prepareStatement("DELETE FROM productos WHERE categoria=?");
    ps.setString(1,_categoria);
    ps.execute();
    return true;
    
   
                
        
        
    }
catch(SQLException e){
    System.out.println(e.toString());
    return false;
}
}}
 