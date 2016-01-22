/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuentaBD;

import HojaDeCuentaBE.AutomaticoBE;
import ejecutar.Coneccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Loyola
 */
public class p_Automatico_upd {
    private int Accion;
    private int Id_Automatico;
    private int Codigo;
    private String Descripcion;
    private int ReturnVal ;
    
    public p_Automatico_upd(Coneccion strCn,AutomaticoBE objAutomaticoBE) throws SQLException {
        this.Accion = objAutomaticoBE.getAccion();
        this.Id_Automatico = objAutomaticoBE.getId_Automatico();
        this.Codigo = objAutomaticoBE.getCodigo();
        this.Descripcion = objAutomaticoBE.getDescripcion();        
        
        Connection con = strCn.getCon();
        ResultSet rs=null;
        PreparedStatement pstOperacion = null;
        PreparedStatement pstUpdFinMes = null;
//        PreparedStatement pstLista = null;
        try {
            con.setAutoCommit(false);
            if (this.Accion == 1){ //ACTUALIZACION DE DEGISTROS DE UNA TABLA
                pstOperacion=con.prepareStatement("UPDATE Automatico SET "
                + " Codigo = ?"
                + ",Descripcio = ?"
                +"WHERE ID_Automatico = ?");
                pstOperacion.setInt(1, this.Codigo);
                pstOperacion.setString(2, this.Descripcion);                
                pstOperacion.executeUpdate();
                this.ReturnVal=0;
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
    public p_Automatico_upd(Connection con,AutomaticoBE objAutomaticoBE) throws SQLException {
        this.Accion = objAutomaticoBE.getAccion();
        this.Id_Automatico = objAutomaticoBE.getId_Automatico();
        this.Codigo = objAutomaticoBE.getCodigo();
        this.Descripcion = objAutomaticoBE.getDescripcion();        
        
        ResultSet rs=null;
        PreparedStatement pstOperacion = null;
        try {
            con.setAutoCommit(false);
            if (this.Accion == 3){ //ACTUALIZACION DE DEGISTROS DE UNA TABLA
                pstOperacion=con.prepareStatement("UPDATE Automatico SET " 
                + " Codigo = ?"
                + ",Descripcio = ?"
                +"WHERE ID_Automatico = ?");
//                pstOperacion.setDate(1, this.Fecha); nunca se edita por cuestiones delk programa
                
                pstOperacion.setInt(1, this.Codigo);
                pstOperacion.setString(2, this.Descripcion);                
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
