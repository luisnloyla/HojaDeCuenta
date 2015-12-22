/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionDA;

import CongregacionBD.p_Ccorriente_sel;
import CongregacionBE.CcorrienteBE;
import ejecutar.Coneccion;
import java.sql.Connection;

/**
 *
 * @author Loyola
 */
interface CcorrienteDAL {
        public int Leer(Coneccion strCn,CcorrienteBE objCcorrienteBE );
        public int Leer(Connection strCn,CcorrienteBE objCcorrienteBE );
}
public class cCcorrienteDAL implements CcorrienteDAL{

    @Override
    public int Leer(Coneccion strCn, CcorrienteBE objCcorrienteBE) {
        p_Ccorriente_sel Ccorriente_sel=new p_Ccorriente_sel(strCn,objCcorrienteBE);
        return Ccorriente_sel.getReturVal();
    }

    @Override
    public int Leer(Connection strCn, CcorrienteBE objCcorrienteBE) {
        p_Ccorriente_sel Ccorriente_sel=new p_Ccorriente_sel(strCn,objCcorrienteBE);
        return Ccorriente_sel.getReturVal();
    }
   
}
