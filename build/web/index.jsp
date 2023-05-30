<%-- 
    Document   : index
    Created on : 22/05/2023, 11:26:16 p. m.
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tienda Deportiva Barbosa</title>
    </head>
    <body>
        <h1>Artículos</h1>
        <h2 href="">Nuevo Registro</h2>
        <br/><br/>
        <table border="1" width="80%">
            <thead>
                <tr>
                    <th>Categoría</th>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Precio</th>
                </tr>
            </thead>
            
             <h2>Registrar Producto</h2>
        <form action="" method="POST" autocomplete="off" >
            <p>Categoría:
                <input id="categoria" name="categoria" type="text"/>
            </p>
            <p>Nombre artículo:
                <input id="nombre" name="nombre" type="text"/>
            </p>
            <p>Descripción:
                <input id="descripcion" name="descripcion" type="text"/>
            </p>
            <p>Precio:
                <input id="precio" name="precio" type="number"/>
                
            </p>
            <button id="guardar" name="guardar" type="submit">Guardar</button> 
            <input type="submit" name="action" value="Add"/>
                 <input type="submit" name="action" value="Edit"/>
                 <input type="submit" name="action" value="Delete"/>
                 <input type="submit" name="action" value="Search"/>

            
        </form>
             <tbody>
                 <c:forEach var="producto" items="${lista}">
                     <tr>
                         <td><c:out value="${producto.categoria}"/></td>
                         <td><c:out value="${producto.nombre}"/></td>
                         <td><c:out value="${producto.descripcion}"/></td>
                         <td><c:out value="${producto.precio}"/></td>
                         
                     </tr>
                 </c:forEach>
             </tbody>
        </table>
    </body>
</html>