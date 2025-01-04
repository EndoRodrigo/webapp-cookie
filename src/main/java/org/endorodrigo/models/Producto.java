package org.endorodrigo.models;

import java.time.LocalDate;

public class Producto {
    private Long id;
    private String nombre;
    private Categoria Categoria;
    private int precio;
    private String sku;
    private LocalDate fechaRegistro;

    public Producto() {
    }

    public Producto(Long id, String nombre, Categoria Categoria, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.Categoria = Categoria;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(Categoria Categoria) {
        this.Categoria = Categoria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    
}
