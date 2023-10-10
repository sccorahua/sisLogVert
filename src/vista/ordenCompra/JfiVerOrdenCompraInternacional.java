package vista.ordenCompra;

//v1.0 SCN
import controlador.ConOrdenCompra;
import controlador.ConProveedor;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ItemOrdenCompraInter;
import modelo.OrdenCompraInter;
import modelo.Proveedor;

public class JfiVerOrdenCompraInternacional extends javax.swing.JInternalFrame {

    public JfiVerOrdenCompraInternacional(String ano, String periodo, String correlativo) {
        initComponents();
        this.setSize(new Dimension(700, 420));
        this.setTitle("Detalles Orden de Commpra Internacional " + correlativo + "-" + ano);
        //orden compra
        ConOrdenCompra conCompra = new ConOrdenCompra();
        OrdenCompraInter compra = conCompra.getOneCompraInt(Integer.parseInt(ano), Integer.parseInt(periodo), Integer.parseInt(correlativo));
        //company
        InputCompany.setEditable(false);
        ConProveedor conProv = new ConProveedor();
        JOptionPane.showMessageDialog(null, compra.getId_proveedor());
        Proveedor prov = conProv.conProveedor(String.valueOf(compra.getId_proveedor()), "", "", "");
        JOptionPane.showMessageDialog(null, prov.getNom_proveedor());
        InputCompany.setText(prov.getNom_proveedor());
        //address
        InputAddress.setEditable(false);
        InputAddress.setText(prov.getDir_proveedor());
        //phone
        InputPhone.setEditable(false);
        InputPhone.setText(prov.getTelefono());
        //email
        InputEmail.setEditable(false);
        InputEmail.setText(compra.getEmail());
        //quote number
        InputQuote.setEditable(false);
        InputQuote.setText(compra.getQuote_number());
        //date
        InputFecha.setEditable(false);
        InputFecha.setText(String.valueOf(compra.getFec_ord_com()));
        //Payment terms
        InputPaymentTerms.setEditable(false);
        InputPaymentTerms.setText(compra.getPay_ter());
        //Incoterms
        InputIncoterms.setEditable(false);
        InputIncoterms.setText(compra.getIncoterms());
        //Request Ship date
        InputShipDate.setEditable(false);
        InputShipDate.setText(compra.getReq_ship_date());
        //Freight
        InputFreightForw.setEditable(false);
        InputFreightForw.setText(compra.getFre_forw());
        //tabla
        DefaultTableModel modelo = (DefaultTableModel) TablaProd.getModel();
        ArrayList<ItemOrdenCompraInter> ListArticulo = conCompra.getListItemOfCompraInt(Integer.parseInt(ano), Integer.parseInt(periodo), Integer.parseInt(correlativo));
        modelo.setRowCount(ListArticulo.size());

        for (int i = 0; i < ListArticulo.size(); i++) {
            TablaProd.setValueAt(i + 1, i, 0);
            TablaProd.setValueAt(ListArticulo.get(i).getId_item(), i, 1);
            TablaProd.setValueAt(ListArticulo.get(i).getUnidad(), i, 2);
            TablaProd.setValueAt(ListArticulo.get(i).getCantidad(), i, 3);
            TablaProd.setValueAt(ListArticulo.get(i).getUni_precio(), i, 5);
            TablaProd.setValueAt(ListArticulo.get(i).getDescuento(), i, 4);
            TablaProd.setValueAt(ListArticulo.get(i).getImporte_tot(), i, 6);
        }

        //cost center
        InputCostCenter.setEditable(false);
        InputCostCenter.setText(compra.getCen_cost_ord_com());

        //currency
        InputCurrency.setEditable(false);
        InputCurrency.setText("dolares");

        //Username
        InputUserSol.setEditable(false);
        InputUserSol.setText(compra.getUser_sol());

        //SwiftCode
        InputSwiftCode.setEditable(false);
        InputSwiftCode.setText(compra.getSwi_cod());

        //bank details
        InputBankDet.setEditable(false);
        InputBankDet.setText(compra.getBan_det());

        //account number
        InputAccountNumber.setEditable(false);
        InputAccountNumber.setText(compra.getNro_cta());

        LabelFreight.setText(compra.getIncoterms().toUpperCase() + " Cost");
        LabelFreight1.setText(compra.getIncoterms().toUpperCase() + " Cost");

        //valores totales
        LabelValSubTotal.setText("S/." + String.valueOf(compra.getSub_total_sol()));
        LabelValDiscount.setText("S/." + String.valueOf(compra.getDescuento_sol()));
        LabelValNeto.setText("S/." + String.valueOf(compra.getNeto_sol()));
        LabelValFreight.setText("S/." + String.valueOf(compra.getTransporte_sol()));
        LabelValTotalAmount.setText("S/." + String.valueOf(compra.getTotal_amo_sol()));

        LabelValSubTotal1.setText("$" + String.valueOf(compra.getSub_total_dol()));
        LabelValDiscount1.setText("$" + String.valueOf(compra.getDescuento_dol()));
        LabelValNeto1.setText("$" + String.valueOf(compra.getNeto_dol()));
        LabelValFreight1.setText("$" + String.valueOf(compra.getTransporte_dol()));
        LabelValTotalAmount1.setText("$" + String.valueOf(compra.getTotal_amo_dol()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        InputAddress = new javax.swing.JTextField();
        InputPhone = new javax.swing.JTextField();
        InputEmail = new javax.swing.JTextField();
        InputPaymentTerms = new javax.swing.JTextField();
        InputShipDate = new javax.swing.JTextField();
        InputFreightForw = new javax.swing.JTextField();
        InputCompany = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        InputQuote = new javax.swing.JTextField();
        InputFecha = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProd = new javax.swing.JTable();
        InputIncoterms = new javax.swing.JTextField();
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
        InputCostCenter = new javax.swing.JTextField();
        LabelSubTotal = new javax.swing.JLabel();
        LabelDiscount = new javax.swing.JLabel();
        LabelNeto = new javax.swing.JLabel();
        LabelFreight = new javax.swing.JLabel();
        LabelTotAmount = new javax.swing.JLabel();
        LabelValSubTotal = new javax.swing.JLabel();
        LabelValDiscount = new javax.swing.JLabel();
        LabelValNeto = new javax.swing.JLabel();
        LabelValFreight = new javax.swing.JLabel();
        LabelValTotalAmount = new javax.swing.JLabel();
        LabelSubTotal1 = new javax.swing.JLabel();
        LabelDiscount1 = new javax.swing.JLabel();
        LabelNeto1 = new javax.swing.JLabel();
        LabelFreight1 = new javax.swing.JLabel();
        LabelTotAmount1 = new javax.swing.JLabel();
        LabelValTotalAmount1 = new javax.swing.JLabel();
        LabelValFreight1 = new javax.swing.JLabel();
        LabelValNeto1 = new javax.swing.JLabel();
        LabelValDiscount1 = new javax.swing.JLabel();
        LabelValSubTotal1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Company:");

        jLabel4.setText("Address:");

        jLabel5.setText("Phone:");

        jLabel7.setText("Quote number:");

        jLabel8.setText("Date:");

        jLabel9.setText("Payment terms:");

        jLabel10.setText("Incoterms:");

        jLabel11.setText("Request Ship Date:");

        jLabel12.setText("Freight Forwarder:");

        InputPaymentTerms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputPaymentTermsActionPerformed(evt);
            }
        });

