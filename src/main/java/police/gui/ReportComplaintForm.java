/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package police.gui;
import java.awt.Desktop;
import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import police.CSVHandler;
import police.model.FormValidator;

/**
 *
 * @author HP
 */
public class ReportComplaintForm extends javax.swing.JFrame {

    /**
     * Creates new form ReportComplaintForm
     */
    public ReportComplaintForm() 
    {
        initComponents();
        setLocationRelativeTo(null);
    }
    String evidencePath = "";
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        ComplainerNamelbl = new javax.swing.JLabel();
        ComplainerNametxt = new javax.swing.JTextField();
        ComplainerContactlbl = new javax.swing.JLabel();
        ComplainerContacttxt = new javax.swing.JTextField();
        CNIClbl = new javax.swing.JLabel();
        ComplainerCNICtxt = new javax.swing.JTextField();
        IncidentDatelbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        IncidentTimelbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Locationlbl = new javax.swing.JLabel();
        Locationtxt = new javax.swing.JTextField();
        Descriptionlbl = new javax.swing.JLabel();
        Evidencelbl = new javax.swing.JLabel();
        Evidencebtn = new javax.swing.JButton();
        Backbtn = new javax.swing.JButton();
        Submitbtn = new javax.swing.JButton();
        dateChoosertxt = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblerrAddress = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        IncidentTimetxt = new com.github.lgooddatepicker.components.TimePicker();
        ComplainerNamelbl1 = new javax.swing.JLabel();
        ComplainerFatherNametxt1 = new javax.swing.JTextField();
        jTextArea2 = new javax.swing.JTextArea();
        txtAddress = new javax.swing.JTextField();
        CNIClbl1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Descriptiontxt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Report a Complain");
        setPreferredSize(new java.awt.Dimension(650, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(650, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jScrollPane4.setPreferredSize(new java.awt.Dimension(600, 625));

        mainPanel.setBackground(new java.awt.Color(0, 0, 102));
        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setPreferredSize(new java.awt.Dimension(600, 1050));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ComplainerNamelbl.setText("Complainer's Name :");
        ComplainerNamelbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ComplainerNamelbl.setForeground(new java.awt.Color(255, 255, 255));
        mainPanel.add(ComplainerNamelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 100, -1, -1));

        ComplainerNametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComplainerNametxtActionPerformed(evt);
            }
        });
        mainPanel.add(ComplainerNametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 93, 298, 30));

        ComplainerContactlbl.setText("Contact Number :");
        ComplainerContactlbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ComplainerContactlbl.setForeground(new java.awt.Color(255, 255, 255));
        mainPanel.add(ComplainerContactlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));
        mainPanel.add(ComplainerContacttxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 298, 30));

        CNIClbl.setText("CNIC No :");
        CNIClbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CNIClbl.setForeground(new java.awt.Color(255, 255, 255));
        mainPanel.add(CNIClbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, -1));
        mainPanel.add(ComplainerCNICtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 298, 30));

        IncidentDatelbl.setText("Incident Date  :");
        IncidentDatelbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        IncidentDatelbl.setForeground(new java.awt.Color(255, 255, 255));
        mainPanel.add(IncidentDatelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, -1, -1));

        jLabel2.setText("( YYYY-MM-DD )");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        mainPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, -1, -1));

        IncidentTimelbl.setText("Incident Time  :");
        IncidentTimelbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        IncidentTimelbl.setForeground(new java.awt.Color(255, 255, 255));
        mainPanel.add(IncidentTimelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, -1, -1));

        jLabel3.setText("( HH : MM )");
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        mainPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 490, -1, -1));

        Locationlbl.setText("Location :");
        Locationlbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Locationlbl.setForeground(new java.awt.Color(255, 255, 255));
        mainPanel.add(Locationlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, -1, -1));
        mainPanel.add(Locationtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 530, 298, 30));

        Descriptionlbl.setText("Description :");
        Descriptionlbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Descriptionlbl.setForeground(new java.awt.Color(255, 255, 255));
        mainPanel.add(Descriptionlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 630, -1, -1));

        Evidencelbl.setText("Evidence :");
        Evidencelbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Evidencelbl.setForeground(new java.awt.Color(255, 255, 255));
        mainPanel.add(Evidencelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 760, -1, -1));

        Evidencebtn.setText("Upload Evidence");
        Evidencebtn.setBackground(new java.awt.Color(0, 0, 0));
        Evidencebtn.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        Evidencebtn.setForeground(new java.awt.Color(255, 255, 255));
        Evidencebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvidencebtnActionPerformed(evt);
            }
        });
        mainPanel.add(Evidencebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 750, -1, -1));

        Backbtn.setText("Back");
        Backbtn.setBackground(new java.awt.Color(204, 0, 0));
        Backbtn.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        Backbtn.setForeground(new java.awt.Color(255, 255, 255));
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });
        mainPanel.add(Backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 830, 92, -1));

        Submitbtn.setText("Submit");
        Submitbtn.setBackground(new java.awt.Color(0, 204, 0));
        Submitbtn.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        Submitbtn.setForeground(new java.awt.Color(255, 255, 255));
        Submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitbtnActionPerformed(evt);
            }
        });
        mainPanel.add(Submitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 830, 102, -1));
        mainPanel.add(dateChoosertxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 298, 31));
        mainPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 129, 298, -1));
        mainPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 184, 298, -1));
        mainPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 300, -1));
        mainPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 298, -1));
        mainPanel.add(lblerrAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 298, -1));
        mainPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 300, -1));
        mainPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, 300, -1));
        mainPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 570, 300, -1));
        mainPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 720, 300, -1));
        mainPanel.add(IncidentTimetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 298, 26));

        ComplainerNamelbl1.setText("Complainer's Father Name :");
        ComplainerNamelbl1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ComplainerNamelbl1.setForeground(new java.awt.Color(255, 255, 255));
        mainPanel.add(ComplainerNamelbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 155, -1, -1));

        ComplainerFatherNametxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComplainerFatherNametxt1ActionPerformed(evt);
            }
        });
        mainPanel.add(ComplainerFatherNametxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 148, 298, 30));

        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText("Facing Issues reporting online?\nClick here to download the report document, \nfill it and submit to nearest station   ->");
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setBackground(new java.awt.Color(0, 0, 102));
        jTextArea2.setBorder(null);
        jTextArea2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea2.setHighlighter(null);
        jTextArea2.setPreferredSize(new java.awt.Dimension(300, 200));
        mainPanel.add(jTextArea2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 910, 270, 60));

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        mainPanel.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 298, 35));

        CNIClbl1.setText("Address :");
        CNIClbl1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CNIClbl1.setForeground(new java.awt.Color(255, 255, 255));
        mainPanel.add(CNIClbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setText("Report a Complain");
        jLabel1.setFont(new java.awt.Font("Wide Latin", 1, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        mainPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 70));

        jButton3.setText("Open Form PDF");
        jButton3.setBackground(new java.awt.Color(204, 0, 0));
        jButton3.setBorderPainted(false);
        jButton3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        mainPanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 910, 150, 40));

        Descriptiontxt.setColumns(20);
        Descriptiontxt.setLineWrap(true);
        Descriptiontxt.setRows(5);
        jScrollPane1.setViewportView(Descriptiontxt);

        mainPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 600, 300, 110));

        jScrollPane4.setViewportView(mainPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComplainerNametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComplainerNametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComplainerNametxtActionPerformed

    private void EvidencebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvidencebtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            evidencePath = fileChooser.getSelectedFile().getAbsolutePath();
            JOptionPane.showMessageDialog(this, "Selected: " + evidencePath);
        }
    }//GEN-LAST:event_EvidencebtnActionPerformed

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        new HomePageForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackbtnActionPerformed

    private void SubmitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitbtnActionPerformed
        try {
            CSVHandler csvHandler = new CSVHandler();
            String complaintId = generateComplaintId(csvHandler);
            boolean isvalid = FormValidator.validateForm(ComplainerNametxt,
                jLabel4, ComplainerFatherNametxt1, jLabel12, ComplainerContacttxt,
                jLabel6, ComplainerCNICtxt, jLabel7, txtAddress, lblerrAddress,
                dateChoosertxt, jLabel8, IncidentTimetxt,
                jLabel9, Locationtxt, jLabel10,
                Descriptiontxt, jLabel11);
            if (!isvalid)
            {
                return;
            }
            // Get the selected date as a string
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String dateString = "";
            if (dateChoosertxt.getDate() != null) 
            {
                dateString = sdf.format(dateChoosertxt.getDate());
            }
            else 
            {
                JOptionPane.showMessageDialog(this, "Please select a date.");
                return;
            }
            if(evidencePath == "")
            {
                JOptionPane.showMessageDialog(this,"Evidence cannot be empty", "Please add the evidence files", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            csvHandler.addComplaint(
                complaintId,
                ComplainerNametxt.getText(),
                ComplainerFatherNametxt1.getText(),
                ComplainerContacttxt.getText(),
                ComplainerCNICtxt.getText(),
                txtAddress.getText(),
                dateString,
                IncidentTimetxt.getText(),
                Locationtxt.getText(),
                Descriptiontxt.getText(),
                evidencePath,
                "PENDING"
            );

            JOptionPane.showMessageDialog(this, "Complaint submitted successfully!");
            new HomePageForm().setVisible(true);
            this.dispose();
        } 
        catch (IOException e) 
        {
            JOptionPane.showMessageDialog(this, "Error saving complaint: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SubmitbtnActionPerformed

    private void ComplainerFatherNametxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComplainerFatherNametxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComplainerFatherNametxt1ActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String filePath = "./Resources/Other Stuff/ReportComplainForm.pdf";
            try {
                File file = new File(filePath);
                if (file.exists())
                {
                    Desktop.getDesktop().open(file);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "File not found: " + filePath, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (IOException e)
            {
                JOptionPane.showMessageDialog(this, "Failed to open file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch (UnsupportedOperationException e)
            {
                JOptionPane.showMessageDialog(this, "Opening files is not supported on this system.", "Error", JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new HomePageForm().setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    
    private String generateComplaintId(CSVHandler csvHandler)
    {
        int count = csvHandler.getComplaintCount() + 1;
        return String.format("CID%03d", count);
    }
    
    
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
            java.util.logging.Logger.getLogger(ReportComplaintForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportComplaintForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportComplaintForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportComplaintForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportComplaintForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Backbtn;
    private javax.swing.JLabel CNIClbl;
    private javax.swing.JLabel CNIClbl1;
    private javax.swing.JTextField ComplainerCNICtxt;
    private javax.swing.JLabel ComplainerContactlbl;
    private javax.swing.JTextField ComplainerContacttxt;
    private javax.swing.JTextField ComplainerFatherNametxt1;
    private javax.swing.JLabel ComplainerNamelbl;
    private javax.swing.JLabel ComplainerNamelbl1;
    private javax.swing.JTextField ComplainerNametxt;
    private javax.swing.JLabel Descriptionlbl;
    private javax.swing.JTextArea Descriptiontxt;
    private javax.swing.JButton Evidencebtn;
    private javax.swing.JLabel Evidencelbl;
    private javax.swing.JLabel IncidentDatelbl;
    private javax.swing.JLabel IncidentTimelbl;
    private com.github.lgooddatepicker.components.TimePicker IncidentTimetxt;
    private javax.swing.JLabel Locationlbl;
    private javax.swing.JTextField Locationtxt;
    private javax.swing.JButton Submitbtn;
    private com.toedter.calendar.JDateChooser dateChoosertxt;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel lblerrAddress;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField txtAddress;
    // End of variables declaration//GEN-END:variables
}
