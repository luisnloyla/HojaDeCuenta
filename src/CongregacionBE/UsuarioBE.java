/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionBE;

/**
 *
 * @author Loyola
 */
public class UsuarioBE {
    private int Accion;
    private int Id_Usuario;
    private String Nombre;
    private String Password;
    private String FlagActivo;
    private int ReturnVal;

    public UsuarioBE(int Accion, int Id_Usuario, String Nombre, String Password, String FlagActivo) {
        this.Accion = Accion;
        this.Id_Usuario = Id_Usuario;
        this.Nombre = Nombre;
        this.Password = Password;
        this.FlagActivo = FlagActivo;
    }
    
    public int getAccion() {
        return Accion;
    }

    public void setAccion(int Accion) {
        this.Accion = Accion;
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

    public int getReturVal() {
        return ReturnVal;
    }

    public String getFlagActivo() {
        return FlagActivo;
    }

    public void setFlagActivo(String FlagActivo) {
        this.FlagActivo = FlagActivo;
    }

    public int getReturnVal() {
        return ReturnVal;
    }

    public void setReturnVal(int ReturnVal) {
        this.ReturnVal = ReturnVal;
    }
       
}
