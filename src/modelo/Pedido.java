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
public class Pedido {
    private String fecha;
    private String hora;
    private double montototalpedido;
    private double montonetopedido;
    ArrayList<Producto> prod = new ArrayList<Producto>();
    ArrayList<LineadePedido> lineadePedido = new ArrayList<LineadePedido>();
    private int numPedido = 0;

    public Pedido(int numPedido, String fecha, String hora, double montototalpedido, double montonetopedido) {
        this.numPedido = numPedido;
        this.fecha = fecha;
        this.hora = hora;
        this.montototalpedido = montototalpedido;
        this.montonetopedido = montonetopedido;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getMontototalpedido() {
        return montototalpedido;
    }

    public void setMontototalpedido(double montototalpedido) {
        this.montototalpedido = montototalpedido;
    }

    public double getMontonetopedido() {
        return montonetopedido;
    }

    public void setMontonetopedido(double montonetopedido) {
        this.montonetopedido = montonetopedido;
    }

    public ArrayList<Producto> getProd() {
        return prod;
    }

    public void setProd(ArrayList<Producto> prod) {
        this.prod = prod;
    }

    public ArrayList<LineadePedido> getLineadePedido() {
        return lineadePedido;
    }

    public void setLineadePedido(ArrayList<LineadePedido> lineadePedido) {
        this.lineadePedido = lineadePedido;
    }
    //----------------------------------------------------------------------//
    
    public void agregar(Producto p){
        prod.add(p);
    }
    
    public void agregarLineadePedido(LineadePedido linea1){
        lineadePedido.add(linea1);
    }
    
    public double calcularTotal(){
        double total = 0;
        for(int i = 0; i < prod.size(); i++){
            total = total + prod.get(i).getPreciodelProdconAgreg();
        }
        return(total);
    }   
    
    public static void agregarPedidoANeg(Pedido pedido){
        Repositorio.n1.agregarPedido(pedido);
    }
    
    public void mostrarProducto(){
        for(int i = 0; i < prod.size(); i++){
            Producto p = prod.get(i);
            p.mostrarProducto();
            System.out.println("");
        }
    }
    
    public void mostrarLineadePedido(){
        for(int i = 0; i < lineadePedido.size(); i++){
            LineadePedido linea1 = lineadePedido.get(i);
            linea1.mostrarLineadePedido();
            System.out.println("");
        }
    }
    
    public void mostrarPedido(){
        System.out.println("");
        System.out.println("**********************************************************************************");
        System.out.println("PEDIDO");
        System.out.println("N°: " + numPedido);
        System.out.println("FECHA: " + fecha);
        System.out.println("HORA: " + hora);
        System.out.println("");
        System.out.println("LINEAS DE PEDIDO");
        for(int i = 0; i < lineadePedido.size(); i++){
            LineadePedido linea = lineadePedido.get(i);
            linea.mostrarLineadePedido();
            System.out.println("");
        }
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("PRODUCTOS DEL PEDIDO");
        for(int i = 0; i < prod.size(); i++){
            Producto p = prod.get(i);
            p.mostrarProducto();
            System.out.println("");
        }
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("MONTO TOTAL: " + montototalpedido);
        System.out.println("NETO TOTAL: " + montonetopedido);
    }
}
