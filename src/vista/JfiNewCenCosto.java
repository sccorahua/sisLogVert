/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import controlador.ConCentroCosto;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import modelo.CentroCosto;

//v1.0 SCN

public class JfiNewCenCosto extends javax.swing.JInternalFrame {

    /**
     * Creates new form JfiNewCenCosto
     */
    public JfiNewCenCosto() {
        initComponents();
        this.setSize(new Dimension(400, 330));
        this.setTitle("Nuevo Centro de Costo");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        InputCodCenCosto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        InputNomCenCosto = new javax.swing.JTextField();
        InputDirCenCosto = new javax.swing.JTextField();
        InputTelCenCosto = new javax.swing.JTextField();
        BtnRegistrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nuevo Centro de Costo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 390, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        jLabel2.setText("Código:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        InputCodCenCosto.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        getContentPane().add(InputCodCenCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 65, 220, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        jLabel4.setText("Dirección:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        jLabel5.setText("Teléfono:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        InputNomCenCosto.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        getContentPane().add(InputNomCenCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 105, 220, -1));

        InputDirCenCosto.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        getContentPane().add(InputDirCenCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 145, 220, -1));

        InputTelCenCosto.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        getContentPane().add(InputTelCenCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 185, 220, -1));

        BtnRegistrar.setText("Registrar");
        BtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarActionPerformed
        CentroCosto cenCosto = new CentroCosto();
        ConCentroCosto metodCenCosto = new ConCentroCosto();

        //validaciones
        //no admite "-" el codigo
        if (InputCodCenCosto.getText().contains("-")) {
            JOptionPane.showMessageDialog(null, "El codigo no puede contener guiones");
        } else if (InputNomCenCosto.getText().trim().isEmpty() || InputDirCenCosto.getText().trim().isEmpty() || InputTelCenCosto.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Es necesario completar todos los campos");
        } else if (!metodCenCosto.conCentroCosto(InputCodCenCosto.getText(), InputNomCenCosto.getText(), InputDirCenCosto.getText()).getId_cen_costo().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ya se encuentra registrado el Centro de Costo. Nombre al que hace referencia al Centro de Costo con codigo y nombre: " + metodCenCosto.conCentroCosto(InputCodCenCosto.getText(), InputNomCenCosto.getText(), InputDirCenCosto.getText()).getId_cen_costo() + " / " + metodCenCosto.conCentroCosto(InputCodCenCosto.getText(), InputNomCenCosto.getText(), InputDirCenCosto.getText()).getId_cen_costo() + ". Con dirección: " + metodCenCosto.conCentroCosto(InputCodCenCosto.getText(), InputNomCenCosto.getText(), InputDirCenCosto.getText()).getDir_cen_costo());
        }else{
            cenCosto.setId_cen_costo(InputCodCenCosto.getText());
            cenCosto.setNom_cen_costo(InputNomCenCosto.getText());
            cenCosto.setDir_cen_costo(InputDirCenCosto.getText());
            cenCosto.setTel_cen_costo(InputTelCenCosto.getText());

            if (metodCenCosto.insCentroCosto(cenCosto)) {
                JOptionPane.showMessageDialog(null, "Se registro correctamente");
                InputCodCenCosto.setText("");
                InputNomCenCosto.setText("");
                InputDirCenCosto.setText("");
                InputTelCenCosto.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Error al momento de guardar. Verificar");

            }
        }
    }//GEN-LAST:event_BtnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRegistrar;
    private javax.swing.JTextField InputCodCenCosto;
    private javax.swing.JTextField InputDirCenCosto;
    private javax.swing.JTextField InputNomCenCosto;
    private javax.swing.JTextField InputTelCenCosto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
