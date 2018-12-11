 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author conty
 */
public class LineadePedido {
    private String CUP;
    private String NombreProd;
    private int cantidad;
    private double precio;
    private String agregados;
    private double subtotal;

    public LineadePedido(String CUP, String NombreProd, int cantidad, double precio, String agregados, double subtotal) {
        this.CUP = CUP;
        this.NombreProd = NombreProd;
        this.cantidad = cantidad;
        this.precio = precio;
        this.agregados = agregados;
        this.subtotal = subtotal;
    }

    public String getCUP() {
        return CUP;
    }

    public void setCUP(String CUP) {
        this.CUP = CUP;
    }

    public String getNombreProd() {
        return NombreProd;
    }

    public void setNombreProd(String NombreProd) {
        this.NombreProd = NombreProd;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getAgregados() {
        return agregados;
    }

    public void setAgregados(String agregados) {
        this.agregados = agregados;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    public void mostrarLineadePedido(){
        System.out.println("CUP: " + CUP);
        System.out.println("NOMBRE DEL PRODUCTO: " + NombreProd);
        System.out.println("CANTIDAD: " + cantidad);
        System.out.println("PRECIO: " + precio);
        System.out.println("AGREGADOS: " + agregados);
        System.out.println("SUBTOTAL: " + subtotal);
    }
}
