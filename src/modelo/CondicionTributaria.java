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
public class CondicionTributaria {
    private String tipo;
    private int codigoAfip;
    
    public CondicionTributaria(String tipo, int codigoAfip) {
        this.tipo = tipo;
        this.codigoAfip = codigoAfip;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCodigoAfip() {
        return codigoAfip;
    }

    public void setCodigoAfip(int codigoAfip) {
        this.codigoAfip = codigoAfip;
    }
    
    public void mostrarCondicionTributaria(){
        System.out.println("TIPO DE CONDICION TRIBUTARIA: " + tipo);
    }
    
}
