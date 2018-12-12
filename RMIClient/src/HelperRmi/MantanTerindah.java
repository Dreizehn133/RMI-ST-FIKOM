/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperRmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Dreizehn
 */
public interface MantanTerindah extends Remote{
    public List<Baper> getFromDb() throws RemoteException;
    public boolean insertToDb(Baper model) throws RemoteException;
    public boolean updateToDb(Baper model) throws RemoteException;
    public boolean deleteToDb(Baper model) throws RemoteException;
    
}
