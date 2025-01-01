package org.endorodrigo.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.endorodrigo.model.Producto;
import org.endorodrigo.service.LoginService;
import org.endorodrigo.service.LoginServiceSesionImpl;
import org.endorodrigo.service.ProductoService;
import org.endorodrigo.service.ProductoServiceImp;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos","/productos.html"})
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImp();
        List<Producto> productos = service.listar();

        LoginService auth = new LoginServiceSesionImpl();
        Optional<String> usernameOptional = auth.getUsername(req);

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>Listado de Productos</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <h1>Listado de Productos!</h1>");
            if(usernameOptional.isPresent()) {
                out.println("<div style='color: blue;'>Hola " + usernameOptional.get() + " Bienvenido!</div>");
            }
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Id</th>");
            out.println("<th>Nombre</th>");
            out.println("<th>Tipo</th>");
            if(usernameOptional.isPresent()) {
                out.println("<th>Precio</th>");
                out.println("<th>Agregar</th>");
            }
            out.println("</tr>");
            productos.forEach(p -> {
                out.println("<tr>");
                out.println("<td>" + p.getId() + "</td>");
                out.println("<td>" + p.getName() + "</td>");
                out.println("<td>" + p.getTypeP() + "</td>");
                if(usernameOptional.isPresent()) {
                    out.println("<td>" + p.getPrice() + "</td>");
                    out.println("<td><a href=\""+req.getContextPath()+"/agregar-carro?id="+p.getId()+"\">Agregar al carro</a></td>");
                }
                out.println("</tr>");
            });
            out.println("</table>");
            out.println("    </body>");
            out.println("</html>");
        }
    }

}

