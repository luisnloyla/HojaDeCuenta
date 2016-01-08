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
public class p_Oblifinmes_ins {
    private int Accion;
    private int Id_Oblifinmes;
    private int Id_Mensual ;
    private String Obligacion ;
    private float Importe;
    private String Actual_Plazo;
    private String FlagActivo ;
    private int ReturnVal ;
    
    public p_Oblifinmes_ins(Coneccion strCn,OblifinmesBE objOblifinmesBE) throws SQLException {
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
        PreparedStatement pstLista = null;
        try {
            con.setAutoCommit(false);
            if (this.Accion == 1){
                pstLista=con.prepareStatement("SELECT max(ID_Oblifinmes) FROM Oblifinmes");
                rs=pstLista.executeQuery();
                int idValidAnterior=0;
                while (rs.next()) {
                    idValidAnterior=rs.getInt(1);
                }
                pstOperacion=con.prepareStatement("INSERT INTO Oblifinmes"
                        + "(Id_Mensual , Obligacion , Importe , Actual_Plazo, FlagActivo) "
                        + "VALUES(? , ? , ? , ?, ?)");
                pstOperacion.setInt(1, this.Id_Mensual);
                pstOperacion.setString(2, this.Obligacion);
                pstOperacion.setFloat(3, this.Importe);
                pstOperacion.setString(4, this.Actual_Plazo);
                pstOperacion.setString(5, this.FlagActivo);
                
                pstOperacion.executeUpdate();
                
                pstLista=con.prepareStatement("SELECT max(ID_Oblifinmes) FROM Oblifinmes");
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
                pstOperacion=con.prepareStatement("CREATE TABLE Oblifinmes("
                        + " Id_Oblifinmes INT NOT NULL PRIMARY KEY  GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)" 
                        + ", Id_Mensual INT NOT NULL"
                        + ", Obligacion VARCHAR(200)"
                        + ", Importe    FLOAT"
                        + ", Actual_Plazo CHAR(1)"
                        + ", FlagActivo CHAR(1))");
                pstOperacion.executeUpdate();
                this.ReturnVal=0;
            }
            if (this.Accion == 3){//ELIMINACION DE UNA TABLA FISICA EN UNA BASE DE DATOS
              pstOperacion=con.prepareStatement("DROP TABLE Oblifinmes");
              pstOperacion.executeUpdate();
              this.ReturnVal=0;
            }//ya existe el 4
            if (this.Accion == 5){//ACTUAL Y LARGO PLAZO
                pstLista=con.prepareStatement("SELECT max(ID_Oblifinmes) FROM Oblifinmes");
                rs=pstLista.executeQuery();
                int idValidAnterior=0;
                while (rs.next()) {
                    idValidAnterior=rs.getInt(1);
                }
                pstOperacion=con.prepareStatement("INSERT INTO Oblifinmes"
                        + "(Id_Mensual , Obligacion , Importe , Actual_Plazo, FlagActivo) "
                        + "VALUES(? , ? , ? , ?, ?)");
                pstOperacion.setInt(1, this.Id_Mensual);
                pstOperacion.setString(2, this.Obligacion);
                pstOperacion.setFloat(3, this.Importe);
                pstOperacion.setString(4, this.Actual_Plazo);
                pstOperacion.setString(5, this.FlagActivo);
                
                pstOperacion.executeUpdate();
                
                pstLista=con.prepareStatement("SELECT max(ID_Oblifinmes) FROM Oblifinmes");
                rs=pstLista.executeQuery();
                int idActual=0;
                while (rs.next()) {
                    idActual=rs.getInt(1);
                }
                this.ReturnVal=-1;
                if (idValidAnterior<idActual) {
                    this.ReturnVal=idActual;
                    pstUpdFinMes = con.prepareStatement(
                    "UPDATE MENSUAL SET "+
                    "TOTACTUAL = (SELECT "
                            +"CASE WHEN SUM(IMPORTE) IS NULL THEN 0 ELSE SUM(IMPORTE) END "
                            + "FROM Oblifinmes WHERE Id_Mensual = ? AND FlagActivo = '1' AND Actual_Plazo = '0')" +
                    ",TOTPLAZO = (SELECT "
                            +"CASE WHEN SUM(IMPORTE) IS NULL THEN 0 ELSE SUM(IMPORTE) END "
                            + "FROM Oblifinmes WHERE Id_Mensual = ? AND FlagActivo = '1' AND Actual_Plazo = '1')" +
                    "WHERE ID_MENSUAL = ?");
                    pstUpdFinMes.setInt(1, this.Id_Mensual);
                    pstUpdFinMes.setInt(2, this.Id_Mensual);
                    pstUpdFinMes.setInt(3, this.Id_Mensual);
                    if (pstUpdFinMes.executeUpdate()==0) {
                        throw new UnsupportedOperationException("No se inserto");
                    }
                }
                
            }
            con.commit();
            con.setAutoCommit(true);
            pstOperacion.close();
            pstLista.close();
            if (pstUpdFinMes != null) pstUpdFinMes.close();
        } catch (Exception e) {
            con.rollback();
            con.setAutoCommit(true);
            pstOperacion.close();
            pstLista.close();
            if (pstUpdFinMes != null) pstUpdFinMes.close();
            System.out.println(e);
            this.ReturnVal=-1;
        }        
    }
    public p_Oblifinmes_ins(Connection con,OblifinmesBE objOblifinmesBE) throws SQLException {
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
        PreparedStatement pstLista = null;
        try {
            con.setAutoCommit(false);
            if (this.Accion == 4){
                pstLista=con.prepareStatement("SELECT max(ID_Oblifinmes) FROM Oblifinmes");
                rs=pstLista.executeQuery();
                int idValidAnterior=0;
                while (rs.next()) {
                    idValidAnterior=rs.getInt(1);
                }
                pstOperacion=con.prepareStatement("INSERT INTO Oblifinmes"
                        + "(Id_Mensual , Obligacion , Importe , Actual_Plazo, FlagActivo)"
                        + "VALUES(? , ? , ? , ?, ?)");
                pstOperacion.setInt(1, this.Id_Mensual);
                pstOperacion.setString(2, this.Obligacion);
                pstOperacion.setFloat(3, this.Importe);
                pstOperacion.setString(4, this.Actual_Plazo);
                pstOperacion.setString(5, this.FlagActivo);
                
                pstOperacion.executeUpdate();
                
                pstLista=con.prepareStatement("SELECT max(ID_Oblifinmes) FROM Oblifinmes");
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
            pstOperacion.close();
            pstLista.close();
        } catch (Exception e) {
            pstOperacion.close();
            pstLista.close();
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
