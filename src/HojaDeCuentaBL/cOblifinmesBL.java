/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuentaBL;

import HojaDeCuentaBE.MensualBE;
import HojaDeCuentaBE.OblifinmesBE;
import HojaDeCuentaDA.cMensualDA;
import HojaDeCuentaDA.cOblifinmesDA;
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
interface OblifinmesBL {
    public int Insertar(Coneccion strCn,OblifinmesBE objOblifinmesBE );
    public int Insertar(Connection strCn,OblifinmesBE objOblifinmesBE );
    public int Insertar(Coneccion strCn,OblifinmesBE objOblifinmesBE,MensualBE objMensualBE);
    public int Eliminar(Coneccion strCn,OblifinmesBE objOblifinmesBE );
    public int Actualizar(Coneccion strCn,OblifinmesBE objOblifinmesBE );    
    public int Actualizar(Coneccion strCn,OblifinmesBE objOblifinmesBE,MensualBE objMensualBE);
}
//******************************************************************************
public class cOblifinmesBL implements OblifinmesBL{

    @Override
    public int Insertar(Coneccion strCn, OblifinmesBE objOblifinmesBE) {
        cOblifinmesDA OblifinmesDA = new cOblifinmesDA();
        return OblifinmesDA.Insertar(strCn, objOblifinmesBE);
    }
    @Override
    public int Insertar(Connection strCn, OblifinmesBE objOblifinmesBE) {
        cOblifinmesDA OblifinmesDA = new cOblifinmesDA();
        return OblifinmesDA.Insertar(strCn, objOblifinmesBE);
    }
    @Override
    public int Insertar(Coneccion strCn, OblifinmesBE objOblifinmesBE, MensualBE objMensualBE) {
        Connection con = strCn.getCon();
        try {
            try {
                con.setAutoCommit(false);
                cOblifinmesDA OblifinmesDA = new cOblifinmesDA();
                int id = OblifinmesDA.Insertar(con, objOblifinmesBE);
                if (id<0) {
                    throw new UnsupportedOperationException("error al insertar OblifinmesDA");
                }
                cMensualDA objMensualDA = new cMensualDA();
                if (objMensualDA.Actualizar(con, objMensualBE)<0) {
                    throw new UnsupportedOperationException("error al insertar objMensualDA");
                }
                con.commit();
                con.setAutoCommit(true);
                return id;
            } catch (SQLException ex) {
                Logger.getLogger(cOblifinmesBL.class.getName()).log(Level.SEVERE, null, ex);
                con.rollback();
                con.setAutoCommit(true);
                return -1;
            }
        } catch (Exception ex) {
            return -1;
        }
    }
    @Override
    public int Actualizar(Coneccion strCn, OblifinmesBE objOblifinmesBE) {
        cOblifinmesDA OblifinmesDA = new cOblifinmesDA();
        return OblifinmesDA.Actualizar(strCn, objOblifinmesBE);
    }

    @Override
    public int Actualizar(Coneccion strCn, OblifinmesBE objOblifinmesBE, MensualBE objMensualBE) {
        Connection con = strCn.getCon();
        try {
            try {
                con.setAutoCommit(false);
                cOblifinmesDA OblifinmesDA = new cOblifinmesDA();
                int id = OblifinmesDA.Actualizar(con, objOblifinmesBE);
                if (id<0) {
                    throw new UnsupportedOperationException("error al actualizar OblifinmesDA");
                }
                cMensualDA objMensualDA = new cMensualDA();
                if (objMensualDA.Actualizar(con, objMensualBE)<0) {
                    throw new UnsupportedOperationException("error al actualizar objMensualDA");
                }
                con.commit();
                con.setAutoCommit(true);
                return id;
            } catch (SQLException ex) {
                Logger.getLogger(cOblifinmesBL.class.getName()).log(Level.SEVERE, null, ex);
                con.rollback();
                con.setAutoCommit(true);
                return -1;
            }
        } catch (Exception ex) {
            return -1;
        }
    }
    @Override
    public int Eliminar(Coneccion strCn, OblifinmesBE objOblifinmesBE) {
        cOblifinmesDA OblifinmesDA = new cOblifinmesDA();
        return OblifinmesDA.Eliminar(strCn, objOblifinmesBE);
    }
}
