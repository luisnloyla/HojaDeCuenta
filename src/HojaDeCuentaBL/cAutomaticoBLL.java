/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuentaBL;

import HojaDeCuentaBE.AutomaticoBE;
import HojaDeCuentaDA.cAutomaticoDAL;
import ejecutar.Coneccion;
import java.util.List;

/**
 *
 * @author Loyola
 */
interface AutomaticoBLL {
    public List<AutomaticoBE> Leer(Coneccion strCn,AutomaticoBE objAutomaticoBE );
}
public class cAutomaticoBLL implements AutomaticoBLL{
    @Override
    public List<AutomaticoBE> Leer(Coneccion strCn, AutomaticoBE objAutomaticoBE) {
        cAutomaticoDAL AutomaticoDAL = new cAutomaticoDAL();
        return AutomaticoDAL.Leer(strCn, objAutomaticoBE);
    }
}
