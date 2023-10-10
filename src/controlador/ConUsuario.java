package controlador;

import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;
import modelo.Usuario;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

//v 1.0 SCN

public class ConUsuario {
    //login
    public boolean IniciarSesion(Usuario user){
        boolean salida = false;
        Connection con = conexion.Conexion.conectar();
        String consulta = "SELECT USE_USUARIO FROM DB_VERTENER.MAE_USUARIO WHERE USE_USUARIO = '" + user.getUse_usuario() + "' AND aes_decrypt(password,'VEP2023I') = '" + user.getPassword() + "'";
        Statement st;
        
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            while (rs.next()) {
                salida = true;
            }
            
        } catch (SQLException e) {
            System.err.println("Error al iniciar sesion..." + e);
            JOptionPane.showMessageDialog(null, "Error al iniciar sesion");
        }
        
        return salida;
    }
    
    //cambiar contraseña
    public boolean CambiarContraseña(Usuario user){
        boolean retorno = false;
        return retorno;
    }
}
