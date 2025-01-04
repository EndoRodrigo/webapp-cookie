package org.endorodrigo.services;

import org.endorodrigo.models.Producto;

import java.util.List;
import java.util.Optional;
import org.endorodrigo.models.Categoria;

public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> porId(Long id);
    
    void guardar(Producto producto);
    void eliminar(Long id);
            
    List<Categoria> listarCategoria();
    Optional<Categoria> porIdCategoria(Long id);
}
