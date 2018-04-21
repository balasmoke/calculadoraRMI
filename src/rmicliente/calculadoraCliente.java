package rmicliente;


import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rmicomum.calculadoraImpl;
import rmicomum.calculadora;

public class calculadoraCliente {
    
    public static void main(String[] args) {
        try {
            // çria um calculadora baseado em uri
            calculadora m = (calculadora) Naming.lookup(calculadoraImpl.geturi() );
            //System.out.println(m.LerMensagem());
            if (args.length == 0) {
                String aux = JOptionPane.showInputDialog(null, "Digite a operação podendo ser uma:\n"
                        + "Soma\n"
                        + "Subtracao\n"
                        + "Multplicacao\n"
                        + "Divisao\n"
                        + "[Exemplo: 5+5]");
                String[] parse = aux.split("");
                int aux2 = new calculadoraCliente().verifi(parse[0], parse[2], parse[1], m);
                JOptionPane.showMessageDialog(null, "Resultado="+aux2);
            }else{
                String[] parse = args[0].split("");
                int aux = new calculadoraCliente().verifi(parse[0], parse[2], parse[1], m);
                JOptionPane.showMessageDialog(null, "Resultado="+aux);
                
            }
        } catch (MalformedURLException e) {
            System.out.println();
            System.out.println("MalformedUPLExçeption: "+ e.toString());
        } catch (RemoteException e){
            System.out.println();
            System.out.println("RemoteExçeption: "+e.toString());
        } catch (NotBoundException e){
            System.out.println();
            System.out.println("NotBoundExçeption: "+e.toString());
        } catch (Exception e){
            System.out.println();
            System.out.println("exçeption: "+e.toString());
        }
        
    }
    public int verifi(String a,String b, String op, calculadora m){
        int result =-1;
        try {
        
                switch(op){
                    case "+":
                        result = m.soma(Integer.parseInt(a), Integer.parseInt(b));
                        break;
                    case "-":
                        result = m.subtracao(Integer.parseInt(a), Integer.parseInt(b));
                        break;
                    case "*":
                        result = m.multipli(Integer.parseInt(a), Integer.parseInt(b));
                        break;
                    case "/":
                        result = m.divisao(Integer.parseInt(a), Integer.parseInt(b));
                        break;
                }
            
            } catch (RemoteException ex) {
                Logger.getLogger(calculadoraCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        return result; 
    }
}