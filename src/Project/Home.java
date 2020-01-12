/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.awt.Color;
import javax.swing.JPanel;
import Dashboard.config;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author adit
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    //Program untuk mengosongkan field yang sudah di input
    public void form_kosong(){
       masuk_id.setText(null);
       masuk_nama.setText(null);
       masuk_npm.setText(null);
       masuk_tanggal.setText(null);
       masuk_uang.setText(null);
       keterangan.setSelectedItem(this);
    }
    //Mengolah data dan menampilkan di menu ringkasan
    public void tampil_data_dashboard(){
        try{
            int no = 1;
            String kas_masuk  = "SELECT SUM(jumlah_masuk)FROM kas_masuk";
            java.sql.Connection conn = (Connection)Koneksi.configDb();
            java.sql.PreparedStatement stmt = conn.prepareStatement(kas_masuk);
            java.sql.ResultSet rs = stmt.executeQuery();
            rs.next();
            
            masuk.setText(rs.getString(1));
            
            String Cvt_masuk = rs.getString(1);
            int total_masuk = Integer.parseInt(Cvt_masuk);
            
//            kas keluar
            String kas_keluar  = "SELECT SUM(jumlah_keluar)FROM kas_keluar";
            java.sql.Connection conn1 = (Connection)Koneksi.configDb();
            java.sql.PreparedStatement stmt2 = conn1.prepareStatement(kas_keluar);
            java.sql.ResultSet rs2 = stmt2.executeQuery();
            rs2.next();
            
            keluar.setText(rs2.getString(1));
            
            String Cvt_keluar = rs2.getString(1);
            int total_keluar = Integer.parseInt(Cvt_keluar);
            
//            total kas 
            int total = total_masuk - total_keluar;
            String Cvt_total = ""+total+"";
            total_kas.setText(Cvt_total);
            
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }        
    }
    //Program untuk menampilkan data dari query kas_masuk ke tabel kas masuk
    public void tampil_data_kasmasuk(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama Mahasiswa");
        model.addColumn("NPM Mahasiswa");
        model.addColumn("Tanggal Pembayaran");
        model.addColumn("Jumlah Pembayaran");
        model.addColumn("Keterangan");
        try{
            String sql  = "SELECT * FROM kas_masuk WHERE keterangan = 'Sudah Bayar' ORDER BY tanggal_masuk DESC";
            java.sql.Connection conn = (Connection)Koneksi.configDb();
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getInt(5), rs.getString(6)});
            }
            table_masuk.setModel(model);
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    //Program untuk menampilkan data dari query kas_keluar ke tabel kas keluar
    public void tampil_data_kaskeluar(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Tanggal");
        model.addColumn("Jumlah");
        model.addColumn("Keperluan");
        try{
            String sql  = "SELECT * FROM kas_keluar";
            java.sql.Connection conn = (Connection)Koneksi.configDb();
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1), rs.getDate(2), rs.getString(3), rs.getString(4)});
            }
            table_keluar.setModel(model);
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    //Program untuk menampilkan data dari query kas_masuk ke tabel namun menggunakan kondisi keterangan belum bayar
    public void tampil_data_belum_bayar(){
      DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama Mahasiswa");
        model.addColumn("NPM Mahasiswa");
        model.addColumn("Tanggal Pembayaran");
        model.addColumn("Jumlah Pembayaran");
        model.addColumn("Keterangan");
        try{
            String sql  = "SELECT * FROM kas_masuk WHERE keterangan='Belum Bayar' ORDER BY tanggal_masuk DESC";
            java.sql.Connection conn = (Connection)Koneksi.configDb();
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getInt(5), rs.getString(6)});
            }
            form_belum_bayar.setModel(model);
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }   
    }
    
    public Home() {
        initComponents();
        tampil_data_dashboard();
        tampil_data_kasmasuk();
        tampil_data_kaskeluar();
        tampil_data_belum_bayar();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        sidepanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        logo1 = new javax.swing.JLabel();
        logo2 = new javax.swing.JLabel();
        btn_ringkasan = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_uangkas = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_mhs = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        mainpanel = new javax.swing.JPanel();
        ringkasan = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        total_kas = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        keluar = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        masuk = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        form_bayar = new javax.swing.JScrollPane();
        form_belum_bayar = new javax.swing.JTable();
        uangkas = new javax.swing.JPanel();
        header1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        uang_keluar = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        keterangan_keluar = new javax.swing.JScrollPane();
        keperluan = new javax.swing.JTextArea();
        btn_kaskeluar = new javax.swing.JButton();
        tanggal_keluar = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        masuk_npm = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        masuk_uang = new javax.swing.JTextField();
        masuk_nama = new javax.swing.JTextField();
        btn_insert_masuk = new javax.swing.JButton();
        masuk_tanggal = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        keterangan = new javax.swing.JComboBox<>();
        btn_update_masuk = new javax.swing.JButton();
        btn_delete_masuk = new javax.swing.JButton();
        masuk_id = new javax.swing.JTextField();
        datamhs = new javax.swing.JPanel();
        header2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_masuk = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_keluar = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kas Pintar");
        setLocationByPlatform(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(970, 660));
        bg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bgKeyPressed(evt);
            }
        });
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidepanel.setBackground(new java.awt.Color(54, 33, 89));
        sidepanel.setMinimumSize(new java.awt.Dimension(340, 660));
        sidepanel.setPreferredSize(new java.awt.Dimension(340, 660));
        sidepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/images/icons8-coin-wallet-64.png"))); // NOI18N
        sidepanel.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 70, 60));

        logo1.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        logo1.setForeground(new java.awt.Color(204, 204, 204));
        logo1.setText("Kas");
        sidepanel.add(logo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        logo2.setFont(new java.awt.Font("Montserrat", 0, 36)); // NOI18N
        logo2.setForeground(new java.awt.Color(204, 204, 204));
        logo2.setText("Pintar");
        sidepanel.add(logo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        btn_ringkasan.setBackground(new java.awt.Color(85, 65, 118));
        btn_ringkasan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_ringkasanMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ringkasanMouseClicked(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/images/icons8-graph-15.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Ringkasan");

        javax.swing.GroupLayout btn_ringkasanLayout = new javax.swing.GroupLayout(btn_ringkasan);
        btn_ringkasan.setLayout(btn_ringkasanLayout);
        btn_ringkasanLayout.setHorizontalGroup(
            btn_ringkasanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ringkasanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_ringkasanLayout.setVerticalGroup(
            btn_ringkasanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ringkasanLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(btn_ringkasanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidepanel.add(btn_ringkasan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 340, 60));

        btn_uangkas.setBackground(new java.awt.Color(63, 43, 100));
        btn_uangkas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_uangkasMousePressed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/images/icons8-receive-cash-15.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Uang Kas");

        javax.swing.GroupLayout btn_uangkasLayout = new javax.swing.GroupLayout(btn_uangkas);
        btn_uangkas.setLayout(btn_uangkasLayout);
        btn_uangkasLayout.setHorizontalGroup(
            btn_uangkasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_uangkasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_uangkasLayout.setVerticalGroup(
            btn_uangkasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_uangkasLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(btn_uangkasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidepanel.add(btn_uangkas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 340, 60));

        btn_mhs.setBackground(new java.awt.Color(63, 43, 100));
        btn_mhs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_mhsMousePressed(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/images/icons8-people-15.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Data Mahasiswa");

        javax.swing.GroupLayout btn_mhsLayout = new javax.swing.GroupLayout(btn_mhs);
        btn_mhs.setLayout(btn_mhsLayout);
        btn_mhsLayout.setHorizontalGroup(
            btn_mhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_mhsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_mhsLayout.setVerticalGroup(
            btn_mhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_mhsLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(btn_mhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidepanel.add(btn_mhs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 340, 60));

        bg.add(sidepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 660));

        mainpanel.setPreferredSize(new java.awt.Dimension(710, 660));
        mainpanel.setLayout(new java.awt.CardLayout());

        ringkasan.setBackground(new java.awt.Color(255, 255, 255));
        ringkasan.setPreferredSize(new java.awt.Dimension(970, 660));
        ringkasan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(112, 72, 221));
        header.setFocusCycleRoot(true);
        header.setRequestFocusEnabled(false);
        header.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                headerPropertyChange(evt);
            }
        });
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(jLabel3.getFont().deriveFont((jLabel3.getFont().getStyle() | java.awt.Font.ITALIC) | java.awt.Font.BOLD, 14));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ringkasan");
        header.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        ringkasan.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 997, 52));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(710, 660));

        jPanel15.setBackground(new java.awt.Color(112, 72, 221));
        jPanel15.setFont(new java.awt.Font("Monotype Corsiva", 3, 18)); // NOI18N
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setBackground(new java.awt.Color(112, 72, 221));
        jLabel27.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("TOTAL UANG KAS");
        jLabel27.setPreferredSize(new java.awt.Dimension(126, 15));
        jPanel15.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 190, 40));

        jPanel16.setBackground(new java.awt.Color(54, 33, 89));

        total_kas.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        total_kas.setForeground(new java.awt.Color(255, 255, 255));
        total_kas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(total_kas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(total_kas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanel15.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 69, 190, -1));

        jPanel7.setBackground(new java.awt.Color(112, 72, 221));
        jPanel7.setFont(new java.awt.Font("Monotype Corsiva", 3, 18)); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(112, 72, 221));
        jLabel4.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TOTAL KAS KELUAR");
        jLabel4.setPreferredSize(new java.awt.Dimension(126, 15));
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 190, 40));

        jPanel8.setBackground(new java.awt.Color(54, 33, 89));

        keluar.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        keluar.setForeground(new java.awt.Color(255, 255, 255));
        keluar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        keluar.getAccessibleContext().setAccessibleName("jPanel12");

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 69, 190, -1));

        jPanel13.setBackground(new java.awt.Color(112, 72, 221));
        jPanel13.setFont(new java.awt.Font("Monotype Corsiva", 3, 18)); // NOI18N
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setBackground(new java.awt.Color(112, 72, 221));
        jLabel26.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("TOTAL KAS MASUK");
        jLabel26.setPreferredSize(new java.awt.Dimension(126, 15));
        jPanel13.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 190, 40));

        jPanel14.setBackground(new java.awt.Color(54, 33, 89));

        masuk.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        masuk.setForeground(new java.awt.Color(255, 255, 255));
        masuk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(masuk, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(masuk, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 69, 190, -1));

        jLabel24.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("DATA MAHASISWA YANG BELUM BAYAR");

        form_bayar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(225, 225, 225)));
        form_bayar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        form_belum_bayar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(225, 225, 225)));
        form_belum_bayar.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        form_belum_bayar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "NO", "NAMA", "NPM", "TANGGAL", "JUMLAH", "KETERANGAN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        form_belum_bayar.setPreferredSize(new java.awt.Dimension(200, 50));
        form_belum_bayar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                form_belum_bayarMouseClicked(evt);
            }
        });
        form_bayar.setViewportView(form_belum_bayar);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(form_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(304, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(form_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ringkasan.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 64, 997, 600));

        mainpanel.add(ringkasan, "card2");

        uangkas.setBackground(new java.awt.Color(255, 255, 255));
        uangkas.setPreferredSize(new java.awt.Dimension(970, 660));
        uangkas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header1.setBackground(new java.awt.Color(112, 72, 221));
        header1.setFocusCycleRoot(true);
        header1.setRequestFocusEnabled(false);
        header1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                header1PropertyChange(evt);
            }
        });
        header1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Montserrat", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Uang Kas");
        header1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        uangkas.add(header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 60));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(229, 229, 229));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(85, 65, 118), 1, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(85, 65, 118));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 30));

        jLabel6.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Kas Keluar");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        jLabel15.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel15.setText("Tanggal Pengeluaran");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 110, -1, -1));

        jLabel16.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel16.setText("Jumlah Uang");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 210, -1, -1));

        uang_keluar.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        uang_keluar.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        uang_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uang_keluarActionPerformed(evt);
            }
        });
        jPanel2.add(uang_keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 280, 40));

        jLabel22.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel22.setText("Keperluan");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 310, -1, -1));

        keperluan.setColumns(20);
        keperluan.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        keperluan.setLineWrap(true);
        keperluan.setRows(1);
        keperluan.setTabSize(1);
        keperluan.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        keterangan_keluar.setViewportView(keperluan);

        jPanel2.add(keterangan_keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 290, 150));

        btn_kaskeluar.setText("SIMPAN");
        btn_kaskeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_kaskeluar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_kaskeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kaskeluarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_kaskeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 270, 40));

        tanggal_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggal_keluarActionPerformed(evt);
            }
        });
        jPanel2.add(tanggal_keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 140, 280, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 320, 560));

        jPanel5.setBackground(new java.awt.Color(229, 229, 229));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(85, 65, 118), 1, true));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(85, 65, 118));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 30));

        jLabel10.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Kas Masuk");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        jLabel18.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel18.setText("Nama Lengkap");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel19.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel19.setText("NPM");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        masuk_npm.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        masuk_npm.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        masuk_npm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masuk_npmActionPerformed(evt);
            }
        });
        jPanel5.add(masuk_npm, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 280, 40));

        jLabel20.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel20.setText("Tanggal Penyetoran");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, 20));

        jLabel21.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel21.setText("Jumlah Uang");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        masuk_uang.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        masuk_uang.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        masuk_uang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masuk_uangActionPerformed(evt);
            }
        });
        jPanel5.add(masuk_uang, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 280, 40));

        masuk_nama.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        masuk_nama.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        masuk_nama.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        masuk_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masuk_namaActionPerformed(evt);
            }
        });
        jPanel5.add(masuk_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 280, 40));

        btn_insert_masuk.setText("INSERT");
        btn_insert_masuk.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_insert_masuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insert_masukActionPerformed(evt);
            }
        });
        jPanel5.add(btn_insert_masuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, 80, 40));

        masuk_tanggal.setPreferredSize(new java.awt.Dimension(20, 35));
        masuk_tanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masuk_tanggalActionPerformed(evt);
            }
        });
        jPanel5.add(masuk_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 280, 50));

        jLabel25.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel25.setText("Keterangan Pembayaran");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        keterangan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sudah Bayar", "Belum Bayar", " " }));
        jPanel5.add(keterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 280, 40));

        btn_update_masuk.setText("UPDATE");
        btn_update_masuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update_masukActionPerformed(evt);
            }
        });
        jPanel5.add(btn_update_masuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, -1, 40));

        btn_delete_masuk.setText("DELETE");
        btn_delete_masuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_masukActionPerformed(evt);
            }
        });
        jPanel5.add(btn_delete_masuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, 40));

        masuk_id.setToolTipText("");
        jPanel5.add(masuk_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 60, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 320, 560));

        uangkas.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 710, 660));

        mainpanel.add(uangkas, "card2");

        datamhs.setBackground(new java.awt.Color(255, 255, 255));
        datamhs.setPreferredSize(new java.awt.Dimension(970, 660));

        header2.setBackground(new java.awt.Color(112, 72, 221));
        header2.setFocusCycleRoot(true);
        header2.setRequestFocusEnabled(false);
        header2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                header2PropertyChange(evt);
            }
        });
        header2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Montserrat", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Data Mahasiswa");
        header2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel23.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel23.setText("TABLE PENGELUARAN KAS");

        jScrollPane3.setBorder(null);

        table_masuk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        table_masuk.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        table_masuk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "NO", "NAMA LENGKAP", "NPM", "UANG MASUK", "TANGGAL PENYETORAN", "KETERANGAN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_masuk.setGridColor(new java.awt.Color(204, 204, 204));
        table_masuk.setIntercellSpacing(new java.awt.Dimension(5, 5));
        table_masuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_masukMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_masuk);

        jLabel11.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel11.setText("TABLE KAS MASUK");

        table_keluar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(225, 225, 225)));
        table_keluar.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        table_keluar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
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
        table_keluar.setRowMargin(5);
        jScrollPane1.setViewportView(table_keluar);

        javax.swing.GroupLayout datamhsLayout = new javax.swing.GroupLayout(datamhs);
        datamhs.setLayout(datamhsLayout);
        datamhsLayout.setHorizontalGroup(
            datamhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(datamhsLayout.createSequentialGroup()
                .addGroup(datamhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datamhsLayout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel23))
                    .addGroup(datamhsLayout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(jLabel11)))
                .addContainerGap(499, Short.MAX_VALUE))
            .addGroup(datamhsLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(datamhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        datamhsLayout.setVerticalGroup(
            datamhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datamhsLayout.createSequentialGroup()
                .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainpanel.add(datamhs, "card2");

        bg.add(mainpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 710, 660));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ringkasanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ringkasanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ringkasanMouseClicked

    private void btn_ringkasanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ringkasanMousePressed
        // TODO add your handling code here:
        //Kode untuk dynamic panel
        //menghapus panel
        mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();
        
        //menambah panel
        mainpanel.add(ringkasan);
        mainpanel.repaint();
        mainpanel.revalidate();
        
        //Mengganti warna ketika panel diklik
        setColor(btn_ringkasan);
        resetColor(btn_uangkas);
        resetColor(btn_mhs);
    }//GEN-LAST:event_btn_ringkasanMousePressed

    private void btn_uangkasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_uangkasMousePressed
        // TODO add your handling code here:
        //Kode untuk dynamic panel
        //menghapus panel
        mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();
        
        //menambah panel
        mainpanel.add(uangkas);
        mainpanel.repaint();
        mainpanel.revalidate();
        
        resetColor(btn_ringkasan);
        setColor(btn_uangkas);
        resetColor(btn_mhs);
    }//GEN-LAST:event_btn_uangkasMousePressed

    private void btn_mhsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mhsMousePressed
        // TODO add your handling code here:
        mainpanel.removeAll();
        mainpanel.repaint();
        mainpanel.revalidate();
        
        //menambah panel
        mainpanel.add(datamhs);
        mainpanel.repaint();
        mainpanel.revalidate();
        
        resetColor(btn_ringkasan);
        resetColor(btn_uangkas);
        setColor(btn_mhs);
    }//GEN-LAST:event_btn_mhsMousePressed

    private void bgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bgKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_bgKeyPressed

    private void header1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_header1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_header1PropertyChange

    private void uang_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uang_keluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uang_keluarActionPerformed

    private void masuk_npmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masuk_npmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masuk_npmActionPerformed

    private void masuk_uangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masuk_uangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masuk_uangActionPerformed

    private void masuk_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masuk_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masuk_namaActionPerformed

    private void btn_insert_masukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insert_masukActionPerformed
        try{
        String sql = "INSERT INTO kas_masuk (nama_mhs, npm_Mhs, tanggal_Masuk, jumlah_masuk, keterangan) VALUES ('"+masuk_nama.getText()+"','"+masuk_npm.getText()+"','"+masuk_tanggal.getText()+"','"+masuk_uang.getText()+"','"+keterangan.getSelectedItem()+"')";
        java.sql.Connection conn = (Connection)Koneksi.configDb();
        java.sql.PreparedStatement pstr = conn.prepareStatement(sql);
        pstr.execute();
        form_kosong();
        tampil_data_kasmasuk();
        tampil_data_belum_bayar();
        tampil_data_dashboard();
        JOptionPane.showMessageDialog(null, "Data berhasil Ditambahkan !");
        } catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, "maaf gagal insert data gagal !" +e.getMessage());
        }
    }//GEN-LAST:event_btn_insert_masukActionPerformed

    private void masuk_tanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masuk_tanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masuk_tanggalActionPerformed

    private void headerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_headerPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_headerPropertyChange

    private void btn_kaskeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kaskeluarActionPerformed
        try{
        String sql = "INSERT INTO kas_keluar (tanggal_keluar, jumlah_keluar, keperluan) VALUES ('"+tanggal_keluar.getText()+"','"+uang_keluar.getText()+"','"+keperluan.getText()+"')";
        java.sql.Connection conn = (Connection)Koneksi.configDb();
        java.sql.PreparedStatement pstr = conn.prepareStatement(sql);
        pstr.execute();
        form_kosong();
        tampil_data_kaskeluar();
        tampil_data_dashboard();
        JOptionPane.showMessageDialog(null, "Data berhasil Ditambahkan !");
        } catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, "maaf gagal insert data gagal !" +e.getMessage());
        }
    }//GEN-LAST:event_btn_kaskeluarActionPerformed

    private void tanggal_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggal_keluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggal_keluarActionPerformed

