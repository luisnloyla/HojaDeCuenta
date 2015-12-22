package CongregacionDA;
import CongregacionBD.p_Dccorriente_del;
import CongregacionBD.p_Dccorriente_ins;
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
import CongregacionBE.DccorrienteBE;
import ejecutar.Coneccion;
import java.sql.Connection;
interface DccorrienteDA {
        public int Insertar(Coneccion strCn,DccorrienteBE objDccorrienteBE );
        public int Insertar(Connection strCn,DccorrienteBE objDccorrienteBE );
        public int Eliminar(Coneccion strCn,DccorrienteBE objDccorrienteBE );
        public int Actualizar(Coneccion strCn,DccorrienteBE objDccorrienteBE );
}
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
public class cDccorrienteDA implements DccorrienteDA{
    @Override
    public int Insertar(Coneccion strCn, DccorrienteBE objDccorrienteBE) {
        p_Dccorriente_ins Dccorriente_ins=new p_Dccorriente_ins(strCn,objDccorrienteBE);
        return Dccorriente_ins.getReturnVal();
    }
    @Override
    public int Insertar(Connection strCn, DccorrienteBE objDccorrienteBE) {
        p_Dccorriente_ins Dccorriente_ins=new p_Dccorriente_ins(strCn,objDccorrienteBE);
        return Dccorriente_ins.getReturnVal();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int Eliminar(Coneccion strCn, DccorrienteBE objDccorrienteBE) {
        p_Dccorriente_del Dccorriente_del=new p_Dccorriente_del(strCn,objDccorrienteBE);
        return Dccorriente_del.getReturnVal();
    }
    @Override
    public int Actualizar(Coneccion strCn, DccorrienteBE objDccorrienteBE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
   
}
