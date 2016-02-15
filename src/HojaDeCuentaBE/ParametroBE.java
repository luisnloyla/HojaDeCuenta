/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuentaBE;

/**
 *
 * @author Loyola
 */
public class ParametroBE {
    private int     Accion;
    private int     Id_Parametro;
    private String  Codigo;
    private String  Descripcion;
    private int     Id_Parametro_Origen;    
    private String  FlagActivo ;
    private int     ReturnVal;

    public ParametroBE(int Accion, int Id_Parametro, String Codigo, String Descripcion, int Id_Parametro_Origen, String FlagActivo) {
        this.Accion = Accion;
        this.Id_Parametro = Id_Parametro;
        this.Codigo = Codigo;
        this.Descripcion = Descripcion;
        this.Id_Parametro_Origen = Id_Parametro_Origen;
        this.FlagActivo = FlagActivo;        
    }

    public int getAccion() {
        return Accion;
    }

    public void setAccion(int Accion) {
        this.Accion = Accion;
    }

    public int getId_Parametro() {
        return Id_Parametro;
    }

    public void setId_Parametro(int Id_Parametro) {
        this.Id_Parametro = Id_Parametro;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getId_Parametro_Origen() {
        return Id_Parametro_Origen;
    }

    public void setId_Parametro_Origen(int Id_Parametro_Origen) {
        this.Id_Parametro_Origen = Id_Parametro_Origen;
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