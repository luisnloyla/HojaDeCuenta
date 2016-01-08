/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuentaTB;
import HojaDeCuentaTC.ParametroTC;
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Loyola
 */
public class ParametroCellRenderer implements TableCellRenderer{
    JPanel jcbParametro = new JPanel();
    Object valorActual;
    ParametroTC ParametroTC02=null;
    ParametroTB ParametroTB02= null;
    int fila = -1;

    public ParametroCellRenderer() {
        jcbParametro.setSize(100, 1000);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object o, boolean bln, boolean bln1, int row, int column) {
        ParametroTB02= (ParametroTB)table.getModel();
        ParametroTC02= ParametroTB02.getRow(row);
        fila= row;
        jcbParametro.setSize(100, 1000);
//        JOptionPane.showMessageDialog(null, "AQUI RE TRAIG EL NOMBRE " + ParametroTC02.getNombre() );
////        ***************************************************
////        ParametroTB.updateRow( row, ParametroTC02) ;
//        if (insertar == 1){
//            ParametroTC02 ParametroTC022= new ParametroTC02(0, "", "", "1", "");
////            ParametroTB.insertRow(ParametroTC022);
//            ParametroTB.insertRow02();
//            insertar = 0;
//        }
////        **************************************************
//        return jcbParametro;
        return (JComponent) table.getValueAt(row, column);
    }
    
}