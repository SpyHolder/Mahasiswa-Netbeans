/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Konfigurasi;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author RPL9
 */
public class koneksi {
    
    public static Connection getKoneksi(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_mhs","root","");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return con;
    }
    public static void main(String[] args) {
        try {
            Connection c = koneksi.getKoneksi();
            System.out.println(String.format("Connected to database %s " + "successfully.", c.getCatalog()));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
