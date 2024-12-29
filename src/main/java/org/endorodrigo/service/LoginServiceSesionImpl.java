package org.endorodrigo.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Arrays;
import java.util.Optional;

public class LoginServiceSesionImpl implements LoginService {
    @Override
    public Optional<String> getUsername(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String username = session.getAttribute("username").toString();
        if (username != null) {
            return Optional.of(username);
        }
        return Optional.empty();
    }
}
