/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Button;

import DAO.AccountDAO;
import POJOs.Account;
import UI.MainScreen;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author hungh
 */
public class BlockButtonEditor extends DefaultCellEditor{
    
    private JButton button;
    private boolean clicked;
    private Account account;
    
    public BlockButtonEditor(JTextField jtf) {
        super(jtf);
        setClickCountToStart(1);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                fireEditingStopped();
                MainScreen.updateDataOfAccount();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        account = (Account)value;    
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
        ImageIcon img_x = new ImageIcon(getClass().getResource("/Images/x_24_red.png"));
        ImageIcon img_tick = new ImageIcon(getClass().getResource("/Images/tick_24.png"));
        if(clicked)
        {
            if(account.getIsActive() == 0) //deactive
            {
                account.setIsActive(1);
                boolean kq = AccountDAO.updateAccount(account);
                if(kq) 
                {
                    button.setText("Block");
                    button.setIcon(img_x);
                }
                else 
                {
                    JOptionPane.showMessageDialog(null, "Fail");
                    button.setText("Active");
                    button.setIcon(img_tick);
                }               
            }
            else if(account.getIsActive() == 1)
            {
                account.setIsActive(0);
                boolean kq = AccountDAO.updateAccount(account);
                if(kq) 
                {   
                    button.setText("Active");
                    button.setIcon(img_tick);
                }
                else 
                {
                    JOptionPane.showMessageDialog(null, "Fail");
                    button.setText("Block");
                    button.setIcon(img_x);
                } 
            }       
        }        
        return account;
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped(); 
    }
}
