/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuentaBD;

import HojaDeCuentaBE.ParametroBE;
import ejecutar.Coneccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Loyola
 */
public class p_Parametro_del {
    private int Accion;
    private int Id_Parametro ;
    private String Codigo ;
    private String Descripcion ;
    private int Id_Parametro_Origen;    
    private String  FlagActivo ;
    private int ReturnVal;

    public p_Parametro_del(Coneccion strCn,ParametroBE objParametroBE) throws SQLException {
        this.Accion = objParametroBE.getAccion();
        this.Id_Parametro = objParametroBE.getId_Parametro();
        this.Codigo = objParametroBE.getCodigo();
        this.Descripcion = objParametroBE.getDescripcion();
        this.Id_Parametro_Origen = objParametroBE.getId_Parametro_Origen();        
        this.FlagActivo = objParametroBE.getFlagActivo();
        this.ReturnVal = objParametroBE.getReturnVal();
        Connection con = strCn.getCon();
//        Statement st=null;
        ResultSet rs=null;
        
        PreparedStatement pstOperacion = null;
        PreparedStatement pstLista = null;
        try {
            con.setAutoCommit(false);
//            st = con.createStatement();
            if (this.Accion == 1){
                pstOperacion=con.prepareStatement("DELETE FROM PARAMETRO WHERE ID_PARAMETRO = ?");
                pstOperacion.setInt(1, this.Id_Parametro);
                pstOperacion.executeUpdate();
//                st.executeUpdate("DELETE FROM PARAMETRO WHERE ID_PARAMETRO = "+this.Id_Parametro);
                this.ReturnVal= 0;
//                rs=st.executeQuery("SELECT * FROM Parametro WHERE ID_PARAMETRO = " + this.Id_Parametro);
                pstLista=con.prepareStatement("SELECT * FROM Parametro WHERE ID_PARAMETRO = ?");
                pstLista.setInt(1, this.Id_Parametro);
                rs = pstLista.executeQuery();
                while (rs.next()) {
                    this.ReturnVal= -1;
                }
            }
            if (this.Accion == 2){               //DESTRUCCION TOTAL DE DATOS
                pstOperacion=con.prepareStatement("DELETE FROM PARAMETRO");
                pstOperacion.executeUpdate();
////                st.executeUpdate("DELETE FROM PARAMETRO");
                this.ReturnVal=0;
                pstLista=con.prepareStatement("SELECT * FROM Parametro WHERE ID_PARAMETRO = ?");
                rs = pstLista.executeQuery();
//                rs=st.executeQuery("SELECT * FROM Parametro");
                while (rs.next()) {
                    this.ReturnVal=-1;
                }
            }
            con.commit();
            con.setAutoCommit(true);
//            st.close();
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
    public p_Parametro_del(Connection strCn,ParametroBE objParametroBE) {
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
    
}