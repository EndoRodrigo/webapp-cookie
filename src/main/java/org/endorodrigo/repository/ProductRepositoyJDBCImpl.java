package org.endorodrigo.repository;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.endorodrigo.models.*;


public class ProductRepositoyJDBCImpl implements Repo<Producto>{

    private Connection conn;

    public ProductRepositoyJDBCImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Producto> getList() throws SQLException {
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
    public Producto forID(Long id) throws SQLException {
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
    public void save(Producto producto) throws SQLException {
        String query;
        if (producto.getId() != null && producto.getId() > 0) {
            query = "update productos set nombre=?, precio=? sku=? categoria_id=? where id=?";
        }else{
            query = "insert into producto(nombre, precio, sku, categoria_id, fecha_registro) values (?,?,?,?,?)";
        }
        
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getPrecio());
            stmt.setString(3, producto.getSku());
            stmt.setLong(4,producto.getCategoria().getId());
            
            if (producto.getId() != null && producto.getId() > 0) {
                stmt.setLong(5, producto.getId());
            }else{
                stmt.setDate(5, Date.valueOf(producto.getFechaRegistro()));
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void delite(Long id) throws SQLException {
        String query = "delete from productos where id = ?";  
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    public Producto getProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        Categoria c = new Categoria();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getNString("name"));
        p.setPrecio(rs.getInt("precio"));
        p.setSku(rs.getString("sku"));
        p.setFechaRegistro(rs.getDate("fecha_registro").toLocalDate());
        c.setId(rs.getLong("id"));
        c.setName(rs.getString("categoria"));
        p.setCategoria(c);

        return p;
    }
}
