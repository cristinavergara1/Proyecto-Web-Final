<%-- 
    Document   : nuevo
    Created on : 22/05/2023, 11:26:37 p. m.
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tienda Deportiva</title>
    </head>
    <body>
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
            
        </form>
    </body>
</html>
