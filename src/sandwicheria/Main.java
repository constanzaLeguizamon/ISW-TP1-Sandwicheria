/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandwicheria;

import controlador.ControladorSandwicheria;

/**
 *
 * @author conty
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        ControladorSandwicheria.VentanaLoguin();
        
        /*String pasar = "6AE97CF5-67BD-42D4-B641-A9AB9922520B";
        Long cuit = solicitarAutorizacion(pasar).getCuit();
        JAXBElement<String> sign = solicitarAutorizacion(pasar).getSign();
        JAXBElement<String> token = solicitarAutorizacion(pasar).getToken();
        System.out.println("NOSE: "+cuit);
        System.out.println("NOSE: "+sign);
        System.out.println("NOSE: "+token);*/
    }

    private static Autorizacion solicitarAutorizacion(java.lang.String codigo) {
        sandwicheria.LoginService service = new sandwicheria.LoginService();
        sandwicheria.ILoginService port = service.getSGEAuthService();
        return port.solicitarAutorizacion(codigo);
    }
    
}
