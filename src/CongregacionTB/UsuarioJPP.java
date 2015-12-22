package CongregacionTB;

import CongregacionTC.UsuarioTC;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class UsuarioJPP extends AbstractCellEditor implements TableCellEditor{
    JPanel jcbUsuario = new JPanel();
    Object valorActual;
    UsuarioTC UsuarioTC=null;
    UsuarioTB usuarioTB= null;
    int fila = -1;
    
    JButton button = new JButton("I");
    JButton button2 = new JButton("E");
    JButton button3 = new JButton("+");
    JCalendar calendar = new JCalendar();
    JDateChooser chooser = new JDateChooser();
    
    public UsuarioJPP() {
        
        jcbUsuario.add(button);
        jcbUsuario.add(button2);
        jcbUsuario.add(button3);
//        jcbUsuario.add(button2);
        button.setActionCommand("Insertar");
        button2.setActionCommand("Eliminar");
        button3.setActionCommand("Nuevo");
        jcbUsuario.setSize(5, 5);
        
         ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioTC usuarioTC = null;
                if (e.getActionCommand().equals("Insertar")) {
                    usuarioTC = new UsuarioTC(0, null, null, null,"",null);
                    usuarioTB.insertRow(usuarioTC);
                }
                else if (e.getActionCommand().equals("Eliminar")) {
//                    if (usuarioTB.getSelectedRow()!=-1){
                        usuarioTB.deleteRow(fila);
//                    }
                }
            }
        };
        button.addActionListener(actionListener);
        button2.addActionListener(actionListener);
        button3.addActionListener(actionListener);
    }
    public Object getCellEditorValue() {
        return valorActual;
    }
    
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        
        usuarioTB= (UsuarioTB)table.getModel();
        UsuarioTC= usuarioTB.getRow(row);
        fila= row;

        return jcbUsuario;

    }
}