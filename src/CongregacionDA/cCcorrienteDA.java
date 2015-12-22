package CongregacionDA;
import CongregacionBD.p_Ccorriente_del;
import CongregacionBD.p_Ccorriente_ins;
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
import CongregacionBE.CcorrienteBE;
import ejecutar.Coneccion;
import java.sql.Connection;
interface CcorrienteDA {
        public int Insertar(Coneccion strCn,CcorrienteBE objCcorrienteBE );
        public int Insertar(Connection strCn,CcorrienteBE objCcorrienteBE );
        public int Eliminar(Coneccion strCn,CcorrienteBE objCcorrienteBE );
        public int Actualizar(Coneccion strCn,CcorrienteBE objCcorrienteBE );
}
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
public class cCcorrienteDA implements CcorrienteDA{
    @Override
    public int Insertar(Coneccion strCn, CcorrienteBE objCcorrienteBE) {
        p_Ccorriente_ins Ccorriente_ins=new p_Ccorriente_ins(strCn,objCcorrienteBE);
        return Ccorriente_ins.getReturVal();
    }
    @Override
    public int Insertar(Connection strCn, CcorrienteBE objCcorrienteBE) {
        p_Ccorriente_ins Ccorriente_ins=new p_Ccorriente_ins(strCn,objCcorrienteBE);
        return Ccorriente_ins.getReturVal();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int Eliminar(Coneccion strCn, CcorrienteBE objCcorrienteBE) {
        p_Ccorriente_del Ccorriente_del=new p_Ccorriente_del(strCn,objCcorrienteBE);
        return Ccorriente_del.getReturVal();
    }
    @Override
    public int Actualizar(Coneccion strCn, CcorrienteBE objCcorrienteBE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
   
}
