/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuentaBL;

import HojaDeCuentaBE.MensualBE;
import HojaDeCuentaBE.AutomaticoBE;
import HojaDeCuentaDA.cMensualDA;
import HojaDeCuentaDA.cAutomaticoDA;
import ejecutar.Coneccion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Loyola
 */
//******************************************************************************
interface AutomaticoBL {
    public int Insertar(Coneccion strCn,AutomaticoBE objAutomaticoBE );
    public int Insertar(Connection strCn,AutomaticoBE objAutomaticoBE );
    public int Insertar(Coneccion strCn,AutomaticoBE objAutomaticoBE,MensualBE objMensualBE);
    public int Eliminar(Coneccion strCn,AutomaticoBE objAutomaticoBE );
    public int Actualizar(Coneccion strCn,AutomaticoBE objAutomaticoBE );    
    public int Actualizar(Coneccion strCn,AutomaticoBE objAutomaticoBE,MensualBE objMensualBE);
}
//******************************************************************************
public class cAutomaticoBL implements AutomaticoBL{

    @Override
    public int Insertar(Coneccion strCn, AutomaticoBE objAutomaticoBE) {
        cAutomaticoDA AutomaticoDA = new cAutomaticoDA();
        return AutomaticoDA.Insertar(strCn, objAutomaticoBE);
    }
    @Override
    public int Insertar(Connection strCn, AutomaticoBE objAutomaticoBE) {
        cAutomaticoDA AutomaticoDA = new cAutomaticoDA();
        return AutomaticoDA.Insertar(strCn, objAutomaticoBE);
    }
    @Override
    public int Insertar(Coneccion strCn, AutomaticoBE objAutomaticoBE, MensualBE objMensualBE) {
        Connection con = strCn.getCon();
        try {
            try {
                con.setAutoCommit(false);
                cAutomaticoDA AutomaticoDA = new cAutomaticoDA();
                int id = AutomaticoDA.Insertar(con, objAutomaticoBE);
                if (id<0) {
                    throw new UnsupportedOperationException("error al insertar AutomaticoDA");
                }
                cMensualDA objMensualDA = new cMensualDA();
                if (objMensualDA.Actualizar(con, objMensualBE)<0) {
                    throw new UnsupportedOperationException("error al insertar objMensualDA");
                }
                con.commit();
                con.setAutoCommit(true);
                return id;
            } catch (SQLException ex) {
                Logger.getLogger(cAutomaticoBL.class.getName()).log(Level.SEVERE, null, ex);
                con.rollback();
                con.setAutoCommit(true);
                return -1;
            }
        } catch (Exception ex) {
            return -1;
        }
    }
    @Override
    public int Actualizar(Coneccion strCn, AutomaticoBE objAutomaticoBE) {
        cAutomaticoDA AutomaticoDA = new cAutomaticoDA();
        return AutomaticoDA.Actualizar(strCn, objAutomaticoBE);
    }

    @Override
    public int Actualizar(Coneccion strCn, AutomaticoBE objAutomaticoBE, MensualBE objMensualBE) {
        Connection con = strCn.getCon();
        try {
            try {
                con.setAutoCommit(false);
                cAutomaticoDA AutomaticoDA = new cAutomaticoDA();
                int id = AutomaticoDA.Actualizar(con, objAutomaticoBE);
                if (id<0) {
                    throw new UnsupportedOperationException("error al actualizar AutomaticoDA");
                }
                cMensualDA objMensualDA = new cMensualDA();
                if (objMensualDA.Actualizar(con, objMensualBE)<0) {
                    throw new UnsupportedOperationException("error al actualizar objMensualDA");
                }
                con.commit();
                con.setAutoCommit(true);
                return id;
            } catch (SQLException ex) {
                Logger.getLogger(cAutomaticoBL.class.getName()).log(Level.SEVERE, null, ex);
                con.rollback();
                con.setAutoCommit(true);
                return -1;
            }
        } catch (Exception ex) {
            return -1;
        }
    }
    @Override
    public int Eliminar(Coneccion strCn, AutomaticoBE objAutomaticoBE) {
        cAutomaticoDA AutomaticoDA = new cAutomaticoDA();
        return AutomaticoDA.Eliminar(strCn, objAutomaticoBE);
    }
}
