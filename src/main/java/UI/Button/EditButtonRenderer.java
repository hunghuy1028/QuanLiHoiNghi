/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Button;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author hungh
 */
public class EditButtonRenderer extends JButton implements TableCellRenderer{

    public EditButtonRenderer() {
        setOpaque(true);
    }
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        ImageIcon edit_img2 = new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"));
        setIcon(edit_img2);
        setText("");
        return this;
    }
    
}
