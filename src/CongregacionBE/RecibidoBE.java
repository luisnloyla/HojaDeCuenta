/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionBE;

import java.sql.Date;

/**
 *
 * @author Loyola
 */
public class RecibidoBE {
    private int Accion;
    private int Id_Recibido;
    private int Id_Mensual;
    private Date Fecha;
    private String Recibidon;
    private double Importe;
    private String FlagActivo;
    private int ReturnVal;

    public RecibidoBE(int Accion, int Id_Recibido, int Id_Mensual, Date Fecha, String Recibidon, double Importe, String FlagActivo) {
        this.Accion = Accion;
        this.Id_Recibido = Id_Recibido;
        this.Id_Mensual = Id_Mensual;
        this.Fecha = Fecha;
        this.Recibidon = Recibidon;
        this.Importe = Importe;
        this.FlagActivo = FlagActivo;
    }

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
     * @return the Id_Recibido
     */
    public int getId_Recibido() {
        return Id_Recibido;
    }

    /**
     * @param Id_Recibido the Id_Recibido to set
     */
    public void setId_Recibido(int Id_Recibido) {
        this.Id_Recibido = Id_Recibido;
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
     * @return the Fecha
     */
    public Date getFecha() {
        return Fecha;
    }

    /**
     * @param Fecha the Fecha to set
     */
    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    /**
     * @return the Recibidon
     */
    public String getRecibidon() {
        return Recibidon;
    }

    /**
     * @param Recibidon the Recibidon to set
     */
    public void setRecibidon(String Recibidon) {
        this.Recibidon = Recibidon;
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