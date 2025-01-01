package org.endorodrigo.model;

import java.util.Objects;

public class ItemCarro {
    private int cantidad;
    private Producto producto;

    public ItemCarro(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getImporte(){
        return cantidad * producto.getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemCarro that = (ItemCarro) o;
        return Objects.equals(producto.getId(), that.producto.getId()) &&
                Objects.equals(producto.getName(), that.producto.getName());
    }

}
