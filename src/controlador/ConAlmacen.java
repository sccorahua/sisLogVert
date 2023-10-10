package controlador;

//V1.0 SCN

import modelo.Almacen;
import java.sql.*;
import java.util.ArrayList;

public class ConAlmacen {
    //registrar nuevo almacen
    public boolean InsAlmacen(Almacen alm){
        boolean confirma = false;
        Connection con = conexion.Conexion.conectar();
        
        try {
            PreparedStatement query = con.prepareStatement("insert into db_vertener.mae_almacen value(?,?,?,'1','A');");
            query.setString(1, alm.getCod_alm());
            query.setString(2, alm.getNom_alm());
            query.setString(3, alm.getDir_alm());
            
            if(query.executeUpdate()>0){
                confirma = true;
            }
        } catch (SQLException e) {
            System.out.println("No se pudo realizar la operación: " + e);
        }
        return confirma;
    }
    //consulta almacen en especifico
    public Almacen conAlmacen(String idAlmacen, String nombreAlmacen, String direccionAlmacen) {
        Almacen alm = new Almacen();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select cod_alm as id,nom_alm as nombre,dir_alm as direccion, id_emp as empresa, estado as estado from mae_almacen where cod_alm = '" + idAlmacen + "' or nom_alm = '" + nombreAlmacen + "' or dir_alm = '" + direccionAlmacen + "';");
            if(rs.next()){
                alm.setCod_alm(rs.getString("id"));
                alm.setNom_alm(rs.getString("nombre"));
                alm.setDir_alm(rs.getString("direccion"));
                alm.setId_emp(rs.getInt("empresa"));
                alm.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return alm;
    }
    
    //lista de almacen
    public ArrayList<Almacen> getListAlmacen() {
        ArrayList<Almacen> listAlmacen = new ArrayList<>();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            //ordenado por nombre de forma alfabetica
            ResultSet rs = st.executeQuery("select cod_alm as id,nom_alm as nombre,dir_alm as direccion, id_emp as empresa, estado as estado from mae_almacen where estado = 'A' order by nom_alm asc");
            while(rs.next()){
                Almacen alm = new Almacen();
                alm.setCod_alm(rs.getString("id"));
                alm.setNom_alm(rs.getString("nombre"));
                alm.setDir_alm(rs.getString("direccion"));
                alm.setId_emp(rs.getInt("empresa"));
                alm.setEstado(rs.getString("estado"));
                listAlmacen.add(alm);
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de guardar item: " + e);
        }
        return listAlmacen;
    }
    
}
