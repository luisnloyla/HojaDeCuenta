package CongregacionDA;
import CongregacionBD.p_Oblifinmes_del;
import CongregacionBD.p_Oblifinmes_ins;
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
import CongregacionBE.OblifinmesBE;
import ejecutar.Coneccion;
import java.sql.Connection;
interface OblifinmesDA {
        public int Insertar(Coneccion strCn,OblifinmesBE objOblifinmesBE );
        public int Insertar(Connection strCn,OblifinmesBE objOblifinmesBE );
        public int Eliminar(Coneccion strCn,OblifinmesBE objOblifinmesBE );
        public int Actualizar(Coneccion strCn,OblifinmesBE objOblifinmesBE );
}
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
public class cOblifinmesDA implements OblifinmesDA{
    @Override
    public int Insertar(Coneccion strCn, OblifinmesBE objOblifinmesBE) {
        p_Oblifinmes_ins Oblifinmes_ins=new p_Oblifinmes_ins(strCn,objOblifinmesBE);
        return Oblifinmes_ins.getReturnVal();
    }
    @Override
    public int Insertar(Connection strCn, OblifinmesBE objOblifinmesBE) {
        p_Oblifinmes_ins Oblifinmes_ins=new p_Oblifinmes_ins(strCn,objOblifinmesBE);
        return Oblifinmes_ins.getReturnVal();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int Eliminar(Coneccion strCn, OblifinmesBE objOblifinmesBE) {
        p_Oblifinmes_del Oblifinmes_del=new p_Oblifinmes_del(strCn,objOblifinmesBE);
        return Oblifinmes_del.getReturnVal();
    }
    @Override
    public int Actualizar(Coneccion strCn, OblifinmesBE objOblifinmesBE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
   
}