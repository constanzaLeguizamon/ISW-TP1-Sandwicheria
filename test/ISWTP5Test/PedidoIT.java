/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISWTP5Test;

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
    public void testGetHora() {
        Ingredientes a1 = new Ingredientes("I10","TOMATE",0,"POR DEFECTO",0);
        Ingredientes a2 = new Ingredientes("I11","LECHUGA",0,"POR DEFECTO",0);
        Ingredientes a3 = new Ingredientes("I12","MAYONESA",0,"POR DEFECTO",0);
        Ingredientes a4 = new Ingredientes("I13","MOSTAZA",0,"POR DEFECTO",0);
        Ingredientes a5 = new Ingredientes("I14","JAMON",40,"AGREGADO",1);
        Ingredientes a6 = new Ingredientes("I15","QUESO",40,"AGREGADO",1);
        Ingredientes a7 = new Ingredientes("I16","HUEVO",20,"AGREGADO",1);
        Ingredientes a8 = new Ingredientes("I18","PICANTE",20,"AGREGADO",1);
        
        Producto p1 = new Producto("P10","SANDWICH DE MILANESA",80,100,"SANDWICH","NO");
        
        p1.agregar(a1);
        p1.agregar(a2);
        p1.agregar(a3);
        p1.agregar(a4);
        
        double precioAgregados = p1.calcularPrecioAgregado();
        int cantidad = 1;
        double subtotal = 0;
        
        subtotal = p1.calcularPrecioSubtotal(precioAgregados, cantidad);
        
        double total = 0;
        
        //Ejecución
        total = Pedido.calcularTotal(subtotal);
        
        //Validación
        assertEquals(80, subtotal, 0.01);
    }    
}
