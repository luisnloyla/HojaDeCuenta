package CongregacionBD;
import CongregacionBE.CcorrienteBE;
import CongregacionBE.UsuarioBE;
import ejecutar.Coneccion;
import java.sql.*;
public class p_Ccorriente_ins {
    private int Accion;
    private int Id_Ccorriente;
    private int Id_Mensual;
    private Date Fecha;
    private int Id_Concepto;
    private double Cuentan;
    private double Importe;
    private String Flagactivo;
    private int ReturnVal;
  
    public p_Ccorriente_ins(Coneccion strCn,CcorrienteBE objCcorrienteBE) {
        this.Accion = objCcorrienteBE.getAccion();
        this.Id_Ccorriente = objCcorrienteBE.getId_Ccorriente();
        this.Id_Mensual = objCcorrienteBE.getId_Mensual();
        this.Fecha = objCcorrienteBE.getFecha();
        this.Id_Concepto = objCcorrienteBE.getId_Concepto();
        this.Cuentan = objCcorrienteBE.getCuentan();
        this.Importe = objCcorrienteBE.getImporte();
        this.Flagactivo = objCcorrienteBE.getFlagactivo();

    }
    public p_Ccorriente_ins(Connection strCn,CcorrienteBE objCcorrienteBE) {
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
