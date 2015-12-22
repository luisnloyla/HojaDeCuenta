/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionDA;

import CongregacionBD.p_Otro_sel;
import CongregacionBE.OtroBE;
import ejecutar.Coneccion;
import java.sql.Connection;

/**
 *
 * @author Loyola
 */
interface OtroDAL {
        public int Leer(Coneccion strCn,OtroBE objOtroBE );
        public int Leer(Connection strCn,OtroBE objOtroBE );
}
public class cOtroDAL implements OtroDAL{

    @Override
    public int Leer(Coneccion strCn, OtroBE objOtroBE) {
        p_Otro_sel Otro_sel=new p_Otro_sel(strCn,objOtroBE);
        return Otro_sel.getReturnVal();
    }

    @Override
    public int Leer(Connection strCn, OtroBE objOtroBE) {
        p_Otro_sel Otro_sel=new p_Otro_sel(strCn,objOtroBE);
        return Otro_sel.getReturnVal();
    }
   
}
