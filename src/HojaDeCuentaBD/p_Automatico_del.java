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
public class p_Automatico_del {
    private int Accion;
    private int Id_Automatico;
    private int Codigo;
    private String Descripcion;
    private int ReturnVal ;
    
    public p_Automatico_del(Coneccion strCn,AutomaticoBE objAutomaticoBE) throws SQLException {
        this.Accion = objAutomaticoBE.getAccion();
        this.Id_Automatico = objAutomaticoBE.getId_Automatico();
        this.Codigo = objAutomaticoBE.getCodigo();
        this.Descripcion = objAutomaticoBE.getDescripcion();      
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
                pstOperacion=con.prepareStatement("DELETE FROM Automatico WHERE ID_Automatico = ?");
                pstOperacion.setInt(1, this.Id_Automatico);
                this.ReturnVal= 0;
                if(pstOperacion.executeUpdate()==0) this.ReturnVal= -1;                
            }
            if (this.Accion == 2){               //DESTRUCCION TOTAL DE DATOS
                pstOperacion=con.prepareStatement("DELETE FROM Automatico");
                pstOperacion.executeUpdate();
                this.ReturnVal=0;
                if(pstOperacion.executeUpdate()==0) this.ReturnVal= -1;
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
    public p_Automatico_del(Connection strCn,AutomaticoBE objAutomaticoBE) {
        this.Accion = objAutomaticoBE.getAccion();
        this.Id_Automatico = objAutomaticoBE.getId_Automatico();
        this.Codigo = objAutomaticoBE.getCodigo();
        this.Descripcion = objAutomaticoBE.getDescripcion();        
    }

    public int getReturnVal() {
        return ReturnVal;
    }

    public void setReturnVal(int ReturnVal) {
        this.ReturnVal = ReturnVal;
    }
    
}
