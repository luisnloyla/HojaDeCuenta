package HojaDeCuenta.TB.Editor;
import HojaDeCuenta.AutoCompletar;
import HojaDeCuenta.TB.Class.OblifinmesC;
import HojaDeCuenta.TB.TableModel.OblifinmesTM;
import HojaDeCuentaBE.ParametroBE;
import HojaDeCuentaBL.cParametroBLL;
import HojaDeCuentaVar.V;
import com.mxrck.autocompleter.TextAutoCompleter;
import ejecutar.Coneccion;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

public class OblifinmesEditor extends AbstractCellEditor implements TableCellEditor {
   private OblifinmesC objOblifinmesC;
   private OblifinmesTM objOblifinmesTM;
   protected Object value;
   
   JComponent component = new JTextField();
   TextAutoCompleter textAutoCompleter;
   public OblifinmesEditor() throws SQLException {
//        jTextField = new JTextField();
//        jTextField.setOpaque(true);
//        jTextField.setText("luis");
//        TextAutoCompleter textAutoCompleter = new TextAutoCompleter(jTextField);
//        
//        textAutoCompleter.addItem("maria");
//        textAutoCompleter.addItem("mario");
//        textAutoCompleter.addItem("marcelino");
//        textAutoCompleter.addItem("maira");
//        textAutoCompleter.addItem("manoa");
//        component = new JTextField();
        component.setOpaque(true);
        textAutoCompleter = new TextAutoCompleter((JTextField) component);
        
        textAutoCompleter.addItem("maria");
        textAutoCompleter.addItem("mario");
        textAutoCompleter.addItem("marcelino");
        textAutoCompleter.addItem("maira");
        textAutoCompleter.addItem("manoa");
        llenadoAutomatico();
   }
   @Override
   public Object getCellEditorValue()
   {
//       return jTextField.getText();
       return ((JTextField) component).getText();
   }
   //El editor usara el propio componente. Para que funcione la celda en el modelo debe ser editable.
   @Override
   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
   {
       objOblifinmesTM = (OblifinmesTM)table.getModel();
       objOblifinmesC = objOblifinmesTM.getRow(row);
       if (value== null) {//objDatos.getjDateChooser()
//           objOblifinmesC.setObligacion(new JTextField());
       }
//       component =objOblifinmesC.getObligacion();
        if (isSelected) {
            component.setBackground(table.getSelectionBackground());
        }else {
            component.setBackground(table.getBackground());
        }        
//////        return jTextField;
//        component = objOblifinmesC.getObligacion();
        
        ((JTextField) component).setText(String.valueOf(value));
        if (new V().selleno == 1) {
           try {
               llenadoAutomatico();
               V v = new V();
               v.selleno = 0;
           } catch (SQLException ex) {
               Logger.getLogger(OblifinmesEditor.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        return component;
   }
   public void llenadoAutomatico() throws SQLException{
       ParametroBE objParametroBE = new ParametroBE(2, 0, "ALP", "ACTUAL_LARGOPLAZO", 0);
        cParametroBLL objParametroBLL = new cParametroBLL();
        List<ParametroBE> listParametroBE = objParametroBLL.Leer(new Coneccion(), objParametroBE);
        List<AutoCompletar> aAutoCompletar = new ArrayList<>();        
        for (ParametroBE listR : listParametroBE) {
           AutoCompletar p = new AutoCompletar(""+listR.getDescripcion(), 25);
           aAutoCompletar.add(p);
        }
        textAutoCompleter.removeAllItems();
        textAutoCompleter.addItems(aAutoCompletar.toArray());
   }
}