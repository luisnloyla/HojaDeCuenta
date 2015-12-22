package congregacion;
import ejecutar.Coneccion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Transaccion {
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Coneccion  c = new Coneccion();
        Connection con = c.getCon();
        Statement stmt = con.createStatement();
        ResultSet rs=null;
        try {
            con.setAutoCommit(false) ;
//            stmt.executeUpdate("CREATE TABLE Venta(nombreBar VARCHAR(40),marcaCerveza VARCHAR(40), precio REAL)") ;
//            stmt.executeUpdate("INSERT INTO Venta VALUES " +
//            "('Bar Ato', 'Mellir', 1200)") ;
//            stmt.executeUpdate("INSERT INTO Venta (nombreBar, marcaCerveza, precio) VALUES ('JUANITO RAMIREZ', 'JR MARCO POLO', 608)");
//            stmt.executeUpdate("INSERT INTO Venta (nombreBar, marcaCerveza, precio) VALUES ('ZABULON', 'AV. LUNA PIZARRO', 724)");
//            stmt.executeUpdate("INSERT INTO Venta (nombreBar, marcaCerveza, precio) VALUES ('ROLANDO MARTINES ALVARES', 'JR TOMAS MARZANO', 754)");
//            stmt.executeUpdate("INSERT INTO Venta (nombreBar, marcaCerveza, precio) VALUES ('MYCOL GUERRA COSME', 'AV. RICARDO MARIATEGUI', 807)");
//            stmt.executeUpdate("INSERT INTO Venta (nombreBar, marcaCerveza, precio) VALUES ('JUANITO RAMIREZ', 'JR MARCO POLO', 608)");
//            stmt.executeUpdate("INSERT INTO Venta (nombreBar, marcaCerveza, precio) VALUES ('ZABULON', 'AV. LUNA PIZARRO', 724)");
//            stmt.executeUpdate("INSERT INTO Venta (nombreBar, marcaCerveza, precio) VALUES ('ROLANDO MARTINES ALVARES', 'JR TOMAS MARZANO', 754)");
//            stmt.executeUpdate("INSERT INTO Venta (nombreBar, marcaCerveza, precio) VALUES ('MYCOL GUERRA COSME', 'AV. RICARDO MARIATEGUI', 807)");
             rs=stmt.executeQuery("SELECT * FROM Venta");
                while (rs.next()) {
                    System.out.println(""+rs.getString(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
                }
//            rs=stmt.executeQuery("SELECT*FROM USUARIO");
            
            con.commit() ;
            con.setAutoCommit(true) ;
        }catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage()) ;
            con.rollback();
            con.setAutoCommit(true);
        }
    }
    
}
