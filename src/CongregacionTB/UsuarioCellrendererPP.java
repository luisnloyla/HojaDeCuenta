package CongregacionTB;

import CongregacionTC.UsuarioTC;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class UsuarioCellrendererPP implements TableCellRenderer{
    JPanel jcbUsuario = new JPanel();
    Object valorActual;
    UsuarioTC UsuarioTC=null;
    UsuarioTB usuarioTB= null;
    int fila = -1;
    public UsuarioCellrendererPP() {
        jcbUsuario.setSize(100, 1000);
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object o, boolean bln, boolean bln1, int row, int i1) {
        usuarioTB= (UsuarioTB)table.getModel();
        UsuarioTC= usuarioTB.getRow(row);
        fila= row;
        jcbUsuario.setSize(100, 1000);
//        JOptionPane.showMessageDialog(null, "AQUI RE TRAIG EL NOMBRE " + UsuarioTC.getNombre() );
////        ***************************************************
////        usuarioTB.updateRow( row, UsuarioTC) ;
//        if (insertar == 1){
//            UsuarioTC UsuarioTC2= new UsuarioTC(0, "", "", "1", "");
////            usuarioTB.insertRow(UsuarioTC2);
//            usuarioTB.insertRow();
//            insertar = 0;
//        }
////        **************************************************
        return jcbUsuario;
    }
    
}
