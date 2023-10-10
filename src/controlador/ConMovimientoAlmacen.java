package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import modelo.MovimientoAlmacen;

// v1.0 SCN
public class ConMovimientoAlmacen {

    //registro de un movimiento INGRESO a almacen
    public boolean InsIngresoMovAlmacen(MovimientoAlmacen ingMovAlm) {
        boolean confirma = false;
        Connection con = conexion.Conexion.conectar();
        try {
            PreparedStatement query = con.prepareStatement("insert into mae_mov_almacen(cod_almacen,id_item,tip_mov,mot_mov,fec_mov,id_proveedor,cantidad,precio_unit,comentario,ref_mov) value(?,?,'I',?,?,?,?,?,?,?);");
            query.setString(1, ingMovAlm.getCod_almacen());
            query.setString(2, ingMovAlm.getId_item());
            query.setString(3, ingMovAlm.getMot_mov());
            query.setDate(4, ingMovAlm.getFec_mov());
            query.setInt(5, ingMovAlm.getId_proveedor());
            query.setInt(6, ingMovAlm.getCantidad());
            query.setBigDecimal(7, ingMovAlm.getPrecio_unit());
            query.setString(8, ingMovAlm.getComentario());
            query.setString(9,ingMovAlm.getRef_mov());

            if (query.executeUpdate() > 0) {
                confirma = true;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return confirma;
    }
    
    //registro de un movimiento SALIDA a almacen
    public boolean InsSalidaMovAlmacen(MovimientoAlmacen ingMovAlm) {
        boolean confirma = false;
        Connection con = conexion.Conexion.conectar();
        try {
            PreparedStatement query = con.prepareStatement("insert into mae_mov_almacen(cod_almacen,id_item,tip_mov,mot_mov,fec_mov,cantidad,comentario) value(?,?,'S',?,?,?,?);");
            query.setString(1, ingMovAlm.getCod_almacen());
            query.setString(2, ingMovAlm.getId_item());
            query.setString(3, ingMovAlm.getMot_mov());
            query.setDate(4, ingMovAlm.getFec_mov());
            query.setInt(5, ingMovAlm.getCantidad());
            query.setString(6, ingMovAlm.getComentario());

            if (query.executeUpdate() > 0) {
                confirma = true;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return confirma;
    }

    //validar fecha
    public boolean valFecha(String fecha) {
        boolean confirma = false;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
        formatoFecha.setLenient(false);
        try {
            formatoFecha.parse(fecha);
            confirma = true;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "error: " + e);
        }
        return confirma;
    }
}
