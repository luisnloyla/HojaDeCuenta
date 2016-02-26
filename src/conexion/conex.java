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
                         if (valor==true)
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
                    int resp =0;
//                    int resp = JOptionPane.showConfirmDialog(null,"No existen las Tablas en su Base de Datos, Desea Crearlas?.","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    JOptionPane.showMessageDialog(null, "No existen las Tablas en su Base de Datos, vamos a Crearlas");
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
                        ",FechaG Date DEFAULT CURRENT Date"+
                        ",HoraG Time DEFAULT CURRENT Time"+
                        ")");
                        st.executeUpdate("CREATE VIEW MENSUAL_V (ID_MENSUAL ,FECHA ,SALDOANTERIORR ,ENTRADAR ,SALIDAR ,SALDORESTANTER ,SALDOANTERIORCC ,ENTRADACC ,SALIDACC ,SALDORESTANTECC ,SALDOANTERIORO ,ENTRADAO ,SALIDAO ,SALDORESTANTEO ,TOTFONDMES ,TOTACTUAL ,TOTPLAZO ,GUARDADO ,ESTABLESER ,FLAGACTIVO ,FechaG  ,HoraG ) AS SELECT ID_MENSUAL ,FECHA ,SALDOANTERIORR ,ENTRADAR ,SALIDAR ,SALDORESTANTER ,SALDOANTERIORCC ,ENTRADACC ,SALIDACC ,SALDORESTANTECC ,SALDOANTERIORO ,ENTRADAO ,SALIDAO ,SALDORESTANTEO ,TOTFONDMES ,TOTACTUAL ,TOTPLAZO ,GUARDADO ,ESTABLESER ,FLAGACTIVO ,FechaG  , CAST(HoraG AS VARCHAR(100)) AS HoraG FROM MENSUAL");
                        st.executeUpdate("CREATE TRIGGER MENSUAL_UPD " +
                                        "AFTER UPDATE ON MENSUAL " +
                                        "REFERENCING OLD AS OLD NEW AS NEW " +
                                        "FOR EACH ROW " +
                                        "WHEN (OLD.GUARDADO <> NEW.GUARDADO AND 1 = NEW.GUARDADO) "+
                                        "UPDATE MENSUAL SET FECHAG = CURRENT_DATE,HORAG = CURRENT_TIME WHERE ID_MENSUAL = NEW.ID_MENSUAL ");
                        st.executeUpdate("CREATE TABLE Parametro(" +
                                "    Id_Parametro int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY" +
                                "    ,Codigo varchar(50) " +
                                "    ,Descripcion varchar(100) " +
                                "    ,Id_Parametro_Origen int " +
                                "    ,FLAGACTIVO CHAR(10)" +
                                "    ,Fecha Date DEFAULT CURRENT Date"+
                                "    ,Hora Time DEFAULT CURRENT Time"+
                                " )");
                        st.executeUpdate("CREATE TABLE Parametro_M(" +
                                "    Id_Parametro_M int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY" +
                                "    ,Codigo varchar(50) " +
                                "    ,Descripcion varchar(100) " +
                                "    ,Id_Parametro_Origen int " +
                                "    ,FLAGACTIVO CHAR(10)" +
                                "    ,Fecha Date "+
                                "    ,Hora Time "+
                                "    ,Id_Parametro int not null"+
                                " )");
                        st.executeUpdate("CREATE TRIGGER PARAMETRO_UPD " +
                                        "AFTER UPDATE ON PARAMETRO " +
                                        "REFERENCING OLD AS OLD NEW AS NEW " +
                                        "FOR EACH ROW " +
                                        "WHEN (OLD.Fecha = NEW.Fecha AND OLD.Hora = NEW.Hora)"+
                                        "INSERT INTO PARAMETRO_M (CODIGO,DESCRIPCION,ID_PARAMETRO_ORIGEN,FLAGACTIVO,Fecha,Hora,Id_Parametro)" +
                                        "VALUES(OLD.CODIGO,OLD.DESCRIPCION,OLD.ID_PARAMETRO_ORIGEN,OLD.FLAGACTIVO,OLD.Fecha,OLD.Hora,OLD.Id_Parametro)");
                        st.executeUpdate("CREATE TRIGGER PARAMETRO_M_UPD " +
                                        "AFTER INSERT ON Parametro_M " +
                                        "REFERENCING NEW AS NEW " +
                                        "FOR EACH ROW " +
                                        "UPDATE PARAMETRO SET FECHA = CURRENT_DATE,HORA = CURRENT_TIME "+
                                        "WHERE Id_Parametro = NEW.Id_Parametro");
                        st.executeUpdate("CREATE VIEW PARAMETRO_V(ID_PARAMETRO,CODIGO,DESCRIPCION,ID_PARAMETRO_ORIGEN,FLAGACTIVO,FECHA,HORA) "
                                                     + "AS SELECT ID_PARAMETRO,CODIGO,DESCRIPCION,ID_PARAMETRO_ORIGEN,FLAGACTIVO,FECHA,CAST(HORA AS VARCHAR(100)) AS HORA FROM PARAMETRO");
                        st.executeUpdate("CREATE VIEW PARAMETRO_MV(ID_PARAMETRO_M,CODIGO,DESCRIPCION,ID_PARAMETRO_ORIGEN,FLAGACTIVO,FECHA,HORA,ID_PARAMETRO) AS SELECT ID_PARAMETRO_M,CODIGO,DESCRIPCION,ID_PARAMETRO_ORIGEN,FLAGACTIVO,FECHA,CAST(HORA AS VARCHAR(100)) AS HORA,ID_PARAMETRO FROM PARAMETRO_M");
                        /*************************************************************************************************************************************/
                        st.executeUpdate("CREATE VIEW PARAMETRO_VU(ID_PARAMETRO,CODIGO,DESCRIPCION,ID_PARAMETRO_ORIGEN,FLAGACTIVO,FECHA,HORA) "
                        + "AS "
                        + "SELECT ID_PARAMETRO,CODIGO,DESCRIPCION,ID_PARAMETRO_ORIGEN,FLAGACTIVO,FECHA,HORA FROM PARAMETRO WHERE FLAGACTIVO = '1' "
                        + "UNION "
                        + "SELECT ID_PARAMETRO,CODIGO,DESCRIPCION,ID_PARAMETRO_ORIGEN,FLAGACTIVO,FECHA,HORA FROM PARAMETRO_M  ");
                        
                        st.executeUpdate("CREATE VIEW PARAMETRO_VU2(ID_PARAMETRO,CODIGO,DESCRIPCION,ID_PARAMETRO_ORIGEN,FLAGACTIVO,FECHA,HORA) "
                        + "AS "
                        + "SELECT ID_PARAMETRO,CODIGO,DESCRIPCION,ID_PARAMETRO_ORIGEN,FLAGACTIVO,FECHA,CAST(HORA AS VARCHAR(100)) AS HORA FROM PARAMETRO WHERE FLAGACTIVO = '1' "
                        + "UNION "
                        + "SELECT ID_PARAMETRO,CODIGO,DESCRIPCION,ID_PARAMETRO_ORIGEN,FLAGACTIVO,FECHA,CAST(HORA AS VARCHAR(100)) AS HORA FROM PARAMETRO_M  ");
                        /*************************************************************************************************************************************/
