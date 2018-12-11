/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISWTP5Test;

import controlador.ControladorSandwicheria;
import java.util.ArrayList;
import modelo.Ingredientes;
import modelo.LineadePedido;
import modelo.Pedido;
import modelo.Producto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author conty
 */
public class PedidoIT {
    
    public PedidoIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    /**
     * Test of getHora method, of class Pedido.
     */
    @Test
    public void comprobarCalcularTotaldelPedidoCantidaddeProductosdelPedido1CantidaddelProductoEntre1Y3PreciodelosAgregadosEntre20Y40SubtotaldelProdcutoEntre40Y100() {
        Ingredientes a1 = new Ingredientes("I10","TOMATE",0,"POR DEFECTO",0);
        Ingredientes a2 = new Ingredientes("I11","LECHUGA",0,"POR DEFECTO",0);
        Ingredientes a3 = new Ingredientes("I12","MAYONESA",0,"POR DEFECTO",0);
        Ingredientes a4 = new Ingredientes("I13","MOSTAZA",0,"POR DEFECTO",0);
        Ingredientes a5 = new Ingredientes("I14","JAMON",20,"AGREGADO",1);
        Ingredientes a6 = new Ingredientes("I15","QUESO",20,"AGREGADO",1);
        Ingredientes a7 = new Ingredientes("I16","HUEVO",20,"AGREGADO",1);
        Ingredientes a8 = new Ingredientes("I18","PICANTE",20,"AGREGADO",1);
        
        Producto p1 = new Producto("P10","SANDWICH DE MILANESA",80,100,"SANDWICH",0);
        p1.agregar(a1);
        p1.agregar(a2);
        p1.agregar(a3);
        p1.agregar(a4);
        p1.agregar(a5);
        p1.agregar(a6);
        p1.agregar(a7);
        p1.agregar(a8);
        
        int cantidad = 1;
        double precioAgregados = p1.calcularPrecioAgregado();
        double subtotal = p1.calcularPrecioSubtotal(precioAgregados, cantidad);
        p1.setPreciodelProdconAgreg(subtotal);
        
        Pedido pedido = new Pedido(1234,ControladorSandwicheria.ObtenerFecha(),ControladorSandwicheria.ObtenerHora(),0,0);
        pedido.agregar(p1);
        
        double total = 0;
        
        //Ejecución
        total = pedido.calcularTotal();
        
        //Validación
        assertEquals(160, total, 0.01);
    }
    
    @Test
    public void comprobarCalcularTotaldelPedidoCantidaddeProductosdelPedido2CantidaddelProductoEntre1Y3PreciodelosAgregadosEntre20Y40SubtotaldelProdcutoEntre40Y300() {
        Ingredientes a1 = new Ingredientes("I10","TOMATE",0,"POR DEFECTO",0);
        Ingredientes a2 = new Ingredientes("I11","LECHUGA",0,"POR DEFECTO",0);
        Ingredientes a3 = new Ingredientes("I12","MAYONESA",0,"POR DEFECTO",0);
        Ingredientes a4 = new Ingredientes("I13","MOSTAZA",0,"POR DEFECTO",0);
        Ingredientes a5 = new Ingredientes("I14","JAMON",20,"AGREGADO",1);
        Ingredientes a6 = new Ingredientes("I15","QUESO",20,"AGREGADO",1);
        Ingredientes a7 = new Ingredientes("I16","HUEVO",20,"AGREGADO",1);
        Ingredientes a8 = new Ingredientes("I18","PICANTE",20,"AGREGADO",1);
        Ingredientes a10 = new Ingredientes("I19","CHEDAR",20,"AGREGADO",11);
        Ingredientes a11 = new Ingredientes("I20","BACON",20,"AGREGADO",11);
        Ingredientes a12 = new Ingredientes("I21","PEPINO",20,"AGREGADO",11);
        
        Producto p1 = new Producto("P10","SANDWICH DE MILANESA",80,100,"SANDWICH",0);
        Producto p2 = new Producto("P11","HAMBURGUESA",70,100,"SANDWICH",0);
        p1.agregar(a1);
        p1.agregar(a2);
        p1.agregar(a3);
        p1.agregar(a4);
        p1.agregar(a5);
        p1.agregar(a6);
        p1.agregar(a7);
        p1.agregar(a8);
        
        p2.agregar(a1);
        p2.agregar(a2);
        p2.agregar(a3);
        p2.agregar(a4);
        p2.agregar(a5);
        p2.agregar(a6);
        p2.agregar(a7);
        p2.agregar(a8);
        p2.agregar(a10);
        p2.agregar(a11);
        p2.agregar(a12);
        
        int cantidad1 = 1;
        double precioAgregados1 = p1.calcularPrecioAgregado();
        double subtotal1 = p1.calcularPrecioSubtotal(precioAgregados1, cantidad1);
        p1.setPreciodelProdconAgreg(subtotal1);
        
        int cantidad2 = 1;
        double precioAgregados2 = p2.calcularPrecioAgregado();
        double subtotal2 = p2.calcularPrecioSubtotal(precioAgregados2, cantidad2);
        p2.setPreciodelProdconAgreg(subtotal2);
        
        Pedido pedido = new Pedido(1234,ControladorSandwicheria.ObtenerFecha(),ControladorSandwicheria.ObtenerHora(),0,0);
        pedido.agregar(p1);
        pedido.agregar(p2);
        
        double total = 0;
        
        //Ejecución
        total = pedido.calcularTotal();
        
        //Validación
        assertEquals(370, total, 0.01);
    }
    
    @Test
    public void comprobarCalcularTotaldelPedidoCantidaddeProductosdelPedido2CantidaddelProductoEntre1Y3PreciodelosAgregados0SubtotaldelProdcutoEntre40Y200() {
        Ingredientes a1 = new Ingredientes("I10","TOMATE",0,"POR DEFECTO",0);
        Ingredientes a2 = new Ingredientes("I11","LECHUGA",0,"POR DEFECTO",0);
        Ingredientes a3 = new Ingredientes("I12","MAYONESA",0,"POR DEFECTO",0);
        Ingredientes a4 = new Ingredientes("I13","MOSTAZA",0,"POR DEFECTO",0);
        
        Producto p1 = new Producto("P10","SANDWICH DE MILANESA",80,100,"SANDWICH",0);
        Producto p2 = new Producto("P11","HAMBURGUESA",70,100,"SANDWICH",0);
        p1.agregar(a1);
        p1.agregar(a2);
        p1.agregar(a3);
        p1.agregar(a4);
        
        p2.agregar(a1);
        p2.agregar(a2);
        p2.agregar(a3);
        p2.agregar(a4);
        
        int cantidad1 = 2;
        double precioAgregados1 = p1.calcularPrecioAgregado();
        double subtotal1 = p1.calcularPrecioSubtotal(precioAgregados1, cantidad1);
        p1.setPreciodelProdconAgreg(subtotal1);
        
        int cantidad2 = 3;
        double precioAgregados2 = p2.calcularPrecioAgregado();
        double subtotal2 = p2.calcularPrecioSubtotal(precioAgregados2, cantidad2);
        p2.setPreciodelProdconAgreg(subtotal2);
        
        Pedido pedido = new Pedido(1234,ControladorSandwicheria.ObtenerFecha(),ControladorSandwicheria.ObtenerHora(),0,0);
        pedido.agregar(p1);
        pedido.agregar(p2);
        
        double total = 0;
        
        //Ejecución
        total = pedido.calcularTotal();
        
        //Validación
        assertEquals(370, total, 0.01);
    }
}
