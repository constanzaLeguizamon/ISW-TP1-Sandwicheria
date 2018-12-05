/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorSandwicheria;
import datos.Repositorio;
import static vista.VentanaLoguin.jLDireccion;
import static vista.VentanaLoguin.jLFecha;
import static vista.VentanaLoguin.jLHora;
import static vista.VentanaLoguin.jLNombre;
import static vista.VentanaLoguin.jLTelefono;

/**
 *
 * @author conty
 */
public class VentanaLog {
    public static void PanelInfoNegocio(){
        jLNombre.setText(Repositorio.n1.getNombre());
        jLDireccion.setText(Repositorio.n1.getDireccion());
        jLTelefono.setText(Repositorio.n1.getTelefono());
        jLFecha.setText(ControladorSandwicheria.ObtenerFecha());
        jLHora.setText(ControladorSandwicheria.ObtenerHora());
    }
}
