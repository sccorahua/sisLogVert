package vista.ordenServicio;

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
import modelo.ItemOrdenCompraInter;
import modelo.ItemOrdenCompraNacional;
import modelo.ItemOrdenServicio;

public class JfiAddServicio extends javax.swing.JInternalFrame {

    public JfiAddServicio(ArrayList<ItemOrdenServicio> ListArticulo, String IGV) {
        initComponents();
        this.setSize(new Dimension(400, 350));
        this.setTitle("Agregar producto");
        SpinCantidad.setValue(1);
        InputDcto.setText("0");
        //tipo de articulo
        this.valIGV = IGV;
        this.ListArt = ListArticulo;

    }

    private ArrayList<ItemOrdenServicio> ListArt = new ArrayList<>();

    public ArrayList<ItemOrdenServicio> getListArt() {
        return ListArt;
    }

    public void setListArt(ArrayList<ItemOrdenServicio> ListArt) {
        this.ListArt = ListArt;
    }

    public ArrayList<ItemOrdenServicio> GetListArt() {
        return ListArt;
    }

    //var IGV
    public String valIGV;

    //var tipo
    public String tip;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
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
        CheckIGV = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        InputDescripcion = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar Servicio");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 390, -1));

        jLabel3.setText("Unidad:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel4.setText("Cantidad:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel5.setText("Precio Unt:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel6.setText("Descuento:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        InputUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputUnidadActionPerformed(evt);
            }
        });
        getContentPane().add(InputUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 200, -1));

        SpinCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SpinCantidadStateChanged(evt);
            }
        });
        getContentPane().add(SpinCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 70, -1));

        InputPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                InputPrecioFocusLost(evt);
            }
        });
        InputPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputPrecioActionPerformed(evt);
            }
        });
        getContentPane().add(InputPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 200, -1));

        InputDcto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputDctoActionPerformed(evt);
            }
        });
        getContentPane().add(InputDcto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 200, -1));

        BtnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, -1));

        CheckIGV.setSelected(true);
        CheckIGV.setText("IGV");
        getContentPane().add(CheckIGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        jLabel9.setText("Descripcion:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        InputDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputDescripcionActionPerformed(evt);
            }
        });
        getContentPane().add(InputDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 200, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        boolean error = false;

        try {
            if (InputDescripcion.getText().length() > 100) {
                error = true;
            }
        } catch (Exception e) {
            error = true;
        }

        try {
            Double a = Double.valueOf(InputPrecio.getText());

            if (a < 0) {
                JOptionPane.showMessageDialog(null, "Debe indicar un precio mayor a 0");
                error = true;
            }

            if (InputPrecio.getText().contains(".")) {
                String[] split = InputPrecio.getText().split("\\.");
                String decimal = split[1];

                if (decimal.length() > 2) {
                    JOptionPane.showMessageDialog(null, "Cantidad maxima de decimales es 2");
                    error = true;
                }

            }

        } catch (HeadlessException | NumberFormatException | IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Debe colocar un valor correcto para el precio unitario" + e);
            error = true;
        }

        try {
            if (Float.parseFloat(InputDcto.getText()) < 0) {
                JOptionPane.showMessageDialog(null, "Debe indicar un descuento mayor a 0");
                error = true;

                if (InputDcto.getText().contains(".")) {
                    String[] split = InputDcto.getText().split("\\.");
                    String decimal = split[1];

                    if (decimal.length() > 2) {
                        JOptionPane.showMessageDialog(null, "Cantidad maxima de decimales es 2");
                        error = true;
                    }

                }
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
            //logica financiera
            BigDecimal cantidad = new BigDecimal(SpinCantidad.getValue().toString());
            BigDecimal precioU = new BigDecimal(InputPrecio.getText());
            BigDecimal descuento = new BigDecimal(InputDcto.getText());
            BigDecimal precioF = new BigDecimal(0);

            for (int i = 0; i < Integer.parseInt(SpinCantidad.getValue().toString()); i++) {
                precioF = precioF.add(precioU);
            }

            precioF = precioF.subtract(descuento);

            if (precioF.compareTo(new BigDecimal(0)) < 0) {
                JOptionPane.showMessageDialog(null, "El valor final no puede ser menor a 0. Revisar");
                return;
            }

            ItemOrdenServicio artG = new ItemOrdenServicio();

            artG.setDescripcion(InputDescripcion.getText());
            artG.setIGV(CheckIGV.isSelected());
            artG.setUnidad(InputUnidad.getText());
            artG.setCantidad(Integer.parseInt(SpinCantidad.getValue().toString()));
            if (artG.isIGV()) {
                BigDecimal NumIGV = new BigDecimal("1."+valIGV);
                
                BigDecimal precioURed = precioU.divide(NumIGV,MathContext.DECIMAL128);
                precioURed = precioURed.setScale(2, RoundingMode.HALF_UP);

                artG.setPre_unitario(new BigDecimal(precioURed.toString()));

                BigDecimal descuentoRed = descuento.divide(NumIGV,MathContext.DECIMAL128);
                descuentoRed = descuentoRed.setScale(2, RoundingMode.HALF_UP);


                artG.setDescuento(new BigDecimal(descuentoRed.toString()));

                BigDecimal precioFRed = precioURed.multiply(new BigDecimal(cantidad.toString()));
                precioFRed = precioFRed.subtract(descuentoRed);
                precioFRed = precioFRed.setScale(2, RoundingMode.HALF_UP);

                artG.setImporte(new BigDecimal(precioFRed.toString()));
                
                artG.setMontoUniIng(new BigDecimal(InputPrecio.getText()).multiply(cantidad));

            } else {
                BigDecimal precioURed = precioU;
                precioURed = precioURed.setScale(2, RoundingMode.HALF_UP);

                artG.setPre_unitario(new BigDecimal(precioURed.toString()));

                BigDecimal descuentoRed = descuento;
                descuentoRed = descuentoRed.setScale(2, RoundingMode.HALF_UP);

                artG.setDescuento(new BigDecimal(descuentoRed.toString()));

                BigDecimal precioFRed = precioF;
                precioFRed = precioFRed.setScale(2, RoundingMode.HALF_UP);

                artG.setImporte(new BigDecimal(precioFRed.toString()));
            }
            
            ListArt.add(artG);
            
            //reiniciando valores
            this.setVisible(false);
            InputDescripcion.setText("");
            InputUnidad.setText("");
            SpinCantidad.setValue(1);
            InputPrecio.setText("");
            InputDcto.setText("0");
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

    private void InputDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputDescripcionActionPerformed

    private void InputDctoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputDctoActionPerformed

    }//GEN-LAST:event_InputDctoActionPerformed

    private void InputPrecioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InputPrecioFocusLost

    }//GEN-LAST:event_InputPrecioFocusLost

    private void InputPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputPrecioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JCheckBox CheckIGV;
    private javax.swing.JTextField InputDcto;
    private javax.swing.JTextField InputDescripcion;
    private javax.swing.JTextField InputPrecio;
    private javax.swing.JTextField InputUnidad;
    private javax.swing.JSpinner SpinCantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
