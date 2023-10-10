package vista;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import vista.ordenCompra.JfiOpcionOrdenCompra;
import vista.ordenServicio.JfiOpcionOrdenServicio;
import vista.ordenServicio.JfiOrdenServicio;

public class JfMenu extends javax.swing.JFrame {

    public static JDesktopPane MenuPanel;

    public JfMenu() {
        Calendar fecha = new GregorianCalendar();
        initComponents();
        this.setSize(new Dimension(900, 600));
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setTitle("Menú Principal - Energias Verdes Perú");

        this.setLayout(null);
        MenuPanel = new JDesktopPane();
        /*      
        BufferedImage img = null;
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/img/logo-couleurs.png"));
        } catch (IOException e) {
            System.out.prinln("Error: " + e);
        }
         */
        this.setContentPane(MenuPanel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        OpcCrearCategoria = new javax.swing.JMenuItem();
        OpcCrearItem = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        OpcCrearAlmacen = new javax.swing.JMenuItem();
        OpcCrearCenCosto = new javax.swing.JMenuItem();
        OpcRegTipCambio = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        OpcIngresoAlmacen = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        OpcOrdenCompra = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 550));

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/configuraciones.png"))); // NOI18N
        jMenu1.setText("Administrar");
        jMenu1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jMenu1.setMargin(new java.awt.Insets(3, 9, 3, 9));

        OpcCrearCategoria.setText("Crear categoria");
        OpcCrearCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcCrearCategoriaActionPerformed(evt);
            }
        });
        jMenu1.add(OpcCrearCategoria);

        OpcCrearItem.setText("Crear Artículo");
        OpcCrearItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcCrearItemActionPerformed(evt);
            }
        });
        jMenu1.add(OpcCrearItem);

        jMenuItem3.setText("Crear proveedor");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        OpcCrearAlmacen.setText("Crear almacén");
        OpcCrearAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcCrearAlmacenActionPerformed(evt);
            }
        });
        jMenu1.add(OpcCrearAlmacen);

        OpcCrearCenCosto.setText("Crear centro de costo");
        OpcCrearCenCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcCrearCenCostoActionPerformed(evt);
            }
        });
        jMenu1.add(OpcCrearCenCosto);

        OpcRegTipCambio.setText("Tipo de Cambio");
        OpcRegTipCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcRegTipCambioActionPerformed(evt);
            }
        });
        jMenu1.add(OpcRegTipCambio);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/categorias.png"))); // NOI18N
        jMenu2.setText("Almacen");
        jMenu2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jMenu2.setMargin(new java.awt.Insets(3, 9, 3, 9));

        OpcIngresoAlmacen.setText("Ingreso");
        OpcIngresoAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcIngresoAlmacenActionPerformed(evt);
            }
        });
        jMenu2.add(OpcIngresoAlmacen);

        jMenuItem7.setText("Salida");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        OpcOrdenCompra.setText("Orden Compra");
        OpcOrdenCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcOrdenCompraActionPerformed(evt);
            }
        });
        jMenu2.add(OpcOrdenCompra);

        jMenuItem10.setText("Orden Servicio");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuItem11.setText("Consulta Stock");
        jMenuItem11.setToolTipText("");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem11);

        jMenuItem12.setText("Reportes");
        jMenu2.add(jMenuItem12);

        jMenuBar1.add(jMenu2);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carrito.png"))); // NOI18N
        jMenu4.setText("Activo Fijo");
        jMenu4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jMenu4.setMargin(new java.awt.Insets(3, 9, 3, 9));

        jMenuItem13.setText("Registro");
        jMenu4.add(jMenuItem13);

        jMenuItem14.setText("Consulta Stock");
        jMenu4.add(jMenuItem14);

        jMenuItem15.setText("Reportes");
        jMenu4.add(jMenuItem15);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario.png"))); // NOI18N
        jMenu5.setText("Usuario");
        jMenu5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N

        jMenuItem16.setText("Cambiar Contraseña");
        jMenu5.add(jMenuItem16);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpcCrearItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcCrearItemActionPerformed
        JfiNewItem jfiNewItem = new JfiNewItem();
        MenuPanel.add(jfiNewItem);
        jfiNewItem.setVisible(true);
    }//GEN-LAST:event_OpcCrearItemActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JfiNewProveedor jfiNewProveedor = new JfiNewProveedor();
        MenuPanel.add(jfiNewProveedor);
        jfiNewProveedor.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void OpcRegTipCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcRegTipCambioActionPerformed
        JfiRegTipoCambio jfiRegTipoCambio = new JfiRegTipoCambio();
        MenuPanel.add(jfiRegTipoCambio);
        jfiRegTipoCambio.setVisible(true);
    }//GEN-LAST:event_OpcRegTipCambioActionPerformed

    private void OpcIngresoAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcIngresoAlmacenActionPerformed
        JfiNewIngresoMovAlmacen jfiNewIngresoMovAlmacen = new JfiNewIngresoMovAlmacen();
        MenuPanel.add(jfiNewIngresoMovAlmacen);
        jfiNewIngresoMovAlmacen.setVisible(true);
    }//GEN-LAST:event_OpcIngresoAlmacenActionPerformed

    private void OpcCrearCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcCrearCategoriaActionPerformed
        JfiNewCategoria jfiNewCategoria = new JfiNewCategoria();
        MenuPanel.add(jfiNewCategoria);
        jfiNewCategoria.setVisible(true);
    }//GEN-LAST:event_OpcCrearCategoriaActionPerformed

    private void OpcCrearAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcCrearAlmacenActionPerformed
        JfiNewAlmacen jfiNewAlmacen = new JfiNewAlmacen();
        MenuPanel.add(jfiNewAlmacen);
        jfiNewAlmacen.setVisible(true);
    }//GEN-LAST:event_OpcCrearAlmacenActionPerformed

    private void OpcCrearCenCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcCrearCenCostoActionPerformed
        JfiNewCenCosto jfiNewCenCosto = new JfiNewCenCosto();
        MenuPanel.add(jfiNewCenCosto);
        jfiNewCenCosto.setVisible(true);
    }//GEN-LAST:event_OpcCrearCenCostoActionPerformed

    private void OpcOrdenCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcOrdenCompraActionPerformed
        JfiOpcionOrdenCompra jfiOpcionOrdenCompra = new JfiOpcionOrdenCompra();
        MenuPanel.add(jfiOpcionOrdenCompra);
        jfiOpcionOrdenCompra.setVisible(true);
    }//GEN-LAST:event_OpcOrdenCompraActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        JfiNewSalidaMovAlmacen jfiNewSalidaMovAlmacen = new JfiNewSalidaMovAlmacen();
        MenuPanel.add(jfiNewSalidaMovAlmacen);
        jfiNewSalidaMovAlmacen.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        JfiConsultaStock jfiConsultaStock = new JfiConsultaStock();
        MenuPanel.add(jfiConsultaStock);
        jfiConsultaStock.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        JfiOpcionOrdenServicio jfiOpcionOrdenServicio = new JfiOpcionOrdenServicio();
        MenuPanel.add(jfiOpcionOrdenServicio);
        jfiOpcionOrdenServicio.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

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
            java.util.logging.Logger.getLogger(JfMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem OpcCrearAlmacen;
    private javax.swing.JMenuItem OpcCrearCategoria;
    private javax.swing.JMenuItem OpcCrearCenCosto;
    private javax.swing.JMenuItem OpcCrearItem;
    private javax.swing.JMenuItem OpcIngresoAlmacen;
    private javax.swing.JMenuItem OpcOrdenCompra;
    private javax.swing.JMenuItem OpcRegTipCambio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
