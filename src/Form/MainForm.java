package Form;

import Konfigurasi.Helper;
import Konfigurasi.koneksi;
import Model.mhsModel;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;


public class MainForm extends javax.swing.JFrame {

    private String jenis,kode_Jcb,kode_Scb;
    private static Connection con = koneksi.getKoneksi();
    
    public void clear(){
        lbl_oldnis.setText("");
        txt_nis.setText("");
        txt_nama.setText("");
        jenis = "";
        buttonGroup1.clearSelection();
        txt_lahir.setText("");
        txt_alamat.setText("");
        txt_ipk.setText("");
        cb_jurusan.setSelectedItem("Pilih Jurusan");
        cb_semester.setSelectedIndex(0);
    }
    
    
    
    private void TampilData(){
        DefaultTableModel TableModel = new DefaultTableModel();
            TableModel.addColumn("NIS");
            TableModel.addColumn("Nama");
            TableModel.addColumn("Jenis Kelamin");
            TableModel.addColumn("Tanggal Lahir");
            TableModel.addColumn("Nilai IPK");
            TableModel.addColumn("Alamat");
            TableModel.addColumn("Jurusan");
            TableModel.addColumn("Semester");
            TBL_mahasiswa.setModel(TableModel);
             try {
                 Statement stm = con.createStatement();
                 String SQL = "CALL GetAllData()";
                 ResultSet res = stm.executeQuery(SQL);
                 while (res.next()) {
                     TableModel.addRow(new Object[]{
                         res.getString("nis"),
                         res.getString("nama"),
                         res.getString("jenis_kelamin"),
                         res.getString("tanggal_lahir"),
                         res.getString("IPK"),
                         res.getString("alamat"),
                         res.getString("nama_jurusan"),
                         res.getString("nama_semester")
                     });
                 }
            } catch (Exception e) {
                System.out.println(e);
            }
    }
    private void TampilDataComboBox(){
        try {
            Statement stm = con.createStatement();
            String QUERY1 = "SELECT * FROM jurusan";
            ResultSet set = stm.executeQuery(QUERY1);
            cb_jurusan.addItem("Pilih Jurusan");
            while (set.next()) {                
                cb_jurusan.addItem(set.getString("nama_jurusan"));
            }
            Statement stat = con.createStatement();
            String QUERY2 = "SELECT * FROM semester";
            ResultSet rs = stat.executeQuery(QUERY2);
            cb_semester.addItem("Pilih Semester");
            while (rs.next()) {                
                cb_semester.addItem(rs.getString("nama_semester"));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    private void DataCombo(){
        try {
            int index1 = cb_jurusan.getSelectedIndex();
            String indexJurusan = cb_jurusan.getItemAt(index1);
             Statement statment = con.createStatement();
                ResultSet result = statment.executeQuery("SELECT * FROM jurusan WHERE nama_jurusan = '" + indexJurusan + "'");
                while (result.next()) {                    
                    result.getString("id_jurusan").toString();
                }
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    
    public MainForm() {
        initComponents();
        TampilDataComboBox();
        TampilData();
        clear();
        if (jRadioButton1.getText()=="Laki-laki") {
            jenis = "Laki-laki";
        }
        else if (jRadioButton2.getText()=="Perempuan") {
            jenis = "Perempuan";
        }
//        try {
//            Statement stat = con.createStatement();
//            ResultSet set = stat.executeQuery("SELECT AVG(IPK) AS ipk FROM mahasiswa");
//            while (set.next()) {                
//                lblRata.setText(set.getString("ipk"));
//            }
//            
//        } catch (Exception ex){
//            System.out.println(ex.toString());
//        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txt_nis = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_lahir = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        cb_jurusan = new javax.swing.JComboBox<>();
        cb_semester = new javax.swing.JComboBox<>();
        btn_simpan = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_mahasiswa = new javax.swing.JTable();
        btn_jurusan = new javax.swing.JButton();
        btn_semester = new javax.swing.JButton();
        BTN_clear = new javax.swing.JButton();
        lbl_oldnis = new javax.swing.JLabel();
        btn_Grafik = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_alamat = new javax.swing.JTextArea();
        txt_ipk = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblRata = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_nis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nisActionPerformed(evt);
            }
        });
        txt_nis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nisKeyTyped(evt);
            }
        });

