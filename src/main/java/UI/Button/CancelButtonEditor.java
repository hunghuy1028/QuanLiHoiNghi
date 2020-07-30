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
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hungh
 */
public class CancelButtonEditor extends DefaultCellEditor{
    private JButton button;
    private Boolean clicked;
    private Boolean check = true;
    private UserHoinghi usrHn;
    JTable table;
    int row;

    public CancelButtonEditor(JTextField jtf) {
        super(jtf);
        setClickCountToStart(1);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                int option = JOptionPane.showConfirmDialog(null, "Are you sure to unjoin this conference?");
                if(option == JOptionPane.YES_OPTION)
                {
                    boolean kq = AccountConferenceDAO.deleteConferenceAndAccount(usrHn);
                    if(!kq) JOptionPane.showMessageDialog(null, "Fail");
                    else
                    {
                        DefaultTableModel model = (DefaultTableModel)table.getModel();
                        int r = table.getSelectedRow();
                        r = table.convertRowIndexToModel(r);
                        model.removeRow(r);
                        for(int i = row; i<model.getRowCount(); i++)
                        {
                            model.setValueAt(i+1, i, 0);
                        }
                    }
                }
            }
        });
        
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        usrHn = (UserHoinghi)value;
        this.table = table;
        this.row = row;
        button.setText("Cancel");
        Calendar calCon = Calendar.getInstance();
        Calendar calToday = Calendar.getInstance();  
        Date dateCon = usrHn.getConference().getThoiGian();
        calCon.setTime(dateCon);
        if(calCon.compareTo(calToday) <= 0) check = false;
        else check = true;
        
        clicked = true;
        return button;
    }

    @Override
    public boolean stopCellEditing() {
        clicked = false;
        return super.stopCellEditing(); 
    }

    @Override
    public Object getCellEditorValue() {
        
        if (clicked && check) {
            
        }
        
        clicked = false;       
        return usrHn;
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped(); 
    }   
}
