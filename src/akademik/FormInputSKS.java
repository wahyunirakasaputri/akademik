package akademik;
import java.util.logging.Level; 
import java.util.logging.Logger;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.swing.JTextField;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

public class FormInputSKS extends javax.swing.JFrame 
{
    Connection Con;
    Statement St;
    ResultSet RS;
    PreparedStatement PStm=null;
    String sql;
    private final JTable table=null;
    Koneksi KonekDb = new Koneksi();

    public FormInputSKS() 
    {
        initComponents();
        KosongkanObjek();
        TampilDataDalamTabel();
        LoadComboBoxStb();
        LoadComboBoxKodeMatkul();
        NonAktifObjek();
    }

    private void KosongkanObjek()
    {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
    }
    private void NonAktifObjek()
    {
        jTextField1.enable(false);
        jTextField2.enable(false);
        jTextField3.enable(false);
        jTextField4.enable(false);
        jTextField5.enable(false);
    }
    
    private void AktifObjek()
    {
        jTextField1.enable(true);
        jTextField2.enable(true);
        jTextField3.enable(true);
        jTextField4.enable(true);
        jTextField5.enable(true);
    }
    
    private void TampilDataDalamTabel()
    {
       try
        {
            Con = KonekDb.Getkoneksidatabase();
            St = Con.createStatement();
            DefaultTableModel Tbl = new DefaultTableModel();
          
            Tbl.addColumn("Nama Mahasiswa");
            Tbl.addColumn("Nama Matakuliah");
            Tbl.addColumn("Sks");
            Tbl.addColumn("Nama Dosen");
           
            jTable1.setModel(Tbl);
            try
            {
                RS = St.executeQuery("SELECT mahasiswa.nama,matkul.nama_matkul,matkul.sks,dosen.nama_dosen FROM mahasiswa INNER JOIN (matkul INNER JOIN input_sks ON matkul.kode_matkul = input_sks.kode_matkul) ON mahasiswa.stb = input_sks.stb JOIN dosen ON dosen.nip= matkul.nip");
                
                while(RS.next())
                {
                    Tbl.addRow(new Object[]
                    {
                        RS.getString("nama"),
                        RS.getString("nama_matkul"),
                        RS.getString("sks"),
                        RS.getString("nama_dosen"),
                        
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
            System.out.println("koneksi gagal "+e.toString());
        }
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
     
    private void LoadComboBoxKodeMatkul()
     {
      try
       {
            Con = KonekDb.Getkoneksidatabase();
            St = Con.createStatement();
            RS = St.executeQuery("SELECT * FROM matkul");
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel1.setText("Stb");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel2.setText("Kode Matkul");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel3.setText("Jumlah SKS");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", " " }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBox1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jComboBox1MouseReleased(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jTextField2.setText("jTextField2");
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        jTextField3.setText("jTextField3");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jButton2.setText("Simpan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

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

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel4.setText("Sks");

        jTextField4.setText("jTextField4");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel5.setText("Nama Dosen");

        jTextField5.setText("jTextField5");

        jButton3.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jButton3.setText("Kembali");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField4)
                                            .addComponent(jTextField5)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(32, 32, 32)
                                        .addComponent(jTextField3)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(287, 287, 287))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        String stb="";
        try
        {
            Con = KonekDb.Getkoneksidatabase();
            St = Con.createStatement();
            RS = St.executeQuery("SELECT nama FROM mahasiswa WHERE stb='" + jComboBox2.getSelectedItem().toString()+"'");
            while (RS.next())
            {
                stb=RS.getString("nama");
            }
            jTextField1.setText(stb);
        }
        catch(SQLException e)
        {
            System.out.println("Koneksi Gagal" + e.toString());
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       String kode_matkul="";
       String sks="";
       String nip="";
        try
        {
            Con = KonekDb.Getkoneksidatabase();
            St = Con.createStatement();
            RS = St.executeQuery("SELECT * FROM matkul WHERE kode_matkul='" + jComboBox1.getSelectedItem().toString()+"'");
            while (RS.next())
            {
                kode_matkul=RS.getString("nama_matkul");
                sks=RS.getString("sks");
                nip=RS.getString("nip");
            }
            jTextField2.setText(kode_matkul);
            jTextField4.setText(sks);
            jTextField5.setText(nip);
           
        }
        catch(SQLException e)
        {
            System.out.println("Koneksi Gagal" + e.toString());
        }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
        Con = KonekDb.Getkoneksidatabase();
        St = Con.createStatement();
        sql = "SELECT stb, SUM(jumlah_sks) FROM input_sks WHERE stb = " + jComboBox2.getSelectedItem();
        RS = St.executeQuery(sql);
        if(RS.next()){
            jTextField3.setText(RS.getString("SUM(jumlah_sks)"));
        }
        if (Integer.parseInt(RS.getString("SUM(jumlah_sks)"))>22)
        {
            JOptionPane.showMessageDialog(null,"Jumlah SKS yang anda input, lebih dari 22, Kurangi SKS");
        }
        } catch (Exception e) {
            System.out.println("KESLAHAN " + e);
        } 
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        
        try {
                Con = KonekDb.Getkoneksidatabase();
                St = Con.createStatement();
                RS = St.executeQuery("SELECT *  FROM input_sks WHERE stb='" + jComboBox2.getSelectedItem().toString() + "' AND kode_matkul='" + jComboBox1.getSelectedItem().toString() + "'");
                if(RS.next()) {
                    JOptionPane.showMessageDialog(null, "Mata Kuliah Telah Tersedia, Silahkan Pilih Mata Kuliah Yang Lain");
                }
                else {
                     String TekString = jTextField1.getText()+jTextField2.getText()+jTextField4.getText()+jTextField5.getText();
                     if(TekString.equals("")) {
            JOptionPane.showMessageDialog(this,"Data Belum Lengkap\nSilahkan Lengkapi Data Anda Dulu!!","Peringatan"
                ,JOptionPane.WARNING_MESSAGE);
            jTextField1.requestFocus();
                        }
                            else
                            {
                                try
                                    {
                                        Con = KonekDb.Getkoneksidatabase();
                                        sql = "INSERT INTO input_sks (stb,kode_matkul,jumlah_sks,nip)"
                                        + "VALUES(?,?,?,?)";
                                        PStm = Con.prepareStatement(sql);

                                        PStm.setString(1,jComboBox2.getSelectedItem().toString());
                                        PStm.setString(2,jComboBox1.getSelectedItem().toString());
                                        PStm.setString(3,jTextField4.getText());
                                        PStm.setString(4,jTextField5.getText());
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
                    }   
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Kesalahan " + e);
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        FormRancanganStudi n = new FormRancanganStudi();
        n.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
     
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        
    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
            try {
                Con = KonekDb.Getkoneksidatabase();
                St = Con.createStatement();
                RS = St.executeQuery("SELECT matkul.nama_matkul WHERE kode_matkul = '" + jComboBox1.getSelectedItem()+ "'");
                if(RS.next()) {
                    JOptionPane.showMessageDialog(null, "Kode Telah Tersedia");
                    NonAktifObjek();
                }
                else {
                    AktifObjek();
                    jTextField1.setEnabled(false);
                    jTextField2.requestFocus();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "KEsalahan " + e);
            }
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jComboBox1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1MousePressed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseReleased
       /* try {
                Con = KonekDb.Getkoneksidatabase();
                St = Con.createStatement();
                RS = St.executeQuery("SELECT matkul.nama_matkul WHERE kode_matkul = '" + jComboBox1.getSelectedItem()+ "'");
                if(RS.next()) {
                    JOptionPane.showMessageDialog(null, "Kode Telah Tersedia");
                    NonAktifObjek();
                }
                else {
                    AktifObjek();
                    jTextField1.setEnabled(false);
                    jTextField2.requestFocus();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "KEsalahan " + e);
            } */
    }//GEN-LAST:event_jComboBox1MouseReleased

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.rowAtPoint(evt.getPoint());
        STB();
        KodeMatkul();
        jTextField1.setText(String.valueOf(jTable1.getValueAt(row, 0).toString()));
        jTextField2.setText(String.valueOf(jTable1.getValueAt(row, 1).toString()));
        jTextField4.setText(String.valueOf(jTable1.getValueAt(row, 2).toString()));
        jTextField5.setText(String.valueOf(jTable1.getValueAt(row, 3).toString())); 
          
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
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
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       TampilDataDalamTabel();
       KosongkanObjek();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(FormInputSKS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormInputSKS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormInputSKS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormInputSKS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormInputSKS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables

}