        jLabel1.setText("NIS");

        txt_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namaActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama");

        jLabel3.setText("Jenis Kelamin");

        jLabel4.setText("Tanggal Lahir");

        txt_lahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lahirActionPerformed(evt);
            }
        });

        jLabel5.setText("Alamat");

        jLabel6.setText("Jurusan");

        jLabel7.setText("Semester");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Laki-laki");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Perempuan");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        cb_jurusan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_jurusanMouseClicked(evt);
            }
        });

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        TBL_mahasiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TBL_mahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBL_mahasiswaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TBL_mahasiswaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TBL_mahasiswaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TBL_mahasiswaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TBL_mahasiswaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TBL_mahasiswa);

        btn_jurusan.setText("+");
        btn_jurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jurusanActionPerformed(evt);
            }
        });

        btn_semester.setText("+");
        btn_semester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_semesterActionPerformed(evt);
            }
        });

        BTN_clear.setText("Fresh");
        BTN_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_clearActionPerformed(evt);
            }
        });

        lbl_oldnis.setForeground(new java.awt.Color(240, 240, 240));
        lbl_oldnis.setText("jLabel8");
        lbl_oldnis.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btn_Grafik.setText("Grafik");
        btn_Grafik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GrafikActionPerformed(evt);
            }
        });

        txt_alamat.setColumns(10);
        txt_alamat.setRows(10);
        jScrollPane2.setViewportView(txt_alamat);

        jLabel8.setText("Nilai IPK");

        lblRata.setText("Rata-rata");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(btn_simpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_hapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BTN_clear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Grafik))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_lahir, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_nis, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jRadioButton1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jRadioButton2))
                                        .addComponent(txt_nama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_ipk, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblRata)))))
                        .addGap(244, 244, 244))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(cb_semester, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_semester))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cb_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_jurusan)))
                                .addGap(72, 72, 72))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbl_oldnis)
                                .addGap(114, 114, 114))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ipk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cb_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cb_semester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_semester, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addComponent(lbl_oldnis)
                        .addGap(16, 16, 16)
                        .addComponent(lblRata)))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Grafik, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_jurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jurusanActionPerformed
       new FormJurusan().setVisible(true);
    }//GEN-LAST:event_btn_jurusanActionPerformed

    private void btn_semesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_semesterActionPerformed
        new FormSemester().setVisible(true);
    }//GEN-LAST:event_btn_semesterActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        jenis = "Laki-laki";
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jenis = "Perempuan";
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        try {
            
            int index2 = cb_semester.getSelectedIndex();
            String indexSemester = cb_semester.getItemAt(index2);
            int index1 = cb_jurusan.getSelectedIndex();
            String indexJurusan = cb_jurusan.getItemAt(index1);
            
            String NIS = txt_nis.getText().toString();
            String NAMA = txt_nama.getText().toString();
            String LAHIR = txt_lahir.getText().toString();
            String ALAMAT = txt_alamat.getText().toString();
            String IPK = txt_ipk.getText().toString();
            
            
            
            Statement stm = con.createStatement();
            if (NIS.equals("")||NAMA.equals("")||LAHIR.equals("")||jenis.equals("")||IPK.equals("")||ALAMAT.equals("")||indexJurusan.equals("Pilih Jurusan")||indexSemester.equals("Pilih Semester")) {
                JOptionPane.showMessageDialog(null, "Silahkan Melengkapi Data Dengan Benar!");
            }
            else {
                mhsModel model = new mhsModel();
                model.setNis(Integer.parseInt(NIS));
                model.setNama(NAMA);
                model.setJenis_kelamin(jenis);
                model.setLahir(LAHIR);
                model.setAlamat(ALAMAT);
                model.setIpk(Integer.parseInt(IPK));
                
                Statement statment = con.createStatement();
                ResultSet result = statment.executeQuery("SELECT * FROM jurusan WHERE nama_jurusan = '" + indexJurusan + "'");
                while (result.next()) {                    
                    model.setId_jurusan(result.getString("id_jurusan").toString());
                }
                
                Statement statment2 = con.createStatement();
                ResultSet result2 = statment2.executeQuery("SELECT * FROM semester WHERE nama_semester = '" + indexSemester + "'");
                while (result2.next()) {                    
                    model.setId_semester(result2.getString("id_semester").toString());
                    
                }
                Helper.InputMahasiswa(model);
                JOptionPane.showMessageDialog(null, "Data Berhasil Di Simpan");
                TampilData();
                clear();
                
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void txt_nisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nisKeyTyped
        char enter=evt.getKeyChar();
        if(!(Character.isDigit(enter)))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nisKeyTyped

    private void TBL_mahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_mahasiswaMouseClicked
        int baris = TBL_mahasiswa.getSelectedRow();
        txt_nis.setText(TBL_mahasiswa.getValueAt(baris, 0).toString());
        lbl_oldnis.setText(TBL_mahasiswa.getValueAt(baris, 0).toString());
        txt_nama.setText(TBL_mahasiswa.getValueAt(baris, 1).toString());
        txt_ipk.setText(TBL_mahasiswa.getValueAt(baris, 4).toString());
        txt_alamat.setText(TBL_mahasiswa.getValueAt(baris, 5).toString());
        txt_lahir.setText(TBL_mahasiswa.getValueAt(baris, 3).toString());
        String jenis = TBL_mahasiswa.getValueAt(baris, 2).toString();
        if (jenis.equals("Laki-laki")) {
            jRadioButton1.setSelected(true);
        }
        else if(jenis.equals("Perempuan")){
            jRadioButton2.setSelected(true);
        }
        cb_jurusan.setSelectedItem(TBL_mahasiswa.getValueAt(baris, 6));
        cb_semester.setSelectedItem(TBL_mahasiswa.getValueAt(baris, 7));
    }//GEN-LAST:event_TBL_mahasiswaMouseClicked

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        if (lbl_oldnis.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tidak ada data yang dihapus");
        } else {
            try {
                int nis = Integer.parseInt(txt_nis.getText());
                Helper.HapusMahasiswa(nis);
                JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
                TampilData();
                clear();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void txt_nisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nisActionPerformed
        
    }//GEN-LAST:event_txt_nisActionPerformed

    private void txt_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namaActionPerformed

    private void txt_lahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lahirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lahirActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        if (lbl_oldnis.getText().equals("")||txt_nis.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tidak ada data yang diedit");
        } else {
            try {
                String jurusan = cb_jurusan.getItemAt(cb_jurusan.getSelectedIndex());
                String semester = cb_semester.getItemAt(cb_semester.getSelectedIndex());

                mhsModel model = new mhsModel();
                model.setOldnis(Integer.parseInt(lbl_oldnis.getText()));
                model.setNis(Integer.parseInt(txt_nis.getText()));
                model.setNama(txt_nama.getText());
                model.setJenis_kelamin(jenis);
                model.setLahir(txt_lahir.getText());
                model.setIpk(Integer.parseInt(txt_ipk.getText()));
                model.setAlamat(txt_alamat.getText());
                model.setIpk(Integer.parseInt(txt_ipk.getText().toString()));
                
                Statement tat = con.createStatement();
                ResultSet tet = tat.executeQuery("SELECT * FROM jurusan WHERE nama_jurusan = '"+jurusan+"'");
                while (tet.next()) {
                    model.setId_jurusan(tet.getString("id_jurusan"));
                }

                Statement tata = con.createStatement();
                ResultSet tete = tata.executeQuery("SELECT * FROM semester WHERE nama_semester = '"+semester+"'");
                while (tete.next()) {
                    model.setId_semester(tete.getString("id_semester"));
                }
                
                Helper.EditMahasiswa(model);
                JOptionPane.showMessageDialog(null, "Data Berhasil Di Edit");
                TampilData();
                clear();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void cb_jurusanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_jurusanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_jurusanMouseClicked

    private void BTN_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_clearActionPerformed
        clear();
        cb_jurusan.removeAllItems();
        cb_semester.removeAllItems();
        TampilDataComboBox();
        TampilData();
    }//GEN-LAST:event_BTN_clearActionPerformed

    private void btn_GrafikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GrafikActionPerformed
        try {
            DefaultCategoryDataset data = new DefaultCategoryDataset();
            Statement state = con.createStatement();
            ResultSet result = state.executeQuery("CALL TampilGrafik()");
            while (result.next()) {                
                data.setValue(Integer.parseInt(result.getString("Jurusan")), result.getString("nama_jurusan"), result.getString("nama_jurusan"));
            }
            JFreeChart chart = ChartFactory.createBarChart("Grafik Mahas    iswa", "Jurusan", "Jumlah siswa", data);
            ChartFrame frame  = new ChartFrame("Grafik Mahasiswa", chart);
            frame.setVisible(true);
            frame.setBounds(400, 100, 600, 500);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btn_GrafikActionPerformed

    private void TBL_mahasiswaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_mahasiswaMouseEntered
        JFileChooser pilihFile = new JFileChooser(System.getProperty("user.home"));
        pilihFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
        pilihFile.setFileFilter(new FileNameExtensionFilter("jpg|png|bmp", "jpg","png","bmp"));
        
        if (pilihFile.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
            File Tampung = pilihFile.getSelectedFile();
            ImageIcon IC = new ImageIcon(Tampung.toString());
            Image img = IC.getImage().getScaledInstance(txtPicture.getWidth(), txtPicture.getHeight(), Image.SCALE_DEFAULT);
            ImageIcon icon = new ImageIcon (img);
            txtPicture.setIcon(icon);
        }
    }//GEN-LAST:event_TBL_mahasiswaMouseEntered

    private void TBL_mahasiswaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_mahasiswaMousePressed
        try {
            DefaultCategoryDataset data = new DefaultCategoryDataset();
            Statement statment = con.createStatement();
            ResultSet hasilGrafik = statment.executeQuery("SELECT * FROM jurusan");
            while(hasilGrafik.next()){
                data.setValue(Integer.parseInt(hasilGrafik.getString("jumlah_mhs")), hasilGrafik.getString("nama_jurusan"), hasilGrafik.getString("nama_jurusan"));
            }
            JFreeChart chart = ChartFactory.createBarChart("Jumlah Mahasiswa Jurusan", "Jurusan", "Jumlah Mahasiswa", data);
            ChartFrame frame = new ChartFrame("Jumlah Mahasiswa Jurusan", chart);
            frame.setVisible(true);
            frame.setBounds(400,100,600,500);
        } catch (Exception ex){
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_TBL_mahasiswaMousePressed

    private void TBL_mahasiswaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_mahasiswaMouseExited
        
    }//GEN-LAST:event_TBL_mahasiswaMouseExited

    private void TBL_mahasiswaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_mahasiswaMouseReleased

    }//GEN-LAST:event_TBL_mahasiswaMouseReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_clear;
    private javax.swing.JTable TBL_mahasiswa;
    private javax.swing.JButton btn_Grafik;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_jurusan;
    private javax.swing.JButton btn_semester;
    private javax.swing.JButton btn_simpan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cb_jurusan;
    private javax.swing.JComboBox<String> cb_semester;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblRata;
    private javax.swing.JLabel lbl_oldnis;
    private javax.swing.JTextArea txt_alamat;
    private javax.swing.JTextField txt_ipk;
    private javax.swing.JTextField txt_lahir;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_nis;
    // End of variables declaration//GEN-END:variables
}
