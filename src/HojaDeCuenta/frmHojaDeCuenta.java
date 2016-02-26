package HojaDeCuenta;
import HojaDeCuenta.TB.Class.OblifinmesC;
import HojaDeCuenta.TB.Class.ParametroC;
import HojaDeCuenta.TB.Editor.OblifinmesEditor;
import HojaDeCuenta.TB.Editor.OblifinmesEditor02;
import HojaDeCuenta.TB.Renderer.OblifinmesRenderer;
import HojaDeCuenta.TB.TableModel.OblifinmesTM;
import HojaDeCuenta.TB.TableModel.ParametroTM;
import HojaDeCuentaBE.MensualBE;
import HojaDeCuentaBE.OblifinmesBE;
import HojaDeCuentaBE.ParametroBE;
import HojaDeCuentaBL.cOblifinmesBL;
import HojaDeCuentaBL.cMensualBL;
import HojaDeCuentaBL.cMensualBLL;
import HojaDeCuentaBL.cParametroBL;
import HojaDeCuentaBL.cParametroBLL;
import HojaDeCuentaVar.V;
import ejecutar.Coneccion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;
import org.jvnet.substance.SubstanceLookAndFeel;

public final class frmHojaDeCuenta extends javax.swing.JFrame {
    public boolean bNuevo = false;
    String[] Mes = {"MES", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
    int IdMes = 1;//1
    String annioActual;
    private int estableser;
    int habilitarCajastexto = 1;
    
    int insertar = 1;
    int actualizar = 2;
    int numeroDeEntradas = 0;
    List<MensualBE> lista = null;
    MensualBE mensualBE = null;
    int indiceEntradaActual = 0;
    
    int SelectindiceEntradaActual = 0;
    ////////////////TABLAS DE OBLIGACION A FIN DE MES //////////////////////////
    private OblifinmesTM mto;
    private OblifinmesTM mtl;
    private ParametroTM mtparametro;
    
    int arranqueTabla = 0;
    //****AUTOCOMPLETO *********************************************************
    MostrarResultadosConsulta consulta = null;
    int ban = 0;
    
    public frmHojaDeCuenta() throws SQLException {
        super("HOJA DE CUENTA  CONGREGACION:"+new V().cCongregacion);
        initComponents();
        /////////////////////////////////////////////////////
        JFrame.setDefaultLookAndFeelDecorated(true);
//        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");
//        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenGraphiteGlassSkin");
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessSkin");
        SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");
//        SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark. SubstanceBubblesWatermark");
        setResizable(false);
        ////////////////////////////////////////////////////////////////////////
        
        ////////////////////////////////////////////////////////////////////////
        //----AQUI ERA

//        cboBusqueda.SelectedIndex = 1;
//
//        VuelveACargarLista();

//        If grdBusqueda.Rows.Count = 0 Then
//            LimpiarCampos()
//            txtCodigo.Tag = ""
//            btnModificar.Enabled = False
//            btnEliminar.Enabled = False
//        Else
//            LlenarCamposDeFilaSeleccionada()
//        End If
        
        AsignarMes();
        Calendar c = new GregorianCalendar();
        jdcFecha.setDate(new Date());
        String dia = Integer.toString(c.get(Calendar.DATE));
        String mes = Integer.toString(c.get(Calendar.MONTH));
        annioActual = Integer.toString(c.get(Calendar.YEAR));
        /***************************************************/
        int anioEstablesido= HallandoAnioEstablesido();
        if (anioEstablesido != 0) {
            annioActual = ""+anioEstablesido;
        }
        /***************************************************/
        jsnAnio.setValue(Integer.parseInt(annioActual));

//        estableser();
        lblId_Mes.setText("0");
        VuelveACargarLista();//por cuestiones de seguridad
        SetearCamposModoGrabado();
        if (numeroDeEntradas==0) {
            LimpiarCampos();
//            anteriorPosterior(false);
            lblMes.setText(Mes[0]);
        }else{
//            IdMes = obtenerFila02();
            IdMes = obtenerFilaEstablecida();
            AsignarMes();
//            anteriorPosterior(true);
        }
        /////////////////////////OBLIGACION A FIN DE MES////////////////////////        
        
        mto = new OblifinmesTM(0,Integer.parseInt(lblId_Mes.getText()));
        tablaOblifinmesT();
        mtl = new OblifinmesTM(1,Integer.parseInt(lblId_Mes.getText()));
        tablaOblifinmesTL();
        mtparametro = new ParametroTM();
        tablaParametro();
        //----AHORA AQUI ESTOY
        this.setLocationRelativeTo(this);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/currency.png"));
        setIconImage(icon);
        setSize(470,620);
        setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtSaldoAnteriorR1 = new javax.swing.JTextField();
        txtEntradaR1 = new javax.swing.JTextField();
        txtSalidaR1 = new javax.swing.JTextField();
        txtSaldoRestanteR1 = new javax.swing.JTextField();
        jpmCrud = new javax.swing.JPopupMenu();
        jmpNuevo = new javax.swing.JMenuItem();
        jmpGuardar = new javax.swing.JMenuItem();
        jmpEliminar = new javax.swing.JMenuItem();
        jpmCrud02 = new javax.swing.JPopupMenu();
        jmpNuevo02 = new javax.swing.JMenuItem();
        jmpGuardar02 = new javax.swing.JMenuItem();
        jmpEliminar02 = new javax.swing.JMenuItem();
        jpmCrudParametro = new javax.swing.JPopupMenu();
        jmpNuevoParametro = new javax.swing.JMenuItem();
        jmpGuardarParametro = new javax.swing.JMenuItem();
        jmpEliminarParametro = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        btnAnterior = new javax.swing.JButton();
        btnPosterior = new javax.swing.JButton();
        btnEstablecer = new javax.swing.JButton();
        lblMes = new javax.swing.JLabel();
        btnFiniquitar = new javax.swing.JButton();
        jsnAnio = new javax.swing.JSpinner();
        btnImprimir = new javax.swing.JButton();
        EGRESO = new javax.swing.JTabbedPane();
        jpEgreso = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtTotalActuales1 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtTotalActuales2 = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jpIngreso = new javax.swing.JPanel();
        btnNumeroEntradas = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSaldoAnteriorR = new javax.swing.JTextField();
        txtEntradaR = new javax.swing.JTextField();
        txtSalidaR = new javax.swing.JTextField();
        txtSaldoRestanteR = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtSaldoAnteriorCC = new javax.swing.JTextField();
        txtEntradaCC = new javax.swing.JTextField();
        txtSalidaCC = new javax.swing.JTextField();
        txtSaldoRestanteCC = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtSaldoAnteriorO = new javax.swing.JTextField();
        txtEntradaO = new javax.swing.JTextField();
        txtSalidaO = new javax.swing.JTextField();
        txtSaldoRestanteO = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtTotFondMes = new javax.swing.JTextField();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        lblId_Mes = new javax.swing.JLabel();
        lblGuardado = new javax.swing.JLabel();
        jpCrud = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtTotalActuales = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtActuales = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtTotalLargoPlazo = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtLargoPlazo = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jtParametro = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        btnConsultas = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtQuery = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtResultadoQuery = new javax.swing.JTextArea();
        btnEjecutar = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Recibido:"));

        jLabel6.setText("Saldo Anterior:");

        jLabel7.setText("ENTRADA:");

        jLabel8.setText("SALIDA:");

        jLabel9.setText("Saldo Restante:");

        txtSaldoAnteriorR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoAnteriorR1ActionPerformed(evt);
            }
        });

        txtEntradaR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntradaR1ActionPerformed(evt);
            }
        });

        txtSalidaR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalidaR1ActionPerformed(evt);
            }
        });

        txtSaldoRestanteR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoRestanteR1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(42, 42, 42)
                                .addComponent(txtSalidaR1))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSaldoAnteriorR1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(31, 31, 31)
                                .addComponent(txtEntradaR1)))
                        .addContainerGap(131, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSaldoRestanteR1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSaldoAnteriorR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEntradaR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSalidaR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtSaldoRestanteR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jpmCrud.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jmpNuevo.setText("NUEVO");
        jmpNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmpNuevoActionPerformed(evt);
            }
        });
        jpmCrud.add(jmpNuevo);

        jmpGuardar.setText("GUARDAR");
        jmpGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmpGuardarActionPerformed(evt);
            }
        });
        jpmCrud.add(jmpGuardar);

        jmpEliminar.setText("ELIMINAR");
        jmpEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmpEliminarActionPerformed(evt);
            }
        });
        jpmCrud.add(jmpEliminar);

        jmpNuevo02.setText("NUEVO");
        jmpNuevo02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmpNuevo02ActionPerformed(evt);
            }
        });
        jpmCrud02.add(jmpNuevo02);

        jmpGuardar02.setText("GUARDAR");
        jmpGuardar02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmpGuardar02ActionPerformed(evt);
            }
        });
        jpmCrud02.add(jmpGuardar02);

        jmpEliminar02.setText("ELIMINAR");
        jmpEliminar02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmpEliminar02ActionPerformed(evt);
            }
        });
        jpmCrud02.add(jmpEliminar02);

        jmpNuevoParametro.setText("NUEVO");
        jmpNuevoParametro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmpNuevoParametroActionPerformed(evt);
            }
        });
        jpmCrudParametro.add(jmpNuevoParametro);

        jmpGuardarParametro.setText("GUARDAR");
        jmpGuardarParametro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmpGuardarParametroActionPerformed(evt);
            }
        });
        jpmCrudParametro.add(jmpGuardarParametro);

        jmpEliminarParametro.setText("ELIMINAR");
        jmpEliminarParametro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmpEliminarParametroActionPerformed(evt);
            }
        });
        jpmCrudParametro.add(jmpEliminarParametro);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btnAnterior.setText("<<");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnPosterior.setText(">>");
        btnPosterior.setBorder(null);
        btnPosterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPosteriorActionPerformed(evt);
            }
        });

        btnEstablecer.setText("E");
        btnEstablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstablecerActionPerformed(evt);
            }
        });

        btnFiniquitar.setText("Fin");
        btnFiniquitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiniquitarActionPerformed(evt);
            }
        });

        jsnAnio.setModel(new javax.swing.SpinnerNumberModel(1900, 1900, 2050, 1));
        jsnAnio.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsnAnioStateChanged(evt);
            }
        });
        jsnAnio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jsnAnioMouseClicked(evt);
            }
        });
        jsnAnio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jsnAnioKeyPressed(evt);
            }
        });

        btnImprimir.setText("IM");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lblMes, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPosterior, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jsnAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btnEstablecer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFiniquitar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblMes))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFiniquitar)
                        .addComponent(btnImprimir)
                        .addComponent(btnEstablecer)
                        .addComponent(jsnAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPosterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        EGRESO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        EGRESO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EGRESOMouseClicked(evt);
            }
        });

        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel21.setText("Total:");

        txtTotalActuales1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTotalActuales1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActuales1ActionPerformed(evt);
            }
        });
        txtTotalActuales1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalActuales1KeyTyped(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalActuales1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtTotalActuales1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel22.setText("Total:");

        txtTotalActuales2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTotalActuales2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActuales2ActionPerformed(evt);
            }
        });
        txtTotalActuales2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalActuales2KeyTyped(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalActuales2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtTotalActuales2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jpEgresoLayout = new javax.swing.GroupLayout(jpEgreso);
        jpEgreso.setLayout(jpEgresoLayout);
        jpEgresoLayout.setHorizontalGroup(
            jpEgresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEgresoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEgresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpEgresoLayout.setVerticalGroup(
            jpEgresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEgresoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        EGRESO.addTab("Recibido", jpEgreso);

        btnNumeroEntradas.setText("NUMERO DE ENTRADAS");
        btnNumeroEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumeroEntradasActionPerformed(evt);
            }
        });

        jButton2.setText("jButton1");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("AUTOCOMPLETO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpIngresoLayout = new javax.swing.GroupLayout(jpIngreso);
        jpIngreso.setLayout(jpIngresoLayout);
        jpIngresoLayout.setHorizontalGroup(
            jpIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpIngresoLayout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addGroup(jpIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(btnNumeroEntradas))
                .addGap(201, 201, 201))
        );
        jpIngresoLayout.setVerticalGroup(
            jpIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpIngresoLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(btnNumeroEntradas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(299, Short.MAX_VALUE))
        );

        EGRESO.addTab("CuentaCorriente", jpIngreso);

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel12.setLayout(null);

        jScrollPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 6));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setText("Saldo Anterior:");

        jLabel2.setText("ENTRADA:");

        jLabel3.setText("SALIDA:");

        jLabel4.setText("Saldo Restante:");

        txtSaldoAnteriorR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSaldoAnteriorR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoAnteriorRActionPerformed(evt);
            }
        });
        txtSaldoAnteriorR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaldoAnteriorRKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSaldoAnteriorRKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSaldoAnteriorRKeyReleased(evt);
            }
        });

        txtEntradaR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtEntradaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntradaRActionPerformed(evt);
            }
        });
        txtEntradaR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEntradaRKeyTyped(evt);
            }
        });

        txtSalidaR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSalidaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalidaRActionPerformed(evt);
            }
        });
        txtSalidaR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSalidaRKeyTyped(evt);
            }
        });

        txtSaldoRestanteR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSaldoRestanteR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoRestanteRActionPerformed(evt);
            }
        });
        txtSaldoRestanteR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaldoRestanteRKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSalidaR, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(txtSaldoAnteriorR)
                            .addComponent(txtEntradaR))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSaldoRestanteR, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSaldoAnteriorR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEntradaR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSalidaR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSaldoRestanteR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("Fecha:");

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel10.setText("Saldo Anterior:");

        jLabel11.setText("ENTRADA:");

        jLabel12.setText("SALIDA:");

        jLabel13.setText("Saldo Restante:");

        txtSaldoAnteriorCC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSaldoAnteriorCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoAnteriorCCActionPerformed(evt);
            }
        });
        txtSaldoAnteriorCC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaldoAnteriorCCKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSaldoAnteriorCCKeyReleased(evt);
            }
        });

        txtEntradaCC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtEntradaCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntradaCCActionPerformed(evt);
            }
        });
        txtEntradaCC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEntradaCCKeyTyped(evt);
            }
        });

        txtSalidaCC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSalidaCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalidaCCActionPerformed(evt);
            }
        });
        txtSalidaCC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSalidaCCKeyTyped(evt);
            }
        });

        txtSaldoRestanteCC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSaldoRestanteCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoRestanteCCActionPerformed(evt);
            }
        });
        txtSaldoRestanteCC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaldoRestanteCCKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSaldoAnteriorCC, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSalidaCC)
                                    .addComponent(txtEntradaCC))))
                        .addGap(0, 134, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSaldoRestanteCC, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtSaldoAnteriorCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtEntradaCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtSalidaCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtSaldoRestanteCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel14.setText("Saldo Anterior:");

        jLabel15.setText("ENTRADA:");

        jLabel16.setText("SALIDA:");

        jLabel17.setText("Saldo Restante:");

        txtSaldoAnteriorO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSaldoAnteriorO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoAnteriorOActionPerformed(evt);
            }
        });
        txtSaldoAnteriorO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaldoAnteriorOKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSaldoAnteriorOKeyReleased(evt);
            }
        });

        txtEntradaO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtEntradaO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntradaOActionPerformed(evt);
            }
        });
        txtEntradaO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEntradaOKeyTyped(evt);
            }
        });

        txtSalidaO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSalidaO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalidaOActionPerformed(evt);
            }
        });
        txtSalidaO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSalidaOKeyTyped(evt);
            }
        });

        txtSaldoRestanteO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSaldoRestanteO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoRestanteOActionPerformed(evt);
            }
        });
        txtSaldoRestanteO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaldoRestanteOKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSaldoAnteriorO, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEntradaO)
                                    .addComponent(txtSalidaO))))
                        .addGap(0, 134, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSaldoRestanteO, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtSaldoAnteriorO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtEntradaO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtSalidaO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtSaldoRestanteO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel18.setText("TOTAL DE FONDOS A FIN DE MES:");

        txtTotFondMes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTotFondMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotFondMesActionPerformed(evt);
            }
        });
        txtTotFondMes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotFondMesKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTotFondMes, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtTotFondMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jdcFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(65, 65, 65)
                        .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblId_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGuardado))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGuardado)
                            .addComponent(lblId_Mes))))
                .addGap(13, 13, 13)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel3);

        jScrollPane5.setViewportView(jScrollPane1);

        jPanel12.add(jScrollPane5);
        jScrollPane5.setBounds(0, 10, 450, 384);

        jpCrud.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 6));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnDeshacer.setText("Deshacer");
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });

        btnSalir.setBackground(java.awt.Color.orange);
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpCrudLayout = new javax.swing.GroupLayout(jpCrud);
        jpCrud.setLayout(jpCrudLayout);
        jpCrudLayout.setHorizontalGroup(
            jpCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCrudLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGrabar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeshacer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpCrudLayout.setVerticalGroup(
            jpCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCrudLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jpCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnDeshacer)
                    .addComponent(btnSalir)
                    .addComponent(btnGrabar)
                    .addComponent(btnNuevo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.add(jpCrud);
        jpCrud.setBounds(0, 410, 450, 60);

        EGRESO.addTab("Conciliacion HojaCuenta", jPanel12);

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel19.setText("Total Actual:");

        txtTotalActuales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTotalActuales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActualesActionPerformed(evt);
            }
        });
        txtTotalActuales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalActualesKeyTyped(evt);
            }
        });

        jtActuales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtActuales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title3", "Title4", "Title5", "Title6"
            }
        ));
        jtActuales.setComponentPopupMenu(jpmCrud);
        jtActuales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtActualesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtActuales);
        if (jtActuales.getColumnModel().getColumnCount() > 0) {
            jtActuales.getColumnModel().getColumn(4).setHeaderValue("Title5");
            jtActuales.getColumnModel().getColumn(5).setHeaderValue("Title6");
        }

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalActuales, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtTotalActuales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel20.setText("Total Largo Plazo:");

        txtTotalLargoPlazo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTotalLargoPlazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalLargoPlazoActionPerformed(evt);
            }
        });
        txtTotalLargoPlazo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalLargoPlazoKeyTyped(evt);
            }
        });

        jtLargoPlazo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtLargoPlazo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title3", "Title4", "Title5", "Title6"
            }
        ));
        jtLargoPlazo.setComponentPopupMenu(jpmCrud02);
        jtLargoPlazo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtLargoPlazoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtLargoPlazo);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(txtTotalLargoPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalLargoPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel11);

        EGRESO.addTab("Obligacion-FinMes", jScrollPane2);

        jtParametro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jtParametro.setComponentPopupMenu(jpmCrudParametro);
        jtParametro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtParametroMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jtParametro);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Parametro", jPanel13);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Configuracion", jPanel14);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Usuario", jPanel15);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Impresion", jPanel16);

        btnConsultas.setText("CONSULTAS");
        btnConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasActionPerformed(evt);
            }
        });

        txtQuery.setColumns(20);
        txtQuery.setRows(5);
        jScrollPane7.setViewportView(txtQuery);

        txtResultadoQuery.setColumns(20);
        txtResultadoQuery.setRows(5);
        jScrollPane10.setViewportView(txtResultadoQuery);

        btnEjecutar.setText("INSERTAR");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addComponent(jScrollPane10)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(btnEjecutar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
                        .addComponent(btnConsultas)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultas)
                    .addComponent(btnEjecutar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SQL", jPanel17);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Back", jPanel18);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Ayuda", jPanel19);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        EGRESO.addTab("C", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(EGRESO)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EGRESO, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSaldoAnteriorR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoAnteriorR1ActionPerformed
        
    }//GEN-LAST:event_txtSaldoAnteriorR1ActionPerformed

    private void txtEntradaR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntradaR1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEntradaR1ActionPerformed

    private void txtSalidaR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalidaR1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalidaR1ActionPerformed

    private void txtSaldoRestanteR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoRestanteR1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoRestanteR1ActionPerformed

    private void txtTotalLargoPlazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalLargoPlazoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalLargoPlazoActionPerformed

    private void txtTotalActualesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActualesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActualesActionPerformed

    private void txtTotFondMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotFondMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotFondMesActionPerformed

    private void txtSaldoRestanteOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoRestanteOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoRestanteOActionPerformed

    private void txtSalidaOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalidaOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalidaOActionPerformed

    private void txtEntradaOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntradaOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEntradaOActionPerformed

    private void txtSaldoAnteriorOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoAnteriorOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoAnteriorOActionPerformed

    private void txtSaldoRestanteCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoRestanteCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoRestanteCCActionPerformed

    private void txtSalidaCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalidaCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalidaCCActionPerformed

    private void txtEntradaCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntradaCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEntradaCCActionPerformed

    private void txtSaldoAnteriorCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoAnteriorCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoAnteriorCCActionPerformed

    private void txtSaldoRestanteRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoRestanteRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoRestanteRActionPerformed

    private void txtSalidaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalidaRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalidaRActionPerformed

    private void txtEntradaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntradaRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEntradaRActionPerformed

    private void txtSaldoAnteriorRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoAnteriorRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoAnteriorRActionPerformed

    private void btnEstablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstablecerActionPerformed
        if (Integer.parseInt(lblId_Mes.getText())== 0) {
            return;
        }
        try {
//            JOptionPane.showMessageDialog(this, this.mensualBE.getEstableser());
                  
            SetearCamposModoGrabado();
            Coneccion c = new Coneccion();
            MensualBE mensualBE;
            cMensualBL mensualBL = new cMensualBL();
            int ires = 0;
            
            mensualBE = new MensualBE(5, Integer.parseInt(lblId_Mes.getText()), new V().fecha(jdcFecha), Float.parseFloat(txtSaldoAnteriorR.getText()), Float.parseFloat(txtEntradaR.getText()), Float.parseFloat(txtSalidaR.getText()), Float.parseFloat(txtSaldoRestanteR.getText()), Float.parseFloat(txtSaldoAnteriorCC.getText()), Float.parseFloat(txtEntradaCC.getText()), Float.parseFloat(txtSalidaCC.getText()), Float.parseFloat(txtSaldoRestanteCC.getText()), Float.parseFloat(txtSaldoAnteriorO.getText()), Float.parseFloat(txtEntradaO.getText()), Float.parseFloat(txtSalidaO.getText()), Float.parseFloat(txtSaldoRestanteO.getText()), Float.parseFloat(txtTotFondMes.getText()), 0//Float.parseFloat(txtTotalActuales.getText())
                , 0//Float.parseFloat(txtTotalLargoPlazo.getText())
                , 0, getEstableser(), "1");
            ires = mensualBL.Actualizar(c, mensualBE);
            if (ires < 0) {
                JOptionPane.showMessageDialog(this, "Error al Finiquitar");
            } else {
//                JOptionPane.showMessageDialog(this, "Exito al Finiquitar");
            }
//            JOptionPane.showMessageDialog(this, getEstableser());
            estableser();
        } catch (SQLException ex) {
            Logger.getLogger(frmHojaDeCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEstablecerActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        SetearCamposModoGrabado();
        try {
            if (Integer.parseInt(lblId_Mes.getText()) != 0) {
                if(lista.get(SelectindiceEntradaActual).getGuardado()==1){
                    Date fechaMayor = null;
                    MensualBE objMensualBE = new MensualBE(4,  Integer.parseInt(lblId_Mes.getText()), new Date(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "0");
                    cMensualBLL objCMensualBLL = new cMensualBLL();
                    List<MensualBE> objList = objCMensualBLL.Leer(new Coneccion(), objMensualBE);
                    for (MensualBE objList1 : objList) {
                        fechaMayor = objList1.getFecha();
                    }
                    if (fechaMayor.compareTo(lista.get(SelectindiceEntradaActual).getFecha())>0) {
                        JOptionPane.showMessageDialog(this, "No se puede eliminar por que tiene dependencias");
                        return;
                    }
                }
                Coneccion c = new Coneccion();
                MensualBE mensualBEl = new MensualBE(1/*2*/,  Integer.parseInt(lblId_Mes.getText()), new Date(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "0");
                cMensualBL mensualBL = new cMensualBL();
                if (mensualBL.Eliminar(c, mensualBEl) < 0) {//if (mensualBL.Actualizar(c, mensualBEl) < 0) {
                    JOptionPane.showMessageDialog(this, "No se elimino");
                }
            }
            VuelveACargarLista();
            if (numeroDeEntradas==0) {
                LimpiarCampos();
                lblId_Mes.setText("0");
                btnModificar.setEnabled(false);
                btnEliminar.setEnabled(false);
            } else {
                obtenerFila(0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmHojaDeCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        bNuevo = false;
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnPosteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPosteriorActionPerformed
//        IdMes++;
//        AsignarMes();
//        if (this.lista!=null) {
//            obtenerFila(IdMes);
//        }
//        JOptionPane.showMessageDialog(rootPane, ""+numeroDeEntradas);
        if (numeroDeEntradas == 0) {
            lblMes.setText(Mes[0]);
            return;
        }
        indiceEntradaActual++;
        if (indiceEntradaActual >= numeroDeEntradas) {
            indiceEntradaActual = 0;            
        }
        IdMes = obtenerFilaNext();
        AsignarMes();        
        //*****************************************************************
        cargarTablasOblifinmes();
    }//GEN-LAST:event_btnPosteriorActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
//        IdMes--;
//        AsignarMes();
//        if (this.lista!=null) {
//            obtenerFila(IdMes);
//        }
        //*****************************************************************
        if (numeroDeEntradas == 0) {            
            lblMes.setText(Mes[0]);        
            return;
        }
        indiceEntradaActual--;
        if (indiceEntradaActual < 0) {
            indiceEntradaActual = numeroDeEntradas - 1;
        }
        IdMes = obtenerFilaNext();
        AsignarMes();
        //*****************************************************************
        cargarTablasOblifinmes();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        try {
            habilitarCajastexto = 1;
            bNuevo = true;
            LimpiarCampos();
            jdcFecha.setFocusable(bNuevo);// es para focalizar
            V v = new V(insertar, new Date());
            
            if (v.getAntecesor()) {
                habilitarCajastexto = 0;//la existencia hace que se genere automaticamente
                if(v.getMensualBE().getGuardado()==1){
                    cargarCamposNuevo(v.getMensualBE());
                    SetearCamposModoEdicion();
                    jdcFecha.setDate(v.sumarRestarDiasFecha(v.getMensualBE().getFecha(), 1));
//                    JOptionPane.showMessageDialog(rootPane, ",,,,,"+jdcFecha.getDate());
                    obtenerFila02();
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Primero Finiquitar del mes "+Mes[(v.getMensualBE().getFecha().getMonth()+1)]+" del año "+(v.getMensualBE().getFecha().getYear()+1900));
                    cargarCampos(lista.get(SelectindiceEntradaActual));
                }
//                VuelveACargarLista();
                
            }else
            SetearCamposModoEdicion();
        } catch (SQLException ex) {
            Logger.getLogger(frmHojaDeCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            if (Integer.parseInt(lblId_Mes.getText()) != 0) {
                habilitarCajastexto = 1;
                bNuevo = false;
                jdcFecha.setFocusCycleRoot(bNuevo);
                //capturamos valor de un jdate chooser y lo asignamos en una variable de tipo Date
//                Date date = new Date();//LUEGO ESOS PARAMATROS LO GUARDAMOS EN UNA VARIABLE
//                date = jdcFecha.getDate();
//                date.setYear(jdcFecha.getCalendar().get(Calendar.YEAR));

                V v = new V(actualizar, new V().fecha(jdcFecha));
//                JOptionPane.showMessageDialog(rootPane, "VALIDO "+new Validar().fecha(jdcFecha));
//                JOptionPane.showMessageDialog(rootPane, "Primero Finiquitar De la fecha "+v.getMensualBE().getFecha());
                if (mensualBE.getGuardado()== 0) {
                   if (v.getAntecesor()) {
                        habilitarCajastexto = 0;//la existencia hace que se genere automaticamente
                    }
                    SetearCamposModoEdicion(); 
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmHojaDeCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        SetearCamposModoGrabado();

//        If grdBusqueda.Rows.Count = 0 Then
//            LimpiarCampos()
//            txtCodigo.Tag = ""
//            btnModificar.Enabled = False
//            btnEliminar.Enabled = False
//        Else
//            LlenarCamposDeFilaSeleccionada()
//        End If
//
//        txtCodigo.Focus()
        if (numeroDeEntradas == 0) {
            LimpiarCampos();
        }else{
            cargarCampos(lista.get(SelectindiceEntradaActual));
        }
        bNuevo = false;
    }//GEN-LAST:event_btnDeshacerActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        try {
            SetearCamposModoGrabado();
            Coneccion c = new Coneccion();
            MensualBE mensualBE;
            cMensualBL mensualBL = new cMensualBL();
            int ires = 0;
            if (bNuevo) {
//                Date date = new Date();//LUEGO ESOS PARAMATROS LO GUARDAMOS EN UNA VARIABLE
//                date = jdcFecha.getDate();
//                date.setYear(jdcFecha.getCalendar().get(Calendar.YEAR));
                //************************************************************************
                MensualBE objMensualBE = new MensualBE(3, 0, new V().fecha(jdcFecha), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "1");
                cMensualBLL objCMensualBLL = new cMensualBLL();
                List<MensualBE> objList = objCMensualBLL.Leer(new Coneccion(), objMensualBE);
                for (MensualBE objList1 : objList) {
                    JOptionPane.showMessageDialog(this, "Ya existe una Hoja De Cuenta con esa fecha");
                    return;
                }
                mensualBE = new MensualBE(1, 0, new V().fecha(jdcFecha)//date
                        , Float.parseFloat(txtSaldoAnteriorR.getText()), Float.parseFloat(txtEntradaR.getText()), Float.parseFloat(txtSalidaR.getText()), Float.parseFloat(txtSaldoRestanteR.getText()), Float.parseFloat(txtSaldoAnteriorCC.getText()), Float.parseFloat(txtEntradaCC.getText()), Float.parseFloat(txtSalidaCC.getText()), Float.parseFloat(txtSaldoRestanteCC.getText()), Float.parseFloat(txtSaldoAnteriorO.getText()), Float.parseFloat(txtEntradaO.getText()), Float.parseFloat(txtSalidaO.getText()), Float.parseFloat(txtSaldoRestanteO.getText()), Float.parseFloat(txtTotFondMes.getText()), 0//Float.parseFloat(txtTotalActuales.getText())
                        , 0//Float.parseFloat(txtTotalLargoPlazo.getText())
                        , 0, this.estableser = 0, "1");
                ires = mensualBL.Insertar(c, mensualBE);
                if (ires < 0) {
                    JOptionPane.showMessageDialog(this, "Error al actualizar");
//                    obtenerFila(Integer.parseInt(lblId_Mes.getText()));
                    cargarCampos(lista.get(SelectindiceEntradaActual));
                } else {
                    if (new V().numeroMesjdc(jdcFecha) == 1){//si es enero entonses se realiza lo siguiente
                        jsnAnio.setValue(new V().numeroAniojdc(jdcFecha));
                    }
                    VuelveACargarLista();
                    obtenerFilaId(ires);
                    cargarTablasOblifinmes();
                    JOptionPane.showMessageDialog(this, "transaccion Exitosa");
                }
            } else {
                mensualBE = new MensualBE(3, Integer.parseInt(lblId_Mes.getText()), new V().fecha(jdcFecha), Float.parseFloat(txtSaldoAnteriorR.getText()), Float.parseFloat(txtEntradaR.getText()), Float.parseFloat(txtSalidaR.getText()), Float.parseFloat(txtSaldoRestanteR.getText()), Float.parseFloat(txtSaldoAnteriorCC.getText()), Float.parseFloat(txtEntradaCC.getText()), Float.parseFloat(txtSalidaCC.getText()), Float.parseFloat(txtSaldoRestanteCC.getText()), Float.parseFloat(txtSaldoAnteriorO.getText()), Float.parseFloat(txtEntradaO.getText()), Float.parseFloat(txtSalidaO.getText()), Float.parseFloat(txtSaldoRestanteO.getText()), Float.parseFloat(txtTotFondMes.getText()), 0//Float.parseFloat(txtTotalActuales.getText())
                        , 0//Float.parseFloat(txtTotalLargoPlazo.getText())
                        , 0, estableser = 0, "1");
                ires = mensualBL.Actualizar(c, mensualBE);
                if (ires < 0) {
                    JOptionPane.showMessageDialog(this, "Error al insertar");
                } else {
                    JOptionPane.showMessageDialog(this, "transaccion Exitosa");
                }
                VuelveACargarLista();
                cargarCampos(lista.get(SelectindiceEntradaActual));
//                obtenerFila(Integer.parseInt(lblId_Mes.getText()));//LA RAZON ES SIMPLE SE CAPTURA CON PRECICION MIENTRAS QUE CON ESTO NO ...
            }
            bNuevo = false;

        } catch (SQLException ex) {
            Logger.getLogger(frmHojaDeCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnFiniquitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiniquitarActionPerformed
        try {
            Coneccion c = new Coneccion();
            MensualBE mensualBE;
            cMensualBL mensualBL = new cMensualBL();
            int ires = 0;
            
            mensualBE = new MensualBE(4, Integer.parseInt(lblId_Mes.getText()), new V().fecha(jdcFecha), Float.parseFloat(txtSaldoAnteriorR.getText()), Float.parseFloat(txtEntradaR.getText()), Float.parseFloat(txtSalidaR.getText()), Float.parseFloat(txtSaldoRestanteR.getText()), Float.parseFloat(txtSaldoAnteriorCC.getText()), Float.parseFloat(txtEntradaCC.getText()), Float.parseFloat(txtSalidaCC.getText()), Float.parseFloat(txtSaldoRestanteCC.getText()), Float.parseFloat(txtSaldoAnteriorO.getText()), Float.parseFloat(txtEntradaO.getText()), Float.parseFloat(txtSalidaO.getText()), Float.parseFloat(txtSaldoRestanteO.getText()), Float.parseFloat(txtTotFondMes.getText()), 0//Float.parseFloat(txtTotalActuales.getText())
                , 0//Float.parseFloat(txtTotalLargoPlazo.getText())
                , 0, estableser = 0, "1");
            ires = mensualBL.Actualizar(c, mensualBE);
            if (ires < 0) {
                JOptionPane.showMessageDialog(this, "Error al Finiquitar");
            } else {
                JOptionPane.showMessageDialog(this, "Exito al Finiquitar");
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmHojaDeCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFiniquitarActionPerformed

    private void jsnAnioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jsnAnioKeyPressed
//        JOptionPane.showMessageDialog(this, "Aqui el click");
    }//GEN-LAST:event_jsnAnioKeyPressed

    private void jsnAnioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jsnAnioMouseClicked
//        JOptionPane.showMessageDialog(this, "Aqui el click ojala");
    }//GEN-LAST:event_jsnAnioMouseClicked

    private void jsnAnioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsnAnioStateChanged
        try {
            VuelveACargarListaAnio();
            cargarTablasOblifinmes();
        } catch (SQLException ex) {
            Logger.getLogger(frmHojaDeCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jsnAnioStateChanged

    private void txtSaldoAnteriorRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoAnteriorRKeyTyped
        keyTyped(evt, txtSaldoAnteriorR.getText());
//        try {
//            float a = Float.parseFloat(txtSaldoAnteriorR.getText());
//            float b = Float.parseFloat(txtSaldoAnteriorCC.getText());//float b = Float.parseFloat(txtEntradaR.getText());
//            float c = Float.parseFloat(txtSalidaR.getText());
//            a = a + b - c;
//            txtSaldoRestanteO.setText("" + a);
//        } catch (Exception e) {
//        }

    }//GEN-LAST:event_txtSaldoAnteriorRKeyTyped

    private void txtEntradaRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntradaRKeyTyped
        keyTyped(evt, txtEntradaR.getText());
    }//GEN-LAST:event_txtEntradaRKeyTyped

    private void txtSalidaRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalidaRKeyTyped
        keyTyped(evt, txtSalidaR.getText());
    }//GEN-LAST:event_txtSalidaRKeyTyped

    private void txtSaldoRestanteRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoRestanteRKeyTyped
        keyTyped(evt, txtSaldoRestanteR.getText());
    }//GEN-LAST:event_txtSaldoRestanteRKeyTyped

    private void txtSaldoAnteriorCCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoAnteriorCCKeyTyped
        keyTyped(evt, txtSaldoAnteriorCC.getText());
    }//GEN-LAST:event_txtSaldoAnteriorCCKeyTyped

    private void txtEntradaCCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntradaCCKeyTyped
        keyTyped(evt, txtEntradaCC.getText());
    }//GEN-LAST:event_txtEntradaCCKeyTyped

    private void txtSalidaCCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalidaCCKeyTyped
        keyTyped(evt, txtSalidaCC.getText());
    }//GEN-LAST:event_txtSalidaCCKeyTyped

    private void txtSaldoRestanteCCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoRestanteCCKeyTyped
        keyTyped(evt, txtSaldoRestanteCC.getText());
    }//GEN-LAST:event_txtSaldoRestanteCCKeyTyped

    private void txtSaldoAnteriorOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoAnteriorOKeyTyped
        keyTyped(evt, txtSaldoAnteriorO.getText());
    }//GEN-LAST:event_txtSaldoAnteriorOKeyTyped

    private void txtEntradaOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntradaOKeyTyped
        keyTyped(evt, txtEntradaO.getText());
    }//GEN-LAST:event_txtEntradaOKeyTyped

    private void txtSalidaOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalidaOKeyTyped
        keyTyped(evt, txtSalidaO.getText());
    }//GEN-LAST:event_txtSalidaOKeyTyped

    private void txtSaldoRestanteOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoRestanteOKeyTyped
        keyTyped(evt, txtSaldoRestanteO.getText());
    }//GEN-LAST:event_txtSaldoRestanteOKeyTyped

    private void txtTotFondMesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotFondMesKeyTyped
        keyTyped(evt, txtTotFondMes.getText());
    }//GEN-LAST:event_txtTotFondMesKeyTyped

    private void txtTotalActualesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalActualesKeyTyped
        keyTyped(evt, txtTotalActuales.getText());
    }//GEN-LAST:event_txtTotalActualesKeyTyped

    private void txtTotalLargoPlazoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalLargoPlazoKeyTyped
        keyTyped(evt, txtTotalLargoPlazo.getText());
    }//GEN-LAST:event_txtTotalLargoPlazoKeyTyped

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
//        MostrarResultadosConsulta consulta = new MostrarResultadosConsulta();
//        consulta.show();
//        consulta.setVisible(true);
        //SELECT id_mensual,fecha,estableser,flagactivo FROM MENSUAL
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void EGRESOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EGRESOMouseClicked
//        JOptionPane.showMessageDialog(this, "hola");
    }//GEN-LAST:event_EGRESOMouseClicked

    private void txtSaldoAnteriorRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoAnteriorRKeyPressed
//        try {
////            float a = Float.parseFloat(txtSaldoAnteriorR.getText());
////            float b = Float.parseFloat(txtEntradaR.getText());//float b = Float.parseFloat(txtEntradaR.getText());
////            float c = Float.parseFloat(txtSalidaR.getText());
////            a = a + b - c;
//            txtSaldoRestanteR.setText(txtSaldoAnteriorR.getText());
////            JOptionPane.showMessageDialog(rootPane, "que ");
//        } catch (Exception e) {
//        }
    }//GEN-LAST:event_txtSaldoAnteriorRKeyPressed

    private void txtSaldoAnteriorRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoAnteriorRKeyReleased
        try {
            float a = Float.parseFloat(txtSaldoAnteriorR.getText());
            float b = Float.parseFloat(txtEntradaR.getText());//float b = Float.parseFloat(txtEntradaR.getText());
            float c = Float.parseFloat(txtSalidaR.getText());
            a = a + b - c;
            txtSaldoRestanteR.setText(""+a);
            sumaTotal();
//            JOptionPane.showMessageDialog(rootPane, "que ");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtSaldoAnteriorRKeyReleased

    private void txtSaldoAnteriorCCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoAnteriorCCKeyReleased
        try {
            float a = Float.parseFloat(txtSaldoAnteriorCC.getText());
            float b = Float.parseFloat(txtEntradaCC.getText());//float b = Float.parseFloat(txtEntradaR.getText());
            float c = Float.parseFloat(txtSalidaCC.getText());
            a = a + b - c;
            txtSaldoRestanteCC.setText(""+a);
            sumaTotal();
//            JOptionPane.showMessageDialog(rootPane, "que ");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtSaldoAnteriorCCKeyReleased

    private void txtSaldoAnteriorOKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoAnteriorOKeyReleased
        try {
            float a = Float.parseFloat(txtSaldoAnteriorO.getText());
            float b = Float.parseFloat(txtEntradaO.getText());//float b = Float.parseFloat(txtEntradaR.getText());
            float c = Float.parseFloat(txtSalidaO.getText());
            a = a + b - c;
            txtSaldoRestanteO.setText(""+a);
            sumaTotal();
//            JOptionPane.showMessageDialog(rootPane, "que ");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtSaldoAnteriorOKeyReleased

    private void btnConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasActionPerformed
        if(ban == 0){
            if (consulta ==null) {
                consulta = new MostrarResultadosConsulta();
                consulta.show();
            }
            ban = 1;
            consulta.setVisible(true);
        }else{
            ban = 0;
            consulta.setVisible(false);
        }
    }//GEN-LAST:event_btnConsultasActionPerformed

    private void btnNumeroEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumeroEntradasActionPerformed
        btnNumeroEntradas.setText(""+numeroDeEntradas);
    }//GEN-LAST:event_btnNumeroEntradasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            frmParametro p = new frmParametro();            
        } catch (SQLException ex) {
            Logger.getLogger(frmHojaDeCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jmpNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmpNuevoActionPerformed
        if (restriccionTabla()){ return;}
        if (jtActuales.getSelectedRow()!=-1){
            OblifinmesC oblifinmesC = null;
            oblifinmesC = new OblifinmesC(0, 0, "", 0, new V().actual, "0");
            mto.insertRow(oblifinmesC);
            jtActuales.getSelectionModel().setSelectionInterval(jtActuales.getRowCount()-1,jtActuales.getRowCount()-1);
        }

    }//GEN-LAST:event_jmpNuevoActionPerformed

    private void jmpGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmpGuardarActionPerformed
        if (restriccionTabla()){ return;}
        int filaSelect = jtActuales.getSelectedRow();
        int id_oblifinmes = Integer.parseInt(jtActuales.getValueAt(filaSelect, 0).toString());
        String descripcion = jtActuales.getValueAt(filaSelect, 2).toString();
        if (descripcion.equals("")) {
            JOptionPane.showMessageDialog(null, "La descripcion no puede ser vacia", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        float monto = Float.parseFloat(jtActuales.getValueAt(filaSelect, 3).toString());
        if (monto==0) {
            JOptionPane.showMessageDialog(null, "monto no puede ser cero intente otra vez", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String flag = jtActuales.getValueAt(filaSelect, 5).toString();
        OblifinmesBE objOblifinmesBE = null;
        cOblifinmesBL oblifinmesBL = new cOblifinmesBL();        
        int ires = 0;
        try {
            if (flag.equals(new V().cFlagInActivo)) {//accion = 1//ACCION 4
                objOblifinmesBE = new OblifinmesBE(5 ,0 , Integer.parseInt(lblId_Mes.getText()), descripcion, monto,new V().actual, new V().cFlagActivo);
//                ires = oblifinmesBL.Insertar(new Coneccion(), objOblifinmesBE,objMensualBE);
                ires = oblifinmesBL.Insertar(new Coneccion(), objOblifinmesBE);
                if (ires<0) {
                    JOptionPane.showMessageDialog(null, "No se guardo", "Advertencia",JOptionPane.WARNING_MESSAGE);
                }else{
                    mto.setValueAt(ires, jtActuales.getSelectedRow(),0);
                    mto.setValueAt(new V().cFlagActivo, jtActuales.getSelectedRow(),5);
                    llenarAutcompleto(new V().cACTUAL_LARGOPLAZO, descripcion);
                    JOptionPane.showMessageDialog(null, "Guardado exitoso", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
                }
            }else{//accio = 1//ACCION = 3
                objOblifinmesBE = new OblifinmesBE(4 ,id_oblifinmes , Integer.parseInt(lblId_Mes.getText()), descripcion, monto,new V().actual, new V().cFlagActivo);
//                ires = oblifinmesBL.Actualizar(new Coneccion(), objOblifinmesBE,objMensualBE);
                ires = oblifinmesBL.Actualizar(new Coneccion(), objOblifinmesBE);
                if (ires<0) {
                    JOptionPane.showMessageDialog(null, "No se guardo", "Advertencia",JOptionPane.WARNING_MESSAGE);
                }else{
                    llenarAutcompleto(new V().cACTUAL_LARGOPLAZO, descripcion);
                    JOptionPane.showMessageDialog(null, "Guardado exitoso", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            resultadoActualLargo();
        } catch (SQLException ex) {
            Logger.getLogger(frmHojaDeCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmpGuardarActionPerformed

    private void jmpEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmpEliminarActionPerformed
        if (restriccionTabla()){ return;}
        if (jtActuales.getSelectedRow()!=-1 ){
            try {
                int filaSelect = jtActuales.getSelectedRow();
                int id_oblifinmes = Integer.parseInt(jtActuales.getValueAt(filaSelect, 0).toString());
                OblifinmesBE objOblifinmesBE = null;
                cOblifinmesBL oblifinmesBL = new cOblifinmesBL();
                int ires = 0;//accion = 1
                objOblifinmesBE = new OblifinmesBE(3 ,id_oblifinmes , Integer.parseInt(lblId_Mes.getText()), "", 0,new V().actual, new V().cFlagActivo);
                ires = oblifinmesBL.Eliminar(new Coneccion(), objOblifinmesBE);
                if (ires<0) {
                    JOptionPane.showMessageDialog(null, "No se Elimino", "Advertencia",JOptionPane.WARNING_MESSAGE);
                }else{
                    mto.deleteRow(jtActuales.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Exito al eliminar", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
                }                
                resultadoActualLargo();
            } catch (SQLException ex) {
                Logger.getLogger(frmHojaDeCuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (jtActuales.getRowCount()==0 ){
            OblifinmesC oblifinmesC = null;
            oblifinmesC = new OblifinmesC(0, 0, "", 0, new V().actual, "0");
            mto.insertRow(oblifinmesC);
            jtActuales.getSelectionModel().setSelectionInterval(0,0);
        }
    }//GEN-LAST:event_jmpEliminarActionPerformed
    
    private void jtActualesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtActualesMouseClicked
        
    }//GEN-LAST:event_jtActualesMouseClicked

    private void jtLargoPlazoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtLargoPlazoMouseClicked
        
    }//GEN-LAST:event_jtLargoPlazoMouseClicked

    private void jmpNuevo02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmpNuevo02ActionPerformed
        if (restriccionTabla()){ return;}
        if (jtLargoPlazo.getSelectedRow()!=-1){
            OblifinmesC oblifinmesC = null;
            oblifinmesC = new OblifinmesC(0, 0, "", 0,  new V().largoPlazo, "0");
            mtl.insertRow(oblifinmesC);
            jtLargoPlazo.getSelectionModel().setSelectionInterval(jtLargoPlazo.getRowCount()-1,jtLargoPlazo.getRowCount()-1);
        }
    }//GEN-LAST:event_jmpNuevo02ActionPerformed

    private void jmpGuardar02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmpGuardar02ActionPerformed
        if (restriccionTabla()){ return;}
        int filaSelect = jtLargoPlazo.getSelectedRow();
        int id_oblifinmes = Integer.parseInt(jtLargoPlazo.getValueAt(filaSelect, 0).toString());
        String descripcion = jtLargoPlazo.getValueAt(filaSelect, 2).toString();
        if (descripcion.equals("")) {
            JOptionPane.showMessageDialog(null, "La descripcion no puede ser vacia", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        float monto = Float.parseFloat(jtLargoPlazo.getValueAt(filaSelect, 3).toString());
        if (monto==0) {
            JOptionPane.showMessageDialog(null, "monto no puede ser cero intente otra vez", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String flag = jtLargoPlazo.getValueAt(filaSelect, 5).toString();
        OblifinmesBE objOblifinmesBE = null;
        cOblifinmesBL oblifinmesBL = new cOblifinmesBL();        
        int ires = 0;
        try {
            if (flag.equals(new V().cFlagInActivo)) {//accion 1//accion 4
                objOblifinmesBE = new OblifinmesBE(5 ,0 , Integer.parseInt(lblId_Mes.getText()), descripcion, monto,new V().largoPlazo, new V().cFlagActivo);
//                ires = oblifinmesBL.Insertar(new Coneccion(), objOblifinmesBE,objMensualBE);
                ires = oblifinmesBL.Insertar(new Coneccion(), objOblifinmesBE);
                if (ires<0) {
                    JOptionPane.showMessageDialog(null, "No se guardo", "Advertencia",JOptionPane.WARNING_MESSAGE);
                }else{
                    mtl.setValueAt(ires, jtLargoPlazo.getSelectedRow(),0);
                    mtl.setValueAt(new V().cFlagActivo, jtLargoPlazo.getSelectedRow(),5);
                    llenarAutcompleto(new V().cACTUAL_LARGOPLAZO, descripcion);
                    JOptionPane.showMessageDialog(null, "Guardado exitoso", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
                }
            }else{//accion 1//accion 3
                objOblifinmesBE = new OblifinmesBE(4 ,id_oblifinmes , Integer.parseInt(lblId_Mes.getText()), descripcion, monto,new V().largoPlazo, new V().cFlagActivo);
//                ires = oblifinmesBL.Actualizar(new Coneccion(), objOblifinmesBE,objMensualBE);
                ires = oblifinmesBL.Actualizar(new Coneccion(), objOblifinmesBE);
                if (ires<0) {
                    JOptionPane.showMessageDialog(null, "No se guardo", "Advertencia",JOptionPane.WARNING_MESSAGE);
                }else{
                    llenarAutcompleto(new V().cACTUAL_LARGOPLAZO, descripcion);
                    JOptionPane.showMessageDialog(null, "Guardado exitoso", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            resultadoActualLargo();
        } catch (SQLException ex) {
            Logger.getLogger(frmHojaDeCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jmpGuardar02ActionPerformed

    private void jmpEliminar02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmpEliminar02ActionPerformed
        if (restriccionTabla()){ 
            return;
        }
        if (jtLargoPlazo.getSelectedRow()!=-1 ){
            try {
                int filaSelect = jtLargoPlazo.getSelectedRow();
                int id_oblifinmes = Integer.parseInt(jtLargoPlazo.getValueAt(filaSelect, 0).toString());
                OblifinmesBE objOblifinmesBE = null;
                cOblifinmesBL oblifinmesBL = new cOblifinmesBL();
                int ires = 0;//1
                objOblifinmesBE = new OblifinmesBE(3 ,id_oblifinmes , Integer.parseInt(lblId_Mes.getText()), "", 0,new V().largoPlazo, new V().cFlagActivo);
                ires = oblifinmesBL.Eliminar(new Coneccion(), objOblifinmesBE);
                if (ires<0) {
                    JOptionPane.showMessageDialog(null, "No se Elimino", "Advertencia",JOptionPane.WARNING_MESSAGE);
                }else{
                    mtl.deleteRow(jtLargoPlazo.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Exito al eliminar", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
                }        
                resultadoActualLargo();
            } catch (SQLException ex) {
                Logger.getLogger(frmHojaDeCuenta.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        if (jtLargoPlazo.getRowCount()==0 ){
            OblifinmesC oblifinmesC = null;
            oblifinmesC = new OblifinmesC(0, 0, "", 0,new V().actual, "0");
            mtl.insertRow(oblifinmesC);
            jtLargoPlazo.getSelectionModel().setSelectionInterval(0,0);
        }
    }//GEN-LAST:event_jmpEliminar02ActionPerformed

    private void jmpNuevoParametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmpNuevoParametroActionPerformed
        if (jtParametro.getSelectedRow()!=-1){
            ParametroC objParametroTC = null;
            objParametroTC = new ParametroC(0, "", "", 0,new V().cFlagInActivo);
            
            mtparametro.insertRow(objParametroTC);
            jtParametro.getSelectionModel().setSelectionInterval(jtParametro.getRowCount()-1,jtParametro.getRowCount()-1);
        }
    }//GEN-LAST:event_jmpNuevoParametroActionPerformed

    private void jmpGuardarParametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmpGuardarParametroActionPerformed
        int filaSelect = jtParametro.getSelectedRow();
        int Id_Par = Integer.parseInt(jtParametro.getValueAt(filaSelect, 0).toString());
        String codigo = jtParametro.getValueAt(filaSelect, 1).toString();
        String descripcion = jtParametro.getValueAt(filaSelect, 2).toString();
        int Id_ParOriginal = Integer.parseInt(jtParametro.getValueAt(filaSelect, 3).toString());
        String flag = jtParametro.getValueAt(filaSelect, 4).toString();
        ParametroBE objParametroBE = null;
        cParametroBL objParametroBL = new cParametroBL();
        int ires = 0;
        try {
            if (Id_Par == 0) {//accion = 1
                objParametroBE = new ParametroBE(1, 0, codigo, descripcion, Id_ParOriginal,flag);
                ires = objParametroBL.Insertar(new Coneccion(), objParametroBE);
                if (ires<0) {
                    JOptionPane.showMessageDialog(null, "No se guardo", "Advertencia",JOptionPane.WARNING_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Guardado exitoso", "Mensaje ",JOptionPane.INFORMATION_MESSAGE);
                    mtparametro.setValueAt(ires, filaSelect,0);
//                    actrualizarParametro(ires, filaSelect, 0);
                }
            }else{//accio = 1
                objParametroBE = new ParametroBE(1, Id_Par, codigo, descripcion, Id_ParOriginal,flag);
                ires = objParametroBL.Actualizar(new Coneccion(), objParametroBE);
                if (ires<0) {
                    JOptionPane.showMessageDialog(null, "No se guardo", "Advertencia",JOptionPane.WARNING_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Guardado exitoso", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmHojaDeCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (codigo.equals("K_N_Nombre")) {
            this.setTitle("HOJA DE CUENTA  CONGREGACION: "+descripcion);
        }
    }//GEN-LAST:event_jmpGuardarParametroActionPerformed

    private void jmpEliminarParametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmpEliminarParametroActionPerformed
        if (jtParametro.getSelectedRow()!=-1 ){
            try {
                int filaSelect = jtParametro.getSelectedRow();
                int id_Par = Integer.parseInt(jtParametro.getValueAt(filaSelect, 0).toString());
                ParametroBE objParametroBE = null;
                cParametroBL objParametroBL = new cParametroBL();
                int ires = 0;//ACCION = 1
                objParametroBE = new ParametroBE(4, id_Par, "", "", 0,new V().cFlagActivo);
                ires = objParametroBL.Actualizar(new Coneccion(), objParametroBE);
                if (ires<0) {
                    JOptionPane.showMessageDialog(null, "No se Elimino", "Advertencia",JOptionPane.WARNING_MESSAGE);
                }else{
                    mtparametro.deleteRow(jtParametro.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Exito al eliminar", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmHojaDeCuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (jtParametro.getRowCount()==0 ){
            ParametroC objParametroC = new ParametroC(0, "", "", 0,new V().cFlagInActivo);
            mtparametro.insertRow(objParametroC);
            jtParametro.getSelectionModel().setSelectionInterval(0,0);
        }
    }//GEN-LAST:event_jmpEliminarParametroActionPerformed

    private void jtParametroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtParametroMouseClicked
        
    }//GEN-LAST:event_jtParametroMouseClicked

    private void txtTotalActuales1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActuales1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActuales1ActionPerformed

    private void txtTotalActuales1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalActuales1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActuales1KeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        JOptionPane.showMessageDialog(rootPane, "Hola como estas");
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtTotalActuales2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActuales2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActuales2ActionPerformed

    private void txtTotalActuales2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalActuales2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActuales2KeyTyped

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setTitle("HOJA DE CUENTA  CONGREGACION: Yanacancha");
    }//GEN-LAST:event_jButton3ActionPerformed
    public void keyTyped(java.awt.event.KeyEvent evt, String s) {
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)
                && (c != '.')) {
            evt.consume();
        }
        if (c == '.' && s.contains(".")) {
            evt.consume();
        }
    }

    private void SetearCamposModoGrabado() { //'no tocar'
        btnNuevo.setEnabled(true);
        btnGrabar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);

        DeshabilitarCampos();
    }

    private void SetearCamposModoEdicion() { //'no tocar'
        btnNuevo.setEnabled(false);
        btnGrabar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);

        HabilitarCampos();
    }
    private void SetearCamposModoEdicion02() { //'CUANDO SOLO EDITA LOS BOTONES'
        btnNuevo.setEnabled(false);
        btnGrabar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);

//        HabilitarCampos();
    }

    private void DeshabilitarCampos() {
        jdcFecha.setEnabled(false);
        txtSaldoAnteriorR.setEnabled(false);
        txtEntradaR.setEnabled(false);
        txtSalidaR.setEnabled(false);
        txtSaldoRestanteR.setEnabled(false);

        txtSaldoAnteriorCC.setEnabled(false);
        txtEntradaCC.setEnabled(false);
        txtSalidaCC.setEnabled(false);
        txtSaldoRestanteCC.setEnabled(false);

        txtSaldoAnteriorO.setEnabled(false);
        txtEntradaO.setEnabled(false);
        txtSalidaO.setEnabled(false);
        txtSaldoRestanteO.setEnabled(false);

        txtTotFondMes.setEnabled(false);
    }

    private void HabilitarCampos() {
        if (bNuevo) {
            jdcFecha.setEnabled((habilitarCajastexto == 1) ? true : false);
        }
        txtSaldoAnteriorR.setEnabled((habilitarCajastexto == 1) ? true : false);//***
//        txtEntradaR.setEnabled(true);
//        txtSalidaR.setEnabled(true);
//        txtSaldoRestanteR.setEnabled(true);
        txtEntradaR.setEnabled(false);
        txtSalidaR.setEnabled(false);
        txtSaldoRestanteR.setEnabled(false);

        txtSaldoAnteriorCC.setEnabled((habilitarCajastexto == 1) ? true : false);//***
//        txtEntradaCC.setEnabled(true);
//        txtSalidaCC.setEnabled(true);
//        txtSaldoRestanteCC.setEnabled(true);
        txtEntradaCC.setEnabled(false);
        txtSalidaCC.setEnabled(false);
        txtSaldoRestanteCC.setEnabled(false);

        txtSaldoAnteriorO.setEnabled((habilitarCajastexto == 1) ? true : false);//***
//        txtEntradaO.setEnabled(true);
//        txtSalidaO.setEnabled(true);
//        txtSaldoRestanteO.setEnabled(true);
        txtEntradaO.setEnabled(false);
        txtSalidaO.setEnabled(false);
        txtSaldoRestanteO.setEnabled(false);

        txtTotFondMes.setEnabled(false);
//        txtTotFondMes.setEnabled(true);
    }

    private void LimpiarCampos() {
//        //ENSAYO****************************
//        Validar validar = new Validar();
//        Date d = new Date();
//        //**********************************
//        jdcFecha.setDate(validar.sumarRestarDiasFecha( d, 1));
        lblId_Mes.setText("0");
        jdcFecha.setDate(new Date());
        txtSaldoAnteriorR.setText("0.00");
        txtEntradaR.setText("0.00");
        txtSalidaR.setText("0.00");
        txtSaldoRestanteR.setText("0.00");

        txtSaldoAnteriorCC.setText("0.00");
        txtEntradaCC.setText("0.00");
        txtSalidaCC.setText("0.00");
        txtSaldoRestanteCC.setText("0.00");

        txtSaldoAnteriorO.setText("0.00");
        txtEntradaO.setText("0.00");
        txtSalidaO.setText("0.00");
        txtSaldoRestanteO.setText("0.00");

        txtTotFondMes.setText("0.00");
    }

    public void AsignarMes() {
        if (IdMes == 13) {
            IdMes = 1;
        }
        if (IdMes == 0) {
            IdMes = 12;
        }
        lblMes.setText(Mes[IdMes]);
    }
    public void estableser() {
        //falta establecer a un registro unico
        if (getEstableser() == 0) {
//            this.estableser = 1;
            setEstableser(1);
            btnEstablecer.setText("E");
            btnFiniquitar.setEnabled(false);
            btnImprimir.setEnabled(false);
            anteriorPosterior(true);
//            btnPosterior.setEnabled(true);
//            btnAnterior.setEnabled(true);
//            jsnAnio.setEnabled(true);
               jScrollPane5.setSize(450,400);
            jpCrud.setLocation(1, 420);
            jpCrud.setVisible(true);
            
        } else {
//            this.estableser = 0;
            setEstableser(0);
            btnEstablecer.setText("D");
            btnFiniquitar.setEnabled(true); 
            btnImprimir.setEnabled(true);
            anteriorPosterior(false);
//            btnPosterior.setEnabled(false);
//            btnAnterior.setEnabled(false);
//            jsnAnio.setEnabled(false);
            
            
            jScrollPane5.setSize(450,460);
            jpCrud.setLocation(1, 420);
            jpCrud.setVisible(false);
            
        }
    }
    public void anteriorPosterior(boolean b){
        btnPosterior.setEnabled(b);
        btnAnterior.setEnabled(b);
        jsnAnio.setEnabled(b);
    }
    public int HallandoAnioEstablesido() throws SQLException {
        MensualBE mensualBE = new MensualBE(7, (int) jsnAnio.getValue(), new V().fecha(jdcFecha), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "1");
        cMensualBLL mensualBLL = new cMensualBLL();
        MensualBE listmensualBE = mensualBLL.LeerObj(new Coneccion(), mensualBE);
        if (listmensualBE != null) {
            return new V().numeroAnioR(listmensualBE.getFecha());
        }

        return 0;
    }
    public void VuelveACargarLista() throws SQLException {
        this.numeroDeEntradas = 0;
        this.indiceEntradaActual= 0;
        this.lista = null;
        MensualBE mensualBE = new MensualBE(5, (int) jsnAnio.getValue(), new V().fecha(jdcFecha), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "1");
        cMensualBLL mensualBLL = new cMensualBLL();
        this.lista = mensualBLL.Leer(new Coneccion(), mensualBE);
        numeroDeEntradas = this.lista.size();
    }
    public void VuelveACargarListaAnio() throws SQLException {
        this.numeroDeEntradas = 0;
        this.indiceEntradaActual= 0;
        this.lista = null;
        MensualBE mensualBE = new MensualBE(5, (int) jsnAnio.getValue(), new V().fecha(jdcFecha), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "1");
        cMensualBLL mensualBLL = new cMensualBLL();
        this.lista = mensualBLL.Leer(new Coneccion(), mensualBE);
        numeroDeEntradas = this.lista.size();
        if (numeroDeEntradas!=0) {
            cargarCampos(this.lista.get(0));
        }else{
            LimpiarCampos();
            lblMes.setText(Mes[0]);
        }
    }
    public void obtenerFila(int Id_Mensual) {
        int cont = 1;
        if (numeroDeEntradas != 0) {
            for (MensualBE listaBE : this.lista) {
                if (Id_Mensual != 0 && Id_Mensual == listaBE.getId_Mensual()) {
                    cargarCampos(listaBE);
                    return;
                } else {
                    if (cont == 1) {
                        cargarCampos(listaBE);
                        cont = 0;
                    }
                }
            }
        }
    }
    public void obtenerFilaId(int Id_Mensual) {
        if (numeroDeEntradas != 0) {
            indiceEntradaActual = 0;
            for (MensualBE listaBE : this.lista) {                
                if (Id_Mensual != 0 && Id_Mensual == listaBE.getId_Mensual()) {
                    cargarCampos(listaBE);
                    
                    return;
                }
                indiceEntradaActual++;
            }
        }
    }

    public int obtenerFila02() {
        if (numeroDeEntradas != 0) {
            cargarCamposNuevo(lista.get(indiceEntradaActual));
            return lista.get(indiceEntradaActual).getFecha().getMonth() + 1;
        }
        return 0;
    }
    public int obtenerFilaNext() {
        if (numeroDeEntradas != 0) {
            cargarCampos(lista.get(indiceEntradaActual));
            return lista.get(indiceEntradaActual).getFecha().getMonth() + 1;
        }
        return 0;
    }
    
    public int obtenerFilaEstablecida() {
        if (numeroDeEntradas != 0) {
            /*para buscar al quien esta establecido*/
            int bandera = 0;
            indiceEntradaActual = -1;
            for (MensualBE Me : lista) {
                indiceEntradaActual ++;
                if (Me.getEstableser()==1) {
                    cargarCampos(lista.get(indiceEntradaActual));
                    setEstableser(lista.get(indiceEntradaActual).getEstableser());
                    estableser();
                    bandera = 1;
                    return lista.get(indiceEntradaActual).getFecha().getMonth() + 1;
                }
            }
            if (bandera == 0) {
                indiceEntradaActual = 0;
                cargarCampos(lista.get(indiceEntradaActual));
                setEstableser(lista.get(indiceEntradaActual).getEstableser());
                estableser();
                return lista.get(indiceEntradaActual).getFecha().getMonth() + 1;
            }
        }
        return 0;
    }

    public void cargarCampos(MensualBE mensualBE) {
        SelectindiceEntradaActual = indiceEntradaActual;
        this.mensualBE = mensualBE;
        lblId_Mes.setText("" + mensualBE.getId_Mensual());
        jdcFecha.setDate(mensualBE.getFecha());
//        JOptionPane.showMessageDialog(rootPane, mensualBE.getFecha());
        txtSaldoAnteriorR.setText("" + mensualBE.getSaldoanteriorr());
        txtEntradaR.setText("" + mensualBE.getEntradar());
        txtSalidaR.setText("" + mensualBE.getSalidar());
        txtSaldoRestanteR.setText("" + mensualBE.getSaldorestanter());
        
        txtSaldoAnteriorCC.setText("" + mensualBE.getSaldoanteriorcc());
        txtEntradaCC.setText("" + mensualBE.getEntradacc());
        txtSalidaCC.setText("" + mensualBE.getSalidacc());
        txtSaldoRestanteCC.setText("" + mensualBE.getSaldorestantecc());
        
        txtSaldoAnteriorO.setText("" + mensualBE.getSaldoanterioro());
        txtEntradaO.setText("" + mensualBE.getEntradao());
        txtSalidaO.setText("" + mensualBE.getSalidao());
        txtSaldoRestanteO.setText("" + mensualBE.getSaldorestanteo());

        txtTotFondMes.setText("" + mensualBE.getTotfondmes());
        
        lblGuardado.setText("" + mensualBE.getGuardado());
        txtTotalActuales.setText("" + mensualBE.getTotactual());
        txtTotalLargoPlazo.setText("" + mensualBE.getTotplazo());
        
        //extras
        IdMes = new V().numeroMes(mensualBE.getFecha());
        AsignarMes();
//        lblMes.setText(Mes[IdMes]);
    }
    
    public void cargarCamposNuevo(MensualBE mensualBE) {
        this.mensualBE = mensualBE;
        lblId_Mes.setText("0");
        txtSaldoAnteriorR.setText("" + mensualBE.getSaldorestanter());
//        txtEntradaR.setText(""+mensualBE.getEntradar());
//        txtSalidaR.setText(""+mensualBE.getSalidar());
        txtSaldoRestanteR.setText(""+mensualBE.getSaldorestanter());

        txtSaldoAnteriorCC.setText("" + mensualBE.getSaldorestantecc());
//        txtEntradaCC.setText(""+mensualBE.getEntradacc());
//        txtSalidaCC.setText(""+mensualBE.getSalidacc());
        txtSaldoRestanteCC.setText(""+mensualBE.getSaldorestantecc());

        txtSaldoAnteriorO.setText("" + mensualBE.getSaldorestanteo());
//        txtEntradaO.setText(""+mensualBE.getEntradao());
//        txtSalidaO.setText(""+mensualBE.getSalidao());
        txtSaldoRestanteO.setText(""+mensualBE.getSaldorestanteo());
        
        lblGuardado.setText(""+0);
        txtTotalActuales.setText("" + 0);
        txtTotalLargoPlazo.setText("" + 0);
        
        txtTotFondMes.setText(""+mensualBE.getTotfondmes());
        lblMes.setText(Mes[0]);
    }
    public void sumaTotal(){
        float a=0;
        float b = Float.parseFloat(txtSaldoRestanteR.getText());
        float c = Float.parseFloat(txtSaldoRestanteCC.getText());
        float d = Float.parseFloat(txtSaldoRestanteO.getText());
        a = b + c + d;
        txtTotFondMes.setText(""+a);
    }
    public void  tablaOblifinmesT() throws SQLException{
        this.jtActuales.setModel(mto);
        /* esto es algo que vale*/
        jtActuales.setDefaultRenderer(JTextArea.class, new OblifinmesRenderer());
        int postColumn01 = 2;
        TableColumn column = jtActuales.getColumnModel().getColumn(postColumn01);
        column.setCellEditor(new OblifinmesEditor());        
        
        
////////        jtActuales.setDefaultRenderer(JTextArea.class, new OblifinmesRenderer());
////////        jtActuales.setDefaultEditor( JTextArea.class, new OblifinmesEditor());//*
//        TableColumn tableColumn01=jtActuales.getColumnModel().getColumn(postColumn01);
//        tableColumn01.setCellEditor(new OblifinmesEditor());
        
        jtActuales.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtActuales.getSelectionModel().setSelectionInterval(0,0);
        jtActuales.getColumnModel().getColumn(0).setMaxWidth(50);
        jtActuales.getColumnModel().getColumn(0).setMinWidth(50);
        jtActuales.getColumnModel().getColumn(0).setPreferredWidth(50);
        
        jtActuales.getColumnModel().getColumn(1).setMaxWidth(0);
        jtActuales.getColumnModel().getColumn(1).setMinWidth(0);
        jtActuales.getColumnModel().getColumn(1).setPreferredWidth(0);
        /************************************************************/
        jtActuales.getColumnModel().getColumn(2).setMaxWidth(300);
        jtActuales.getColumnModel().getColumn(2).setMinWidth(300);
        jtActuales.getColumnModel().getColumn(2).setPreferredWidth(300);
        /************************************************************/
        jtActuales.getColumnModel().getColumn(4).setMaxWidth(0);
        jtActuales.getColumnModel().getColumn(4).setMinWidth(0);
        jtActuales.getColumnModel().getColumn(4).setPreferredWidth(0);
        
        jtActuales.getColumnModel().getColumn(5).setMaxWidth(0);
        jtActuales.getColumnModel().getColumn(5).setMinWidth(0);
        jtActuales.getColumnModel().getColumn(5).setPreferredWidth(0);
    }
    public void  tablaOblifinmesTL() throws SQLException{
        
        this.jtLargoPlazo.setModel(mtl);
        
        jtLargoPlazo.setDefaultRenderer(JTextArea.class, new OblifinmesRenderer());
        int postColumn01 = 2;
        TableColumn column = jtLargoPlazo.getColumnModel().getColumn(postColumn01);
        column.setCellEditor(new OblifinmesEditor02());
        
        jtLargoPlazo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtLargoPlazo.getSelectionModel().setSelectionInterval(0,0);
        jtLargoPlazo.getColumnModel().getColumn(0).setMaxWidth(50);
        jtLargoPlazo.getColumnModel().getColumn(0).setMinWidth(50);
        jtLargoPlazo.getColumnModel().getColumn(0).setPreferredWidth(50);
        
        jtLargoPlazo.getColumnModel().getColumn(1).setMaxWidth(0);
        jtLargoPlazo.getColumnModel().getColumn(1).setMinWidth(0);
        jtLargoPlazo.getColumnModel().getColumn(1).setPreferredWidth(0);
        /************************************************************/
        jtLargoPlazo.getColumnModel().getColumn(2).setMaxWidth(300);
        jtLargoPlazo.getColumnModel().getColumn(2).setMinWidth(300);
        jtLargoPlazo.getColumnModel().getColumn(2).setPreferredWidth(300);
        /************************************************************/
        jtLargoPlazo.getColumnModel().getColumn(4).setMaxWidth(0);
        jtLargoPlazo.getColumnModel().getColumn(4).setMinWidth(0);
        jtLargoPlazo.getColumnModel().getColumn(4).setPreferredWidth(0);
        
        jtLargoPlazo.getColumnModel().getColumn(5).setMaxWidth(0);
        jtLargoPlazo.getColumnModel().getColumn(5).setMinWidth(0);
        jtLargoPlazo.getColumnModel().getColumn(5).setPreferredWidth(0);
    }    
    public void  tablaParametro(){        
        this.jtParametro.setModel(mtparametro);     
        jtParametro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtParametro.getSelectionModel().setSelectionInterval(0,0);
        
        jtParametro.getColumnModel().getColumn(0).setMaxWidth(42);
        jtParametro.getColumnModel().getColumn(0).setMinWidth(42);
        jtParametro.getColumnModel().getColumn(0).setPreferredWidth(42);
        
        jtParametro.getColumnModel().getColumn(1).setMaxWidth(70);
        jtParametro.getColumnModel().getColumn(1).setMinWidth(70);
        jtParametro.getColumnModel().getColumn(1).setPreferredWidth(70);
        /************************************************************/
        jtParametro.getColumnModel().getColumn(2).setMaxWidth(230);
        jtParametro.getColumnModel().getColumn(2).setMinWidth(230);
        jtParametro.getColumnModel().getColumn(2).setPreferredWidth(230);
        /************************************************************/
        jtParametro.getColumnModel().getColumn(3).setMaxWidth(80);
        jtParametro.getColumnModel().getColumn(3).setMinWidth(80);
        jtParametro.getColumnModel().getColumn(3).setPreferredWidth(80);        
        
        jtParametro.getColumnModel().getColumn(4).setMaxWidth(0);
        jtParametro.getColumnModel().getColumn(4).setMinWidth(0);
        jtParametro.getColumnModel().getColumn(4).setPreferredWidth(0);
    }
    public void cargarTablasOblifinmes(){
        //*****************************************************************
            if (numeroDeEntradas != 0) {
                if (arranqueTabla != 0) {
                    eliminarfilasActual();
                    eliminarfilaslargoPlazo();
                    try {
                        llenarfilasActual();
                        llenarfilaslargoPlazo();
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                }
            }else{
                eliminarfilasActual();
                eliminarfilaslargoPlazo();
            }
            arranqueTabla = 1;
    }
    public void eliminarfilasActual(){
        while(jtActuales.getRowCount()!=0 ){
            jtActuales.getSelectionModel().setSelectionInterval(jtActuales.getRowCount()-1,jtActuales.getRowCount()-1);//de fila tal a fila tal...
            mto.deleteRow(jtActuales.getSelectedRow());
        }
    }
    public void llenarfilasActual() throws SQLException {
        int id_mensual = Integer.parseInt(lblId_Mes.getText());
        List<OblifinmesC> listoblifinmesC = new OblifinmesC(0, 0,"", 0, "", "").getOblifinmesC(id_mensual);
        for (OblifinmesC listoblifinmesC1 : listoblifinmesC) {
            mto.insertRow(listoblifinmesC1);
        }
        jtActuales.getSelectionModel().setSelectionInterval(0,0);//de fila tal a fila tal...
    }
    public void eliminarfilaslargoPlazo(){
        while(jtLargoPlazo.getRowCount()!=0 ){
            jtLargoPlazo.getSelectionModel().setSelectionInterval(jtLargoPlazo.getRowCount()-1,jtLargoPlazo.getRowCount()-1);//de fila tal a fila tal...
            mtl.deleteRow(jtLargoPlazo.getSelectedRow());
        }
    }
    public void llenarfilaslargoPlazo() throws SQLException {
        int id_mensual = Integer.parseInt(lblId_Mes.getText());
        List<OblifinmesC> listoblifinmesC = new OblifinmesC(0, 0, "", 0, "", "").getOblifinmesC01(id_mensual);
        for (OblifinmesC listoblifinmesC1 : listoblifinmesC) {
            mtl.insertRow(listoblifinmesC1);
        }
        jtLargoPlazo.getSelectionModel().setSelectionInterval(0,0);//de fila tal a fila tal...
    }
    public boolean restriccionTabla(){
        if (Integer.parseInt(lblId_Mes.getText())== 0) {
            JOptionPane.showMessageDialog(rootPane, "Crear una hoja de cuenta");
            return true;
        }
        if (getEstableser()== 1) {//esta establesido esto juega en contrario
            JOptionPane.showMessageDialog(rootPane, "falta Estableser");
            return true;
        }
        if (lblGuardado.getText().equals(new V().cGuardado)) {
            JOptionPane.showMessageDialog(rootPane, "no se guardará: Esta Finiquitado");
            return true ;
        }
        return false;
    }
    public float sumarMontoActual() {
        float r = 0;
        for (int i = 0; i < jtActuales.getRowCount(); i++) {
            if (jtActuales.getValueAt(i, 5).toString().equals(new V().cFlagActivo)) {
                r=r+Float.parseFloat(jtActuales.getValueAt(i, 3).toString());
            }
        }
        txtTotalActuales.setText(""+r);
        return r;
    }
    public float sumarlargoPlazo() {
        float r = 0;
        for (int i = 0; i < jtLargoPlazo.getRowCount(); i++) {
            if (jtLargoPlazo.getValueAt(i, 5).toString().equals(new V().cFlagActivo)) {
                r=r+Float.parseFloat(jtLargoPlazo.getValueAt(i, 3).toString());
            }
        }
        txtTotalLargoPlazo.setText(""+r);
        return r;
    }    
    public void llenarAutcompleto(String CodigoPadre,String Descripcion) throws SQLException {
        ParametroBE objParametroBE = new ParametroBE(3, 0, CodigoPadre, Descripcion, 0,new V().cFlagActivo);
        cParametroBLL objParametroBLL = new cParametroBLL();
        List<ParametroBE> listParametroBE = objParametroBLL.Leer(new Coneccion(), objParametroBE);
        if (listParametroBE.size() == 0) {
            ParametroBE objParametroBE02 = new ParametroBE(4, 0, CodigoPadre, Descripcion, 0,new V().cFlagActivo);
            cParametroBLL objParametroBLL02 = new cParametroBLL();
            List<ParametroBE> listParametroBE02 = objParametroBLL.Leer(new Coneccion(), objParametroBE02);
            for (ParametroBE listParametroBE021 : listParametroBE02) {
                if (listParametroBE02.size() > 0) {
                    for (ParametroBE obj : listParametroBE02) {
                        ParametroBE objParametroBE03 = new ParametroBE(1, 0, "", Descripcion, listParametroBE021.getId_Parametro(),new V().cFlagActivo);
                        cParametroBL objParametroBL = new cParametroBL();
                        V v = new V();v.selleno = 1;v.selleno02 = 1;
                        if(objParametroBL.Insertar(new Coneccion(), objParametroBE03)< 0){
                            JOptionPane.showMessageDialog(rootPane, "No se inserto datos al auto completado");
                            v.selleno = 0;v.selleno02 = 0;
                        }                        
                        return;
                    }
                }
            }           
            
        }      
        
    }
    public void resultadoActualLargo() throws SQLException{
        MensualBE objMensualBE = new MensualBE(6, Integer.parseInt(lblId_Mes.getText()), new V().fecha(jdcFecha), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "1");
        cMensualBLL objCMensualBLL = new cMensualBLL();
        MensualBE objList = objCMensualBLL.LeerObj(new Coneccion(), objMensualBE);
        if (objList != null) {
            txtTotalActuales.setText(""+objList.getTotactual());
            txtTotalLargoPlazo.setText(""+objList.getTotplazo());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmHojaDeCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHojaDeCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHojaDeCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHojaDeCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmHojaDeCuenta().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frmHojaDeCuenta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane EGRESO;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnConsultas;
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEstablecer;
    private javax.swing.JButton btnFiniquitar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNumeroEntradas;
    private javax.swing.JButton btnPosterior;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JMenuItem jmpEliminar;
    private javax.swing.JMenuItem jmpEliminar02;
    private javax.swing.JMenuItem jmpEliminarParametro;
    private javax.swing.JMenuItem jmpGuardar;
    private javax.swing.JMenuItem jmpGuardar02;
    private javax.swing.JMenuItem jmpGuardarParametro;
    private javax.swing.JMenuItem jmpNuevo;
    private javax.swing.JMenuItem jmpNuevo02;
    private javax.swing.JMenuItem jmpNuevoParametro;
    private javax.swing.JPanel jpCrud;
    private javax.swing.JPanel jpEgreso;
    private javax.swing.JPanel jpIngreso;
    private javax.swing.JPopupMenu jpmCrud;
    private javax.swing.JPopupMenu jpmCrud02;
    private javax.swing.JPopupMenu jpmCrudParametro;
    private javax.swing.JSpinner jsnAnio;
    private javax.swing.JTable jtActuales;
    private javax.swing.JTable jtLargoPlazo;
    private javax.swing.JTable jtParametro;
    private javax.swing.JLabel lblGuardado;
    private javax.swing.JLabel lblId_Mes;
    private javax.swing.JLabel lblMes;
    private javax.swing.JTextField txtEntradaCC;
    private javax.swing.JTextField txtEntradaO;
    private javax.swing.JTextField txtEntradaR;
    private javax.swing.JTextField txtEntradaR1;
    private javax.swing.JTextArea txtQuery;
    private javax.swing.JTextArea txtResultadoQuery;
    private javax.swing.JTextField txtSaldoAnteriorCC;
    private javax.swing.JTextField txtSaldoAnteriorO;
    private javax.swing.JTextField txtSaldoAnteriorR;
    private javax.swing.JTextField txtSaldoAnteriorR1;
    private javax.swing.JTextField txtSaldoRestanteCC;
    private javax.swing.JTextField txtSaldoRestanteO;
    private javax.swing.JTextField txtSaldoRestanteR;
    private javax.swing.JTextField txtSaldoRestanteR1;
    private javax.swing.JTextField txtSalidaCC;
    private javax.swing.JTextField txtSalidaO;
    private javax.swing.JTextField txtSalidaR;
    private javax.swing.JTextField txtSalidaR1;
    private javax.swing.JTextField txtTotFondMes;
    private javax.swing.JTextField txtTotalActuales;
    private javax.swing.JTextField txtTotalActuales1;
    private javax.swing.JTextField txtTotalActuales2;
    private javax.swing.JTextField txtTotalLargoPlazo;
    // End of variables declaration//GEN-END:variables

    public int getEstableser() {
        return estableser;
    }

    public void setEstableser(int estableser) {
        this.estableser = estableser;
    }
}