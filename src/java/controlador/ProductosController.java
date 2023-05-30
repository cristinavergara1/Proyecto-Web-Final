package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Productos;
import modelo.ProductosDao;

@WebServlet(name = "ProductosController", urlPatterns = {"/ProductosController"})
public class ProductosController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductosDao productosDao = new ProductosDao();
        String accion = request.getParameter("accion");
        RequestDispatcher dispatcher = null;

        if (accion == null || accion.isEmpty()) {
            dispatcher = request.getRequestDispatcher("/index.jsp");
            List<Productos> listaProductos = productosDao.listarProductos();
            request.setAttribute("lista", listaProductos);
        } else if ("nuevo".equals(accion)) {
            dispatcher = request.getRequestDispatcher("productos/nuevo.jsp");
        } else if ("insertar".equals(accion)) {
            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            int precio = Integer.parseInt(request.getParameter("precio"));
            Productos producto = new Productos(codigo, nombre, descripcion, precio);
            productosDao.insertar(producto);
            dispatcher = request.getRequestDispatcher("/index.jsp");
            List<Productos> listaProductos = productosDao.listarProductos();
            request.setAttribute("lista", listaProductos);
        } else if ("eliminar".equals(accion)) {
            String codigo = request.getParameter("codigo");
            productosDao.eliminar(codigo);
            dispatcher = request.getRequestDispatcher("index.jsp");
            List<Productos> listaProductos = productosDao.listarProductos();
            request.setAttribute("lista", listaProductos);
        } else if ("nuevo".equals(accion)) {
            dispatcher = request.getRequestDispatcher("productos/nuevo.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/index.jsp");
            List<Productos> listaProductos = productosDao.listarProductos();
            request.setAttribute("lista", listaProductos);
        }

        boolean mostrarEliminar = false;
        boolean mostrarNuevoRegistro = false;
        String rutaVentana = request.getRequestURI();
        String accionVentana = request.getParameter("accion");
        if ("/Tienda/ProductosController".equals(rutaVentana)) {
            if ("insertar".equals(accionVentana)) {
                mostrarNuevoRegistro = true;
                mostrarEliminar = true;
            } else if ("eliminar".equals(accionVentana)) {
                mostrarEliminar = true;
                mostrarNuevoRegistro = true;
            }
        }

        request.setAttribute("mostrarEliminar", mostrarEliminar);
        request.setAttribute("mostrarNuevoRegistro", mostrarNuevoRegistro);
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
