/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionBL;

import CongregacionBE.MensualBE;
import CongregacionDA.cMensualDAL;
import ejecutar.Coneccion;
import java.util.List;

/**
 *
 * @author Loyola
 */
interface MensualBLL {
    public List<MensualBE> Leer(Coneccion strCn,MensualBE objMensualBE );
}
public class cMensualBLL implements MensualBLL{
    @Override
    public List<MensualBE> Leer(Coneccion strCn, MensualBE objMensualBE) {
        cMensualDAL MensualDAL = new cMensualDAL();
        return MensualDAL.Leer(strCn, objMensualBE);
    }
}
