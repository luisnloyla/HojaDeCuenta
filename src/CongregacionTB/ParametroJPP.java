package CongregacionTB;
import CongregacionBE.ParametroBE;
import CongregacionBL.cParametroBL;
import CongregacionTC.ParametroTC;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import ejecutar.Coneccion;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
public class ParametroJPP extends AbstractCellEditor implements TableCellEditor {
    JPanel jcbParametro = new JPanel();
    Object valorActual;
    ParametroTC objParametroTC=null;
    ParametroTB objParametroTB= null;    
    int fila = -1;
    int columna = -1;
    
    JButton button = new JButton("G");
    JButton button2 = new JButton("E");
    JButton button3 = new JButton("+");
    JCalendar calendar = new JCalendar();
    JDateChooser chooser = new JDateChooser();
    JTable objTable = null;//lo usa item nuevo
    public ParametroJPP() {
        jcbParametro.add(button);
        jcbParametro.add(button2);
        jcbParametro.add(button3);
//        jcbParametro.add(button2);
        button.setActionCommand("Insertar");
        button2.setActionCommand("Eliminar");
        button3.setActionCommand("Nuevo");
        jcbParametro.setSize(15,15);
         ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Insertar")) {
                    if (objParametroTC.getId_Parametro()==0){
                        try {
                            Coneccion coneccion= new Coneccion();
                            Random a = new Random();
                            ParametroBE objBE = new ParametroBE(1, 0, objParametroTC.getCodigo(),objParametroTC.getDescripcion(), objParametroTC.getId_Parametro_Origen());
                            cParametroBL objBL= new cParametroBL();
                            int n=objBL.Insertar(coneccion, objBE);
                            if(n<0){
                                JOptionPane.showMessageDialog(null, "No se Inserto");
                            }else JOptionPane.showMessageDialog(null, "Guardado Exitoso");
//                            JOptionPane.showMessageDialog(null, " N ="+n);
                            objParametroTC.setId_Parametro(n);
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(ParametroJPP.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else{
                        try {
                            Coneccion coneccion= new Coneccion();
                            Random a = new Random();
                            ParametroBE objBE = new ParametroBE(1,  objParametroTC.getId_Parametro(), objParametroTC.getCodigo(),objParametroTC.getDescripcion(), objParametroTC.getId_Parametro_Origen());
                            cParametroBL objBL= new cParametroBL();
                            int n=objBL.Actualizar(coneccion, objBE);
                            if(n<0){
                                JOptionPane.showMessageDialog(null, "No se Actulizo");
                            }else JOptionPane.showMessageDialog(null, "Exito al Actualizar");
                        } catch (SQLException ex) {
                            Logger.getLogger(ParametroJPP.class.getName()).log(Level.SEVERE, null, ex);
                        }   
                    }
                }
                else if (e.getActionCommand().equals("Eliminar")) {
//                    if (ParametroTB.getSelectedRow()!=-1){
                    int resp = JOptionPane.showConfirmDialog(null,"Eliminar; Estas seguro?.","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if (resp==0)
                    {
                        try {
                            Coneccion coneccion= new Coneccion();
                            Random a = new Random();
                            ParametroBE objBE = new ParametroBE(1, objParametroTC.getId_Parametro(), "","", 0);
                            cParametroBL objBL= new cParametroBL();
                            int n=objBL.Eliminar(coneccion, objBE);
                            if(n<0){
                                JOptionPane.showMessageDialog(null, "No se Elimino");                                
                            }else objParametroTB.deleteRow(fila);
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(ParametroJPP.class.getName()).log(Level.SEVERE, null, ex);
                        }                        
                    }
                }else if (e.getActionCommand().equals("Nuevo")) {
                    ParametroTB objTB= (ParametroTB)objTable.getModel();
                    int contador = 0;
                    int Indice;
                    for (int i = 0;i < objTB.getRowCount();i++){
                         ParametroTC objTC =objTB.getRow(i);
                         if (objTC.getId_Parametro()==0) {
                            contador++;
                            Indice = i;
                        }
                    }
//                    int resp = JOptionPane.showConfirmDialog(null,"Nuevo Item; Estas seguro?.","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if (contador==0)
                    {
                        objParametroTC = new ParametroTC(0, "", "", 0, jcbParametro);
                        objParametroTB.insertRow(objParametroTC);
                    }else{
                        JOptionPane.showMessageDialog(null, "Primero Guardar el Item");
                    }
                }
            }
        };
        button.addActionListener(actionListener);
        button2.addActionListener(actionListener);
        button3.addActionListener(actionListener);
//        jcbParametro.addKeyListener(null);
    }
    public Object getCellEditorValue() {
        return valorActual;
    }
    
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        objParametroTB= (ParametroTB)table.getModel();
        objParametroTC= objParametroTB.getRow(row);
        fila= row;
        columna = column;
        objTable= table;
        return jcbParametro;
    }
}