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
public class Negocio {
    private int CUIT;
    private int concepto;
    private String nombre;
    private String direccion;
    private String telefono;
    private String ingresosbrutos;
    private String inicioactividades;
    private String email;
    private String razonsocial;
    ArrayList <Pedido> pedido = new ArrayList<Pedido>();
    ArrayList<Cajero> cajero = new ArrayList<Cajero>();
    ArrayList<Comprobante> comprobante = new ArrayList<Comprobante>();
    ArrayList<CondicionTributaria> condtrib = new ArrayList<CondicionTributaria>();
    ArrayList<String> stringPedidos = new ArrayList<String>();
    ArrayList<String> stringComprobantes = new ArrayList<String>();
    
    public static ArrayList<Producto> productos = new ArrayList<Producto>();
    public static ArrayList<Ingredientes> ingredientes = new ArrayList<Ingredientes>();

    public Negocio(int CUIT, int concepto, String nombre, String direccion, String telefono, String ingresosbrutos, String inicioactividades, String email, String razonsocial) {
        this.CUIT = CUIT;
        this.concepto = concepto;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ingresosbrutos = ingresosbrutos;
        this.inicioactividades = inicioactividades;
        this.email = email;
        this.razonsocial = razonsocial;
    }

    public int getCUIT() {
        return CUIT;
    }

    public void setCUIT(int CUIT) {
        this.CUIT = CUIT;
    }

    public int getConcepto() {
        return concepto;
    }

    public void setConcepto(int concepto) {
        this.concepto = concepto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(ArrayList<Pedido> pedido) {
        this.pedido = pedido;
    }

    public ArrayList<Cajero> getCajero() {
        return cajero;
    }

    public void setCajero(ArrayList<Cajero> cajero) {
        this.cajero = cajero;
    }

    public ArrayList<Comprobante> getComprobante() {
        return comprobante;
    }

    public void setComprobante(ArrayList<Comprobante> comprobante) {
        this.comprobante = comprobante;
    }

    public String getIngresosbrutos() {
        return ingresosbrutos;
    }

    public void setIngresosbrutos(String ingresosbrutos) {
        this.ingresosbrutos = ingresosbrutos;
    }

    public String getInicioactividades() {
        return inicioactividades;
    }

    public void setInicioactividades(String inicioactividades) {
        this.inicioactividades = inicioactividades;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }
    
    public ArrayList<CondicionTributaria> getCondtrib() {
        return condtrib;
    }

    public void setCondtrib(ArrayList<CondicionTributaria> condtrib) {
        this.condtrib = condtrib;
    }
    
    
    
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Ingredientes> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingredientes> ingredientes) {
        Negocio.ingredientes = ingredientes;
    }

    public ArrayList<String> getStringPedidos() {
        return stringPedidos;
    }

    public void setStringPedidos(ArrayList<String> stringPedidos) {
        this.stringPedidos = stringPedidos;
    }

    public ArrayList<String> getStringComprobantes() {
        return stringComprobantes;
    }

    public void setStringComprobantes(ArrayList<String> stringComprobantes) {
        this.stringComprobantes = stringComprobantes;
    }
    
    
    public void agregarPedido(Pedido p){
        pedido.add(p);
    }
    
    public void agregarCajero(Cajero caj){
        cajero.add(caj);
    }
    
    public void agregarFactura(Comprobante c){
        comprobante.add(c);
    }
    
    public void agregarCondicionTrib(CondicionTributaria cond){
        condtrib.add(cond);
    }
    
    public void agregarProducto(Producto prod){
        productos.add(prod);
    }
    
    public void agregarIngredientes(Ingredientes ing){
        ingredientes.add(ing);
    }
    
    public void agregarStringPedidos(String str){
        stringPedidos.add(str);
    }
    
    public void agregarStringCompr(String str){
        stringComprobantes.add(str);
    }
    
    
    public void mostrarCajero(){
        for(int i = 0; i < cajero.size(); i++){
            Cajero c = cajero.get(i);
            c.mostrarCajero();
        }
    }
    
    public void mostrarFactura(){
        for(int i = 0; i < comprobante.size(); i++){
            Comprobante c = comprobante.get(i);
        }
    }
    
    public int mostrarCondicionTributaria(int tipo){
        for(int i = 0; i < condtrib.size(); i++){
            CondicionTributaria c = condtrib.get(i);
            if(c.getTipo().equals("Monotributista")){
                tipo = 1;
            }
            
        }
        return(tipo);
    }
    
    public void mostrarProductos(){
        for(int i = 0; i < productos.size(); i++){
            Producto p = productos.get(i);
            p.mostrarProducto();
        }
    }
    
    public void mostrarIngredientes(){
        for(int i = 0; i < ingredientes.size(); i++){
            Ingredientes ing = ingredientes.get(i);
            ing.mostrarIngredientes();
        }
    }
    
    public int verificarIngredientes(String cod){//ERA EL ELSE!!!!!!!!!!!!!
        int confirmacion = 0;
        for(int i = 0; i < ingredientes.size(); i++){
            if(ingredientes.get(i).getCodigo().equals(cod)){
                confirmacion = 1;
            }
        }
        return(confirmacion);
    }
    
    public int verificarProducto(String cod){
        int confirmacion = 0;
        for(int i = 0; i < productos.size(); i++){
            if(productos.get(i).getCUP().equals(cod)){
                confirmacion = 1;
            }
        }
        return(confirmacion);
    }
    
    public void mostrarStringPedidos(){
        System.out.println("PEDIDOS");
        for(int i = 0; i < stringPedidos.size(); i++){
            System.out.println(stringPedidos.get(i));
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("");
        }
    }
    
    public void mostrarStringComprobantes(){
        System.out.println("COMPROBANTES");
        for(int i = 0; i < stringComprobantes.size(); i++){
            System.out.println(stringComprobantes.get(i));
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("");
        }
    }
    
    public void mostrarPedido(){
        for(int i = 0; i < pedido.size(); i++){
            Pedido p = pedido.get(i);
            p.mostrarPedido();
        }
    }
}
