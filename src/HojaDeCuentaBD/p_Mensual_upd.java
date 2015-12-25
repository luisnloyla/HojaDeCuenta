package HojaDeCuentaBD;
import HojaDeCuentaBE.MensualBE;
import ejecutar.Coneccion;
import java.util.Date;
import java.sql.*;
public class p_Mensual_upd {
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
    private int Estableser ;
    private String Flagactivo ;
    
    private int ReturnVal ;

    public p_Mensual_upd(Coneccion strCn,MensualBE objMensualBE) throws SQLException {
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
        PreparedStatement pstOperacion = null;
//        PreparedStatement pstLista = null;
        try {
            con.setAutoCommit(false);
            if (this.Accion == 1){ //ACTUALIZACION DE DEGISTROS DE UNA TABLA
                pstOperacion=con.prepareStatement("UPDATE MENSUAL SET " +
                "SALDOANTERIORR = ?" +",ENTRADAR = ?" +",SALIDAR = ?" +
                ",SALDORESTANTER = ?" +",SALDOANTERIORCC = ?" +",ENTRADACC = ?" +
                ",SALIDACC = ?" +",SALDORESTANTECC = ?" +",SALDOANTERIORO = ?" +
                ",ENTRADAO = ?" +",SALIDAO = ?" +",SALDORESTANTEO = ?" +
                ",TOTFONDMES = ?" +",TOTACTUAL = ?" +",TOTPLAZO = ?" +
                ",GUARDADO = ?" + "WHERE ID_MENSUAL = ?");
//                pstOperacion.setDate(1, this.Fecha); nunca se edita por cuestiones delk programa
                
                pstOperacion.setFloat(1, this.Saldoanteriorr);
                pstOperacion.setFloat(2, this.Entradar);
                pstOperacion.setFloat(3, this.Salidar);
                pstOperacion.setFloat(4, this.Saldorestanter);
                
                pstOperacion.setFloat(5, this.Saldoanteriorcc);
                pstOperacion.setFloat(6, this.Entradacc);
                pstOperacion.setFloat(7, this.Salidacc);
                pstOperacion.setFloat(8, this.Saldorestantecc);
                
                pstOperacion.setFloat(9, this.Saldoanterioro);
                pstOperacion.setFloat(10, this.Entradao);
                pstOperacion.setFloat(11, this.Salidao);
                pstOperacion.setFloat(12, this.Saldorestanteo);
                
                pstOperacion.setFloat(13, this.Totfondmes);
                pstOperacion.setFloat(14, this.Totactual);
                pstOperacion.setFloat(15, this.Totplazo);
                
                pstOperacion.setInt(16, this.Guardado);
                pstOperacion.setInt(17, this.Id_Mensual);
                
                pstOperacion.executeUpdate();
                this.ReturnVal=0;
            }
            if (this.Accion == 2){//ELIMINACION DE REGISTROEN FLAGACTIVO = 0
                pstOperacion=con.prepareStatement("UPDATE MENSUAL SET FLAGACTIVO = '0' WHERE ID_MENSUAL = ?");
                pstOperacion.setInt(1, this.Id_Mensual);
                pstOperacion.executeUpdate();
                this.ReturnVal=0;
            }
             if (this.Accion == 3){ //ACTUALIZACION DE DEGISTROS DE UNA TABLA
                pstOperacion=con.prepareStatement("UPDATE MENSUAL SET " +
                "SALDOANTERIORR = ?" +",SALDORESTANTER = ?" +
                ",SALDOANTERIORCC = ?" +",SALDORESTANTECC = ?" +
                ",SALDOANTERIORO = ?" +",SALDORESTANTEO = ?" +
                ",TOTFONDMES = ? WHERE ID_MENSUAL = ?");
//                pstOperacion.setDate(1, this.Fecha); nunca se edita por cuestiones delk programa
                
                pstOperacion.setFloat(1, this.Saldoanteriorr);
                pstOperacion.setFloat(2, this.Saldorestanter);
                
                pstOperacion.setFloat(3, this.Saldoanteriorcc);
                pstOperacion.setFloat(4, this.Saldorestantecc);
                
                pstOperacion.setFloat(5, this.Saldoanterioro);
                pstOperacion.setFloat(6, this.Saldorestanteo);
                
                pstOperacion.setFloat(7, this.Totfondmes);
                pstOperacion.setInt(8, this.Id_Mensual);
                
                pstOperacion.executeUpdate();
                this.ReturnVal=0;
            }
            if (this.Accion == 4){//FINIQUITAR
                pstOperacion=con.prepareStatement("UPDATE MENSUAL SET Guardado = 1  WHERE ID_MENSUAL = ?");
                pstOperacion.setInt(1, this.Id_Mensual);
                pstOperacion.executeUpdate();
                this.ReturnVal=0;
            }
            if (this.Accion == 5){//FINIQUITAR
                pstOperacion=con.prepareStatement("UPDATE MENSUAL SET Estableser = ?  WHERE ID_MENSUAL = ?");
                pstOperacion.setInt(1, this.Estableser);
                pstOperacion.setInt(2, this.Id_Mensual);
                pstOperacion.executeUpdate();
                this.ReturnVal=0;
            }
            con.commit();
            con.setAutoCommit(true);
            pstOperacion.close();
//            pstLista.close();
        } catch (Exception e) {
            con.rollback();
            con.setAutoCommit(true);
            pstOperacion.close();
//            pstLista.close();
            System.out.println(e);
            this.ReturnVal=-1;
        }
    }
    public p_Mensual_upd(Connection strCn,MensualBE objMensualBE) {
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