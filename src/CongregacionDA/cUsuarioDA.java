package CongregacionDA;
import CongregacionBD.p_Usuario_del;
import CongregacionBD.p_Usuario_ins;
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
import CongregacionBE.UsuarioBE;
import ejecutar.Coneccion;
import java.sql.Connection;
interface UsuarioDA {
        public int Insertar(Coneccion strCn,UsuarioBE objUsuarioBE );
        public int Insertar(Connection strCn,UsuarioBE objUsuarioBE );
        public int Eliminar(Coneccion strCn,UsuarioBE objUsuarioBE );
        public int Actualizar(Coneccion strCn,UsuarioBE objUsuarioBE );
}
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
public class cUsuarioDA implements UsuarioDA{
    @Override
    public int Insertar(Coneccion strCn, UsuarioBE objUsuarioBE) {
        p_Usuario_ins usuario_ins=new p_Usuario_ins(strCn,objUsuarioBE);
        return usuario_ins.getReturVal();
    }
    @Override
    public int Insertar(Connection strCn, UsuarioBE objUsuarioBE) {
        p_Usuario_ins usuario_ins=new p_Usuario_ins(strCn,objUsuarioBE);
        return usuario_ins.getReturVal();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int Eliminar(Coneccion strCn, UsuarioBE objUsuarioBE) {
        p_Usuario_del usuario_del=new p_Usuario_del(strCn,objUsuarioBE);
        return usuario_del.getReturVal();
    }
    @Override
    public int Actualizar(Coneccion strCn, UsuarioBE objUsuarioBE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
   
}