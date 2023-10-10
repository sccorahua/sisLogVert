package vista;

import controlador.ConTipoCambio;
import java.awt.Dimension;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import modelo.TipoCambio;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JTextField;

//v1.0 SCN
public class JfiRegTipoCambio extends javax.swing.JInternalFrame {

    public JfiRegTipoCambio() {
        initComponents();
        this.setSize(new Dimension(400, 280));
        this.setTitle("Registrar tipo de cambio");
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
        jLabel3 = new javax.swing.JLabel();
        InputTipCamCompra = new javax.swing.JTextField();
        InputTipCamVenta = new javax.swing.JTextField();
        CalendarFec = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        BtnRegistrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registrar Tipo de Cambio");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 390, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        jLabel2.setText("Compra:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 125, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        jLabel3.setText("Venta:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 155, -1, -1));

        InputTipCamCompra.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        getContentPane().add(InputTipCamCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 80, -1));

        InputTipCamVenta.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        getContentPane().add(InputTipCamVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 80, -1));

        CalendarFec.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(CalendarFec, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 150, -1));

        jLabel4.setText("Fecha:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 75, -1, -1));

        BtnRegistrar.setText("Registrar");
        BtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarActionPerformed
        TipoCambio tipoCambio = new TipoCambio();
        ConTipoCambio metodTipCam = new ConTipoCambio();
        Date fecha = null;
        try {
            fecha = new Date(CalendarFec.getDate().getTime());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una fecha valida");
        }

        if (InputTipCamCompra.getText().trim().isEmpty() || InputTipCamVenta.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Es obligatorio ingresar un valor en compra/venta");
        } else if (!valInput(InputTipCamCompra.getText())) {
            JOptionPane.showMessageDialog(null, "El valor ingresado en compra no es valida.Verificar");
        } else if (!valInput(InputTipCamVenta.getText())) {
            JOptionPane.showMessageDialog(null, "El valor ingresado en venta no es valida.Verificar");
        } else if (metodTipCam.conFecha(fecha).getFec_tip_cambio() != null) {
            JOptionPane.showMessageDialog(null, metodTipCam.conFecha(fecha).getFec_tip_cambio());
            JOptionPane.showMessageDialog(null, "Ya se ingreso un tipo de cambio para la fecha seleccionada.");
        } else if (((JTextField) CalendarFec.getDateEditor().getUiComponent()).getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe asignar una fecha.");
        } else {
            tipoCambio.setFec_tip_cambio(fecha);
            tipoCambio.setTip_cambio_compra(conStringToDouble(InputTipCamCompra.getText()));
            tipoCambio.setTip_cambio_venta(conStringToDouble(InputTipCamVenta.getText()));
            if (metodTipCam.InsTipCambio(tipoCambio)) {
                JOptionPane.showMessageDialog(null, "Se registro correctamente");
                InputTipCamCompra.setText("");
                InputTipCamVenta.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Se ingreso de forma incorrecta un dato. favor de revisar");
            }
        }
    }//GEN-LAST:event_BtnRegistrarActionPerformed

    private boolean valInput(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private BigDecimal conStringToDouble(String number) {
        BigDecimal valor = new BigDecimal(0);
        try {
            valor = new BigDecimal(number);
            return valor;
        } catch (NumberFormatException e) {
            return valor;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRegistrar;
    private com.toedter.calendar.JDateChooser CalendarFec;
    private javax.swing.JTextField InputTipCamCompra;
    private javax.swing.JTextField InputTipCamVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}