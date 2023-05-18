/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uf6projecte;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import static uf6projecte.UF6Projecte.BD_NAME;
import static uf6projecte.UF6Projecte.PORT;
import static uf6projecte.UF6Projecte.PWD;
import static uf6projecte.UF6Projecte.URL;
import static uf6projecte.UF6Projecte.USER;

/**
 *
 * @author Pablo Jiménez
 */
public class ModificarGrups extends javax.swing.JFrame {

    /**
     * Creates new form ModificarGrups
     */
    public static boolean isOpen = false;
    private GrupEntity grups;
    private ArrayList<GrupEntity> llista_grups;
    private int index;
    

    /**
     * Creates new form AfegirAlumne
     */
    public ModificarGrups()  {
        try {
            
            grups = VentanaGrups.getGrupActual();
            GrupTable gpTable = new GrupTable();
            BDConnection bdCon = new BDConnection(URL, PORT, BD_NAME, USER, PWD);
            gpTable.setConnection(bdCon);
            isOpen = true;
            llista_grups = gpTable.GetAll();
            index = llista_grups.indexOf(grups);
            setResizable(false);
            initComponents();

        } catch (SQLException | NullConnectionException |ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
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

        nomGrup = new javax.swing.JTextField(grups.getNom());
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        quotaGrup = new javax.swing.JTextField(Float.parseFloat(grups.getQuota()));
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        nAlumnesGrup = new javax.swing.JTextField(grups.getnumAlumnes());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nomGrup.setText("Introdueix el nom");

        jLabel1.setText("Nom:");

        jLabel3.setText("Quota:");

        quotaGrup.setText("Introdueix la quota");

        jLabel4.setText("Nº Alumnes:");

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        nAlumnesGrup.setText("Introdueix el nom d'alumnes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomGrup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quotaGrup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nAlumnesGrup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jButton1)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomGrup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quotaGrup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(nAlumnesGrup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            if (nomGrup.getText().equals("") || quotaGrup.getText().equals("")
                    || nAlumnesGrup.getText().equals("")) {
                throw new CampBuitException();
            }
            int codiGrup = llista_grups.get(index).getID();
            GrupEntity grups = new GrupEntity(codiGrup, nomGrup.getText(), Integer.parseInt(nAlumnesGrup.getText()), Float.parseFloat(quotaGrup.getText()));
            GrupTable grupTable = new GrupTable();
            BDConnection bdCon;
            bdCon = new BDConnection(URL, PORT, BD_NAME, USER, PWD);
            grupTable.setConnection(bdCon);
            grupTable.Update(grups);
            JOptionPane.showMessageDialog(null, "Grup modificat",
                    "Modificar", JOptionPane.INFORMATION_MESSAGE);
            VentanaAlumnes ventAlum = new VentanaAlumnes();
            ventAlum.actualitzarMostrar();
        } catch (ClassNotFoundException | NullConnectionException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR, el grup amb aquest codi ja existeix",
                    "ERROR", JOptionPane.WARNING_MESSAGE);
        } catch (CampBuitException ex) {
            JOptionPane.showMessageDialog(null, "ERROR, un dels camps és buit",
                    "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarGrups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarGrups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarGrups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarGrups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarGrups().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nAlumnesGrup;
    private javax.swing.JTextField nomGrup;
    private javax.swing.JTextField quotaGrup;
    // End of variables declaration//GEN-END:variables
}