/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuenta.TB.Class;

import HojaDeCuentaBE.*;
import java.util.Date;

/**
 *
 * @author Loyola
 */
public class MensualBE {
    private int Accion;
    private int Id_Mensual ;
    private Date Fecha;    

    private float Saldoanteriorr ;
    private float Entradar ;
    private float Salidar ;
    private float Saldorestanter ;

    private float Saldoanteriorcc ;
    private float Entradacc ;
    private float Salidacc ;
    private float Saldorestantecc ;
    
    private float Saldoanterioro ;
    private float Entradao ;
    private float Salidao ;
    private float Saldorestanteo ;

    private float Totfondmes ;
    private float Totactual ;
    private float Totplazo ;
    
    private int Guardado ;
    private int Estableser ;
    private String Flagactivo ;
    
    private int ReturnVal ;

    public MensualBE(int Accion, int Id_Mensual, Date Fecha, float Saldoanteriorr, float Entradar, float Salidar, float Saldorestanter, float Saldoanteriorcc, float Entradacc, float Salidacc, float Saldorestantecc, float Saldoanterioro, float Entradao, float Salidao, float Saldorestanteo, float Totfondmes, float Totactual, float Totplazo, int Guardado, int Estableser, String Flagactivo) {
        this.Accion = Accion;
        this.Id_Mensual = Id_Mensual;
        this.Fecha = Fecha;
        this.Saldoanteriorr = Saldoanteriorr;
        this.Entradar = Entradar;
        this.Salidar = Salidar;
        this.Saldorestanter = Saldorestanter;
        this.Saldoanteriorcc = Saldoanteriorcc;
        this.Entradacc = Entradacc;
        this.Salidacc = Salidacc;
        this.Saldorestantecc = Saldorestantecc;
        this.Saldoanterioro = Saldoanterioro;
        this.Entradao = Entradao;
        this.Salidao = Salidao;
        this.Saldorestanteo = Saldorestanteo;
        this.Totfondmes = Totfondmes;
        this.Totactual = Totactual;
        this.Totplazo = Totplazo;
        this.Guardado = Guardado;
        this.Estableser = Estableser;
        this.Flagactivo = Flagactivo;
    }   
    
    public int getAccion() {
        return Accion;
    }

    public void setAccion(int Accion) {
        this.Accion = Accion;
    }

    public int getId_Mensual() {
        return Id_Mensual;
    }

    public void setId_Mensual(int Id_Mensual) {
        this.Id_Mensual = Id_Mensual;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public float getSaldoanteriorr() {
        return Saldoanteriorr;
    }

    public void setSaldoanteriorr(float Saldoanteriorr) {
        this.Saldoanteriorr = Saldoanteriorr;
    }

    public float getEntradar() {
        return Entradar;
    }

    public void setEntradar(float Entradar) {
        this.Entradar = Entradar;
    }

    public float getSalidar() {
        return Salidar;
    }

    public void setSalidar(float Salidar) {
        this.Salidar = Salidar;
    }

    public float getSaldorestanter() {
        return Saldorestanter;
    }

    public void setSaldorestanter(float Saldorestanter) {
        this.Saldorestanter = Saldorestanter;
    }

    public float getSaldoanteriorcc() {
        return Saldoanteriorcc;
    }

    public void setSaldoanteriorcc(float Saldoanteriorcc) {
        this.Saldoanteriorcc = Saldoanteriorcc;
    }

    public float getEntradacc() {
        return Entradacc;
    }

    public void setEntradacc(float Entradacc) {
        this.Entradacc = Entradacc;
    }

    public float getSalidacc() {
        return Salidacc;
    }

    public void setSalidacc(float Salidacc) {
        this.Salidacc = Salidacc;
    }

    public float getSaldorestantecc() {
        return Saldorestantecc;
    }

    public void setSaldorestantecc(float Saldorestantecc) {
        this.Saldorestantecc = Saldorestantecc;
    }

    public float getSaldoanterioro() {
        return Saldoanterioro;
    }

    public void setSaldoanterioro(float Saldoanterioro) {
        this.Saldoanterioro = Saldoanterioro;
    }

    public float getEntradao() {
        return Entradao;
    }

    public void setEntradao(float Entradao) {
        this.Entradao = Entradao;
    }

    public float getSalidao() {
        return Salidao;
    }

    public void setSalidao(float Salidao) {
        this.Salidao = Salidao;
    }

    public float getSaldorestanteo() {
        return Saldorestanteo;
    }

    public void setSaldorestanteo(float Saldorestanteo) {
        this.Saldorestanteo = Saldorestanteo;
    }

    public float getTotfondmes() {
        return Totfondmes;
    }

    public void setTotfondmes(float Totfondmes) {
        this.Totfondmes = Totfondmes;
    }

    public float getTotactual() {
        return Totactual;
    }

    public void setTotactual(float Totactual) {
        this.Totactual = Totactual;
    }

    public float getTotplazo() {
        return Totplazo;
    }

    public void setTotplazo(float Totplazo) {
        this.Totplazo = Totplazo;
    }

    public int getGuardado() {
        return Guardado;
    }

    public void setGuardado(int Guardado) {
        this.Guardado = Guardado;
    }

    public int getEstableser() {
        return Estableser;
    }

    public void setEstableser(int Estableser) {
        this.Estableser = Estableser;
    }

    public String getFlagactivo() {
        return Flagactivo;
    }

    public void setFlagactivo(String Flagactivo) {
        this.Flagactivo = Flagactivo;
    }

    public int getReturnVal() {
        return ReturnVal;
    }

    public void setReturnVal(int ReturnVal) {
        this.ReturnVal = ReturnVal;
    }
}
