/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package police.gui;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.io.*;
import police.*;

/**
 *
 * @author HP
 */
public class PoliceLoginForm extends javax.swing.JFrame {

    /**
     * Creates new form PoliceLoginForm
     */
    public PoliceLoginForm() 
    {
        initComponents();
        setLocationRelativeTo(null);
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
        mainPanel = new javax.swing.JPanel();
        Usernamelbl = new javax.swing.JLabel();
        Passwordlbl = new javax.swing.JLabel();
        Usernametxt = new javax.swing.JTextField();
        Backbtn = new javax.swing.JButton();
        Loginbtn = new javax.swing.JButton();
        Passwordtxt = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        headinglbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Police Login");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        mainPanel.setBackground(new java.awt.Color(0, 0, 102));
        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mainPanelKeyPressed(evt);
            }
        });
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Usernamelbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Usernamelbl.setForeground(new java.awt.Color(255, 255, 255));
        Usernamelbl.setText("Username :");
        mainPanel.add(Usernamelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 81, 27));

        Passwordlbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Passwordlbl.setForeground(new java.awt.Color(255, 255, 255));
        Passwordlbl.setText("Password :");
        mainPanel.add(Passwordlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 81, -1));

        Usernametxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UsernametxtKeyPressed(evt);
            }
        });
        mainPanel.add(Usernametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 180, 25));

        Backbtn.setBackground(new java.awt.Color(204, 0, 0));
        Backbtn.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        Backbtn.setForeground(new java.awt.Color(255, 255, 255));
        Backbtn.setText("Back");
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });
        mainPanel.add(Backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 100, 30));

        Loginbtn.setBackground(new java.awt.Color(51, 204, 0));
        Loginbtn.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        Loginbtn.setForeground(new java.awt.Color(255, 255, 255));
        Loginbtn.setText("Login");
        Loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginbtnActionPerformed(evt);
            }
        });
        mainPanel.add(Loginbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 110, 30));

        Passwordtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordtxtActionPerformed(evt);
            }
        });
        Passwordtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PasswordtxtKeyPressed(evt);
            }
        });
        mainPanel.add(Passwordtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 180, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        headinglbl.setFont(new java.awt.Font("Wide Latin", 1, 18)); // NOI18N
        headinglbl.setForeground(new java.awt.Color(255, 255, 0));
        headinglbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headinglbl.setText("POLICE LOGIN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(headinglbl, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(headinglbl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        mainPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 70));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        new HomePageForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackbtnActionPerformed

    private void LoginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginbtnActionPerformed
        try 
        {
            String username = Usernametxt.getText().trim();
            String password = new String(Passwordtxt.getPassword()).trim();
            
            if (username.equals("Admin") && password.equals("Admin123")) 
            {
                Session.setLoggedInUsername("Admin");
                JOptionPane.showMessageDialog(this, "Admin login successful!");
                new AdminDashboard().setVisible(true);
                this.dispose();
                return;
            }
            
            CSVHandler csvHandler = new CSVHandler();
            if (csvHandler.authenticateOfficer(Usernametxt.getText(), new String(Passwordtxt.getPassword()))) 
            {
                JOptionPane.showMessageDialog(this, "Login successful!");
                new PoliceDashboardForm(Session.getLoggedInUsername()).setVisible(true);
                this.dispose();
            } 
            else 
            {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch (IOException e) 
        {
            JOptionPane.showMessageDialog(this, "Error during login: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LoginbtnActionPerformed

    private void PasswordtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordtxtActionPerformed

    private void mainPanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mainPanelKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mainPanelKeyPressed

    private void UsernametxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UsernametxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
           Passwordtxt.requestFocusInWindow(); 
        }
    }//GEN-LAST:event_UsernametxtKeyPressed

    private void PasswordtxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordtxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            Loginbtn.doClick();
        }
    }//GEN-LAST:event_PasswordtxtKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new HomePageForm().setVisible(true);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(PoliceLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PoliceLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PoliceLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PoliceLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PoliceLoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Backbtn;
    private javax.swing.JButton Loginbtn;
    private javax.swing.JLabel Passwordlbl;
    private javax.swing.JPasswordField Passwordtxt;
    private javax.swing.JLabel Usernamelbl;
    private javax.swing.JTextField Usernametxt;
    private javax.swing.JLabel headinglbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
