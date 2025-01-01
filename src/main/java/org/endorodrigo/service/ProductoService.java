package org.endorodrigo.service;

import org.endorodrigo.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> porID(Long id);
}
