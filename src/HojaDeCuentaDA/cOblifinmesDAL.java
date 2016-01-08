/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuentaDA;
import HojaDeCuentaBD.p_Oblifinmes_sel;
import HojaDeCuentaBE.OblifinmesBE;
import ejecutar.Coneccion;
import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Loyola
 */
interface OblifinmesDAL {
        public List<OblifinmesBE> Leer(Coneccion strCn,OblifinmesBE objOblifinmesBE );
}
public class cOblifinmesDAL implements OblifinmesDAL{

    @Override
    public List<OblifinmesBE> Leer(Coneccion strCn, OblifinmesBE objOblifinmesBE) {
        try {
            p_Oblifinmes_sel Oblifinmes_sel=new p_Oblifinmes_sel(strCn,objOblifinmesBE);
            return Oblifinmes_sel.getaOblifinmesBE();
        } catch (SQLException ex) {
            Logger.getLogger(cOblifinmesDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
   
}
