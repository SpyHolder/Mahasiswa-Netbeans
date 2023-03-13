package Form;

import Konfigurasi.Helper;
import Konfigurasi.koneksi;
import Model.smsModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormSemester extends javax.swing.JFrame {

    Connection con = koneksi.getKoneksi();
    
    public void TampilSemester(){
        try {
            DefaultTableModel TableModel = new DefaultTableModel();
            TableModel.addColumn("ID Semester");
            TableModel.addColumn("Nama Semester");
            Tbl_semester.setModel(TableModel);
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM semester");
            while (res.next()) {                
                TableModel.addRow(new Object[]{
                    res.getString("id_semester"),
                    res.getString("nama_semester")
                });
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    void clear(){
        try {
            lbl_oldID.setText("");
            txt_kodeSemester.setText("");
            txt_namaSemester.setText("");
            txt_kodeSemester.disable();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM semester ORDER BY id_semester DESC");
            if (rs.next()) {
                String ID = rs.getString("id_semester").substring(2);
                String IDTambah = "" + (Integer.parseInt(ID) + 1);
                String Nol = "";

                if(IDTambah.length()==1)
                {Nol = "00";}
                else if(IDTambah.length()==2)
                {Nol = "0";}
                else if(IDTambah.length()==3)
                {Nol = "";}
                txt_kodeSemester.setText("S-" + Nol + IDTambah);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
    }
    
    public FormSemester() {
        initComponents();
        this.TampilSemester();
        clear();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_semester = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_kodeSemester = new javax.swing.JTextField();
        txt_namaSemester = new javax.swing.JTextField();
        BTN_inputSemester = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        lbl_oldID = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Tbl_semester.setModel(new javax.swing.table.DefaultTableModel(
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
        Tbl_semester.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tbl_semesterMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tbl_semester);

        jLabel1.setText("ID Semester");

        jLabel2.setText("Nama Semester");

        BTN_inputSemester.setText("Input");
        BTN_inputSemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_inputSemesterActionPerformed(evt);
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

        lbl_oldID.setForeground(new java.awt.Color(240, 240, 240));

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
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_kodeSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_namaSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BTN_inputSemester)
                                .addGap(7, 7, 7)
                                .addComponent(btn_edit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_hapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(219, 219, 219)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(lbl_oldID)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_kodeSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_oldID))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_namaSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTN_inputSemester)
                            .addComponent(btn_edit)
                            .addComponent(btn_hapus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       
    }//GEN-LAST:event_formWindowClosing

    private void BTN_inputSemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_inputSemesterActionPerformed
        try {
            if (txt_kodeSemester.getText().equals("")||txt_namaSemester.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Silahkan Melengkapi Data");
            }
            else {
                Statement sat = con.createStatement();
                ResultSet rees = sat.executeQuery("SELECT * FROM `semester` WHERE id_semester = '"+txt_kodeSemester.getText()+"'");
                if (rees.next()) {
                    JOptionPane.showMessageDialog(null, "ID Semester ini sudah ada. Silahkan masukkan data yang berbeda!");
                } else {
                    smsModel model = new smsModel();
                    model.setId_semester(txt_kodeSemester.getText());
                    model.setNama_semester(txt_namaSemester.getText());
                    Helper.InputSemester(model);
                    JOptionPane.showMessageDialog(null, "Data Berhasil Di Input");
                    TampilSemester();
                    clear();
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_BTN_inputSemesterActionPerformed

    private void Tbl_semesterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_semesterMouseClicked
        try {
            int baris = Tbl_semester.getSelectedRow();
            txt_kodeSemester.setText(Tbl_semester.getValueAt(baris, 0).toString());
            lbl_oldID.setText(Tbl_semester.getValueAt(baris, 0).toString());
            txt_namaSemester.setText(Tbl_semester.getValueAt(baris, 1).toString());
            txt_kodeSemester.enable();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_Tbl_semesterMouseClicked

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
            if (txt_kodeSemester.getText().equals("")||txt_namaSemester.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Silahkan Melengkapi Data");
            }
            else {
                if (lbl_oldID.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Tidak ada data yang diedit");
                } else {
                    smsModel model = new smsModel();
                    model.setOldid_semester(lbl_oldID.getText());
                    model.setId_semester(txt_kodeSemester.getText());
                    model.setNama_semester(txt_namaSemester.getText());
                    Helper.EditSemester(model);
                    JOptionPane.showMessageDialog(null, "Data Berhasil Diedit");
                    TampilSemester();
                    clear();
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try {
            if (lbl_oldID.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Tidak ada data yang dihapus");
            }
            else {
                Helper.HapusSemester(lbl_oldID.getText());
                JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
                TampilSemester();
                clear();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clear();
        TampilSemester();
    }//GEN-LAST:event_jButton1ActionPerformed

   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSemester().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_inputSemester;
    private javax.swing.JTable Tbl_semester;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_oldID;
    private javax.swing.JTextField txt_kodeSemester;
    private javax.swing.JTextField txt_namaSemester;
    // End of variables declaration//GEN-END:variables
}
