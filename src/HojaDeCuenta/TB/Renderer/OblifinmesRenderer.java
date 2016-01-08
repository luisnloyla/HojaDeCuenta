/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuenta.TB.Renderer;
import HojaDeCuenta.TB.Class.OblifinmesC;
import HojaDeCuenta.TB.TableModel.OblifinmesTM;
import java.awt.Component;
import javax.swing.JComponent;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Loyola
 */
public class OblifinmesRenderer implements TableCellRenderer{
    JTextField field= new JTextField();
    Object valorActual;
    OblifinmesC objOblifinmesC=null;
    OblifinmesTM objOblifinmesTM= null;
    int fila = -1;

    public OblifinmesRenderer() {
        field.setSize(100, 1000);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object o, boolean bln, boolean bln1, int row, int column) {
        objOblifinmesTM= (OblifinmesTM)table.getModel();
        objOblifinmesC= objOblifinmesTM.getRow(row);
        fila= row;
        field.setSize(100, 1000);
//        return field;
        return (JComponent) table.getValueAt(row, column);
    }
    
}