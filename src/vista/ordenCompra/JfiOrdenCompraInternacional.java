package vista.ordenCompra;

import controlador.ConCentroCosto;
import controlador.ConOrdenCompra;
import controlador.ConProveedor;
import controlador.ConTipoCambio;
import java.awt.Dimension;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.CentroCosto;
import modelo.ItemOrdenCompraInter;
import modelo.OrdenCompraInter;
import modelo.Proveedor;
import vista.JfMenu;
import static vista.ordenCompra.JfiOrdenCompraNacional.ListArticulo;
import static vista.ordenServicio.JfiOrdenServicio.ListArticulo;

// v1.0 SCN
public class JfiOrdenCompraInternacional extends javax.swing.JInternalFrame {

    public JfiOrdenCompraInternacional() {
        initComponents();
        this.setSize(new Dimension(950, 520));
        this.setTitle("Orden de compra internacional");
        //iniciliza ventana addProducto
        jfiAddProducto = new JfiAddProducto(null, ListArticulo, null, "i");
        //n1 correlativo
        getNumCorrel1();
        //n2 correlativo
        ConOrdenCompra metOrdCompra = new ConOrdenCompra();
        int ano = metOrdCompra.getAnoActual("d");
        InputCorrel2.setText(String.valueOf(ano));
        InputCorrel2.setEditable(false);
        InputCorrel2.setEnabled(false);
        //Limpia la lista de articulos
        ListArticulo.clear();
        //company
        ComboCompany.removeAllItems();
        ComboCompany.addItem("Elija una opción");
        cargarComboProveedor();
        //incoterms
                ComboIncoterms.removeAllItems();
        ComboIncoterms.addItem("Elija una opción");
        ComboIncoterms.addItem("EXW");
        ComboIncoterms.addItem("FAS");
        ComboIncoterms.addItem("FCA");
        ComboIncoterms.addItem("FOB");
        ComboIncoterms.addItem("CFR");
        ComboIncoterms.addItem("CIF");
        ComboIncoterms.addItem("CIP");
        ComboIncoterms.addItem("CPT");
        ComboIncoterms.addItem("DAP");
        ComboIncoterms.addItem("DDP");
        ComboIncoterms.addItem("DPU");
        //address commpany
        InputAddress.setEnabled(false);
        InputAddress.setEditable(false);
        //centro de costo
        ComboCenCosto.removeAllItems();
        ComboCenCosto.addItem("Elija una opción");
        cargarComboCentroCosto();
    }

    //jframe addProducto
    public JfiAddProducto jfiAddProducto;
    public ArrayList<ItemOrdenCompraInter> ListArticulo = new ArrayList<>();
    private boolean AddPrd = false; //validador

    //proveedor
    private int contadorProv = 0; //contador

