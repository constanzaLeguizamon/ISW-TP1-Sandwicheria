/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.VentanaPedido;
import datos.Repositorio;
import static datos.Repositorio.listadodeProductosconAgregados;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cajero;
import modelo.Comprobante;
import modelo.Ingredientes;
import modelo.LineadePedido;
import modelo.Pedido;
import modelo.Producto;
import modelo.Turno;
import vista.VentanaComanda;
import vista.VentanaComandas;
import vista.VentanaComprobantes;
import static vista.VentanaLoguin.jPasswordField1;
import static vista.VentanaLoguin.jTextField3;
import vista.VentanaLoguin;
import static vista.VentanaPedido.IngredientesPorDefectoGenerales;
import static vista.VentanaPedido.IngredientesPorDefectoGeneralesEspe;
import vista.VentanaPedidos;
import vista.VentanaTurnos;
import static vista.VentanaPedido.IniciardeNuevo;
import static vista.VentanaPedido.OcultarBotonesBarraBaja;
import vista.VentanaTurno;


/**
 *
 * @author conty
 */
public class ControladorSandwicheria {
    
    static VentanaLoguin VentanaLog = new VentanaLoguin();
    static VentanaPedidos VentanaPed = new VentanaPedidos();
    static VentanaComandas VentanaCom = new VentanaComandas();
    static VentanaComprobantes VentanaCompr = new VentanaComprobantes();
    static VentanaTurnos VentanaTur = new VentanaTurnos();
    public static int controlarAgreg = 0;
    public static ArrayList<String[]> pasarDatosComanda = new ArrayList<String[]>();
    public static ArrayList<String[]> pasarDatosComprobante = new ArrayList<String[]>();
    public static double total;

    public static double getTotal() {
        return total;
    }

    public static void setTotal(double total) {
        ControladorSandwicheria.total = total;
    }
    
    public static void VentanaLoguin(){
        VentanaLog.setVisible(true);
        VentanaPed.setVisible(false);
        VentanaCom.setVisible(false);
        VentanaCompr.setVisible(false);
    }
    
    public static void VentanaPedido(){
        VentanaLog.setVisible(false);
        VentanaPed.setVisible(true);
        VentanaCom.setVisible(false);
        VentanaCompr.setVisible(false);
        Pedido pedido = new Pedido(NumPedido(),ObtenerFecha(),ObtenerHora(),0,0);
        VentanaPed.pedido = pedido;
    }
    
    public static void VentanaComanda(){
        VentanaLog.setVisible(false);
        VentanaPed.setVisible(false);
        VentanaCom.setVisible(true);
        VentanaCompr.setVisible(false);
    }
    
    public static void VentanaComprobante(){
        VentanaLog.setVisible(false);
        VentanaPed.setVisible(false);
        VentanaCom.setVisible(false);
        VentanaCompr.setVisible(true);
    }
    
    public static void VentanaTurno(){
        VentanaLog.setVisible(false);
        VentanaPed.setVisible(false);
        VentanaCom.setVisible(false);
        VentanaCompr.setVisible(false);
        VentanaTur.setVisible(true);
    }
    
    public static String ObtenerFecha(){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = dateFormat.format(date);
        return(fecha);
    }
    
    public static String ObtenerHora(){
        Date date = new Date();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        String hora = hourFormat.format(date);
        return(hora);
    }
    
    public static int ObtenerHoraTurno(){
        Date date = new Date();
        DateFormat hourFormatturno = new SimpleDateFormat("HH");
        String horatur = hourFormatturno.format(date);
        int horaTurno = Integer.parseInt(horatur);
        return(horaTurno);
    }
    
    public static int ObtenerMinutosTurno(){
        Date date = new Date();
        DateFormat hourFormatminutos = new SimpleDateFormat("mm");
        String horaminu = hourFormatminutos.format(date);
        int minutosTurno = Integer.parseInt(horaminu);
        return(minutosTurno);
    }
    
