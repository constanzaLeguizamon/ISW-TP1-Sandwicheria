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
    ArrayList<String> stringProductos = new ArrayList<String>();
    ArrayList<LineadePedido> lineadePedido = new ArrayList<LineadePedido>();
    public static int numPedido = 0;

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

    public ArrayList<String> getStringProductos() {
        return stringProductos;
    }

    public void setStringProductos(ArrayList<String> stringProductos) {
        this.stringProductos = stringProductos;
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
    
    public void agregarString(String str){
        stringProductos.add(str);
    }
    
    public void agregarLineadePedido(LineadePedido linea1){
        lineadePedido.add(linea1);
    }
    
    public static double total = 0;
    public static double calcularTotal(double subtotal){
        total = total + subtotal;
        return(total);
    }
    
    public static void agregarPedidoANeg(Pedido pedido){
        Repositorio.n1.agregarPedido(pedido);
        
        //PREPARAMOS UN STRING PARA COPIAR LOS PEDIDOS EN EL NEGOCIO Y RECUPERARLOS IS EN ALGUN MOMENTO SE NECESITARA
        String datosCompletosPedido="";
        String detallePedido = "";
        for(int i = 0; i < pedido.getStringProductos().size(); i++){
            detallePedido = detallePedido + pedido.getStringProductos().get(i) + "/"+ " " ;
        }
        String fechaPedido= pedido.getFecha();
        String horaPedido = pedido.getHora();
        String totalPedido = String.valueOf(pedido.getMontototalpedido());
        datosCompletosPedido = fechaPedido + " " + "-" + horaPedido + " " + "-" + detallePedido + " " + "-" + "Total: " + totalPedido;
        Repositorio.n1.agregarStringPedidos(datosCompletosPedido);
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
        System.out.println("PEDIDO");
        System.out.println("");
        System.out.println("FECHA: " + fecha);
        System.out.println("HORA: " + hora);
        System.out.println("");
        for(int i = 0; i < lineadePedido.size(); i++){
            LineadePedido linea = lineadePedido.get(i);
            linea.mostrarLineadePedido();
            System.out.println("");
        }
        System.out.println("");
        System.out.println("MONTO TOTAL: " + montototalpedido);
        System.out.println("NETO TOTAL: " + montonetopedido);
    }
    
    public void mostrarPedidoString(){
        System.out.println("PEDIDO");
        System.out.println("");
        System.out.println("FECHA: " + fecha);
        System.out.println("HORA: " + hora);
        System.out.println("");
        for(int i = 0; i < stringProductos.size(); i++){
            String s = stringProductos.get(i);
            System.out.println(s);
            System.out.println("");
        }
        System.out.println("MONTO TOTAL: " + montototalpedido);
        System.out.println("NETO TOTAL: " + montonetopedido);
    }
}
