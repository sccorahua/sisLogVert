package vista.ordenCompra;

import controlador.ConOrdenCompra;
import controlador.ConProveedor;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.ItemOrdenCompraNacional;
import modelo.OrdenCompraNacional;
import modelo.Proveedor;

// v1.0 SCN 
public class JfiVerOrdenCompraNacional extends javax.swing.JInternalFrame {

    public JfiVerOrdenCompraNacional(String ano, String periodo, String correlativo) {
        initComponents();
        this.setSize(new Dimension(700, 420));
        this.setTitle("Detalles Orden de Commpra Nacional " + correlativo + "-" + ano);
        //orden de compra
        ConOrdenCompra conCompra = new ConOrdenCompra();
        OrdenCompraNacional compraNac = conCompra.getOneCompraNac(Integer.parseInt(ano), Integer.parseInt(periodo), Integer.parseInt(correlativo));
        //input prov
        InputSr.setEditable(false);
        ConProveedor conProv = new ConProveedor();
        Proveedor prov = conProv.conProveedor(String.valueOf(compraNac.getId_proveedor()), "", "", "");

        //inputTipDoc
        InputTipDoc.setEditable(false);
        InputSr.setText(prov.getNom_proveedor());
        if (prov.getTip_doc().equals("1")) {
            InputTipDoc.setText("RUC");
        }
        if (prov.getTip_doc().equals("2")) {
            InputTipDoc.setText("Otro documento");
        }

        //
        InputNroDoc.setEditable(false);
        InputNroDoc.setText(prov.getNum_doc());

        InputDir.setEditable(false);
        InputDir.setText(prov.getDir_proveedor());

        InputCotizacion.setEditable(false);
        InputCotizacion.setText(compraNac.getCotizacion());

        InputFecha.setEditable(false);
        InputFecha.setText(String.valueOf(compraNac.getFec_ord_com()));

        InputContacto.setEditable(false);
        InputContacto.setText(compraNac.getCon_ord_com());

        InputTelefono.setEditable(false);
        InputTelefono.setText(compraNac.getTel_ord_com());

        InputEmail.setEditable(false);
        InputEmail.setText(compraNac.getEmail());

        InputCtaCteBanco.setEditable(false);
        InputCtaCteBanco.setText(compraNac.getCta_cte_ban_ord_com());

        //rellenar tabla
        DefaultTableModel modelo = (DefaultTableModel) TablaProd.getModel();
        ArrayList<ItemOrdenCompraNacional> ListArticulo = conCompra.getListItemOfCompraNac(Integer.parseInt(ano), Integer.parseInt(periodo), Integer.parseInt(correlativo));
        modelo.setRowCount(ListArticulo.size());

        for (int i = 0; i < ListArticulo.size(); i++) {
            TablaProd.setValueAt(i + 1, i, 0);
            TablaProd.setValueAt(ListArticulo.get(i).getId_item(), i, 1);
            TablaProd.setValueAt(ListArticulo.get(i).getTip_unidad(), i, 2);
            TablaProd.setValueAt(ListArticulo.get(i).getCantidad(), i, 3);
            TablaProd.setValueAt(ListArticulo.get(i).getDescuento(), i, 5);
            TablaProd.setValueAt(ListArticulo.get(i).getPrecioU(), i, 4);
            TablaProd.setValueAt(ListArticulo.get(i).getPrecioF(), i, 6);
        }

        //moneda
        InputMoneda.setEditable(false);
        if (compraNac.getMoneda().equals("1")) {
            InputMoneda.setText("Soles");
        }
        if (compraNac.getMoneda().equals("2")) {
            InputMoneda.setText("Dolares");
        }

        //lugar entrega
        InputLugEntrega.setEditable(false);
        InputLugEntrega.setText(compraNac.getLug_ent_ord_com());

        //
        InputPerSolicitud.setEditable(false);
        InputPerSolicitud.setText(compraNac.getSol_ord_com());

        InputObs.setEditable(false);
        InputObs.setText(compraNac.getObservacion());

        InputCenCosto.setEditable(false);
        InputCenCosto.setText(compraNac.getCen_cos_ord_com());

        InputFecEntrega.setEditable(false);
        InputFecEntrega.setText(String.valueOf(compraNac.getFec_ent_ord_com()));

        InputForPago.setEditable(false);
        if (compraNac.getFor_pago_ord_com().equals("E")) {
            InputForPago.setText("Contado");
            InputDias.setVisible(false);
            LabelDias.setVisible(false);
        }
        if (compraNac.getFor_pago_ord_com().equals("C")) {
            InputForPago.setText("Credito");
            InputDias.setVisible(true);
            LabelDias.setVisible(true);
            InputDias.setText(String.valueOf(compraNac.getPag_cre_dias()));
        }
        
            LabelImpBruto.setText("S/."+String.valueOf(compraNac.getImp_bruto_sol()));
            LabelDescuento.setText("S/."+String.valueOf(compraNac.getDescuento_sol()));
            LabelSubTot.setText("S/."+String.valueOf(compraNac.getSub_total_sol()));
            LabelTextIGV.setText("IGV(" + String.valueOf(compraNac.getIgv()) + "%)");
            LabelIGV.setText("S/."+String.valueOf(compraNac.getTotal_sol().subtract(compraNac.getSub_total_sol())));
            LabelTotal.setText("S/."+String.valueOf(compraNac.getTotal_sol()));  

            LabelImpBruto1.setText("$"+String.valueOf(compraNac.getImp_bruto_dol()));
            LabelDescuento1.setText("$"+String.valueOf(compraNac.getDescuento_dol()));
            LabelSubTot1.setText("$"+String.valueOf(compraNac.getSub_total_dol()));
            LabelTextIGV1.setText("IGV(" + String.valueOf(compraNac.getIgv()) + ")");
            LabelIGV1.setText("$"+String.valueOf(compraNac.getTotal_dol().subtract(compraNac.getSub_total_dol())));
            LabelTotal1.setText("$"+String.valueOf(compraNac.getTotal_dol()));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        InputTipDoc = new javax.swing.JTextField();
        InputNroDoc = new javax.swing.JTextField();
        InputDir = new javax.swing.JTextField();
        InputCotizacion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        InputContacto = new javax.swing.JTextField();
        InputTelefono = new javax.swing.JTextField();
        InputEmail = new javax.swing.JTextField();
        InputCtaCteBanco = new javax.swing.JTextField();
        InputFecha = new javax.swing.JTextField();
        InputSr = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProd = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        InputLugEntrega = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        InputPerSolicitud = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        LabelDias = new javax.swing.JLabel();
        InputMoneda = new javax.swing.JTextField();
        InputCenCosto = new javax.swing.JTextField();
        InputForPago = new javax.swing.JTextField();
        InputFecEntrega = new javax.swing.JTextField();
        InputDias = new javax.swing.JTextField();
        InputObs = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        LabelTotal = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        LabelDescuento = new javax.swing.JLabel();
        LabelIGV = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        LabelImpBruto = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        LabelSubTot = new javax.swing.JLabel();
        LabelTextIGV = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        LabelImpBruto1 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        LabelDescuento1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        LabelSubTot1 = new javax.swing.JLabel();
        LabelTextIGV1 = new javax.swing.JLabel();
        LabelIGV1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LabelTotal1 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("Señor:");

        jLabel4.setText("Tipo Documento:");

        jLabel5.setText("Nro Documento:");

        jLabel6.setText("Dirección:");

        jLabel7.setText("Cotización:");

        InputTipDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputTipDocActionPerformed(evt);
            }
        });

        jLabel10.setText("Fecha:");

        jLabel11.setText("Contacto:");

        jLabel12.setText("Telefono:");

        jLabel13.setText("Email:");

        jLabel14.setText("Cta Cte Banco:");

        InputContacto.setToolTipText("");

        InputCtaCteBanco.setToolTipText("");

        TablaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Descripcion", "Unidad", "Cantidad", "Precio", "Dscto", "Importe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaProd);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(21, 21, 21)
                        .addComponent(InputNroDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel12)
                        .addGap(51, 51, 51)
                        .addComponent(InputTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(57, 57, 57)
                        .addComponent(InputDir, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel13)
                        .addGap(68, 68, 68)
                        .addComponent(InputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(51, 51, 51)
                        .addComponent(InputCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel14)
                        .addGap(22, 22, 22)
                        .addComponent(InputCtaCteBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(InputSr, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(InputTipDoc))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel11))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(InputContacto)
                            .addComponent(InputFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(InputSr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(InputFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(InputTipDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(InputContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(InputNroDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(InputTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(InputDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(InputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(InputCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(InputCtaCteBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("General", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setText("Observaciones:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel20.setText("Centro Costo:");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        jLabel21.setText("Moneda:");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel22.setText("Fecha entrega:");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

        jLabel23.setText("Lugar entrega:");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));
        jPanel3.add(InputLugEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 200, -1));

        jLabel24.setText("A solicitud de:");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        jPanel3.add(InputPerSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 200, -1));

        jLabel25.setText("Forma pago:");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, -1));

        LabelDias.setText("Días:");
        jPanel3.add(LabelDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));
        jPanel3.add(InputMoneda, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 200, -1));

        InputCenCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputCenCostoActionPerformed(evt);
            }
        });
        jPanel3.add(InputCenCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 200, -1));
        jPanel3.add(InputForPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 200, -1));
        jPanel3.add(InputFecEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 200, -1));
        jPanel3.add(InputDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 200, -1));
        jPanel3.add(InputObs, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 200, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Total");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        LabelTotal.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LabelTotal.setText("0.00");
        jPanel3.add(LabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("SubTotal");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        LabelDescuento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelDescuento.setText("0.00");
        jPanel3.add(LabelDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        LabelIGV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelIGV.setText("0.00");
        jPanel3.add(LabelIGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Importe Bruto");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        LabelImpBruto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelImpBruto.setText("0.00");
        jPanel3.add(LabelImpBruto, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Descuento");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        LabelSubTot.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelSubTot.setText("0.00");
        jPanel3.add(LabelSubTot, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, -1, -1));

        LabelTextIGV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelTextIGV.setText("IGV");
        jPanel3.add(LabelTextIGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Importe Bruto");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, -1, -1));

        LabelImpBruto1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelImpBruto1.setText("0.00");
        jPanel3.add(LabelImpBruto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, -1, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Descuento");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, -1, -1));

        LabelDescuento1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelDescuento1.setText("0.00");
        jPanel3.add(LabelDescuento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("SubTotal");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, -1, -1));

        LabelSubTot1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelSubTot1.setText("0.00");
        jPanel3.add(LabelSubTot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, -1, -1));

        LabelTextIGV1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelTextIGV1.setText("IGV");
        jPanel3.add(LabelTextIGV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, -1, -1));

        LabelIGV1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelIGV1.setText("0.00");
        jPanel3.add(LabelIGV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Total");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, -1, -1));

        LabelTotal1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LabelTotal1.setText("0.00");
        jPanel3.add(LabelTotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, -1, -1));

        jTabbedPane1.addTab("Detalles", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 670, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InputTipDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputTipDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputTipDocActionPerformed

    private void InputCenCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputCenCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputCenCostoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField InputCenCosto;
    private javax.swing.JTextField InputContacto;
    private javax.swing.JTextField InputCotizacion;
    private javax.swing.JTextField InputCtaCteBanco;
    private javax.swing.JTextField InputDias;
    private javax.swing.JTextField InputDir;
    private javax.swing.JTextField InputEmail;
    private javax.swing.JTextField InputFecEntrega;
    private javax.swing.JTextField InputFecha;
    private javax.swing.JTextField InputForPago;
    private javax.swing.JTextField InputLugEntrega;
    private javax.swing.JTextField InputMoneda;
    private javax.swing.JTextField InputNroDoc;
    private javax.swing.JTextField InputObs;
    private javax.swing.JTextField InputPerSolicitud;
    private javax.swing.JTextField InputSr;
    private javax.swing.JTextField InputTelefono;
    private javax.swing.JTextField InputTipDoc;
    private javax.swing.JLabel LabelDescuento;
    private javax.swing.JLabel LabelDescuento1;
    private javax.swing.JLabel LabelDias;
    private javax.swing.JLabel LabelIGV;
    private javax.swing.JLabel LabelIGV1;
    private javax.swing.JLabel LabelImpBruto;
    private javax.swing.JLabel LabelImpBruto1;
    private javax.swing.JLabel LabelSubTot;
    private javax.swing.JLabel LabelSubTot1;
    private javax.swing.JLabel LabelTextIGV;
    private javax.swing.JLabel LabelTextIGV1;
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JLabel LabelTotal1;
    public static javax.swing.JTable TablaProd;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
