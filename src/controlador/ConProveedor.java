package controlador;

import modelo.Proveedor;
import java.sql.*;
import java.util.ArrayList;

public class ConProveedor {
    //registrar nuevo proveedor
    public boolean InsProveedor(Proveedor prov){
        boolean confirma = false;
        Connection con = conexion.Conexion.conectar();
        try {
            PreparedStatement query = con.prepareStatement("insert into db_vertener.mae_proveedor(nom_proveedor,tip_doc,num_doc,telefono,des_proveedor,dir_proveedor,estado) value(?,?,?,?,?,?,'A');");
            query.setString(1, prov.getNom_proveedor());
            query.setString(2, prov.getTip_doc());
            query.setString(3, prov.getNum_doc());
            query.setString(4, prov.getTelefono());
            query.setString(5, prov.getDes_proveedor());
            query.setString(6, prov.getDir_proveedor());
            
            if(query.executeUpdate()>0){
                confirma = true;
            }
        } catch (SQLException e) {
            System.out.println("No se pudo realizar la operacion: " + e);
        }
        return confirma;
    }
    
    //consulta proveedor en especifico
    public Proveedor conProveedor(String id ,String nombre, String tipoDoc, String numeroDoc) {
        Proveedor prov = new Proveedor();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select id_proveedor as id,nom_proveedor as nombre,tip_doc as tipDoc, num_doc as numDoc, des_proveedor as descripcion, dir_proveedor as direccion, estado as estado from mae_proveedor where (nom_proveedor = '" + nombre + "') or (tip_doc = '" + tipoDoc + "' and num_doc = '" + numeroDoc + "' ) or (id_proveedor = '" + id +"');");
            if(rs.next()){
                prov.setId_proveedor(rs.getInt("id"));
                prov.setNom_proveedor(rs.getString("nombre"));
                prov.setTip_doc(rs.getString("tipDoc"));
                prov.setNum_doc(rs.getString("numDoc"));
                prov.setDes_proveedor(rs.getString("descripcion"));
                prov.setDir_proveedor(rs.getString("direccion"));
                prov.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return prov;
    }
    
    //lista de proveedores
    public ArrayList<Proveedor> getListProveedor() {
        ArrayList<Proveedor> listProveedor = new ArrayList<>();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            //ordenado por nombre de forma alfabetica
            ResultSet rs = st.executeQuery("select id_proveedor as id,nom_proveedor as nombre,tip_doc as tipDoc, num_doc as numDoc, des_proveedor as descripcion, dir_proveedor as direccion, estado as estado from mae_proveedor where estado = 'A' order by nom_proveedor asc;");
            while(rs.next()){
                Proveedor prov = new Proveedor();
                prov.setId_proveedor(rs.getInt("id"));
                prov.setNom_proveedor(rs.getString("nombre"));
                prov.setTip_doc(rs.getString("tipDoc"));
                prov.setNum_doc(rs.getString("numDoc"));
                prov.setDes_proveedor(rs.getString("descripcion"));
                prov.setDir_proveedor(rs.getString("direccion"));
                prov.setEstado(rs.getString("estado"));
                listProveedor.add(prov);
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de obtener la lista proveedor: " + e);
        }
        return listProveedor;
    }
}
