/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionTC;

import CongregacionBE.UsuarioBE;
import CongregacionBL.cUsuarioBLL;
import com.toedter.calendar.JDateChooser;
import ejecutar.Coneccion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Loyola
 */
public class UsuarioTC02 {
    private int Id_Usuario;
    private String Nombre;
    private String Password;
    private String FlagActivo;
    private boolean FlagActivoEtiqueta;
    private JPanel Bootn;
    private JDateChooser jDateChooser;
    public UsuarioTC02(int Id_Usuario, String Nombre, String Password, String FlagActivo, boolean FlagActivoEtiqueta,JPanel jPanel,JDateChooser jDateChooser) {
        
        this.Id_Usuario = Id_Usuario;
        this.Nombre = Nombre;
        this.Password = Password;
        this.FlagActivo = FlagActivo;
        this.FlagActivoEtiqueta=FlagActivoEtiqueta;
        this.Bootn = jPanel;
        this.jDateChooser = jDateChooser;
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
    
    public static List<UsuarioTC02> getUsuarioTC02() throws SQLException {
        Coneccion coneccion= new Coneccion(); 
        UsuarioBE usuarioBE = new UsuarioBE(1, 0, "","","1");
        cUsuarioBLL usuarioBLL= new cUsuarioBLL();
//            cUsuarioBL usuarioBL= new cUsuarioBL();
        List<UsuarioBE> objUsuarioBE=usuarioBLL.Leer(coneccion, usuarioBE);
        List<UsuarioTC02> objUsuarioTC = new ArrayList<>();
        for (UsuarioBE obj : objUsuarioBE) {
            UsuarioTC02 utc = new UsuarioTC02(obj.getId_Usuario(),obj.getNombre(), obj.getPassword(), obj.getFlagActivo(),true,new JPanel(),new JDateChooser());
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
    public boolean getFlagActivoEtiqueta() {
        return FlagActivoEtiqueta;
    }
    public void setFlagActivoEtiqueta(boolean FlagActivoEtiqueta) {
        this.FlagActivoEtiqueta = FlagActivoEtiqueta;
    }

    public JPanel getBootn() {
        return Bootn;
    }

    public void setBootn(JPanel Bootn) {
        this.Bootn = Bootn;
    }

    public JDateChooser getjDateChooser() {
        return jDateChooser;
    }

    public void setjDateChooser(JDateChooser jDateChooser) {
        this.jDateChooser = jDateChooser;
    }

    public void setFlagActivoEtiqueta(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
