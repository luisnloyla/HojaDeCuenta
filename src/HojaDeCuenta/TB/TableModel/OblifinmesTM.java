package HojaDeCuenta.TB.TableModel;
import HojaDeCuenta.TB.Class.OblifinmesC;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;


public class OblifinmesTM extends AbstractTableModel{
    private List<OblifinmesC> objOblifinmesC = new ArrayList<>() ;
    private String[] columnas = {"Id_Oblifinmes","Id_Mensual","Obligacion","Importe","Actual_Plazo","FlagActivo"};
    private boolean [] editables = { true,  true,  true,  true,  true,  true};
    private Class [] tipoColumna = {Object.class,Object.class,JTextField.class,Object.class,Object.class,Object.class};
    
    public OblifinmesTM(int tipo,int id_mensual) throws SQLException {
        if (tipo == 0) {
            objOblifinmesC = OblifinmesC.getOblifinmesC(id_mensual);
        }
        if (tipo == 1) {
            objOblifinmesC = OblifinmesC.getOblifinmesC01(id_mensual);
        }
    }
    public boolean isCellEditable(int rowIndex,int columnIndex) {
        return editables[columnIndex];
    }
    @Override
    public int getRowCount() {
        return objOblifinmesC.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }
    
    public String getColumnName(int column) {
        return columnas[column];
    }
    public void insertRow(OblifinmesC rowOblifinmesC) {
        objOblifinmesC.add(rowOblifinmesC);
        this.fireTableRowsInserted(objOblifinmesC.size(), objOblifinmesC.size());
    }    
    public void deleteRow(int indice) {
        objOblifinmesC.remove(indice);
        this.fireTableRowsDeleted(indice, indice);
    }
    public OblifinmesC getRow(int rowIndex) {
        return objOblifinmesC.get(rowIndex);
    }
    public void updateRow(int indice,OblifinmesC rowOblifinmesC) {
        objOblifinmesC.set(indice,rowOblifinmesC);
        this.fireTableRowsUpdated(indice, indice);
    }
    public Class getColumnClass(int columnIndex){
        return tipoColumna[columnIndex];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:return objOblifinmesC.get(rowIndex).getId_Oblifinmes();
            case 1:return objOblifinmesC.get(rowIndex).getId_Mensual();
            case 2:return objOblifinmesC.get(rowIndex).getObligacion();
            case 3:return objOblifinmesC.get(rowIndex).getImporte();
            case 4:return objOblifinmesC.get(rowIndex).getActual_Plazo();
            case 5:return objOblifinmesC.get(rowIndex).getFlagActivo();
            default:return null;
        }
    }
    public void setValueAt(Object object,int rowIndex, int columnIndex) {
        super.setValueAt(object, rowIndex, rowIndex);
        try {
            switch(columnIndex){
                case 0: objOblifinmesC.get(rowIndex).setId_Oblifinmes(Integer.valueOf(String.valueOf(object)));break;
                case 1: objOblifinmesC.get(rowIndex).setId_Mensual(Integer.valueOf(String.valueOf(object)));break;
//                case 2: objOblifinmesC.get(rowIndex).setObligacion((JTextField) object);break;                
                case 2: objOblifinmesC.get(rowIndex).setObligacion(String.valueOf(object));break;
                case 3: objOblifinmesC.get(rowIndex).setImporte(Float.valueOf(String.valueOf(object)));break;
                case 4: objOblifinmesC.get(rowIndex).setActual_Plazo(String.valueOf(object));break;
                case 5: objOblifinmesC.get(rowIndex).setFlagActivo(String.valueOf(object));break;
            }
        } catch (Exception e) {
        }
    }
}