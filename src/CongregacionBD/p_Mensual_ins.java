package CongregacionBD;
import CongregacionBE.MensualBE;
import ejecutar.Coneccion;
import java.util.Date;
import java.sql.*;
public class p_Mensual_ins {
    private int Accion;
    private int Id_Mensual ;
    private Date Fecha;

    private float Saldoanteriorr;
    private float Entradar;
    private float Salidar;
    private float Saldorestanter;

    private float Saldoanteriorcc;
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

    public p_Mensual_ins(Coneccion strCn,MensualBE objMensualBE) throws SQLException {
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
        PreparedStatement pstLista = null;
        try {
            con.setAutoCommit(false);
            if (this.Accion == 1){
                pstLista=con.prepareStatement("SELECT max(ID_MENSUAL) FROM MENSUAL");
                rs=pstLista.executeQuery();
                int idValidAnterior=0;
                while (rs.next()) {
                    idValidAnterior=rs.getInt(1);
                }
                pstOperacion=con.prepareStatement("INSERT INTO MENSUAL  (" +
                "FECHA" +",SALDOANTERIORR" +",ENTRADAR" +",SALIDAR" +
                ",SALDORESTANTER" +",SALDOANTERIORCC " +",ENTRADACC" +
                ",SALIDACC " +",SALDORESTANTECC " +",SALDOANTERIORO " +
                ",ENTRADAO " +",SALIDAO " +",SALDORESTANTEO" +
                ",TOTFONDMES " +",TOTACTUAL " +",TOTPLAZO " +
                ",GUARDADO "+",ESTABLESER" +",FLAGACTIVO " + ") VALUES(? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?,?)");
                pstOperacion.setString(1, ""+this.Fecha.getYear()+"-"+(this.Fecha.getMonth()+1)+"-"+this.Fecha.getDate());
                
                pstOperacion.setFloat(2, this.Saldoanteriorr);
                pstOperacion.setFloat(3, this.Entradar);
                pstOperacion.setFloat(4, this.Salidar);
                pstOperacion.setFloat(5, this.Saldorestanter);
                
                pstOperacion.setFloat(6, this.Saldoanteriorcc);
                pstOperacion.setFloat(7, this.Entradacc);
                pstOperacion.setFloat(8, this.Salidacc);
                pstOperacion.setFloat(9, this.Saldorestantecc);
                
                pstOperacion.setFloat(10, this.Saldoanterioro);
                pstOperacion.setFloat(11, this.Entradao);
                pstOperacion.setFloat(12, this.Salidao);
                pstOperacion.setFloat(13, this.Saldorestanteo);
                
                pstOperacion.setFloat(14, this.Totfondmes);
                pstOperacion.setFloat(15, this.Totactual);
                pstOperacion.setFloat(16, this.Totplazo);
                
                pstOperacion.setInt(17, this.Guardado);
                pstOperacion.setInt(18, this.Estableser);
                pstOperacion.setString(19, this.Flagactivo);
                
                pstOperacion.executeUpdate();
                
                pstLista=con.prepareStatement("SELECT max(ID_MENSUAL) FROM MENSUAL");
                rs=pstLista.executeQuery();
                int idActual=0;
                while (rs.next()) {
                    idActual=rs.getInt(1);
                }
                this.ReturnVal=-1;
                if (idValidAnterior<idActual) {
                    this.ReturnVal=idActual;
                }
            }
            if (this.Accion == 2){//CREACION DE UNA TABLA FISICA EN UNA BASE DE DATOS
                pstOperacion=con.prepareStatement("CREATE TABLE MENSUAL(" +
                "ID_MENSUAL INT NOT NULL PRIMARY KEY  GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)" +
                ",FECHA DATE" +
                ",SALDOANTERIORR FLOAT" +
                ",ENTRADAR FLOAT" +
                ",SALIDAR FLOAT" +
                ",SALDORESTANTER FLOAT" +
                ",SALDOANTERIORCC FLOAT" +
                ",ENTRADACC FLOAT" +
                ",SALIDACC FLOAT" +
                ",SALDORESTANTECC FLOAT" +
                ",SALDOANTERIORO FLOAT" +
                ",ENTRADAO FLOAT" +
                ",SALIDAO FLOAT" +
                ",SALDORESTANTEO FLOAT" +
                ",TOTFONDMES FLOAT" +
                ",TOTACTUAL FLOAT" +
                ",TOTPLAZO FLOAT" +
                ",GUARDADO INT" +
                ",ESTABLESER INT" +
                ",FLAGACTIVO CHAR(10)" +
                ")");
                pstOperacion.executeUpdate();
                this.ReturnVal=0;
            }
            if (this.Accion == 3){//ELIMINACION DE UNA TABLA FISICA EN UNA BASE DE DATOS
              pstOperacion=con.prepareStatement("DROP TABLE Mensual");
              pstOperacion.executeUpdate();
              this.ReturnVal=0;
            }
            con.commit();
            con.setAutoCommit(true);
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
    public p_Mensual_ins(Connection strCn,MensualBE objMensualBE) {
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
}