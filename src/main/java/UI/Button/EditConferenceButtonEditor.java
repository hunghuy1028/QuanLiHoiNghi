/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Button;

import UI.MainScreen;
import UI.Dialog.conferenceManagementDialog;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author hungh
 */
public class EditConferenceButtonEditor extends DefaultCellEditor {
    private JButton button;
    private boolean clicked;
    private Integer idHn;
    
    public EditConferenceButtonEditor(JTextField jtf) {
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
        idHn = (Integer) value;
        ImageIcon edit_img2 = new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"));
        button.setIcon(edit_img2);
        button.setText("");
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
            new conferenceManagementDialog(MainScreen.getInstance(), true, idHn).setVisible(true);
        }
        clicked = false;
        return idHn;
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
    
}
