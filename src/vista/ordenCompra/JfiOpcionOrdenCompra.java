/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista.ordenCompra;

import controlador.ConMovimientoAlmacen;
import controlador.ConOrdenCompra;
import controlador.ConProveedor;
import java.awt.Dimension;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ItemOrdenCompraInter;
import modelo.ItemOrdenCompraNacional;
import modelo.MovimientoAlmacen;
import modelo.OrdenCompraInter;
import modelo.OrdenCompraNacional;
import modelo.Proveedor;
import vista.JfMenu;
import static vista.ordenCompra.JfiVerOrdenCompraNacional.TablaProd;

// v1.0 SCN 
public class JfiOpcionOrdenCompra extends javax.swing.JInternalFrame {

    public JfiOpcionOrdenCompra() {
        initComponents();
        this.setSize(new Dimension(700, 380));
        this.setTitle("Menú Orden compra");
        //combo tipo
        ComboTipo.removeAllItems();
        ComboTipo.addItem("Elija una opción");
        ComboTipo.addItem("nacional");
        ComboTipo.addItem("internacional");
        ComboAno.setEditable(false);
        ComboPeriodo.setEditable(false);
        //combo ano
        ComboAno.removeAllItems();
        ComboAno.addItem("Elija una opción");
        //combo periodo
        ComboPeriodo.removeAllItems();
        ComboPeriodo.addItem("Elija una opción");
        //combo estado
        ComboEstado.removeAllItems();
        ComboEstado.addItem("Pendiente");
        ComboEstado.addItem("Aprobado");
        //igv insertar
        InputIGV.setText("18");
    }

    //contador de combo tipo
    private int contadorComboTipo = 0;

