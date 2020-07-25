/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Button;

import POJOs.Account;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author hungh
 */
public class BlockButtonRenderer extends JButton implements TableCellRenderer{

    public BlockButtonRenderer() {
        setOpaque(true);
    }

    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Account account = (Account)value;
        ImageIcon img_x = new ImageIcon(getClass().getResource("/Images/x_24_red.png"));
        ImageIcon img_tick = new ImageIcon(getClass().getResource("/Images/tick_24.png"));
        if(account.getIsActive() == 0)
        {
            setText("Block");
            setIcon(img_x);            
        }else if (account.getIsActive() == 1)
        {
            setText("Active");
            setIcon(img_tick);
        }
        return this;
    }
    
}
