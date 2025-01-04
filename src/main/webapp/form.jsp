<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.endorodrigo.models.*"%>
<%@page import="java.util.List"%>
<%
List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de productos</title>
    </head>
    <body>
        <h1>Formulario de productos</h1>
        <form action="<%=request.getContextPath()%>/productos/form" method="POST">
            <div>
                <label for="nombre">Nombre</label>
                <div>
                    <input type="text" name="nombre" id="nombre">
                </div>
            </div>
            <div>
                <label for="precio">Precio</label>
                <div>
                    <input type="number" name="precio" id="precio">
                </div>
            </div>
            <div>
                <label for="sku">Sku</label>
                <div>
                    <input type="text" name="sku" id="sku">
                </div>
            </div>
            <div>
                <label for="fecha">Fecha Registro</label>
                <div>
                    <input type="date" name="fecha" id="fecha">
                </div>
            </div>
            <div>
                <label for="categoria">Categoria</label>
                <div>
                    <select id="catagoria" name="categoria">
                        <option value="first">--- selecione ---</option>
                        <% for (Categoria c : categorias) {%>
                        <option value="<%=c.getId()%>"><%=c.getName()%></option>
                       
                        <%}%>
                    </select>

                </div>
            </div>
            <div>
                <input type="submit" value="Crear">
            </div>
        </form>
    </body>
</html>
