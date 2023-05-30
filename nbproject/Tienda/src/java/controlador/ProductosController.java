
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Productos;
import modelo.ProductosDao;
import java.lang.ClassNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ProductosController extends HttpServlet {




 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ProductosDao productosDao = null;
    String accion;
    RequestDispatcher dispatcher = null;

        try {
            productosDao = new ProductosDao();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    accion = request.getParameter("accion");
    if (accion == null || accion.isEmpty()) {
        dispatcher = request.getRequestDispatcher("Tienda\\web\\index.jsp");
        List<Productos> listaProductos = productosDao.listarProductos();
        request.setAttribute("lista", listaProductos);
    }

    dispatcher.forward(request, response);}

       

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      doGet(request,response);
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
