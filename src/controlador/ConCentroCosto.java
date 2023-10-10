package controlador;

//v1.0 SCN
import java.sql.PreparedStatement;
import modelo.CentroCosto;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ConCentroCosto {

    //registrar nuevo centro de costo
    public boolean insCentroCosto(CentroCosto cenCosto) {
        boolean confirma = false;
        Connection con = conexion.Conexion.conectar();
        try {
            PreparedStatement query = con.prepareStatement("insert into mae_cen_costo(id_cen_costo,nom_cen_costo,dir_cen_costo,tel_cen_costo,estado) value(?,?,?,?,'A');");
            query.setString(1, cenCosto.getId_cen_costo());
            query.setString(2, cenCosto.getNom_cen_costo());
            query.setString(3, cenCosto.getDir_cen_costo());
            query.setString(4, cenCosto.getTel_cen_costo());

            if (query.executeUpdate() > 0) {
                confirma = true;
            }
        } catch (SQLException e) {
            System.out.println("No se pudo realizar la operacion: " + e);
        }
        return confirma;
    }

    //consulta centro de costo en especifico
    public CentroCosto conCentroCosto(String idCentroCosto, String nombreCentroCosto, String direccionCentroCosto) {
        CentroCosto centroCosto = new CentroCosto();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select id_cen_costo as id,nom_cen_costo as nombre,dir_cen_costo as direccion, tel_cen_costo as telefono, estado as estado from mae_cen_costo where nom_cen_costo = '" + nombreCentroCosto + "' or id_cen_costo = '" + idCentroCosto + "' or dir_cen_costo = '" + direccionCentroCosto + "' ;");
            if (rs.next()) {
                centroCosto.setId_cen_costo(rs.getString("id"));
                centroCosto.setNom_cen_costo(rs.getString("nombre"));
                centroCosto.setDir_cen_costo(rs.getString("direccion"));
                centroCosto.setTel_cen_costo(rs.getString("telefono"));
                centroCosto.setTel_cen_costo(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return centroCosto;
    }

    //lista de centro de costo
    public ArrayList<CentroCosto> getListCentroCosto() {
        ArrayList<CentroCosto> listCentroCosto = new ArrayList<>();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            //ordenado por nombre de forma alfabetica
            ResultSet rs = st.executeQuery("select id_cen_costo as id,nom_cen_costo as nombre,dir_cen_costo as direccion,tel_cen_costo as telefono,estado as estado from mae_cen_costo where estado='A' order by nom_cen_costo asc;");
            while (rs.next()) {
                CentroCosto cCosto = new CentroCosto();
                cCosto.setId_cen_costo(rs.getString("id"));
                cCosto.setNom_cen_costo(rs.getString("nombre"));
                cCosto.setDir_cen_costo(rs.getString("direccion"));
                cCosto.setTel_cen_costo(rs.getString("telefono"));
                cCosto.setEstado(rs.getString("estado"));
                listCentroCosto.add(cCosto);
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de guardar en lista Centro de Costo: " + e);
        }
        return listCentroCosto;
    }
}
