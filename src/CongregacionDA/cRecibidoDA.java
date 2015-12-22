package CongregacionDA;
import CongregacionBD.p_Recibido_del;
import CongregacionBD.p_Recibido_ins;
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
import CongregacionBE.RecibidoBE;
import ejecutar.Coneccion;
import java.sql.Connection;
interface RecibidoDA {
        public int Insertar(Coneccion strCn,RecibidoBE objRecibidoBE );
        public int Insertar(Connection strCn,RecibidoBE objRecibidoBE );
        public int Eliminar(Coneccion strCn,RecibidoBE objRecibidoBE );
        public int Actualizar(Coneccion strCn,RecibidoBE objRecibidoBE );
}
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
public class cRecibidoDA implements RecibidoDA{
    @Override
    public int Insertar(Coneccion strCn, RecibidoBE objRecibidoBE) {
        p_Recibido_ins Recibido_ins=new p_Recibido_ins(strCn,objRecibidoBE);
        return Recibido_ins.getReturVal();
    }
    @Override
    public int Insertar(Connection strCn, RecibidoBE objRecibidoBE) {
        p_Recibido_ins Recibido_ins=new p_Recibido_ins(strCn,objRecibidoBE);
        return Recibido_ins.getReturVal();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int Eliminar(Coneccion strCn, RecibidoBE objRecibidoBE) {
        p_Recibido_del Recibido_del=new p_Recibido_del(strCn,objRecibidoBE);
        return Recibido_del.getReturVal();
    }
    @Override
    public int Actualizar(Coneccion strCn, RecibidoBE objRecibidoBE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
   
}
