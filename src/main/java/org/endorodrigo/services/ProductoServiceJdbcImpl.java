package org.endorodrigo.services;


import org.endorodrigo.models.Producto;
import org.endorodrigo.repository.ProductRepositoyJDBCImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductoServiceJdbcImpl implements ProductoService{

    private ProductRepositoyJDBCImpl repositoyJDBC;

    public ProductoServiceJdbcImpl(Connection conn) {
        this.repositoyJDBC = new ProductRepositoyJDBCImpl(conn);
    }

    @Override
    public List<Producto> listar() {
       try {
            return repositoyJDBC.getListProduct();
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

    @Override
    public Optional<Producto> porId(Long id) {
        try {
            return Optional.ofNullable(repositoyJDBC.forIDPorudct(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
