package CongregacionBD;
import CongregacionBE.MensualBE;
import ejecutar.Coneccion;
import java.util.Date;
import java.sql.*;
public class p_Mensual_del {
    private int Accion;
    private int Id_Mensual ;
    private Date Fecha;

    private float Saldoanteriorr ;
    private float Entradar ;
    private float Salidar ;
    private float Saldorestanter ;

    private float Saldoanteriorcc ;
    private float Entradacc ;
    private float Salidacc ;
    private float Saldorestantecc ;
    
    private float Saldoanterioro ;
    private float Entradao ;
    private float Salidao ;
    private float Saldorestanteo ;

    private float Totfondmes ;
    private float Totactual ;
    private float Totplazo ;
    
    private float Guardado ;
    private String Flagactivo ;
    private int Estableser;
    private int ReturnVal ;
    

    public p_Mensual_del(Coneccion strCn,MensualBE objMensualBE) throws SQLException {
        this.Accion = objMensualBE.getAccion();
        this.Id_Mensual = objMensualBE.getId_Mensual();
        this.Fecha = objMensualBE.getFecha();        
        this.Saldoanteriorr = objMensualBE.getSaldoanteriorr();
        this.Entradar = objMensualBE.getEntradar();
        this.Salidar = objMensualBE.getSalidar();
        this.Saldorestanter = objMensualBE.getSaldorestanter();
        this.Saldoanteriorcc = objMensualBE.getSaldoanteriorcc();
        this.Entradacc = objMensualBE.getEntradacc();
        this.Salidacc = objMensualBE.getSalidacc();
        this.Saldorestantecc = objMensualBE.getSaldorestantecc();
        this.Saldoanterioro = objMensualBE.getSaldoanterioro();
        this.Entradao = objMensualBE.getEntradao();
        this.Salidao = objMensualBE.getSalidao();
        this.Saldorestanteo = objMensualBE.getSaldorestanteo();
        this.Totfondmes = objMensualBE.getTotfondmes();
        this.Totactual = objMensualBE.getTotactual();
        this.Totplazo = objMensualBE.getTotplazo();
        this.Guardado = objMensualBE.getGuardado();
        this.Estableser = objMensualBE.getEstableser();
        this.Flagactivo = objMensualBE.getFlagactivo();
        Connection con = strCn.getCon();
//        Statement st=null;
        ResultSet rs=null;
        
        PreparedStatement pstOperacion = null;
        PreparedStatement pstLista = null;
        try {
            con.setAutoCommit(false);
//            st = con.createStatement();            
            if (this.Accion == 1){
                pstOperacion=con.prepareStatement("DELETE FROM MENSUAL WHERE ID_MENSUAL = ?");
                pstOperacion.setInt(1, this.Id_Mensual);
                pstOperacion.executeUpdate();
//                st.executeUpdate("DELETE FROM PARAMETRO WHERE ID_PARAMETRO = "+this.Id_Parametro);
                this.ReturnVal= 0;
//                rs=st.executeQuery("SELECT * FROM Parametro WHERE ID_PARAMETRO = " + this.Id_Parametro);
                pstLista=con.prepareStatement("SELECT * FROM MENSUAL WHERE ID_MENSUAL = ?");
                pstLista.setInt(1, this.Id_Mensual);
                rs = pstLista.executeQuery();
                while (rs.next()) {
                    this.ReturnVal= -1;
                }
            }
            if (this.Accion == 2){               //DESTRUCCION TOTAL DE DATOS
                pstOperacion=con.prepareStatement("DELETE FROM MENSUAL");
                pstOperacion.executeUpdate();
////                st.executeUpdate("DELETE FROM PARAMETRO");
                this.ReturnVal=0;
                pstLista=con.prepareStatement("SELECT * FROM MENSUAL WHERE Id_MENSUAL = ?");
                rs = pstLista.executeQuery();
//                rs=st.executeQuery("SELECT * FROM Parametro");
                while (rs.next()) {
                    this.ReturnVal=-1;
                }
            }
            con.commit();
            con.setAutoCommit(true);
//            st.close();
            pstOperacion.close();
            pstLista.close();
        } catch (Exception e) {
            con.rollback();
            con.setAutoCommit(true);
            pstOperacion.close();
            pstLista.close();
            System.out.println(e);
            this.ReturnVal=-1;
        }
    }
    public p_Mensual_del(Connection strCn,MensualBE objMensualBE) {
        this.Accion = objMensualBE.getAccion();
        this.Id_Mensual = objMensualBE.getId_Mensual();
        this.Fecha = objMensualBE.getFecha();        
        this.Saldoanteriorr = objMensualBE.getSaldoanteriorr();
        this.Entradar = objMensualBE.getEntradar();
        this.Salidar = objMensualBE.getSalidar();
        this.Saldorestanter = objMensualBE.getSaldorestanter();
        this.Saldoanteriorcc = objMensualBE.getSaldoanteriorcc();
        this.Entradacc = objMensualBE.getEntradacc();
        this.Salidacc = objMensualBE.getSalidacc();
        this.Saldorestantecc = objMensualBE.getSaldorestantecc();
        this.Saldoanterioro = objMensualBE.getSaldoanterioro();
        this.Entradao = objMensualBE.getEntradao();
        this.Salidao = objMensualBE.getSalidao();
        this.Saldorestanteo = objMensualBE.getSaldorestanteo();
        this.Totfondmes = objMensualBE.getTotfondmes();
        this.Totactual = objMensualBE.getTotactual();
        this.Totplazo = objMensualBE.getTotplazo();
        this.Guardado = objMensualBE.getGuardado();
        this.Flagactivo = objMensualBE.getFlagactivo();
//        this.ReturnVal = objMensualBE.getReturnVal();
    }
    public int getReturVal() {
        return ReturnVal;
    }

    public void setReturVal(int ReturVal) {
        this.ReturnVal = ReturVal;
    }    
}

