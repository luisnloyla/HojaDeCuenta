package HojaDeCuentaDA;
import HojaDeCuentaBD.p_Mensual_del;
import HojaDeCuentaBD.p_Mensual_ins;
import HojaDeCuentaBD.p_Mensual_upd;
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
import HojaDeCuentaBE.MensualBE;
import ejecutar.Coneccion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
interface MensualDA {
        public int Insertar(Coneccion strCn,MensualBE objMensualBE );
        public int Insertar(Connection strCn,MensualBE objMensualBE );
        public int Eliminar(Coneccion strCn,MensualBE objMensualBE );
        public int Actualizar(Coneccion strCn,MensualBE objMensualBE );        
}
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
public class cMensualDA implements MensualDA{
    @Override
    public int Insertar(Coneccion strCn, MensualBE objMensualBE) {
        p_Mensual_ins Mensual_ins;
        try {
            Mensual_ins = new p_Mensual_ins(strCn,objMensualBE);
            return Mensual_ins.getReturVal();
        } catch (SQLException ex) {
            Logger.getLogger(cMensualDA.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    @Override
    public int Insertar(Connection strCn, MensualBE objMensualBE) {
        p_Mensual_ins Mensual_ins=new p_Mensual_ins(strCn,objMensualBE);
        return Mensual_ins.getReturVal();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int Eliminar(Coneccion strCn, MensualBE objMensualBE) {
        p_Mensual_del Mensual_del;
        try {
            Mensual_del = new p_Mensual_del(strCn,objMensualBE);
            return Mensual_del.getReturVal();
        } catch (SQLException ex) {
            Logger.getLogger(cMensualDA.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }        
    }
    @Override
    public int Actualizar(Coneccion strCn, MensualBE objMensualBE) {
        try {
            p_Mensual_upd Mensual_upd=new p_Mensual_upd(strCn,objMensualBE);
            return Mensual_upd.getReturVal();
        } catch (SQLException ex) {
            Logger.getLogger(cMensualDA.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }    
   
}
