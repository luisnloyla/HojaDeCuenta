/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionBD;

import CongregacionBE.RecibidoBE;
import CongregacionBE.UsuarioBE;
import ejecutar.Coneccion;
import java.sql.Connection;
import java.sql.Date;

/**
 *
 * @author Loyola
 */
public class p_Recibido_del {
    private int Accion;
    private int Id_Recibido;
    private int Id_Mensual;
    private Date Fecha;
    private String Recibidon;
    private double Importe;
    private String FlagActivo;
    private int ReturnVal;
    public p_Recibido_del(Coneccion strCn,RecibidoBE objRecibidoBE) {
        this.Accion = objRecibidoBE.getAccion();
        this.Id_Recibido = objRecibidoBE.getId_Recibido();
        this.Id_Mensual = objRecibidoBE.getId_Mensual();
        this.Fecha = objRecibidoBE.getFecha();
        this.Recibidon = objRecibidoBE.getRecibidon();
        this.Importe = objRecibidoBE.getImporte();
        this.FlagActivo = objRecibidoBE.getFlagActivo();
    }
    public p_Recibido_del(Connection strCn,RecibidoBE objRecibidoBE) {
        this.Accion = objRecibidoBE.getAccion();
        this.Id_Recibido = objRecibidoBE.getId_Recibido();
        this.Id_Mensual = objRecibidoBE.getId_Mensual();
        this.Fecha = objRecibidoBE.getFecha();
        this.Recibidon = objRecibidoBE.getRecibidon();
        this.Importe = objRecibidoBE.getImporte();
        this.FlagActivo = objRecibidoBE.getFlagActivo();
    }

    public int getReturnVal() {
        return ReturnVal;
    }

    public void setReturnVal(int ReturnVal) {
        this.ReturnVal = ReturnVal;
    }

    public int getReturVal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
