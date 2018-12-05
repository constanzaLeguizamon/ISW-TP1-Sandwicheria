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
public class Rubro {
    private String nombrerubro;
    ArrayList<Producto> productos = new ArrayList<Producto>();

    public Rubro(String nombrerubro) {
        this.nombrerubro = nombrerubro;
    }

    public String getNombrerubro() {
        return nombrerubro;
    }

    public void setNombrerubro(String nombrerubro) {
        this.nombrerubro = nombrerubro;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    
    public void agregarProducto(Producto p){
        productos.add(p);
    }
    
    public void mostrarProductos(){
        for(int i = 0; i<productos.size(); i++){
            Producto p = productos.get(i);
            p.mostrarProducto();
        }
    }
     
    public void mostrarRubro(){
        System.out.println("NOMBRE RUBRO: " + nombrerubro);
    }
    
}
