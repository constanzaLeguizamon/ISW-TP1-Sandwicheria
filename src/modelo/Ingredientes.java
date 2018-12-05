/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author conty
 */
public class Ingredientes {
    private String codigo;
    private String nombre;
    private double precio;
    private int tipo;
    private String descripcion;

    public Ingredientes(String codigo, String nombre, double precio, String descripcion, int tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public void mostrarIngredientes(){
        System.out.println("CODIGO: " + codigo);
        System.out.println("NOMBRE: " + nombre);
        System.out.println("PRECIO: " + precio);
        System.out.println("DESCRIPCION: " + descripcion);
        System.out.println("TIPO: " + tipo);
        System.out.println("");
    }
}
