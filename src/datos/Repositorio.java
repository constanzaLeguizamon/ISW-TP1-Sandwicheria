/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import modelo.Cajero;
import modelo.Cliente;
import modelo.CondicionTributaria;
import modelo.Ingredientes;
import modelo.Negocio;
import modelo.PDV1;
import modelo.Producto;
import modelo.Rubro;
import modelo.TipoComprobante;
import modelo.TipoDoc;
import modelo.Turno;
import vista.VentanaPedido;

/**
 *
 * @author conty
 */
public class Repositorio {
    public static CondicionTributaria cond1 = new CondicionTributaria("Consumidor Final",0);
    public static CondicionTributaria cond2 = new CondicionTributaria("Responsable Inscripto",0);
    public static CondicionTributaria cond3 = new CondicionTributaria("Monotributista",0);
    public static CondicionTributaria cond4 = new CondicionTributaria("Exento",0);
    public static CondicionTributaria cond5 = new CondicionTributaria("No Responsable",0);
    
    public static Negocio n1 = new Negocio(123456,0,"La Sandwicheria","Av. San Martin 200 - San Andrés","4915608","913-506850-1","11/05/2005","lasandwicheria@gmail.com","La Sandwicheria S.R.L");
    
    public static PDV1 pto1 = new PDV1("0001");
    
    public static Rubro r1 = new Rubro("SANDWICHES");
    public static Rubro r2 = new Rubro("BEBIDAS");
    
    public static Turno t1 = new Turno("Mañana","10:00","17:00",0);
    public static Turno t2 = new Turno("Noche","17:00","01:00",0);
    
    public static Cajero c1 = new Cajero(43678,13000,t1,"1234","Carrizo Luciana","21 años","05 de Junio de 1997","Barrio 115 Viv. San Andrés");
    public static Cajero c2 = new Cajero(43677,13000,t2,"1234","Martinez Jose Luis","25 años","10 de Agosto de 1995","Las Talitas Tafí Viejo");
    
    public static TipoDoc tipo1 = new TipoDoc(96);
    
    public static Cliente cli1 = new Cliente(201111111,tipo1,cond1,"","","","");
    
    public static Producto p1 = new Producto("P10","SANDWICH DE MILANESA",80,100,"SANDWICH",0);
    public static Producto p2 = new Producto("P11","HAMBURGUESA",70,100,"SANDWICH",0);
    public static Producto p3 = new Producto("P12","SANDWICH DE POLLO",75,50,"SANDWICH",0);
    public static Producto p4 = new Producto("P13","GASEOSA",40,30,"BEBIDA",0);
    public static Producto p5 = new Producto("P14","JUGO",25,25,"BEBIDA",0);
    public static Producto p6 = new Producto("P15","AGUA MINERAL",30,20,"BEBIDA",0);
    public static Producto p7 = new Producto("P16","AGUA GASIFICADA",35,20,"BEBIDA",0);
    public static Producto p8 = new Producto("P17","CERVEZA",45,30,"BEBIDA",0);
    
    //SI ES POR DEFECTO, POR DEFECTO = 0, SI ES AGREGADO PARA CUALQUIER TIPO DE SANDWICH, GENERAL = 1,
    //SI ES UN AGREGADO ESPECIFICO DE UN TIPO DE SANDWICH, ESPECIFICO = CUP DEL SANDWICH AL QUE PERTENECE
    //LOS INGREDIENTES POR DEFECTO POR EJEMPLO PAN MILANESA U OTRO = 2
    
