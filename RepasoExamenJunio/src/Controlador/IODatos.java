/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Usuario;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alumnodaw
 */
public class IODatos {
    private static final String URL= "jdbc:mysql://192.168.4.121:3306/usuarios_repaso";
    private static final String USER="admin";
    private static final String PASS="Admin1234";
    
    public static void addusers(Usuario u){
        try (Connection con= DriverManager.getConnection(URL, USER, PASS);){
            PreparedStatement ps = con.prepareStatement("insert into usuarios values(?,?,?,?,?)");
            
            ps.setString(1,u.getNombre());
            ps.setString(2,u.getContra());
            ps.setString(4,u.getEquipo());
            ps.setInt(3,u.getEdad());
            ps.setString(5,u.getRuta_foto());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(IODatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean comprobarlogin(String nombre,String contra){
        boolean correcto=false;
         try (Connection con= DriverManager.getConnection(URL, USER, PASS);){
             PreparedStatement ps = con.prepareStatement("select * from usuarios where nombre=? and contra=?");
             
             ps.setString(1,nombre);
             ps.setString(2,contra);
             
            ResultSet rs = ps.executeQuery();
             
             if(rs.next()){
                 correcto = true;
             }
             
         } catch (SQLException ex) {
            Logger.getLogger(IODatos.class.getName()).log(Level.SEVERE, null, ex);
        }
         return correcto;
        
    }
    
    public static boolean comprobaruserexists(String nombre){
        boolean existe=false;
                 try (Connection con= DriverManager.getConnection(URL, USER, PASS);){

                     PreparedStatement ps = con.prepareStatement("select * from usuarios where nombre=?");
                     
                     ps.setString(1,nombre);
                     
              ResultSet rs = ps.executeQuery();
              
              if(rs.next()){
                  existe = true;
              }
    }   
            catch (SQLException ex) {
            Logger.getLogger(IODatos.class.getName()).log(Level.SEVERE, null, ex);
            
            }
        return existe;
                 
}
    public static DefaultTableModel rellenartablabbdd(){
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("nombre");
        tabla.addColumn("contraseña");
        tabla.addColumn("equipo");
        tabla.addColumn("edad");
        tabla.addColumn("foto_perfil");
        
        String sentencia = "select * from usuarios";
        
        try (Connection con= DriverManager.getConnection(URL, USER, PASS);){
            
            PreparedStatement ps = con.prepareStatement(sentencia);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Object[] fila = {rs.getString("nombre"),rs.getString("contra"),rs.getString("equipo"),rs.getInt("edad"),rs.getString("ruta_foto")};
                tabla.addRow(fila);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(IODatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }
}