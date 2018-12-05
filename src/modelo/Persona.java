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
public class Persona {
    private String apeynom;
    private String edad;
    private String fechanaci;
    private String domicilio;

    public Persona(String apeynom, String edad, String fechanaci, String domicilio) {
        this.apeynom = apeynom;
        this.edad = edad;
        this.fechanaci = fechanaci;
        this.domicilio = domicilio;
    }

    public String getApeynom() {
        return apeynom;
    }

    public void setApeynom(String apeynom) {
        this.apeynom = apeynom;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getFechanaci() {
        return fechanaci;
    }

    public void setFechanaci(String fechanaci) {
        this.fechanaci = fechanaci;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public void mostrarPersona(){
        System.out.println("APELLIDO Y NOMBRE: " + apeynom);
        System.out.println("EDAD: " + edad);
        System.out.println("FECHA DE NACIMIENTO: " + fechanaci);
        System.out.println("DOMICILIO: " + domicilio);
    }
}
