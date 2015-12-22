package CongregacionDA;
import CongregacionBD.p_Mensual_sel;
import CongregacionBE.MensualBE;
import ejecutar.Coneccion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Loyola
 */
interface MensualDAL {
        public List<MensualBE> Leer(Coneccion strCn,MensualBE objMensualBE );
        public List<MensualBE> Leer(Connection strCn,MensualBE objMensualBE );
}
public class cMensualDAL implements MensualDAL{
    @Override
    public List<MensualBE> Leer(Coneccion strCn, MensualBE objMensualBE) {
        p_Mensual_sel Mensual_sel;
        try {
            Mensual_sel = new p_Mensual_sel(strCn,objMensualBE);
            return Mensual_sel.getaMensualBE();
        } catch (SQLException ex) {
            Logger.getLogger(cMensualDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    @Override
    public List<MensualBE> Leer(Connection strCn, MensualBE objMensualBE) {
        p_Mensual_sel Mensual_sel=new p_Mensual_sel(strCn,objMensualBE);
        return Mensual_sel.getaMensualBE();
    }
}
