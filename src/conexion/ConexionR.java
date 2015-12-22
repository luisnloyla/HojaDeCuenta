package conexion;
import java.sql.*;
import java.util.StringTokenizer;
import java.io.*;//Para el archivo
import java.net.URL;//Para el archivo
import javax.swing.JOptionPane;
public class ConexionR {
    protected static Connection conex=null;
    protected static ConexionR instancia;
    private static String sonombre,soarch,sover;
    private static File Dir_trabajo;
    static boolean directorio=false;
    static boolean archivoBD=false;
    static String dirAplic, sistOperativo;
    private static boolean existFile=false;
    private boolean existDir = false;

    public ConexionR() {
    }
   
    /***************************************************************************
     * 
     */
     /*SINGLETON*/
    public static ConexionR getInstancia()
    {
        if (instancia==null)
            instancia= new ConexionR();
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
                conex = DriverManager.getConnection("jdbc:derby:"+ruta+so+"bd123;create=true;user=admin;password=4dm1n");
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
                         boolean valor=result.getString("TABLE_NAME").equals("EGRESO");
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
                        //  /*ESTA ES MI TYABLA*/  st.executeUpdate("CREATE TABLE alumnos (codigo VARCHAR(10) not null, apellidos VARCHAR(100), nombres VARCHAR(100), clave VARCHAR(30), especialidad VARCHAR(7) , primary key (codigo,especialidad))");
                        st.executeUpdate("create table egreso( id_e int not null, f int not null , e int not null, c int not null, nombre varchar(100), ot decimal(10,1), de decimal(10,1), re decimal(10,1),primary key(id_e))");
                        st.executeUpdate("create table ingreso( id_in int not null, f int not null, e int not null, c int not null , com decimal(10,1), cfsr decimal(10,1), ccc decimal(10,1), nom_ott varchar(100), ott decimal(10,1), primary key(id_in))");
                        st.executeUpdate("create table totalll( id_tot int not null, mm int not null, aa int not null , ct decimal(10,1), ct2 decimal(10,1), primary key(id_tot))");
                        JOptionPane.showMessageDialog(null, "SE CREO LAS TABLAS", "Advertencia",JOptionPane.WARNING_MESSAGE);
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
    String Recurso = ConexionR.class.getSimpleName() + ".class";
    if (Dir_trabajo == null) {
        try {
            URL url = ConexionR.class.getResource(Recurso);
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