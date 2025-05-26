/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package police.gui;
import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import police.CSVHandler;
import police.model.FormValidator;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
/**
 *
 * @author waqar
 */
public class AddCriminalForm extends javax.swing.JFrame {
        String evidencePath = "";

    private CriminalManagementForm CriminalManagementForm = null;
    public AddCriminalForm() 
    {
        initComponents();
        setLocationRelativeTo(null);
    }
    public AddCriminalForm(CriminalManagementForm CriminalManagementForm) 
    {
        initComponents();
        setLocationRelativeTo(null);
        this.CriminalManagementForm = CriminalManagementForm;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComplainerContacttxt1 = new javax.swing.JTextField();
        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ComplainerNamelbl = new javax.swing.JLabel();
        ComplainerNametxt = new javax.swing.JTextField();
        ComplainerContactlbl = new javax.swing.JLabel();
        CriminalAddresstxt = new javax.swing.JTextField();
        CNIClbl = new javax.swing.JLabel();
        ComplainerCNICtxt = new javax.swing.JTextField();
        IncidentDatelbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        IncidentTimelbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Descriptionlbl = new javax.swing.JLabel();
        Submitbtn = new javax.swing.JButton();
        dateChoosertxt = new com.toedter.calendar.JDateChooser();
        IncidentTimetxt = new com.github.lgooddatepicker.components.TimePicker();
        ComplainerIDlbl = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        Statuslbl = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        ComplainerAddresslbl1 = new javax.swing.JLabel();
        Cnictxt = new javax.swing.JTextField();
        lblerrID = new javax.swing.JLabel();
        lblerrname = new javax.swing.JLabel();
        lblerrfather = new javax.swing.JLabel();
        lblerrcontact = new javax.swing.JLabel();
        lblerraddress = new javax.swing.JLabel();
        lblerrcnic = new javax.swing.JLabel();
        lblerrdate = new javax.swing.JLabel();
        lblcrimetype = new javax.swing.JLabel();
        Backbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Descriptiontxt = new javax.swing.JTextArea();
        lblerrtime = new javax.swing.JLabel();
        lblerrlocation = new javax.swing.JLabel();
        lblerrdescrip = new javax.swing.JLabel();
        ComplainerContacttxt2 = new javax.swing.JTextField();

        ComplainerContacttxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComplainerContacttxt1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(153, 153, 153));
        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setPreferredSize(new java.awt.Dimension(600, 700));

        jLabel1.setText("ADD CRIMINAL:");
        jLabel1.setFont(new java.awt.Font("Bahnschrift", 3, 28)); // NOI18N

