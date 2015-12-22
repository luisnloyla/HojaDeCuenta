/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuentaTB;

import HojaDeCuentaTC.UsuarioTC02;
import java.awt.Component;
import java.awt.ItemSelectable;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Loyola
 */
public class UsuarioChk extends AbstractCellEditor implements TableCellEditor{
    JCheckBox jcbUsuario = new JCheckBox("no Eliminar");
    Object valorActual;
    UsuarioTC02 UsuarioTC02=null;
    UsuarioTB02 usuarioTB02= null;
    int fila = -1;
    
    public UsuarioChk() {
        
        ItemListener itemListener;
        itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
//                        JOptionPane.showMessageDialog(null, "AQUI RE TRAIG EL NOMBRE " + UsuarioTC02.getNombre() );
                if (e.getStateChange()==ItemEvent.SELECTED) {
//                    JOptionPane.showMessageDialog(null, "si a" + UsuarioTC02.getNombre() );
                    ItemSelectable selectable = e.getItemSelectable();
                    boolean s =  (boolean)selectable.getSelectedObjects()[0];
//                    boolean s =  (boolean)selectable.getSelectedObjects()[0];
                    valorActual = s;
                    
                    UsuarioTC02.setFlagActivoEtiqueta(false);
                    
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