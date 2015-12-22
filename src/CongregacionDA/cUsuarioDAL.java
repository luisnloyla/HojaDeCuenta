/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionDA;

import CongregacionBD.p_Usuario_sel;
import CongregacionBE.UsuarioBE;
import ejecutar.Coneccion;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Loyola
 */
interface UsuarioDAL {
        public List<UsuarioBE> Leer(Coneccion strCn,UsuarioBE objUsuarioBE );
        public int Leer(Connection strCn,UsuarioBE objUsuarioBE );
}
public class cUsuarioDAL implements UsuarioDAL{

    @Override
    public List<UsuarioBE> Leer(Coneccion strCn, UsuarioBE objUsuarioBE) {
        p_Usuario_sel usuario_sel=new p_Usuario_sel(strCn,objUsuarioBE);
        return usuario_sel.getaUsuario();
    }

    @Override
    public int Leer(Connection strCn, UsuarioBE objUsuarioBE) {
        p_Usuario_sel usuario_sel=new p_Usuario_sel(strCn,objUsuarioBE);
        return usuario_sel.getReturVal();
    }
   
}
