package HojaDeCuentaDA;
import HojaDeCuentaBD.p_Oblifinmes_del;
import HojaDeCuentaBD.p_Oblifinmes_ins;
import HojaDeCuentaBD.p_Oblifinmes_upd;
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
import HojaDeCuentaBE.OblifinmesBE;
import ejecutar.Coneccion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
interface OblifinmesDA {
        public int Insertar(Coneccion strCn,OblifinmesBE objOblifinmesBE );
        public int Insertar(Connection strCn,OblifinmesBE objOblifinmesBE );
        public int Eliminar(Coneccion strCn,OblifinmesBE objOblifinmesBE );
        public int Actualizar(Coneccion strCn,OblifinmesBE objOblifinmesBE );
        public int Actualizar(Connection strCn,OblifinmesBE objOblifinmesBE );
}
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
public class cOblifinmesDA implements OblifinmesDA{
    @Override
    public int Insertar(Coneccion strCn, OblifinmesBE objOblifinmesBE) {
        try {
            p_Oblifinmes_ins Oblifinmes_ins=new p_Oblifinmes_ins(strCn,objOblifinmesBE);
            return Oblifinmes_ins.getReturnVal();
        } catch (SQLException ex) {
            Logger.getLogger(cOblifinmesDA.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
    }
    @Override
    public int Insertar(Connection strCn, OblifinmesBE objOblifinmesBE) {
        try {
            p_Oblifinmes_ins Oblifinmes_ins=new p_Oblifinmes_ins(strCn,objOblifinmesBE);
            return Oblifinmes_ins.getReturnVal();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            return -1;
        }
    }
    @Override
    public int Eliminar(Coneccion strCn, OblifinmesBE objOblifinmesBE) {
        try {
            p_Oblifinmes_del Oblifinmes_del=new p_Oblifinmes_del(strCn,objOblifinmesBE);
            return Oblifinmes_del.getReturnVal();
        } catch (SQLException ex) {
            Logger.getLogger(cOblifinmesDA.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    @Override
    public int Actualizar(Coneccion strCn, OblifinmesBE objOblifinmesBE) {
        try {
            p_Oblifinmes_upd oblifinmes_upd=new p_Oblifinmes_upd(strCn,objOblifinmesBE);
            return oblifinmes_upd.getReturnVal();
        } catch (SQLException ex) {
            return -1;
        }
    } 

    @Override
    public int Actualizar(Connection strCn, OblifinmesBE objOblifinmesBE) {
        try {
            p_Oblifinmes_upd oblifinmes_upd=new p_Oblifinmes_upd(strCn,objOblifinmesBE);
            return oblifinmes_upd.getReturnVal();
        } catch (SQLException ex) {
            return -1;
        }
    }
   
}