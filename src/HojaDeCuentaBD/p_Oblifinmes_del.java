/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuentaBD;

import HojaDeCuentaBE.OblifinmesBE;
import ejecutar.Coneccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Loyola
 */
public class p_Oblifinmes_del {
    private int Accion;
    private int Id_Oblifinmes;
    private int Id_Mensual ;
    private String Obligacion ;
    private float Importe;
    private String Actual_Plazo;
    private String FlagActivo ;
    private int ReturnVal ;
    
    public p_Oblifinmes_del(Coneccion strCn,OblifinmesBE objOblifinmesBE) throws SQLException {
        this.Accion = objOblifinmesBE.getAccion();
        this.Id_Oblifinmes = objOblifinmesBE.getId_Oblifinmes();
        this.Id_Mensual = objOblifinmesBE.getId_Mensual();
        this.Obligacion = objOblifinmesBE.getObligacion();
        this.Importe = objOblifinmesBE.getImporte();
        this.Actual_Plazo = objOblifinmesBE.getActual_Plazo();
        this.FlagActivo = objOblifinmesBE.getFlagActivo();
        this.ReturnVal = objOblifinmesBE.getReturnVal();
        Connection con = strCn.getCon();
//        Statement st=null;
        ResultSet rs=null;
        
        PreparedStatement pstOperacion = null;
        PreparedStatement pstUpdFinMes = null;
//        PreparedStatement pstLista = null;
        try {
            con.setAutoCommit(false);
//            st = con.createStatement();            
            if (this.Accion == 1){
                pstOperacion=con.prepareStatement("DELETE FROM Oblifinmes WHERE ID_Oblifinmes = ?");
                pstOperacion.setInt(1, this.Id_Oblifinmes);
                this.ReturnVal= 0;
                if(pstOperacion.executeUpdate()==0) this.ReturnVal= -1;                
            }
            if (this.Accion == 2){               //DESTRUCCION TOTAL DE DATOS
                pstOperacion=con.prepareStatement("DELETE FROM Oblifinmes");
                pstOperacion.executeUpdate();
                this.ReturnVal=0;
                if(pstOperacion.executeUpdate()==0) this.ReturnVal= -1;

            }
            if (this.Accion == 3){//erliminacion y actualizacion
                pstOperacion=con.prepareStatement("DELETE FROM Oblifinmes WHERE ID_Oblifinmes = ?");
                pstOperacion.setInt(1, this.Id_Oblifinmes);
                this.ReturnVal=-1;
                if(pstOperacion.executeUpdate() > 0){
                    this.ReturnVal= 0;
                    pstUpdFinMes = con.prepareStatement(
                    "UPDATE MENSUAL SET "+
                    "TOTACTUAL = (SELECT  "
                            +"CASE WHEN SUM(IMPORTE) IS NULL THEN 0 ELSE SUM(IMPORTE) END "
                            + "FROM Oblifinmes WHERE Id_Mensual = ? "
                            + "AND FlagActivo = '1' AND Actual_Plazo = '0') " +
                    ",TOTPLAZO = (SELECT "
                            +"CASE WHEN SUM(IMPORTE) IS NULL THEN 0 ELSE SUM(IMPORTE) END "
                            + "FROM Oblifinmes WHERE Id_Mensual = ? "
                            + "AND FlagActivo = '1' AND Actual_Plazo = '1') " +
                    "WHERE ID_MENSUAL =  ?");
                    pstUpdFinMes.setInt(1, this.Id_Mensual);
                    pstUpdFinMes.setInt(2, this.Id_Mensual);
                    pstUpdFinMes.setInt(3, this.Id_Mensual);
                    if (pstUpdFinMes.executeUpdate()==0) {
                        throw new UnsupportedOperationException("No se actualizo");
                    }
                }else{throw new UnsupportedOperationException("No se elimino");}
            }
            con.commit();
            con.setAutoCommit(true);
            pstOperacion.close();
            if (pstUpdFinMes != null) pstUpdFinMes.close();
        } catch (Exception e) {
            con.rollback();
            con.setAutoCommit(true);
            pstOperacion.close();
            if (pstUpdFinMes != null) pstUpdFinMes.close();
            System.out.println(e);
            this.ReturnVal=-1;
        }
    }
    public p_Oblifinmes_del(Connection strCn,OblifinmesBE objOblifinmesBE) {
        this.Accion = objOblifinmesBE.getAccion();
        this.Id_Oblifinmes = objOblifinmesBE.getId_Oblifinmes();
        this.Id_Mensual = objOblifinmesBE.getId_Mensual();
        this.Obligacion = objOblifinmesBE.getObligacion();
        this.Importe = objOblifinmesBE.getImporte();
        this.Actual_Plazo = objOblifinmesBE.getActual_Plazo();
        this.FlagActivo = objOblifinmesBE.getFlagActivo();
        this.ReturnVal = objOblifinmesBE.getReturnVal();        
    }

    public int getReturnVal() {
        return ReturnVal;
    }

    public void setReturnVal(int ReturnVal) {
        this.ReturnVal = ReturnVal;
    }
    
}
