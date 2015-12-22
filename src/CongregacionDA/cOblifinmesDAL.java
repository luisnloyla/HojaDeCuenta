/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionDA;

import CongregacionBD.p_Oblifinmes_sel;
import CongregacionBE.OblifinmesBE;
import ejecutar.Coneccion;
import java.sql.Connection;

/**
 *
 * @author Loyola
 */
interface OblifinmesDAL {
        public int Leer(Coneccion strCn,OblifinmesBE objOblifinmesBE );
        public int Leer(Connection strCn,OblifinmesBE objOblifinmesBE );
}
public class cOblifinmesDAL implements OblifinmesDAL{

    @Override
    public int Leer(Coneccion strCn, OblifinmesBE objOblifinmesBE) {
        p_Oblifinmes_sel Oblifinmes_sel=new p_Oblifinmes_sel(strCn,objOblifinmesBE);
        return Oblifinmes_sel.getReturnVal();
    }

    @Override
    public int Leer(Connection strCn, OblifinmesBE objOblifinmesBE) {
        p_Oblifinmes_sel Oblifinmes_sel=new p_Oblifinmes_sel(strCn,objOblifinmesBE);
        return Oblifinmes_sel.getReturnVal();
    }
   
}
