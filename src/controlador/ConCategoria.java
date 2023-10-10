package controlador;

import java.sql.*;
import modelo.Categoria;
import java.util.ArrayList;

//v 1.0 SCN

public class ConCategoria { 
    //registrar categoria
    public boolean InsCategoria(Categoria cat) {
        boolean confirma = false;
        Connection con = conexion.Conexion.conectar();
        try {
            PreparedStatement query = con.prepareStatement("insert into db_vertener.mae_categoria values(?,?,?,'A');");
            query.setString(1, cat.getId_categoria());
            query.setString(2, cat.getNom_categoria());
            query.setString(3, cat.getDes_categoria());
            if (query.executeUpdate() > 0) {
                confirma = true;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al momento de guardar categoria" + e);
        }
        return confirma;
    }

    //lista de categorias
    public ArrayList<Categoria> getListCategoria() {
        ArrayList<Categoria> listCategoria = new ArrayList<>();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            //ordenado por nombre de forma alfabetica
            ResultSet rs = st.executeQuery("select id_categoria,nom_categoria,des_categoria,estado from mae_categoria where estado='A' order by nom_categoria asc;");
            while(rs.next()){
                Categoria cat = new Categoria();
                cat.setId_categoria(rs.getString("id_categoria"));
                cat.setNom_categoria(rs.getString("nom_categoria"));
                cat.setDes_categoria(rs.getString("des_categoria"));
                cat.setEstado(rs.getString("estado"));
                listCategoria.add(cat);
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de guardar item: " + e);
        }
        return listCategoria;
    }
    
    //consulta categoria en especifico
    public Categoria conCategoria(String idCategoria, String nombreCategoria) {
        Categoria cat = new Categoria();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select id_categoria as id,nom_categoria as nombre, des_categoria as descripcion, estado as estado from mae_categoria where id_categoria = '" + idCategoria + "' or nom_categoria = '" + nombreCategoria + "';");
            if(rs.next()){
                cat.setId_categoria(rs.getString("id"));
                cat.setNom_categoria(rs.getString("nombre"));
                cat.setDes_categoria(rs.getString("des_categoria"));
                cat.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return cat;
    }
}
