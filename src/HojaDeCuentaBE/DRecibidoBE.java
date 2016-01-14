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
public class DRecibidoBE {
    private int Accion;
    private int Id_Drecibido;
    private int Id_Recibido;
    private int Id_Concepto;
    private String Descripcion;
    private double Importe;
    private Date Fecha;
    private int Orden;
    private int IngresoSalida;
    private String Flagactivo;
    private int ReturnVal;
    
    public DRecibidoBE(int Accion, int Id_Drecibido, int Id_Recibido, int Id_Concepto, String Descripcion, double Importe, Date Fecha, int Orden, int IngresoSalida, String Flagactivo) {
        this.Accion = Accion;
        this.Id_Drecibido = Id_Drecibido;
        this.Id_Recibido = Id_Recibido;
        this.Id_Concepto = Id_Concepto;
        this.Descripcion = Descripcion;
        this.Importe = Importe;
        this.Fecha = Fecha;
        this.Orden = Orden;
        this.IngresoSalida = IngresoSalida;
        this.Flagactivo = Flagactivo;
    }

    public int getAccion() {
        return Accion;
    }

    public void setAccion(int Accion) {
        this.Accion = Accion;
    }

    public int getId_Drecibido() {
        return Id_Drecibido;
    }

    public void setId_Drecibido(int Id_Drecibido) {
        this.Id_Drecibido = Id_Drecibido;
    }

    public int getId_Recibido() {
        return Id_Recibido;
    }

    public void setId_Recibido(int Id_Recibido) {
        this.Id_Recibido = Id_Recibido;
    }

    public int getId_Concepto() {
        return Id_Concepto;
    }

    public void setId_Concepto(int Id_Concepto) {
        this.Id_Concepto = Id_Concepto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public double getImporte() {
        return Importe;
    }

    public void setImporte(double Importe) {
        this.Importe = Importe;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public int getOrden() {
        return Orden;
    }

    public void setOrden(int Orden) {
        this.Orden = Orden;
    }

    public int getIngresoSalida() {
        return IngresoSalida;
    }

    public void setIngresoSalida(int IngresoSalida) {
        this.IngresoSalida = IngresoSalida;
    }

    public String getFlagactivo() {
        return Flagactivo;
    }

    public void setFlagactivo(String Flagactivo) {
        this.Flagactivo = Flagactivo;
    }

    public int getReturnVal() {
        return ReturnVal;
    }

    public void setReturnVal(int ReturnVal) {
        this.ReturnVal = ReturnVal;
    }
    
    
}
