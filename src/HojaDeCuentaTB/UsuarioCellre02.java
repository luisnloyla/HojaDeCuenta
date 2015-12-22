/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuentaTB;

import HojaDeCuentaTC.UsuarioTC02;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Loyola
 */
public class UsuarioCellre02 implements TableCellRenderer{
    JPanel jcbUsuario = new JPanel();
    Object valorActual;
    UsuarioTC02 UsuarioTC02=null;
    UsuarioTB02 usuarioTB02= null;
    int fila = -1;

    public UsuarioCellre02() {
        jcbUsuario.setSize(100, 1000);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object o, boolean bln, boolean bln1, int row, int i1) {
        usuarioTB02= (UsuarioTB02)table.getModel();
        UsuarioTC02= usuarioTB02.getRow(row);
        fila= row;
        jcbUsuario.setSize(100, 1000);
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
