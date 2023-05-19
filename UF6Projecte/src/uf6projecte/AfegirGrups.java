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
public class AfegirGrups extends javax.swing.JFrame {

    /**
     * Creates new form AfegirGrups
     */
    public static boolean isOpen = false;

    /**
     * Creates new form AfegirAlumne
     */
    public AfegirGrups() {
        try {
            GrupTable gpTable = new GrupTable();
            BDConnection bdCon = new BDConnection(URL, PORT, BD_NAME, USER, PWD);
            gpTable.setConnection(bdCon);
            isOpen = true;
            setResizable(false);

            initComponents();

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static int confirmarOperacio() {
        int result = 0;
        String[] options = {"Si", "No"};
        int opcio = JOptionPane.showOptionDialog(
                null,
                "Estàs segur de realitzar la operació?",
                "Comfirmació",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, //no custom icon
                options, //button titles
                options[0] //default button
        );
        if (opcio == JOptionPane.YES_OPTION) {
            result = 0;
        } else if (opcio == JOptionPane.NO_OPTION) {
            result = 1;
        } else {
            result = 2;
        }
        return opcio;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomGrp = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codiGrup = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        quotaGr = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        afegirGrup = new javax.swing.JButton();
        nAlumnesGr = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        nomGrp.setText("Introdueix el nom");

        jLabel1.setText("Nom:");

        jLabel2.setText("Codi:");

        codiGrup.setText("Introdueix el codi");
        codiGrup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codiGrupActionPerformed(evt);
            }
        });

        jLabel3.setText("Quota:");

        quotaGr.setText("Introdueix la quota");

        jLabel4.setText("Nº Alumnes:");

        afegirGrup.setText("Afegir");
        afegirGrup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afegirGrupActionPerformed(evt);
            }
        });

        nAlumnesGr.setText("Introdueix num. de alumnes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel4))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codiGrup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomGrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quotaGr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nAlumnesGr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(afegirGrup)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(codiGrup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomGrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quotaGr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nAlumnesGr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(88, 88, 88)
                .addComponent(afegirGrup)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void afegirGrupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afegirGrupActionPerformed
        try {

            int opcio = confirmarOperacio();
            if (opcio == 0) {
                if (codiGrup.getText().equals("") || nomGrp.getText().equals("")
                        || nAlumnesGr.getText().equals("") || quotaGr.getText().equals("")) {
                    throw new CampBuitException();
                }

                GrupEntity grups = new GrupEntity(Integer.parseInt(codiGrup.getText()), nomGrp.getText(), Integer.parseInt(nAlumnesGr.getText()), Float.parseFloat(quotaGr.getText()));
                GrupTable grTable = new GrupTable();
                BDConnection bdCon;
                bdCon = new BDConnection(URL, PORT, BD_NAME, USER, PWD);
                grTable.setConnection(bdCon);
                grTable.Insert(grups);
                JOptionPane.showMessageDialog(null, "Grup afegit",
                        "Afegir", JOptionPane.INFORMATION_MESSAGE);
                VentanaGrups ventGrups = new VentanaGrups();
                ventGrups.actualitzarMostrar();
            } else if (opcio == 1) {
                JOptionPane.showMessageDialog(null, "Operació cancelada",
                        "ERROR", JOptionPane.WARNING_MESSAGE);
            }

        } catch (ClassNotFoundException | NullConnectionException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR, el Grup amb aquest codi ja existeix",
                    "ERROR", JOptionPane.WARNING_MESSAGE);
        } catch (CampBuitException ex) {
            JOptionPane.showMessageDialog(null, "ERROR, un dels camps és buit",
                    "ERROR", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_afegirGrupActionPerformed

    private void codiGrupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codiGrupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codiGrupActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        isOpen = false;
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(AfegirGrups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AfegirGrups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AfegirGrups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AfegirGrups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AfegirGrups().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton afegirGrup;
    private javax.swing.JTextField codiGrup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nAlumnesGr;
    private javax.swing.JTextField nomGrp;
    private javax.swing.JTextField quotaGr;
    // End of variables declaration//GEN-END:variables
}