    //variables principales
    private BigDecimal SubTotal = new BigDecimal(0);
    private BigDecimal Discount = new BigDecimal(0);
    private BigDecimal Neto = new BigDecimal(0);
    private BigDecimal CIF = new BigDecimal(0);
    private BigDecimal totAmount = new BigDecimal(0);

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        InputCorrel1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        InputCorrel2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        InputAddress = new javax.swing.JTextField();
        InputPhone = new javax.swing.JTextField();
        InputEmail = new javax.swing.JTextField();
        InputQuoteNumber = new javax.swing.JTextField();
        InputPaymentTerms = new javax.swing.JTextField();
        InputShipDate = new javax.swing.JTextField();
        InputFreightForw = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProd = new javax.swing.JTable();
        BtnAddProducto = new javax.swing.JButton();
        BtnActDato = new javax.swing.JButton();
        BtnEliProduct = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        InputCurrency = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        InputUserSol = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        InputBankDet = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        InputAccountNumber = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        InputSwiftCode = new javax.swing.JTextField();
        ComboCenCosto = new javax.swing.JComboBox<>();
        ComboCompany = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        labelSubTotal = new javax.swing.JLabel();
        labelNeto = new javax.swing.JLabel();
        labelTotAmount = new javax.swing.JLabel();
        labelDiscount = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        FecDate = new com.toedter.calendar.JDateChooser();
        InputCIF = new javax.swing.JTextField();
        ComboIncoterms = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("PURCHASE ORDER N°");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        InputCorrel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        InputCorrel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputCorrel1ActionPerformed(evt);
            }
        });
        getContentPane().add(InputCorrel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 60, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("-");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 20, -1));

        InputCorrel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(InputCorrel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, 40));

        jLabel3.setText("Company:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel4.setText("Address:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel5.setText("Phone:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel6.setText("Email:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel7.setText("Quote number:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel8.setText("Date:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));

        jLabel9.setText("Payment terms:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, -1));

        jLabel10.setText("Incoterms:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, -1));

        jLabel11.setText("Request Ship Date:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, -1));

        jLabel12.setText("Freight Forwarder:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, -1, -1));
        getContentPane().add(InputAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 190, -1));

        InputPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputPhoneActionPerformed(evt);
            }
        });
        getContentPane().add(InputPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 190, -1));
        getContentPane().add(InputEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 190, -1));
        getContentPane().add(InputQuoteNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 190, -1));

        InputPaymentTerms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputPaymentTermsActionPerformed(evt);
            }
        });
        getContentPane().add(InputPaymentTerms, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 190, -1));
        getContentPane().add(InputShipDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 190, -1));

        InputFreightForw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputFreightForwActionPerformed(evt);
            }
        });
        getContentPane().add(InputFreightForw, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 190, -1));

        TablaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Description", "Quantify", "Und", "Unit Price", "Discount", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
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
        if (TablaProd.getColumnModel().getColumnCount() > 0) {
            TablaProd.getColumnModel().getColumn(0).setPreferredWidth(25);
            TablaProd.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 650, 100));

        BtnAddProducto.setText("Agregar Producto");
        BtnAddProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddProductoActionPerformed(evt);
            }
        });
        getContentPane().add(BtnAddProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 160, -1));

        BtnActDato.setText("Actualizar Datos");
        BtnActDato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActDatoActionPerformed(evt);
            }
        });
        getContentPane().add(BtnActDato, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 150, -1));

        BtnEliProduct.setText("Eliminar Producto");
        BtnEliProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliProductActionPerformed(evt);
            }
        });
        getContentPane().add(BtnEliProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 150, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 666, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 670, 120));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setText("Cost Center:");

        jLabel14.setText("Currency:");

        jLabel15.setText("Username:");

        jLabel16.setText("Bank details:");

        jLabel17.setText("Account Number:");

        jLabel18.setText("Swift Code:");

        ComboCenCosto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(InputCurrency, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(InputUserSol, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(jLabel16)
                    .addComponent(InputBankDet, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(jLabel17)
                    .addComponent(InputAccountNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(jLabel18)
                    .addComponent(InputSwiftCode, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(ComboCenCosto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboCenCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputUserSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputBankDet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputAccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputSwiftCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 240, 370));

        ComboCompany.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboCompanyActionPerformed(evt);
            }
        });
        getContentPane().add(ComboCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 190, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Sub Total");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Discount");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Neto");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, -1, 20));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Freight Cost");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel23.setText("Total Amount");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, -1, -1));

        labelSubTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSubTotal.setText("0.00");
        getContentPane().add(labelSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, -1, -1));

        labelNeto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNeto.setText("0.00");
        getContentPane().add(labelNeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, -1, -1));

        labelTotAmount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTotAmount.setText("0.00");
        getContentPane().add(labelTotAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, -1, -1));

        labelDiscount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDiscount.setText("0.00");
        getContentPane().add(labelDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, -1, -1));

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 420, 210, 50));

        FecDate.setDateFormatString("yyyy/MM/dd");
        getContentPane().add(FecDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 190, -1));

        InputCIF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        InputCIF.setText("0.00");
        InputCIF.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                InputCIFInputMethodTextChanged(evt);
            }
        });
        getContentPane().add(InputCIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 450, -1, -1));

        ComboIncoterms.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(ComboIncoterms, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 190, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InputPaymentTermsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputPaymentTermsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputPaymentTermsActionPerformed

    private void ComboCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCompanyActionPerformed
        ConProveedor metodProv = new ConProveedor();
        contadorProv += 1;
        try {
            if (ComboCompany.getSelectedItem().equals("Elija una opción") && contadorProv > 2) {
                JOptionPane.showMessageDialog(null, "Debe indicar un proveedor");
            }
            Proveedor prov = metodProv.conProveedor("", ComboCompany.getSelectedItem().toString(), "%", "%");
            InputAddress.setText(prov.getDir_proveedor());
        } catch (Exception e) {
            //Entra al abrir la pantalla por prmiera vez
            if (contadorProv > 2) {
                JOptionPane.showMessageDialog(null, "Error al cargar informacion de proveedor" + e);

            }
        }
    }//GEN-LAST:event_ComboCompanyActionPerformed

    private void InputFreightForwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputFreightForwActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputFreightForwActionPerformed

    private void InputCorrel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputCorrel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputCorrel1ActionPerformed

    private void BtnAddProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddProductoActionPerformed
        if (!AddPrd) {
            JfMenu.MenuPanel.add(jfiAddProducto);
        }
        AddPrd = true;
        jfiAddProducto.setVisible(true);
    }//GEN-LAST:event_BtnAddProductoActionPerformed

    private void BtnActDatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActDatoActionPerformed
        RellTabla();
    }//GEN-LAST:event_BtnActDatoActionPerformed

    private void BtnEliProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliProductActionPerformed
        int rowS = TablaProd.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) TablaProd.getModel();
        modelo.removeRow(rowS);
        ListArticulo.remove(rowS);
        RellTabla();
    }//GEN-LAST:event_BtnEliProductActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean error = false;
        Date fecha = null;
        ConTipoCambio metodTipCam = new ConTipoCambio();

        if (ListArticulo.size() == 0) {
            JOptionPane.showMessageDialog(null, "Debe agregar como minimo un producto");
            error = true;
        }

        if (ComboCompany.getSelectedItem().equals("Elija una opción")) {
            error = true;
            JOptionPane.showMessageDialog(null, "Debe indicar un proveedor para grabar");
        }

        try {
            fecha = new Date(FecDate.getDate().getTime());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una fecha de entrega valida");
            error = true;
        }

        if (ComboCenCosto.getSelectedItem().equals("Elija una opción")) {
            error = true;
            JOptionPane.showMessageDialog(null, "Debe indicar un centro de costo para grabar");
        }

        if (ListArticulo.size() != TablaProd.getRowCount()) {
            error = true;
            JOptionPane.showMessageDialog(null, "La cantidad de articulos ingresados es mayor a la cantidad mostrada en el formato, favor de actualizar para corregir el error");
        }

        if (metodTipCam.conFecha(fecha).getFec_tip_cambio() == null) {
            error = true;
            JOptionPane.showMessageDialog(null, "Favor de ingresar primero el tipo de cambio para la fecha de la orden para continuar con el registro");
        }

        try {
            Double valorCIF = Double.parseDouble(InputCIF.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "debe indicar un valor numero para el Costo CIF");
            error = true;
        }

        if (ListArticulo.size() < 1) {
            error = true;
            JOptionPane.showMessageDialog(null, "Debe agregar como minimo un articulo");
        }
        
        if(ComboIncoterms.getSelectedItem().equals("Elija una opción")){
            error = true;
            JOptionPane.showMessageDialog(null, "Debe indicar las condiciones de transporte");
        }

        if (!error) {
            OrdenCompraInter compraInter = new OrdenCompraInter();
            ConOrdenCompra metCompra = new ConOrdenCompra();
            ItemOrdenCompraInter articulo = new ItemOrdenCompraInter();
            ConProveedor metProv = new ConProveedor();
            int idProv = metProv.conProveedor("", ComboCompany.getSelectedItem().toString(), "%", "%").getId_proveedor();
            String[] split = ComboCenCosto.getSelectedItem().toString().split("-");
            String IdCenCosto = split[0];

            compraInter.setAno_ord_com_int(metCompra.getAnoActual("c"));
            compraInter.setNum_ord_com_int(metCompra.getUltOrdenCompraInternacional() + 1);

            String fec = String.valueOf(fecha);
            String[] split1 = fec.split("-");
            int periodo = Integer.parseInt(split1[1]);

            compraInter.setPeriodo_est_com_int(periodo);
            compraInter.setId_proveedor(idProv);
            compraInter.setEmail(InputEmail.getText());
            compraInter.setQuote_number(InputQuoteNumber.getText());
            compraInter.setFec_ord_com(fecha);
            compraInter.setPay_ter(InputPaymentTerms.getText());
            compraInter.setIncoterms(ComboIncoterms.getSelectedItem().toString());
            compraInter.setReq_ship_date(InputShipDate.getText());
            compraInter.setFre_forw(InputFreightForw.getText());
            compraInter.setCen_cost_ord_com(IdCenCosto);
            compraInter.setUser_sol(InputUserSol.getText());
            compraInter.setBan_det(InputBankDet.getText());
            compraInter.setNro_cta(InputAccountNumber.getText());
            compraInter.setSwi_cod(InputSwiftCode.getText());

            compraInter.setSub_total_dol(new BigDecimal(labelSubTotal.getText()));
            compraInter.setDescuento_dol(new BigDecimal(labelDiscount.getText()));
            compraInter.setNeto_dol(new BigDecimal(labelNeto.getText()));
            compraInter.setTransporte_dol(new BigDecimal(InputCIF.getText()));
            compraInter.setTotal_amo_dol(new BigDecimal(labelTotAmount.getText()));

            int contador = 0;

            try {
                if (metCompra.insOrdCompraInt(compraInter)) {
                    for (int i = 0; i < ListArticulo.size(); i++) {
                        ListArticulo.get(i).setRef_ano_ord_com(metCompra.getAnoActual("c"));
                        ListArticulo.get(i).setRef_num_ord_com(compraInter.getNum_ord_com_int());
                        ListArticulo.get(i).setPeriodo_ord_com(periodo);
                        ListArticulo.get(i).setItem_ord_com(i + 1);
                        try {
                            metCompra.insItemOrdCompraInt(ListArticulo.get(i));
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Error al momento de registrar el item " + ListArticulo.get(i).getId_item() + ", favor de revisar los datos ingresados");
                        }
                        contador += 1;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error al momento de guardar la cabecera, revisar los datos ingrsados");
                }
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }

            //reinicio de variables
            if ((contador) == ListArticulo.size()) {
                JOptionPane.showMessageDialog(null, "Se agrego la Orden de Compra Internacional " + compraInter.getNum_ord_com_int() + "-" + metCompra.getAnoActual("d") + " satisfactoriamente.");
                ComboCompany.setSelectedItem("Elija una opción");
                InputAddress.setText("");
                contadorProv = 0;
                InputPhone.setText("");
                InputEmail.setText("");
                InputQuoteNumber.setText("");
                FecDate.setDate(null);
                InputPaymentTerms.setText("");
                ComboIncoterms.setSelectedItem("Elija una opción");
                InputShipDate.setText("");
                InputFreightForw.setText("");

                //limpiando tabla
                DefaultTableModel modelo = (DefaultTableModel) TablaProd.getModel();
                int row = TablaProd.getRowCount() - 1;
                for (int i = row; i >= 0; i--) {
                    modelo.removeRow(TablaProd.getRowCount() - 1);
                }

                labelSubTotal.setText("0.00");
                labelDiscount.setText("0.00");
                labelNeto.setText("0.00");
                labelTotAmount.setText("0.00");
                InputCIF.setText("0.00");
                ComboCenCosto.setSelectedItem("Elija una opcion");
                InputCurrency.setText("");
                InputUserSol.setText("");
                InputBankDet.setText("");
                InputAccountNumber.setText("");
                InputSwiftCode.setText("");
                ListArticulo.clear();
                getNumCorrel1();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void InputCIFInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_InputCIFInputMethodTextChanged
        Double NetoAct = Double.parseDouble(labelNeto.getText());
        try {
            Double CIFAct = Double.valueOf(InputCIF.getText());
            labelTotAmount.setText(String.valueOf(CIFAct + NetoAct));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico para CIF: " + e);
        }

    }//GEN-LAST:event_InputCIFInputMethodTextChanged

    private void InputPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputPhoneActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActDato;
    private javax.swing.JButton BtnAddProducto;
    private javax.swing.JButton BtnEliProduct;
    private javax.swing.JComboBox<String> ComboCenCosto;
    private javax.swing.JComboBox<String> ComboCompany;
    private javax.swing.JComboBox<String> ComboIncoterms;
    private com.toedter.calendar.JDateChooser FecDate;
    private javax.swing.JTextField InputAccountNumber;
    private javax.swing.JTextField InputAddress;
    private javax.swing.JTextField InputBankDet;
    private javax.swing.JTextField InputCIF;
    private javax.swing.JTextField InputCorrel1;
    private javax.swing.JTextField InputCorrel2;
    private javax.swing.JTextField InputCurrency;
    private javax.swing.JTextField InputEmail;
    private javax.swing.JTextField InputFreightForw;
    private javax.swing.JTextField InputPaymentTerms;
    private javax.swing.JTextField InputPhone;
    private javax.swing.JTextField InputQuoteNumber;
    private javax.swing.JTextField InputShipDate;
    private javax.swing.JTextField InputSwiftCode;
    private javax.swing.JTextField InputUserSol;
    private javax.swing.JTable TablaProd;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDiscount;
    private javax.swing.JLabel labelNeto;
    private javax.swing.JLabel labelSubTotal;
    private javax.swing.JLabel labelTotAmount;
    // End of variables declaration//GEN-END:variables

    private void cargarComboProveedor() {
        ConProveedor metodProv = new ConProveedor();
        ArrayList<Proveedor> listProveedor = metodProv.getListProveedor();

        for (int i = 0; i < listProveedor.size(); i++) {
            ComboCompany.addItem(listProveedor.get(i).getNom_proveedor());
        }
    }

    private void cargarComboCentroCosto() {
        ConCentroCosto metodCenCosto = new ConCentroCosto();
        ArrayList<CentroCosto> listCentroCosto = metodCenCosto.getListCentroCosto();

        for (int i = 0; i < listCentroCosto.size(); i++) {
            ComboCenCosto.addItem(listCentroCosto.get(i).getId_cen_costo() + "-" + listCentroCosto.get(i).getNom_cen_costo());
        }
    }

    //obtener el correlativo que prosigue
    private void getNumCorrel1() {
        InputCorrel1.setEditable(false);
        InputCorrel1.setEnabled(false);
        ConOrdenCompra metodOCN = new ConOrdenCompra();
        int UltOCN = metodOCN.getUltOrdenCompraInternacional() + 1;
        if (UltOCN < 10) {
            InputCorrel1.setText("000" + String.valueOf(UltOCN));
        } else if (UltOCN < 100) {
            InputCorrel1.setText("00" + String.valueOf(UltOCN));
        } else if (UltOCN < 1000) {
            InputCorrel1.setText("0" + String.valueOf(UltOCN));
        } else if (UltOCN < 10000) {
            InputCorrel1.setText(String.valueOf(UltOCN));
        }
    }

    //funcion que rellena la tabla de articulos
    private void RellTabla() {
        SubTotal = new BigDecimal(0);
        Discount = new BigDecimal(0);
        Neto = new BigDecimal(0);
        CIF = new BigDecimal(0);
        totAmount = new BigDecimal(0);

        DefaultTableModel modelo = (DefaultTableModel) TablaProd.getModel();
        modelo.setRowCount(ListArticulo.size());
        for (int i = 0; i < ListArticulo.size(); i++) {
            TablaProd.setValueAt(i + 1, i, 0);
            TablaProd.setValueAt(ListArticulo.get(i).getId_item(), i, 1);
            TablaProd.setValueAt(ListArticulo.get(i).getUnidad(), i, 2);
            TablaProd.setValueAt(ListArticulo.get(i).getCantidad(), i, 3);

            BigDecimal precioURed = ListArticulo.get(i).getUni_precio();
            BigDecimal DescuentoRed = ListArticulo.get(i).getDescuento();
            BigDecimal precioFRed = ListArticulo.get(i).getImporte_tot();

            TablaProd.setValueAt(DescuentoRed, i, 5);
            TablaProd.setValueAt(precioURed, i, 4);
            TablaProd.setValueAt(precioFRed, i, 6);

            SubTotal = SubTotal.add(ListArticulo.get(i).getUni_precio().multiply(new BigDecimal(String.valueOf(ListArticulo.get(i).getCantidad()))));
            Discount = Discount.add(ListArticulo.get(i).getDescuento());
            Neto = SubTotal.subtract(Discount);

            try {
                //variable tipo de envio
                CIF = new BigDecimal(InputCIF.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico en el CIF");
            }

            totAmount = Neto.add(CIF);

            //redondeando valores para mostrar
            SubTotal = SubTotal.setScale(2, RoundingMode.HALF_UP);
            Discount = Discount.setScale(2, RoundingMode.HALF_UP);
            Neto = Neto.setScale(2, RoundingMode.HALF_UP);
            totAmount = totAmount.setScale(2, RoundingMode.HALF_UP);

            labelSubTotal.setText(String.valueOf(SubTotal));
            labelDiscount.setText(String.valueOf(Discount));
            labelNeto.setText(String.valueOf(Neto));
            labelTotAmount.setText(String.valueOf(totAmount));

        }

        if (ListArticulo.size() == 0) {
            labelSubTotal.setText("0.00");
            labelDiscount.setText("0.00");
            labelNeto.setText("0.00");
            labelTotAmount.setText("0.00");
        }

    }

}
