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
public class p_Oblifinmes_upd {
    private int Accion;
    private int Id_Oblifinmes;
    private int Id_Mensual ;
    private String Obligacion ;
    private float Importe;
    private String Actual_Plazo;
    private String FlagActivo ;
    private int ReturnVal ;
    
    public p_Oblifinmes_upd(Coneccion strCn,OblifinmesBE objOblifinmesBE) throws SQLException {
        this.Accion = objOblifinmesBE.getAccion();
        this.Id_Oblifinmes = objOblifinmesBE.getId_Oblifinmes();
        this.Id_Mensual = objOblifinmesBE.getId_Mensual();
        this.Obligacion = objOblifinmesBE.getObligacion();
        this.Importe = objOblifinmesBE.getImporte();
        this.Actual_Plazo = objOblifinmesBE.getActual_Plazo();
        this.FlagActivo = objOblifinmesBE.getFlagActivo();
        this.ReturnVal = objOblifinmesBE.getReturnVal();
        Connection con = strCn.getCon();
        ResultSet rs=null;
        PreparedStatement pstOperacion = null;
        PreparedStatement pstUpdFinMes = null;
//        PreparedStatement pstLista = null;
        try {
            con.setAutoCommit(false);
            if (this.Accion == 1){ //ACTUALIZACION DE DEGISTROS DE UNA TABLA
                pstOperacion=con.prepareStatement("UPDATE Oblifinmes SET " 
                + " Obligacion = ?"
                + ",Importe    = ?"
                +"WHERE ID_Oblifinmes = ?");
//                pstOperacion.setDate(1, this.Fecha); nunca se edita por cuestiones delk programa
                
                pstOperacion.setString(1, this.Obligacion);
                pstOperacion.setFloat(2, this.Importe);
                pstOperacion.setInt(3, this.Id_Oblifinmes);
                
                pstOperacion.executeUpdate();
                this.ReturnVal=0;
            }
            if (this.Accion == 2){//ELIMINACION DE REGISTROEN FLAGACTIVO = 0
                pstOperacion=con.prepareStatement("UPDATE Oblifinmes SET FLAGACTIVO = '0' WHERE ID_Oblifinmes = ?");
                pstOperacion.setInt(1, this.Id_Oblifinmes);
                pstOperacion.executeUpdate();
                this.ReturnVal=0;
            }//ya existe el 3
            if (this.Accion == 4){ //ACTUALIZACION DE DEGISTROS DE UNA TABLA
                pstOperacion=con.prepareStatement("UPDATE Oblifinmes SET " 
                + " Obligacion = ?"
                + ",Importe    = ?"
                +"WHERE ID_Oblifinmes = ?");
                
                pstOperacion.setString(1, this.Obligacion);
                pstOperacion.setFloat(2, this.Importe);
                pstOperacion.setInt(3, this.Id_Oblifinmes);
                                                
                this.ReturnVal=-1;
                if (pstOperacion.executeUpdate()>0) {
                    this.ReturnVal=0;
                    pstUpdFinMes = con.prepareStatement(
                    "UPDATE MENSUAL SET "+
                    "TOTACTUAL = (SELECT  "
                            +"CASE WHEN SUM(IMPORTE) IS NULL THEN 0 ELSE SUM(IMPORTE) END "
                            + "FROM Oblifinmes WHERE Id_Mensual = "
                            + "(SELECT Id_Mensual FROM Oblifinmes WHERE ID_Oblifinmes = ? ) "
                            + "AND FlagActivo = '1' AND Actual_Plazo = '0') " +
                    ",TOTPLAZO = (SELECT "
                            +"CASE WHEN SUM(IMPORTE) IS NULL THEN 0 ELSE SUM(IMPORTE) END "
                            + "FROM Oblifinmes WHERE Id_Mensual = "
                            + "(SELECT Id_Mensual FROM Oblifinmes WHERE ID_Oblifinmes = ? ) "
                            + "AND FlagActivo = '1' AND Actual_Plazo = '1') " +
                    "WHERE ID_MENSUAL =  (SELECT Id_Mensual FROM Oblifinmes WHERE ID_Oblifinmes = ? )");
                    pstUpdFinMes.setInt(1, this.Id_Oblifinmes);
                    pstUpdFinMes.setInt(2, this.Id_Oblifinmes);
                    pstUpdFinMes.setInt(3, this.Id_Oblifinmes);                    
                    
                    if (pstUpdFinMes.executeUpdate()==0) {
                        throw new UnsupportedOperationException("No se inserto");
                    }
                }
            }
            con.commit();
            con.setAutoCommit(true);
            pstOperacion.close();
            if (pstUpdFinMes != null) pstUpdFinMes.close();
//            pstLista.close();
        } catch (Exception e) {
            con.rollback();
            con.setAutoCommit(true);
            pstOperacion.close();
            if (pstUpdFinMes != null) pstUpdFinMes.close();
//            pstLista.close();
            System.out.println(e);
            this.ReturnVal=-1;
        }
    }
    public p_Oblifinmes_upd(Connection con,OblifinmesBE objOblifinmesBE) throws SQLException {
        this.Accion = objOblifinmesBE.getAccion();
        this.Id_Oblifinmes = objOblifinmesBE.getId_Oblifinmes();
        this.Id_Mensual = objOblifinmesBE.getId_Mensual();
        this.Obligacion = objOblifinmesBE.getObligacion();
        this.Importe = objOblifinmesBE.getImporte();
        this.Actual_Plazo = objOblifinmesBE.getActual_Plazo();
        this.FlagActivo = objOblifinmesBE.getFlagActivo();
        this.ReturnVal = objOblifinmesBE.getReturnVal();                
        ResultSet rs=null;
        PreparedStatement pstOperacion = null;
        try {
            con.setAutoCommit(false);
            if (this.Accion == 3){ //ACTUALIZACION DE DEGISTROS DE UNA TABLA
                pstOperacion=con.prepareStatement("UPDATE Oblifinmes SET " 
                + " Obligacion = ?"
                + ",Importe    = ?"
                +"WHERE ID_Oblifinmes = ?");
//                pstOperacion.setDate(1, this.Fecha); nunca se edita por cuestiones delk programa
                
                pstOperacion.setString(1, this.Obligacion);
                pstOperacion.setFloat(2, this.Importe);
                pstOperacion.setInt(3, this.Id_Oblifinmes);
                
                pstOperacion.executeUpdate();
                this.ReturnVal=0;
            }//ya existe 4
            pstOperacion.close();
        } catch (Exception e) {
            pstOperacion.close();
            System.out.println(e);
            this.ReturnVal=-1;
        }
    }

    public int getReturnVal() {
        return ReturnVal;
    }

    public void setReturnVal(int ReturnVal) {
        this.ReturnVal = ReturnVal;
    }
    
}
