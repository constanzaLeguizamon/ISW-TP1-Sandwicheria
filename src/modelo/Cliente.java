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
public class Cliente extends Persona {
    private int numDoc;
    private CondicionTributaria cond;
    private TipoDoc tipodoc;
    ArrayList<Comprobante> comprobante = new ArrayList<Comprobante>();

    public Cliente(int numDoc, TipoDoc tipodoc, CondicionTributaria cond, String apeynom, String edad, String fechanaci, String domicilio) {
        super(apeynom, edad, fechanaci, domicilio);
        this.numDoc = numDoc;
        this.tipodoc = tipodoc;
        this.cond = cond;
    }

    public int getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(int numDoc) {
        this.numDoc = numDoc;
    }

    public TipoDoc getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(TipoDoc tipodoc) {
        this.tipodoc = tipodoc;
    }
    
    public CondicionTributaria getCond() {
        return cond;
    }

    public void setCond(CondicionTributaria cond) {
        this.cond = cond;
    }
    
    public ArrayList<Comprobante> getComprobante() {
        return comprobante;
    }

    public void setComprobante(ArrayList<Comprobante> comprobante) {
        this.comprobante = comprobante;
    }
    
    public void agregarComprobante(Comprobante c){
       comprobante.add(c);
    }
    
    public void mostrarComprobante(){
        for(int i = 0; i < comprobante.size(); i++){
            Comprobante c = comprobante.get(i);
        }
    }
    
    public void mostrarCliente(){
        System.out.println("NumDoc: " + numDoc);
        System.out.println("APELLIDO Y NOMBRE: " + getApeynom());
        System.out.println("Condicion tributaria: " + cond);
        
    }
}
