package rmicomum;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface calculadora extends Remote{
    public int soma(int a, int b)throws RemoteException;
    
    public int subtracao(int a, int b)throws RemoteException;
    
    public int multipli(int a, int b)throws RemoteException;
    
    public int divisao(int a, int b)throws RemoteException;
}