package conexion;
import java.sql.*;
import java.util.StringTokenizer;
import java.io.*;//Para el archivo
import java.net.URL;//Para el archivo
import javax.swing.JOptionPane;
public class conex {
    protected static Connection conex=null;
    protected static conex instancia;
    private static String sonombre,soarch,sover;
    private static File Dir_trabajo;
    static boolean directorio=false;
    static boolean archivoBD=false;
    
    static String dirAplic, sistOperativo;
    private static boolean existFile=false;
    private boolean existDir = false;
    
    public conex() {
    }
   
    /***************************************************************************
     * 
     */
     /*SINGLETON*/
    public static conex getInstancia()
    {
        if (instancia==null)
            instancia= new conex();
        return instancia;
    }
    
    public Connection abrir()
    {        
          try{                 
                //Establecemos el PATH
                File ruta= getRutaTrabajo();
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                //Recupera la cadena para el Sistema Operativo
                String so = getSistOpNombre();
                conex = DriverManager.getConnection("jdbc:derby:"+ruta+so+"BD_HojaDeCuenta;create=true;user=admin;password=4dm1n");
                Statement st = conex.createStatement();
                String[] names = { "TABLE" };
                ResultSet result;
                DatabaseMetaData metadata = null;
                boolean tableExists=false;
                try
                {
                     metadata = conex.getMetaData();
                     result = metadata.getTables(null, null, null, names);
                     while((result.next()))
                     {
                         boolean valor=result.getString("TABLE_NAME").equals("MENSUAL");
                         if ((valor==true) )
                         {
                            tableExists=true;
                         }
                     }
                }
                catch(java.sql.SQLException e)
                {
                    JOptionPane.showMessageDialog(null, "Hubo un error en tiempo de ejecucion, el programa se cerrara.","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                //Verifica si existe la Tabla dentro de la BASE de Datos.
                // SI es false crea toda las tablas
               if (tableExists==false)
               {
                    int resp = JOptionPane.showConfirmDialog(null,"No existen las Tablas en su Base de Datos, Desea Crearlas?.","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if (resp==0)
                    {
                         //Eliminando todas las tablas
                         metadata = conex.getMetaData();
                         result = metadata.getTables(null, null, null, names);
                         while((result.next()))
                         {
                             String tabla = result.getString("TABLE_NAME");
                             st.executeUpdate("DROP TABLE "+tabla);
                             System.out.println("Elimina tabla");
                         }
//                        //  /*ESTA ES MI TYABLA*/  st.executeUpdate("CREATE TABLE alumnos (codigo VARCHAR(10) not null, apellidos VARCHAR(100), nombres VARCHAR(100), clave VARCHAR(30), especialidad VARCHAR(7) , primary key (codigo,especialidad))");
//                        st.executeUpdate("create table egreso( id_e int not null, f int not null , e int not null, c int not null, nombre varchar(100), ot decimal(10,1), de decimal(10,1), re decimal(10,1),primary key(id_e))");
//                        st.executeUpdate("create table ingreso( id_in int not null, f int not null, e int not null, c int not null , com decimal(10,1), cfsr decimal(10,1), ccc decimal(10,1), nom_ott varchar(100), ott decimal(10,1), primary key(id_in))");
//                        st.executeUpdate("create table totalll( id_tot int not null, mm int not null, aa int not null , ct decimal(10,1), ct2 decimal(10,1), primary key(id_tot))");
                        st.executeUpdate("CREATE TABLE MENSUAL(" +
                        "ID_MENSUAL INT NOT NULL PRIMARY KEY  GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)" +
                        ",FECHA DATE" +
                        ",SALDOANTERIORR FLOAT" +
                        ",ENTRADAR FLOAT" +
                        ",SALIDAR FLOAT" +
                        ",SALDORESTANTER FLOAT" +
                        ",SALDOANTERIORCC FLOAT" +
                        ",ENTRADACC FLOAT" +
                        ",SALIDACC FLOAT" +
                        ",SALDORESTANTECC FLOAT" +
                        ",SALDOANTERIORO FLOAT" +
                        ",ENTRADAO FLOAT" +
                        ",SALIDAO FLOAT" +
                        ",SALDORESTANTEO FLOAT" +
                        ",TOTFONDMES FLOAT" +
                        ",TOTACTUAL FLOAT" +
                        ",TOTPLAZO FLOAT" +
                        ",GUARDADO INT" +
                        ",ESTABLESER INT" +
                        ",FLAGACTIVO CHAR(10)" +
                        ")");
                        st.executeUpdate("CREATE TABLE Parametro(" +
                                "    Id_Parametro int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY" +
                                "    ,Codigo varchar(50) " +
                                "    ,Descripcion varchar(100) " +
                                "    ,Id_Parametro_Origen int " +
                                " )");
                        st.executeUpdate("INSERT INTO PARAMETRO (CODIGO,DESCRIPCION,ID_PARAMETRO_ORIGEN)VALUES"
                                + " ('T','TRANSACCION',0)"//1
                                + ",('001','ENTRADA_RECIBIDO',1)"//2
                                + ",('002','ENTRADA_CUENTACORRIENTE',1)"//3
                                + ",('003','ENTRADA_OTRO',1)"//4
                                + ",('004','SALIDA',1)"//5
                                
                                + ",('O','Contribuciones para la OM',2)"//6
                                + ",('S','Contribuciones para el FSR',2)"//7
                                + ",('C','Contribuciones de la Congregación',2)"//8
                                + ",('T','Boletos de autobus',2)"//9
                                
                                + ",('D','Depositado en la cuenta corriente',3)"//10
                                + ",('I','Intereses',3)"//11
                                
                                + ",('B','Fondos Depositados',4)"//12
                                
                                + ",('G','Gastos visita supte. Circuito (num. 204)',5)"//13
                                + ",('G','Articulos de limpieza (num. 205)',5)"//14
                                + ",('G','Compañía Electrica Unida (num. 206)',5)"//15
                                + ",('G','Recargo por servicio bancario',5)"//16
                                + ",('G','Cheque num. 206 anulado (cambio de nombre)',5)"//17
                                + ",('G','Compañía Electrica Consolidada (num. 207)',5)"//18
                                + ",('G','Compañía de gas (num. 208)',5)"//19
                                + ",('ALP','ACTUAL_LARGOPLAZO',0)"//20
                                + ",('','Boleto de autobús',20)"//21
                                + ",('','Saldo restante del préstamo',20)"//22
                                + "");
                        st.executeUpdate("CREATE TABLE Oblifinmes("
                        + " Id_Oblifinmes INT NOT NULL PRIMARY KEY  GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)" 
                        + ", Id_Mensual INT NOT NULL"
                        + ", Obligacion VARCHAR(200)"
                        + ", Importe    FLOAT"
                        + ", Actual_Plazo CHAR(1)"
                        + ", FlagActivo CHAR(1))");                        
//                        JOptionPane.showMessageDialog(null, "SE CREO LAS TABLAS", "Advertencia",JOptionPane.WARNING_MESSAGE);
                        JOptionPane.showMessageDialog(null, "SE CREO LAS TABLAS", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
                    }
               }
          }
          catch (Exception ex)
          {
                JOptionPane.showMessageDialog(null, "Hubo un error en la conexion a la Base de Datos, el programa se cerrara.","ERROR",JOptionPane.ERROR_MESSAGE);
          }
        return conex;
    }

    public String getSistOpNombre()  {
        String valor="";
        try{
            sonombre=System.getProperty("os.name");
            StringTokenizer tokens = new StringTokenizer(sonombre);
            sonombre=tokens.nextToken();
            if (sonombre.equals("Windows"))
                valor= "\\";
             if (sonombre.equals("Linux"))
                valor="/";
        }catch(Exception ex){        
            sonombre=ex.toString();
        }     
        return valor;
    }
    public File getRutaTrabajo()   {
    String Recurso = conex.class.getSimpleName() + ".class";
    if (Dir_trabajo == null) {
        try {
            URL url = conex.class.getResource(Recurso);
            if (url.getProtocol().equals("file")) 
            {
                File f = new File(url.toURI());
                do {
                    f = f.getParentFile();
                }
                while (!f.isDirectory());
                Dir_trabajo = f;
            } 
            else if (url.getProtocol().equals("jar")) 
            {
                String expected = "!/" + Recurso;
                String s = url.toString();
                s = s.substring(4);
                System.out.println(s);
                s = s.substring(0, s.length() - expected.length());
                File f = new File(new URL(s).toURI());

                do {
                    f = f.getParentFile();
                } while (!f.isDirectory());
                Dir_trabajo = f;
            }
        } catch (Exception e) {
            Dir_trabajo = new File(".");
        }
    }
    return Dir_trabajo;
    }
}

