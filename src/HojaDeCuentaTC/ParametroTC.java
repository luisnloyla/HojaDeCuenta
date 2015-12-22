/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuentaTC;

import HojaDeCuentaBE.ParametroBE;
import HojaDeCuentaBL.cParametroBLL;
import com.toedter.calendar.JCalendar;
import ejecutar.Coneccion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;


/**
 *
 * @author Loyola
 */
public class ParametroTC {

    private int Id_Parametro ;
    private String Codigo ;
    private String Descripcion ;
    private int Id_Parametro_Origen;
    private JPanel jPanel;

    public ParametroTC(int Id_Parametro, String Codigo, String Descripcion, int Id_Parametro_Origen,JPanel jPanel) {
        this.Id_Parametro = Id_Parametro;
        this.Codigo = Codigo;
        this.Descripcion = Descripcion;
        this.Id_Parametro_Origen = Id_Parametro_Origen;
        this.jPanel = jPanel;
    }
    
    
    public static List<ParametroTC> getParametroTC() throws SQLException {
        Coneccion coneccion= new Coneccion(); 
        ParametroBE ParametroBE = new ParametroBE(1, 0, "", "", 0);
        cParametroBLL ParametroBLL= new cParametroBLL();
//            cParametroBL ParametroBL= new cParametroBL();
        List<ParametroBE> objParametroBE=ParametroBLL.Leer(coneccion, ParametroBE);        
        List<ParametroTC> objParametroTC = new ArrayList<>();
        for (ParametroBE obj : objParametroBE) {
            ParametroTC utc = new ParametroTC(obj.getId_Parametro() , obj.getCodigo(), obj.getDescripcion(), obj.getId_Parametro_Origen(),null );
            objParametroTC.add(utc);
        }
//        ParametroTC utc = new ParametroTC(1, "MARLON", "123MJ", "1","Grabar");
//        ParametroTC utc2 = new ParametroTC(2, "MARIO BROZZ", "EDC32", "1","Grabar");
//        ParametroTC utc3 = new ParametroTC(3, "HIME LUX", "739J4", "1","Grabar");
//        objParametroTC.add(utc);
//        objParametroTC.add(utc2);
//        objParametroTC.add(utc3);
        return objParametroTC;
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

    public JPanel getjPanel() {
        return jPanel;
    }

    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }

}
