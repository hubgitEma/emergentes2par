package com.emergentes.modelo;

public class Productos {

    int id;
    String descripcion;
    int cantidad;
    float precio;
    String categoria;

    public Productos() {
        id=0;
    }

    public Productos(int id, String descripcion, int cantidad, float precio, String categoria) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Productos(String descripcion, int cantidad, float precio, String categoria) {        
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
}
