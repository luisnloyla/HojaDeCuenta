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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Loyola
 */
public class p_Automatico_sel {
    private int Accion;
    private int Id_Automatico;
    private int Codigo;
    private String Descripcion;    
    private List<AutomaticoBE> aAutomaticoBE = new ArrayList<>();    
    private int ReturnVal ;
    //particulares
    private AutomaticoBE uAutomaticoBE = null;
    private float valor = 0;
    
    public p_Automatico_sel(Coneccion strCn,AutomaticoBE objAutomaticoBE) throws SQLException {
        this.Accion = objAutomaticoBE.getAccion();
        this.Id_Automatico = objAutomaticoBE.getId_Automatico();
        this.Codigo = objAutomaticoBE.getCodigo();
        this.Descripcion = objAutomaticoBE.getDescripcion();
        
        Connection con = strCn.getCon();
        ResultSet rs=null;
        PreparedStatement pstLista = null;
        try {
            con.setAutoCommit(false);
            if (this.Accion == 1){
                pstLista=con.prepareStatement("SELECT * FROM Automatico WHERE Descripcion = ?");
                pstLista.setString(1, this.Descripcion);
                rs=pstLista.executeQuery();
                while (rs.next()) {
                    AutomaticoBE objAutomaticoBElista = new AutomaticoBE(0, rs.getInt(1), rs.getInt(2), rs.getString(3));
                    aAutomaticoBE.add(objAutomaticoBElista);
                }
                this.ReturnVal=0;
            }
            if (this.Accion == 2){
                pstLista=con.prepareStatement("SELECT * FROM Automatico WHERE Codigo = ? AND Descripcion = ?");
                pstLista.setInt(1, this.Codigo);
                pstLista.setString(2, this.Descripcion);
                rs=pstLista.executeQuery();
                while (rs.next()) {
                    AutomaticoBE objAutomaticoBElista = new AutomaticoBE(0, rs.getInt(1), rs.getInt(2), rs.getString(3));
                    aAutomaticoBE.add(objAutomaticoBElista);
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
    public p_Automatico_sel(Connection strCn,AutomaticoBE objAutomaticoBE) {
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
    public List<AutomaticoBE> getaAutomaticoBE() {
        return aAutomaticoBE;
    }
    public void setaAutomaticoBE(List<AutomaticoBE> aAutomaticoBE) {
        this.aAutomaticoBE = aAutomaticoBE;
    }    

    public AutomaticoBE getuAutomaticoBE() {
        return uAutomaticoBE;
    }

    public void setuAutomaticoBE(AutomaticoBE uAutomaticoBE) {
        this.uAutomaticoBE = uAutomaticoBE;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }   
    
}