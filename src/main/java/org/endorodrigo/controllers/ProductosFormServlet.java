
package org.endorodrigo.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import org.endorodrigo.services.ProductoService;
import org.endorodrigo.services.ProductoServiceJdbcImpl;

@WebServlet("/Productos/form")
public class ProductosFormServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        ProductoService productoService = new ProductoServiceJdbcImpl(conn);
        req.setAttribute("conn", productoService.listar());
        getServletContext().getRequestDispatcher("form.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        ProductoService productoService = new ProductoServiceJdbcImpl(conn);
        req.setAttribute("categorias", productoService.listar());
        getServletContext().getRequestDispatcher("form.jsp").forward(req, resp);
    }
    
}
