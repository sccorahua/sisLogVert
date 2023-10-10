package vista.ordenCompra;

//v1.0 SCN
import controlador.ConCategoria;
import controlador.ConItem;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Categoria;
import modelo.Item;
import modelo.ItemOrdenCompraInter;
import modelo.ItemOrdenCompraNacional;

public class JfiAddProducto extends javax.swing.JInternalFrame {

    private ArrayList<ItemOrdenCompraNacional> LisArt = new ArrayList<>();
    private ArrayList<ItemOrdenCompraInter> ListArtInt = new ArrayList<>();

    public ArrayList<ItemOrdenCompraNacional> GetLisArt() {
        return LisArt;
    }

    public JfiAddProducto(ArrayList<ItemOrdenCompraNacional> ListArticulo, ArrayList<ItemOrdenCompraInter> ListArticuloInt, String IGV, String tipo) {
        initComponents();
        this.setSize(new Dimension(400, 450));
        this.setTitle("Agregar producto");
        ComboCategoria.removeAllItems();
        ComboCategoria.addItem("Elija una opcion");
        ComboArticulo.addItem("Elija una opcion");
        cargarComboCategoria();
        SpinCantidad.setValue(1);
        InputDcto.setText("0");
        //tipo de articulo
        this.tip = tipo;
        if (tipo.equals("i")) {
            CheckIGV.setVisible(false);
            this.ListArtInt = ListArticuloInt;
        }
        //igv si es nacional
        if (tipo.equals("n")) {
            this.valIGV = IGV;
            this.LisArt = ListArticulo;

        }
    }

    //evitar alerta si alguna categoria no contiene articulos asociados
    private boolean CatArtAsoc = false;

    //var IGV
    public String valIGV;

    //var tipo
    public String tip;

    private void cargarComboCategoria() {
        ConCategoria metodCat = new ConCategoria();
        ArrayList<Categoria> listCategoria = metodCat.getListCategoria();

        for (int i = 0; i < listCategoria.size(); i++) {
            ComboCategoria.addItem(listCategoria.get(i).getId_categoria() + "-" + listCategoria.get(i).getNom_categoria());
        }
    }

    private void cargarComboItem(String categoria) {
        ConItem metodItem = new ConItem();
        ArrayList<Item> listItem = metodItem.conListItem(categoria);

        for (int i = 0; i < listItem.size(); i++) {
            ComboArticulo.addItem(listItem.get(i).getId_item() + "-" + listItem.get(i).getNom_item());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ComboArticulo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        InputUnidad = new javax.swing.JTextField();
        SpinCantidad = new javax.swing.JSpinner();
        InputPrecio = new javax.swing.JTextField();
        InputDcto = new javax.swing.JTextField();
        BtnAgregar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        ComboCategoria = new javax.swing.JComboBox<>();
        CheckIGV = new javax.swing.JCheckBox();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar Producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 390, -1));

