/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorSandwicheria;
import datos.Repositorio;
import javax.swing.JOptionPane;
import modelo.Cajero;
import static vista.VentanaPedidos.jBAgregPed;
import static vista.VentanaPedidos.jBAgregados;
import static vista.VentanaPedidos.jBCambiar;
import static vista.VentanaPedidos.jBCancelar;
import static vista.VentanaPedidos.jBCancelarPedido;
import static vista.VentanaPedidos.jBContinuarComa;
import static vista.VentanaPedidos.jBEliminarConcepto;
import static vista.VentanaPedidos.jBFinalizarTurno;
import static vista.VentanaPedidos.jComboBox1;
import static vista.VentanaPedidos.jComboBox2;
import static vista.VentanaPedidos.jComboBox3;
import static vista.VentanaPedidos.jLConcepto;
import static vista.VentanaPedidos.jLCondTribuCliente;
import static vista.VentanaPedidos.jLCondTribuDueño;
import static vista.VentanaPedidos.jLDireccionNegocio;
import static vista.VentanaPedidos.jLFechaNegocio;
import static vista.VentanaPedidos.jLHoraNegocio;
import static vista.VentanaPedidos.jLLegajoCajero;
import static vista.VentanaPedidos.jLNombreCajero;
import static vista.VentanaPedidos.jLNombreNegocio;
import static vista.VentanaPedidos.jLTelefonoNegocio;
import static vista.VentanaPedidos.jLTituloAgregados;
import static vista.VentanaPedidos.jLTituloCantidad;
import static vista.VentanaPedidos.jLTituloGenerales;
import static vista.VentanaPedidos.jLTituloPorDefecto;
import static vista.VentanaPedidos.jLTituloProductos;
import static vista.VentanaPedidos.jLTituloSandwich;
import static vista.VentanaPedidos.jLTituloTotal;
import static vista.VentanaPedidos.jLTotal;
import static vista.VentanaPedidos.jLTurnoCajero;
import static vista.VentanaPedidos.jPanel4;
import static vista.VentanaPedidos.jPanel5;
import static vista.VentanaPedidos.jSpinner1;
import static vista.VentanaPedidos.jTAgregEspe;
import static vista.VentanaPedidos.jTAgregGene;
import static vista.VentanaPedidos.jTAgregPorDefec;
import static vista.VentanaPedidos.jTable1;

/**
 *
 * @author conty
 */
public class VentanaPedido {
    public static int CbteTipo = 0;
    public static String tipocomprobante;

    public static void IniciarPedido(){
        jPanel4.setEnabled(true);
        jLTituloProductos.setEnabled(true);
        jTable1.setEnabled(true);
        jBAgregPed.setEnabled(true);
        jBAgregados.setEnabled(true);
        
        jPanel5.setEnabled(false);
        jLTituloAgregados.setEnabled(false);
        jLTituloPorDefecto.setEnabled(false);
        jLTituloGenerales.setEnabled(false);
        jLTituloSandwich.setText("");
        jLTituloSandwich.setEnabled(false);
        jTAgregPorDefec.setEnabled(false);
        jTAgregGene.setEnabled(false);
        jTAgregEspe.setEnabled(false);
        jBCancelar.setEnabled(false);
        jLTituloCantidad.setEnabled(true);
        jSpinner1.setEnabled(true);
        jSpinner1.setValue(1);
        OcultarBotonesBarraBaja();
    }
    
    public static void IniciardeNuevo(){
        MostrarBotonesBarraBaja();
        jPanel4.setEnabled(true);
        jLTituloProductos.setEnabled(true);
        jTable1.setEnabled(true);
        jBAgregPed.setEnabled(true);
        jBAgregados.setEnabled(true);
        
        jPanel5.setEnabled(false);
        jLTituloAgregados.setEnabled(false);
        jLTituloPorDefecto.setEnabled(false);
        jLTituloGenerales.setEnabled(false);
        jLTituloSandwich.setText("");
        jLTituloSandwich.setEnabled(false);
        jTAgregPorDefec.setEnabled(false);
        jTAgregGene.setEnabled(false);
        jTAgregEspe.setEnabled(false);
        jBCancelar.setEnabled(false);
        jLTituloCantidad.setEnabled(true);
        jSpinner1.setEnabled(true);
        jSpinner1.setValue(1);
    }
    
    public static void PanelInfoNegocio(){
        jLNombreNegocio.setText(Repositorio.n1.getNombre());
        jLDireccionNegocio.setText(Repositorio.n1.getDireccion());
        jLTelefonoNegocio.setText(Repositorio.n1.getTelefono());
        jLFechaNegocio.setText(ControladorSandwicheria.ObtenerFecha());
        jLHoraNegocio.setText(ControladorSandwicheria.ObtenerHora());
    }
    
    public static void PanelInfoCajero(Cajero cajero){
        jLNombreCajero.setText(cajero.getApeynom());
        jLTurnoCajero.setText(cajero.getTur().getNombreturno());
        jLLegajoCajero.setText(Integer.toString(cajero.getLegajo()));
    }
    
