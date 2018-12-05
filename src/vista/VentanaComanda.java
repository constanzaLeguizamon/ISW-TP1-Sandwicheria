/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorSandwicheria;
import datos.Repositorio;
import modelo.Cajero;
import static vista.VentanaComandas.jLDireccionNeg;
import static vista.VentanaComandas.jLFechaNeg;
import static vista.VentanaComandas.jLHoraNeg;
import static vista.VentanaComandas.jLLegajoCaj;
import static vista.VentanaComandas.jLNombreCaj;
import static vista.VentanaComandas.jLNombreNeg;
import static vista.VentanaComandas.jLTelefonoNeg;
import static vista.VentanaComandas.jLTurnoCaj;

/**
 *
 * @author conty
 */
public class VentanaComanda {
    public static void PanelInfoNeg(){
        jLNombreNeg.setText(Repositorio.n1.getNombre());
        jLDireccionNeg.setText(Repositorio.n1.getDireccion());
        jLTelefonoNeg.setText(Repositorio.n1.getTelefono());
        jLFechaNeg.setText(ControladorSandwicheria.ObtenerFecha());
        jLHoraNeg.setText(ControladorSandwicheria.ObtenerHora());
    } 
    
    public static void PanelInfoCajero(Cajero cajero){
        jLNombreCaj.setText(cajero.getApeynom());
        jLTurnoCaj.setText(cajero.getTur().getNombreturno());
        jLLegajoCaj.setText(Integer.toString(cajero.getLegajo()));
    }
}
