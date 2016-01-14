package HojaDeCuentaBD;
import HojaDeCuentaBE.MensualBE;
import ejecutar.Coneccion;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class p_Mensual_sel {
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
    
    private int Guardado ;
    private String Flagactivo ;
    private int Estableser ;
    private int ReturnVal ;
    private List<MensualBE> aMensualBE = new ArrayList<>();     
    private MensualBE uMensualBE = null;

    public p_Mensual_sel(Coneccion strCn,MensualBE objMensualBE) throws SQLException {
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
        ResultSet rs=null;
//        PreparedStatement pstOperacion = null;
        PreparedStatement pstLista = null;
        try {
            con.setAutoCommit(false);
            if (this.Accion == 1){
                pstLista=con.prepareStatement("SELECT * FROM MENSUAL WHERE FLAGACTIVO = '1'");
                rs=pstLista.executeQuery();
                while (rs.next()) {
                    MensualBE objMensualBElista = new MensualBE(0, rs.getInt(1), rs.getDate(2), rs.getFloat(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6), rs.getFloat(7), rs.getFloat(8), rs.getFloat(9), rs.getFloat(10), rs.getFloat(11), rs.getFloat(12), rs.getFloat(13), rs.getFloat(14), rs.getFloat(15), rs.getFloat(16), rs.getFloat(17), rs.getInt(18), rs.getInt(19),rs.getString(20));
                    aMensualBE.add(objMensualBElista);
                }
                this.ReturnVal=0;
            }
            if (this.Accion == 2){
                pstLista=con.prepareStatement("SELECT * FROM MENSUAL WHERE ID_MENSUAL = ? AND FLAGACTIVO = '1'");
                pstLista.setInt(1, this.Id_Mensual);
                rs=pstLista.executeQuery();
                while (rs.next()) {
                    MensualBE objMensualBElista = new MensualBE(0, rs.getInt(1), rs.getDate(2), rs.getFloat(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6), rs.getFloat(7), rs.getFloat(8), rs.getFloat(9), rs.getFloat(10), rs.getFloat(11), rs.getFloat(12), rs.getFloat(13), rs.getFloat(14), rs.getFloat(15), rs.getFloat(16), rs.getFloat(17), rs.getInt(18), rs.getInt(19),rs.getString(20));
                    aMensualBE.add(objMensualBElista);
                }
                this.ReturnVal=0;
            }
            if (this.Accion == 3){//BUSQUEDA DE FECHA POR AÑO Y MES
                pstLista=con.prepareStatement("SELECT * FROM MENSUAL WHERE MONTH(FECHA) = ? AND YEAR(FECHA) = ? AND FLAGACTIVO = '1'");
                
                pstLista.setInt(1, (this.Fecha.getMonth()+1));//AQUI EL MES
                pstLista.setInt(2, this.Fecha.getYear());//AQUI EL ANIO
                rs=pstLista.executeQuery();
                while (rs.next()) {
                    MensualBE objMensualBElista = new MensualBE(0, rs.getInt(1), rs.getDate(2), rs.getFloat(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6), rs.getFloat(7), rs.getFloat(8), rs.getFloat(9), rs.getFloat(10), rs.getFloat(11), rs.getFloat(12), rs.getFloat(13), rs.getFloat(14), rs.getFloat(15), rs.getFloat(16), rs.getFloat(17), rs.getInt(18), rs.getInt(19),rs.getString(20));
                    aMensualBE.add(objMensualBElista);
                }
                this.ReturnVal=0;
            }
            if (this.Accion == 4){//FECHA MAXIMA
                pstLista=con.prepareStatement("SELECT * FROM MENSUAL WHERE FLAGACTIVO = '1' AND FECHA = (SELECT MAX(FECHA) FROM MENSUAL WHERE FLAGACTIVO = '1')");
                rs=pstLista.executeQuery();
                while (rs.next()) {
                    MensualBE objMensualBElista = new MensualBE(0, rs.getInt(1), rs.getDate(2), rs.getFloat(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6), rs.getFloat(7), rs.getFloat(8), rs.getFloat(9), rs.getFloat(10), rs.getFloat(11), rs.getFloat(12), rs.getFloat(13), rs.getFloat(14), rs.getFloat(15), rs.getFloat(16), rs.getFloat(17), rs.getInt(18), rs.getInt(19),rs.getString(20));
                    aMensualBE.add(objMensualBElista);
                }
                this.ReturnVal=0;
            }
            if (this.Accion == 5){
                pstLista=con.prepareStatement("SELECT * FROM MENSUAL WHERE YEAR (FECHA) = ? AND FLAGACTIVO = '1'");
                pstLista.setInt(1, (this.Id_Mensual));//AQUI EL MES                
                rs=pstLista.executeQuery();
                while (rs.next()) {
                    MensualBE objMensualBElista = new MensualBE(0, rs.getInt(1), rs.getDate(2), rs.getFloat(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6), rs.getFloat(7), rs.getFloat(8), rs.getFloat(9), rs.getFloat(10), rs.getFloat(11), rs.getFloat(12), rs.getFloat(13), rs.getFloat(14), rs.getFloat(15), rs.getFloat(16), rs.getFloat(17), rs.getInt(18), rs.getInt(19),rs.getString(20));
                    aMensualBE.add(objMensualBElista);
                }
                this.ReturnVal=0;
            }
            if (this.Accion == 6){//para totales actuales y largo plazo
                pstLista=con.prepareStatement("SELECT * FROM MENSUAL WHERE ID_MENSUAL = ? AND FLAGACTIVO = '1'");
                pstLista.setInt(1, this.Id_Mensual);
                rs=pstLista.executeQuery();
                int cont= 0;
                while (rs.next()) {
                    cont++;
                    uMensualBE = new MensualBE(0, rs.getInt(1), rs.getDate(2), rs.getFloat(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6), rs.getFloat(7), rs.getFloat(8), rs.getFloat(9), rs.getFloat(10), rs.getFloat(11), rs.getFloat(12), rs.getFloat(13), rs.getFloat(14), rs.getFloat(15), rs.getFloat(16), rs.getFloat(17), rs.getInt(18), rs.getInt(19),rs.getString(20));
                }
                if (cont>1) {
                    throw new UnsupportedOperationException("error mas de un registro");
                }
                this.ReturnVal=0;
            }
            if (this.Accion == 7){//para totales actuales y largo plazo
                pstLista=con.prepareStatement("SELECT * FROM MENSUAL WHERE ESTABLESER = 1 AND FLAGACTIVO = '1'");
                rs=pstLista.executeQuery();
                int cont= 0;
                while (rs.next()) {
                    cont++;
                    uMensualBE = new MensualBE(0, rs.getInt(1), rs.getDate(2), rs.getFloat(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6), rs.getFloat(7), rs.getFloat(8), rs.getFloat(9), rs.getFloat(10), rs.getFloat(11), rs.getFloat(12), rs.getFloat(13), rs.getFloat(14), rs.getFloat(15), rs.getFloat(16), rs.getFloat(17), rs.getInt(18), rs.getInt(19),rs.getString(20));
                }
                if (cont>1) {
                    throw new UnsupportedOperationException("error mas de un registro");
                }
                this.ReturnVal=0;
            }
            con.commit();
            con.setAutoCommit(true);
//            pstOperacion.close();
            pstLista.close();
        } catch (Exception e) {
            con.rollback();
            con.setAutoCommit(true);
//            pstOperacion.close();
            pstLista.close();
            System.out.println(e);
            this.ReturnVal=-1;
        }  
    }
    public p_Mensual_sel(Connection strCn,MensualBE objMensualBE) {
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
//        this.ReturnVal = objMensualBE.getReturnVal();
    }
    public int getReturVal() {
        return ReturnVal;
    }

    public void setReturVal(int ReturVal) {
        this.ReturnVal = ReturVal;
    }

    public List<MensualBE> getaMensualBE() {
        return aMensualBE;
    }

    public MensualBE getuMensualBE() {
        return uMensualBE;
    }

    public void setuMensualBE(MensualBE uMensualBE) {
        this.uMensualBE = uMensualBE;
    }
    
}