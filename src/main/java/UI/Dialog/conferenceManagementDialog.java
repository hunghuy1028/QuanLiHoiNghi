/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Dialog;

import DAO.ConferenceDAO;
import DAO.LocationDAO;
import POJOs.Account;
import POJOs.Conference;
import POJOs.Location;
import POJOs.UserHoinghi;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author hungh
 */
public class conferenceManagementDialog extends javax.swing.JDialog {

    /**
     * Creates new form conferenceManagementDialog
     */
    JDateChooser jdc = new JDateChooser();
    static Conference conference = null;
    static int idLocation = 0;
    File fileChoose = null;
    static List<Location> locations;
    
    public conferenceManagementDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        dateText.setLayout(new BorderLayout());
        dateText.add(jdc, BorderLayout.EAST);
    }
    
    public conferenceManagementDialog(java.awt.Frame parent, boolean modal, Integer idHoiNghi) {
        
        super(parent, modal);
        initComponents();
        dateText.setLayout(new BorderLayout());
        dateText.add(jdc, BorderLayout.EAST);
        jdc.setMinSelectableDate(new Date());
        conference = ConferenceDAO.getConference(idHoiNghi);
        editConference();
    }
    
    
    
    private void editConference()
    {
        jLabel6.setText("Edit conference ID: "+conference.getIdHoiNghi());
        nameText.setText(conference.getTen());
        briefDes_text.setText(conference.getMoTaNgan());
        detailDes_text.setText(conference.getMoTaChiTiet());
        participantsText.setText(String.valueOf(conference.getNgThamDu()));
        imageDisplay.setToolTipText("Please put an image to resource project first.");
        browserButton.setToolTipText("Please put an image to resource project first.");
        imageDisplay.setText("");
        try
        {
            ImageIcon newImg = new ImageIcon(new ImageIcon(conference.getHinhAnh())
                    .getImage().getScaledInstance(260, 150, Image.SCALE_DEFAULT));
            imageDisplay.setIcon(newImg);
        }catch(NullPointerException ex){
            imageDisplay.setText("<html><body>Can't load image. <br>Please put an image to resource project.<br>"
                    + "<b>src/main/resources/Images/</b></body></html>");
        };
        
        
        Date dateCon = conference.getThoiGian();
        jdc.setDate(dateCon);
        Calendar ca = Calendar.getInstance();
        ca.setTime(dateCon);
        jSpinner1.setValue(dateCon);
        
        DefaultTableModel participantsTable = (DefaultTableModel)totalParicipantTable.getModel();
        
        participantsTable.setRowCount(0);
        
        Iterator<UserHoinghi> userHoinghis = conference.getUserHoinghis().iterator();
        int j = 0;
        while(userHoinghis.hasNext())
        {
            UserHoinghi temp = userHoinghis.next();
            Account acc = temp.getAccount();
            if(temp.getStatus() == 1)
            {
                j++;
                participantsTable.addRow(new Object[]{j, acc.getIdAccount(), acc.getUsername(), acc.getTen()});
            }
            
        }
        jLabel9.setText("Participants so far ("+j+")");
        
        locations = LocationDAO.getListLocation();
        for(int l = 0 ; l < locations.size(); l++)
        {
            jComboBox1.addItem((l+1)+" - "+locations.get(l).getTen());
        }
        //jComboBox1.addItem("Thêm địa điểm.");
        idLocation = conference.getLocation().getIdDiaDiem();
        Location lc = conference.getLocation();
        
        for(int m=0; m<locations.size(); m++)
        {
            if(locations.get(m).getIdDiaDiem() == idLocation)
            {
                jComboBox1.setSelectedIndex(m);
                break;
            }
        }
        
        
        jLabel4.setText("<html><body>"+lc.getDiaChi()+"<br> <b>Max: "+lc.getSucChua()+" participants</b>"+"</body></html>");
        jComboBox1.addItemListener((ItemEvent e) -> {
            if(e.getStateChange() == ItemEvent.SELECTED)
            {
                Location l = locations.get(jComboBox1.getSelectedIndex());
                jLabel4.setText("<html><body>"+l.getDiaChi()+"<br> <b>Max: "+l.getSucChua()+" participants</b>"+"</body></html>");
                idLocation = l.getIdDiaDiem();
            }
        });
    }
    
    public static void addCombobox()
    {
        jComboBox1.removeAllItems();
        locations = LocationDAO.getListLocation();
        for(int l = 0 ; l < locations.size(); l++)
        {
            jComboBox1.addItem((l+1)+"-"+locations.get(l).getTen());
        }
        idLocation = conference.getLocation().getIdDiaDiem();
        Location lc = conference.getLocation();
        jComboBox1.setSelectedItem(lc.getTen());
        jLabel4.setText("<html><body>"+lc.getDiaChi()+"<br><b>Max: "+lc.getSucChua()+" participants</b>"+"</body></html>");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        dateText = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        briefDes_text = new javax.swing.JTextArea();
        participantsText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailDes_text = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        totalParicipantTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        imageDisplay = new javax.swing.JLabel();
        browserButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(54, 104, 141));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Edit conference");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel8.setText("Total participants:");

        dateText.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        briefDes_text.setColumns(20);
        briefDes_text.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        briefDes_text.setLineWrap(true);
        briefDes_text.setRows(5);
        briefDes_text.setWrapStyleWord(true);
        jScrollPane2.setViewportView(briefDes_text);

        participantsText.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        participantsText.setText("0");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel5.setText("Date:");

        detailDes_text.setColumns(20);
        detailDes_text.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        detailDes_text.setLineWrap(true);
        detailDes_text.setRows(5);
        detailDes_text.setWrapStyleWord(true);
        jScrollPane1.setViewportView(detailDes_text);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel3.setText("Detail Description:");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel2.setText("Brief Description:");

        nameText.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel1.setText("Name:");

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel11.setText("Location:");

        jComboBox1.setMaximumSize(new java.awt.Dimension(175, 20));
        jComboBox1.setMinimumSize(new java.awt.Dimension(175, 20));
        jComboBox1.setPreferredSize(new java.awt.Dimension(175, 20));

        Date nday = new Date();
        SpinnerDateModel sm = new SpinnerDateModel(nday, null, null, Calendar.HOUR_OF_DAY);
        jSpinner1 = new JSpinner(sm);
        JSpinner.DateEditor de = new JSpinner.DateEditor(jSpinner1, "HH:mm");
        jSpinner1.setEditor(de);

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(participantsText, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner1)
                    .addComponent(dateText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(participantsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(79, 79, 79))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel9.setText("Paricipants so far");

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        totalParicipantTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.No", "ID Account", "Username", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(totalParicipantTable);
        if (totalParicipantTable.getColumnModel().getColumnCount() > 0) {
            totalParicipantTable.getColumnModel().getColumn(0).setResizable(false);
            totalParicipantTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            totalParicipantTable.getColumnModel().getColumn(1).setPreferredWidth(70);
            totalParicipantTable.getColumnModel().getColumn(2).setPreferredWidth(80);
            totalParicipantTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        }

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton1.setText("CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton2.setText("SAVE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel12.setText("Image");

        imageDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageDisplay.setText("Image");
        imageDisplay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        browserButton.setText("Browser...");
        browserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browserButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(imageDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(browserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(browserButton)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12))
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(imageDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:     
        
        Calendar calendarSave = Calendar.getInstance(); 
        calendarSave.setTime(jdc.getDate());
        //hour - minute
        Calendar hourSave = Calendar.getInstance();
        Date valueHour = (Date)jSpinner1.getValue();
        hourSave.setTime(valueHour);
        
        calendarSave.set(Calendar.HOUR_OF_DAY, hourSave.get(Calendar.HOUR_OF_DAY));
        calendarSave.set(Calendar.MINUTE, hourSave.get(Calendar.MINUTE));
        calendarSave.set(Calendar.SECOND, 0);
        if(nameText.getText().isEmpty() || briefDes_text.getText().isEmpty() || detailDes_text.getText().isEmpty()
                || participantsText.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please fill all fields");
            return;
        }
        else
        {
            try {
                conference.setTen(nameText.getText());
                conference.setMoTaNgan(briefDes_text.getText());
                conference.setMoTaChiTiet(detailDes_text.getText());
                conference.setThoiGian(calendarSave.getTime());
                if(fileChoose != null)
                {
                    conference.setHinhAnh(fileChoose.getAbsolutePath());
                }
                Location locationCurrent = LocationDAO.getLocation(idLocation);
                boolean isSameDay = false;
                
                for(Iterator<Conference> confernceIterator = locationCurrent.getConferences().iterator(); 
                        confernceIterator.hasNext();)
                {
                    Conference cNext = confernceIterator.next();
                    if(!Objects.equals(cNext.getIdHoiNghi(), conference.getIdHoiNghi()))
                    {
                        Calendar cCalendar = Calendar.getInstance();
                        cCalendar.setTime(cNext.getThoiGian());
                        isSameDay = (calendarSave.get(Calendar.YEAR) == cCalendar.get(Calendar.YEAR))
                            && (calendarSave.get(Calendar.DAY_OF_YEAR) == cCalendar.get(Calendar.DAY_OF_YEAR));
                    }
                    
                    
                }
                int currentParticipants = Integer.valueOf(participantsText.getText());

                if(currentParticipants > locationCurrent.getSucChua())
                {
                    JOptionPane.showMessageDialog(null, "Number of participants must be smaller than capacity of this location ("
                            +locationCurrent.getSucChua()+" people)");
                }
                else
                {
                    if(isSameDay)
                    {
                        JOptionPane.showMessageDialog(null, "This place have a conference on this day. Please choose another day or another place!");
                    }
                    else{
                        conference.setNgThamDu(currentParticipants);
                        conference.setLocation(locationCurrent);

                        boolean kq = ConferenceDAO.updateConference(conference);
                        if(kq)
                        {
                            JOptionPane.showMessageDialog(null, "Update success");
                        }else
                            JOptionPane.showMessageDialog(null, "Update fail. Try later!");
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter correct number");
            } catch (NullPointerException ex)
            {
                JOptionPane.showMessageDialog(null, "Please choose image");
            }
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void browserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browserButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser f = new JFileChooser();
        f.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "tif"));
        int result = f.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            fileChoose = f.getSelectedFile();
            ImageIcon newImg = new ImageIcon(new ImageIcon(fileChoose.getAbsolutePath())
                    .getImage().getScaledInstance(260, 150, Image.SCALE_DEFAULT));
            imageDisplay.setText("");
            imageDisplay.setIcon(newImg);
        }
        
    }//GEN-LAST:event_browserButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new addNewLocation2(null, true).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(conferenceManagementDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(conferenceManagementDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(conferenceManagementDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(conferenceManagementDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                conferenceManagementDialog dialog = new conferenceManagementDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea briefDes_text;
    private javax.swing.JButton browserButton;
    private javax.swing.JLabel dateText;
    private javax.swing.JTextArea detailDes_text;
    private javax.swing.JLabel imageDisplay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private static javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField participantsText;
    private javax.swing.JTable totalParicipantTable;
    // End of variables declaration//GEN-END:variables
}
