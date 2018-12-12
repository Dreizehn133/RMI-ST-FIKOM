/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Dreizehn
 */
public class RMIServer {

    public static void main(String[] args) throws RemoteException {
        Registry reg = LocateRegistry.createRegistry(1402);
        reg.rebind("valentineIsShit", new OperasiCrud());
        System.out.println("Becek Is Run!!");
    }
    
}
