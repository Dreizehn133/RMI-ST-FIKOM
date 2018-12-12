/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperRmi;

import java.io.Serializable;

/**
 *
 * @author Dreizehn
 */
public class Baper implements Serializable{
    int id;String nama, alamat, status;

    public Baper(int id, String nama, String alamat, String status) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getStatus() {
        return status;
    }
    
    

    
    
}
