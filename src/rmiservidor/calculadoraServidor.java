
package rmiservidor;

import rmicomum.calculadoraImpl;
import java.rmi.Naming;
import rmicomum.calculadora;

public class calculadoraServidor {
    
    public calculadoraServidor(){
        try {
            calculadora m = new calculadoraImpl();
            Naming.rebind(calculadoraImpl.geturi(), m);
            
            
        } catch (Exception e) {
            System.out.println("Erro "+ e);
        }
    }
    
    public static void main(String[] args) {
        new calculadoraServidor();
    }
    
}