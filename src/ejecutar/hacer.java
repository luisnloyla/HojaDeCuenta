package ejecutar;
import conexion.conex;
import java.sql.*;
public class hacer {
     private  int avi=0;
     protected  static Connection cone;
     public void intro(String instruccion){
        conex cn=new conex().getInstancia();
        Statement st=null;
         avi=0;
        try{
            cone=cn.abrir();
            st = cone.createStatement();
            st.executeUpdate(instruccion);
            st.close();avi=1;
        }catch(Exception e){System.out.println(" aqui"+e);
        avi=0;}                
    }
    public ResultSet listar(String instruccion){
       
        conex cn=new conex().getInstancia();
        Statement st=null;
        ResultSet rs=null; 
        try{
            cone=cn.abrir();
            st=cone.createStatement();
            rs=st.executeQuery(instruccion);avi=1;
            
        }catch(Exception e){avi=0;}
        return rs;
    }
    public int soplon(){
        return avi;
    }
    
}
