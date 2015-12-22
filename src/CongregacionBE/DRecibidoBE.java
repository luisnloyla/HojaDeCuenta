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
public class DRecibidoBE {
    private int Accion;
    private int Id_Drecibido ;
    private int Id_Recibido ;
    private int Id_Concepto;
    private String Descripcion;
    private double Importe;
    private String Flagactivo;
    private int ReturnVal;

    public DRecibidoBE(int Accion,int Id_Drecibido, int Id_Recibido, int Id_Concepto, String Descripcion, double Importe, String Flagactivo) {
        this.Accion = Accion;
        this.Id_Drecibido = Id_Drecibido;
        this.Id_Recibido = Id_Recibido;
        this.Id_Concepto = Id_Concepto;
        this.Descripcion = Descripcion;
        this.Importe = Importe;
        this.Flagactivo = Flagactivo;
    }

    public int getAccion() {
        return Accion;
    }

    public void setAccion(int Accion) {
        this.Accion = Accion;
    }
    
    /**
     * @return the Id_Drecibido
     */
    public int getId_Drecibido() {
        return Id_Drecibido;
    }

    /**
     * @param Id_Drecibido the Id_Drecibido to set
     */
    public void setId_Drecibido(int Id_Drecibido) {
        this.Id_Drecibido = Id_Drecibido;
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
    
}
