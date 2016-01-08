package HojaDeCuenta.TB.TableModel;
import HojaDeCuenta.TB.Class.ParametroC;
import java.sql.SQLException;
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class ParametroTM extends AbstractTableModel{
    private List<ParametroC> objParametroTC = new ArrayList<>() ;
//    private String[] columnas = { "Id_Parametro",   "Codigo",    "Descripcion", "Id_Parametro_Origen"};
    private String[] columnas = {"Id_Par","Codigo","Descripcion","Id_ParOrigen"};
    private boolean [] editables = { true       ,   true     ,   true     , true};
    private Class [] tipoColumna = {Object.class,Object.class,Object.class,Object.class};
    
    public ParametroTM() throws SQLException {
        objParametroTC = ParametroC.getParametroTC();
    }
    @Override
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
    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }    
    public void insertRow(ParametroC rowParametroTC) {
        objParametroTC.add(rowParametroTC);
        this.fireTableRowsInserted(objParametroTC.size(), objParametroTC.size());
    }    
    public void deleteRow(int indice) {
        objParametroTC.remove(indice);
        this.fireTableRowsDeleted(indice, indice);
    }
    public ParametroC getRow(int rowIndex) {
        return objParametroTC.get(rowIndex);
    }
    public void updateRow(int indice,ParametroC rowParametroTC) {
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
            default:return null;
        }
    }
    @Override
    public void setValueAt(Object object,int rowIndex, int columnIndex) {
        super.setValueAt(object, rowIndex, rowIndex);
        try {
            switch(columnIndex){
                case 0: objParametroTC.get(rowIndex).setId_Parametro(Integer.valueOf(String.valueOf(object)));break;
                case 1: objParametroTC.get(rowIndex).setCodigo(String.valueOf(object));break;
                case 2: objParametroTC.get(rowIndex).setDescripcion(String.valueOf(object));break;
                case 3: objParametroTC.get(rowIndex).setId_Parametro_Origen(Integer.valueOf(String.valueOf(object)));break;
            }
        } catch (Exception e) {
           System.out.println(e);
        }
    }
}
