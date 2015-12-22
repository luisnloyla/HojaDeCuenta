package CongregacionBD;
import CongregacionBE.CcorrienteBE;
import ejecutar.Coneccion;
import java.sql.*;
public class p_Ccorriente_del {
    private int Accion;
    private int Id_Ccorriente;
    private int Id_Mensual;
    private Date Fecha;
    private int Id_Concepto;
    private double Cuentan;
    private double Importe;
    private String Flagactivo;
    private int ReturnVal;

    public p_Ccorriente_del(Coneccion strCn,CcorrienteBE objCcorrienteBE) {
        this.Accion = objCcorrienteBE.getAccion();
        this.Id_Ccorriente = objCcorrienteBE.getId_Ccorriente();
        this.Id_Mensual = objCcorrienteBE.getId_Mensual();
        this.Fecha = objCcorrienteBE.getFecha();
        this.Id_Concepto = objCcorrienteBE.getId_Concepto();
        this.Cuentan = objCcorrienteBE.getCuentan();
        this.Importe = objCcorrienteBE.getImporte();
        this.Flagactivo = objCcorrienteBE.getFlagactivo();
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
                st.executeUpdate("DELETE FROM USUARIO WHERE ID_USUARIO = "+this.Id_Ccorriente);
                st.close();
              this.ReturnVal=0;
            }
        } catch (Exception e) {
            System.out.println(e);
            this.ReturnVal=-1;
        } 
    }
    public p_Ccorriente_del(Connection strCn,CcorrienteBE objCcorrienteBE) {
        this.Accion = objCcorrienteBE.getAccion();
        this.Id_Ccorriente = objCcorrienteBE.getId_Ccorriente();
        this.Id_Mensual = objCcorrienteBE.getId_Mensual();
        this.Fecha = objCcorrienteBE.getFecha();
        this.Id_Concepto = objCcorrienteBE.getId_Concepto();
        this.Cuentan = objCcorrienteBE.getCuentan();
        this.Importe = objCcorrienteBE.getImporte();
        this.Flagactivo = objCcorrienteBE.getFlagactivo();

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
                st.executeUpdate("DELETE FROM USUARIO WHERE ID_USUARIO = "+this.Id_Ccorriente);
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
