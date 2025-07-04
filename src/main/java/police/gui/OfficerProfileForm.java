/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package police.gui;

import police.CSVHandler;
import police.model.Officer;
import javax.swing.*;
import java.awt.*;
import java.io.*;


/**
 *
 * @author HP
 */
public class OfficerProfileForm extends javax.swing.JFrame {

    /**
     * Creates new form OfficerProfileForm
     */
    private static String loggedInUsername;

    public OfficerProfileForm(String loggedInUsername) 
    {
        this.loggedInUsername = loggedInUsername;
        initComponents();
        loadOfficerDetails();
        setLocationRelativeTo(null);
    }
    private void loadOfficerDetails() 
    {
        try 
        {
            CSVHandler csvHandler = new CSVHandler();
            Officer officer = csvHandler.getOfficerDetails(loggedInUsername);
            if (officer != null) 
            {
                Namedisplay.setText(officer.getName());
                BadgeNodisplay.setText(officer.getBadgeNumber());
                Roledisplay.setText(officer.getRole());
                Emaildisplay.setText(officer.getEmail());
                PhoneNodisplay.setText(officer.getPhone());
                ServiceYearsdisplay.setText(String.valueOf(officer.getServiceYears()));
                NoOfCasesSolveddisplay.setText(String.valueOf(officer.getCasesSolved()));
                SuccessPercentagedisplay.setText(String.format("%.1f%%", officer.getSuccessPercentage()));
                OfficerGradedisplay.setText(officer.getGrade());
                // Load image
                if (officer.getImagePath() != null && !officer.getImagePath().isEmpty()) 
                {
                    ImageIcon icon = new ImageIcon(officer.getImagePath());
                    Image scaledImage = icon.getImage().getScaledInstance(180, 280, Image.SCALE_SMOOTH);
                    imageLabel.setIcon(new ImageIcon(scaledImage));
                } 
                else 
                {
                    imageLabel.setText("No Image");
                }
            } 
            else 
            {
                JOptionPane.showMessageDialog(this, "Officer details not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch (IOException e) 
        {
            JOptionPane.showMessageDialog(this, "Error loading officer details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        Namelbl = new javax.swing.JLabel();
        BadgeNolbl = new javax.swing.JLabel();
        Ranklbl = new javax.swing.JLabel();
        Emaillbl = new javax.swing.JLabel();
        PhoneNolbl = new javax.swing.JLabel();
        ServiceYearslbl = new javax.swing.JLabel();
        NoOfCasesSolvedlbl = new javax.swing.JLabel();
        SuccessPercentagelbl = new javax.swing.JLabel();
        OfficerGradelbl = new javax.swing.JLabel();
        Namedisplay = new javax.swing.JLabel();
        BadgeNodisplay = new javax.swing.JLabel();
        Roledisplay = new javax.swing.JLabel();
        Emaildisplay = new javax.swing.JLabel();
        PhoneNodisplay = new javax.swing.JLabel();
        ServiceYearsdisplay = new javax.swing.JLabel();
        NoOfCasesSolveddisplay = new javax.swing.JLabel();
        SuccessPercentagedisplay = new javax.swing.JLabel();
        OfficerGradedisplay = new javax.swing.JLabel();
        imagePanel = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        Backbtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(0, 0, 102));
        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Namelbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Namelbl.setForeground(new java.awt.Color(255, 255, 255));
        Namelbl.setText("Officer Name :");
        mainPanel.add(Namelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 100, 33));

        BadgeNolbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BadgeNolbl.setForeground(java.awt.Color.white);
        BadgeNolbl.setText("Officer Badge No :");
        mainPanel.add(BadgeNolbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 168, 130, 33));

        Ranklbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Ranklbl.setForeground(java.awt.Color.white);
        Ranklbl.setText("Rank :");
        mainPanel.add(Ranklbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 60, 37));

        Emaillbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Emaillbl.setForeground(java.awt.Color.white);
        Emaillbl.setText("Email :");
        mainPanel.add(Emaillbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 60, 31));

        PhoneNolbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PhoneNolbl.setForeground(java.awt.Color.white);
        PhoneNolbl.setText("Phone No : ");
        mainPanel.add(PhoneNolbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 299, 90, 35));

        ServiceYearslbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ServiceYearslbl.setForeground(java.awt.Color.white);
        ServiceYearslbl.setText("Service Years :");
        mainPanel.add(ServiceYearslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 346, 110, 33));

        NoOfCasesSolvedlbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NoOfCasesSolvedlbl.setForeground(java.awt.Color.white);
        NoOfCasesSolvedlbl.setText("No of Cases Solved :");
        mainPanel.add(NoOfCasesSolvedlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 150, 33));

        SuccessPercentagelbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SuccessPercentagelbl.setForeground(java.awt.Color.white);
        SuccessPercentagelbl.setText("Success Percentage :");
        mainPanel.add(SuccessPercentagelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 140, 34));

        OfficerGradelbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        OfficerGradelbl.setForeground(java.awt.Color.white);
        OfficerGradelbl.setText("Officer Grade :");
        mainPanel.add(OfficerGradelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 100, 33));

        Namedisplay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Namedisplay.setForeground(new java.awt.Color(255, 0, 0));
        mainPanel.add(Namedisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 123, 300, 33));

        BadgeNodisplay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BadgeNodisplay.setForeground(new java.awt.Color(255, 0, 0));
        mainPanel.add(BadgeNodisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 283, 33));

        Roledisplay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Roledisplay.setForeground(new java.awt.Color(255, 0, 0));
        mainPanel.add(Roledisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 340, 33));

        Emaildisplay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Emaildisplay.setForeground(new java.awt.Color(255, 0, 0));
        mainPanel.add(Emaildisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 340, 37));

        PhoneNodisplay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PhoneNodisplay.setForeground(new java.awt.Color(255, 0, 0));
        mainPanel.add(PhoneNodisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 299, 320, 33));

        ServiceYearsdisplay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ServiceYearsdisplay.setForeground(new java.awt.Color(255, 0, 0));
        mainPanel.add(ServiceYearsdisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 280, 33));

        NoOfCasesSolveddisplay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NoOfCasesSolveddisplay.setForeground(new java.awt.Color(255, 0, 0));
        mainPanel.add(NoOfCasesSolveddisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 277, 33));

        SuccessPercentagedisplay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SuccessPercentagedisplay.setForeground(new java.awt.Color(255, 0, 0));
        mainPanel.add(SuccessPercentagedisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 268, 33));

        OfficerGradedisplay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        OfficerGradedisplay.setForeground(new java.awt.Color(255, 0, 0));
        mainPanel.add(OfficerGradedisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 319, 33));

        imagePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagePanel.add(imageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 177));

        mainPanel.add(imagePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 210, -1));

        Backbtn.setBackground(new java.awt.Color(204, 0, 0));
        Backbtn.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        Backbtn.setForeground(new java.awt.Color(255, 255, 255));
        Backbtn.setText("Back");
        Backbtn.setBorder(null);
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });
        mainPanel.add(Backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 492, 92, 33));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Wide Latin", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PROFILE INFORMATION");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
           this.dispose();
    }//GEN-LAST:event_BackbtnActionPerformed

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
            java.util.logging.Logger.getLogger(OfficerProfileForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OfficerProfileForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OfficerProfileForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OfficerProfileForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OfficerProfileForm(loggedInUsername).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Backbtn;
    private javax.swing.JLabel BadgeNodisplay;
    private javax.swing.JLabel BadgeNolbl;
    private javax.swing.JLabel Emaildisplay;
    private javax.swing.JLabel Emaillbl;
    private javax.swing.JLabel Namedisplay;
    private javax.swing.JLabel Namelbl;
    private javax.swing.JLabel NoOfCasesSolveddisplay;
    private javax.swing.JLabel NoOfCasesSolvedlbl;
    private javax.swing.JLabel OfficerGradedisplay;
    private javax.swing.JLabel OfficerGradelbl;
    private javax.swing.JLabel PhoneNodisplay;
    private javax.swing.JLabel PhoneNolbl;
    private javax.swing.JLabel Ranklbl;
    private javax.swing.JLabel Roledisplay;
    private javax.swing.JLabel ServiceYearsdisplay;
    private javax.swing.JLabel ServiceYearslbl;
    private javax.swing.JLabel SuccessPercentagedisplay;
    private javax.swing.JLabel SuccessPercentagelbl;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
