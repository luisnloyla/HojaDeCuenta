/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionBL;

import CongregacionBE.UsuarioBE;
import CongregacionDA.cUsuarioDAL;
import ejecutar.Coneccion;
import java.util.List;

/**
 *
 * @author Loyola
 */
interface UsuarioBLL {
    public List<UsuarioBE> Leer(Coneccion strCn,UsuarioBE objUsuarioBE );
}
public class cUsuarioBLL implements UsuarioBLL{

    @Override
    public List<UsuarioBE> Leer(Coneccion strCn, UsuarioBE objUsuarioBE) {
        cUsuarioDAL usuarioDAL = new cUsuarioDAL();
        return usuarioDAL.Leer(strCn, objUsuarioBE);
    }

   
}
