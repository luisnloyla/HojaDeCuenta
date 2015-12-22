package HojaDeCuentaTB;

import HojaDeCuentaTC.UsuarioTC02;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class UsuarioJP extends AbstractCellEditor implements TableCellEditor{
    JPanel jcbUsuario = new JPanel();
    Object valorActual;
    UsuarioTC02 UsuarioTC02=null;
    UsuarioTB02 usuarioTB02= null;
    int fila = -1;
    
    JButton button = new JButton("I");
    JButton button2 = new JButton("E");
    JButton button3 = new JButton("+");
    JCalendar calendar = new JCalendar();
    JDateChooser chooser = new JDateChooser();
    
    public UsuarioJP() {
//        jcbUsuario.add(button);
//        jcbUsuario.add(button2);
//        jcbUsuario.add(button3);
//        jcbUsuario.add(calendar);
        jcbUsuario.add(chooser);
//        jcbUsuario.add(button2);
        jcbUsuario.setSize(5, 5);
//        ItemListener itemListener;
//        itemListener = new ItemListener() {
//            
//            @Override
//            public void itemStateChanged(ItemEvent e) {
////                        JOptionPane.showMessageDialog(null, "AQUI RE TRAIG EL NOMBRE " + UsuarioTC02.getNombre() );
//                if (e.getStateChange()==ItemEvent.SELECTED) {
////                    JOptionPane.showMessageDialog(null, "si a" + UsuarioTC02.getNombre() );
//                    ItemSelectable selectable = e.getItemSelectable();
//                    boolean s =  (boolean)selectable.getSelectedObjects()[0];
//                    valorActual = s;
//                    
//                    UsuarioTC02.setFlagActivoEtiqueta(s);
//                    
//                }
//            }
//        };
//        jcbUsuario.addItemListener(itemListener);
    }
    public Object getCellEditorValue() {
        return valorActual;
    }
    
    
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        
        usuarioTB02= (UsuarioTB02)table.getModel();
        UsuarioTC02= usuarioTB02.getRow(row);
        fila= row;
//        JOptionPane.showMessageDialog(null, "AQUI RE TRAIG EL NOMBRE " + UsuarioTC02.getNombre() );
////        ***************************************************
////        usuarioTB.updateRow( row, UsuarioTC02) ;
//        if (insertar == 1){
//            UsuarioTC02 UsuarioTC022= new UsuarioTC02(0, "", "", "1", "");
////            usuarioTB.insertRow(UsuarioTC022);
//            usuarioTB.insertRow02();
//            insertar = 0;
//        }
////        **************************************************
        return jcbUsuario;

    }
    
}