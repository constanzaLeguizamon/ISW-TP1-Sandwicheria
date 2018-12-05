/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datos.Repositorio;
import java.util.ArrayList;

/**
 *
 * @author conty
 */
public class Producto {
    private String CUP;
    private String nombre;
    private double precio;
    private int stock;
    private String descripcion;
    private String agregadoEspe;
    public static ArrayList<Ingredientes> ingredientes = new ArrayList<Ingredientes>();
    public static ArrayList<Double> arraySubtotal = new ArrayList<Double>();

    public Producto(String CUP, String nombre, double precio, int stock, String descripcion, String agregadoEspe) {
        this.CUP = CUP;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
        this.agregadoEspe = agregadoEspe;
    }

    public String getCUP() {
        return CUP;
    }

    public void setCUP(String CUP) {
        this.CUP = CUP;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAgregadoEspe() {
        return agregadoEspe;
    }

    public void setAgregadoEspe(String agregadoEspe) {
        this.agregadoEspe = agregadoEspe;
    }

    public static ArrayList<Ingredientes> getIngredientes() {
        return ingredientes;
    }

    public static void setIngredientes(ArrayList<Ingredientes> ingredientes) {
        Producto.ingredientes = ingredientes;
    }
    
    public void agregar(Ingredientes i){
        ingredientes.add(i);
    }
    
    public void mostrarIngredientes(){
        for(int i = 0; i < ingredientes.size(); i++){
            Ingredientes ing = ingredientes.get(i);
            ing.mostrarIngredientes();
        }
    }
    
    public static void AgregarAgregadosAlProducto(Producto producto, String nombreAgregado){
        Ingredientes i1 = null;
        for(int i = 0; i < Repositorio.n1.getIngredientes().size(); i++){
            if(Repositorio.n1.getIngredientes().get(i).getNombre().equals(nombreAgregado)){
                i1 = Repositorio.n1.getIngredientes().get(i);
                producto.agregar(i1);
            }
        }
    }
    
    public static double calcularPrecioAgregado(){
        double precio = 0;
        for(int i = 0; i < ingredientes.size(); i++){
            precio = precio + ingredientes.get(i).getPrecio();
        }
        ingredientes.clear();
        return(precio);
    }
    
    public double calcularPrecioSubtotal(double precioAgregado, int cantidad){
        double subtotal = 0;
        if(descripcion.equals("SANDWICH")){
            subtotal = (precio + precioAgregado)*cantidad;
        }
        else{
            subtotal = (precio)*cantidad;
        }
        return(subtotal);
    }
    
    public void mostrarProducto(){
        System.out.println("CUP: " + CUP);
        System.out.println("NOMBRE: " + nombre);
        System.out.println("PRECIO UNITARIO: " + precio);
        System.out.println("AGREGDOS:");
        for(int i = 0; i < ingredientes.size(); i++){
            Ingredientes ing = ingredientes.get(i);
            ing.mostrarIngredientes();
        }
    }
}
