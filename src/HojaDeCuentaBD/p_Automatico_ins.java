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
public class p_Automatico_ins {
    private int Accion;
    private int Id_Automatico;
    private int Codigo;
    private String Descripcion;
    private int ReturnVal ;
    
    public p_Automatico_ins(Coneccion strCn,AutomaticoBE objAutomaticoBE) throws SQLException {
        this.Accion = objAutomaticoBE.getAccion();
        this.Id_Automatico = objAutomaticoBE.getId_Automatico();
        this.Codigo = objAutomaticoBE.getCodigo();
        this.Descripcion = objAutomaticoBE.getDescripcion();
        Connection con = strCn.getCon();
        ResultSet rs=null;
        
        PreparedStatement pstOperacion = null;
        PreparedStatement pstUpdFinMes = null;
        PreparedStatement pstLista = null;
        try {
            con.setAutoCommit(false);
            if (this.Accion == 1){
                pstLista=con.prepareStatement("SELECT max(ID_Automatico) FROM Automatico");
                rs=pstLista.executeQuery();
                int idValidAnterior=0;
                while (rs.next()) {
                    idValidAnterior=rs.getInt(1);
                }
                pstOperacion=con.prepareStatement("INSERT INTO Automatico"
                        + "(Codigo , Descripcion ) "
                        + "VALUES(? , ?)");                
                pstOperacion.setInt(1, this.Codigo);                
                pstOperacion.setString(2, this.Descripcion);
                
                pstOperacion.executeUpdate();
                
                pstLista=con.prepareStatement("SELECT max(ID_Automatico) FROM Automatico");
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
    public p_Automatico_ins(Connection con,AutomaticoBE objAutomaticoBE) throws SQLException {
        this.Accion = objAutomaticoBE.getAccion();
        this.Id_Automatico = objAutomaticoBE.getId_Automatico();
        this.Codigo = objAutomaticoBE.getCodigo();
        this.Descripcion = objAutomaticoBE.getDescripcion();
        
        ResultSet rs=null;

        PreparedStatement pstOperacion = null;
        PreparedStatement pstLista = null;
        try {
            con.setAutoCommit(false);
            //codigo
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
