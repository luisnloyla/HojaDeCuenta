package HojaDeCuentaDA;
import HojaDeCuentaBD.p_Automatico_del;
import HojaDeCuentaBD.p_Automatico_ins;
import HojaDeCuentaBD.p_Automatico_upd;
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
import HojaDeCuentaBE.AutomaticoBE;
import ejecutar.Coneccion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
interface AutomaticoDA {
        public int Insertar(Coneccion strCn,AutomaticoBE objAutomaticoBE );
        public int Insertar(Connection strCn,AutomaticoBE objAutomaticoBE );
        public int Eliminar(Coneccion strCn,AutomaticoBE objAutomaticoBE );
        public int Actualizar(Coneccion strCn,AutomaticoBE objAutomaticoBE );
        public int Actualizar(Connection strCn,AutomaticoBE objAutomaticoBE );
}
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
public class cAutomaticoDA implements AutomaticoDA{
    @Override
    public int Insertar(Coneccion strCn, AutomaticoBE objAutomaticoBE) {
        try {
            p_Automatico_ins Automatico_ins=new p_Automatico_ins(strCn,objAutomaticoBE);
            return Automatico_ins.getReturnVal();
        } catch (SQLException ex) {
            Logger.getLogger(cAutomaticoDA.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
    }
    @Override
    public int Insertar(Connection strCn, AutomaticoBE objAutomaticoBE) {
        try {
            p_Automatico_ins Automatico_ins=new p_Automatico_ins(strCn,objAutomaticoBE);
            return Automatico_ins.getReturnVal();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            return -1;
        }
    }
    @Override
    public int Eliminar(Coneccion strCn, AutomaticoBE objAutomaticoBE) {
        try {
            p_Automatico_del Automatico_del=new p_Automatico_del(strCn,objAutomaticoBE);
            return Automatico_del.getReturnVal();
        } catch (SQLException ex) {
            Logger.getLogger(cAutomaticoDA.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    @Override
    public int Actualizar(Coneccion strCn, AutomaticoBE objAutomaticoBE) {
        try {
            p_Automatico_upd Automatico_upd=new p_Automatico_upd(strCn,objAutomaticoBE);
            return Automatico_upd.getReturnVal();
        } catch (SQLException ex) {
            return -1;
        }
    } 

    @Override
    public int Actualizar(Connection strCn, AutomaticoBE objAutomaticoBE) {
        try {
            p_Automatico_upd Automatico_upd=new p_Automatico_upd(strCn,objAutomaticoBE);
            return Automatico_upd.getReturnVal();
        } catch (SQLException ex) {
            return -1;
        }
    }
   
}