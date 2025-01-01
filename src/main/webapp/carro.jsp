<%@ page contentType="text/html" pageEncoding="UTF-8" import="org.endorodrigo.model.*" %>
<%
    Carro carro = (Carro) session.getAttribute("carro");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Carro de compras</title>
</head>
<body>
<h1>Carro de compras</h1>

<%
    if(carro == null || carro.getItems().isEmpty()) {
%>
    <p>Lo sentimos, no hay productos en el carrito de compras</p>
<%
    } else {
%>
    <table>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>PRICE</th>
            <th>COUNT</th>
            <th>TOTAL</th>
        </tr>
        <%
            for(ItemCarro item : carro.getItems()) {
        %>
        <tr>
            <td><%= item.getProducto().getId() %></td>
            <td><%= item.getProducto().getName() %></td>
            <td><%= item.getProducto().getPrice() %></td>
            <td><%= item.getCantidad() %></td>
            <td><%= item.getProducto().getPrice() * item.getCantidad() %></td>
        </tr>
        <%
            }
        %>
        <tr>
            <td colspan="4">TOTAL</td>
            <td><%= carro.getTotal() %></td>
        </tr>
    </table>
<%
    }
%>

<p><a href="<%= request.getContextPath() %>/productos">Mostrar productos</a></p>
<p><a href="<%= request.getContextPath() %>/index.html">Volver al inicio</a></p>

</body>
</html>
