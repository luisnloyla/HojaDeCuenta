package congregacion;
import CongregacionTB.UsuarioCBO;
import CongregacionTB.UsuarioCellrendererPP;
import CongregacionTB.UsuarioJPP;
import CongregacionTB.UsuarioTB;
import CongregacionTC.UsuarioTC;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class frmUsuario {
    public frmUsuario() throws SQLException {
        JFrame jf = new JFrame("Usuario");
        final UsuarioTB usuarioTB= new UsuarioTB();
        
        final JTable jt = new JTable(usuarioTB);
        jt.setRowHeight(32);
//        usuarioTB.insertRow(usuarioTC);
        jt.getColumn(jt.getColumnName(0)).setWidth(0);
        jt.getColumn(jt.getColumnName(0)).setMinWidth(0);
        jt.getColumn(jt.getColumnName(0)).setMaxWidth(0);
//        jt.getColumn(jt.getColumnName(1)).setWidth(80);
//        jt.getColumn(jt.getColumnName(1)).setMinWidth(80);
//        jt.getColumn(jt.getColumnName(1)).setMaxWidth(80);
        
        jt.getColumn(jt.getColumnName(3)).setWidth(0);
        jt.getColumn(jt.getColumnName(3)).setMinWidth(0);
        jt.getColumn(jt.getColumnName(3)).setMaxWidth(0);
        
//        TableColumnModel tableColumnModel = jt.getColumnModel();
//        tableColumnModel.removeColumn(jt.getColumn("Id_Usuario"));
        //        jt.setDefaultRenderer(JPanel.class, new UsuarioCellre02());
        JPanel jPanel = new JPanel();
        int postColumn = jt.getColumnModel().getColumnCount()-2;
        TableColumn tableColumn=jt.getColumnModel().getColumn(postColumn);
        tableColumn.setCellEditor(new UsuarioCBO());
        
        int postColumn3 = jt.getColumnModel().getColumnCount()-1;
        jt.setDefaultRenderer(JPanel.class, new UsuarioCellrendererPP());
        TableColumn tableColumn3=jt.getColumnModel().getColumn(postColumn3);
        tableColumn3.setCellEditor(new UsuarioJPP());
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
                UsuarioTC usuarioTC = null;
                if (e.getActionCommand().equals("Insertar")) {
                    usuarioTC = new UsuarioTC(0, null, null, null,"",null);
                    usuarioTB.insertRow(usuarioTC);
                }
                else if (e.getActionCommand().equals("Eliminar")) {
                    if (jt.getSelectedRow()!=-1){
                        usuarioTB.deleteRow(jt.getSelectedRow());
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
    public static void main(String[] args) throws SQLException {
        frmUsuario usuario = new frmUsuario();
        //insertar clase usuario
//        UsuarioTC utc = new UsuarioTC(12, "LUIS NAZARIO", "LU15", "1");
//        utb.insertRow(utc);
    }
}