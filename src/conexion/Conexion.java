
package conexion;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    //conexion local
    public static Connection conectar(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db_vertener?allowPublicKeyRetrieval=true&useSSL=false","root","VertEnergy23");
            return con;
        } catch (SQLException e){
            System.err.println("Error al conectar a la base de datos..." + e);
            return null;
        }
    }
}
