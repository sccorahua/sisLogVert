package vista.ordenServicio;

// v1.0 SCN
import controlador.ConOrdenServicio;
import controlador.ConProveedor;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.OrdenServicio;
import modelo.Proveedor;
import vista.JfMenu;
import static vista.ordenCompra.JfiOpcionOrdenCompra.TablaProd;

public class JfiOpcionOrdenServicio extends javax.swing.JInternalFrame {

    public JfiOpcionOrdenServicio() {
        initComponents();
        this.setTitle("Orden de Servicio");
        this.setSize(new Dimension(700, 360));
        //Combo de año
        relComboAno();
        //Combo de periodo
        ComboPeriodo.setEnabled(false);
        //Combo de estado
        ComboEstado.removeAllItems();
        ComboEstado.addItem("Pendiente");
        ComboEstado.addItem("Aprobado");
    }

    private int contadorAno = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProd = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ComboEstado = new javax.swing.JComboBox<>();
        ComboPeriodo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        ComboAno = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        InputIGV = new javax.swing.JTextField();
        BtnDetalles = new javax.swing.JButton();
        BtnAprobar = new javax.swing.JButton();
        BtnBuscar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Correlativo", "Fecha", "Proveedor", "Monto Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaProd);
        if (TablaProd.getColumnModel().getColumnCount() > 0) {
            TablaProd.getColumnModel().getColumn(0).setPreferredWidth(50);
            TablaProd.getColumnModel().getColumn(1).setPreferredWidth(100);
            TablaProd.getColumnModel().getColumn(2).setPreferredWidth(200);
            TablaProd.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 74, 487, 240));

        jLabel1.setText("Año:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 9, -1, -1));

        jLabel2.setText("Periodo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 37, -1, -1));

        ComboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(ComboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 6, 170, -1));

        ComboPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboPeriodoActionPerformed(evt);
            }
        });
        getContentPane().add(ComboPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 34, 172, -1));

        jLabel3.setText("Estado:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 9, -1, -1));

        ComboAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboAnoActionPerformed(evt);
            }
        });
        getContentPane().add(ComboAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 6, 171, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("Nuevo");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Orden Servicio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("IGV:");

        InputIGV.setText("18");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputIGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InputIGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(25, 25, 25))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 191, -1, 120));

        BtnDetalles.setText("Ver Detalles");
        BtnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDetallesActionPerformed(evt);
            }
        });
        getContentPane().add(BtnDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, -1, -1));

        BtnAprobar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnAprobar.setText("Aprobar");
        BtnAprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAprobarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnAprobar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 91, -1));

        BtnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 21, 91, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean error = false;
        String IGV = InputIGV.getText();
        try {
            int IntIGV = Integer.parseInt(IGV);
            if (IntIGV < 0 || IntIGV > 100) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un numero entre 0 y 100");
                error = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El valor ingresado en IGV es incorrecto. Debe ingresar un valor numerico: " + e);
            error = true;
        }

        if (!error) {
            this.setVisible(false);
            JfiOrdenServicio jfiOrdenServicio = new JfiOrdenServicio(IGV);
            JfMenu.MenuPanel.add(jfiOrdenServicio);
            jfiOrdenServicio.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ComboAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboAnoActionPerformed
        if (contadorAno > 0 && !ComboAno.getSelectedItem().toString().equals("Elija una opción")) {
            relComboPeriodo();
            ComboPeriodo.setEnabled(true);
        } else {
            ComboPeriodo.removeAllItems();
            ComboPeriodo.setEnabled(false);
        }
        contadorAno += 1;
    }//GEN-LAST:event_ComboAnoActionPerformed

    private void ComboPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboPeriodoActionPerformed

    }//GEN-LAST:event_ComboPeriodoActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        boolean error = false;

        if (ComboAno.getSelectedItem().equals("Elija una opción")) {
            JOptionPane.showMessageDialog(null, "Debe indicar un año para realizar la busqueda");
        }

        if (!error) {
            ConOrdenServicio controllerOrdenServicio = new ConOrdenServicio();
            ArrayList<OrdenServicio> ListServicio = new ArrayList<>();
            ConProveedor controllerProveedor = new ConProveedor();

            if (!ComboAno.getSelectedItem().toString().equals("Elija una opción") && !ComboPeriodo.getSelectedItem().toString().equals("Elija una opción") && ComboEstado.getSelectedItem().toString().equals("Elija una opción")) {
                ListServicio = controllerOrdenServicio.getOrdServicio(Integer.parseInt(ComboPeriodo.getSelectedItem().toString()), Integer.parseInt(ComboAno.getSelectedItem().toString()), "%");
            } else if (!ComboAno.getSelectedItem().toString().equals("Elija una opción") && !ComboPeriodo.getSelectedItem().toString().equals("Elija una opción") && !ComboEstado.getSelectedItem().toString().equals("Elija una opción")) {
                if (ComboEstado.getSelectedItem().toString().equals("Pendiente")) {
                    ListServicio = controllerOrdenServicio.getOrdServicio(Integer.parseInt(ComboAno.getSelectedItem().toString()), Integer.parseInt(ComboPeriodo.getSelectedItem().toString()), "P");
                }
                if (ComboEstado.getSelectedItem().toString().equals("Aprobado")) {
                    ListServicio = controllerOrdenServicio.getOrdServicio(Integer.parseInt(ComboAno.getSelectedItem().toString()), Integer.parseInt(ComboPeriodo.getSelectedItem().toString()), "A");
                }
            }
            DefaultTableModel modelo = (DefaultTableModel) TablaProd.getModel();
            modelo.setRowCount(ListServicio.size());
            
            for (int i = 0; i < ListServicio.size(); i++) {
                String correlativo = "OS" + rellCorrel(ListServicio.get(i).getNumero()) + "-" + ListServicio.get(i).getAno();
                TablaProd.setValueAt(correlativo, i, 0);
                TablaProd.setValueAt(ListServicio.get(i).getFecha().toString(), i, 1);

                Proveedor prov = controllerProveedor.conProveedor(String.valueOf(ListServicio.get(i).getProveedor()), "", "", "");

                TablaProd.setValueAt(prov.getNom_proveedor(), i, 2);

                if (ListServicio.get(i).getMoneda().equals("1")) {
                    TablaProd.setValueAt("S/. " + ListServicio.get(i).getTotal_sol().toString(), i, 3);
                } else if (ListServicio.get(i).getMoneda().equals("2")) {
                    TablaProd.setValueAt("$ " + ListServicio.get(i).getTotal_dol().toString(), i, 3);
                }
            }
        }
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void BtnAprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAprobarActionPerformed
        int rowS = TablaProd.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) TablaProd.getModel();

        String correlativo = modelo.getValueAt(rowS, 0).toString();
        String fecha = modelo.getValueAt(rowS, 1).toString();

        String[] split = correlativo.split("OS");
        String id = split[1];
        String[] split1 = id.split("-");
        String correl = String.valueOf(Integer.parseInt(split1[0]));
        String ano = split1[1];
        String[] split2 = fecha.split("-");
        String valor2 = split2[1];
        String periodo = String.valueOf(Integer.parseInt(valor2));

        int rpta = JOptionPane.showConfirmDialog(null, "Confirma que desea aprobar la Orden de Servicio" + correlativo);

        if (rpta == 0) {
            try {
                ConOrdenServicio controllerOrdServicio = new ConOrdenServicio();
                OrdenServicio servicio = controllerOrdServicio.getOneOrdServicio(Integer.parseInt(ano), Integer.parseInt(periodo), Integer.parseInt((correl)));
                if (controllerOrdServicio.aprOrdenServicio(servicio)) {
                    JOptionPane.showMessageDialog(null, "Se aprobo la Orden de Servicio");
                } else {
                    JOptionPane.showMessageDialog(null, "La orden de servicio ya fue aprobada anteriormente");
                }

            } catch (HeadlessException | NumberFormatException e) {
                System.out.println("Error al momento de aprobar la orden de servicio: " + e);
            }
        }

    }//GEN-LAST:event_BtnAprobarActionPerformed

    private void BtnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDetallesActionPerformed
        int rowS = TablaProd.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) TablaProd.getModel();

        String correlativo = modelo.getValueAt(rowS, 0).toString();
        String fecha = modelo.getValueAt(rowS, 1).toString();

        String[] split = correlativo.split("S");
        String id = split[1];
        String[] split1 = id.split("-");
        String correl = String.valueOf(Integer.parseInt(split1[0]));
        String ano = split1[1];
        String[] split2 = fecha.split("-");
        String valor2 = split2[1];
        String periodo = String.valueOf(Integer.parseInt(valor2));
        JfiVerOrdenServicio jfiVerOrdenServicio = new JfiVerOrdenServicio(ano, periodo, correl);
        JfMenu.MenuPanel.add(jfiVerOrdenServicio);
        jfiVerOrdenServicio.setVisible(true);
    }//GEN-LAST:event_BtnDetallesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAprobar;
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnDetalles;
    private javax.swing.JComboBox<String> ComboAno;
    private javax.swing.JComboBox<String> ComboEstado;
    private javax.swing.JComboBox<String> ComboPeriodo;
    private javax.swing.JTextField InputIGV;
    public static javax.swing.JTable TablaProd;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void relComboAno() {
        ComboAno.removeAllItems();
        ComboAno.addItem("Elija una opción");
        ConOrdenServicio controllerOrdenServicio = new ConOrdenServicio();
        ArrayList<Integer> listAno = controllerOrdenServicio.getAnosOrdServicio();

        for (int i = 0; i < listAno.size(); i++) {
            ComboAno.addItem(String.valueOf(listAno.get(i)));
        }
    }

    private void relComboPeriodo() {
        ComboPeriodo.removeAllItems();
        ComboPeriodo.addItem("Elija una opción");
        ConOrdenServicio controllerOrdenServicio = new ConOrdenServicio();
        ArrayList<Integer> listPeriodo = controllerOrdenServicio.getPersOrdServicio(ComboAno.getSelectedItem().toString());

        for (int i = 0; i < listPeriodo.size(); i++) {
            ComboPeriodo.addItem(String.valueOf(listPeriodo.get(i)));
        }
    }

    //rellena de ceros para 4 digitos de correlativo
    private String rellCorrel(int val) {
        String value = "";
        if (val < 10) {
            value = String.valueOf("000" + val);
        } else if (val < 100) {
            value = String.valueOf("00" + val);
        } else if (val < 1000) {
            value = String.valueOf("0" + val);
        } else if (val < 10000) {
            value = String.valueOf(val);
        }
        return value;
    }
}
