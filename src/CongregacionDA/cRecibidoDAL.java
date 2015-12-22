/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionDA;

import CongregacionBD.p_Recibido_sel;
import CongregacionBE.RecibidoBE;
import ejecutar.Coneccion;
import java.sql.Connection;

/**
 *
 * @author Loyola
 */
interface RecibidoDAL {
        public int Leer(Coneccion strCn,RecibidoBE objRecibidoBE );
        public int Leer(Connection strCn,RecibidoBE objRecibidoBE );
}
public class cRecibidoDAL implements RecibidoDAL{

    @Override
    public int Leer(Coneccion strCn, RecibidoBE objRecibidoBE) {
        p_Recibido_sel Recibido_sel=new p_Recibido_sel(strCn,objRecibidoBE);
        return Recibido_sel.getReturVal();
    }

    @Override
    public int Leer(Connection strCn, RecibidoBE objRecibidoBE) {
        p_Recibido_sel Recibido_sel=new p_Recibido_sel(strCn,objRecibidoBE);
        return Recibido_sel.getReturVal();
    }
   
}
