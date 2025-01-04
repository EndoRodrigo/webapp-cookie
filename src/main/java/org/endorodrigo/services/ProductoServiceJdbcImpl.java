package org.endorodrigo.services;


import org.endorodrigo.models.Producto;
import org.endorodrigo.repository.ProductRepositoyJDBCImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.endorodrigo.models.Categoria;
import org.endorodrigo.repository.CategoriaRepositoryJdbcImpl;
import org.endorodrigo.repository.Repo;

public class ProductoServiceJdbcImpl implements ProductoService{

    private Repo<Producto> repositoyJDBC;
    private Repo<Categoria> repositoryCategoria;

    public ProductoServiceJdbcImpl(Connection conn) {
        this.repositoyJDBC = new ProductRepositoyJDBCImpl(conn);
        this.repositoryCategoria = new CategoriaRepositoryJdbcImpl(conn);
    }

    @Override
    public List<Producto> listar() {
       try {
            return repositoyJDBC.getList();
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

    @Override
    public Optional<Producto> porId(Long id) {
        try {
            return Optional.ofNullable(repositoyJDBC.forID(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void guardar(Producto producto) {
        try {
            repositoyJDBC.save(producto);
        } catch (SQLException ex) {
            Logger.getLogger(ProductoServiceJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            repositoyJDBC.delite(id);
        } catch (SQLException ex) {
            Logger.getLogger(ProductoServiceJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Categoria> listarCategoria() {
        try {
            return repositoryCategoria.getList();
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        try {
            return Optional.ofNullable(repositoryCategoria.forID(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
