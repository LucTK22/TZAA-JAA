package com.example.tienda_perfumes.model;

import jakarta.persistence.*;

@Entity
public class ProductoCarrito {

    // Un mismo perfume puede estar en carritos de distintos usuarios.
    @ManyToOne
    @JoinColumn(name = "perfume_id", referencedColumnName = "id")
    private Perfume perfume;

    @ManyToOne
    @JoinColumn(name = "carrito_id", referencedColumnName = "id")
    private Carrito carrito;

    @Id
    @GeneratedValue
    private Long id;

    private int cantidad;

    public Perfume getPerfume() {
        return perfume;
    }

    public void setPerfume(Perfume perfume) {
        this.perfume = perfume;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
