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
public class TipoDoc {
    private int codigoAfip;

    public TipoDoc(int codigoAfip) {
        this.codigoAfip = codigoAfip;
    }

    public int getCodigoAfip() {
        return codigoAfip;
    }

    public void setCodigoAfip(int codigoAfip) {
        this.codigoAfip = codigoAfip;
    }
}
