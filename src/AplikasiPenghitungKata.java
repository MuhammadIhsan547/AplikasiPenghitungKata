
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class AplikasiPenghitungKata extends javax.swing.JFrame {

    /**
     * Creates new form AplikasiPenghitungKata
     */
    public AplikasiPenghitungKata() {
        initComponents();
        
        Target.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                MethodHitung();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                MethodHitung();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                MethodHitung();
            }
        });
        
        TombolSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TombolSimpanActionPerformed(evt);
            }
        });
        
        // Set nilai default pada label
        LabelTotalKata.setText("Jumlah Kata: 0");
        LabelTotalKarakter.setText("Jumlah Karakter: 0");
        LabelTotalKalimat.setText("Jumlah Kalimat: 0");
        LabelTotalParagraf.setText("Jumlah Paragraf: 0");
    }
    
    // Metode untuk menghitung kata, karakter, kalimat, dan paragraf
    private void MethodHitung() {
        String isiTeks = Target.getText();

        if (isiTeks.trim().isEmpty()) {
            // Set nilai default pada label jika teks kosong
            LabelTotalKata.setText("Jumlah Kata: 0");
            LabelTotalKarakter.setText("Jumlah Karakter: 0");
            LabelTotalKalimat.setText("Jumlah Kalimat: 0");
            LabelTotalParagraf.setText("Jumlah Paragraf: 0");
            return;  // Tidak perlu menghitung jika teks kosong
        }

        // Menghitung jumlah karakter
        int totalKarakter = isiTeks.length();

        // Menghitung jumlah kata
        String[] kataArray = isiTeks.trim().split("\\s+");
        int totalKata = kataArray.length;

        // Menghitung jumlah kalimat
        String[] kalimatArray = isiTeks.split("[.!?]+");
        int totalKalimat = kalimatArray.length;

        // Menghitung jumlah paragraf
        String[] paragrafArray = isiTeks.split("\\n+");
        int totalParagraf = paragrafArray.length;

        // Tampilkan hasil hitung pada Label
        LabelTotalKata.setText("Total Kata: " + totalKata);
        LabelTotalKarakter.setText("Total Karakter: " + totalKarakter);
        LabelTotalKalimat.setText("Total Kalimat: " + totalKalimat);
        LabelTotalParagraf.setText("Total Paragraf: " + totalParagraf);
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Target = new javax.swing.JTextArea();
        LabelTotalKata = new javax.swing.JLabel();
        LabelTotalKarakter = new javax.swing.JLabel();
        LabelTotalKalimat = new javax.swing.JLabel();
        LabelTotalParagraf = new javax.swing.JLabel();
        CariKata = new javax.swing.JTextField();
        LabelCariKata = new javax.swing.JLabel();
        TombolCari = new javax.swing.JButton();
        TombolKeluar = new javax.swing.JButton();
        TombolSimpan = new javax.swing.JButton();
        TombolHitung = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Penghitung Kata");

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Aplikasi Penghitung Kata");

        Target.setColumns(20);
        Target.setRows(5);
        jScrollPane1.setViewportView(Target);

        LabelTotalKata.setText("Total Kata : ");

        LabelTotalKarakter.setText("Total Karakter : ");

        LabelTotalKalimat.setText("Total Kalimat : ");

        LabelTotalParagraf.setText("Total Paragraf : ");

        LabelCariKata.setText("Cari Kata");

        TombolCari.setText("Cari");
        TombolCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TombolCariActionPerformed(evt);
            }
        });

        TombolKeluar.setText("Keluar");
        TombolKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TombolKeluarActionPerformed(evt);
            }
        });

        TombolSimpan.setText("Simpan");
        TombolSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TombolSimpanActionPerformed(evt);
            }
        });

        TombolHitung.setText("Hitung");
        TombolHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TombolHitungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LabelTotalKata)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 315, Short.MAX_VALUE)
                        .addComponent(LabelCariKata)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CariKata, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TombolCari))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(TombolKeluar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelTotalKarakter)
                            .addComponent(LabelTotalKalimat)
                            .addComponent(LabelTotalParagraf)
                            .addComponent(TombolHitung)
                            .addComponent(TombolSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTotalKata)
                    .addComponent(CariKata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelCariKata)
                    .addComponent(TombolCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelTotalKarakter)
                .addGap(15, 15, 15)
                .addComponent(LabelTotalKalimat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelTotalParagraf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TombolHitung)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TombolSimpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(TombolKeluar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TombolCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TombolCariActionPerformed
        // TODO add your handling code here:
        String carikata = CariKata.getText().trim();
        String harusteks = Target.getText();

        // Mengecek apakah input kata dan teks tidak kosong
        if (carikata.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan kata yang ingin dicari.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (harusteks.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Teks dilarang kosong. Tolong Masukkan teks terlebih dahulu.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Menghitung jumlah kemunculan kata
        String[] kataArray = harusteks.split("\\s+");
        int totalmuncul = 0;
        for (String kata : kataArray) {
            if (kata.equalsIgnoreCase(carikata)) {
                totalmuncul++;
            }
        }

        // Menampilkan hasil
        JOptionPane.showMessageDialog(this, "Kata '" + carikata + "': " + totalmuncul);
                                        
    }//GEN-LAST:event_TombolCariActionPerformed

    private void TombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TombolSimpanActionPerformed
        // TODO add your handling code here:
        // Cek apakah Target Area kosong
        if (Target.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Teks tidak boleh kosong. Masukkan teks terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Batalkan proses penyimpanan
        }

        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (PrintWriter writer = new PrintWriter(fileToSave)) {
                // Menulis isi teks
                writer.println("Isi Teks:");
                writer.println(Target.getText());

                // Menulis hasil perhitungan
                writer.println("\nHasil Perhitungan:");
                writer.println(LabelTotalKata.getText());
                writer.println(LabelTotalKarakter.getText());
                writer.println(LabelTotalKalimat.getText());
                writer.println(LabelTotalParagraf.getText());

                JOptionPane.showMessageDialog(this, "File berhasil disimpan.", "Simpan Berhasil", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    
    }//GEN-LAST:event_TombolSimpanActionPerformed

    private void TombolHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TombolHitungActionPerformed
        // TODO add your handling code here:
        MethodHitung();
    }//GEN-LAST:event_TombolHitungActionPerformed

    private void TombolKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TombolKeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_TombolKeluarActionPerformed

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
            java.util.logging.Logger.getLogger(AplikasiPenghitungKata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplikasiPenghitungKata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplikasiPenghitungKata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplikasiPenghitungKata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplikasiPenghitungKata().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CariKata;
    private javax.swing.JLabel LabelCariKata;
    private javax.swing.JLabel LabelTotalKalimat;
    private javax.swing.JLabel LabelTotalKarakter;
    private javax.swing.JLabel LabelTotalKata;
    private javax.swing.JLabel LabelTotalParagraf;
    private javax.swing.JTextArea Target;
    private javax.swing.JButton TombolCari;
    private javax.swing.JButton TombolHitung;
    private javax.swing.JButton TombolKeluar;
    private javax.swing.JButton TombolSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
