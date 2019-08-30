package akademik;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FormTranskrip extends javax.swing.JFrame 
{
    Connection Con;
    Statement St;
    ResultSet RS;
    PreparedStatement PStm=null;
    String sql;
    private final JTable table=null;
    Koneksi KonekDb = new Koneksi();
 
    public FormTranskrip() 
    {
        initComponents();
        NonAktifObjek();
        KosongkanObjek();
        LoadComboBoxStb();
        LoadComboBoxKodeMatkul();
        TampilDataDalamTabel();
        
    }
private void KosongkanObjek()
    {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField9.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
    }
    private void NonAktifObjek()
    {
        jTextField1.enable(false);
        jTextField2.enable(false);
        jTextField9.enable(false);
    }
    
     private void LoadComboBoxStb()
     {
      try
       {
            Con = KonekDb.Getkoneksidatabase();
            St = Con.createStatement();
            RS = St.executeQuery("SELECT * FROM mahasiswa");
            while(RS.next())
            {
            jComboBox2.addItem(RS.getString("stb"));
            }
        }
        catch(SQLException e)
        {
            System.out.println("koneksi gagal "+e.toString());
        }
    }
     
 
     
    private void TampilDataDalamTabel()
    {
       try
        {
            Con = KonekDb.Getkoneksidatabase();
            St = Con.createStatement();
            DefaultTableModel Tbl = new DefaultTableModel();
           
            Tbl.addColumn("Nama Mahasiswa");
            Tbl.addColumn("Nama Jurusan");
            Tbl.addColumn("Nama Matakuliah");
            Tbl.addColumn("Nilai");
            Tbl.addColumn("Tahun Ajar");
            
            jTable1.setModel(Tbl);
            try
            {
                RS = St.executeQuery("SELECT mahasiswa.nama, jurusan.nama_jurusan, "
                        + "matkul.nama_matkul, rancangan_studi.nilai, "
                        + "rancangan_studi.thn_ajar FROM mahasiswa JOIN rancangan_studi ON "
                        + "mahasiswa.stb = rancangan_studi.stb JOIN matkul ON "
                        + "matkul.kode_matkul = rancangan_studi.kode_matkul JOIN "
                        + "jurusan ON mahasiswa.kode_jurusan = jurusan.kode_jurusan");
                while(RS.next())
                {
                    Tbl.addRow(new Object[]
                    {
                        RS.getString("nama"),
                        RS.getString("nama_jurusan"),
                        RS.getString("nama_matkul"),
                        RS.getString("nilai"),
                        RS.getString("thn_ajar"),
                    });
                    jTable1.setModel(Tbl);
                }
            }
            catch(Exception e)
            {
            }
        }
        catch(SQLException e)
        {
            System.out.println("koenksi gagal "+e.toString());
        }
    }
     
    private void LoadComboBoxKodeMatkul()
     {
      try
       {
                    Con = KonekDb.Getkoneksidatabase();
                    St = Con.createStatement();
                    RS = St.executeQuery("SELECT input_sks.kode_matkul FROM input_sks");
                    while(RS.next())
                    {
                        jComboBox1.addItem(RS.getString("kode_matkul"));
                    }
        }
        catch(SQLException e)
        {
            System.out.println("koneksi gagal "+e.toString());
        }
    } 
     
      private void KodeMatkul()
    {
         try
        {
            Con = KonekDb.Getkoneksidatabase();
            St = Con.createStatement();
            RS=St.executeQuery("SELECT * FROM matkul WHERE nama_matkul ='"+jTextField2.getText()+"'");
            while(RS.next())
            {
                jComboBox1.setSelectedItem(RS.getString("kode_matkul"));
            }
        }
        catch(SQLException e)
        {
            System.out.println("koneksi gagal "+e.toString());
        }
        
    }
      
      private void STB()
    {
         try
        {
            Con = KonekDb.Getkoneksidatabase();
            St = Con.createStatement();
            RS=St.executeQuery("SELECT * FROM mahasiswa WHERE nama ='"+jTextField1.getText()+"'");
            while(RS.next())
            {
                jComboBox2.setSelectedItem(RS.getString("stb"));
            }
        }
        catch(SQLException e)
        {
            System.out.println("koneksi gagal "+e.toString());
        }
        
    }
      
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField9 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel1.setText("Stb");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--" }));
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jComboBox2MouseExited(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jComboBox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox2KeyPressed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel2.setText("Jurusan");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel3.setText("Kode Matkul");

        jTextField2.setText("jTextField2");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", " " }));
        jComboBox1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jComboBox1ComponentAdded(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel4.setText("Nilai");

        jTextField3.setText("jTextField3");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextField9.setText("jTextField9");

        jButton3.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jButton3.setText("Simpan");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jButton5.setText("Hapus");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jButton6.setText("Kembali");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel5.setText("Tahun Ajar");

        jTextField4.setText("jTextField4");

        jButton7.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jButton7.setText("Refresh");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, 113, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField3)
                            .addComponent(jTextField9)
                            .addComponent(jTextField4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(jTextField2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(273, 273, 273))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String kode_matkul="";
       
        try
        {
            Con = KonekDb.Getkoneksidatabase();
            St = Con.createStatement();
            RS = St.executeQuery("SELECT * FROM matkul WHERE kode_matkul='" + jComboBox1.getSelectedItem().toString()+"'");
            while (RS.next())
            {
                kode_matkul=RS.getString("nama_matkul");
                
            }
            jTextField2.setText(kode_matkul);
        }
        catch(SQLException e)
        {
            System.out.println("Koneksi Gagal" + e.toString());
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        String stb="";
        String kode_jurusan="";
        try
        {
            Con = KonekDb.Getkoneksidatabase();
            St = Con.createStatement();
            RS = St.executeQuery("SELECT * FROM mahasiswa WHERE stb='" + jComboBox2.getSelectedItem().toString()+"'");
            while (RS.next())
            {
                stb=RS.getString("nama");
                kode_jurusan=RS.getString("kode_jurusan");
            }
            jTextField1.setText(stb);
            jTextField9.setText(kode_jurusan);
        }
        catch(SQLException e)
        {
            System.out.println("Koneksi Gagal" + e.toString());
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String TekString = jTextField1.getText()+jTextField2.getText()+jTextField3.getText()
                            +jTextField9.getText() + jTextField4.getText();
        if(TekString.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Data Belum Lengkap\nSilahkan Lengkapi Data Anda Dulu!!","Peringatan"
                ,JOptionPane.WARNING_MESSAGE);
            jTextField1.requestFocus();
        }
        else
        {
            try
            {
                Con = KonekDb.Getkoneksidatabase();
                sql = "INSERT INTO rancangan_studi (stb,kode_matkul,nilai,thn_ajar)"
                + "VALUES(?,?,?,?)";
                PStm = Con.prepareStatement(sql);
                PStm.setString(1, (String)jComboBox2.getSelectedItem().toString());
                //PStm.setString(2,jTextField9.getText());
                PStm.setString(2, (String)jComboBox1.getSelectedItem().toString());
                PStm.setString(3,jTextField3.getText());
                PStm.setString(4,jTextField4.getText());
                
                int intTambah = PStm.executeUpdate();
                TampilDataDalamTabel();

                if(intTambah>0)
                JOptionPane.showMessageDialog(this,"Penambahan Sukses","Informasi",JOptionPane.INFORMATION_MESSAGE);
                else
                JOptionPane.showMessageDialog(this,"Penambahan Gagal","Informasi",JOptionPane.INFORMATION_MESSAGE);
                {
                    PStm.close();
                    KosongkanObjek();
                }
            }
            catch(SQLException e)
            {
                System.out.println("Koneksi Gagal" + e.toString());
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            try
            {
            sql="DELETE FROM input_sks "+"WHERE stb=? AND kode_matkul=?";
            PStm=Con.prepareStatement(sql);
            PStm.setString(1, jComboBox2.getSelectedItem().toString());
            PStm.setString(2, jComboBox1.getSelectedItem().toString());
            int intTambah=PStm.executeUpdate();
            if(intTambah>0)
            {
                JOptionPane.showMessageDialog(this, "Hapus data sukses","Informasi",
                JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Hapus data gagal","Informasi",
                JOptionPane.INFORMATION_MESSAGE);
            }
            PStm.close();
        }
        catch(SQLException e)
        {
            System.out.println("koneksi gagal "+e.toString());
        }
       TampilDataDalamTabel();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
        FormRancanganStudi n = new FormRancanganStudi();
        n.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.rowAtPoint(evt.getPoint());
       
        jTextField1.setText(String.valueOf(jTable1.getValueAt(row, 0).toString()));
   
        STB();
        jTextField2.setText(String.valueOf(jTable1.getValueAt(row, 2).toString()));
        jTextField3.setText(String.valueOf(jTable1.getValueAt(row, 3).toString()));
        //jComboBox1.setSelectedItem(String.valueOf(jTable1.getValueAt(row, 2).toString()));
        jTextField4.setText(String.valueOf(jTable1.getValueAt(row, 4).toString()));
        jTextField9.setText(String.valueOf(jTable1.getValueAt(row, 1).toString()));
        jComboBox2.setSelectedItem(String.valueOf(jTable1.getValueAt(row, 0).toString()));
        KodeMatkul();
        
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        KosongkanObjek();
        TampilDataDalamTabel();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked

    }//GEN-LAST:event_jComboBox2MouseClicked

    private void jComboBox2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseExited

    }//GEN-LAST:event_jComboBox2MouseExited

    private void jComboBox2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyPressed
      
    }//GEN-LAST:event_jComboBox2KeyPressed

    private void jComboBox1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jComboBox1ComponentAdded
          
    }//GEN-LAST:event_jComboBox1ComponentAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormTranskrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTranskrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTranskrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTranskrip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTranskrip().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