    public static void mostrarProductosDisponibles(DefaultTableModel datosInicio){
        ArrayList<Producto> producto = Repositorio.n1.getProductos();
        Object fila[] = new Object [4];
        for(int i = 0; i < producto.size(); i++){
            fila[0] = producto.get(i).getCUP();
            fila[1] = producto.get(i).getNombre();
            fila[2] = new Boolean(false);
            fila[3] = producto.get(i).getDescripcion();
            datosInicio.addRow(fila);
        }
    }
    public static int numPedido = 0;
    public static int NumPedido(){
        numPedido = numPedido + 1;
        return(numPedido);
    }
    
    public static int numComprobante = 0;
    public static int NumComprobante(){
        numComprobante = numComprobante + 1;
        return(numComprobante);
    }
    
    public static void PermitirAcceso(String usuario, String clave){
        //HORARIO DEL TURNO MAÑANA: TRAIGO LOS CAJEROS Y BUSCO EL CAJERO QUE TENGA EL TURNO DE LA MAÑANA
        //UNA VEZ IDENTIFICADO, SI EL USUARIO INGRESADO CORRESPONDE A SU NUM DE LEGAJO Y LA CONTRASEÑA ES LA CORRECTA, PASA
        if((ObtenerHoraTurno() == 10 && ObtenerMinutosTurno() == 00) || (ObtenerHoraTurno() == 10 && ObtenerMinutosTurno() > 00) || (ObtenerHoraTurno() > 10)){
            if(ObtenerHoraTurno() < 17 || (ObtenerHoraTurno() == 17 && ObtenerMinutosTurno() > 00)){
                for(int i = 0; i < Repositorio.n1.getCajero().size(); i++){
                    Cajero caj = Repositorio.n1.getCajero().get(i);
                    if(caj.getTur().getNombreturno().equals("Mañana")){
                        int leg = caj.getLegajo();
                        String legajo = Integer.toString(leg);
                        String contra = caj.getContraseña();
                        if(usuario.equals(legajo) && clave.equals(contra)){
                            VentanaPedido.PanelInfoCajero(caj);
                            VentanaComanda.PanelInfoCajero(caj);
                            VentanaTurno.PanelInfoCajero(caj);
                            VentanaPedido();
                            jTextField3.setText("");
                            jPasswordField1.setText("");
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Usuario o Clave incorrecta");
                            jTextField3.setText("");
                            jPasswordField1.setText("");
                        }
                    }
                }
            }
        }
        
        if((ObtenerHoraTurno() == 17 && ObtenerMinutosTurno() == 00) || (ObtenerHoraTurno() == 17 && ObtenerMinutosTurno() > 00) || (ObtenerHoraTurno() > 17)){
            if(ObtenerHoraTurno() < 24 || (ObtenerHoraTurno() == 24 && ObtenerMinutosTurno() > 00)){
                for(int i = 0; i < Repositorio.n1.getCajero().size(); i++){
                    Cajero caj = Repositorio.n1.getCajero().get(i);
                    if(caj.getTur().getNombreturno().equals("Noche")){
                        int leg = caj.getLegajo();
                        String legajo = Integer.toString(leg);
                        String contra = caj.getContraseña();
                        if(usuario.equals(legajo) && clave.equals(contra)){
                            VentanaPedido.PanelInfoCajero(caj);
                            VentanaComanda.PanelInfoCajero(caj);
                            VentanaTurno.PanelInfoCajero(caj);
                            VentanaPedido();
                            jTextField3.setText("");
                            jPasswordField1.setText("");
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Usuario o Clave incorrecta");
                            jTextField3.setText("");
                            jPasswordField1.setText("");
                        }
                    }
                }
            }
        }
    }
    
