/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuentaBE;

/**
 *
 * @author luis
 */
public class AutomaticoBE {
    private int Accion;
    private int Id_Automatico;
    private int Codigo;
    private String Descripcion;
    private int ReturnVal ;

    public AutomaticoBE(int Accion, int Id_Automatico, int Codigo, String Descripcion) {
        this.Accion = Accion;
        this.Id_Automatico = Id_Automatico;
        this.Codigo = Codigo;
        this.Descripcion = Descripcion;        
    }
    
    public void setAccion(int Accion) {
        this.Accion = Accion;
    }

    public int getAccion() {
        return Accion;
    }
    
    public int getId_Automatico() {
        return Id_Automatico;
    }

    public void setId_Automatico(int Id_Automatico) {
        this.Id_Automatico = Id_Automatico;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setReturnVal(int ReturnVal) {
        this.ReturnVal = ReturnVal;
    }

    public int getReturnVal() {
        return ReturnVal;
    }
    
}
