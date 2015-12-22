/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejecutar;
import conexion.conex;
import java.sql.*;
/**
 *
 * @author Loyola
 */
public class Coneccion {
    private static Connection con;
    private Statement st=null;
    
    public Coneccion() throws SQLException {
        conex cn=new conex().getInstancia();
        con=cn.abrir();
        st = con.createStatement();
        
    }
    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection aCon) {
        con = aCon;
    }
    
  
    

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }
  
}
