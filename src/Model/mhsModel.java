/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author RPL9
 */
public class mhsModel {
    
    private int nis,oldnis,ipk;

    public int getIpk() {
        return ipk;
    }

    public void setIpk(int ipk) {
        this.ipk = ipk;
    }

    public int getOldnis() {
        return oldnis;
    }

    public void setOldnis(int oldnis) {
        this.oldnis = oldnis;
    }

    public String getId_jurusan() {
        return id_jurusan;
    }

    public void setId_jurusan(String id_jurusan) {
        this.id_jurusan = id_jurusan;
    }

    public String getId_semester() {
        return id_semester;
    }

    public void setId_semester(String id_semester) {
        this.id_semester = id_semester;
    }

    
    private String nama,jenis_kelamin,lahir,alamat,id_jurusan,id_semester;

    public int getNis() {
        return nis;
    }

    public void setNis(int nis) {
        this.nis = nis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getLahir() {
        return lahir;
    }

    public void setLahir(String lahir) {
        this.lahir = lahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
}
