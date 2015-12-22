package congregacion;
import CongregacionTB.ParametroCellRenderer;
import CongregacionTB.ParametroJPP;
import CongregacionTB.ParametroTB;
import CongregacionTC.ParametroTC;
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
public class frmParametro {
    public frmParametro() throws SQLException {
        JFrame jf = new JFrame("Parametro");
        final ParametroTB ParametroTB= new ParametroTB();
        final JTable jt = new JTable(ParametroTB);
        jt.setRowHeight(32);
//        ParametroTB.insertRow(ParametroTC);
//
//        jt.getColumn(jt.getColumnName(0)).setWidth(0);
//        jt.getColumn(jt.getColumnName(0)).setMinWidth(0);
//        jt.getColumn(jt.getColumnName(0)).setMaxWidth(0);
        jt.getColumn(jt.getColumnName(4)).setWidth(145);
        jt.getColumn(jt.getColumnName(4)).setMinWidth(145);
        jt.getColumn(jt.getColumnName(4)).setMaxWidth(145);
//
//        jt.getColumn(jt.getColumnName(3)).setWidth(0);
//        jt.getColumn(jt.getColumnName(3)).setMinWidth(0);
//        jt.getColumn(jt.getColumnName(3)).setMaxWidth(0);

//        TableColumnModel tableColumnModel = jt.getColumnModel();
//        tableColumnModel.removeColumn(jt.getColumn("Id_Parametro"));
//        jt.setDefaultRenderer(JPanel.class, new ParametroCellre02());
        JPanel jPanel = new JPanel();
//        int postColumn = jt.getColumnModel().getColumnCount()-2;
//        TableColumn tableColumn=jt.getColumnModel().getColumn(postColumn);
//        tableColumn.setCellEditor(new ParametroJPP());

        int postColumn3 = jt.getColumnModel().getColumnCount()-1;
        jt.setDefaultRenderer(JPanel.class, new ParametroCellRenderer());
        TableColumn tableColumn3=jt.getColumnModel().getColumn(postColumn3);
        tableColumn3.setCellEditor(new ParametroJPP());
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
                ParametroTC ParametroTC = null;
                if (e.getActionCommand().equals("Insertar")) {
                    ParametroTC = new ParametroTC(0, "", "", 0, null);
                    ParametroTB.insertRow(ParametroTC);
                }
                else if (e.getActionCommand().equals("Eliminar")) {
                    if (jt.getSelectedRow()!=-1){
                        ParametroTB.deleteRow(jt.getSelectedRow());
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
        frmParametro Parametro = new frmParametro();
        
        //insertar clase Parametro
//        ParametroTC utc = new ParametroTC(12, "LUIS NAZARIO", "LU15", "1");
//        utb.insertRow(utc);    

    }
}