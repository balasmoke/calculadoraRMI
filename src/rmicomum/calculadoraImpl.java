package rmicomum;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class calculadoraImpl extends UnicastRemoteObject implements calculadora{
    
    private static String SERVIDOR="localhost";
    private static Integer PORTA=1099;
    private static String SERVICO="mensageiro";
    
    private String msgRecebida="nenhuma mensagem";
    
    public static String geturi(){
        String uri = String.format("rmi://%s:%d/%s", SERVIDOR,PORTA,SERVICO);
        return uri;
    }
    
    public  calculadoraImpl()throws RemoteException{
        super();
    }
        
    public int soma(int a, int b) throws RemoteException {
        return a+b;
    }
    
    public int subtracao(int a, int b) throws RemoteException {
        return a-b;
    }

    public int multipli(int a, int b) throws RemoteException {
        return a*b;
    }
    
    public int divisao(int a, int b) throws RemoteException {
        return a/b;
    }
    
}