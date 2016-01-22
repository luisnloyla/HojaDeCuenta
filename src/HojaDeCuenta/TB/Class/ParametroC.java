/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuenta.TB.Class;

import HojaDeCuentaBE.ParametroBE;
import HojaDeCuentaBL.cParametroBLL;
import HojaDeCuentaVar.V;
import ejecutar.Coneccion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;


/**
 *
 * @author Loyola
 */
public class ParametroC {

    private int Id_Parametro ;
    private String Codigo ;
    private String Descripcion ;
    private int Id_Parametro_Origen; 
    private int     Tipo;
    private String  FlagActivo ;

    public ParametroC(int Id_Parametro, String Codigo, String Descripcion, int Id_Parametro_Origen, int Tipo, String FlagActivo) {
        this.Id_Parametro = Id_Parametro;
        this.Codigo = Codigo;
        this.Descripcion = Descripcion;
        this.Id_Parametro_Origen = Id_Parametro_Origen;
        this.Tipo = Tipo;
        this.FlagActivo = FlagActivo;
    }
    
    

    public int getId_Parametro() {
        return Id_Parametro;
    }

    public void setId_Parametro(int Id_Parametro) {
        this.Id_Parametro = Id_Parametro;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getId_Parametro_Origen() {
        return Id_Parametro_Origen;
    }

    public void setId_Parametro_Origen(int Id_Parametro_Origen) {
        this.Id_Parametro_Origen = Id_Parametro_Origen;
    }   
    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    public String getFlagActivo() {
        return FlagActivo;
    }

    public void setFlagActivo(String FlagActivo) {
        this.FlagActivo = FlagActivo;
    }
    public static List<ParametroC> getParametroTC() throws SQLException {                
        ParametroBE ParametroBE = new ParametroBE(1, 0, "", "", 0,0,new V().cFlagActivo);
        cParametroBLL ParametroBLL= new cParametroBLL();
        List<ParametroBE> objParametroBE=ParametroBLL.Leer(new Coneccion(), ParametroBE);
        List<ParametroC> objParametroTC = new ArrayList<>();
        for (ParametroBE obj : objParametroBE) {
            ParametroC utc = new ParametroC(obj.getId_Parametro() , obj.getCodigo(), obj.getDescripcion(), obj.getId_Parametro_Origen(),obj.getTipo(),obj.getFlagActivo());
            objParametroTC.add(utc);
        }
        if (objParametroBE.size()==0) {
            ParametroC utc = new ParametroC(0, "", "", 0,0,new V().cFlagInActivo);
            objParametroTC.add(utc);
        }
        return objParametroTC;
    }  

}
