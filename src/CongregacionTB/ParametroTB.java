package CongregacionTB;
import CongregacionTC.ParametroTC;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

public class ParametroTB extends AbstractTableModel{
    private List<ParametroTC> objParametroTC ;//= new ArrayList<ParametroTC>() ;
    private String[] columnas = { "Id_Parametro",   "Codigo",    "Descripcion", "Id_Parametro_Origen","Operacion"};
    private boolean [] editables = { false,   true,   true, true,true};
    private Class [] tipoColumna = {Object.class,Object.class,Object.class,Object.class,JPanel.class};
    
    public ParametroTB() throws SQLException {
        objParametroTC = ParametroTC.getParametroTC();  
        
    }
    public boolean isCellEditable(int rowIndex,int columnIndex) {
        return editables[columnIndex];
    }
    @Override
    public int getRowCount() {
        return objParametroTC.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }
   
    public String getColumnName(int column) {
        return columnas[column];
    }
    public void insertRow(ParametroTC rowParametroTC) {
        objParametroTC.add(rowParametroTC);
        this.fireTableRowsInserted(objParametroTC.size(), objParametroTC.size());
    }    
    public void deleteRow(int indice) {
        objParametroTC.remove(indice);
        this.fireTableRowsDeleted(indice, indice);
    }
    public ParametroTC getRow(int rowIndex) {
        return objParametroTC.get(rowIndex);
    }
    public void updateRow(int indice,ParametroTC rowParametroTC) {
        objParametroTC.set(indice,rowParametroTC);
        this.fireTableRowsUpdated(indice, indice);
    }
    public Class getColumnClass(int columnIndex){
        return tipoColumna[columnIndex];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:return objParametroTC.get(rowIndex).getId_Parametro();
            case 1:return objParametroTC.get(rowIndex).getCodigo();
            case 2:return objParametroTC.get(rowIndex).getDescripcion();
            case 3:return objParametroTC.get(rowIndex).getId_Parametro_Origen();
            case 4:return objParametroTC.get(rowIndex).getjPanel();
            default:return null;
        }
    }
    public void setValueAt(Object object,int rowIndex, int columnIndex) {
        super.setValueAt(object, rowIndex, rowIndex);
        try {
            switch(columnIndex){
            case 0: objParametroTC.get(rowIndex).setId_Parametro(Integer.valueOf(Integer.parseInt((String) object)));break;
            case 1: objParametroTC.get(rowIndex).setCodigo(String.valueOf(object));break;
            case 2: objParametroTC.get(rowIndex).setDescripcion(String.valueOf(object));break;
            case 3: objParametroTC.get(rowIndex).setId_Parametro_Origen(Integer.valueOf(Integer.parseInt((String) object)));break;         
            case 4: objParametroTC.get(rowIndex).setjPanel((JPanel) object);break;
        }
        } catch (Exception e) {
        }
    }
}
