/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Button;

import DAO.AccountConferenceDAO;
import POJOs.UserHoinghi;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author hungh
 */
public class AcceptButtonEditor extends DefaultCellEditor {
    
    private JButton button;
    private Boolean clicked;
    private UserHoinghi usrHn;
    int row;
    JTable table;
    
    public AcceptButtonEditor(JTextField jtf) {
        super(jtf);
        setClickCountToStart(1);
        button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table != null)
                {
                    fireEditingStopped();
                    TableModel model = table.getModel();
                        if (model instanceof DefaultTableModel) {
                            ((DefaultTableModel) model).removeRow(row);
                        }
                }
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        usrHn = (UserHoinghi)value;
        this.table = table;
        this.row= row;
        clicked = true;
        return button;
    }

    @Override
    public boolean stopCellEditing() {
        clicked = false;
        return super.stopCellEditing(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getCellEditorValue() {
        if (clicked) {
            usrHn.setStatus(1);
            boolean kq = AccountConferenceDAO.updateConferenceAndAccount(usrHn);
            if(!kq) JOptionPane.showMessageDialog(null, "Fail");
        }
        
        clicked = false;
        
        return usrHn;
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
