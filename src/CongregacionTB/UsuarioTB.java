package CongregacionTB;

import CongregacionTC.UsuarioTC;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;

public class UsuarioTB extends AbstractTableModel{
    private List<UsuarioTC> objUsuarioTC ;//= new ArrayList<UsuarioTC>() ;
    private String[] columnas = { "Id_Usuario",   "Nombre",    "Password", "FlagActivo","Accion","Operacion"};
    private boolean [] editables = { true,   true,   true, true,true,true};
    private boolean [] visibles = { false,   true,   true, true,true,true};
    
    public UsuarioTB() throws SQLException {
        objUsuarioTC = UsuarioTC.getUsuarioTC();  
        
    }
    public boolean isCellEditable(int rowIndex,int columnIndex) {
        return editables[columnIndex];
    }
    @Override
    public int getRowCount() {
        return objUsuarioTC.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }
   
    public String getColumnName(int column) {
        return columnas[column];
    }
    public void insertRow(UsuarioTC rowUsuarioTC) {
        objUsuarioTC.add(rowUsuarioTC);
        this.fireTableRowsInserted(objUsuarioTC.size(), objUsuarioTC.size());
    }    
    public void deleteRow(int indice) {
        objUsuarioTC.remove(indice);
        this.fireTableRowsDeleted(indice, indice);
    }
    public UsuarioTC getRow(int rowIndex) {
        return objUsuarioTC.get(rowIndex);
    }
    public void updateRow(int indice,UsuarioTC rowUsuarioTC) {
        objUsuarioTC.set(indice,rowUsuarioTC);
        this.fireTableRowsUpdated(indice, indice);
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:return objUsuarioTC.get(rowIndex).getId_Usuario();
            case 1:return objUsuarioTC.get(rowIndex).getNombre();
            case 2:return objUsuarioTC.get(rowIndex).getPassword();
            case 3:return objUsuarioTC.get(rowIndex).getFlagActivo();
            case 4:return objUsuarioTC.get(rowIndex).getFlagActivoEtiqueta();
            case 5:return objUsuarioTC.get(rowIndex).getJpanel();
            default:return null;
        }
    }
    public void setValueAt(Object object,int rowIndex, int columnIndex) {
        super.setValueAt(object, rowIndex, rowIndex);
        try {
            switch(columnIndex){
            case 0: objUsuarioTC.get(rowIndex).setId_Usuario(Integer.valueOf(Integer.parseInt((String) object)));break;
            case 1: objUsuarioTC.get(rowIndex).setNombre(String.valueOf(object));break;
            case 2: objUsuarioTC.get(rowIndex).setPassword(String.valueOf(object));break;
            case 3: objUsuarioTC.get(rowIndex).setFlagActivo(String.valueOf(object));break;
            case 4: objUsuarioTC.get(rowIndex).setFlagActivoEtiqueta(String.valueOf(object));
//                if (objUsuarioTC.get(rowIndex).getFlagActivoEtiqueta().equals("Eliminar")){
//                    deleteRow(rowIndex);
//                }
                break;
            case 5: objUsuarioTC.get(rowIndex).setJpanel((JPanel)object);
        }
        } catch (Exception e) {
        }
    }
//    public void setColumn(UsuarioTC rowUsuarioTC) {
//        ;
//        this.fireTableRowsInserted(objUsuarioTC.size(), objUsuarioTC.size());
//    }
}
