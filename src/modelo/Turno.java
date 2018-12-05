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
public class Turno {
    private String nombreturno;
    private String horainicio;
    private String horafinalizacion;
    private double montoturno;
    ArrayList <Pedido> pedido = new ArrayList <Pedido>();
    public static int controlAcu = 0;

    public Turno(String nombreturno, String horainicio, String horafinalizacion, double montoturno) {
        this.nombreturno = nombreturno;
        this.horainicio = horainicio;
        this.horafinalizacion = horafinalizacion;
        this.montoturno = montoturno;
    }

    public String getNombreturno() {
        return nombreturno;
    }

    public void setNombreturno(String nombreturno) {
        this.nombreturno = nombreturno;
    }
    
    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public String getHorafinalizacion() {
        return horafinalizacion;
    }

    public void setHorafinalizacion(String horafinalizacion) {
        this.horafinalizacion = horafinalizacion;
    }

    public double getMontoturno() {
        return montoturno;
    }

    public void setMontoturno(double montoturno) {
        this.montoturno = montoturno;
    }

    public ArrayList<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(ArrayList<Pedido> pedido) {
        this.pedido = pedido;
    }
    
    public void agregarPedido(Pedido ped){
        pedido.add(ped);
    }
    
    public static void CantidaddePedidos(){
        controlAcu = controlAcu + 1;
    }
    
    public static double totalPed = 0;
    
    public static void TotalPedidos(double total){
        totalPed = totalPed + total;
    }
    
    public void mostrarPedido(){
        for(int i = 0; i < pedido.size(); i++){
            Pedido ped = pedido.get(i);
            ped.mostrarPedido();
        }
    }
    
    public void mostrarTurno(){
        System.out.println("NOMBRE: " + nombreturno);
        System.out.println("HORA INICIO: " + horainicio);
        System.out.println("HORA FINALIZACION: " + horafinalizacion);
        System.out.println("MONTO DEL TURNO: " + montoturno);
    }
}
