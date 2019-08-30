package akademik;
import java.util.logging.Level; 
import java.util.logging.Logger;
import java.awt.Toolkit;
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

public class FormMahasiswa extends javax.swing.JFrame 
{
    Connection Con;
    Statement St;
    ResultSet RS;
    PreparedStatement PStm=null;
    String sql;
    private final JTable table=null;
    Koneksi KonekDb = new Koneksi();
    
    
    public FormMahasiswa() 
    {
        initComponents();
        KosongkanObjek();
        NonAktifObjek();
        TampilDataDalamTabel();
        LoadComboBoxJurusan();
    }
    
     private void KosongkanObjek()
    {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jComboBox3.setSelectedIndex(0);
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jDateChooser1.setDate(null);
        
    }
    private void NonAktifObjek()
    {
        jTextField1.enable(false);
        jTextField2.enable(false);
        jTextField3.enable(false);
        jTextField4.enable(false);
        jTextField5.enable(false);
        jComboBox3.setEnabled(false);
        jButton3.setEnabled(false);
        jDateChooser1.setEnabled(false);
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(false);
    }
    private void AktifkanObjek()
    {
        jTextField1.enable(true);
        jTextField2.enable(true);
        jTextField3.enable(true);
        jTextField4.enable(true);
        jTextField5.enable(true);
        jComboBox3.setEnabled(true);
        jTextField1.requestFocus();
        jButton3.setEnabled(true);
        jDateChooser1.setEnabled(true);
        jComboBox1.setEnabled(true);
        jComboBox2.setEnabled(true);
    }
    private void TampilDataDalamTabel()
    {
       try
        {
            Con = KonekDb.Getkoneksidatabase();
            St = Con.createStatement();
            DefaultTableModel Tbl = new DefaultTableModel();
            Tbl.addColumn("Stb");
            Tbl.addColumn("Nama Mahasiswa");
            Tbl.addColumn("Alamat");
            Tbl.addColumn("Jenis Kelamin");
            Tbl.addColumn("Tempat Lahir");
            Tbl.addColumn("Tanggal Lahir");
            Tbl.addColumn("Agama");
            Tbl.addColumn("Nama Jurusan");
            Tbl.addColumn("keterangan");
           
            jTable1.setModel(Tbl);
            try
            {
                RS = St.executeQuery("SELECT mahasiswa.stb,mahasiswa.nama,"
                                     + "mahasiswa.alamat,mahasiswa.jk,mahasiswa.tempat_lahir,"
                                     + "mahasiswa.tgl_lahir,mahasiswa.agama,"
                                     + "jurusan.nama_jurusan AS nama_jurusan FROM mahasiswa "
                                     + "INNER JOIN jurusan ON (mahasiswa.kode_jurusan = jurusan.kode_jurusan)");
                while(RS.next())
                {
                    Tbl.addRow(new Object[]
                    {
                        RS.getString("stb"),
                        RS.getString("nama"),
                        RS.getString("alamat"),
                        RS.getString("jk"),
                        RS.getString("tempat_lahir"),
                        RS.getString("tgl_lahir"),
                        RS.getString("agama"),
                        RS.getString("nama_jurusan"),
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

    private void LoadComboBoxJurusan()
    {
      try
       {
            Con = KonekDb.Getkoneksidatabase();
            St = Con.createStatement();
            RS = St.executeQuery("SELECT * FROM jurusan");
            while(RS.next())
            {
            jComboBox2.addItem(RS.getString("kode_jurusan"));
            }
        }
        catch(SQLException e)
        {
            System.out.println("koneksi gagal "+e.toString());
        }
    }
    
    private void KodeJurusan()
    {
         try
        {
            Con = KonekDb.Getkoneksidatabase();
            St = Con.createStatement();
            RS=St.executeQuery("SELECT * FROM mahasiswa where stb='" + jTextField1.getText()+"'");
            while(RS.next())
            {
                jComboBox2.setSelectedItem(RS.getString("kode_jurusan"));
            }
        }
        catch(SQLException e)
        {
            System.out.println("koneksi gagal "+e.toString());
        }
        
    }
    
    public static Date AmbilTanggal(JTable table, int kolom)
    {
        JTable tabel = table;
        String str_tgl = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(),kolom));
        Date tanggal = null;
        try
        {
            tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(str_tgl);
        }
        catch (ParseException ex)
        {
            
        }
        return tanggal;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField5 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Wahyuni Raka\\Pictures\\user-logo.png")); // NOI18N
        jLabel1.setText("MAHASISWA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel2.setText("Stb");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel3.setText("Nama ");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel4.setText("Jenis Kelamin");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel5.setText("Tanggal Lahir");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel6.setText("Alamat");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel7.setText("Tempat Lahir");

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel8.setText("Agama");

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel9.setText("Kode Jurusan");

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        jTextField4.setText("jTextField4");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Islam", "Kristen", "Hindu", "Budha" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jTextField5.setText("jTextField5");

        jButton2.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jButton2.setText("Tambah");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jButton3.setText("Simpan");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jButton5.setText("Edit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jButton6.setText("Refresh");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jButton7.setText("Batal");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jButton8.setText("Kembali");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel10.setText("Cari");

        jTextField6.setText("jTextField6");

        jButton1.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
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

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "L", "P" }));

        jLabel11.setText("Keterangan");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addGap(0, 93, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11))
                                        .addGap(69, 69, 69))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(73, 73, 73)))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                                .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AktifkanObjek();
        KosongkanObjek();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      
        String TekString = jTextField1.getText()+jTextField2.getText()+jTextField3.getText()
        +jTextField4.getText()+jTextField5.getText();
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
                sql = "INSERT INTO mahasiswa (stb,nama,alamat,jk,tempat_lahir,tgl_lahir,agama,kode_jurusan)"
                + "VALUES(?,?,?,?,?,?,?,?)";
                PStm = Con.prepareStatement(sql);
                PStm.setString(1,jTextField1.getText());
                PStm.setString(2,jTextField2.getText());
                PStm.setString(3,jTextField3.getText());
                PStm.setString(4, (String)jComboBox3.getSelectedItem().toString());
                PStm.setString(5,jTextField4.getText());
                java.sql.Date sql = new java.sql.Date(jDateChooser1.getDate().getTime());
                PStm.setString(6, sql.toString());
                PStm.setString(7, (String)jComboBox1.getSelectedItem().toString());
                PStm.setString(8, (String)jComboBox2.getSelectedItem().toString());

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try
        {
            sql="DELETE FROM mahasiswa "+"WHERE stb=?";
            PStm=Con.prepareStatement(sql);
            PStm.setString(1, jTextField1.getText());
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
            System.out.println("koneksi gagal3 "+e.toString());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        TampilDataDalamTabel();
        KosongkanObjek();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        KosongkanObjek();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.dispose();
        FormUtama n = new FormUtama();
        n.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            Con=KonekDb.Getkoneksidatabase();
            St=Con.createStatement();
            DefaultTableModel Tbl=new DefaultTableModel();
            Tbl.addColumn("Stb");
            Tbl.addColumn("Nama Mahasiswa");
            Tbl.addColumn("Alamat");
            Tbl.addColumn("Jenis Kelamin");
            Tbl.addColumn("Tempat Lahir");
            Tbl.addColumn("Tanggal Lahir");
            Tbl.addColumn("Agama");
            Tbl.addColumn("Nama Jurusan");
            jTable1.setModel(Tbl);
            try
            {
               RS = St.executeQuery("SELECT mahasiswa.stb,mahasiswa.nama,"
                                     + "mahasiswa.alamat,mahasiswa.jk,mahasiswa.tempat_lahir,"
                                     + "mahasiswa.tgl_lahir,mahasiswa.agama,"
                                     + "jurusan.nama_jurusan AS nama_jurusan FROM mahasiswa "
                                     + "INNER JOIN jurusan ON (mahasiswa.kode_jurusan = jurusan.kode_jurusan) WHERE mahasiswa.nama LIKE '%"+jTextField6.getText()+"%'" );
               
                while(RS.next())
                {
                    Tbl.addRow(new Object[]
                        {
                             RS.getString("stb"),
                             RS.getString("nama"),
                             RS.getString("alamat"),
                             RS.getString("jk"),
                             RS.getString("tempat_lahir"),
                             RS.getString("tgl_lahir"),
                             RS.getString("agama"),
                             RS.getString("nama_jurusan"),
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
                System.out.println("koneksi gagal4 "+e.toString());
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

            int row = jTable1.rowAtPoint(evt.getPoint());
            jTextField1.setText(String.valueOf(jTable1.getValueAt(row, 0).toString()));
            jTextField2.setText(String.valueOf(jTable1.getValueAt(row, 1).toString()));
            jTextField3.setText(String.valueOf(jTable1.getValueAt(row, 2).toString()));
            jComboBox1.setSelectedItem(String.valueOf(jTable1.getValueAt(row, 6).toString()));
            jComboBox2.setSelectedItem(String.valueOf(jTable1.getValueAt(row, 7).toString()));
            jTextField5.setText(String.valueOf(jTable1.getValueAt(row, 7).toString()));
            KodeJurusan();
            jComboBox3.setSelectedItem(String.valueOf(jTable1.getValueAt(row, 3).toString()));
            jTextField4.setText(String.valueOf(jTable1.getValueAt(row, 4).toString()));
            jDateChooser1.setDate(AmbilTanggal(jTable1, 5));   
         
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        String kode_jurusan="";
        try
        {
            Con = KonekDb.Getkoneksidatabase();
            St = Con.createStatement();
            RS = St.executeQuery("SELECT nama_jurusan FROM jurusan WHERE kode_jurusan='" + jComboBox2.getSelectedItem().toString()+"'");
            while (RS.next())
            {
                kode_jurusan=RS.getString("nama_jurusan");
            }
            jTextField5.setText(kode_jurusan);
        }
        catch(SQLException e)
        {
            System.out.println("Koneksi Gagal" + e.toString());
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      
        try
        {
        sql = "UPDATE mahasiswa set nama = ?,alamat = ?,jk = ?,tempat_lahir = ?,"
              + "tgl_lahir = ?, agama = ?, kode_jurusan = ? where stb = ?";
        PStm = Con.prepareStatement(sql);
       
        PStm.setString(1,jTextField2.getText());
        PStm.setString(2,jTextField3.getText());
        PStm.setString(3, (String)jComboBox3.getSelectedItem().toString());
        PStm.setString(4,jTextField4.getText());
        java.sql.Date sql = new java.sql.Date(jDateChooser1.getDate().getTime());
        PStm.setString(5, sql.toString());
        PStm.setString(6, (String)jComboBox1.getSelectedItem().toString());
        PStm.setString(7, (String)jComboBox2.getSelectedItem().toString());
        PStm.setString(8,jTextField1.getText());

        int intTambah = PStm.executeUpdate();
        if(intTambah>0)
        {
        JOptionPane.showMessageDialog(this, "Edit Sukses!", "Informasi!", JOptionPane.INFORMATION_MESSAGE);
        TampilDataDalamTabel();
        }
        else
        JOptionPane.showMessageDialog(this, "Edit Gagal!", "Informasi!", JOptionPane.INFORMATION_MESSAGE);
        PStm.close();
        KosongkanObjek();
        }
        catch (SQLException e)
        {
        System.out.println("Koneksi Gagal!" + e.toString());
        }
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
            java.util.logging.Logger.getLogger(FormMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
