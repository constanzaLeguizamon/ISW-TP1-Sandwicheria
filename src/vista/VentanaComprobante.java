/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorSandwicheria;
import datos.Repositorio;
import static vista.VentanaComprobantes.jLCuit;
import static vista.VentanaComprobantes.jLDireccion;
import static vista.VentanaComprobantes.jLEmail;
import static vista.VentanaComprobantes.jLFacturado;
import static vista.VentanaComprobantes.jLFecha;
import static vista.VentanaComprobantes.jLHora;
import static vista.VentanaComprobantes.jLIngresosBrutos;
import static vista.VentanaComprobantes.jLInicioActividades;
import static vista.VentanaComprobantes.jLNombre;
import static vista.VentanaComprobantes.jLPtoVta;
import static vista.VentanaComprobantes.jLTelefono;
import static vista.VentanaComprobantes.jLTipoComprobante;

/**
 *
 * @author conty
 */
public class VentanaComprobante {
    public static void PanelInfoFac(){
        jLTipoComprobante.setText(VentanaPedido.tipocomprobante);
        jLFacturado.setText("Supervisor");
        jLFecha.setText(ControladorSandwicheria.ObtenerFecha());
        jLHora.setText(ControladorSandwicheria.ObtenerHora());
        jLPtoVta.setText(Repositorio.pto1.getPtovta());
    }
    
    public static void PanelInfoNeg(){
        jLNombre.setText(Repositorio.n1.getNombre());
        jLDireccion.setText(Repositorio.n1.getDireccion());
        jLCuit.setText(Integer.toString(Repositorio.n1.getCUIT()));
        jLIngresosBrutos.setText(Repositorio.n1.getIngresosbrutos());
        jLTelefono.setText(Repositorio.n1.getTelefono());
        jLEmail.setText(Repositorio.n1.getEmail());
        jLInicioActividades.setText(Repositorio.n1.getInicioactividades());
    }
}