    public static String AñadirAgregados(int cont, String CUPProducto, DefaultTableModel datos1, DefaultTableModel datos2, DefaultTableModel datos3){
        controlarAgreg = controlarAgreg + 1;
        Producto p1 = null;
        String nombreTabla = "";
        
        if(cont == 1){
            p1 = IdentificarProducto(CUPProducto);
            if(p1.getDescripcion().equals("SANDWICH")){
                HabilitarAgregados(CUPProducto, datos1, datos2, datos3);
                if(listadodeProductosconAgregados(CUPProducto) == true){
                    nombreTabla = p1.getNombre();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "EL PRODUCTO SELECCIONADO NO TIENE AGREGADOS");
            }
        }
        
        if(cont == 0){
            JOptionPane.showMessageDialog(null, "NO SE HA SELECCIONADO UN PRODUCTO");
            controlarAgreg = 0;
        }
        
        if(cont > 1){
            JOptionPane.showMessageDialog(null, "NO SE PUEDE SELECCIONAR DOS PRODUCTOS");
            controlarAgreg = 0;
        }
        return(nombreTabla);
    }
    
    public static Producto IdentificarProducto(String CUPProducto){
        Producto p1 = null;
        for(int i = 0; i < Repositorio.n1.getProductos().size(); i++){
            if(Repositorio.n1.getProductos().get(i).getCUP().equals(CUPProducto)){
                p1 = Repositorio.n1.getProductos().get(i);
            }
        }
        return(p1);
    }
    
    public static void HabilitarAgregados(String CUP, DefaultTableModel datos1, DefaultTableModel datos2, DefaultTableModel datos3){
        if(listadodeProductosconAgregados(CUP) == true){
            IngredientesPorDefectoGeneralesEspe();//HABILITA LAS TABLAS PARA CARGAR LOS DATOS
            addRowIngredientesPorDefectoGenerales(datos1, datos2);//CARGA LOS DATOS DE LOS AGREGADOS POR DEFECTO Y GENERALES
            addRowIngredientesEspe(datos3); //CARGA LOS AGREGADOS DE LOS PROD PARTICULARES
        }
        if(listadodeProductosconAgregados(CUP) == false){
            IngredientesPorDefectoGenerales();
            addRowIngredientesPorDefectoGenerales(datos1, datos2);
        }
    }
    
    public static void addRowIngredientesPorDefectoGenerales(DefaultTableModel datos1, DefaultTableModel datos2){
        ArrayList<Ingredientes> ingre = Repositorio.n1.getIngredientes();
        for(int i = 0; i < ingre.size(); i++){
            if(ingre.get(i).getTipo() == 0){
                Object fila1[] = new Object[2];
                fila1[0] = ingre.get(i).getNombre();
                fila1[1] = new Boolean(true);
                datos1.addRow(fila1);
            }
            if(ingre.get(i).getTipo() == 1){
                Object fila2[] = new Object[2];
                fila2[0] = ingre.get(i).getNombre();
                fila2[1] = new Boolean(false);
                datos2.addRow(fila2);
            }
        }
    }
    
    public static void addRowIngredientesEspe(DefaultTableModel datos3){
        ArrayList<Ingredientes> ingre = Repositorio.n1.getIngredientes();
        for(int i = 0; i < ingre.size(); i++){
            if(ingre.get(i).getTipo() != 0 && ingre.get(i).getTipo() != 1 && ingre.get(i).getTipo() != 2){
                Object fila1[] = new Object[2];
                fila1[0] = ingre.get(i).getNombre();
                fila1[1] = new Boolean(false);
                datos3.addRow(fila1);
            }
        }
    }
    
