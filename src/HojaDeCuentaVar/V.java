/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuentaVar;

import HojaDeCuentaBE.MensualBE;
import HojaDeCuentaBL.cMensualBLL;
import com.toedter.calendar.JDateChooser;
import ejecutar.Coneccion;
//import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lois_
 */
public final class V {
    private boolean Antecesor;//*
    private MensualBE mensualBE;//*
    static final public String actual = "0";
    static final public String largoPlazo = "1";
    static final public String cFlagActivo = "1";
    static final public String cFlagInActivo = "0";
    static final public String cCongregacion = "SAN JUAN PAMPA";
    static final public String cNoGuardado = "0";
    static final public String cGuardado = "1";
    static final public String cACTUAL_LARGOPLAZO = "ALP";
    static public int selleno = 0;
    static public int selleno02 = 0;
    public V() {
        
   }
    
    public V( int Accion,Date date ) throws SQLException {
        this.Antecesor = false;
        this.mensualBE = null;
        MensualBE mensualBE01 = null;
        if (Accion == 1) {//insertar accion 
            mensualBE01 = new MensualBE(4, 0, date, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "1");
        }
        if (Accion==2) {//actualizacion accion
            mensualBE01 = new MensualBE(3, 0, sumarRestarDiasFecha(date, -1), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "1");
        }
        cMensualBLL mensualBLL=new cMensualBLL();
        List<MensualBE> aMensualBE=mensualBLL.Leer(new Coneccion(), mensualBE01);
        for (MensualBE MensualBE02 : aMensualBE) {
            this.Antecesor=true;
            this.mensualBE=MensualBE02;
        }
    }
    public Date sumarRestarDiasFecha(Date fecha, int dias){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); // Configuramos la fecha que se recibe
//        calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
        calendar.add(Calendar.MONTH, dias);
        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
    }
    
    public Date fecha(JDateChooser jdc){
        Date date = new Date();//LUEGO ESOS PARAMATROS LO GUARDAMOS EN UNA VARIABLE
        date = jdc.getDate();
        date.setYear(jdc.getCalendar().get(Calendar.YEAR));
        return date;
    }
    public int numeroMesjdc(JDateChooser jdc){
        return numeroMes(fecha(jdc));
    }
    public int numeroMes(Date fecha){
        return (fecha.getMonth()+1);
    }
    public int numeroAniojdc(JDateChooser jdc){
        return numeroAnio(fecha(jdc));
    }
    public int numeroAnio(Date fecha){
        return (fecha.getYear());
    }
    public int numeroAnioR(Date fecha){//EL AÑO LA FIRME
        return (fecha.getYear()+1900);
    }
    /**
     * @return the Antecesor
     */
    public boolean getAntecesor() {
        return Antecesor;
    }

    /**
     * @param Antecesor the Antecesor to set
     */
    public void setAntecesor(boolean Antecesor) {
        this.Antecesor = Antecesor;
    }

    /**
     * @return the mensualBE
     */
    public MensualBE getMensualBE() {
        return mensualBE;
    }

    /**
     * @param mensualBE the mensualBE to set
     */
    public void setMensualBE(MensualBE mensualBE) {
        this.mensualBE = mensualBE;
    }
    
}