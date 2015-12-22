/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionBD;

import CongregacionBE.DccorrienteBE;
import ejecutar.Coneccion;
import java.sql.Connection;

/**
 *
 * @author Loyola
 */
public class p_Dccorriente_sel {
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
    public p_Dccorriente_sel(Coneccion strCn,DccorrienteBE objDccorrienteBE) {
        this.Accion = objDccorrienteBE.getAccion();
        this.Id_Dccorriente = objDccorrienteBE.getId_Dccorriente();
        this.Id_Ccorriente = objDccorrienteBE.getId_Ccorriente();
        this.Id_Transaccion = objDccorrienteBE.getId_Transaccion();
        this.Id_Opcion = objDccorrienteBE.getId_Opcion();
        this.Id_Tabla = objDccorrienteBE.getId_Tabla();
        this.Descripcion = objDccorrienteBE.getDescripcion();
        this.Importe = objDccorrienteBE.getImporte();
        this.Flagactivo = objDccorrienteBE.getFlagactivo();
    
    }
    public p_Dccorriente_sel(Connection strCn,DccorrienteBE objDccorrienteBE) {
        this.Accion = objDccorrienteBE.getAccion();
        this.Id_Dccorriente = objDccorrienteBE.getId_Dccorriente();
        this.Id_Ccorriente = objDccorrienteBE.getId_Ccorriente();
        this.Id_Transaccion = objDccorrienteBE.getId_Transaccion();
        this.Id_Opcion = objDccorrienteBE.getId_Opcion();
        this.Id_Tabla = objDccorrienteBE.getId_Tabla();
        this.Descripcion = objDccorrienteBE.getDescripcion();
        this.Importe = objDccorrienteBE.getImporte();
        this.Flagactivo = objDccorrienteBE.getFlagactivo();
    
    }

    public int getReturnVal() {
        return ReturnVal;
    }

    public void setReturnVal(int ReturnVal) {
        this.ReturnVal = ReturnVal;
    }
    
}
