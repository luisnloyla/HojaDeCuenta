/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionDA;

import CongregacionBD.p_DRecibido_sel;
import CongregacionBE.DRecibidoBE;
import ejecutar.Coneccion;
import java.sql.Connection;

/**
 *
 * @author Loyola
 */
interface DRecibidoDAL {
        public int Leer(Coneccion strCn,DRecibidoBE objDRecibidoBE );
        public int Leer(Connection strCn,DRecibidoBE objDRecibidoBE );
}
public class cDRecibidoDAL implements DRecibidoDAL{

    @Override
    public int Leer(Coneccion strCn, DRecibidoBE objDRecibidoBE) {
        p_DRecibido_sel DRecibido_sel=new p_DRecibido_sel(strCn,objDRecibidoBE);
        return DRecibido_sel.getReturnVal();
    }

    @Override
    public int Leer(Connection strCn, DRecibidoBE objDRecibidoBE) {
        p_DRecibido_sel DRecibido_sel=new p_DRecibido_sel(strCn,objDRecibidoBE);
        return DRecibido_sel.getReturnVal();
    }
   
}
