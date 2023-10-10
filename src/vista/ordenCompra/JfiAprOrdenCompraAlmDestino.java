package vista.ordenCompra;

// v1.0 SCN
import controlador.ConAlmacen;
import controlador.ConInventarioAlmacen;
import controlador.ConMovimientoAlmacen;
import controlador.ConOrdenCompra;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Almacen;
import modelo.InventarioAlmacen;
import modelo.ItemOrdenCompraInter;
import modelo.ItemOrdenCompraNacional;
import modelo.MovimientoAlmacen;
import modelo.OrdenCompraInter;
import modelo.OrdenCompraNacional;

public class JfiAprOrdenCompraAlmDestino extends javax.swing.JInternalFrame {

    public JfiAprOrdenCompraAlmDestino(String ano, String periodo, String correlativo, String tipo) {
        initComponents();
        this.setTitle("Almacen destino");
        this.setSize(new Dimension(240, 230));

        //valores
        this.anoS = Integer.parseInt(ano);
        this.periodoS = Integer.parseInt(periodo);
        this.correlS = Integer.parseInt(correlativo);
        this.tipS = tipo;

        //comboAlmacen
        ComboAlmacen.removeAllItems();
        ComboAlmacen.addItem("Elija una opción");
        ConAlmacen alm = new ConAlmacen();
        ArrayList<Almacen> listAlm = alm.getListAlmacen();
        for (int i = 0; i < listAlm.size(); i++) {
            ComboAlmacen.addItem(listAlm.get(i).getCod_alm() + "-" + listAlm.get(i).getNom_alm());
        }
    }

    //valores
    private int anoS;
    private int periodoS;
    private int correlS;
    private String tipS;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComboAlmacen = new javax.swing.JComboBox<>();
        btnConfirmar = new javax.swing.JButton();
        InputComent = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ComboAlmacen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(ComboAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 170, -1));

        btnConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));
        getContentPane().add(InputComent, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 170, -1));

        jLabel1.setText("Comentario:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        boolean error = false;
        int cont = 0;

        if (InputComent.getText().length() > 120) {
            error = true;
            JOptionPane.showMessageDialog(null, "La cantidad maxima es de 120 caracteres");
        }

        if (tipS.equals("N") && !error) {
            ConMovimientoAlmacen conMov = new ConMovimientoAlmacen();
            ConOrdenCompra conCompra = new ConOrdenCompra();
            OrdenCompraNacional compra = conCompra.getOneCompraNac(anoS, periodoS, correlS);
            ArrayList<ItemOrdenCompraNacional> ListArticulo = conCompra.getListItemOfCompraNac(anoS, periodoS, correlS);
            ConInventarioAlmacen conInv = new ConInventarioAlmacen();
            
            String[] split = ComboAlmacen.getSelectedItem().toString().split("-");
            String idAlm = split[0];

            String[] split1 = String.valueOf(anoS).split("20");
            String anoC = split1[1];

            if (compra.getEstado().equals("P")) {
                for (int i = 0; i < ListArticulo.size(); i++) {
                    MovimientoAlmacen mov = new MovimientoAlmacen();
                    mov.setCod_almacen(idAlm);
                    mov.setId_item(ListArticulo.get(i).getId_item());
                    mov.setMot_mov("orden de Compra Nacional");
                    mov.setFec_mov(compra.getFec_ord_com());
                    mov.setId_proveedor(compra.getId_proveedor());
                    mov.setCantidad(ListArticulo.get(i).getCantidad());
                    mov.setPrecio_unit(ListArticulo.get(i).getPrecioU());
                    mov.setRef_mov(String.valueOf("NAC" + rell0(correlS) + "-" + anoC));
                    mov.setComentario(InputComent.getText());

                    InventarioAlmacen inv = new InventarioAlmacen();
                    
                    inv.setId_almacen(idAlm);
                    inv.setId_item(ListArticulo.get(i).getId_item());
                    inv.setPrecio_red(ListArticulo.get(i).getPrecioU());
                    inv.setCantidad(ListArticulo.get(i).getCantidad());
                    
                    conInv.regItemInventario(inv, "I");
                    
                    if (conMov.InsIngresoMovAlmacen(mov)) {
                        cont += 1;
                    }
                }

                if (!conCompra.modEstadoCompraNac(compra)) {
                    JOptionPane.showMessageDialog(null, "Error al momento de aprobar la cabecera de la OC Nacional, por favor comunicarse con soporte del aplicativo");
                }

                JOptionPane.showMessageDialog(null, "Se ingresaron " + cont + " distintos productos correctamente de la OC Nacional: NAC" + rell0(correlS) + "-" + anoC);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "La OC Nacional ya fue aprobada");
            }
        }

        if (tipS.equals("I") && !error) {
            ConMovimientoAlmacen conMov = new ConMovimientoAlmacen();
            ConOrdenCompra conCompra = new ConOrdenCompra();
            OrdenCompraInter compra = conCompra.getOneCompraInt(anoS, periodoS, correlS);
            ArrayList<ItemOrdenCompraInter> ListArticulo = conCompra.getListItemOfCompraInt(anoS, periodoS, correlS);

            String[] split = ComboAlmacen.getSelectedItem().toString().split("-");
            String idAlm = split[0];

            String[] split1 = String.valueOf(anoS).split("20");
            String anoC = split1[1];

            if (compra.getEstado().equals("P")) {
                for (int i = 0; i < ListArticulo.size(); i++) {
                    MovimientoAlmacen mov = new MovimientoAlmacen();
                    mov.setCod_almacen(idAlm);
                    mov.setId_item(ListArticulo.get(i).getId_item());
                    mov.setMot_mov("orden de Compra Nacional");
                    mov.setFec_mov(compra.getFec_ord_com());
                    mov.setId_proveedor(compra.getId_proveedor());
                    mov.setCantidad(ListArticulo.get(i).getCantidad());
                    mov.setPrecio_unit(ListArticulo.get(i).getUni_precio());
                    mov.setRef_mov(String.valueOf("INT" + rell0(correlS) + "-" + anoC));
                    mov.setComentario(InputComent.getText());

                    if (conMov.InsIngresoMovAlmacen(mov)) {
                        cont += 1;
                    }
                }

                if (!conCompra.modEstadoCompraInt(compra)) {
                    JOptionPane.showMessageDialog(null, "Error al momento de aprobar la cabecera de la OC Nacional, por favor comunicarse con soporte del aplicativo");
                }

                JOptionPane.showMessageDialog(null, "Se ingresaron " + cont + " distintos productos correctamente de la OC Internacional: INT" + rell0(correlS) + "-" + anoC);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "La OC Internacional ya fue aprobada");
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboAlmacen;
    private javax.swing.JTextField InputComent;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private String rell0(int val) {
        String numCor = "";

        if (val < 10) {
            numCor = String.valueOf("000" + String.valueOf(val));
        } else if (val < 100) {
            numCor = String.valueOf("00" + String.valueOf(val));
        } else if (val < 1000) {
            numCor = String.valueOf("0" + String.valueOf(val));
        } else if (val < 10000) {
            numCor = String.valueOf(String.valueOf(val));
        }

        return numCor;
    }
}
