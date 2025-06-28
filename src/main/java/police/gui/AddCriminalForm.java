/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package police.gui;
import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import police.CSVHandler;
import police.model.Criminal;
import police.model.FormValidator;
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
/**
 *
 * @author waqar
 */
public class AddCriminalForm extends javax.swing.JFrame 
{
    private String imagePath = "";
    private CriminalManagementForm parent;
    private Criminal criminal;
    private boolean isAddMode;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private CSVHandler csvHandler;
    private String loggedInUsername;

    public AddCriminalForm() 
    {
        initComponents();
        setLocationRelativeTo(null);
        this.csvHandler = new CSVHandler();
        autoGenerateCriminalId();
    }

    public AddCriminalForm(CriminalManagementForm parent, Criminal criminal, String loggedInUsername) {
        this.parent = parent;
        this.criminal = criminal;
        this.isAddMode = (criminal == null);
        this.csvHandler = new CSVHandler();
        this.loggedInUsername = loggedInUsername;
        initComponents();
        setLocationRelativeTo(parent);
        populateFields();
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
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        ComplainerContacttxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComplainerContacttxt1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(0, 0, 102));
        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setPreferredSize(new java.awt.Dimension(600, 1000));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headinglbl.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        headinglbl.setForeground(new java.awt.Color(255, 255, 0));
        headinglbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headinglbl.setText("ADD / UPDATE CRIMINALS ");
        mainPanel.add(headinglbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 15, 490, 60));

        ComplainerIDlbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ComplainerIDlbl.setForeground(new java.awt.Color(255, 255, 255));
        ComplainerIDlbl.setText("Criminal ID :");
        mainPanel.add(ComplainerIDlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 113, -1, -1));

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        mainPanel.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 305, 30));

        ComplainerNamelbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ComplainerNamelbl.setForeground(new java.awt.Color(255, 255, 255));
        ComplainerNamelbl.setText("Criminal Name :");
        mainPanel.add(ComplainerNamelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 173, -1, -1));

        ComplainerNametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComplainerNametxtActionPerformed(evt);
            }
        });
        mainPanel.add(ComplainerNametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 305, 30));

        CNIClbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CNIClbl.setForeground(new java.awt.Color(255, 255, 255));
        CNIClbl.setText("CNIC No :");
        mainPanel.add(CNIClbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 233, -1, -1));
        mainPanel.add(Cnictxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 304, 30));

        ComplainerAddresslbl1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ComplainerAddresslbl1.setForeground(new java.awt.Color(255, 255, 255));
        ComplainerAddresslbl1.setText("Address :");
        mainPanel.add(ComplainerAddresslbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 293, -1, -1));

        CriminalAddresstxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CriminalAddresstxtActionPerformed(evt);
            }
        });
        mainPanel.add(CriminalAddresstxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 304, 30));

        ComplainerContactlbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ComplainerContactlbl.setForeground(new java.awt.Color(255, 255, 255));
        ComplainerContactlbl.setText("No. of Crimes:");
        mainPanel.add(ComplainerContactlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 353, -1, -1));

        ComplainerContacttxt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComplainerContacttxt2ActionPerformed(evt);
            }
        });
        mainPanel.add(ComplainerContacttxt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 304, 30));

        Statuslbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Statuslbl.setForeground(new java.awt.Color(255, 255, 255));
        Statuslbl.setText("Arrest Status:");
        mainPanel.add(Statuslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 413, -1, -1));

        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });
        mainPanel.add(txtStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 304, 30));

        IncidentDatelbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        IncidentDatelbl.setForeground(new java.awt.Color(255, 255, 255));
        IncidentDatelbl.setText("Arrest Date:");
        mainPanel.add(IncidentDatelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 466, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("( YYYY-MM-DD )");
        mainPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 488, -1, -1));
        mainPanel.add(dateChoosertxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 470, 304, 31));

        Descriptionlbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Descriptionlbl.setForeground(new java.awt.Color(255, 255, 255));
        Descriptionlbl.setText("Description :");
        mainPanel.add(Descriptionlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 556, 100, -1));

        Descriptiontxt.setColumns(20);
        Descriptiontxt.setLineWrap(true);
        Descriptiontxt.setRows(5);
        jScrollPane1.setViewportView(Descriptiontxt);

        mainPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 530, 304, 110));

        Submitbtn.setBackground(new java.awt.Color(0, 0, 0));
        Submitbtn.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        Submitbtn.setForeground(new java.awt.Color(255, 255, 255));
        Submitbtn.setText("Submit");
        Submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitbtnActionPerformed(evt);
            }
        });
        mainPanel.add(Submitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 739, 111, 32));

        Backbtn.setBackground(new java.awt.Color(204, 0, 0));
        Backbtn.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        Backbtn.setForeground(new java.awt.Color(255, 255, 255));
        Backbtn.setText("Back");
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });
        mainPanel.add(Backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 739, 116, 32));

        imagelbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        imagelbl.setForeground(new java.awt.Color(255, 255, 255));
        imagelbl.setText("Criminal Image :");
        mainPanel.add(imagelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 667, 120, -1));

        addImagebtn.setBackground(new java.awt.Color(0, 204, 0));
        addImagebtn.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        addImagebtn.setForeground(new java.awt.Color(255, 255, 255));
        addImagebtn.setText("Add Image");
        addImagebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addImagebtnActionPerformed(evt);
            }
        });
        mainPanel.add(addImagebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 660, 130, 30));
        mainPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 1000));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        mainPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 80));

        jScrollPane2.setViewportView(mainPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE)
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
        try 
        {
            Date arrestDate = dateChoosertxt.getDate();
            String formattedDate = null;
            if (arrestDate != null) 
            {
                formattedDate = sdf.format(arrestDate);
            }            
            String criminalId = txtID.getText().trim();
            String criminalName = ComplainerNametxt.getText().trim();
            String cnic = Cnictxt.getText().trim();
            String address = CriminalAddresstxt.getText().trim();
            String noOfCrimes = ComplainerContacttxt2.getText().trim();
            String arrestStatus = txtStatus.getText().trim();
            String description = Descriptiontxt.getText().trim();
            if(criminalName == null)
            {
                JOptionPane.showMessageDialog(this, "Criminal Name Cannot be Empty", "Please Enter correct details", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(cnic == null)
            {
                JOptionPane.showMessageDialog(this, "CNIC Cannot be Empty", "Please Enter correct details", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(address == null)
            {
                JOptionPane.showMessageDialog(this, "Address Cannot be Empty", "Please Enter correct details", JOptionPane.INFORMATION_MESSAGE);
                return;
            }            
            if(noOfCrimes == null)
            {
                JOptionPane.showMessageDialog(this, "No of Crimes Cannot be Empty", "Please Enter correct details", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(arrestStatus == null)
            {
                JOptionPane.showMessageDialog(this, "Arrest Status Cannot be Empty", "Please Enter correct details", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(description == null)
            {
                JOptionPane.showMessageDialog(this, "Description Cannot be Empty", "Please Enter correct details", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(formattedDate == null)
            {
                JOptionPane.showMessageDialog(this,"Date Cannot be empty", "Please Choose A Correct Date", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if( imagePath == "")
            {
                JOptionPane.showMessageDialog(this,"Image cannot be empty", "Please Choose an image", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            Criminal newCriminal = new Criminal(criminalId, criminalName, cnic, address, imagePath, noOfCrimes, arrestStatus, formattedDate, description);
            if (isAddMode) 
            {
                csvHandler.addCriminal(newCriminal);
                JOptionPane.showMessageDialog(this, "Criminal record added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } 
            else 
            {
                csvHandler.updateCriminal(newCriminal);
                JOptionPane.showMessageDialog(this, "Criminal record updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            if (parent != null) 
            {
                parent.loadCriminals(); 
            }
            dispose();
            new CriminalManagementForm(loggedInUsername).setVisible(true);
        } 
        catch (IOException ex) 
        {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
    
    private void populateFields() 
    {
        if (!isAddMode && criminal != null) 
        {
            txtID.setText(criminal.getCriminalId());
            txtID.setEditable(false);
            ComplainerNametxt.setText(criminal.getCriminalName());
            Cnictxt.setText(criminal.getCnic());
            CriminalAddresstxt.setText(criminal.getAddress());
            ComplainerContacttxt2.setText(criminal.getNoOfCrimes());
            txtStatus.setText(criminal.getArrestStatus());
            Descriptiontxt.setText(criminal.getDescriptionForArrest());
            imagePath = criminal.getImagePath();
            try 
            {
                if (criminal.getDateOfArrest() != null && !criminal.getDateOfArrest().isEmpty()) 
                {
                    Date date = sdf.parse(criminal.getDateOfArrest());
                    dateChoosertxt.setDate(date);
                }
            }
            catch (ParseException e) 
            {
                System.err.println("Failed to parse arrest date: " + criminal.getDateOfArrest());
                JOptionPane.showMessageDialog(this, "Invalid date format in criminal data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            autoGenerateCriminalId();
        }
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
