/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuentaBE;

import java.util.Date;

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
    private int IngresoSalida;
    private String FlagActivo;
    private int ReturnVal;
    public RecibidoBE(int Accion, int Id_Recibido, int Id_Mensual, Date Fecha, String Recibidon, double Importe, int IngresoSalida, String FlagActivo) {
        this.Accion = Accion;
        this.Id_Recibido = Id_Recibido;
        this.Id_Mensual = Id_Mensual;
        this.Fecha = Fecha;
        this.Recibidon = Recibidon;
        this.Importe = Importe;
        this.IngresoSalida = IngresoSalida;
        this.FlagActivo = FlagActivo;
    }

    public int getAccion() {
        return Accion;
    }

    public void setAccion(int Accion) {
        this.Accion = Accion;
    }

    public int getId_Recibido() {
        return Id_Recibido;
    }

    public void setId_Recibido(int Id_Recibido) {
        this.Id_Recibido = Id_Recibido;
    }

    public int getId_Mensual() {
        return Id_Mensual;
    }

    public void setId_Mensual(int Id_Mensual) {
        this.Id_Mensual = Id_Mensual;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getRecibidon() {
        return Recibidon;
    }

    public void setRecibidon(String Recibidon) {
        this.Recibidon = Recibidon;
    }

    public double getImporte() {
        return Importe;
    }

    public void setImporte(double Importe) {
        this.Importe = Importe;
    }

    public int getIngresoSalida() {
        return IngresoSalida;
    }

    public void setIngresoSalida(int IngresoSalida) {
        this.IngresoSalida = IngresoSalida;
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