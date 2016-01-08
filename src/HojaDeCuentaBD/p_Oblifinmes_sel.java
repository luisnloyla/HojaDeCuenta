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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Loyola
 */
public class p_Oblifinmes_sel {
    private int Accion;
    private int Id_Oblifinmes;
    private int Id_Mensual ;
    private String Obligacion ;
    private float Importe;
    private String Actual_Plazo;
    private String FlagActivo ;
    private List<OblifinmesBE> aOblifinmesBE = new ArrayList<>();    
    private int ReturnVal ;
    //particulares
    private OblifinmesBE uOblifinmesBE = null;
    private float valor = 0;
    
    public p_Oblifinmes_sel(Coneccion strCn,OblifinmesBE objOblifinmesBE) throws SQLException {
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
        PreparedStatement pstLista = null;
        try {
            con.setAutoCommit(false);
            if (this.Accion == 1){
                pstLista=con.prepareStatement("SELECT * FROM Oblifinmes WHERE ID_MENSUAL = ? AND ACTUAL_PLAZO = ? AND FLAGACTIVO = '1'");
                pstLista.setInt(1, this.Id_Mensual);
                pstLista.setString(2, this.Actual_Plazo);
                rs=pstLista.executeQuery();
                while (rs.next()) {
                    OblifinmesBE objOblifinmesBElista = new OblifinmesBE(0, rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4), rs.getString(5), rs.getString(6));
                    aOblifinmesBE.add(objOblifinmesBElista);
                }
                this.ReturnVal=0;
            }
            if (this.Accion == 2){
                pstLista=con.prepareStatement("SELECT * FROM Oblifinmes WHERE ID_Oblifinmes = ? AND FLAGACTIVO = '1'");
                pstLista.setInt(1, this.Id_Oblifinmes);
                rs=pstLista.executeQuery();
                while (rs.next()) {
                    OblifinmesBE objOblifinmesBElista = new OblifinmesBE(0, rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4), rs.getString(5), rs.getString(6));
                    aOblifinmesBE.add(objOblifinmesBElista);
                }
                this.ReturnVal=0;
            }
            if (this.Accion == 3){
                pstLista=con.prepareStatement("SELECT SUM(IMPORTE) FROM Oblifinmes WHERE ID_MENSUAL = ? AND ACTUAL_PLAZO = ? AND FLAGACTIVO = '1'");
                pstLista.setInt(1, this.Id_Mensual);
                pstLista.setString(2, this.Actual_Plazo);
                rs=pstLista.executeQuery();
                while (rs.next()) {
                    this.valor = rs.getFloat(1);
                }
                this.ReturnVal=0;
            }            
            con.commit();
            con.setAutoCommit(true);
            pstLista.close();
        } catch (Exception e) {
            con.rollback();
            con.setAutoCommit(true);
            pstLista.close();
            System.out.println(e);
            this.ReturnVal=-1;
        }  
        
    }
    public p_Oblifinmes_sel(Connection strCn,OblifinmesBE objOblifinmesBE) {
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
    public List<OblifinmesBE> getaOblifinmesBE() {
        return aOblifinmesBE;
    }
    public void setaOblifinmesBE(List<OblifinmesBE> aOblifinmesBE) {
        this.aOblifinmesBE = aOblifinmesBE;
    }    

    public OblifinmesBE getuOblifinmesBE() {
        return uOblifinmesBE;
    }

    public void setuOblifinmesBE(OblifinmesBE uOblifinmesBE) {
        this.uOblifinmesBE = uOblifinmesBE;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }   
    
}