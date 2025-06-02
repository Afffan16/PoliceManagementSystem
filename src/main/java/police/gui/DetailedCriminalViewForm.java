/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package police.gui;
import police.model.Criminal;
import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.Image;

/**
 *
 * @author waqar
 */
public class DetailedCriminalViewForm extends javax.swing.JFrame {

    private static Criminal criminal;
    private static String loggedInUsername;

    public DetailedCriminalViewForm(Criminal criminal, String loggedInUsername) 
    {
        this.loggedInUsername = loggedInUsername;
        initComponents();
        setLocationRelativeTo(null);

        criminalId.setText("Criminal ID : " + criminal.getCriminalId());
        criminalName.setText("Criminal Name : " + criminal.getCriminalName());
        CNIC.setText("CNIC : " + criminal.getCnic());
        Address.setText("Address : " + criminal.getAddress());
        NoOfCrimes.setText("No of Crimes : " + criminal.getNoOfCrimes());
        ArrestStatus.setText("Arrest Status : " + criminal.getArrestStatus());
        dateofArrest.setText("Date of Arrest : " + criminal.getDateOfArrest());
        descriptionLabel.setText("Description For Arrest : " + criminal.getDescriptionForArrest());

 
        try
        {
            ImageIcon imageIcon = new ImageIcon(criminal.getImagePath());
            Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            Imagelbl.setIcon(new ImageIcon(image));
        } 
        catch (Exception e) 
        {
            Imagelbl.setText("Image not available");
        }
    }
    

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        Backbtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        criminalId = new javax.swing.JLabel();
        criminalName = new javax.swing.JLabel();
        CNIC = new javax.swing.JLabel();
        Address = new javax.swing.JLabel();
        NoOfCrimes = new javax.swing.JLabel();
        ArrestStatus = new javax.swing.JLabel();
        dateofArrest = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Imagelbl = new javax.swing.JLabel();
        headinglbl = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(0, 0, 102));
        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        mainPanel.setPreferredSize(new java.awt.Dimension(750, 500));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Backbtn.setBackground(new java.awt.Color(204, 0, 0));
        Backbtn.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        Backbtn.setForeground(new java.awt.Color(255, 255, 255));
        Backbtn.setText("Back");
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });
        mainPanel.add(Backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 579, 81, 31));

        criminalName.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N

        CNIC.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N

        Address.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N

        NoOfCrimes.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N

        ArrestStatus.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N

        dateofArrest.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N

        descriptionLabel.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(criminalId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(descriptionLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateofArrest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ArrestStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NoOfCrimes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(475, 475, 475)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(criminalName, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(CNIC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(11, 11, 11))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(criminalId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(criminalName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NoOfCrimes, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ArrestStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dateofArrest, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        mainPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 164, -1, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(Imagelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 120));

        mainPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, -3, 140, 120));

        headinglbl.setBackground(new java.awt.Color(255, 255, 204));
        headinglbl.setFont(new java.awt.Font("Wide Latin", 2, 24)); // NOI18N
        headinglbl.setForeground(new java.awt.Color(255, 255, 0));
        headinglbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headinglbl.setText("CRIMINAL DETAILS");
        mainPanel.add(headinglbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 12, 510, 100));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        mainPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 120));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_BackbtnActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DetailedCriminalViewForm(criminal,loggedInUsername).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Address;
    private javax.swing.JLabel ArrestStatus;
    private javax.swing.JButton Backbtn;
    private javax.swing.JLabel CNIC;
    private javax.swing.JLabel Imagelbl;
    private javax.swing.JLabel NoOfCrimes;
    private javax.swing.JLabel criminalId;
    private javax.swing.JLabel criminalName;
    private javax.swing.JLabel dateofArrest;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JLabel headinglbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
