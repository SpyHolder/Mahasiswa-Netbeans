package Form;

import Konfigurasi.Helper;
import Konfigurasi.koneksi;
import Model.jrsModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormJurusan extends javax.swing.JFrame {

    Connection con = koneksi.getKoneksi();
    void TampilJurusan(){
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Jurusan");
            model.addColumn("Nama Jurusan");
            TBL_jurusan.setModel(model);
            Statement  statement = con.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM jurusan");
            while (result.next()) {            
                model.addRow(new Object[]{
                    result.getString("id_jurusan"),
                    result.getString("nama_jurusan")
                });
            }
            TBL_jurusan.getRowCount();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    void Clear(){
        lbl_oldIDJurusan.setText("");
        txt_kodeJurusan.setText("");
        txt_namaJurusan.setText("");
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM jurusan ORDER BY id_jurusan DESC");
            if (rs.next()) {
                String ID = rs.getString("id_jurusan").substring(2);
                String IDTambah = "" + (Integer.parseInt(ID) + 1);
                String Nol = "";

                if(IDTambah.length()==1)
                {Nol = "00";}
                else if(IDTambah.length()==2)
                {Nol = "0";}
                else if(IDTambah.length()==3)
                {Nol = "";}
                txt_kodeJurusan.setText("J-" + Nol + IDTambah);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
      txt_kodeJurusan.disable();
    }
    
    public FormJurusan() {
        initComponents();
        TampilJurusan();
        Clear();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_kodeJurusan = new javax.swing.JTextField();
        txt_namaJurusan = new javax.swing.JTextField();
        bt_Input = new javax.swing.JButton();
        btn_Hapus = new javax.swing.JButton();
        btn_Edit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_jurusan = new javax.swing.JTable();
        lbl_oldIDJurusan = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(585, 350));

        bt_Input.setText("Input");
        bt_Input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_InputActionPerformed(evt);
            }
        });

        btn_Hapus.setText("Hapus");
        btn_Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HapusActionPerformed(evt);
            }
        });

        btn_Edit.setText("Edit");
        btn_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditActionPerformed(evt);
            }
        });

        jLabel1.setText("ID Jurusan");

        jLabel2.setText("Nama Jurusan");

        TBL_jurusan.setModel(new javax.swing.table.DefaultTableModel(
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
        TBL_jurusan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBL_jurusanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBL_jurusan);

        lbl_oldIDJurusan.setForeground(new java.awt.Color(240, 240, 240));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/refresh.png"))); // NOI18N
        jButton1.setMaximumSize(new java.awt.Dimension(25, 25));
        jButton1.setMinimumSize(new java.awt.Dimension(25, 25));
        jButton1.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt_Input)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Edit)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Hapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_namaJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_kodeJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbl_oldIDJurusan)
                                        .addGap(149, 149, 149))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_kodeJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_oldIDJurusan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_namaJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_Input)
                            .addComponent(btn_Edit)
                            .addComponent(btn_Hapus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TBL_jurusanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_jurusanMouseClicked
        try {
            int baris = TBL_jurusan.getSelectedRow();
            txt_kodeJurusan.setText(TBL_jurusan.getValueAt(baris, 0).toString());
            lbl_oldIDJurusan.setText(TBL_jurusan.getValueAt(baris, 0).toString());
            txt_namaJurusan.setText(TBL_jurusan.getValueAt(baris, 1).toString());
            txt_kodeJurusan.enable();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_TBL_jurusanMouseClicked

    private void bt_InputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_InputActionPerformed
        try {
            if (txt_kodeJurusan.getText().equals("")||txt_namaJurusan.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Silahkan Melengkapi Data");
            }
            else {
                Statement sat = con.createStatement();
                ResultSet res = sat.executeQuery("SELECT * FROM `jurusan` WHERE id_jurusan = '"+txt_kodeJurusan.getText()+"'");
                if (res.next()) {
                    JOptionPane.showMessageDialog(null, "ID Jurusan ini sudah ada. Silahkan masukkan data yang berbeda!");
                } else {
                    jrsModel model = new jrsModel();
                    model.setId_jurusan(txt_kodeJurusan.getText());
                    model.setNama_jurusan(txt_namaJurusan.getText());
                    Helper.InputJurusan(model);
                    JOptionPane.showMessageDialog(null, "Data Berhasil Di Input");
                    TampilJurusan();
                    Clear();
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_bt_InputActionPerformed

    private void btn_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditActionPerformed
        try {
            if (txt_kodeJurusan.getText().equals("")||txt_namaJurusan.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Silahkan Melengkapi Data");
            }
            else {
                 if (lbl_oldIDJurusan.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Tidak ada data yang diedit");
                } else {
                   jrsModel model = new jrsModel();
                    model.setOlid_jurusan(lbl_oldIDJurusan.getText());
                    model.setId_jurusan(txt_kodeJurusan.getText());
                    model.setNama_jurusan(txt_namaJurusan.getText());
                    Helper.EditJurusan(model);
                    JOptionPane.showMessageDialog(null, "Data Berhasil Di Edit");
                    TampilJurusan();
                    Clear();      
                 }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_EditActionPerformed

    private void btn_HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HapusActionPerformed
        try {
            if (lbl_oldIDJurusan.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Tidak ada data yang terhapus");
            } else {
                jrsModel model = new jrsModel();
                model.setOlid_jurusan(txt_kodeJurusan.getText());
                Helper.HapusJurusan(model);
                JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
                TampilJurusan();
                Clear();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btn_HapusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Clear();
        TampilJurusan();
                
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormJurusan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TBL_jurusan;
    private javax.swing.JButton bt_Input;
    private javax.swing.JButton btn_Edit;
    private javax.swing.JButton btn_Hapus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_oldIDJurusan;
    private javax.swing.JTextField txt_kodeJurusan;
    private javax.swing.JTextField txt_namaJurusan;
    // End of variables declaration//GEN-END:variables
}