    public static void PanelCondTrib(){
        jLCondTribuDueño.setEnabled(false);
        jLCondTribuCliente.setEnabled(false);
        jLConcepto.setEnabled(false);
        jComboBox2.setEnabled(false);
        jComboBox1.setEnabled(false);
        jComboBox3.setEnabled(false);
        jBCambiar.setEnabled(false);
        
        if(jComboBox1.getSelectedItem().toString().equals("MONOTRIBUTISTA") && (jComboBox2.getSelectedItem().toString().equals("RESPONSABLE INSCRIPTO"))){
            CbteTipo = 11;
            tipocomprobante = "Tipo Factura C";
        }
        
        if(jComboBox1.getSelectedItem().toString().equals("MONOTRIBUTISTA") && (jComboBox2.getSelectedItem().toString().equals("MONOTRIBUTISTA"))){
            CbteTipo = 11;
            tipocomprobante = "Tipo Factura C";
        }
        
        if(jComboBox1.getSelectedItem().toString().equals("MONOTRIBUTISTA") && (jComboBox2.getSelectedItem().toString().equals("EXENTO"))){
            CbteTipo = 11;
            tipocomprobante = "Tipo Factura C";
        }
        
        if(jComboBox1.getSelectedItem().toString().equals("MONOTRIBUTISTA") && (jComboBox2.getSelectedItem().toString().equals("NO RESPONSABLE"))){
            CbteTipo = 11;
            tipocomprobante = "Tipo Factura C";
        }
        
        if(jComboBox1.getSelectedItem().toString().equals("MONOTRIBUTISTA") && (jComboBox2.getSelectedItem().toString().equals("CONSUMIDOR FINAL"))){
            CbteTipo = 11;
            tipocomprobante = "Tipo Factura C";
        }
    }
    
    public static void CambiarCodTrib(){
        jLCondTribuDueño.setEnabled(true);
        jLCondTribuCliente.setEnabled(true);
        jLConcepto.setEnabled(true);
        jComboBox2.setEnabled(true);
        jComboBox1.setEnabled(true);
        jComboBox3.setEnabled(true);
    }
    
    public static void IngredientesPorDefectoGenerales(){
        jPanel4.setEnabled(false);
        jLTituloProductos.setEnabled(false);
        jTable1.setEnabled(false);
        jBAgregPed.setEnabled(true);
        jBAgregados.setEnabled(false);
        jLTituloCantidad.setEnabled(false);
        jSpinner1.setEnabled(false);
        
        jPanel5.setEnabled(true);
        jLTituloAgregados.setEnabled(true);
        jLTituloPorDefecto.setEnabled(true);
        jLTituloGenerales.setEnabled(true);
        jLTituloSandwich.setEnabled(false);
        jTAgregPorDefec.setEnabled(true);
        jTAgregGene.setEnabled(true);
        jTAgregEspe.setEnabled(false);
        jBCancelar.setEnabled(true);
    }
    
    public static void IngredientesPorDefectoGeneralesEspe(){
        jPanel4.setEnabled(false);
        jLTituloProductos.setEnabled(false);
        jTable1.setEnabled(false);
        jBAgregPed.setEnabled(true);
        jBAgregados.setEnabled(false);
        jLTituloCantidad.setEnabled(false);
        jSpinner1.setEnabled(false);
        
        jPanel5.setEnabled(true);
        jLTituloAgregados.setEnabled(true);
        jLTituloPorDefecto.setEnabled(true);
        jLTituloGenerales.setEnabled(true);
        jLTituloSandwich.setEnabled(true);
        jTAgregPorDefec.setEnabled(true);
        jTAgregGene.setEnabled(true);
        jTAgregEspe.setEnabled(true);
        jBCancelar.setEnabled(true);
    }
    
    public static void OcultarBotonesBarraBaja(){
        jLTituloTotal.setEnabled(false);
        jLTotal.setEnabled(false);
        jBEliminarConcepto.setEnabled(false);
        jBCancelarPedido.setEnabled(false);
        jBContinuarComa.setEnabled(false);
    }
    
    public static void MostrarBotonesBarraBaja(){
        jLTituloTotal.setEnabled(true);
        jLTotal.setEnabled(true);
        jBEliminarConcepto.setEnabled(true);
        jBCancelarPedido.setEnabled(true);
        jBContinuarComa.setEnabled(true);
    }
    
    public static void FinTurno(){
        //ES 17
        if(ControladorSandwicheria.ObtenerHoraTurno() == 12){
            JOptionPane.showMessageDialog(null, ControladorSandwicheria.ObtenerHoraTurno());
            jBFinalizarTurno.setEnabled(true);
        }
        
        else{
            if(ControladorSandwicheria.ObtenerHoraTurno() == 24){
                jBFinalizarTurno.setEnabled(true);
            }
            else{
                jBFinalizarTurno.setEnabled(false);
            }
        }
    }
}
