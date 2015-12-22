/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuentaDA;

import HojaDeCuentaBD.p_Dccorriente_sel;
import HojaDeCuentaBE.DccorrienteBE;
import ejecutar.Coneccion;
import java.sql.Connection;

/**
 *
 * @author Loyola
 */
interface DccorrienteDAL {
        public int Leer(Coneccion strCn,DccorrienteBE objDccorrienteBE );
        public int Leer(Connection strCn,DccorrienteBE objDccorrienteBE );
}
public class cDccorrienteDAL implements DccorrienteDAL{

    @Override
    public int Leer(Coneccion strCn, DccorrienteBE objDccorrienteBE) {
        p_Dccorriente_sel Dccorriente_sel=new p_Dccorriente_sel(strCn,objDccorrienteBE);
        return Dccorriente_sel.getReturnVal();
    }

    @Override
    public int Leer(Connection strCn, DccorrienteBE objDccorrienteBE) {
        p_Dccorriente_sel Dccorriente_sel=new p_Dccorriente_sel(strCn,objDccorrienteBE);
        return Dccorriente_sel.getReturnVal();
    }
   
}
