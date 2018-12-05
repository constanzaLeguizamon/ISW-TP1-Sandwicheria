/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ControladorSandwicheria;
import datos.Repositorio;
import java.util.ArrayList;

/**
 *
 * @author conty
 */
public class Comprobante {
    private int numComprobante;
    private String fecha;
    private String hora;
    private double montototalpedido;
    ArrayList<String> stringDetalle = new ArrayList<String>();
    public static ArrayList<String[]> pasarDatosComprobante = new ArrayList<String[]>();

    public Comprobante(int numComprobante, String fecha, String hora, double montototalpedido) {
        this.numComprobante = numComprobante;
        this.fecha = fecha;
        this.hora = hora;
        this.montototalpedido = montototalpedido;
    }

    public int getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(int numComprobante) {
        this.numComprobante = numComprobante;
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

    public ArrayList<String> getStringDetalle() {
        return stringDetalle;
    }

    public void setStringDetalle(ArrayList<String> stringDetalle) {
        this.stringDetalle = stringDetalle;
    }
    
    public void agregarStringDetalle(String str){
        stringDetalle.add(str);
    }
    
    public static void agregarComprobanteANeg(Pedido pedido, Comprobante comprobante){
        ControladorSandwicheria.agregarDetalleaComprobante(comprobante, pedido.getMontototalpedido());
        Repositorio.n1.agregarFactura(comprobante);
    }
    
    public void mostrarComprobanteString(){
        System.out.println("COMPROBANTE");
        System.out.println("");
        System.out.println("FECHA: " + fecha);
        System.out.println("HORA: " + hora);
        System.out.println("");
        for(int i = 0; i < stringDetalle.size(); i++){
            String s = stringDetalle.get(i);
            System.out.println(s);
            System.out.println("");
        }
        System.out.println("MONTO TOTAL: " + montototalpedido);
    }
}
