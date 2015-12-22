package congregacion;

import CongregacionTB.UsuarioCellre;
import CongregacionTB.UsuarioCellre02;
import CongregacionTB.UsuarioChk;
import CongregacionTB.UsuarioJDC;

import CongregacionTB.UsuarioTB02;
import CongregacionTC.UsuarioTC02;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Component;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.AbstractCellEditor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class frmUsuario02 {
        JFrame jf = new JFrame("Usuario");
        final UsuarioTB02 usuarioTB02= new UsuarioTB02();
        final JTable jt = new JTable(usuarioTB02);
        JPanel jPanel02 = new JPanel();
        JPanel jPanel03 = new JPanel();
        JDateChooser jDateChooser = new JDateChooser();
    public frmUsuario02() throws SQLException {
        
        
//        usuarioTB.insertRow(usuarioTC);
        jt.setRowHeight(32);
        jt.getColumn(jt.getColumnName(0)).setWidth(0);
        jt.getColumn(jt.getColumnName(0)).setMinWidth(0);
        jt.getColumn(jt.getColumnName(0)).setMaxWidth(0);
        
//        jt.getColumn(jt.getColumnName(5)).setWidth(300);
//        jt.getColumn(jt.getColumnName(5)).setMinWidth(300);
//        jt.getColumn(jt.getColumnName(5)).setMaxWidth(300);
        
        

        jt.getColumn(jt.getColumnName(3)).setWidth(0);
        jt.getColumn(jt.getColumnName(3)).setMinWidth(0);
        jt.getColumn(jt.getColumnName(3)).setMaxWidth(0);
        
//        TableColumnModel tableColumnModel = jt.getColumnModel();
//        tableColumnModel.removeColumn(jt.getColumn("Id_Usuario"));
        
        JPanel jPanel = new JPanel();
        int postColumn = jt.getColumnModel().getColumnCount()-3;
        TableColumn tableColumn=jt.getColumnModel().getColumn(postColumn);
        tableColumn.setCellEditor(new UsuarioChk());
        //**********************************************************************
        JButton btnA = new JButton("A");
        JButton btnB = new JButton("B");
        jPanel02.add(btnA);
        jPanel02.add(btnB);
        
        jPanel03.add(jDateChooser);
//        
//        int postColumn2 = jt.getColumnModel().getColumnCount()-2;
//        jt.setDefaultRenderer(JPanel.class, new UsuarioCellRedender());
//        TableColumn tableColumn2=jt.getColumnModel().getColumn(postColumn2);
//        tableColumn2.setCellEditor(new UsuarioCellEditor());
        
        int postColumn3 = jt.getColumnModel().getColumnCount()-1;
//        jt.setDefaultRenderer(JPanel.class, new UsuarioCellre02());
        TableColumn tableColumn3=jt.getColumnModel().getColumn(postColumn3);
        tableColumn3.setCellEditor(new UsuarioJDC());
        //************************
        JButton btnInsertar = new JButton("Insertar");
        JButton btnEliminar = new JButton("Eliminar");
        btnInsertar.setActionCommand("Insertar");
        btnEliminar.setActionCommand("Eliminar");
        
        jPanel.setLayout(new FlowLayout());
        jPanel.add(btnEliminar);
        jPanel.add(btnInsertar);
//        jPanel.setLayout(new GridLayout(10,10));
        jPanel.setVisible(true);
        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioTC02 usuarioTC02 = null;
                if (e.getActionCommand().equals("Insertar")) {
                    usuarioTC02 = new UsuarioTC02(0, null, null, null,true,new JPanel(),new JDateChooser());
                    usuarioTB02.insertRow(usuarioTC02);
                }
                else if (e.getActionCommand().equals("Eliminar")) {
                    if (jt.getSelectedRow()!=-1){
                        usuarioTB02.deleteRow(jt.getSelectedRow());
                    }
                }
            }
        };
        //************************
        btnInsertar.addActionListener(actionListener);
        btnEliminar.addActionListener(actionListener);
        JScrollPane sp = new JScrollPane(jt);
        jf.add(jPanel,BorderLayout.NORTH);
        jf.add(sp,BorderLayout.CENTER);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(600,200);
        jf.setVisible(true);
    }
    public class UsuarioCellRedender implements TableCellRenderer{
     
        public Component getTableCellRendererComponent(JTable table, Object o, boolean bln, boolean bln1, int row, int i1) {

            return jPanel02;
        }
    
    }
    public class UsuarioCellEditor extends AbstractCellEditor implements TableCellEditor{
      
        public Object getCellEditorValue() {
            return "";
        }


        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

            return jPanel02;
        }    
    }
//    //*************************************************************************
//    public class UsuarioCellRedender03 implements TableCellRenderer{
//     
//        public Component getTableCellRendererComponent(JTable table, Object o, boolean bln, boolean bln1, int row, int i1) {
//
//            return jPanel03;
//        }
//    
//    }
//    public class UsuarioCellEditor03 extends AbstractCellEditor implements TableCellEditor{
//      
//        public Object getCellEditorValue() {
//            return "";
//        }
//
//
//        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//
//            return jPanel03;
//        }    
//    }
    //**************************************************************************
    public class UsuarioJDCCellRedender implements TableCellRenderer{
     
        public Component getTableCellRendererComponent(JTable table, Object o, boolean bln, boolean bln1, int row, int i1) {

            return jDateChooser;
        }
    
    }
    public class UsuarioJDCCellEditor extends AbstractCellEditor implements TableCellEditor{
    
        public Object getCellEditorValue() {
            return "";
        }
    
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            
//            fila= row;
            return jDateChooser;

        }
    
    }
    public static void main(String[] args) throws SQLException {
        frmUsuario02 usuario = new frmUsuario02();
        
        //insertar clase usuario
//        UsuarioTC utc = new UsuarioTC(12, "LUIS NAZARIO", "LU15", "1");
//        utb.insertRow(utc);

    }
    
}
