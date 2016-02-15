package ejecutar;
import conexion.conex;
import java.sql.*;

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