    public static void addProductoADetalledePedido(int cont, int seleccionado, String CUPProducto, int cantidad, DefaultTableModel datosInicio, DefaultTableModel datos1, DefaultTableModel datos2, DefaultTableModel datos3, DefaultTableModel datos4, Pedido pedido){
        Object fila1[] = new Object[7];
        if(cont == 1){
            Producto p1 = new Producto(CUPProducto, nombredelProducto(CUPProducto), preciodelProducto(CUPProducto), stockdelProducto(CUPProducto), descripciondelProducto(CUPProducto),0);
            if(p1.getDescripcion().equals("SANDWICH")){
                if(controlarAgreg > 0){ //COMO ES UN SANDWICH DEBE TENER POR LO MENOS AGREGADOS POR DEFECTO, CON ESTA VARIABLE ME ASEGURO DE QUE EL EMPLEADO ALLA PASADO POR LOS AGREGADOS
                    String listaAgregado = IdentificarAgregado(p1, datos1, datos2, datos3);
                    double precioAgregado = p1.calcularPrecioAgregado();
                    double subtotal = p1.calcularPrecioSubtotal(precioAgregado,cantidad);
                    p1.setPreciodelProdconAgreg(subtotal);
                    pedido.agregar(p1);
                    
                    fila1[0] = p1.getCUP();
                    fila1[1] = cantidad;
                    fila1[2] = p1.getNombre();
                    fila1[3] = p1.getPrecio();
                    fila1[4] = listaAgregado;
                    fila1[5] = precioAgregado;
                    fila1[6] = subtotal;
                    datos4.addRow(fila1);
                    
                    total = pedido.calcularTotal();
                    
                    LineadePedido lineadePedido = new LineadePedido(p1.getCUP(),p1.getNombre(),cantidad,p1.getPrecio(),listaAgregado,subtotal);
                    pedido.agregarLineadePedido(lineadePedido);
                    pedido.setMontonetopedido(total);
                    pedido.setMontototalpedido(total);
                    
                    LimpiarTablas(datosInicio, datos1, datos2, datos3);
                }
                else{
                    JOptionPane.showMessageDialog(null, "NO TE OLVIDES DE LOS AGREGADOS");
                }
            }
            if(p1.getDescripcion().equals("BEBIDA")){
                double subtotal = p1.calcularPrecioSubtotal(0,cantidad);
                p1.setPreciodelProdconAgreg(subtotal);
                pedido.agregar(p1);
                
                fila1[0] = p1.getCUP();
                fila1[1] = cantidad;
                fila1[2] = p1.getNombre();
                fila1[3] = p1.getPrecio();
                fila1[4] = "--";
                fila1[5] = "--";
                fila1[6] = subtotal;
                datos4.addRow(fila1);
                
                total = pedido.calcularTotal();
                
                LineadePedido lineadePedido = new LineadePedido(p1.getCUP(),p1.getNombre(),cantidad,p1.getPrecio(),"",subtotal);
                pedido.agregarLineadePedido(lineadePedido);
                pedido.setMontonetopedido(total);
                pedido.setMontototalpedido(total);
                
                LimpiarTablas(datosInicio, datos1, datos2, datos3);
            }
        }
        if(cont>1){
            JOptionPane.showMessageDialog(null, "NO SE PUEDEN SELECCIONAR DOS PRODUCTO");
        }
        if(cont==0){
            JOptionPane.showMessageDialog(null, "NO SE HA SELECCIONADO NINGUN PRODUCTO");
        }
        controlarAgreg = 0;
    }
    
    public static String IdentificarAgregado(Producto producto1, DefaultTableModel datos1, DefaultTableModel datos2, DefaultTableModel datos3){
        String agregado = "";
        Boolean checked = false;
        for(int i = 0; i < datos1.getRowCount(); i++){
            checked = Boolean.valueOf(datos1.getValueAt(i,1).toString());
            if(checked){
                String nombreAgregado = String.valueOf(datos1.getValueAt(i,0));
                agregado = agregado + nombreAgregado + "-";//VA FORMANDO UN SATRING CON TODOS LOS AGREGADOS (DE LAS 3 TABLAS)
                Producto.AgregarAgregadosAlProducto(producto1,nombreAgregado);//VOY AGREGANDO LOS AGREGADOS PARA LUEGO CALCULAR EL PRECIO TOTAL DE LOS AGREGADOS
                
            }
        }
        
        Boolean checked2 = false;
        for(int i = 0; i < datos2.getRowCount(); i++){
            checked2 = Boolean.valueOf(datos2.getValueAt(i,1).toString());
            if(checked2){
                String nombreAgregado2 = String.valueOf(datos2.getValueAt(i,0));
                agregado = agregado + nombreAgregado2 + "-";
                Producto.AgregarAgregadosAlProducto(producto1,nombreAgregado2);
            }
        }
        
        Boolean checked3 = false;
        for(int i = 0; i < datos3.getRowCount(); i++){
            checked3 = Boolean.valueOf(datos3.getValueAt(i,1).toString());
            if(checked3){
                String nombreAgregado3 = String.valueOf(datos3.getValueAt(i,0));
                agregado = agregado + nombreAgregado3 + "-";
                Producto.AgregarAgregadosAlProducto(producto1,nombreAgregado3);
            }
        }
        return(agregado);
    }
    
