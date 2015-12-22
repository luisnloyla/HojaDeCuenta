/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionBD;

import CongregacionBE.OtroBE;
import CongregacionBE.UsuarioBE;
import ejecutar.Coneccion;
import java.sql.Connection;

/**
 *
 * @author Loyola
 */
public class p_Otro_ins {
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

    public p_Otro_ins(Coneccion strCn,OtroBE objOtroBE) {
        this.Accion = objOtroBE.getAccion();
        this.Id_Otro = objOtroBE.getId_Otro();
        this.Id_Mensual = objOtroBE.getId_Mensual();
        this.Id_Ccorriente = objOtroBE.getId_Ccorriente();
        this.Id_Transaccion = objOtroBE.getId_Transaccion();
        this.Id_Tabla = objOtroBE.getId_Tabla();
        this.Descripcion = objOtroBE.getDescripcion();
        this.Importe = objOtroBE.getImporte();
        this.Flagactivo = objOtroBE.getFlagactivo();
        this.ReturnVal = objOtroBE.getReturnVal();
    }
    public p_Otro_ins(Connection strCn,OtroBE objOtroBE) {
        this.Accion = objOtroBE.getAccion();
        this.Id_Otro = objOtroBE.getId_Otro();
        this.Id_Mensual = objOtroBE.getId_Mensual();
        this.Id_Ccorriente = objOtroBE.getId_Ccorriente();
        this.Id_Transaccion = objOtroBE.getId_Transaccion();
        this.Id_Tabla = objOtroBE.getId_Tabla();
        this.Descripcion = objOtroBE.getDescripcion();
        this.Importe = objOtroBE.getImporte();
        this.Flagactivo = objOtroBE.getFlagactivo();
        this.ReturnVal = objOtroBE.getReturnVal();
    }

    public int getReturnVal() {
        return ReturnVal;
    }

    public void setReturnVal(int ReturnVal) {
        this.ReturnVal = ReturnVal;
    }
    
}
