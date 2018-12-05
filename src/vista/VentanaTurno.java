/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorSandwicheria;
import datos.Repositorio;
import modelo.Cajero;
import static vista.VentanaTurnos.jLDireccion;
import static vista.VentanaTurnos.jLFecha;
import static vista.VentanaTurnos.jLHora;
import static vista.VentanaTurnos.jLHoraFinalizacion;
import static vista.VentanaTurnos.jLHoraInicio;
import static vista.VentanaTurnos.jLLegajoEmpleado;
import static vista.VentanaTurnos.jLNombre;
import static vista.VentanaTurnos.jLNombreEmpleado;
import static vista.VentanaTurnos.jLTelefono;
import static vista.VentanaTurnos.jLTurnoEmpleado;

/**
 *
 * @author conty
 */
public class VentanaTurno {
    public static void PanelInfoNeg(){
        jLNombre.setText(Repositorio.n1.getNombre());
        jLDireccion.setText(Repositorio.n1.getDireccion());
        jLTelefono.setText(Repositorio.n1.getTelefono());
        jLFecha.setText(ControladorSandwicheria.ObtenerFecha());
        jLHora.setText(ControladorSandwicheria.ObtenerHora());
    }
    
    public static void PanelInfoCajero(Cajero cajero){
        jLNombreEmpleado.setText(cajero.getApeynom());
        jLTurnoEmpleado.setText(cajero.getTur().getNombreturno());
        jLLegajoEmpleado.setText(Integer.toString(cajero.getLegajo()));
        jLHoraInicio.setText(cajero.getTur().getHorainicio());
        jLHoraFinalizacion.setText(cajero.getTur().getHorafinalizacion());
    }
}
