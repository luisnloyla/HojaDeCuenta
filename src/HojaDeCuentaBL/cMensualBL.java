/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuentaBL;

import HojaDeCuentaBE.MensualBE;
import HojaDeCuentaDA.cMensualDA;
import ejecutar.Coneccion;
import java.sql.Connection;

/**
 *
 * @author Loyola
 */
//******************************************************************************
interface MensualBL {
    public int Insertar(Coneccion strCn,MensualBE objMensualBE );
    public int Insertar(Connection strCn,MensualBE objMensualBE );
    public int Eliminar(Coneccion strCn,MensualBE objMensualBE );
    public int Actualizar(Coneccion strCn,MensualBE objMensualBE );
}
//******************************************************************************
public class cMensualBL implements MensualBL{

    @Override
    public int Insertar(Coneccion strCn, MensualBE objMensualBE) {
        cMensualDA MensualDA = new cMensualDA();
        return MensualDA.Insertar(strCn, objMensualBE);
    }
    @Override
    public int Insertar(Connection strCn, MensualBE objMensualBE) {
        cMensualDA MensualDA = new cMensualDA();
        return MensualDA.Insertar(strCn, objMensualBE);
    }
    @Override
    public int Eliminar(Coneccion strCn, MensualBE objMensualBE) {
        cMensualDA MensualDA = new cMensualDA();
        return MensualDA.Eliminar(strCn, objMensualBE);
    }

    @Override
    public int Actualizar(Coneccion strCn, MensualBE objMensualBE) {
        cMensualDA MensualDA = new cMensualDA();
        return MensualDA.Actualizar(strCn, objMensualBE);
    }
}
