/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Button;

import POJOs.Conference;
import UI.MainScreen;
import UI.Dialog.RequestUserDialog;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hungh
 */
public class NewRequestButtonEditor extends DefaultCellEditor {
    
    private JButton button;
    private boolean clicked;
    private Conference conference;
    JTable table;
    
    public NewRequestButtonEditor(JTextField jtf) {
        super(jtf);
        setClickCountToStart(1);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        Conference conference2 = (Conference) value;
        this.table = table;
        this.conference = conference2;
        button.setText("Accepting...");
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
        if(clicked)
        {
            new RequestUserDialog(MainScreen.getInstance(), true, conference).setVisible(true);
            
        }
        clicked = false;
        return conference;
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
    
    
}
