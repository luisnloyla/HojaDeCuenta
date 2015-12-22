package CongregacionDA;
import CongregacionBD.p_Otro_del;
import CongregacionBD.p_Otro_ins;
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
import CongregacionBE.OtroBE;
import ejecutar.Coneccion;
import java.sql.Connection;
interface OtroDA {
        public int Insertar(Coneccion strCn,OtroBE objOtroBE );
        public int Insertar(Connection strCn,OtroBE objOtroBE );
        public int Eliminar(Coneccion strCn,OtroBE objOtroBE );
        public int Actualizar(Coneccion strCn,OtroBE objOtroBE );
}
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
public class cOtroDA implements OtroDA{
    @Override
    public int Insertar(Coneccion strCn, OtroBE objOtroBE) {
        p_Otro_ins Otro_ins=new p_Otro_ins(strCn,objOtroBE);
        return Otro_ins.getReturnVal();
    }
    @Override
    public int Insertar(Connection strCn, OtroBE objOtroBE) {
        p_Otro_ins Otro_ins=new p_Otro_ins(strCn,objOtroBE);
        return Otro_ins.getReturnVal();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int Eliminar(Coneccion strCn, OtroBE objOtroBE) {
        p_Otro_del Otro_del=new p_Otro_del(strCn,objOtroBE);
        return Otro_del.getReturnVal();
    }
    @Override
    public int Actualizar(Coneccion strCn, OtroBE objOtroBE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
   
}
