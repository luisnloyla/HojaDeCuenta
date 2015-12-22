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
public class CcorrienteBE {

    private int Accion;
    private int Id_Ccorriente;
    private int Id_Mensual;
    private Date Fecha;
    private int Id_Concepto;
    private double Cuentan;
    private double Importe;
    private String Flagactivo;
    private int ReturnVal;

    public CcorrienteBE(int Accion, int Id_Ccorriente, int Id_Mensual, Date Fecha, int Id_Concepto, double Cuentan, double Importe, String Flagactivo) {
        this.Accion = Accion;
        this.Id_Ccorriente = Id_Ccorriente;
        this.Id_Mensual = Id_Mensual;
        this.Fecha = Fecha;
        this.Id_Concepto = Id_Concepto;
        this.Cuentan = Cuentan;
        this.Importe = Importe;
        this.Flagactivo = Flagactivo;
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
     * @return the Id_Ccorriente
     */
    public int getId_Ccorriente() {
        return Id_Ccorriente;
    }

    /**
     * @param Id_Ccorriente the Id_Ccorriente to set
     */
    public void setId_Ccorriente(int Id_Ccorriente) {
        this.Id_Ccorriente = Id_Ccorriente;
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
     * @return the Id_Concepto
     */
    public int getId_Concepto() {
        return Id_Concepto;
    }

    /**
     * @param Id_Concepto the Id_Concepto to set
     */
    public void setId_Concepto(int Id_Concepto) {
        this.Id_Concepto = Id_Concepto;
    }

    /**
     * @return the Cuentan
     */
    public double getCuentan() {
        return Cuentan;
    }

    /**
     * @param Cuentan the Cuentan to set
     */
    public void setCuentan(double Cuentan) {
        this.Cuentan = Cuentan;
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
     * @return the Flagactivo
     */
    public String getFlagactivo() {
        return Flagactivo;
    }

    /**
     * @param Flagactivo the Flagactivo to set
     */
    public void setFlagactivo(String Flagactivo) {
        this.Flagactivo = Flagactivo;
    }

    /**
     * @return the ReturnVal
     */
    public int getReturnVal() {
        return ReturnVal;
    }

    /**
     * @param ReturnVal the ReturnVal to set
     */
    public void setReturnVal(int ReturnVal) {
        this.ReturnVal = ReturnVal;
    }
    
}
