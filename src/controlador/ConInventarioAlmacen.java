package controlador;

// v1.0 SCN
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import modelo.InventarioAlmacen;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ConInventarioAlmacen {

    private Connection con = conexion.Conexion.conectar();

    //registrar nuevo inventario
    public boolean insInvAlm(InventarioAlmacen item) {
        boolean confirma = false;
        try {
            PreparedStatement query = con.prepareStatement("INSERT INTO MAE_INV_ITEM(ID_ALMACEN,ID_ITEM,PRECIO_RED,CANTIDAD) VALUE(?,?,?,?);");
            query.setString(1, item.getId_almacen());
            query.setString(2, item.getId_item());
            query.setBigDecimal(3, item.getPrecio_red());
            query.setInt(4, item.getCantidad());

            if (query.executeUpdate() > 0) {
                confirma = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de registrar un nuevo producto en inventario " + e);
        }
        return confirma;
    }

    //obtener inventario item
    public InventarioAlmacen getInvItemAlm(String almacen, String item) {
        InventarioAlmacen inv = new InventarioAlmacen();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT ID_ALMACEN,ID_ITEM,PRECIO_RED,CANTIDAD FROM MAE_INV_ITEM WHERE ID_ALMACEN = '" + almacen + "' AND ID_ITEM = '" + item + "';");
            if (rs.next()) {
                inv.setId_almacen(rs.getString("ID_ALMACEN"));
                inv.setId_item(rs.getString("ID_ITEM"));
                inv.setPrecio_red(rs.getBigDecimal("PRECIO_RED"));
                inv.setCantidad(rs.getInt("CANTIDAD"));
            } else {
                inv.setCantidad(-1);
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de obtener consulta de item en inventario: " + e);
        }
        return inv;
    }

    //obtener inventario alm
    public ArrayList<InventarioAlmacen> getInvAlm(String almacen) {
        ArrayList<InventarioAlmacen> listInv = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT ID_ALMACEN,ID_ITEM,PRECIO_RED,CANTIDAD FROM MAE_INV_ITEM WHERE ID_ALMACEN = '" + almacen + "';");
            while (rs.next()) {
                InventarioAlmacen inv = new InventarioAlmacen();
                inv.setId_almacen(rs.getString("ID_ALMACEN"));
                inv.setId_item(rs.getString("ID_ITEM"));
                inv.setPrecio_red(rs.getBigDecimal("PRECIO_RED"));
                inv.setCantidad(rs.getInt("CANTIDAD"));
                listInv.add(inv);
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de obtener consulta de item en inventario: " + e);
        }
        return listInv;
    }

    //obtener inventario item
    public ArrayList<InventarioAlmacen> getInvItem(String item) {
        ArrayList<InventarioAlmacen> listInv = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT ID_ALMACEN,ID_ITEM,PRECIO_RED,CANTIDAD FROM MAE_INV_ITEM WHERE ID_ITEM = '" + item + "';");
            while (rs.next()) {
                InventarioAlmacen inv = new InventarioAlmacen();
                inv.setId_almacen(rs.getString("ID_ALMACEN"));
                inv.setId_item(rs.getString("ID_ITEM"));
                inv.setPrecio_red(rs.getBigDecimal("PRECIO_RED"));
                inv.setCantidad(rs.getInt("CANTIDAD"));
                listInv.add(inv);
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de obtener consulta de item en inventario: " + e);
        }
        return listInv;
    }

    //movimientos en almacen (tipo S salida I ingreso)
    public int regItemInventario(InventarioAlmacen item, String tipo) {
        InventarioAlmacen cons = getInvItemAlm(item.getId_almacen(), item.getId_item());
        int stock = 0;

        //no existe el producto
        if (cons.getCantidad() == -1 && tipo.equals("I")) {
            try {
                PreparedStatement query = con.prepareStatement("INSERT INTO MAE_INV_ITEM(ID_ALMACEN,ID_ITEM,PRECIO_RED,CANTIDAD) VALUE(?,?,?,?);");
                query.setString(1, item.getId_almacen());
                query.setString(2, item.getId_item());
                query.setBigDecimal(3, item.getPrecio_red());
                query.setInt(4, item.getCantidad());

                if (query.executeUpdate() > 0) {
                    stock = item.getCantidad();
                }
            } catch (SQLException e) {
                System.out.println("Error al momento de hacer el nuevo registro del producto: " + e);
            }
            //modificando registro
        } else if (cons.getCantidad() > -1 && tipo.equals("I")) {
            String stock1 = String.valueOf(cons.getCantidad() + item.getCantidad());

            BigDecimal precio = ((cons.getPrecio_red().multiply(new BigDecimal(cons.getCantidad()))).add(item.getPrecio_red().multiply(new BigDecimal(item.getCantidad())))).divide(new BigDecimal(stock1), MathContext.DECIMAL128);
            precio = precio.setScale(2, RoundingMode.HALF_UP);

            try {
                PreparedStatement query = con.prepareStatement("UPDATE MAE_INV_ITEM SET CANTIDAD = ?, PRECIO_RED = ? WHERE ID_ALMACEN = ? AND ID_ITEM = ?;");
                query.setInt(1, stock);
                query.setBigDecimal(2, precio);
                query.setString(3, item.getId_almacen());
                query.setString(4, item.getId_item());

                query.executeUpdate();

            } catch (SQLException e) {
                System.out.println("Error al momento de actualizar el item del inventario: " + e);
            }
        }

        if (cons.getCantidad() > -1 && tipo.equals("S")) {
            stock = cons.getCantidad() - item.getCantidad();
            System.out.println("primero:" + cons.getCantidad() + " luego: " + stock);
            if (stock > 0) {
                try {
                    PreparedStatement query = con.prepareStatement("UPDATE MAE_INV_ITEM SET CANTIDAD = ? WHERE ID_ALMACEN = ? AND ID_ITEM = ?;");
                    query.setInt(1, stock);
                    query.setString(2, item.getId_almacen());
                    query.setString(3, item.getId_item());

                    query.executeUpdate();

                } catch (SQLException e) {
                    System.out.println("Error al momento de actualizar el item del inventario: " + e);
                }
            }
        } else if (cons.getCantidad() == -1 && tipo.equals("S")) {
            stock = -1;
        }
        return stock;
    }
}
