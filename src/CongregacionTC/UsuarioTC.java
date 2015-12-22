/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionTC;

import CongregacionBE.UsuarioBE;
import CongregacionBL.cUsuarioBL;
import CongregacionBL.cUsuarioBLL;
import ejecutar.Coneccion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Loyola
 */
public class UsuarioTC {

    
    private int Id_Usuario;
    private String Nombre;
    private String Password;
    private String FlagActivo;
    private String FlagActivoEtiqueta;
    private JPanel jpanel;
    
    public UsuarioTC(int Id_Usuario, String Nombre, String Password, String FlagActivo, String FlagActivoEtiqueta,JPanel jPanel) {
        
        this.Id_Usuario = Id_Usuario;
        this.Nombre = Nombre;
        this.Password = Password;
        this.FlagActivo = FlagActivo;
        this.FlagActivoEtiqueta=FlagActivoEtiqueta;
        this.jpanel=jPanel;
    }
    /**
     * @return the Id_Usuario
     */
    public int getId_Usuario() {
        return Id_Usuario;
    }

    /**
     * @param Id_Usuario the Id_Usuario to set
     */
    public void setId_Usuario(int Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }
    public String getFlagActivo() {
        return FlagActivo;
    }

    public void setFlagActivo(String FlagActivo) {
        this.FlagActivo = FlagActivo;
    }
    
    public static List<UsuarioTC> getUsuarioTC() throws SQLException {
        Coneccion coneccion= new Coneccion(); 
        UsuarioBE usuarioBE = new UsuarioBE(1, 0, "","","1");
        cUsuarioBLL usuarioBLL= new cUsuarioBLL();
//            cUsuarioBL usuarioBL= new cUsuarioBL();
        List<UsuarioBE> objUsuarioBE=usuarioBLL.Leer(coneccion, usuarioBE);        
        List<UsuarioTC> objUsuarioTC = new ArrayList<>();
        for (UsuarioBE obj : objUsuarioBE) {
            UsuarioTC utc = new UsuarioTC(obj.getId_Usuario(),obj.getNombre(), obj.getPassword(), obj.getFlagActivo(),"Grabar",new JPanel());
            objUsuarioTC.add(utc);
        }
//        UsuarioTC utc = new UsuarioTC(1, "MARLON", "123MJ", "1","Grabar");
//        UsuarioTC utc2 = new UsuarioTC(2, "MARIO BROZZ", "EDC32", "1","Grabar");
//        UsuarioTC utc3 = new UsuarioTC(3, "HIME LUX", "739J4", "1","Grabar");
//        objUsuarioTC.add(utc);
//        objUsuarioTC.add(utc2);
//        objUsuarioTC.add(utc3);
        return objUsuarioTC;
    }

    public String getFlagActivoEtiqueta() {
        return FlagActivoEtiqueta;
    }

    public void setFlagActivoEtiqueta(String FlagActivoEtiqueta) {
        this.FlagActivoEtiqueta = FlagActivoEtiqueta;
    }

    public JPanel getJpanel() {
        return jpanel;
    }

    public void setJpanel(JPanel jpanel) {
        this.jpanel = jpanel;
    }
}
