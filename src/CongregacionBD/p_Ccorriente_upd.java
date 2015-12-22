package CongregacionBD;
import CongregacionBE.CcorrienteBE;
import CongregacionBE.UsuarioBE;
import ejecutar.Coneccion;
import java.sql.*;
public class p_Ccorriente_upd {
    private int Accion;
    private int Id_Ccorriente;
    private int Id_Mensual;
    private Date Fecha;
    private int Id_Concepto;
    private double Cuentan;
    private double Importe;
    private String Flagactivo;
    private int ReturnVal;

    public p_Ccorriente_upd(int Accion, int Id_Ccorriente, int Id_Mensual, Date Fecha, int Id_Concepto, double Cuentan, double Importe, String Flagactivo) {
        this.Accion = Accion;
        this.Id_Ccorriente = Id_Ccorriente;
        this.Id_Mensual = Id_Mensual;
        this.Fecha = Fecha;
        this.Id_Concepto = Id_Concepto;
        this.Cuentan = Cuentan;
        this.Importe = Importe;
        this.Flagactivo = Flagactivo;
    }
    
    public p_Ccorriente_upd(Coneccion strCn,CcorrienteBE objCcorrienteBE) {
        this.Accion = objCcorrienteBE.getAccion();
        this.Id_Ccorriente = objCcorrienteBE.getId_Ccorriente();
        this.Id_Mensual = objCcorrienteBE.getId_Mensual();
        this.Fecha = objCcorrienteBE.getFecha();
        this.Id_Concepto = objCcorrienteBE.getId_Concepto();
        this.Cuentan = objCcorrienteBE.getCuentan();
        this.Importe = objCcorrienteBE.getImporte();
        this.Flagactivo = objCcorrienteBE.getFlagactivo();

    }
    public p_Ccorriente_upd(Connection strCn,CcorrienteBE objCcorrienteBE) {
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
