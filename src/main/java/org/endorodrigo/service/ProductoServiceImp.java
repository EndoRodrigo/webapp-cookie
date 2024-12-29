package org.endorodrigo.service;

import org.endorodrigo.model.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImp implements ProductoService{
    @Override
    public List<Producto> listar() {
        return Arrays.asList(
                new Producto(1L,"notebook","computacion",175000),
                new Producto(2L,"Mesa Escritorio","oficina",10000),
                new Producto(3L,"Teclado Mecanico","computacion",40000)
        );
    }
}