    public static void PasarDatosaDetalleComanda(DefaultTableModel datos, DefaultTableModel datosComanda){
        for(int i = 0; i < datos.getRowCount(); i++){
            String CUP = String.valueOf(datos.getValueAt(i,0));
            String cantidad = String.valueOf(datos.getValueAt(i,1));
            String nombreProducto = String.valueOf(datos.getValueAt(i,2));
            String agregados = String.valueOf(datos.getValueAt(i,4));
            String comanda[] = {CUP,cantidad,nombreProducto,agregados};
            pasarDatosComanda.add(comanda);
        }
        ArrayList <String[]> comanda = pasarDatosComanda;
        for(int i = 0; i < comanda.size(); i++){
            datosComanda.addRow(pasarDatosComanda.get(i));
        }
    }
    
    public static void PasarDatosaDetalleComprobante(DefaultTableModel datos, DefaultTableModel datosCompro){
        for(int i = 0; i < datos.getRowCount(); i++){
            String CUP = String.valueOf(datos.getValueAt(i,0));
            String cantidad = String.valueOf(datos.getValueAt(i,1));
            String nombreProducto = String.valueOf(datos.getValueAt(i,2));
            String agregados = String.valueOf(datos.getValueAt(i,4));
            String subtotal = String.valueOf(datos.getValueAt(i,6));
            String comprobante[] = {CUP,cantidad,nombreProducto,agregados,"0.0","0.00","0.00",subtotal};
            pasarDatosComprobante.add(comprobante);
        }
        ArrayList <String[]> comprobante = pasarDatosComprobante;
        for(int i = 0; i < comprobante.size(); i++){
            datosCompro.addRow(pasarDatosComprobante.get(i));
        }
    }
    
    public static void agregarDetalleaComprobante(Comprobante comp, DefaultTableModel datos){
        for(int i = 0; i < datos.getRowCount(); i++){
            String CUP = String.valueOf(datos.getValueAt(i,0));
            String cantidad = String.valueOf(datos.getValueAt(i,1));
            String nombreProducto = String.valueOf(datos.getValueAt(i,2));
            String agregados = String.valueOf(datos.getValueAt(i,4));
            String subtotal = String.valueOf(datos.getValueAt(i,7));
            String detalleComprobante = "CUP: " + CUP + " - " + "CANT: " + cantidad + " - " + 
                                "NOMPROD: " + nombreProducto + " - " + "AGREG: " + agregados + " - " +
                                "%ALIIVA: " + "0.0" + " - " + "%DESC: " + "0.0" + " - " +
                                "DESC: " + "0.0" + " - " + "SUBTOT: " + subtotal;
            comp.agregarStringDetalle(detalleComprobante);
        }
    }
    
    public static double EliminarConcepto(DefaultTableModel datos, int filaSeleccionada, Pedido pedido){
        if (filaSeleccionada<0) {
            JOptionPane.showMessageDialog(null, "NO HA SELECCIONADO NINGUN CONCEPTO");
        }
        else {
            for(int i = 0; i < pedido.getProd().size(); i++ ){
                if(filaSeleccionada == i){
                    pedido.getProd().remove(i);
                }
            }
            for(int i = 0; i < pedido.getLineadePedido().size(); i++){
                if(filaSeleccionada == i){
                    pedido.getLineadePedido().remove(i);
                }
            }
            total = pedido.calcularTotal();
            pedido.setMontonetopedido(total);
            pedido.setMontototalpedido(total);
            datos.removeRow(filaSeleccionada); 
            if(datos.getRowCount() == 0){
                OcultarBotonesBarraBaja();
            }
            JOptionPane.showMessageDialog(null, "EL CONCEPTO HA SIDO ELIMINADO");
        }
        return(total);
    }
    
