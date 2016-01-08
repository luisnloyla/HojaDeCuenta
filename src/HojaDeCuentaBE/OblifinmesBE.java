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
public class OblifinmesBE {
    private int Accion;
    private int Id_Oblifinmes;
    private int Id_Mensual ;
    private String Obligacion ;
    private float Importe;
    private String Actual_Plazo;
    private String FlagActivo ;
    private int ReturnVal ;

    public OblifinmesBE(int Accion, int Id_Oblifinmes, int Id_Mensual, String Obligacion, float Importe, String Actual_Plazo, String FlagActivo) {
        this.Accion = Accion;
        this.Id_Oblifinmes = Id_Oblifinmes;
        this.Id_Mensual = Id_Mensual;
        this.Obligacion = Obligacion;
        this.Importe = Importe;
        this.Actual_Plazo = Actual_Plazo;
        this.FlagActivo = FlagActivo;        
    }

    public int getAccion() {
        return Accion;
    }

    public void setAccion(int Accion) {
        this.Accion = Accion;
    }

    public int getId_Oblifinmes() {
        return Id_Oblifinmes;
    }

    public void setId_Oblifinmes(int Id_Oblifinmes) {
        this.Id_Oblifinmes = Id_Oblifinmes;
    }

    public int getId_Mensual() {
        return Id_Mensual;
    }

    public void setId_Mensual(int Id_Mensual) {
        this.Id_Mensual = Id_Mensual;
    }

    public String getObligacion() {
        return Obligacion;
    }

    public void setObligacion(String Obligacion) {
        this.Obligacion = Obligacion;
    }

    public float getImporte() {
        return Importe;
    }

    public void setImporte(float Importe) {
        this.Importe = Importe;
    }

    public String getActual_Plazo() {
        return Actual_Plazo;
    }

    public void setActual_Plazo(String Actual_Plazo) {
        this.Actual_Plazo = Actual_Plazo;
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