//    update btn kas masuk
    private void btn_update_masukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update_masukActionPerformed
        try{
        String sql = "UPDATE kas_masuk SET nama_mhs='"+masuk_nama.getText()+"', npm_Mhs='"+masuk_npm.getText()+"' , tanggal_Masuk='"+masuk_tanggal.getText()+"' , jumlah_masuk='"+masuk_uang.getText()+"' , keterangan='"+keterangan.getSelectedItem()+"' WHERE id_kas_masuk='"+masuk_id.getText()+"'";
        java.sql.Connection conn = (Connection)Koneksi.configDb();
        java.sql.PreparedStatement pstr = conn.prepareStatement(sql);
        pstr.execute();
        form_kosong();
        tampil_data_kasmasuk();
        tampil_data_belum_bayar();
        tampil_data_dashboard();
        JOptionPane.showMessageDialog(null, "Data berhasil Update !");
        } catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, "maaf gagal insert data gagal !");
        }
    }//GEN-LAST:event_btn_update_masukActionPerformed

//    delete kas masuk
    private void btn_delete_masukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_masukActionPerformed
        try{
        String sql = "DELETE FROM kas_masuk WHERE id_kas_masuk='"+masuk_id.getText()+"'";
        java.sql.Connection conn = (Connection)Koneksi.configDb();
        java.sql.PreparedStatement pstr = conn.prepareStatement(sql);
        pstr.execute();
        form_kosong();
        tampil_data_kasmasuk();
        tampil_data_belum_bayar();
        tampil_data_dashboard();
        JOptionPane.showMessageDialog(null, "Data berhasil Delete !");
        } catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, "maaf Delete data gagal !");
        }
    }//GEN-LAST:event_btn_delete_masukActionPerformed

