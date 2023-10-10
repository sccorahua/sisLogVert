package controlador;

//v1.0 SCN
import java.sql.PreparedStatement;
import modelo.TipoCambio;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConTipoCambio {

    //registrar tipo de cambio
    public boolean InsTipCambio(TipoCambio tipCamb) {
        boolean confirma = false;
        Connection con = conexion.Conexion.conectar();
        try {
            PreparedStatement query = con.prepareStatement("insert into mae_tip_cambio(fec_tip_cambio,tip_cambio_compra,tip_cambio_venta) value(?,?,?);");
            query.setDate(1, tipCamb.getFec_tip_cambio());
            query.setBigDecimal(2, tipCamb.getTip_cambio_compra());
            query.setBigDecimal(3, tipCamb.getTip_cambio_venta());

            if (query.executeUpdate() > 0) {
                confirma = true;
            }
        } catch (SQLException e) {
            System.out.println("No se pudo realizar la operacion: " + e);
        }
        return confirma;
    }

    //consulta fecha en especifico
    public TipoCambio conFecha(Date fecha) {
        TipoCambio tipCamb = new TipoCambio();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select fec_tip_cambio as fecha,tip_cambio_compra as compra,tip_cambio_venta as venta from mae_tip_cambio where fec_tip_cambio = '" + fecha + "';");
            if(rs.next()){
                tipCamb.setFec_tip_cambio(rs.getDate("fecha"));
                tipCamb.setTip_cambio_compra(rs.getBigDecimal("compra"));
                tipCamb.setTip_cambio_venta(rs.getBigDecimal("venta"));
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar fecha en especifico: " + e);
        }
        return tipCamb;
    }
}
