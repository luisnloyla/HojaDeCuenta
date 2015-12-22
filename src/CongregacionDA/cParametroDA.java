package CongregacionDA;
import CongregacionBD.p_Parametro_del;
import CongregacionBD.p_Parametro_ins;
import CongregacionBD.p_Parametro_upd;
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
import CongregacionBE.ParametroBE;
import ejecutar.Coneccion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
interface ParametroDA {
        public int Insertar(Coneccion strCn,ParametroBE objParametroBE );
        public int Insertar(Connection strCn,ParametroBE objParametroBE );
        public int Eliminar(Coneccion strCn,ParametroBE objParametroBE );
        public int Actualizar(Coneccion strCn,ParametroBE objParametroBE );
}
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
public class cParametroDA implements ParametroDA{
    @Override
    public int Insertar(Coneccion strCn, ParametroBE objParametroBE) {
        try {
            p_Parametro_ins Parametro_ins=new p_Parametro_ins(strCn,objParametroBE);
            return Parametro_ins.getReturnVal();
        } catch (SQLException ex) {
            Logger.getLogger(cParametroDA.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    @Override
    public int Insertar(Connection strCn, ParametroBE objParametroBE) {
        p_Parametro_ins Parametro_ins=new p_Parametro_ins(strCn,objParametroBE);
        return Parametro_ins.getReturnVal();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int Eliminar(Coneccion strCn, ParametroBE objParametroBE) {
        try {
            p_Parametro_del Parametro_del=new p_Parametro_del(strCn,objParametroBE);
            return Parametro_del.getReturnVal();
        } catch (SQLException ex) {
            return -1;
        }        
    }
    @Override
    public int Actualizar(Coneccion strCn, ParametroBE objParametroBE) {
        try {
            p_Parametro_upd Parametro_upd=new p_Parametro_upd(strCn,objParametroBE);
            return Parametro_upd.getReturnVal();
        } catch (SQLException ex) {
            return -1;
        }   
    }
}
