/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuentaBL;

import HojaDeCuentaBE.OblifinmesBE;
import HojaDeCuentaDA.cOblifinmesDAL;
import ejecutar.Coneccion;
import java.util.List;

/**
 *
 * @author Loyola
 */
interface OblifinmesBLL {
    public List<OblifinmesBE> Leer(Coneccion strCn,OblifinmesBE objOblifinmesBE );
}
public class cOblifinmesBLL implements OblifinmesBLL{
    @Override
    public List<OblifinmesBE> Leer(Coneccion strCn, OblifinmesBE objOblifinmesBE) {
        cOblifinmesDAL OblifinmesDAL = new cOblifinmesDAL();
        return OblifinmesDAL.Leer(strCn, objOblifinmesBE);
    }
}
