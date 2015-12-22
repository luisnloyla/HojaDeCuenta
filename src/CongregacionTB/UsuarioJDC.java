/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionTB;

import CongregacionTC.UsuarioTC;
import CongregacionTC.UsuarioTC02;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.ItemSelectable;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.AncestorListener;
import javax.swing.table.TableCellEditor;

public class UsuarioJDC extends AbstractCellEditor implements TableCellEditor{
    JDateChooser jcbUsuario = new JDateChooser();
    Object valorActual;
    UsuarioTC02 usuarioTC02=null;
    UsuarioTB02 usuarioTB02= null;
    int fila = -1;
    
    public UsuarioJDC() {
        ItemListener itemListener;
        itemListener = new ItemListener() {
            
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange()==ItemEvent.SELECTED) {
                    ItemSelectable selectable = e.getItemSelectable();
                    String s =  (String)selectable.getSelectedObjects()[0];
                    valorActual = s;
                    if (s.equals("Grabar")){
                        usuarioTC02.setFlagActivo("1");
                    }else if (s.equals("Eliminar")){
                        usuarioTC02.setFlagActivo("0");
                        JOptionPane.showMessageDialog(null, "ELIMINAR " );
                        usuarioTB02.deleteRow(fila);
                    }else if (s.equals("Item")){
                        usuarioTC02.setFlagActivo("1");
                        UsuarioTC usuarioTC2= new UsuarioTC(0, "", "", "1", "",new JPanel());
                        usuarioTB02.insertRow(usuarioTC02);
//                        JOptionPane.showMessageDialog(null, "AQUI RE TRAIG EL NOMBRE " + usuarioTC.getNombre()+"02" );
                    }
                    
                    if (!s.equals("Operacion") &&!s.equals("Item")){
                        usuarioTC02.setFlagActivoEtiqueta(s);
                    }
                }
            }

            
           
        };
        jcbUsuario.addAncestorListener((AncestorListener) itemListener);
    }
    public Object getCellEditorValue() {
        return valorActual;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        UsuarioTB02 usuarioTB02 = (UsuarioTB02)table.getModel();
        usuarioTC02= usuarioTB02.getRow(row);
        fila= row;
//        JOptionPane.showMessageDialog(null, "AQUI RE TRAIG EL NOMBRE " + usuarioTC.getNombre() );
////        ***************************************************
////        usuarioTB.updateRow( row, usuarioTC) ;
//        if (insertar == 1){
//            UsuarioTC usuarioTC2= new UsuarioTC(0, "", "", "1", "");
////            usuarioTB.insertRow(usuarioTC2);
//            usuarioTB.insertRow02();
//            insertar = 0;
//        }
////        **************************************************
        return jcbUsuario;
    }
 
}