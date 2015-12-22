package CongregacionDA;
import CongregacionBD.p_DRecibido_del;
import CongregacionBD.p_DRecibido_ins;
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
import CongregacionBE.DRecibidoBE;
import ejecutar.Coneccion;
import java.sql.Connection;
interface DRecibidoDA {
        public int Insertar(Coneccion strCn,DRecibidoBE objDRecibidoBE );
        public int Insertar(Connection strCn,DRecibidoBE objDRecibidoBE );
        public int Eliminar(Coneccion strCn,DRecibidoBE objDRecibidoBE );
        public int Actualizar(Coneccion strCn,DRecibidoBE objDRecibidoBE );
}
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
public class cDRecibidoDA implements DRecibidoDA{
    @Override
    public int Insertar(Coneccion strCn, DRecibidoBE objDRecibidoBE) {
        p_DRecibido_ins DRecibido_ins=new p_DRecibido_ins(strCn,objDRecibidoBE);
        return DRecibido_ins.getReturnVal();
    }
    @Override
    public int Insertar(Connection strCn, DRecibidoBE objDRecibidoBE) {
        p_DRecibido_ins DRecibido_ins=new p_DRecibido_ins(strCn,objDRecibidoBE);
        return DRecibido_ins.getReturnVal();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int Eliminar(Coneccion strCn, DRecibidoBE objDRecibidoBE) {
        p_DRecibido_del DRecibido_del=new p_DRecibido_del(strCn,objDRecibidoBE);
        return DRecibido_del.getReturnVal();
    }
    @Override
    public int Actualizar(Coneccion strCn, DRecibidoBE objDRecibidoBE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
   
}