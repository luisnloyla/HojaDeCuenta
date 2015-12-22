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
public class OtroBE {
    private int Accion;
    private int Id_Otro ;
    private int Id_Mensual ;
    private int Id_Ccorriente;
    private int Id_Transaccion ;
    private int Id_Tabla ;
    private String Descripcion ;
    private double Importe ;
    private String Flagactivo ;
    private int ReturnVal;

    public OtroBE(int Accion, int Id_Otro, int Id_Mensual, int Id_Ccorriente, int Id_Transaccion, int Id_Tabla, String Descripcion, double Importe, String Flagactivo) {
        this.Accion = Accion;
        this.Id_Otro = Id_Otro;
        this.Id_Mensual = Id_Mensual;
        this.Id_Ccorriente = Id_Ccorriente;
        this.Id_Transaccion = Id_Transaccion;
        this.Id_Tabla = Id_Tabla;
        this.Descripcion = Descripcion;
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
     * @return the Id_Otro
     */
    public int getId_Otro() {
        return Id_Otro;
    }

    /**
     * @param Id_Otro the Id_Otro to set
     */
    public void setId_Otro(int Id_Otro) {
        this.Id_Otro = Id_Otro;
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
     * @return the Id_Transaccion
     */
    public int getId_Transaccion() {
        return Id_Transaccion;
    }

    /**
     * @param Id_Transaccion the Id_Transaccion to set
     */
    public void setId_Transaccion(int Id_Transaccion) {
        this.Id_Transaccion = Id_Transaccion;
    }

    /**
     * @return the Id_Tabla
     */
    public int getId_Tabla() {
        return Id_Tabla;
    }

    /**
     * @param Id_Tabla the Id_Tabla to set
     */
    public void setId_Tabla(int Id_Tabla) {
        this.Id_Tabla = Id_Tabla;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
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