        ComplainerNamelbl.setText("Criminal Name :");
        ComplainerNamelbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        ComplainerNametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComplainerNametxtActionPerformed(evt);
            }
        });

        ComplainerContactlbl.setText("No. of Crimes:");
        ComplainerContactlbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        CriminalAddresstxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CriminalAddresstxtActionPerformed(evt);
            }
        });

        CNIClbl.setText("CNIC No :");
        CNIClbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        IncidentDatelbl.setText("Arrest Date:");
        IncidentDatelbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel2.setText("( YYYY-MM-DD )");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N

        IncidentTimelbl.setText("Time  of Crime:");
        IncidentTimelbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel3.setText("( HH : MM )");
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N

        Descriptionlbl.setText("Description :");
        Descriptionlbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        Submitbtn.setText("Submit");
        Submitbtn.setFont(new java.awt.Font("Britannic Bold", 0, 14)); // NOI18N
        Submitbtn.setForeground(new java.awt.Color(255, 0, 0));
        Submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitbtnActionPerformed(evt);
            }
        });

        ComplainerIDlbl.setText("Criminal ID :");
        ComplainerIDlbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        Statuslbl.setText("Arrest Status:");
        Statuslbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });

        ComplainerAddresslbl1.setText("Address :");
        ComplainerAddresslbl1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        Backbtn.setText("Back");
        Backbtn.setFont(new java.awt.Font("Britannic Bold", 0, 14)); // NOI18N
        Backbtn.setForeground(new java.awt.Color(255, 0, 0));
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });

        Descriptiontxt.setColumns(20);
        Descriptiontxt.setLineWrap(true);
        Descriptiontxt.setRows(5);
        jScrollPane1.setViewportView(Descriptiontxt);

        ComplainerContacttxt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComplainerContacttxt2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComplainerNamelbl)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IncidentDatelbl)
                                    .addComponent(jLabel2)))
                            .addComponent(ComplainerIDlbl)
                            .addComponent(Statuslbl)
                            .addComponent(ComplainerAddresslbl1)
                            .addComponent(CNIClbl))
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblerrcontact, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblerraddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(338, 338, 338)
                                                .addComponent(lblerrdate, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                                                .addGap(299, 299, 299)))
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(lblerrname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblerrID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ComplainerNametxt, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)))
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(ComplainerContacttxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(lblerrfather, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(CriminalAddresstxt, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Cnictxt, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(680, 680, 680))))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(lblerrcnic, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                            .addGap(512, 512, 512)
                            .addComponent(lblerrtime, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                            .addGap(103, 103, 103)
                            .addComponent(ComplainerCNICtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(Backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblcrimetype, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ComplainerContactlbl)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(IncidentTimelbl)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(357, 357, 357)
                                        .addComponent(lblerrlocation, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(dateChoosertxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(IncidentTimetxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(Submitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(32, 32, 32)
                                                .addComponent(lblerrdescrip, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(Descriptionlbl)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel3)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComplainerIDlbl))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(lblerrID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComplainerNamelbl)
                    .addComponent(ComplainerNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblerrname)
                .addGap(2, 2, 2)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Statuslbl)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblerrfather)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComplainerContacttxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComplainerContactlbl))
                .addGap(27, 27, 27)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComplainerAddresslbl1)
                    .addComponent(CriminalAddresstxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(lblerrcontact)
                .addGap(21, 21, 21)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(lblerraddress)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(ComplainerCNICtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(lblerrcnic)
                                .addGap(18, 18, 18)
                                .addComponent(dateChoosertxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(lblerrdate))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(IncidentDatelbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)))
                        .addGap(13, 13, 13)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(lblerrtime)
                                .addGap(34, 34, 34)
                                .addComponent(lblerrlocation)
                                .addGap(119, 119, 119)
                                .addComponent(lblerrdescrip))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(IncidentTimelbl)
                                    .addComponent(IncidentTimetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(59, 59, 59)
                                        .addComponent(Descriptionlbl))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CNIClbl)
                        .addComponent(Cnictxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(Submitbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Backbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblcrimetype)
                .addGap(67, 67, 67))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComplainerNametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComplainerNametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComplainerNametxtActionPerformed

    private void CriminalAddresstxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CriminalAddresstxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CriminalAddresstxtActionPerformed

    private void SubmitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitbtnActionPerformed
             
    try {
        Date chooser = dateChoosertxt.getDate();       
        if (chooser == null) {
            lblerrdate.setText("Date is required");
            return;
        }
        
        // Format date consistently
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(chooser);
        
        CriminalManagementForm.addCriminalToCSV(
            txtID.getText().trim(),
            ComplainerNametxt.getText().trim(),
            txtStatus.getText().trim(),
            ComplainerContacttxt2.getText().trim(),
            CriminalAddresstxt.getText().trim(),
            Cnictxt.getText().trim(),
            formattedDate,
            IncidentTimetxt.getText(), // Assuming TimePicker has getText()
            Descriptiontxt.getText().trim()
        );

        JOptionPane.showMessageDialog(this, "Criminal record added successfully!");
        String loggedInUsername = null;
        new CriminalManagementForm(loggedInUsername).setVisible(true);
        this.dispose();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), 
                                    "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
    

        
        

     
    }//GEN-LAST:event_SubmitbtnActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusActionPerformed

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        String loggedInUsername = null;
        new CriminalManagementForm(loggedInUsername).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackbtnActionPerformed

    private void ComplainerContacttxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComplainerContacttxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComplainerContacttxt1ActionPerformed

    private void ComplainerContacttxt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComplainerContacttxt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComplainerContacttxt2ActionPerformed

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
            java.util.logging.Logger.getLogger(AddCriminalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCriminalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCriminalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCriminalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCriminalForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Backbtn;
    private javax.swing.JLabel CNIClbl;
    private javax.swing.JTextField Cnictxt;
    private javax.swing.JLabel ComplainerAddresslbl1;
    private javax.swing.JTextField ComplainerCNICtxt;
    private javax.swing.JLabel ComplainerContactlbl;
    private javax.swing.JTextField ComplainerContacttxt1;
    private javax.swing.JTextField ComplainerContacttxt2;
    private javax.swing.JLabel ComplainerIDlbl;
    private javax.swing.JLabel ComplainerNamelbl;
    private javax.swing.JTextField ComplainerNametxt;
    private javax.swing.JTextField CriminalAddresstxt;
    private javax.swing.JLabel Descriptionlbl;
    private javax.swing.JTextArea Descriptiontxt;
    private javax.swing.JLabel IncidentDatelbl;
    private javax.swing.JLabel IncidentTimelbl;
    private com.github.lgooddatepicker.components.TimePicker IncidentTimetxt;
    private javax.swing.JLabel Statuslbl;
    private javax.swing.JButton Submitbtn;
    private com.toedter.calendar.JDateChooser dateChoosertxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblcrimetype;
    private javax.swing.JLabel lblerrID;
    private javax.swing.JLabel lblerraddress;
    private javax.swing.JLabel lblerrcnic;
    private javax.swing.JLabel lblerrcontact;
    private javax.swing.JLabel lblerrdate;
    private javax.swing.JLabel lblerrdescrip;
    private javax.swing.JLabel lblerrfather;
    private javax.swing.JLabel lblerrlocation;
    private javax.swing.JLabel lblerrname;
    private javax.swing.JLabel lblerrtime;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