    //contador de combo ano
    private int contadorComboAno = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnNacional = new javax.swing.JButton();
        BtnInternacional = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        InputIGV = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaProd = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        ComboTipo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        ComboAno = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        ComboPeriodo = new javax.swing.JComboBox<>();
        BtnAprobar = new javax.swing.JButton();
        BtnDetalle = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ComboEstado = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnNacional.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnNacional.setText("Nacional");
        BtnNacional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNacionalActionPerformed(evt);
            }
        });
        getContentPane().add(BtnNacional, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 110, 30));

        BtnInternacional.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnInternacional.setText("Internacional");
        BtnInternacional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInternacionalActionPerformed(evt);
            }
        });
        getContentPane().add(BtnInternacional, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 110, 30));

        jLabel1.setText("IGV:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 240, -1, -1));

        InputIGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputIGVActionPerformed(evt);
            }
        });
        getContentPane().add(InputIGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(595, 240, 70, -1));

        TablaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Correlativo", "Fecha", "Proveedor", "MontoTotal"
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
        jScrollPane2.setViewportView(TablaProd);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 500, 260));

        jLabel2.setText("Tipo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        ComboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboTipoActionPerformed(evt);
            }
        });
        getContentPane().add(ComboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 170, -1));

        jLabel3.setText("Año:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        ComboAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboAnoActionPerformed(evt);
            }
        });
        getContentPane().add(ComboAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 170, -1));

        jLabel4.setText("Periodo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        ComboPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboPeriodoActionPerformed(evt);
            }
        });
        getContentPane().add(ComboPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 170, -1));

        BtnAprobar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnAprobar.setText("Aprobar");
        BtnAprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAprobarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnAprobar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 90, -1));

        BtnDetalle.setText("Ver detalles");
        BtnDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDetalleActionPerformed(evt);
            }
        });
        getContentPane().add(BtnDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setToolTipText("");

        jLabel5.setText("Nuevo:");
        jPanel3.add(jLabel5);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 140, 180));

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 90, -1));

        jLabel6.setText("Estado:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, -1));

        ComboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(ComboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 170, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnNacionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNacionalActionPerformed
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
            JfiOrdenCompraNacional jfiOrdenCompraNacional = new JfiOrdenCompraNacional(IGV);
            JfMenu.MenuPanel.add(jfiOrdenCompraNacional);
            jfiOrdenCompraNacional.setVisible(true);
        }
    }//GEN-LAST:event_BtnNacionalActionPerformed

    private void InputIGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputIGVActionPerformed

    }//GEN-LAST:event_InputIGVActionPerformed

    private void BtnInternacionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInternacionalActionPerformed
        this.setVisible(false);
        JfiOrdenCompraInternacional jfiOrdenCompraInternacional = new JfiOrdenCompraInternacional();
        JfMenu.MenuPanel.add(jfiOrdenCompraInternacional);
        jfiOrdenCompraInternacional.setVisible(true);
    }//GEN-LAST:event_BtnInternacionalActionPerformed

    private void ComboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboTipoActionPerformed
        try {
            if (ComboTipo.getSelectedItem().toString().equals("Elija una opción")) {
                ComboAno.setEnabled(false);
                ComboPeriodo.setEnabled(false);
            } else {
                ComboAno.setEnabled(true);
            }

            if (contadorComboTipo > 0) {
                cargarComboAno(ComboTipo.getSelectedItem().toString());
            }
        } catch (Exception e) {

        }

        contadorComboTipo += 1;
    }//GEN-LAST:event_ComboTipoActionPerformed

    private void ComboAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboAnoActionPerformed
        int anoSel = 0;

        try {
            if (ComboAno.getSelectedItem().toString().equals("Elija una opción")) {
                ComboPeriodo.setEnabled(false);
            } else {
                anoSel = Integer.parseInt(ComboAno.getSelectedItem().toString());
                cargarComboPeriodo(anoSel);
                ComboPeriodo.setEnabled(true);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ComboAnoActionPerformed

    private void ComboPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboPeriodoActionPerformed

    }//GEN-LAST:event_ComboPeriodoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        boolean valida = false;
        ConOrdenCompra conCompra = new ConOrdenCompra();

        if (!ComboTipo.getSelectedItem().toString().equals("Elija una opción")
                && !ComboAno.getSelectedItem().toString().equals("Elija una opción")
                && !ComboPeriodo.getSelectedItem().toString().equals("Elija una opción")) {
            valida = true;
        }

        if (valida) {
            DefaultTableModel modelo = (DefaultTableModel) TablaProd.getModel();
            ConProveedor conProv = new ConProveedor();

            switch (ComboTipo.getSelectedItem().toString()) {
                case "internacional":
                    ArrayList<OrdenCompraInter> listInter = new ArrayList<>();
                    if (ComboEstado.getSelectedItem().equals("Pendiente")) {
                        listInter = conCompra.getCompraInter(Integer.parseInt(ComboAno.getSelectedItem().toString()), Integer.parseInt(ComboPeriodo.getSelectedItem().toString()), "P");
                    } else if (ComboEstado.getSelectedItem().equals("Aprobado")) {
                        listInter = conCompra.getCompraInter(Integer.parseInt(ComboAno.getSelectedItem().toString()), Integer.parseInt(ComboPeriodo.getSelectedItem().toString()), "A");
                    }
                    modelo.setRowCount(listInter.size());

                    for (int i = 0; i < listInter.size(); i++) {
                        String correlativo = "INT" + rellCorrel(listInter.get(i).getNum_ord_com_int()) + "-" + listInter.get(i).getAno_ord_com_int();
                        TablaProd.setValueAt(correlativo, i, 0);
                        TablaProd.setValueAt(listInter.get(i).getFec_ord_com(), i, 1);

                        Proveedor prov = conProv.conProveedor(String.valueOf(listInter.get(i).getId_proveedor()), "", "", "");

                        TablaProd.setValueAt(prov.getNom_proveedor(), i, 2);
                        TablaProd.setValueAt("$ " + listInter.get(i).getTotal_amo_dol(), i, 3);
                    }
                    break;
                case "nacional":
                    ArrayList<OrdenCompraNacional> listNac = conCompra.getCompraNac(Integer.parseInt(ComboAno.getSelectedItem().toString()), Integer.parseInt(ComboPeriodo.getSelectedItem().toString()));
                    modelo.setRowCount(listNac.size());

                    for (int i = 0; i < listNac.size(); i++) {
                        String correlativo = "NAC" + rellCorrel(listNac.get(i).getNum_ord_com_nac()) + "-" + listNac.get(i).getAno_ord_com_nac();
                        TablaProd.setValueAt(correlativo, i, 0);
                        TablaProd.setValueAt(listNac.get(i).getFec_ord_com(), i, 1);

                        Proveedor prov = conProv.conProveedor(String.valueOf(listNac.get(i).getId_proveedor()), "", "", "");

                        TablaProd.setValueAt(prov.getNom_proveedor(), i, 2);

                        if (listNac.get(i).getMoneda().equals("1")) {
                            TablaProd.setValueAt("S/. " + listNac.get(i).getTotal_sol(), i, 3);
                        } else if (listNac.get(i).getMoneda().equals("2")) {
                            TablaProd.setValueAt("$ " + listNac.get(i).getTotal_dol(), i, 3);
                        }
                    }
            }
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void BtnDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDetalleActionPerformed
        int rowS = TablaProd.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) TablaProd.getModel();

        String correlativo = modelo.getValueAt(rowS, 0).toString();
        String fecha = modelo.getValueAt(rowS, 1).toString();

        if (correlativo.indexOf("NAC") == 0) {
            String[] split = correlativo.split("C");
            String id = split[1];
            String[] split1 = id.split("-");
            String correl = String.valueOf(Integer.parseInt(split1[0]));
            String ano = split1[1];
            String[] split2 = fecha.split("-");
            String valor2 = split2[1];
            String periodo = String.valueOf(Integer.parseInt(valor2));
            JfiVerOrdenCompraNacional jfiVerOrdenCompraNacional = new JfiVerOrdenCompraNacional(ano, periodo, correl);
            JfMenu.MenuPanel.add(jfiVerOrdenCompraNacional);
            jfiVerOrdenCompraNacional.setVisible(true);
        }

        if (correlativo.indexOf("INT") == 0) {
            String[] split = correlativo.split("T");
            String id = split[1];
            String[] split1 = id.split("-");
            String correl = String.valueOf(Integer.parseInt(split1[0]));
            String ano = split1[1];
            String[] split2 = fecha.split("-");
            String valor2 = split2[1];
            String periodo = String.valueOf(Integer.parseInt(valor2));
            JfiVerOrdenCompraInternacional jfiVerOrdenCompraInternacional = new JfiVerOrdenCompraInternacional(ano, periodo, correl);
            JfMenu.MenuPanel.add(jfiVerOrdenCompraInternacional);
            jfiVerOrdenCompraInternacional.setVisible(true);
        }
    }//GEN-LAST:event_BtnDetalleActionPerformed

    private void BtnAprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAprobarActionPerformed
        int rowS = TablaProd.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) TablaProd.getModel();

        String correlativo = modelo.getValueAt(rowS, 0).toString();
        String fecha = modelo.getValueAt(rowS, 1).toString();

        if (correlativo.indexOf("NAC") == 0) {
            String[] split = correlativo.split("C");
            String id = split[1];
            String[] split1 = id.split("-");
            String correl = String.valueOf(Integer.parseInt(split1[0]));
            String ano = split1[1];
            String[] split2 = fecha.split("-");
            String valor2 = split2[1];
            String periodo = String.valueOf(Integer.parseInt(valor2));

            JfiAprOrdenCompraAlmDestino jfiAprOrdenCompraAlmDestino = new JfiAprOrdenCompraAlmDestino(ano, periodo, correl, "N");
            JfMenu.MenuPanel.add(jfiAprOrdenCompraAlmDestino);
            jfiAprOrdenCompraAlmDestino.setVisible(true);
        }

        if (correlativo.indexOf("INT") == 0) {
            String[] split = correlativo.split("T");
            String id = split[1];
            String[] split1 = id.split("-");
            String correl = String.valueOf(Integer.parseInt(split1[0]));
            String ano = split1[1];
            String[] split2 = fecha.split("-");
            String valor2 = split2[1];
            String periodo = String.valueOf(Integer.parseInt(valor2));

            JfiAprOrdenCompraAlmDestino jfiAprOrdenCompraAlmDestino = new JfiAprOrdenCompraAlmDestino(ano, periodo, correl, "I");
            JfMenu.MenuPanel.add(jfiAprOrdenCompraAlmDestino);
            jfiAprOrdenCompraAlmDestino.setVisible(true);
        }
    }//GEN-LAST:event_BtnAprobarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAprobar;
    private javax.swing.JButton BtnDetalle;
    private javax.swing.JButton BtnInternacional;
    private javax.swing.JButton BtnNacional;
    private javax.swing.JComboBox<String> ComboAno;
    private javax.swing.JComboBox<String> ComboEstado;
    private javax.swing.JComboBox<String> ComboPeriodo;
    private javax.swing.JComboBox<String> ComboTipo;
    private javax.swing.JTextField InputIGV;
    public static javax.swing.JTable TablaProd;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void cargarComboAno(String tipo) {
        ConOrdenCompra metCompra = new ConOrdenCompra();
        ComboAno.removeAllItems();
        ComboAno.addItem("Elija una opción");
        switch (tipo) {
            case "nacional":
                ArrayList<Integer> listAnoNac = metCompra.getAnoComNac();

                for (int i = 0; i < listAnoNac.size(); i++) {
                    ComboAno.addItem(String.valueOf(listAnoNac.get(i)));
                }

                ComboPeriodo.setEnabled(true);
                break;
            case "internacional":
                ArrayList<Integer> listAnoInt = metCompra.getAnoComInt();

                for (int i = 0; i < listAnoInt.size(); i++) {
                    ComboAno.addItem(String.valueOf(listAnoInt.get(i)));
                }
                ComboPeriodo.setEnabled(true);
                break;
            default:
                break;
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

    private void cargarComboPeriodo(int anoSeleccion) {
        ComboPeriodo.removeAllItems();
        ComboPeriodo.addItem("Elija una opción");

        ConOrdenCompra metCompra = new ConOrdenCompra();
        switch (ComboTipo.getSelectedItem().toString()) {
            case "nacional":
                ArrayList<Integer> listAnoNac = metCompra.getPerComNac(String.valueOf(anoSeleccion));

                for (int i = 0; i < listAnoNac.size(); i++) {
                    ComboPeriodo.addItem(String.valueOf(listAnoNac.get(i)));
                }

                break;
            case "internacional":
                ArrayList<Integer> listAnoInt = metCompra.getPerComInt(String.valueOf(anoSeleccion));

                for (int i = 0; i < listAnoInt.size(); i++) {
                    ComboPeriodo.addItem(String.valueOf(listAnoInt.get(i)));
                }
                break;
        }
    }

}
