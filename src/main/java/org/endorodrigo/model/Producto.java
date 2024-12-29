package org.endorodrigo.model;

public class Producto {
    private Long id;
    private String name;
    private String typeP;
    private int price;

    public Producto(Long id, String name, String typeP, int price) {
        this.id = id;
        this.name = name;
        this.typeP = typeP;
        this.price = price;
    }

    public Producto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeP() {
        return typeP;
    }

    public void setTypeP(String typeP) {
        this.typeP = typeP;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
