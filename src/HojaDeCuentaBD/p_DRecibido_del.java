/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuentaBD;
import HojaDeCuentaBE.DRecibidoBE;
import ejecutar.Coneccion;
import java.sql.Connection;

/**
 *
 * @author Loyola
 */
public class p_DRecibido_del {
    private int Accion;
    private int Id_Drecibido ;
    private int Id_Recibido ;
    private int Id_Concepto;
    private String Descripcion;
    private double Importe;
    private String Flagactivo;
    private int ReturnVal;
    
    public p_DRecibido_del(Coneccion strCn,DRecibidoBE objDRecibidoBE ) {
        this.Accion = objDRecibidoBE.getAccion();
        this.Id_Drecibido = objDRecibidoBE.getId_Drecibido();
        this.Id_Recibido = objDRecibidoBE.getId_Recibido();
        this.Id_Concepto = objDRecibidoBE.getId_Concepto();
        this.Descripcion = objDRecibidoBE.getDescripcion();
        this.Importe = objDRecibidoBE.getImporte();
        this.Flagactivo = objDRecibidoBE.getFlagactivo();    
    }
    public p_DRecibido_del(Connection strCn,DRecibidoBE objDRecibidoBE ) {
        this.Accion = objDRecibidoBE.getAccion();
        this.Id_Drecibido = objDRecibidoBE.getId_Drecibido();
        this.Id_Recibido = objDRecibidoBE.getId_Recibido();
        this.Id_Concepto = objDRecibidoBE.getId_Concepto();
        this.Descripcion = objDRecibidoBE.getDescripcion();
        this.Importe = objDRecibidoBE.getImporte();
        this.Flagactivo = objDRecibidoBE.getFlagactivo();    
    }

    public int getReturnVal() {
        return ReturnVal;
    }

    public void setReturnVal(int ReturnVal) {
        this.ReturnVal = ReturnVal;
    }
}
