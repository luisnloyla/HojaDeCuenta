/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionBL;

import CongregacionBE.ParametroBE;
import CongregacionDA.cParametroDA;
import ejecutar.Coneccion;
import java.sql.Connection;

/**
 *
 * @author Loyola
 */
//******************************************************************************
interface ParametroBL {
    public int Insertar(Coneccion strCn,ParametroBE objParametroBE );
    public int Insertar(Connection strCn,ParametroBE objParametroBE );
    public int Eliminar(Coneccion strCn,ParametroBE objParametroBE );
    public int Actualizar(Coneccion strCn,ParametroBE objParametroBE );
}
//******************************************************************************
public class cParametroBL implements ParametroBL{

    @Override
    public int Insertar(Coneccion strCn, ParametroBE objParametroBE) {
        cParametroDA ParametroDA = new cParametroDA();
        return ParametroDA.Insertar(strCn, objParametroBE);
    }
    @Override
    public int Insertar(Connection strCn, ParametroBE objParametroBE) {
        cParametroDA ParametroDA = new cParametroDA();
        return ParametroDA.Insertar(strCn, objParametroBE);
    }
    @Override
    public int Eliminar(Coneccion strCn, ParametroBE objParametroBE) {
        cParametroDA ParametroDA = new cParametroDA();
        return ParametroDA.Eliminar(strCn, objParametroBE);
    }

    @Override
    public int Actualizar(Coneccion strCn, ParametroBE objParametroBE) {
        cParametroDA ParametroDA = new cParametroDA();
        return ParametroDA.Actualizar(strCn, objParametroBE);
    }
}