/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Konfigurasi;

import Model.jrsModel;
import Model.mhsModel;
import Model.smsModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RPL9
 */
public class Helper {
    
    private static Connection con = koneksi.getKoneksi();
    public static void InputMahasiswa(mhsModel model){
        try {
            String QUERY = "INSERT INTO mahasiswa (nis,nama,jenis_kelamin,tanggal_lahir,IPK,alamat,id_jurusan,id_semester) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement statment = con.prepareStatement(QUERY);
            statment.setInt(1,model.getNis());
            statment.setString(2, model.getNama());
            statment.setString(3, model.getJenis_kelamin());
            statment.setString(4, model.getLahir());
            statment.setInt(5, model.getIpk());
            statment.setString(6, model.getAlamat());
            statment.setString(7, model.getId_jurusan());
            statment.setString(8, model.getId_semester());
            statment.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public static void InputJurusan(jrsModel model){
        try {
            String QUERY = "INSERT INTO jurusan (id_jurusan,nama_jurusan) VALUES (?,?)";
            PreparedStatement stm = con.prepareStatement(QUERY);
            stm.setString(1, model.getId_jurusan());
            stm.setString(2, model.getNama_jurusan());
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public static void HapusJurusan(jrsModel model){
        try {
            String QUERY = "DELETE FROM jurusan WHERE id_jurusan = ?";
            PreparedStatement hapus = con.prepareStatement(QUERY);
            hapus.setString(1, model.getOlid_jurusan());
            hapus.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public static void EditJurusan(jrsModel model){
        try {
            String SQL = "UPDATE jurusan SET id_jurusan = ?, nama_jurusan = ? WHERE id_jurusan = ?";
            PreparedStatement delet = con.prepareStatement(SQL);
            delet.setString(1, model.getId_jurusan());
            delet.setString(2, model.getNama_jurusan());
            delet.setString(3, model.getOlid_jurusan());
            delet.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public static void InputSemester(smsModel model){
        try {
            String QUERY = "INSERT INTO semester (id_semester,nama_semester) VALUES (?,?)";
            PreparedStatement stm = con.prepareStatement(QUERY);
            stm.setString(1, model.getId_semester());
            stm.setString(2, model.getNama_semester());
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public static void EditSemester(smsModel model){
        try {
            String QUERY = "UPDATE semester SET id_semester = ?,nama_semester = ? WHERE id_semester = ?";
            PreparedStatement stm = con.prepareStatement(QUERY);
            stm.setString(1, model.getOldid_semester());
            stm.setString(3, model.getId_semester());
            stm.setString(2, model.getNama_semester());
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public static void HapusSemester(String id){
        try {
            String SQL = "DELETE FROM semester WHERE id_semester = ?";
            PreparedStatement stat = con.prepareStatement(SQL);
            stat.setString(1, id);
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public static void EditMahasiswa(mhsModel model){
        try {
            String QUERY = "UPDATE mahasiswa SET nis = ?,nama = ?,jenis_kelamin = ?,tanggal_lahir = ?,IPK = ?,alamat = ?,id_jurusan = ?,id_semester = ? WHERE nis = ?";
            PreparedStatement yolo = con.prepareStatement(QUERY);
            yolo.setInt(1, model.getNis());
            yolo.setString(2, model.getNama());;
            yolo.setString(3, model.getJenis_kelamin());
            yolo.setString(4, model.getLahir());
            yolo.setInt(5, model.getIpk());
            yolo.setString(6, model.getAlamat());
            yolo.setString(7, model.getId_jurusan());
            yolo.setString(8, model.getId_semester());
            yolo.setInt(9, model.getOldnis());
            yolo.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public static void HapusMahasiswa(int nis){
        try {
            String QUERY = "DELETE FROM mahasiswa WHERE nis = ?";
            PreparedStatement fuck = con.prepareStatement(QUERY);
            fuck.setInt(1, nis);
            fuck.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
