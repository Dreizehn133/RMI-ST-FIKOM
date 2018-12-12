/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import HelperRmi.Baper;
import HelperRmi.MantanTerindah;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dreizehn
 */
public class OperasiCrud extends UnicastRemoteObject implements MantanTerindah{

    public OperasiCrud() throws RemoteException {
        koneksi();
    }

    
    
    Connection connection;
    private void koneksi(){
        String DB="jdbc:mysql://localhost/becek"; 
        String user="root";
        String pass="";
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = (Connection) DriverManager.getConnection(DB,user,pass);
            if(connection!=null){
                System.out.println("konek");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public List<Baper> getFromDb() throws RemoteException {
        List<Baper> data = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM baper");
            while(rs.next()){
                Baper laper = new Baper(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                  data.add(laper);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return data;
    }

    @Override
    public boolean insertToDb(Baper model) throws RemoteException {
        boolean value=false;
        String sql = "INSERT INTO baper VALUES (null,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, model.getNama());
            statement.setString(2, model.getAlamat());
            statement.setString(3, model.getStatus());
            int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    value=true;
                }else {
                    value=false;
                }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return value;
    }

    @Override
    public boolean updateToDb(Baper model) throws RemoteException {
        boolean value=false;
        String sql = "UPDATE baper SET nama=?, stb=?, status=? where id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, model.getNama());
            statement.setString(2, model.getAlamat());
            statement.setString(3, model.getStatus());
            statement.setInt(4, model.getId());
            int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    value=true;
                }else {
                    value=false;
                }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return value;
    }

    @Override
    public boolean deleteToDb(Baper model) throws RemoteException {
        boolean value=false;
        String sql = "DELETE FROM baper where id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, model.getId());
            int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    value=true;
                }else {
                    value=false;
                }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return value;
    }
}
