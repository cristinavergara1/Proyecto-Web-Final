package modelo;

import config.Conexion;

/**
 *
 * @author Usuario
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductosDao {

    Connection conexion;

    public ProductosDao() {
        Conexion con = new Conexion();
        conexion = con.estableceConexion();

    }

    public List<Productos> listarProductos() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Productos> lista = new ArrayList<>();

        try {
            ps = conexion.prepareStatement("SELECT * FROM tbl_tienda");
            rs = ps.executeQuery();

            while (rs.next()) {
                String codigo = rs.getString("art_codigo");
                String nombre = rs.getString("art_nombre");
                String descripcion = rs.getString("art_descripcion");
                int precio = rs.getInt("art_precio");

                Productos producto = new Productos(codigo, nombre, descripcion, precio);
                lista.add(producto);
            }

            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // Cerrar los recursos JDBC en el bloque finally para garantizar su liberación
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean insertar(Productos producto) {
        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("INSERT INTO tbl_tienda(art_codigo,art_nombre,art_descripcion,art_precio)VALUES (?,?,?,?)");
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getDescripcion());
            ps.setInt(4, producto.getPrecio());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean eliminar(String _codigo) {
        PreparedStatement ps;

        try {
            ps = conexion.prepareStatement("DELETE FROM tbl_tienda WHERE art_codigo=?");
            ps.setString(1, _codigo);
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

}
