/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionBL;

import CongregacionBE.UsuarioBE;
import CongregacionDA.cUsuarioDA;
import ejecutar.Coneccion;
import java.sql.Connection;

/**
 *
 * @author Loyola
 */
//******************************************************************************
interface UsuarioBL {
    public int Insertar(Coneccion strCn,UsuarioBE objUsuarioBE );
    public int Insertar(Connection strCn,UsuarioBE objUsuarioBE );
    public int Eliminar(Coneccion strCn,UsuarioBE objUsuarioBE );
    public int Actualizar(Coneccion strCn,UsuarioBE objUsuarioBE );
}
//******************************************************************************
public class cUsuarioBL implements UsuarioBL{

    @Override
    public int Insertar(Coneccion strCn, UsuarioBE objUsuarioBE) {
        cUsuarioDA usuarioDA = new cUsuarioDA();
        return usuarioDA.Insertar(strCn, objUsuarioBE);
    }
    @Override
    public int Insertar(Connection strCn, UsuarioBE objUsuarioBE) {
        cUsuarioDA usuarioDA = new cUsuarioDA();
        return usuarioDA.Insertar(strCn, objUsuarioBE);
    }
    @Override
    public int Eliminar(Coneccion strCn, UsuarioBE objUsuarioBE) {
        cUsuarioDA usuarioDA = new cUsuarioDA();
        return usuarioDA.Eliminar(strCn, objUsuarioBE);
    }

    @Override
    public int Actualizar(Coneccion strCn, UsuarioBE objUsuarioBE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}