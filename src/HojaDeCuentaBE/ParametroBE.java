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
    private int     Tipo;
    private String  FlagActivo ;
    private int     ReturnVal;

    public ParametroBE(int Accion, int Id_Parametro, String Codigo, String Descripcion, int Id_Parametro_Origen) {
        this.Accion = Accion;
        this.Id_Parametro = Id_Parametro;
        this.Codigo = Codigo;
        this.Descripcion = Descripcion;
        this.Id_Parametro_Origen = Id_Parametro_Origen;
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
     * @return the Id_Parametro
     */
    public int getId_Parametro() {
        return Id_Parametro;
    }

    /**
     * @param Id_Parametro the Id_Parametro to set
     */
    public void setId_Parametro(int Id_Parametro) {
        this.Id_Parametro = Id_Parametro;
    }

    /**
     * @return the Codigo
     */
    public String getCodigo() {
        return Codigo;
    }

    /**
     * @param Codigo the Codigo to set
     */
    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
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
     * @return the Id_Parametro_Origen
     */
    public int getId_Parametro_Origen() {
        return Id_Parametro_Origen;
    }

    /**
     * @param Id_Parametro_Origen the Id_Parametro_Origen to set
     */
    public void setId_Parametro_Origen(int Id_Parametro_Origen) {
        this.Id_Parametro_Origen = Id_Parametro_Origen;
    }

    /**
     * @return the ReturnVal
     */
    public int getReturnVal() {
        return ReturnVal;
    }  
    
}