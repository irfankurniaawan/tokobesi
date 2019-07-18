/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokobesi;

/**
 *
 * @author lenovo
 */

import Koneksi.KoneksiDBS;
import java.sql.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class formtransaksi extends javax.swing.JFrame {
    private DefaultTableModel model;
    
    String noJual, kdProduk, nmProduk, xtotal;
    int hrg_jual, qty;
    double total, bayar, kembali, sTotal;

    /**
     * Creates new form formtransaksi
     */
    
    
    public formtransaksi() {
        initComponents();
        
         model = new DefaultTableModel();
        
        tblTransaksi.setModel(model);
        model.addColumn("NOMOR PRNJUALAN");
        model.addColumn("KODE PRODUK");
        model.addColumn("NAMA PRODUK");
        model.addColumn("HARGA JUAL");
        model.addColumn("QTY");
        model.addColumn("SUBTOTAL");
        
    }
   
    
    public void loadDataProduk(){
        noJual = txtNoJual.getText();
        kdProduk = txtKdProduk.getText();
        nmProduk = txtNmProduk.getText();
        hrg_jual = Integer.parseInt(txtHrg.getText());
        qty = Integer.parseInt(txtQty.getText());
        total = Integer.parseInt(lblTotal.getText());
        bayar = Integer.parseInt(txtBayar.getText());
        kembali = Integer.parseInt(lblKembali.getText());
    }
    
    public void reset(){
        noJual = "";
        kdProduk = "";       
        nmProduk = "";
        hrg_jual = 0;
        qty = 0;
        total = 0;
        bayar = 0;
        kembali =0;
        
        txtNoJual.setText(noJual);
        txtKdProduk.setText(kdProduk);
        txtNmProduk.setText(nmProduk);
        txtHrg.setText("0");
        txtQty.setText("0");
        lblTotal.setText("0");
        txtBayar.setText("0");
        lblKembali.setText("0");
    }
      public void dataProduk(){   
        try{
            Statement stat = (Statement) KoneksiDBS.getKoneksi().createStatement();
           
            String sql = "SELECT * FROM master_produk WHERE kode_produk = '"+ txtKdProduk.getText() +"'";
            ResultSet res = stat.executeQuery(sql);
                        
            while(res.next()){
               txtNmProduk.setText(res.getString("nama_produk"));
               txtHrg.setText(res.getString("harga_jual"));
            }
        }catch(SQLException err){
           JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
      
     public void masukTabel(){
        try{
            String noJual=txtNoJual.getText();
            String kdProduk=txtKdProduk.getText();
            String nmProduk=txtNmProduk.getText();
            double hrg=Double.parseDouble(txtHrg.getText());
            int jml=Integer.parseInt(txtQty.getText());
            sTotal = hrg*jml;
            total = total + sTotal;
            xtotal=Double.toString(total);
            lblTotal.setText(xtotal);
            model.addRow(new Object[]{noJual,kdProduk,nmProduk,hrg,jml,sTotal});
        }
        catch(Exception e){
            System.out.println("Error : "+e);
        }
    }
     
     public void simpanDataTransaksi(){ 
        bayar = Double.parseDouble(txtBayar.getText());
        kembali = bayar - total;
        String xkembali=Double.toString(kembali);
        lblKembali.setText(xkembali);
       
        try{
            Statement stat = (Statement) KoneksiDBS.getKoneksi().createStatement();
            
            String  sql =   "INSERT INTO transaksi(nomor_penjualan, kode_produk,nama_produk, harga_jual, jumlah, total, bayar, kembali)"
                            + "VALUES('"+ txtNoJual.getText() +"','"+ txtKdProduk.getText() +"','"+txtNmProduk.getText()+"','"+ txtHrg.getText() +"','"+ txtQty.getText() +"','"+ total +"', '"+ txtBayar.getText() +"', '"+ kembali +"')";
            PreparedStatement p = (PreparedStatement) KoneksiDBS.getKoneksi().prepareStatement(sql);
            p.executeUpdate();
            
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
     
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNmProduk = new javax.swing.JTextField();
        lblKembali = new javax.swing.JLabel();
        txtHrg = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransaksi = new javax.swing.JTable();
        tblSimpan = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmdKeranjang = new javax.swing.JButton();
        txtNoJual = new javax.swing.JTextField();
        txtBayar = new javax.swing.JTextField();
        txtKdProduk = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNmProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNmProdukActionPerformed(evt);
            }
        });

        lblKembali.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblKembali.setText("NOMINAL KEMBALIAN");

        tblTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTransaksi);

        tblSimpan.setText("SIMPAN");
        tblSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblSimpanActionPerformed(evt);
            }
        });

        label.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        label.setText("TOTAL");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("BAYAR");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotal.setText("NOMINAL TOTAL");

        jLabel1.setText("TRANSAKSI PENJUALAN");

        jLabel2.setText("NOMOR PENJUALAN");

        jLabel3.setText("KODE PRODUK");

        jLabel4.setText("NAMA PRODUK");

        jLabel5.setText("HARGA");

        jLabel6.setText("QTY");

        cmdKeranjang.setText("BELI");
        cmdKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKeranjangActionPerformed(evt);
            }
        });

        txtBayar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBayarActionPerformed(evt);
            }
        });

        txtKdProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKdProdukActionPerformed(evt);
            }
        });
        txtKdProduk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKdProdukKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("KEMBALI");

        jButton1.setText("KELUAR");
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cmdKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tblSimpan))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(79, 79, 79))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtKdProduk))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 55, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNmProduk)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHrg, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNoJual, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(label)
                            .addComponent(jLabel9))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblKembali)
                            .addComponent(txtBayar, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel1)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtNoJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtKdProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNmProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label)
                                    .addComponent(lblTotal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblKembali)))
                                .addGap(3, 3, 3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(46, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdKeranjang)
                            .addComponent(tblSimpan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(94, 94, 94))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblSimpanActionPerformed
        //memanggil fungsi simpan data transaksi
        simpanDataTransaksi();
    }//GEN-LAST:event_tblSimpanActionPerformed

    private void cmdKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKeranjangActionPerformed
        //memanggil fungsi masuk tabel sementara
        masukTabel();
    }//GEN-LAST:event_cmdKeranjangActionPerformed

    private void txtKdProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKdProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKdProdukActionPerformed

    private void txtKdProdukKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKdProdukKeyReleased
        //memanggil fungsi data produk
        dataProduk();
    }//GEN-LAST:event_txtKdProdukKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new master().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNmProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNmProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNmProdukActionPerformed

    private void txtBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBayarActionPerformed

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
            java.util.logging.Logger.getLogger(formtransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formtransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formtransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formtransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formtransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdKeranjang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel lblKembali;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JButton tblSimpan;
    private javax.swing.JTable tblTransaksi;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtHrg;
    private javax.swing.JTextField txtKdProduk;
    private javax.swing.JTextField txtNmProduk;
    private javax.swing.JTextField txtNoJual;
    private javax.swing.JTextField txtQty;
    // End of variables declaration//GEN-END:variables
}