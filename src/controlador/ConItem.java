package controlador;

import modelo.Item;
import java.sql.*;
import java.util.ArrayList;

//v 1.0 SCN
public class ConItem {

    //registrar nuevo item
    public boolean InsItem(Item item) {
        boolean confirma = false;
        Connection con = conexion.Conexion.conectar();
        try {
            PreparedStatement query = con.prepareStatement("insert into db_vertener.mae_item values(?,?,?,'A',?);");
            query.setString(1, item.getId_item());
            query.setString(2, item.getNom_item());
            query.setString(3, item.getDes_item());
            query.setString(4, item.getId_categoria());

            if (query.executeUpdate() > 0) {
                confirma = true;
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("No se pudo realizar el registro " + e);
        }
        return confirma;
    }

    //consulta item en especifico
    public Item conItem(String nombreItem, String categoria) {
        Item item = new Item();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select id_item as id,nom_item as nombre,des_item as descripcion, estado as estado, id_categoria as categoria from mae_item where nom_item = '" + nombreItem + "' and id_categoria = '" + categoria + "' ;");
            if (rs.next()) {
                item.setId_item(rs.getString("id"));
                item.setNom_item(rs.getString("nombre"));
                item.setDes_item(rs.getString("descripcion"));
                item.setEstado(rs.getString("estado"));
                item.setId_categoria(rs.getString("categoria"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return item;
    }
    
    //consulta item por id
    public Item conItemId(String id) {
        Item item = new Item();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select id_item as id,nom_item as nombre,des_item as descripcion, estado as estado, id_categoria as categoria from mae_item where id_item = '" + id + "';");
            if (rs.next()) {
                item.setId_item(rs.getString("id"));
                item.setNom_item(rs.getString("nombre"));
                item.setDes_item(rs.getString("descripcion"));
                item.setEstado(rs.getString("estado"));
                item.setId_categoria(rs.getString("categoria"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return item;
    }

    //consulta lista de item por categoria
    public ArrayList<Item> conListItem(String categoria) {
        ArrayList<Item> listItem = new ArrayList<>();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select id_item as id,nom_item as nombre,des_item as descripcion, estado as estado, id_categoria as categoria from mae_item where id_categoria = '" + categoria + "' ;");
            while (rs.next()) {
                Item item = new Item();
                item.setId_item(rs.getString("id"));
                item.setNom_item(rs.getString("nombre"));
                item.setDes_item(rs.getString("descripcion"));
                item.setEstado(rs.getString("estado"));
                item.setId_categoria(rs.getString("categoria"));
                listItem.add(item);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return listItem;
    }
}
