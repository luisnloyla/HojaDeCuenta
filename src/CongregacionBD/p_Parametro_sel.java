/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionBD;

import CongregacionBE.ParametroBE;
import ejecutar.Coneccion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Loyola
 */
public class p_Parametro_sel {
    private int Accion;
    private int Id_Parametro ;
    private String Codigo ;
    private String Descripcion ;
    private int Id_Parametro_Origen;
    private int ReturnVal;
    private List<ParametroBE> aParametroBE = new ArrayList<>(); 

    public p_Parametro_sel(Coneccion strCn,ParametroBE objParametroBE) {
        this.Accion = objParametroBE.getAccion();
        this.Id_Parametro = objParametroBE.getId_Parametro();
        this.Codigo = objParametroBE.getCodigo();
        this.Descripcion = objParametroBE.getDescripcion();
        this.Id_Parametro_Origen = objParametroBE.getId_Parametro_Origen();
        this.ReturnVal = objParametroBE.getReturnVal();
        Statement st=null;
        ResultSet rs=null;
                
        ParametroBE ParametroBE = null;
        try {
            st = strCn.getSt();
            
            //        this.ReturVal = ReturVal;
            if (this.Accion == 1){

                rs=st.executeQuery("SELECT*FROM Parametro");
                while (rs.next()) {
                    System.out.println(""+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
                    ParametroBE = new ParametroBE(0, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                    aParametroBE.add(ParametroBE);
                }
              rs.close();
              st.close(); 
              this.ReturnVal=0;
            }
        } catch (Exception e) {
            this.ReturnVal=-1;
            System.out.println(e);
        } 
    }
    public p_Parametro_sel(Connection strCn,ParametroBE objParametroBE) {
        this.Accion = objParametroBE.getAccion();
        this.Id_Parametro = objParametroBE.getId_Parametro();
        this.Codigo = objParametroBE.getCodigo();
        this.Descripcion = objParametroBE.getDescripcion();
        this.Id_Parametro_Origen = objParametroBE.getId_Parametro_Origen();
        this.ReturnVal = objParametroBE.getReturnVal();
    }

    public int getReturnVal() {
        return ReturnVal;
    }

    public void setReturnVal(int ReturnVal) {
        this.ReturnVal = ReturnVal;
    }

    public int getReturVal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<ParametroBE> getaParametroBE() {
        return aParametroBE;
    }

    public void setaParametroBE(List<ParametroBE> aParametroBE) {
        this.aParametroBE = aParametroBE;
    }
    
}
