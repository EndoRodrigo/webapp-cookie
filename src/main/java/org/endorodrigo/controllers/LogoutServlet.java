package org.endorodrigo.controllers;

import org.endorodrigo.services.LoginServiceSessionImpl;
import org.endorodrigo.services.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> username = auth.getUsername(req);
        if (username.isPresent()) {
            HttpSession session = req.getSession();
            session.invalidate();
        }
        resp.sendRedirect(req.getContextPath() + "/login.html");
    }
}
