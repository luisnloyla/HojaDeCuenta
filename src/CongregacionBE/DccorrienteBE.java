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
public class DccorrienteBE {
    private int Accion;
    private int Id_Dccorriente;
    private int Id_Ccorriente ;
    private int Id_Transaccion ;
    private int Id_Opcion ;
    private int Id_Tabla ;
    private String Descripcion ;
    private double Importe ;
    private String Flagactivo ;
    private int ReturnVal;
    public DccorrienteBE(int Accion, int Id_Dccorriente, int Id_Ccorriente, int Id_Transaccion, int Id_Opcion, int Id_Tabla, String Descripcion, double Importe, String Flagactivo) {
        this.Accion = Accion;
        this.Id_Dccorriente = Id_Dccorriente;
        this.Id_Ccorriente = Id_Ccorriente;
        this.Id_Transaccion = Id_Transaccion;
        this.Id_Opcion = Id_Opcion;
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
     * @return the Id_Dccorriente
     */
    public int getId_Dccorriente() {
        return Id_Dccorriente;
    }

    /**
     * @param Id_Dccorriente the Id_Dccorriente to set
     */
    public void setId_Dccorriente(int Id_Dccorriente) {
        this.Id_Dccorriente = Id_Dccorriente;
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
     * @return the Id_Opcion
     */
    public int getId_Opcion() {
        return Id_Opcion;
    }

    /**
     * @param Id_Opcion the Id_Opcion to set
     */
    public void setId_Opcion(int Id_Opcion) {
        this.Id_Opcion = Id_Opcion;
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
