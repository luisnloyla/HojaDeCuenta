/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionBL;

import CongregacionBE.ParametroBE;
import CongregacionDA.cParametroDAL;
import ejecutar.Coneccion;
import java.util.List;

/**
 *
 * @author Loyola
 */
interface ParametroBLL {
    public List<ParametroBE> Leer(Coneccion strCn,ParametroBE objParametroBE );
}
public class cParametroBLL implements ParametroBLL{

    @Override
    public List<ParametroBE> Leer(Coneccion strCn, ParametroBE objParametroBE) {
        cParametroDAL ParametroDAL = new cParametroDAL();
        return ParametroDAL.Leer(strCn, objParametroBE);
    }

   
}
