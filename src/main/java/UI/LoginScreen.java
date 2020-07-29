/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.AccountDAO;
import File.SupportFile;
import POJOs.Account;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

/**
 *
 * @author hungh
 */
public class LoginScreen extends javax.swing.JDialog {

    /**
     * Creates new form LoginScreen
     */
    
    int isLoginSuccess = -1;
    int accountID = -1; // if account > 0: exist
    
    public LoginScreen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        parentCardLayout.removeAll();
        parentCardLayout.add(signIn);
        parentCardLayout.repaint();
        parentCardLayout.revalidate();
        
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        parentCardLayout = new javax.swing.JPanel();
        signIn = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        signIn_username = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        signIn_password = new javax.swing.JPasswordField();
        signInButton = new javax.swing.JButton();
        closeButton0 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        toSignUp = new javax.swing.JLabel();
        signUp = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        closeButton1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        toSignIn = new javax.swing.JLabel();
        signUp_name = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        signUp_username = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        signUp_password = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        signUp_rePassword = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        signUp_email = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();
        signUpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(700, 500));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setModal(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel2.setBackground(new java.awt.Color(54, 104, 141));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user_2_1.png"))); // NOI18N

        status.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        status.setForeground(new java.awt.Color(255, 255, 255));
        status.setText("SIGN IN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(90, 90, 90))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(status)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parentCardLayout.setBackground(new java.awt.Color(255, 255, 255));
        parentCardLayout.setLayout(new java.awt.CardLayout());

        signIn.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel5.setText("Username");

        signIn_username.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        signIn_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel6.setText("Password");

        signIn_password.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        signIn_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        signInButton.setBackground(new java.awt.Color(51, 153, 255));
        signInButton.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        signInButton.setText("SIGN IN");
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });

        closeButton0.setBackground(new java.awt.Color(54, 104, 141));
        closeButton0.setPreferredSize(new java.awt.Dimension(45, 45));
        closeButton0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButton0MouseClicked(evt);
            }
        });
        closeButton0.setLayout(new java.awt.BorderLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/x_icon.png"))); // NOI18N
        closeButton0.add(jLabel2, java.awt.BorderLayout.CENTER);

        toSignUp.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        toSignUp.setForeground(new java.awt.Color(102, 102, 102));
        toSignUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toSignUp.setText("Not a member? Click here to sign up!");
        toSignUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toSignUpMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout signInLayout = new javax.swing.GroupLayout(signIn);
        signIn.setLayout(signInLayout);
        signInLayout.setHorizontalGroup(
            signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signInLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closeButton0, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signInLayout.createSequentialGroup()
                        .addGroup(signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(toSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))))
            .addGroup(signInLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signInLayout.createSequentialGroup()
                        .addGroup(signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(signIn_username, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(signIn_password, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(76, Short.MAX_VALUE))
                    .addGroup(signInLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 219, Short.MAX_VALUE))))
        );
        signInLayout.setVerticalGroup(
            signInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signInLayout.createSequentialGroup()
                .addComponent(closeButton0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signIn_username, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signIn_password, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(toSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        parentCardLayout.add(signIn, "card2");

        signUp.setBackground(new java.awt.Color(255, 255, 255));
        signUp.setPreferredSize(new java.awt.Dimension(374, 500));

        jLabel11.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel11.setText("Name");

        closeButton1.setBackground(new java.awt.Color(54, 104, 141));
        closeButton1.setPreferredSize(new java.awt.Dimension(45, 45));
        closeButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButton1MouseClicked(evt);
            }
        });
        closeButton1.setLayout(new java.awt.BorderLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/x_icon.png"))); // NOI18N
        closeButton1.add(jLabel3, java.awt.BorderLayout.CENTER);

        toSignIn.setFont(new java.awt.Font("Corbel", 3, 18)); // NOI18N
        toSignIn.setForeground(new java.awt.Color(102, 102, 102));
        toSignIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toSignIn.setText("Already registered? Sign in now!");
        toSignIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toSignInMouseClicked(evt);
            }
        });

        signUp_name.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        signUp_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel9.setText("Username");

        signUp_username.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        signUp_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel12.setText("Password");

        signUp_password.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        signUp_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel8.setText("Retype password");

        signUp_rePassword.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        signUp_rePassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel13.setText("Email");

        signUp_email.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        signUp_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        clearButton.setBackground(new java.awt.Color(51, 153, 255));
        clearButton.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        signUpButton.setBackground(new java.awt.Color(51, 153, 255));
        signUpButton.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        signUpButton.setText("SIGN UP");
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout signUpLayout = new javax.swing.GroupLayout(signUp);
        signUp.setLayout(signUpLayout);
        signUpLayout.setHorizontalGroup(
            signUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signUpLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(signUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(signUp_email, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signUp_name, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9)
                    .addComponent(signUp_username, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(signUp_password, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(signUp_rePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signUpLayout.createSequentialGroup()
                .addContainerGap(329, Short.MAX_VALUE)
                .addComponent(closeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(signUpLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(signUpButton)
                .addGap(30, 30, 30))
            .addGroup(signUpLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(toSignIn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        signUpLayout.setVerticalGroup(
            signUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signUpLayout.createSequentialGroup()
                .addComponent(closeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signUp_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signUp_username, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel12)
                .addGap(4, 4, 4)
                .addComponent(signUp_password, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel8)
                .addGap(4, 4, 4)
                .addComponent(signUp_rePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signUp_email, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(signUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toSignIn)
                .addContainerGap())
        );

        parentCardLayout.add(signUp, "card3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(parentCardLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(parentCardLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void toSignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toSignUpMouseClicked
        // TODO add your handling code here:
        parentCardLayout.removeAll();
        parentCardLayout.add(signUp);
        parentCardLayout.repaint();
        parentCardLayout.revalidate();
        status.setText("SIGN UP");
    }//GEN-LAST:event_toSignUpMouseClicked

    private void toSignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toSignInMouseClicked
        // TODO add your handling code here:
        parentCardLayout.removeAll();
        parentCardLayout.add(signIn);
        parentCardLayout.repaint();
        parentCardLayout.revalidate();
        
        status.setText("SIGN IN");
    }//GEN-LAST:event_toSignInMouseClicked

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
        // TODO add your handling code here:
        boolean b = checkRegister();
        if (b)
        {
            signUp_name.setText("");
            signUp_password.setText("");
            signUp_rePassword.setText("");
            signUp_username.setText("");
            signUp_email.setText("");
            
            parentCardLayout.removeAll();
            parentCardLayout.add(signIn);
            parentCardLayout.repaint();
            parentCardLayout.revalidate();
            status.setText("SIGN IN");
        }
    }//GEN-LAST:event_signUpButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        signUp_name.setText("");
        signUp_password.setText("");
        signUp_rePassword.setText("");
        signUp_username.setText("");
        signUp_email.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void closeButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButton1MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_closeButton1MouseClicked

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInButtonActionPerformed
        // TODO add your handling code here:
        checkLogin();
        if (isLoginSuccess >= 0)
        {
            this.dispose();
        }
    }//GEN-LAST:event_signInButtonActionPerformed

    private void closeButton0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButton0MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_closeButton0MouseClicked

    private boolean checkRegister()
    {
        boolean isRegisterSuccess = false;
        String currentName = signUp_name.getText();
        String currentUsername = signUp_username.getText();
        String currentPassword = new String(signUp_password.getPassword());
        String currentRePassword = new String(signUp_rePassword.getPassword());
        String currentEmail = signUp_email.getText();
        
        if (currentName.equals("") || currentUsername.equals("") || currentPassword.equals("") 
                || currentRePassword.equals("") || currentEmail.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please fill out the fields!");
        }
        else
        {
            if (currentPassword.equals(currentRePassword))
            {
                if(currentPassword.length() < 6)
                {
                    JOptionPane.showMessageDialog(null, "Password needs to contain at least 6 characters!");
                }
                else
                {
                    Account account = AccountDAO.getAccountByUsername(currentUsername);
                    if (account != null)
                    {
                        JOptionPane.showMessageDialog(null, "Username already exists!");
                    }
                    else
                    {
                        try {
                            String passwordHased = SupportFile.getSecurePassword(currentPassword);
                            Account newAccount = new Account();
                            newAccount.setTen(currentName);
                            newAccount.setEmail(currentEmail);
                            newAccount.setUsername(currentUsername);
                            newAccount.setPassword(passwordHased);
                            newAccount.setIsActive(1);
                            newAccount.setAccountType(1);
                            isRegisterSuccess = AccountDAO.addAccount(newAccount);
                            if(isRegisterSuccess)
                            {
                                JOptionPane.showMessageDialog(null, "Register success!. You can login now!");
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "An error occurred!");
                            }

                        } catch (NoSuchAlgorithmException e) {
                            JOptionPane.showMessageDialog(null, "An error occurred!");
                        }
                    }
                }
            }else
            {
                JOptionPane.showMessageDialog(null, "Password not match!");
            }
        }
        return isRegisterSuccess;
    }
    
    public void checkLogin()
    {
        String currentUsername = signIn_username.getText();
        String currentPassword = new String(signIn_password.getPassword());
        
        if (currentUsername.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter username!");
        }
        else
        {
            if (currentPassword.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter password!");
            }
            else 
            {
                Account account = AccountDAO.getAccountByUsername(currentUsername);
                if (account == null)
                {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password!");
                }
                else
                {
                    String passwordDB = account.getPassword();
                    
                    //hashing
                    try {
                        String passwordHased = null;
                        passwordHased = SupportFile.getSecurePassword(currentPassword);

                        if (passwordDB.equals(passwordHased))
                        {
                            if(account.getIsActive() == 1)
                            {
                                isLoginSuccess = account.getAccountType();
                                accountID = account.getIdAccount();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "This account has been blocked!");
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Incorrect username or password!");
                        }
                        
                    } catch (NoSuchAlgorithmException e) {
                        JOptionPane.showMessageDialog(null, "Incorrect username or password!");
                    }
                }
            }
        }
    }
    
    public int getTypeAccount()
    {
        return isLoginSuccess;
    }
    
    public int getAccountID()
    {
        return accountID;
    }
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
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginScreen dialog = new LoginScreen(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton clearButton;
    private javax.swing.JPanel closeButton0;
    private javax.swing.JPanel closeButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel parentCardLayout;
    private javax.swing.JPanel signIn;
    private javax.swing.JButton signInButton;
    private javax.swing.JPasswordField signIn_password;
    private javax.swing.JTextField signIn_username;
    private javax.swing.JPanel signUp;
    private javax.swing.JButton signUpButton;
    private javax.swing.JTextField signUp_email;
    private javax.swing.JTextField signUp_name;
    private javax.swing.JPasswordField signUp_password;
    private javax.swing.JPasswordField signUp_rePassword;
    private javax.swing.JTextField signUp_username;
    private javax.swing.JLabel status;
    private javax.swing.JLabel toSignIn;
    private javax.swing.JLabel toSignUp;
    // End of variables declaration//GEN-END:variables
}
