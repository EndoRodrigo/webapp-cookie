package org.endorodrigo.repository;

import org.endorodrigo.models.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoyJDBCImpl implements Repo<Producto>{

    private Connection conn;

    public ProductRepositoyJDBCImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Producto> getListProduct() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        try(Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("""
                    SELECT P.ID, P.NAME, P.PRICE, C.NAME AS CATEGORIA
                    FROM PRODUCT AS P
                    INNER JOIN CATEGORIA AS C ON P.CATEGORIA_ID = C.ID;
                    """);

            while(rs.next()){
                Producto p = getProducto(rs);
                productos.add(p);
            }
        }
        return productos;
    }

    @Override
    public Producto forIDPorudct(Long id) throws SQLException {
        String Query = """
                    SELECT P.ID, P.NAME, P.PRICE, C.NAME AS CATEGORIA
                    FROM PRODUCT AS P
                    INNER JOIN CATEGORIA AS C ON P.CATEGORIA_ID = C.ID
                    WHERE P.ID = ?
                    """;
        Producto productos = null;
        try(PreparedStatement stmt = conn.prepareStatement(Query)) {
            stmt.setLong(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    productos = getProducto(rs);
                }
            }
        }
        return productos;
    }

    @Override
    public void saveProduct(Producto producto) throws SQLException {

    }

    @Override
    public void deliteProduct(Long id) throws SQLException {

    }

    private Producto getProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getNString("name"));
        p.setPrecio(rs.getInt("price"));
        p.setTipo(rs.getString("categoria"));
        return p;
    }
}
