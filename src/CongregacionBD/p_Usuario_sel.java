/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionBD;

import CongregacionBE.UsuarioBE;
import ejecutar.Coneccion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Loyola
 */
public class p_Usuario_sel {
    private int Accion;
    private int Id_Usuario;
    private String Nombre;
    private String Password;
    private int ReturnVal;
    private List<UsuarioBE> aUsuario = new ArrayList<>(); 
    public p_Usuario_sel(Coneccion strCn,UsuarioBE objUsuarioBE) {
        this.Accion     = objUsuarioBE.getAccion();
        this.Id_Usuario = objUsuarioBE.getId_Usuario();
        this.Nombre     = objUsuarioBE.getNombre();
        this.Password   = objUsuarioBE.getPassword();
        Statement st=null;
        ResultSet rs=null;
                
        UsuarioBE usuarioBE = null;
        try {
            st = strCn.getSt();
            
            //        this.ReturVal = ReturVal;
            if (this.Accion == 1){

                rs=st.executeQuery("SELECT*FROM USUARIO");
                while (rs.next()) {
                    System.out.println(""+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
                    usuarioBE = new UsuarioBE(0, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                    aUsuario.add(usuarioBE);
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
    public p_Usuario_sel(Connection strCn,UsuarioBE objUsuarioBE) {
        this.Accion     = objUsuarioBE.getAccion();
        this.Id_Usuario = objUsuarioBE.getId_Usuario();
        this.Nombre     = objUsuarioBE.getNombre();
        this.Password   = objUsuarioBE.getPassword();
        Statement st=null;
        ResultSet rs=null;
        try {
            st = strCn.createStatement();
            
            //        this.ReturVal = ReturVal;
            if (this.Accion == 1){
//              st.executeUpdate("CREATE TABLE USUARIO(Id_Usuario INT PRIMARY KEY,Nombre VARCHAR(100),Password VARCHAR(100))");
                rs=st.executeQuery("SELECT*FROM USUARIO");
                while (rs.next()) {
                    System.out.println(""+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
                    
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
    public int getReturVal() {
        return ReturnVal;
    }

    public void setReturVal(int ReturVal) {
        this.ReturnVal = ReturVal;
    }

    public List<UsuarioBE> getaUsuario() {
        return aUsuario;
    }

    public void setaUsuario(List<UsuarioBE> aUsuario) {
        this.aUsuario = aUsuario;
    }
    
}
