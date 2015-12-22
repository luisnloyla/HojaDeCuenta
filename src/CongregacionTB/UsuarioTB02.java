package CongregacionTB;

import CongregacionTC.UsuarioTC02;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

public class UsuarioTB02 extends AbstractTableModel{
    private List<UsuarioTC02> objUsuarioTC02 ;//= new ArrayList<UsuarioTC02>() ;
    private String[] columnas = { "Id_Usuario",   "Nombre",    "Password", "FlagActivo","Accion","Boton","Fecha"};
    private Class [] tipoColumna = {Object.class,Object.class,Object.class,Object.class,boolean.class,JPanel.class,JDateChooser.class};
    private boolean [] editables = { true,   true,   true, true,true,true,true};
    
    
    public UsuarioTB02() throws SQLException {
        objUsuarioTC02 = UsuarioTC02.getUsuarioTC02();  
        
    }
    public boolean isCellEditable(int rowIndex,int columnIndex) {
        return editables[columnIndex];
    }
    @Override
    public int getRowCount() {
        return objUsuarioTC02.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }
   
    public String getColumnName(int column) {
        return columnas[column];
    }
    public void insertRow(UsuarioTC02 rowUsuarioTC02) {
        objUsuarioTC02.add(rowUsuarioTC02);
        this.fireTableRowsInserted(objUsuarioTC02.size(), objUsuarioTC02.size());
    }    
    public void deleteRow(int indice) {
        objUsuarioTC02.remove(indice);
        this.fireTableRowsDeleted(indice, indice);
    }
    public UsuarioTC02 getRow(int rowIndex) {
        return objUsuarioTC02.get(rowIndex);
    }
    public void updateRow(int indice,UsuarioTC02 rowUsuarioTC02) {
        objUsuarioTC02.set(indice,rowUsuarioTC02);
        this.fireTableRowsUpdated(indice, indice);
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:return objUsuarioTC02.get(rowIndex).getId_Usuario();
            case 1:return objUsuarioTC02.get(rowIndex).getNombre();
            case 2:return objUsuarioTC02.get(rowIndex).getPassword();
            case 3:return objUsuarioTC02.get(rowIndex).getFlagActivo();
            case 4:return objUsuarioTC02.get(rowIndex).getFlagActivoEtiqueta();
//            case 5:return objUsuarioTC02.get(rowIndex).getFlagActivoEtiqueta();
            case 6:return objUsuarioTC02.get(rowIndex).getjDateChooser();
            default:return null;
        }
    }
    public void setValueAt(Object object,int rowIndex, int columnIndex) {
        super.setValueAt(object, rowIndex, rowIndex);
        try {
            switch(columnIndex){
            case 0: objUsuarioTC02.get(rowIndex).setId_Usuario(Integer.valueOf(Integer.parseInt((String) object)));break;
            case 1: objUsuarioTC02.get(rowIndex).setNombre(String.valueOf(object));break;
            case 2: objUsuarioTC02.get(rowIndex).setPassword(String.valueOf(object));break;
            case 3: objUsuarioTC02.get(rowIndex).setFlagActivo(String.valueOf(object));break;
            case 4: objUsuarioTC02.get(rowIndex).setFlagActivoEtiqueta((boolean) object);
                if (objUsuarioTC02.get(rowIndex).getFlagActivoEtiqueta()==false){
                    deleteRow(rowIndex);
                }break;
//            case 5: objUsuarioTC02.get(rowIndex).setBootn(JPanel.valueOf(object));break;
            case 6: objUsuarioTC02.get(rowIndex).setjDateChooser((JDateChooser)object);break;
        }
        } catch (Exception e) {
        }
        
    }
//    public void setColumn(UsuarioTC02 rowUsuarioTC02) {
//        ;
//        this.fireTableRowsInserted(objUsuarioTC02.size(), objUsuarioTC02.size());
//    }
    public Class getColumnClass(int columnIndex){
        return tipoColumna[columnIndex];
    }
}
