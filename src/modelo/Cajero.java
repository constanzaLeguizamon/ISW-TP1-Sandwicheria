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
public class Cajero extends Persona{
    private int legajo;
    private double sueldo;
    private Turno tur;
    private String contraseña;
    ArrayList<Comanda> comanda = new ArrayList<Comanda>();
    ArrayList<Comprobante> comprobante = new ArrayList<Comprobante>();
    ArrayList<Turno> turno = new ArrayList<Turno>();
    

    public Cajero(int legajo, double sueldo, Turno tur, String contraseña, String apeynom, String edad, String fechanaci, String domicilio) {
        super(apeynom, edad, fechanaci, domicilio);
        this.legajo = legajo;
        this.sueldo = sueldo;
        this.tur = tur;
        this.contraseña = contraseña;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Turno getTur() {
        return tur;
    }

    public void setTur(Turno tur) {
        this.tur = tur;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public ArrayList<Comanda> getComanda() {
        return comanda;
    }

    public void setComanda(ArrayList<Comanda> comanda) {
        this.comanda = comanda;
    }

    public ArrayList<Comprobante> getComprobante() {
        return comprobante;
    }

    public void setComprobante(ArrayList<Comprobante> comprobante) {
        this.comprobante = comprobante;
    }

    public ArrayList<Turno> getTurno() {
        return turno;
    }

    public void setTurno(ArrayList<Turno> turno) {
        this.turno = turno;
    }
    
    public void agregarComanda(Comanda c){
        comanda.add(c);
    }
    
    public void mostrarComanda(){
        for(int i = 0; i < comanda.size(); i++){
            Comanda c = comanda.get(i);
        }
    }
    
    public void agregarComprobante(Comprobante c){
        comprobante.add(c);
    }
    
    public void mostrarComprobante(){
        for(int i = 0; i < comprobante.size(); i++){
            Comprobante c = comprobante.get(i);
        }
    }
    
    public void agregarTurno(Turno t){
        turno.add(t);
    }
    
    public void mostrarTurno(){
        for(int i = 0; i < turno.size(); i++){
            Turno t = turno.get(i);
            t.mostrarTurno();
        }
    }
    
    public void mostrarCajero(){
        System.out.println("LEGAJO: " + legajo);
        System.out.println("APELLIDO Y NOMBRE: " + getApeynom());
        System.out.println("SALARIO: " + sueldo);
        System.out.println("");
    }
}