    public static Ingredientes a1 = new Ingredientes("I10","TOMATE",0,"POR DEFECTO",0);
    public static Ingredientes a2 = new Ingredientes("I11","LECHUGA",0,"POR DEFECTO",0);
    public static Ingredientes a3 = new Ingredientes("I12","MAYONESA",0,"POR DEFECTO",0);
    public static Ingredientes a4 = new Ingredientes("I13","MOSTAZA",0,"POR DEFECTO",0);
    public static Ingredientes a5 = new Ingredientes("I14","JAMON",20,"AGREGADO",1);
    public static Ingredientes a6 = new Ingredientes("I15","QUESO",20,"AGREGADO",1);
    public static Ingredientes a7 = new Ingredientes("I16","HUEVO",20,"AGREGADO",1);
    public static Ingredientes a8 = new Ingredientes("I17","CEBOLLA",20,"AGREGADO",1);
    public static Ingredientes a9 = new Ingredientes("I18","PICANTE",20,"AGREGADO",1);
    public static Ingredientes a10 = new Ingredientes("I19","CHEDAR",20,"AGREGADO",11);
    public static Ingredientes a11 = new Ingredientes("I20","BACON",20,"AGREGADO",11);
    public static Ingredientes a12 = new Ingredientes("I21","PEPINO",20,"AGREGADO",11);
    public static Ingredientes a13 = new Ingredientes("I22","SALSA DE QUESO",20,"AGREGADO",11);
    public static Ingredientes a14 = new Ingredientes("I23","PAN",0,"POR DEFECTO",2);
    public static Ingredientes a15 = new Ingredientes("I24","PAN HAMBURGUESA",0,"POR DEFECTO",2);
    public static Ingredientes a16 = new Ingredientes("I25","MILANESA",0,"POR DEFECTO",2);
    public static Ingredientes a17 = new Ingredientes("I26","HAMBURGUESA",0,"POR DEFECTO",2);
    public static Ingredientes a18 = new Ingredientes("I27","POLLO",0,"POR DEFECTO",2);
    
    public static void agregarProductoalRubro(){
        for(int i = 0; i < n1.getProductos().size(); i++){
            Producto producto = n1.getProductos().get(i);
            if(producto.getDescripcion().equals("SANDWICH")){
                r1.agregarProducto(producto);
            }
            if(producto.getDescripcion().equals("BEBIDA")){
                r2.agregarProducto(producto);
            }
        }
    }
    
    public static void agregarCajerosNeg(){
        n1.agregarCajero(c1);
        n1.agregarCajero(c2);
    }
    
    public static void agregarProducIngreNeg(){
        n1.agregarProducto(p1);
        n1.agregarProducto(p2);
        n1.agregarProducto(p3);
        n1.agregarProducto(p4);
        n1.agregarProducto(p5);
        n1.agregarProducto(p6);
        n1.agregarProducto(p7);
        n1.agregarProducto(p8);
        
        n1.agregarIngredientes(a1);
        n1.agregarIngredientes(a2);
        n1.agregarIngredientes(a3);
        n1.agregarIngredientes(a4);
        n1.agregarIngredientes(a5);
        n1.agregarIngredientes(a6);
        n1.agregarIngredientes(a7);
        n1.agregarIngredientes(a8);
        n1.agregarIngredientes(a9);
        n1.agregarIngredientes(a10);
        n1.agregarIngredientes(a11);
        n1.agregarIngredientes(a12);
        n1.agregarIngredientes(a13);
        n1.agregarIngredientes(a14);
        n1.agregarIngredientes(a15);
        n1.agregarIngredientes(a16);
        n1.agregarIngredientes(a17);
        n1.agregarIngredientes(a18);
    }
    
    public static void agregarCondTribNeg(){
        n1.agregarCondicionTrib(cond2);
        n1.agregarCondicionTrib(cond3);
        n1.agregarCondicionTrib(cond4);
        n1.agregarCondicionTrib(cond5);
    }
    
    public static TipoComprobante tipoCbte1 = new TipoComprobante(VentanaPedido.CbteTipo);
    
    public static boolean listadodeProductosconAgregados(String CUPProd){
        boolean resultado = false;
        for(int i =0; i < n1.getProductos().size(); i++){
            Producto prod = n1.getProductos().get(i);
            if(prod.getCUP().equals(CUPProd)){
                if(prod.getNombre().equals("SANDWICH DE MILANESA")){
                    resultado = false;
                }
                if(prod.getNombre().equals("SANDWICH DE POLLO")){
                    resultado = false;
                }
                if(prod.getNombre().equals("HAMBURGUESA")){
                    resultado = true;
                }
                if(prod.getNombre().equals("GASEOSA")){
                    resultado = false;
                }
                if(prod.getNombre().equals("JUGO")){
                    resultado = false;
                }
                if(prod.getNombre().equals("AGUA MINERAL")){
                    resultado = false;
                }
                if(prod.getNombre().equals("AGUA GASIFICADA")){
                    resultado = false;
                }
                if(prod.getNombre().equals("CERVEZA")){
                    resultado = false;
                }
            }
        }
        return (resultado);
    }
}
