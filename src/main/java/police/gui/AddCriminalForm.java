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
import police.model.FormvalidatorADD;
/**
 *
 * @author waqar
 */
public class AddCriminalForm extends javax.swing.JFrame 
{
    private String imagePath = "";
    
    private CriminalManagementForm CriminalManagementForm = null;
    public AddCriminalForm() 
    {
        initComponents();
        setLocationRelativeTo(null);
        autoGenerateCriminalId();
    }
    public AddCriminalForm(CriminalManagementForm CriminalManagementForm) 
    {
        initComponents();
        setLocationRelativeTo(null);
        this.CriminalManagementForm = CriminalManagementForm;
        autoGenerateCriminalId();
    }
    
    private void autoGenerateCriminalId()
    {
        try {
            
            CSVHandler csvHandler = new CSVHandler();
            int count = csvHandler.getCriminalCount() + 1; 
            String criminalId = String.format("CR%03d", count); 
            txtID.setText(criminalId);
            txtID.setEditable(false); 
        } 
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(this, "Error generating Criminal ID: " + e.getMessage(), 
                                        "Error", JOptionPane.ERROR_MESSAGE);
            txtID.setText("CR001"); 
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComplainerContacttxt1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        headinglbl = new javax.swing.JLabel();
        ComplainerIDlbl = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        ComplainerNamelbl = new javax.swing.JLabel();
        ComplainerNametxt = new javax.swing.JTextField();
        CNIClbl = new javax.swing.JLabel();
        Cnictxt = new javax.swing.JTextField();
        ComplainerAddresslbl1 = new javax.swing.JLabel();
        CriminalAddresstxt = new javax.swing.JTextField();
        ComplainerContactlbl = new javax.swing.JLabel();
        ComplainerContacttxt2 = new javax.swing.JTextField();
        Statuslbl = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        IncidentDatelbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateChoosertxt = new com.toedter.calendar.JDateChooser();
        Descriptionlbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Descriptiontxt = new javax.swing.JTextArea();
        Submitbtn = new javax.swing.JButton();
        Backbtn = new javax.swing.JButton();
        imagelbl = new javax.swing.JLabel();
        addImagebtn = new javax.swing.JButton();
        lblerrname = new javax.swing.JLabel();
        lblerrcnic = new javax.swing.JLabel();
        lblerraddress = new javax.swing.JLabel();
        lblerrcrime = new javax.swing.JLabel();
        lblerrstatus = new javax.swing.JLabel();
        lblerrdate = new javax.swing.JLabel();
        lblerrdiscription = new javax.swing.JLabel();
        lblerrimg = new javax.swing.JLabel();

        ComplainerContacttxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComplainerContacttxt1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(630, 650));

        mainPanel.setBackground(new java.awt.Color(153, 153, 153));
        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setPreferredSize(new java.awt.Dimension(600, 1000));

        headinglbl.setFont(new java.awt.Font("Bahnschrift", 1, 28)); // NOI18N
        headinglbl.setText("ADD CRIMINAL :");

        ComplainerIDlbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ComplainerIDlbl.setText("Criminal ID :");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        ComplainerNamelbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ComplainerNamelbl.setText("Criminal Name :");

        ComplainerNametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComplainerNametxtActionPerformed(evt);
            }
        });

        CNIClbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CNIClbl.setText("CNIC No :");

        ComplainerAddresslbl1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ComplainerAddresslbl1.setText("Address :");

        CriminalAddresstxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CriminalAddresstxtActionPerformed(evt);
            }
        });

        ComplainerContactlbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ComplainerContactlbl.setText("No. of Crimes:");

        ComplainerContacttxt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComplainerContacttxt2ActionPerformed(evt);
            }
        });

        Statuslbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Statuslbl.setText("Arrest Status:");

        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });

        IncidentDatelbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        IncidentDatelbl.setText("Arrest Date:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel2.setText("( YYYY-MM-DD )");

        Descriptionlbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Descriptionlbl.setText("Description of Arrest :");

        Descriptiontxt.setColumns(20);
        Descriptiontxt.setLineWrap(true);
        Descriptiontxt.setRows(5);
        jScrollPane1.setViewportView(Descriptiontxt);

        Submitbtn.setFont(new java.awt.Font("Britannic Bold", 0, 14)); // NOI18N
        Submitbtn.setForeground(new java.awt.Color(255, 0, 0));
        Submitbtn.setText("Submit");
        Submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitbtnActionPerformed(evt);
            }
        });

        Backbtn.setFont(new java.awt.Font("Britannic Bold", 0, 14)); // NOI18N
        Backbtn.setForeground(new java.awt.Color(255, 0, 0));
        Backbtn.setText("Back");
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });

        imagelbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        imagelbl.setText("Criminal Image :");

        addImagebtn.setFont(new java.awt.Font("Britannic Bold", 0, 14)); // NOI18N
        addImagebtn.setText("Add Image");
        addImagebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addImagebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(Backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(Submitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagelbl)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComplainerNamelbl)
                            .addComponent(IncidentDatelbl)
                            .addComponent(jLabel2)
                            .addComponent(ComplainerIDlbl)
                            .addComponent(ComplainerAddresslbl1)
                            .addComponent(CNIClbl)
                            .addComponent(Descriptionlbl)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Statuslbl)
                                .addComponent(ComplainerContactlbl)))
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Cnictxt, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtID)
                                    .addComponent(ComplainerNametxt, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                    .addComponent(lblerrname, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblerrcrime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblerraddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ComplainerContacttxt2, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblerrdiscription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblerrdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblerrstatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblerrcnic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CriminalAddresstxt, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1)
                                    .addComponent(dateChoosertxt, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                    .addComponent(txtStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblerrimg, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addImagebtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(0, 48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headinglbl, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headinglbl, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComplainerIDlbl))
                .addGap(30, 30, 30)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComplainerNamelbl)
                    .addComponent(ComplainerNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(lblerrname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CNIClbl)
                    .addComponent(Cnictxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(lblerrcnic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CriminalAddresstxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComplainerAddresslbl1))
                .addGap(8, 8, 8)
                .addComponent(lblerraddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComplainerContacttxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComplainerContactlbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblerrcrime)
                .addGap(8, 8, 8)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Statuslbl)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(lblerrstatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(IncidentDatelbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(dateChoosertxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(Descriptionlbl))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lblerrdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblerrdiscription)
                .addGap(7, 7, 7)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagelbl)
                    .addComponent(addImagebtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblerrimg)
                .addGap(38, 38, 38)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Backbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Submitbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jScrollPane2.setViewportView(mainPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
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
       
        FormvalidatorADD.ValidateAddCriminalForm(ComplainerNametxt,lblerrname,
                                 Cnictxt,lblerrcnic,
                                 CriminalAddresstxt,lblerraddress,
                                 ComplainerContacttxt2,lblerrcrime,
                                 txtStatus,lblerrstatus,
                                 dateChoosertxt,lblerrdate,
                                 Descriptiontxt,lblerrdiscription);
        try 
        {
            Date chooser = dateChoosertxt.getDate();       
            SimpleDateFormat sdf = new SimpleDateFormat("DD/mm/yyyy");
            String formattedDate = sdf.format(chooser);
            
            CriminalManagementForm.addCriminalToCSV(
                txtID.getText().trim(),
                ComplainerNametxt.getText().trim(),
                Cnictxt.getText().trim(),
                CriminalAddresstxt.getText().trim(),
                imagePath,
                ComplainerContacttxt2.getText().trim(),
                txtStatus.getText().trim(),
                formattedDate,
                Descriptiontxt.getText().trim()
            );

            JOptionPane.showMessageDialog(this, "Criminal record added successfully!");
            String loggedInUsername = null;
            new CriminalManagementForm(loggedInUsername).setVisible(true);
            this.dispose();
        }
        catch (Exception ex) 
        {
//            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), 
//                                        "Error", JOptionPane.ERROR_MESSAGE);
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

    private void addImagebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addImagebtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) 
        {
            imagePath = fileChooser.getSelectedFile().getAbsolutePath();
            JOptionPane.showMessageDialog(this, "Selected: " + imagePath);
        } 
    }//GEN-LAST:event_addImagebtnActionPerformed

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
    private javax.swing.JLabel Statuslbl;
    private javax.swing.JButton Submitbtn;
    private javax.swing.JButton addImagebtn;
    private com.toedter.calendar.JDateChooser dateChoosertxt;
    private javax.swing.JLabel headinglbl;
    private javax.swing.JLabel imagelbl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblerraddress;
    private javax.swing.JLabel lblerrcnic;
    private javax.swing.JLabel lblerrcrime;
    private javax.swing.JLabel lblerrdate;
    private javax.swing.JLabel lblerrdiscription;
    private javax.swing.JLabel lblerrimg;
    private javax.swing.JLabel lblerrname;
    private javax.swing.JLabel lblerrstatus;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
