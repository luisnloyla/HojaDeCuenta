package HojaDeCuenta;

import HojaDeCuentaBE.MensualBE;
import HojaDeCuentaBE.ParametroBE;
import HojaDeCuentaBE.UsuarioBE;
import HojaDeCuentaBL.cParametroBL;
import HojaDeCuentaBL.cParametroBLL;
import HojaDeCuentaBL.cUsuarioBL;
import HojaDeCuentaVar.V;
import ejecutar.Coneccion;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;


public class Congregacion {

    public Congregacion() {
        try {
//            parametro();
//            parametroInsertar();
            parametroLista();
        } catch (Exception e) {
        }
    }
    public void VuelveACargarLista() //throws SQLException
    {//se cambi de planes solo que cargue un solo registro
//        this.lista = null;
//        MensualBE mensualBE = new MensualBE(5, Integer.parseInt( jsnAnio.getValue()), new Validar().fecha(jdcFecha), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "1");

//        cMensualBLL mensualBLL = new cMensualBLL();
//        this.lista = mensualBLL.Leer(new Coneccion(), mensualBE)

    }
    public static void main(String[] args) throws SQLException {
        
/*
//        for (int i=1000000;i<2000000;i++){
            Coneccion coneccion= new Coneccion();
            Random a = new Random();
            UsuarioBE usuarioBE = new UsuarioBE(1, 0, "MARTE", ""+a.nextFloat()+"", 0);
            cUsuarioBLL usuarioBLL= new cUsuarioBLL();
//            cUsuarioBL usuarioBL= new cUsuarioBL();
            int n=usuarioBLL.Leer(coneccion, usuarioBE);
//            int n2=usuarioBL.Insertar(coneccion, usuarioBE);
            System.out.println(n);
//            System.out.println(n2);
//        }
        */
        /*
        ///@@@@@@@@@@@@@@@@@@@@@@ ELIMINAR @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //        for (int i=1000000;i<2000000;i++){
            Coneccion coneccion= new Coneccion();
            Random a = new Random();
            UsuarioBE usuarioBE = new UsuarioBE(1, 0, "MARTE", ""+a.nextFloat()+"", 0);
            cUsuarioBL usuarioBL= new cUsuarioBL();
//            cUsuarioBL usuarioBL= new cUsuarioBL();
            int n=usuarioBL.Eliminar(coneccion, usuarioBE);
//            int n2=usuarioBL.Insertar(coneccion, usuarioBE);
            System.out.println(n);
//            System.out.println(n2);
//        }
            */
        ///@@@@@@@@@@@@@@@@@@@@@@ INSERTAR @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
////                for (int i=1000000;i<2000000;i++){
//            Coneccion coneccion= new Coneccion();
//            Random a = new Random();
//            UsuarioBE usuarioBE = new UsuarioBE(1, 0, "Mario Riva Aguero", ""+a.nextFloat()+"","1");
//            cUsuarioBL usuarioBL= new cUsuarioBL();
////            cUsuarioBL usuarioBL= new cUsuarioBL();
//            int n=usuarioBL.Insertar(coneccion, usuarioBE);
////            int n2=usuarioBL.Insertar(coneccion, usuarioBE);
//            System.out.println(n);
////            System.out.println(n2);
////        }
        JFrame.setDefaultLookAndFeelDecorated(true);

            Congregacion congregacion = new Congregacion();
    }
    public void usuario() throws SQLException{
         Coneccion coneccion= new Coneccion();
            Random a = new Random();
            UsuarioBE usuarioBE = new UsuarioBE(1, 0, "Mario Riva Aguero", ""+a.nextFloat()+"","1");
            cUsuarioBL usuarioBL= new cUsuarioBL();
//            cUsuarioBL usuarioBL= new cUsuarioBL();
            int n=usuarioBL.Insertar(coneccion, usuarioBE);
//            int n2=usuarioBL.Insertar(coneccion, usuarioBE);
            System.out.println(n);
    }
    public void parametro() throws SQLException{
         Coneccion coneccion= new Coneccion();
            Random a = new Random();
            ParametroBE objBE = new ParametroBE(2, 0, "", "", 0);
            cParametroBL objBL= new cParametroBL();
//            cUsuarioBL usuarioBL= new cUsuarioBL();
            int n=objBL.Insertar(coneccion, objBE);
//            int n2=usuarioBL.Insertar(coneccion, usuarioBE);
            System.out.println(n);
    }
    public void parametroInsertar() throws SQLException{
         Coneccion coneccion= new Coneccion();
            Random a = new Random();
            ParametroBE objBE = new ParametroBE(1, 0, "Brauni", "BRAUNY MARXTILL", 0);
            cParametroBL objBL= new cParametroBL();
//            cUsuarioBL usuarioBL= new cUsuarioBL();
            int n=objBL.Insertar(coneccion, objBE);
//            int n2=usuarioBL.Insertar(coneccion, usuarioBE);
            System.out.println(n);
    }
    public void parametroLista() throws SQLException{
         Coneccion coneccion= new Coneccion();
            Random a = new Random();
            ParametroBE objBE = new ParametroBE(1, 0, "Brauni", "BRAUNY MARXTILL", 0);
            cParametroBLL objBLL= new cParametroBLL();
//            cUsuarioBL usuarioBL= new cUsuarioBL();
            List<ParametroBE> list = new ArrayList<>();
            list=objBLL.Leer(coneccion, objBE);
            for (ParametroBE parametroBE:list) {
                System.out.print(parametroBE.getId_Parametro()+"\t");
                System.out.print(parametroBE.getCodigo()+"\t");
                System.out.print(parametroBE.getDescripcion()+"\t");
                System.out.print(parametroBE.getId_Parametro_Origen()+"\t");
                
                System.out.println();
            }
//            int n2=usuarioBL.Insertar(coneccion, usuarioBE);
            
    }
}
