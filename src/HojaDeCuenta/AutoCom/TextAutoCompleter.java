package HojaDeCuenta.AutoCom;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;

//import twaver.*;

public class TextAutoCompleter {
    ArrayList<String> items = new ArrayList();
    public TextAutoCompleter(final JTextField txtInput) {
        this.items.add(" ");
        setupAutoComplete(txtInput);
    }
    
    private static boolean isAdjusting(JComboBox cbInput) {
        if (cbInput.getClientProperty("is_adjusting") instanceof Boolean) {
            return (Boolean) cbInput.getClientProperty("is_adjusting");
        }
        return false;
    }

    private static void setAdjusting(JComboBox cbInput, boolean adjusting) {
        cbInput.putClientProperty("is_adjusting", adjusting);
    }
    
    public  void setupAutoComplete(final JTextField txtInput) {
        final DefaultComboBoxModel model = new DefaultComboBoxModel();
        final JComboBox cbInput = new JComboBox(model) {
            public Dimension getPreferredSize() {
                return new Dimension(super.getPreferredSize().width, 0);
            }
        };
        setAdjusting(cbInput, false);
        for (String item : items) {
            model.addElement(item);
        }
        cbInput.setSelectedItem(null);
        cbInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isAdjusting(cbInput)) {
                    if (cbInput.getSelectedItem() != null) {
                        txtInput.setText(cbInput.getSelectedItem().toString());
                    }
                }
            }
        });

        txtInput.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                setAdjusting(cbInput, true);
//                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//                    if (cbInput.isPopupVisible()) {
//                        e.setKeyCode(KeyEvent.VK_ENTER);
//                    }
//                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    e.setSource(cbInput);
                    cbInput.dispatchEvent(e);
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        txtInput.setText(cbInput.getSelectedItem().toString());
                        cbInput.setPopupVisible(false);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    cbInput.setPopupVisible(false);
                }
                setAdjusting(cbInput, false);
            }
        });
        txtInput.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateList();
            }

            public void removeUpdate(DocumentEvent e) {
                updateList();
            }
            
            public void changedUpdate(DocumentEvent e) {
                updateList();
            }
            private void updateList() {
                if (items == null) {
                    return;
                }
                setAdjusting(cbInput, true);
                model.removeAllElements();                
                String input = txtInput.getText();
                if (!input.isEmpty()) {
                    for (String item : items) {
//                        if (item.toLowerCase().startsWith(input.toLowerCase())) {
//                            model.addElement(item);
//                        }
                        if (validar(input, item)) {
                            model.addElement(item);                            
                        }
                    }
                }
                cbInput.setPopupVisible(model.getSize() > 0);
                setAdjusting(cbInput, false);
            }
        });
        txtInput.setLayout(new BorderLayout());
        txtInput.add(cbInput, BorderLayout.SOUTH);
    }
    public static List<String> lista(String cad) {        
        List<String> a = new ArrayList<>();
        String k = "";
        cad = cad + " ";
        for (int i = 0; i < cad.length(); i++) {
            if (' '!=cad.charAt(i)) {
                k = k+ cad.charAt(i);
            }else{
                if (k.length()>0) {
                    a.add(k);
                    k = "";
                }
            }
        } 
        return a;
    }
    public static Boolean validar(String txt,String item) {
        List<String> a = lista(txt.toUpperCase());
        item=item.toUpperCase();
        int t = a.size(),cont = 0;
        for (String a1 : a) {
            if (item.contains(a1)) {
                cont++;
            }
        }
        if (t == cont) {
            return true;
        }
        return false;
    }
    public void addItems(ArrayList<String> list) {
        items = list;
    }
    public void removeAllItems() {
        items = null;
    }
}