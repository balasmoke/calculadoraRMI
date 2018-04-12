package rmicliente;


import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.net.MalformedURLException;
import rmicomum.calculadoraImpl;
import rmicomum.calculadora;

public class calculadoraCliente {
    
    public static void main(String[] args) {
        try {
            // çria um calculadora baseado em uri
            calculadora m = (calculadora) Naming.lookup(calculadoraImpl.geturi() );
            //System.out.println(m.LerMensagem());
            if (args.length == 0) {
                System.out.println("sem mensagem");
            }else{
                String[] parse = args[0].split("");
                int result =-1;
                switch(parse[1]){
                    case "+":
                        result = m.soma(Integer.parseInt(parse[0]), Integer.parseInt(parse[2]));
                        break;
                    case "-":
                        result = m.subtracao(Integer.parseInt(parse[0]), Integer.parseInt(parse[2]));
                        break;
                    case "*":
                        result = m.multipli(Integer.parseInt(parse[0]), Integer.parseInt(parse[2]));
                        break;
                    case "/":
                        result = m.divisao(Integer.parseInt(parse[0]), Integer.parseInt(parse[2]));
                        break;
                }
                 System.out.println("resultado: "+ result );
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
}