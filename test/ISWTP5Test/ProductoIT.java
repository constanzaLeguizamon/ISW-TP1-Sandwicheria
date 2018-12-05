/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISWTP5Test;

import java.util.ArrayList;
import modelo.Ingredientes;
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
public class ProductoIT {
    
    public ProductoIT() {
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
     * Test of getCUP method, of class Producto.
     */
    @Test
    public void comprobarCalcularPrecioAgregadoCantidaddeAgregadosEntre2Y4PreciodelosAgregadosEntre20y40() {
        //Configuración
        Ingredientes a1 = new Ingredientes("I10","TOMATE",20,"POR DEFECTO",0);
        Ingredientes a2 = new Ingredientes("I11","LECHUGA",20,"POR DEFECTO",0);
        Producto p1 = new Producto("P10","SANDWICH DE MILANESA",80,100,"SANDWICH","NO");
        p1.agregar(a1);
        p1.agregar(a2);
        double precioAgregados =0;
        
        //Ejecución
        precioAgregados = p1.calcularPrecioAgregado();
        
        //Validación
        assertEquals(40, precioAgregados, 0.01);
    }
    
    @Test
    public void comprobarCalcularPrecioAgregadoCantidaddeAgregadosEntre2Y8PreciodelosAgregadosEntre0y40() {
        //Configuración
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
        p1.agregar(a5);
        p1.agregar(a6);
        p1.agregar(a7);
        p1.agregar(a8);
        double precioAgregados =0;
        
        //Ejecución
        precioAgregados = p1.calcularPrecioAgregado();
        
        //Validación
        assertEquals(120, precioAgregados, 0.01);
    }
    
    @Test
    public void comprobarCalcularPrecioSubtotalValoresdelProdcutoEntre80Y100CantidaddeAgregadosEntre2Y4PreciodelosAgregadosEntre0y40() {
        //Configuración
        Ingredientes a1 = new Ingredientes("I10","TOMATE",20,"POR DEFECTO",0);
        Ingredientes a2 = new Ingredientes("I11","LECHUGA",20,"POR DEFECTO",0);
        Producto p1 = new Producto("P10","SANDWICH DE MILANESA",80,100,"SANDWICH","NO");
        p1.agregar(a1);
        p1.agregar(a2);
        double precioAgregados = p1.calcularPrecioAgregado();
        int cantidad = 2;
        double subtotal = 0;
        
        //Ejecución
        subtotal = p1.calcularPrecioSubtotal(precioAgregados, cantidad);
        
        //Validación
        assertEquals(240, subtotal, 0.01);
    }
    
    @Test
    public void comprobarCalcularPrecioSubtotalValoresdelProdcutoEntre80Y100CantidaddeAgregadosEntre2Y8PreciodelosAgregadosEntre0y40() {
        //Configuración
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
        p1.agregar(a5);
        p1.agregar(a6);
        p1.agregar(a7);
        p1.agregar(a8);
        
        double precioAgregados = p1.calcularPrecioAgregado();
        int cantidad = 1;
        double subtotal = 0;
        
        //Ejecución
        subtotal = p1.calcularPrecioSubtotal(precioAgregados, cantidad);
        
        //Validación
        assertEquals(200, subtotal, 0.01);
    }
}