    public static void LimpiarTablas(DefaultTableModel datosInicio, DefaultTableModel datos1, DefaultTableModel datos2, DefaultTableModel datos3){
        for (int i = 0; i < datosInicio.getRowCount(); i++) {
            datosInicio.removeRow(i);
            i-=1;
        }
        for (int i = 0; i < datos1.getRowCount(); i++) {
            datos1.removeRow(i);
            i-=1;
        }
        for (int i = 0; i < datos2.getRowCount(); i++) {
            datos2.removeRow(i);
            i-=1;
        }
        for (int i = 0; i < datos3.getRowCount(); i++) {
            datos3.removeRow(i);
            i-=1;
        }
        IniciardeNuevo();
        mostrarProductosDisponibles(datosInicio);
    }
    
    public static void CancelarPedido(Pedido pedido, DefaultTableModel datosInicio, DefaultTableModel datos1, DefaultTableModel datos2, DefaultTableModel datos3, DefaultTableModel datos4){
        for (int i = 0; i < datos4.getRowCount(); i++) {
            datos4.removeRow(i);
            i-=1;
        }
        LimpiarTablas(datosInicio, datos1, datos2, datos3);
        OcultarBotonesBarraBaja();
        pedido.getProd().clear();
        pedido.getLineadePedido().clear();
        pedido.setMontototalpedido(0);
        pedido.setMontonetopedido(0);
        total = 0;
    }
    
    public static void NuevoPedido(DefaultTableModel datosPedido, DefaultTableModel datosComanda, DefaultTableModel datosComprobante){
        for (int i = 0; i < datosPedido.getRowCount(); i++) {
            datosPedido.removeRow(i);
            i-=1;
        }
        for (int i = 0; i < datosComanda.getRowCount(); i++) {
            datosComanda.removeRow(i);
            i-=1;
        }
        for (int i = 0; i < datosComprobante.getRowCount(); i++) {
            datosComprobante.removeRow(i);
            i-=1;
        }
        total = 0;
        ControladorSandwicheria.pasarDatosComanda.clear();
        ControladorSandwicheria.pasarDatosComprobante.clear();
    }
    
    public static int ObtenerCantidadPedidos(){
        int cantidad = Turno.controlAcu;
        return(cantidad);
    }
    
    public static double ObtenerTotalPedido(){
        double total = Turno.totalPed;
        return(total);
    }
    
    public static String nombredelProducto(String CUPProd){
        Producto prod = null;
        String nombreProd = "";
        for(int i =0; i < Repositorio.n1.getProductos().size(); i++){
            prod = Repositorio.n1.getProductos().get(i);
            if(prod.getCUP().equals(CUPProd)){
                nombreProd = prod.getNombre();
            }
        }
        return(nombreProd);
    }
    
    public static double preciodelProducto(String CUPProd){
        Producto prod = null;
        double precio = 0;
        for(int i =0; i < Repositorio.n1.getProductos().size(); i++){
            prod = Repositorio.n1.getProductos().get(i);
            if(prod.getCUP().equals(CUPProd)){
                precio = prod.getPrecio();
            }
        }
        return(precio);
    }
    
    public static int stockdelProducto(String CUPProd){
        Producto prod = null;
        int stockProd = 0;
        for(int i =0; i < Repositorio.n1.getProductos().size(); i++){
            prod = Repositorio.n1.getProductos().get(i);
            if(prod.getCUP().equals(CUPProd)){
                stockProd = prod.getStock();
            }
        }
        return(stockProd);
    }
    
    public static String descripciondelProducto(String CUPProd){
        Producto prod = null;
        String descripcionProd = "";
        for(int i =0; i < Repositorio.n1.getProductos().size(); i++){
            prod = Repositorio.n1.getProductos().get(i);
            if(prod.getCUP().equals(CUPProd)){
                descripcionProd = prod.getDescripcion();
            }
        }
        return(descripcionProd);
    }
    
    public static int NuevoComprobante(double total){
        Comprobante comprobante = new Comprobante(NumComprobante(),ObtenerFecha(),ObtenerHora(),total);
        VentanaCompr.comp1 = comprobante;
        return(comprobante.getNumComprobante());
    }
}