        InputFreightForw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputFreightForwActionPerformed(evt);
            }
        });

        InputCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputCompanyActionPerformed(evt);
            }
        });

        jLabel1.setText("Email:");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(InputAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                    .addComponent(InputPhone, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(InputEmail)
                                    .addComponent(InputCompany)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(InputQuote, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(InputShipDate)
                            .addComponent(InputFecha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InputPaymentTerms, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InputIncoterms, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(InputFreightForw))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(InputCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(InputFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(InputAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InputPaymentTerms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(InputPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(InputIncoterms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(InputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(InputShipDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(InputQuote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(InputFreightForw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("General", jPanel1);

        jLabel13.setText("Cost Center:");

        jLabel14.setText("Currency:");

        jLabel15.setText("Username:");

        jLabel16.setText("Bank details:");

        jLabel17.setText("Account Number:");

        jLabel18.setText("Swift Code:");

        InputCostCenter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputCostCenterActionPerformed(evt);
            }
        });

        LabelSubTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelSubTotal.setText("SubTotal");

        LabelDiscount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelDiscount.setText("Discount");

        LabelNeto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelNeto.setText("Neto");

        LabelFreight.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelFreight.setText("Transport");

        LabelTotAmount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelTotAmount.setText("TotalAmount");

        LabelValSubTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelValSubTotal.setText("0.00");

        LabelValDiscount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelValDiscount.setText("0.00");

        LabelValNeto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelValNeto.setText("0.00");

        LabelValFreight.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelValFreight.setText("0.00");

        LabelValTotalAmount.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LabelValTotalAmount.setText("0.00");

        LabelSubTotal1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelSubTotal1.setText("SubTotal");

        LabelDiscount1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelDiscount1.setText("Discount");

        LabelNeto1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelNeto1.setText("Neto");

        LabelFreight1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelFreight1.setText("Transport");

        LabelTotAmount1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelTotAmount1.setText("TotalAmount");

        LabelValTotalAmount1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LabelValTotalAmount1.setText("0.00");

        LabelValFreight1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelValFreight1.setText("0.00");

        LabelValNeto1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelValNeto1.setText("0.00");

        LabelValDiscount1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelValDiscount1.setText("0.00");

        LabelValSubTotal1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelValSubTotal1.setText("0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(InputCostCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel14))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(InputCurrency)
                                    .addComponent(InputUserSol))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel16))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(InputBankDet, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(InputSwiftCode)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(LabelSubTotal1))
                                            .addComponent(LabelNeto1)
                                            .addComponent(LabelFreight1)
                                            .addComponent(LabelTotAmount1)
                                            .addComponent(LabelDiscount1))
                                        .addGap(40, 40, 40)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LabelValDiscount1)
                                            .addComponent(LabelValTotalAmount1)
                                            .addComponent(LabelValFreight1)
                                            .addComponent(LabelValNeto1)
                                            .addComponent(LabelValSubTotal1)))
                                    .addComponent(InputAccountNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(LabelSubTotal))
                            .addComponent(LabelNeto)
                            .addComponent(LabelFreight)
                            .addComponent(LabelTotAmount)
                            .addComponent(LabelDiscount))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelValDiscount)
                            .addComponent(LabelValTotalAmount)
                            .addComponent(LabelValFreight)
                            .addComponent(LabelValNeto)
                            .addComponent(LabelValSubTotal))
                        .addGap(378, 378, 378)))
                .addGap(55, 55, 55))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(InputCostCenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(InputSwiftCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(InputCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(InputUserSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(InputAccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(InputBankDet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelSubTotal)
                            .addComponent(LabelValSubTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDiscount)
                            .addComponent(LabelValDiscount))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelNeto)
                            .addComponent(LabelValNeto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelFreight, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelValFreight))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelTotAmount)
                            .addComponent(LabelValTotalAmount)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelSubTotal1)
                            .addComponent(LabelValSubTotal1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDiscount1)
                            .addComponent(LabelValDiscount1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelNeto1)
                            .addComponent(LabelValNeto1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelFreight1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelValFreight1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelTotAmount1)
                            .addComponent(LabelValTotalAmount1))))
                .addGap(104, 104, 104))
        );

        jTabbedPane1.addTab("Detalles", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 670, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InputPaymentTermsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputPaymentTermsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputPaymentTermsActionPerformed

    private void InputFreightForwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputFreightForwActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputFreightForwActionPerformed

    private void InputCostCenterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputCostCenterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputCostCenterActionPerformed

    private void InputCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputCompanyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputCompanyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField InputAccountNumber;
    private javax.swing.JTextField InputAddress;
    private javax.swing.JTextField InputBankDet;
    private javax.swing.JTextField InputCompany;
    private javax.swing.JTextField InputCostCenter;
    private javax.swing.JTextField InputCurrency;
    private javax.swing.JTextField InputEmail;
    private javax.swing.JTextField InputFecha;
    private javax.swing.JTextField InputFreightForw;
    private javax.swing.JTextField InputIncoterms;
    private javax.swing.JTextField InputPaymentTerms;
    private javax.swing.JTextField InputPhone;
    private javax.swing.JTextField InputQuote;
    private javax.swing.JTextField InputShipDate;
    private javax.swing.JTextField InputSwiftCode;
    private javax.swing.JTextField InputUserSol;
    private javax.swing.JLabel LabelDiscount;
    private javax.swing.JLabel LabelDiscount1;
    private javax.swing.JLabel LabelFreight;
    private javax.swing.JLabel LabelFreight1;
    private javax.swing.JLabel LabelNeto;
    private javax.swing.JLabel LabelNeto1;
    private javax.swing.JLabel LabelSubTotal;
    private javax.swing.JLabel LabelSubTotal1;
    private javax.swing.JLabel LabelTotAmount;
    private javax.swing.JLabel LabelTotAmount1;
    private javax.swing.JLabel LabelValDiscount;
    private javax.swing.JLabel LabelValDiscount1;
    private javax.swing.JLabel LabelValFreight;
    private javax.swing.JLabel LabelValFreight1;
    private javax.swing.JLabel LabelValNeto;
    private javax.swing.JLabel LabelValNeto1;
    private javax.swing.JLabel LabelValSubTotal;
    private javax.swing.JLabel LabelValSubTotal1;
    private javax.swing.JLabel LabelValTotalAmount;
    private javax.swing.JLabel LabelValTotalAmount1;
    private javax.swing.JTable TablaProd;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
