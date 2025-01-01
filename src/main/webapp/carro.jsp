<%@page import="org.endorodrigo.models.Carro"%>
<%@page import="org.endorodrigo.models.ItemCarro"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%
    Carro carro = (Carro) session.getAttribute("carro");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Carro de Compras</title>
    </head>
    <body>
        <h1>Carro de Compras</h1>
        <% if (carro == null || carro.getItems().isEmpty()) {%>
        <p>Lo sentimos no hay productos en el carro de compras!</p>
        <%} else {%>
        <form name="formcarro" action="/webapp-cookie/actualizar-carro" method="post">
            <table>
                <tr>
                    <th>id</th>
                    <th>nombre</th>
                    <th>precio</th>
                    <th>cantidad</th>
                    <th>total</th>
                    <th>borrar</th>
                </tr>
                <%
                    List<ItemCarro> items = carro.getItems();
                    for (int i = 0; i < items.size(); i++) {
                        ItemCarro item = items.get(i);
                %>
                <tr>
                    <td><%=item.getProducto().getId()%></td>
                    <td><%=item.getProducto().getNombre()%></td>
                    <td><%=item.getProducto().getPrecio()%></td>
                    <td><input type="text" size="4" name="cant_<%=item.getProducto().getId()%>" value="<%=item.getCantidad()%>" /></td>
                    <td><%=item.getImporte()%></td>
                    <td><input type="checkbox" value="<%=item.getProducto().getId()%>" name="deleteProductos" /></td>
                </tr>
                <% }%>

                <tr>
                    <td colspan="4" style="text-align: right">Total:</td>
                    <td><%=carro.getTotal()%></td>
                </tr>
            </table>
            <a href="javascript:document.formcarro.submit();">Actualizar</a>
        </form>
        <%}%>
        <p><a href="<%=request.getContextPath()%>/productos">seguir comprando</a></p>
        <p><a href="<%=request.getContextPath()%>/index.html">volver</a></p>
    </body>
</html>