/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Button;

import POJOs.UserHoinghi;
import java.awt.Component;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author hungh
 */
public class CancelButtonRenderer extends JButton implements TableCellRenderer{

    public CancelButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        UserHoinghi usrHn = (UserHoinghi)value;
        
        Calendar calCon = Calendar.getInstance();
        Calendar calToday = Calendar.getInstance();  
        Date dateCon = usrHn.getConference().getThoiGian();
        calCon.setTime(dateCon);
        if(calCon.compareTo(calToday) <= 0)
        {
            setEnabled(false);
        }
        else{
            setEnabled(true);
        }
        setText("Cancel");
        return this;
    }
    
    
}
