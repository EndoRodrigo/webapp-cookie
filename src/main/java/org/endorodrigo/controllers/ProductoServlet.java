package org.endorodrigo.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.endorodrigo.model.Producto;
import org.endorodrigo.service.ProductoService;
import org.endorodrigo.service.ProductoServiceImp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/productos.xls","/productos.html"})
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImp();
        List<Producto> producto = service.listar();
        String servletPath = req.getServletPath();

        try(PrintWriter out = resp.getWriter()){

                out.println("<!DOCTYPE html>");
                out.println("<html lang=\"en\">");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<title>Listado de porductos</title>");
                out.println("</head>");
                out.println(" <body>");
                out.println("<h1>Listado de porductos!</h1>");
                out.println("<p><a href=\""+req.getContextPath()+"/productos.xls"+"\">Exportar archivo de excel</></p>");
                out.println("<p><a href=\""+req.getContextPath()+"/json"+"\">Mostrar json</></p>");
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>ID</th>");
                out.println("<th>NAME</th>");
                out.println("<th>TIPE</th>");
                out.println("<th>PRICE</th>");
                out.println("</tr>");
                producto.forEach(
                        p -> {
                            out.println("<tr>");
                            out.println("<td>"+ p.getId() +"</td>");
                            out.println("<td>"+ p.getName() +"</td>");
                            out.println("<td>"+ p.getTypeP() +"</td>");
                            out.println("<td>"+ p.getPrice() +"</td>");
                            out.println("</tr>");
                        }
                );
                out.println("</table>");
                out.println(" </body>");
                out.println(" </html>");



        }
    }
}
