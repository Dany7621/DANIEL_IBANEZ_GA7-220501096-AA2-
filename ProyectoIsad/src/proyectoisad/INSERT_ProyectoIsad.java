/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoisad;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author usuario
 */
public class INSERT_ProyectoIsad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
             String usuario = "root";//direccion para la conexcion
        String clave = ""; //pdirecicon para la clave, no hay  asi que esta vacion
        String url = "jdbc:mysql://localhost:3306/taller_isad"; //comunicacion con el sql
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//para ver si jala
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(INSERT_ProyectoIsad.class.getName()).log(Level.SEVERE, null, ex); // en caso de que no jale
        }
        //Objetos para obtener la conexión a DB
        Connection conexion; 
        Statement statement;
        ResultSet rs;
        
        //Conexión a DB
        try {
            conexion = DriverManager.getConnection(url, usuario, clave);

            statement = conexion.createStatement();
            statement.executeUpdate("INSERT INTO productos (estado, pieza, disponibilidad, precio)VALUES ('usado','rueda de turbina','1','20000.46')"); //update es el que realiza operaciones
            rs = statement.executeQuery("SELECT * FROM productos");//este imprime informacion al usuario
            rs.next();
            do {
                System.out.println(rs.getInt("id_productos") + ": "  + rs.getString("pieza")+ ". "+ rs.getString("estado")+ ". "  + rs.getInt("disponibilidad")+ " - "  + rs.getInt("precio") );
            }
            while(rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(INSERT_ProyectoIsad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