        jLabel2.setText("Articulo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        ComboArticulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(ComboArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 200, -1));

        jLabel3.setText("Unidad:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel4.setText("Cantidad:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jLabel5.setText("Precio Unt:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel6.setText("Descuento:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        InputUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputUnidadActionPerformed(evt);
            }
        });
        getContentPane().add(InputUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 200, -1));

        SpinCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SpinCantidadStateChanged(evt);
            }
        });
        getContentPane().add(SpinCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 70, -1));
        getContentPane().add(InputPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 200, -1));
        getContentPane().add(InputDcto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 200, -1));

        BtnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, -1, -1));

        jLabel8.setText("Categoria:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        ComboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(ComboCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 200, -1));

        CheckIGV.setSelected(true);
        CheckIGV.setText("IGV");
        getContentPane().add(CheckIGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCategoriaActionPerformed
        ComboArticulo.removeAllItems();
        if (ComboCategoria.getSelectedItem() == null) {
        } else if (!ComboCategoria.getSelectedItem().toString().equalsIgnoreCase("Seleccione una categoria")) {
            String[] split = ComboCategoria.getSelectedItem().toString().split("-");
            String IdCategoria = split[0];
            cargarComboItem(IdCategoria);
            if (ComboArticulo.getSelectedItem() == null && CatArtAsoc) {
                JOptionPane.showMessageDialog(null, "La categoria no cuenta con articulos asociados");
            }
            CatArtAsoc = true;
        }
    }//GEN-LAST:event_ComboCategoriaActionPerformed

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        boolean error = false;
        try {
            if (ComboArticulo.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un producto a comprar");
                error = true;
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un articulo" + e);
            error = true;
        }
        try {
            if (Float.parseFloat(InputPrecio.getText()) < 0) {
                JOptionPane.showMessageDialog(null, "Debe indicar un precio mayor a 0");
                error = true;
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe colocar un valor correcto para el precio unitario" + e);
            error = true;
        }

        try {
            if (Float.parseFloat(InputDcto.getText()) < 0) {
                JOptionPane.showMessageDialog(null, "Debe indicar un descuento mayor a 0");
                error = true;
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe colocar un valor correcto para el descuento" + e);
            error = true;
        }

        try {
            if (InputUnidad.getText().length() > 10) {
                JOptionPane.showMessageDialog(null, "El maximo permitido son 10 digitos para el valor del campo Unidad");
                error = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe colocar un valor correcto para el tipo de unidad" + e);

        }

        if (!error) {
            String[] split = ComboArticulo.getSelectedItem().toString().split("-");
            String idArticulo = split[0];
            int cantidad = Integer.parseInt(SpinCantidad.getValue().toString());
            BigDecimal precioU = new BigDecimal(InputPrecio.getText());
            BigDecimal descuento = new BigDecimal(InputDcto.getText());
            BigDecimal precioF = (precioU.multiply(new BigDecimal(String.valueOf(cantidad)))).subtract(descuento);
            if (precioF.compareTo(new BigDecimal(0)) == -1) {
                JOptionPane.showMessageDialog(null, "El valor final no puede ser menor a 0. Revisar");
                return;
            }

            switch (tip) {
                case "n":
                    ItemOrdenCompraNacional artG = new ItemOrdenCompraNacional();

                    artG.setId_item(idArticulo);
                    artG.setCantidad(cantidad);
                    artG.setIGV(CheckIGV.isSelected());
                    artG.setTip_unidad(InputUnidad.getText());

                    if (artG.isIGV()) {
                        BigDecimal PrecioUIGV = precioU.divide(new BigDecimal(String.valueOf("1." + valIGV)), MathContext.DECIMAL128);
                        PrecioUIGV = PrecioUIGV.setScale(2, RoundingMode.HALF_UP);
                        BigDecimal DescuentoIGV = descuento.divide(new BigDecimal(String.valueOf("1." + valIGV)), MathContext.DECIMAL128);
                        DescuentoIGV = DescuentoIGV.setScale(2, RoundingMode.HALF_UP);
                        BigDecimal precioFIGV = precioF.divide(new BigDecimal(String.valueOf("1." + valIGV)), MathContext.DECIMAL128);
                        precioFIGV = precioFIGV.setScale(2, RoundingMode.HALF_UP);

                        artG.setPrecioU(PrecioUIGV);
                        artG.setDescuento(DescuentoIGV);
                        artG.setPrecioF(precioFIGV);
                        artG.setMontoUniIng(new BigDecimal(InputPrecio.getText()).multiply(new BigDecimal(SpinCantidad.getValue().toString())));

                    } else {
                        artG.setPrecioU(precioU);
                        artG.setDescuento(descuento);
                        artG.setPrecioF(precioF);
                    }
                    LisArt.add(artG);
                case "i":
                    ItemOrdenCompraInter artS = new ItemOrdenCompraInter();

                    artS.setId_item(idArticulo);
                    artS.setCantidad(cantidad);
                    artS.setUnidad(InputUnidad.getText());
                    artS.setUni_precio(precioU);
                    artS.setDescuento(descuento);
                    artS.setImporte_tot(precioF);
                    ListArtInt.add(artS);
            }
            //reiniciando valores
            this.setVisible(false);
            CatArtAsoc = false;
            ComboCategoria.setSelectedItem("Elija una opcion");
            ComboArticulo.addItem("Elija una opcion");
            InputUnidad.setText("");
            SpinCantidad.setValue(1);
            InputPrecio.setText("");
            InputDcto.setText("");
        }
    }//GEN-LAST:event_BtnAgregarActionPerformed


    private void SpinCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SpinCantidadStateChanged
        try {
            int cantidad = Integer.parseInt(SpinCantidad.getValue().toString());

            if (cantidad < 1) {
                JOptionPane.showMessageDialog(null, "La cantidad minima es 1");
                SpinCantidad.setValue(1);
            }
        } catch (HeadlessException | NumberFormatException e) {
            System.out.println("Error: " + e);
            JOptionPane.showMessageDialog(null, "Indique un numero entero valido" + e);
            SpinCantidad.setValue(1);
        }
    }//GEN-LAST:event_SpinCantidadStateChanged

    private void InputUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputUnidadActionPerformed

    }//GEN-LAST:event_InputUnidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JCheckBox CheckIGV;
    private javax.swing.JComboBox<String> ComboArticulo;
    private javax.swing.JComboBox<String> ComboCategoria;
    private javax.swing.JTextField InputDcto;
    private javax.swing.JTextField InputPrecio;
    private javax.swing.JTextField InputUnidad;
    private javax.swing.JSpinner SpinCantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
