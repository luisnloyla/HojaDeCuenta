/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuentaDA;
import HojaDeCuentaBD.p_Automatico_sel;
import HojaDeCuentaBE.AutomaticoBE;
import ejecutar.Coneccion;
import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Loyola
 */
interface AutomaticoDAL {
        public List<AutomaticoBE> Leer(Coneccion strCn,AutomaticoBE objAutomaticoBE );
        public float LeerValor(Coneccion strCn,AutomaticoBE objAutomaticoBE );
}
public class cAutomaticoDAL implements AutomaticoDAL{

    @Override
    public List<AutomaticoBE> Leer(Coneccion strCn, AutomaticoBE objAutomaticoBE) {
        try {
            p_Automatico_sel Automatico_sel=new p_Automatico_sel(strCn,objAutomaticoBE);
            return Automatico_sel.getaAutomaticoBE();
        } catch (SQLException ex) {
            Logger.getLogger(cAutomaticoDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public float LeerValor(Coneccion strCn, AutomaticoBE objAutomaticoBE) {
        try {
            p_Automatico_sel Automatico_sel=new p_Automatico_sel(strCn,objAutomaticoBE);
            return Automatico_sel.getValor();
        } catch (SQLException ex) {
            Logger.getLogger(cAutomaticoDAL.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
   
}
