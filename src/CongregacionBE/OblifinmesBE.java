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
public class OblifinmesBE {
    private int Accion;
    private int Id_Oblifinmes;
    private int Id_Mensual ;
    private String Obligacion ;
    private double Importe;
    private String Actual_Plazo;
    private String FlagActivo ;
    private int ReturnVal ;

    /**
     * @return the Accion
     */
    public int getAccion() {
        return Accion;
    }

    /**
     * @param Accion the Accion to set
     */
    public void setAccion(int Accion) {
        this.Accion = Accion;
    }

    /**
     * @return the Id_Oblifinmes
     */
    public int getId_Oblifinmes() {
        return Id_Oblifinmes;
    }

    /**
     * @param Id_Oblifinmes the Id_Oblifinmes to set
     */
    public void setId_Oblifinmes(int Id_Oblifinmes) {
        this.Id_Oblifinmes = Id_Oblifinmes;
    }

    /**
     * @return the Id_Mensual
     */
    public int getId_Mensual() {
        return Id_Mensual;
    }

    /**
     * @param Id_Mensual the Id_Mensual to set
     */
    public void setId_Mensual(int Id_Mensual) {
        this.Id_Mensual = Id_Mensual;
    }

    /**
     * @return the Obligacion
     */
    public String getObligacion() {
        return Obligacion;
    }

    /**
     * @param Obligacion the Obligacion to set
     */
    public void setObligacion(String Obligacion) {
        this.Obligacion = Obligacion;
    }

    /**
     * @return the Importe
     */
    public double getImporte() {
        return Importe;
    }

    /**
     * @param Importe the Importe to set
     */
    public void setImporte(double Importe) {
        this.Importe = Importe;
    }

    /**
     * @return the Actual_Plazo
     */
    public String getActual_Plazo() {
        return Actual_Plazo;
    }

    /**
     * @param Actual_Plazo the Actual_Plazo to set
     */
    public void setActual_Plazo(String Actual_Plazo) {
        this.Actual_Plazo = Actual_Plazo;
    }

    /**
     * @return the FlagActivo
     */
    public String getFlagActivo() {
        return FlagActivo;
    }

    /**
     * @param FlagActivo the FlagActivo to set
     */
    public void setFlagActivo(String FlagActivo) {
        this.FlagActivo = FlagActivo;
    }

    /**
     * @return the ReturnVal
     */
    public int getReturnVal() {
        return ReturnVal;
    }
   
}