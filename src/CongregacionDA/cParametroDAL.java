/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionDA;

import CongregacionBD.p_Parametro_sel;
import CongregacionBE.ParametroBE;
import ejecutar.Coneccion;
import java.util.List;

/**
 *
 * @author Loyola
 */
interface ParametroDAL {
        public List<ParametroBE> Leer(Coneccion strCn,ParametroBE objParametroBE );              
}
public class cParametroDAL implements ParametroDAL{

    public List<ParametroBE> Leer(Coneccion strCn, ParametroBE objParametroBE) {
        p_Parametro_sel Parametro_sel=new p_Parametro_sel(strCn,objParametroBE);
        return Parametro_sel.getaParametroBE();
    }
   
}