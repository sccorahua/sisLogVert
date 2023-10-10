package vista;

// v1.0 SCN
import controlador.ConAlmacen;
import controlador.ConCategoria;
import controlador.ConInventarioAlmacen;
import controlador.ConItem;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Almacen;
import modelo.Categoria;
import modelo.InventarioAlmacen;
import modelo.Item;

public class JfiConsultaStock extends javax.swing.JInternalFrame {

    public JfiConsultaStock() {
        initComponents();
        this.setSize(new Dimension(600, 400));
        this.setTitle("Stock actual");
        //almacen
        ComboAlm.removeAllItems();
        ComboAlm.addItem("Elija una opción");
        cargarComboAlmacen();
        //categoria
        ComboCategoria.removeAllItems();
        ComboCategoria.addItem("Elija una opción");
        cargarComboCategoria();
        //producto
        ComboProd.removeAllItems();
        ComboProd.addItem("Elija una opción");
        cargarComboProducto();
    }

    int contCategoria = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProd = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ComboAlm = new javax.swing.JComboBox<>();
        ComboProd = new javax.swing.JComboBox<>();
        BtnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ComboCategoria = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Articulo", "Cantidad", "Almacen"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
            TablaProd.getColumnModel().getColumn(0).setPreferredWidth(10);
            TablaProd.getColumnModel().getColumn(1).setPreferredWidth(100);
            TablaProd.getColumnModel().getColumn(2).setPreferredWidth(25);
            TablaProd.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 570, 270));

        jLabel1.setText("Almacen:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        jLabel2.setText("Producto:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, 20));

        ComboAlm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboAlm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboAlmActionPerformed(evt);
            }
        });
        getContentPane().add(ComboAlm, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 150, -1));

        ComboProd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(ComboProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 140, -1));

        BtnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 80, 30));

        jLabel3.setText("Categoria:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        ComboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(ComboCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 150, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboAlmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboAlmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboAlmActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        ArrayList<InventarioAlmacen> listInv = new ArrayList<>();
        ConInventarioAlmacen conInv = new ConInventarioAlmacen();
        ConItem conIt = new ConItem();
        ConAlmacen conAlm = new ConAlmacen();

        String[] split = ComboAlm.getSelectedItem().toString().split("-");
        String idAlm = split[0];

        String[] split1 = ComboProd.getSelectedItem().toString().split("-");
        String idProd = split1[0];

        if (ComboProd.getSelectedItem().equals("Elija una opción") && !ComboAlm.getSelectedItem().toString().equals("Elija una opción")) {
            listInv = conInv.getInvAlm(idAlm);
        } else if (!ComboProd.getSelectedItem().equals("Elija una opción") && ComboAlm.getSelectedItem().toString().equals("Elija una opción")) {
            listInv = conInv.getInvItem(idProd);
        } else if (!ComboProd.getSelectedItem().equals("Elija una opción") && !ComboAlm.getSelectedItem().toString().equals("Elija una opción")) {
            listInv.add(conInv.getInvItemAlm(idAlm, idProd));
        } else if (ComboProd.getSelectedItem().equals("Elija una opción") && ComboAlm.getSelectedItem().toString().equals("Elija una opción")) {
            JOptionPane.showMessageDialog(null, "Indicar al menos un producto o almacen");
        }

        DefaultTableModel modelo = (DefaultTableModel) TablaProd.getModel();

        if (listInv.get(0).getCantidad() == -1) {
            JOptionPane.showMessageDialog(null, "No existen stock del producto seleccionado");
        } else {
            modelo.setRowCount(listInv.size());
            for (int i = 0; i < listInv.size(); i++) {
                TablaProd.setValueAt(i + 1, i, 0);

                Item it = conIt.conItemId(listInv.get(i).getId_item());

                TablaProd.setValueAt(it.getId_item() + "-" + it.getNom_item(), i, 1);
                TablaProd.setValueAt(listInv.get(i).getCantidad(), i, 2);

                Almacen alm = conAlm.conAlmacen(listInv.get(i).getId_almacen(), "", "");

                TablaProd.setValueAt(alm.getCod_alm() + "-" + alm.getNom_alm(), i, 3);
            }
        }

    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void ComboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCategoriaActionPerformed
        try {
            if (ComboCategoria.getSelectedItem().equals("Elija una opción") && contCategoria > 0) {
                ComboProd.setSelectedItem("Elija una opción");
            } else {
                cargarComboProducto();
            }
        } catch (Exception e) {

        }

        contCategoria += 1;
    }//GEN-LAST:event_ComboCategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JComboBox<String> ComboAlm;
    private javax.swing.JComboBox<String> ComboCategoria;
    private javax.swing.JComboBox<String> ComboProd;
    public static javax.swing.JTable TablaProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void cargarComboAlmacen() {
        ConAlmacen metAlmacen = new ConAlmacen();
        ArrayList<Almacen> listAlmacen = metAlmacen.getListAlmacen();

        for (int i = 0; i < listAlmacen.size(); i++) {
            ComboAlm.addItem(listAlmacen.get(i).getCod_alm() + "-" + listAlmacen.get(i).getNom_alm());
        }
    }

    private void cargarComboCategoria() {
        ConCategoria metodCat = new ConCategoria();
        ArrayList<Categoria> listCategoria = metodCat.getListCategoria();
        ComboCategoria.removeAllItems();

        for (int i = 0; i < listCategoria.size(); i++) {
            ComboCategoria.addItem(listCategoria.get(i).getId_categoria() + "-" + listCategoria.get(i).getNom_categoria());
        }
    }

    private void cargarComboProducto() {
        ComboProd.removeAllItems();
        ComboProd.addItem("Elija una opción");
        ConItem metItem = new ConItem();
        String[] split = ComboCategoria.getSelectedItem().toString().split("-");
        String idCat = split[0];
        ArrayList<Item> ListItem = metItem.conListItem(idCat);

        for (int i = 0; i < ListItem.size(); i++) {
            ComboProd.addItem(ListItem.get(i).getId_item() + "-" + ListItem.get(i).getNom_item());
        }
    }

}
