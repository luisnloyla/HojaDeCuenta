/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CongregacionTB;

import CongregacionTC.UsuarioTC;
import java.awt.Component;
import java.awt.ItemSelectable;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Loyola
 */
public class UsuarioCBO extends AbstractCellEditor implements TableCellEditor{
    JComboBox jcbUsuario = new JComboBox(new String[]{"Operacion","Grabar","Eliminar","Item"});
    Object valorActual;
    UsuarioTC usuarioTC=null;
    UsuarioTB usuarioTB= null;
    int fila = -1;
    
    public UsuarioCBO() {
        ItemListener itemListener;
        itemListener = new ItemListener() {
            
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange()==ItemEvent.SELECTED) {
                    ItemSelectable selectable = e.getItemSelectable();
                    String s =  (String)selectable.getSelectedObjects()[0];
                    valorActual = s;
                    if (s.equals("Grabar")){
                        usuarioTC.setFlagActivo("1");
                    }else if (s.equals("Eliminar")){
                        usuarioTC.setFlagActivo("0");
                        JOptionPane.showMessageDialog(null, "ELIMINAR ");
                        usuarioTB.deleteRow(fila);
                    }else if (s.equals("Item")){
                        usuarioTC.setFlagActivo("1");
                        UsuarioTC usuarioTC2= new UsuarioTC(0, "", "", "1", "",null);
                        usuarioTB.insertRow(usuarioTC2);
//                        JOptionPane.showMessageDialog(null, "AQUI RE TRAIG EL NOMBRE " + usuarioTC.getNombre()+"02" );
                    }
                    
                    if (!s.equals("Operacion") &&!s.equals("Item")){
                        usuarioTC.setFlagActivoEtiqueta(s);
                    }
                }
            }
        };
        jcbUsuario.addItemListener(itemListener);
    }
    public Object getCellEditorValue() {
        return valorActual;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        usuarioTB= (UsuarioTB)table.getModel();
        usuarioTC= usuarioTB.getRow(row);
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
////        ***************************************************
        jcbUsuario.setSelectedItem(usuarioTC.getFlagActivoEtiqueta());
        return jcbUsuario;

    }
}