//                        st.executeUpdate("INSERT INTO PARAMETRO (CODIGO,DESCRIPCION,ID_PARAMETRO_ORIGEN,FLAGACTIVO)VALUES('K_E','ESTATICO',0,'1'),('K_D','DINAMICO',0,'1'),('K_E_001','ENTRADA_RECIBIDO',1,'1'),('K_E_002','ENTRADA_CUENTACORRIENTE',1,'1'),('K_E_003','ENTRADA_OTRO',1,'1'),('K_E_004','OTROS',1,'1'),('K_E_005','SALIDA',1,'1'),('ALP','ACTUAL_LARGOPLAZO',2,'1'),('O','Contribuciones para la OM',3,'1'),('S','Contribuciones para el FSR',3,'1'),('C','Contribuciones de la Congregación',3,'1'),('T','Boletos de autobus',3,'1'),('D','Depositado en la cuenta corriente',4,'1'),('I','Intereses',4,'1'),('B','Fondos Depositados',5,'1'),('','Boleto de autobús',8,'1'),('','Saldo restante del préstamo',8,'1')");
                        st.executeUpdate("INSERT INTO PARAMETRO (CODIGO,DESCRIPCION,ID_PARAMETRO_ORIGEN,FLAGACTIVO)VALUES('K_E','ESTATICO',0,'1'),('K_D','DINAMICO',0,'1'),('K_N','ESTATICOS/DINAMICOS',0,'1'),('K_E_001','ENTRADA_RECIBIDO',1,'1'),('K_E_002','ENTRADA_CUENTACORRIENTE',1,'1'),('K_E_003','ENTRADA_OTRO',1,'1'),('K_E_004','OTROS',1,'1'),('K_E_005','SALIDA',1,'1'),('K_D_ACTUAL','ACTUAL',2,'1'),('K_D_PLAZO','LARGO_PLAZO',2,'1'),('K_E_006','CONGREGACION',1,'1'),('K_N_Nombre','San Juan',11,'1'),('K_N_Direccion','Gamaniel Blanco',11,'1'),('K_N_Ciudad','Cerro De Pasco',11,'1'),('K_N_Provincia','Pasco',11,'1'),('O','Contribuciones para la OM',3,'1'),('S','Contribuciones para el FSR',3,'1'),('C','Contribuciones de la Congregación',3,'1'),('T','Boletos de autobus',3,'1'),('D','Depositado en la cuenta corriente',4,'1'),('I','Intereses',4,'1'),('B','Fondos Depositados',5,'1'),('','Boleto de autobús',10,'1'),('','Saldo restante del préstamo',11,'1')");
                        st.executeUpdate("CREATE TABLE Oblifinmes("
                                + " Id_Oblifinmes INT NOT NULL PRIMARY KEY  GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)"
                                + ", Id_Mensual INT NOT NULL"
                                + ", Obligacion VARCHAR(200)"
                                + ", Importe    FLOAT"
                                + ", Actual_Plazo CHAR(1)"
                                + ", FlagActivo CHAR(1))");
                        st.executeUpdate("CREATE TABLE AUTOMATICO("
                                + "ID_AUTOMATICO INT NOT NULL PRIMARY KEY  GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)"
                                + ",CODIGO INT"
                                + ",DESCRIPCION VARCHAR(32000)"
                                + ",IndiceDESCRIPCION GENERATED ALWAYS AS(UPPER(DESCRIPCION)))");
                        st.executeUpdate("CREATE INDEX AUTOMATICOIndiceCodigo ON AUTOMATICO(IndiceDESCRIPCION)");
//                        JOptionPane.showMessageDialog(null, "SE CREO LAS TABLAS", "Advertencia",JOptionPane.WARNING_MESSAGE);
                        JOptionPane.showMessageDialog(null, "SE CREO LAS TABLAS", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
                    }
               }
          }
          catch (Exception ex)
          {
                JOptionPane.showMessageDialog(null, "Hubo un error en la conexion a la Base de Datos, el programa se cerrara. "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
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
//SELECT*FROM PARAMETRO_VU2 WHERE ID_PARAMETRO = 15 AND  '15:35:13' >= HORA
//-------------------------------------------------------------------------
//SELECT*FROM PARAMETRO_VU WHERE ID_PARAMETRO = 15 AND HORA = (
//SELECT MAX (HORA) FROM PARAMETRO_VU WHERE ID_PARAMETRO = 15  AND  HORA  <= '15:37:50')
