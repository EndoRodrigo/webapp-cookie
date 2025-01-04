package org.endorodrigo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.endorodrigo.models.Categoria;


public class CategoriaRepositoryJdbcImpl implements Repo<Categoria>{
    
    Connection conn;

    public CategoriaRepositoryJdbcImpl(Connection conn) {
        this.conn = conn;
    }


    @Override
    public List<Categoria> getList() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        String query = "select * from category";
        try(Statement stmt =  conn.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {                
                categorias.add(getCategoria(rs));
            }
        }
        return categorias;
    }

    @Override
    public Categoria forID(Long id) throws SQLException {
        Categoria categoria = new Categoria();
        String query = "select * from category where id = ?";
        try(PreparedStatement stmt =  conn.prepareStatement(query)){
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                categoria = getCategoria(rs);
            }
        }
        return categoria;
    }

    @Override
    public void save(Categoria t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delite(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Categoria getCategoria(ResultSet rs) throws SQLException{
        Categoria c = new Categoria();
        c.setId(rs.getLong("id"));
        c.setName(rs.getString("name"));
        return c;
    }
    
}
