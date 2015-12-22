package CongregacionBD;
import CongregacionBE.UsuarioBE;
import ejecutar.Coneccion;
import java.sql.*;
public class p_Usuario_del {
    private int Accion;
    private int Id_Usuario;
    private String Nombre;
    private String Password;
    private int ReturnVal;
    public p_Usuario_del(Coneccion strCn,UsuarioBE objUsuarioBE) {
        this.Accion     = objUsuarioBE.getAccion();
        this.Id_Usuario = objUsuarioBE.getId_Usuario();
        this.Nombre     = objUsuarioBE.getNombre();
        this.Password   = objUsuarioBE.getPassword();
        Statement st=null;
        try {
            st = strCn.getSt();            
            if (this.Accion == 1){
                this.ReturnVal=-1;
//              st.executeUpdate("CREATE TABLE USUARIO(Id_Usuario INT PRIMARY KEY,Nombre VARCHAR(100),Password VARCHAR(100))");
                st.executeUpdate("DELETE FROM USUARIO");
//                for (int i=50;i<500;i++){
////                    Random a = new Random();
//                       st.executeUpdate("INSERT INTO USUARIO (Id_Usuario ,Nombre ,Password )VALUES("+ i
//                        + ",'"+ "marandool" +"'"
//                        + ",'"+"fiojriof878" +"'"
//                        + ")");
//              
//               }
                
                st.close(); 
              this.ReturnVal=0;
            }
            if (this.Accion == 2){
                this.ReturnVal=-1;
                st.executeUpdate("DELETE FROM USUARIO WHERE ID_USUARIO = "+this.Id_Usuario);
                st.close();
              this.ReturnVal=0;
            }
        } catch (Exception e) {
            System.out.println(e);
            this.ReturnVal=-1;
        }        

    }
    public p_Usuario_del(Connection strCn,UsuarioBE objUsuarioBE) {
        this.Accion     = objUsuarioBE.getAccion();
        this.Id_Usuario = objUsuarioBE.getId_Usuario();
        this.Nombre     = objUsuarioBE.getNombre();
        this.Password   = objUsuarioBE.getPassword();
        Statement st=null;
        try {
            st = strCn.createStatement();
            if (this.Accion == 1){
                this.ReturnVal=-1;
                st.executeUpdate("DELETE FROM USUARIO");
              this.ReturnVal=0;
            }
            if (this.Accion == 2){
                this.ReturnVal=-1;
                st.executeUpdate("DELETE FROM USUARIO WHERE ID_USUARIO = "+this.Id_Usuario);
              this.ReturnVal=0;
            }
        } catch (Exception e) {
            System.out.println(e);
            this.ReturnVal=-1;
        }
    }
    public int getReturVal() {
        return ReturnVal;
    }

    public void setReturVal(int ReturVal) {
        this.ReturnVal = ReturVal;
    }    
}