//    GET DATA BELUM BAYAR
    private void form_belum_bayarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_form_belum_bayarMouseClicked
        int row = form_belum_bayar.rowAtPoint(evt.getPoint());
        
        String id = form_belum_bayar.getValueAt(row, 0).toString();
        masuk_id.setText(id);
        String nama = form_belum_bayar.getValueAt(row, 1).toString();
        masuk_nama.setText(nama);
        String npm = form_belum_bayar.getValueAt(row, 2).toString();
        masuk_npm.setText(npm);
        String tanggal = form_belum_bayar.getValueAt(row, 3).toString();
        masuk_tanggal.setText(tanggal);
        String jumlah = form_belum_bayar.getValueAt(row, 4).toString();
        masuk_uang.setText(jumlah);
        String ket = form_belum_bayar.getValueAt(row, 5).toString();
        keterangan.setSelectedItem(ket);
    }//GEN-LAST:event_form_belum_bayarMouseClicked

//    get value btn masuk on jtable kas masuk
    private void table_masukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_masukMouseClicked
        int row = table_masuk.rowAtPoint(evt.getPoint());

        String id = table_masuk.getValueAt(row, 0).toString();
        masuk_id.setText(id);
        String nama = table_masuk.getValueAt(row, 1).toString();
        masuk_nama.setText(nama);
        String npm = table_masuk.getValueAt(row, 2).toString();
        masuk_npm.setText(npm);
        String tanggal = table_masuk.getValueAt(row, 3).toString();
        masuk_tanggal.setText(tanggal);
        String jumlah = table_masuk.getValueAt(row, 4).toString();
        masuk_uang.setText(jumlah);
        String ket = table_masuk.getValueAt(row, 5).toString();
        keterangan.setSelectedItem(ket);
    }//GEN-LAST:event_table_masukMouseClicked

    private void header2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_header2PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_header2PropertyChange

    
    void setColor(JPanel panel){
        panel.setBackground(new Color(85,65,118));
    }
    
    void resetColor (JPanel panel){
        panel.setBackground (new Color(63,43,100));
    }
    
    
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btn_delete_masuk;
    private javax.swing.JButton btn_insert_masuk;
    private javax.swing.JButton btn_kaskeluar;
    private javax.swing.JPanel btn_mhs;
    private javax.swing.JPanel btn_ringkasan;
    private javax.swing.JPanel btn_uangkas;
    private javax.swing.JButton btn_update_masuk;
    private javax.swing.JPanel datamhs;
    private javax.swing.JScrollPane form_bayar;
    private javax.swing.JTable form_belum_bayar;
    private javax.swing.JPanel header;
    private javax.swing.JPanel header1;
    private javax.swing.JPanel header2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel keluar;
    private javax.swing.JTextArea keperluan;
    private javax.swing.JComboBox<String> keterangan;
    private javax.swing.JScrollPane keterangan_keluar;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logo1;
    private javax.swing.JLabel logo2;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JLabel masuk;
    private javax.swing.JTextField masuk_id;
    private javax.swing.JTextField masuk_nama;
    private javax.swing.JTextField masuk_npm;
    private javax.swing.JTextField masuk_tanggal;
    private javax.swing.JTextField masuk_uang;
    private javax.swing.JPanel ringkasan;
    private javax.swing.JPanel sidepanel;
    private javax.swing.JTable table_keluar;
    private javax.swing.JTable table_masuk;
    private javax.swing.JTextField tanggal_keluar;
    private javax.swing.JLabel total_kas;
    private javax.swing.JTextField uang_keluar;
    private javax.swing.JPanel uangkas;
    // End of variables declaration//GEN-END:variables
}

