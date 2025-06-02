/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package police.gui;
import com.toedter.calendar.JDateChooser;
import police.CSVHandler;
import police.model.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.swing.table.*;
import java.util.List;
import com.github.lgooddatepicker.components.TimePicker;


public class CriminalManagementForm extends javax.swing.JFrame 
{
    private static String loggedInUsername;
    private DefaultTableModel tableModel;
    
    public CriminalManagementForm(String loggedInUsername) 
    {
        this.loggedInUsername = loggedInUsername;
        initComponents();
        setLocationRelativeTo(null);
        
        tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] {"Criminal ID", "Criminal Name", "CNIC", "Address", "ImagePath", 
                         "No of Crimes", "ArrestStatus", "Date of Arrest", "DescriptionForArrest"}
        );
        SearchResultsTable.setModel(tableModel);
        
        loadCriminals();
    }

    private void loadCriminals() 
    {
        tableModel.setRowCount(0);
        try 
        {
            CSVHandler csvHandler = new CSVHandler();
            List<Criminal> criminals = csvHandler.getAllCriminals();
            for (Criminal cri : criminals)
            {
                tableModel.addRow(new Object[]
                {
                    cri.getCriminalId(), 
                    cri.getCriminalName(), 
                    cri.getCnic(),
                    cri.getAddress(), 
                    cri.getImagePath(), 
                    cri.getNoOfCrimes(), 
                    cri.getArrestStatus(),
                    cri.getDateOfArrest(),
                    cri.getDescriptionForArrest()
                });
            }
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(this, "Error loading Criminals: " + e.getMessage(), 
                                         "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadCriminals(String searchTxt) 
    {
        tableModel.setRowCount(0);
        try 
        {
            CSVHandler csvHandler = new CSVHandler();
            List<Criminal> criminals = csvHandler.searchCriminals(searchTxt);
            for (Criminal cri : criminals) 
            {
                tableModel.addRow(new Object[]
                {
                    cri.getCriminalId(), 
                    cri.getCriminalName(), 
                    cri.getCnic(),
                    cri.getAddress(), 
                    cri.getImagePath(), 
                    cri.getNoOfCrimes(), 
                    cri.getArrestStatus(),
                    cri.getDateOfArrest(),
                    cri.getDescriptionForArrest()
                });
            }
        } 
        catch (IOException e) 
        {
            JOptionPane.showMessageDialog(this, "Error searching Criminals: " + e.getMessage(), 
                                         "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        searchlbl = new javax.swing.JLabel();
        searchbartxt = new javax.swing.JTextField();
        Searchbtn = new javax.swing.JButton();
        lblsearcherr = new javax.swing.JLabel();
        headinglbl = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        tableScrollPane = new javax.swing.JScrollPane();
        SearchResultsTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        Addbtn = new javax.swing.JButton();
        Deletebtn = new javax.swing.JButton();
        Updatebtn = new javax.swing.JButton();
        Backbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(0, 0, 102));
        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchPanel.setBackground(new java.awt.Color(0, 0, 0));

        searchlbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchlbl.setForeground(new java.awt.Color(255, 255, 255));
        searchlbl.setText("Search by Criminal ID : ");

        searchbartxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbartxtActionPerformed(evt);
            }
        });
        searchbartxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchbartxtKeyReleased(evt);
            }
        });

        Searchbtn.setBackground(new java.awt.Color(51, 204, 0));
        Searchbtn.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        Searchbtn.setForeground(new java.awt.Color(255, 255, 255));
        Searchbtn.setText("Search");
        Searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(searchlbl)
                .addGap(31, 31, 31)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblsearcherr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchbartxt, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchbartxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchlbl)
                    .addComponent(Searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblsearcherr))
        );

        mainPanel.add(searchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 67, 782, -1));

        headinglbl.setFont(new java.awt.Font("Wide Latin", 1, 18)); // NOI18N
        headinglbl.setForeground(new java.awt.Color(255, 255, 0));
        headinglbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headinglbl.setText("CRIMINAL MANAGEMENT");
        mainPanel.add(headinglbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 12, 530, 43));

        SearchResultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String[] {"FIR ID", "Complainant", "Father's Name", "Contact", "Address", "NIC Number", "Date", "Time", "Location", "Description", "Crime Type"}
        ));
        tableScrollPane.setViewportView(SearchResultsTable);

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                .addContainerGap())
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(tablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 127, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Addbtn.setBackground(new java.awt.Color(0, 0, 0));
        Addbtn.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        Addbtn.setForeground(new java.awt.Color(255, 255, 255));
        Addbtn.setText("Add");
        Addbtn.setMaximumSize(new java.awt.Dimension(72, 22));
        Addbtn.setMinimumSize(new java.awt.Dimension(72, 22));
        Addbtn.setPreferredSize(new java.awt.Dimension(72, 22));
        Addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddbtnActionPerformed(evt);
            }
        });
        jPanel1.add(Addbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 23, 90, 33));

        Deletebtn.setBackground(new java.awt.Color(0, 0, 0));
        Deletebtn.setFont(new java.awt.Font("Segoe UI Black", 3, 16)); // NOI18N
        Deletebtn.setForeground(new java.awt.Color(255, 255, 255));
        Deletebtn.setText("Delete");
        Deletebtn.setMaximumSize(new java.awt.Dimension(72, 22));
        Deletebtn.setMinimumSize(new java.awt.Dimension(72, 22));
        Deletebtn.setPreferredSize(new java.awt.Dimension(72, 22));
        Deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletebtnActionPerformed(evt);
            }
        });
        jPanel1.add(Deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 23, 94, 33));

        Updatebtn.setBackground(new java.awt.Color(0, 0, 0));
        Updatebtn.setFont(new java.awt.Font("Segoe UI Black", 3, 16)); // NOI18N
        Updatebtn.setForeground(new java.awt.Color(255, 255, 255));
        Updatebtn.setText("Update");
        Updatebtn.setMaximumSize(new java.awt.Dimension(72, 22));
        Updatebtn.setMinimumSize(new java.awt.Dimension(72, 22));
        Updatebtn.setPreferredSize(new java.awt.Dimension(72, 22));
        Updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatebtnActionPerformed(evt);
            }
        });
        jPanel1.add(Updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 23, 101, 33));

        Backbtn.setBackground(new java.awt.Color(204, 0, 0));
        Backbtn.setFont(new java.awt.Font("Segoe UI Black", 3, 16)); // NOI18N
        Backbtn.setForeground(new java.awt.Color(255, 255, 255));
        Backbtn.setText("Back");
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });
        jPanel1.add(Backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 23, 92, 33));

        mainPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 470, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchbartxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbartxtKeyReleased
        if (searchbartxt.getText().isEmpty())
        {
            loadCriminals();
        }
        else
        {
            loadCriminals(searchbartxt.getText());
        }
    }//GEN-LAST:event_searchbartxtKeyReleased

    private void SearchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchbtnActionPerformed
        boolean isvalid = FormValidator.searerr(searchbartxt, lblsearcherr);
        if (searchbartxt.getText().isEmpty())
        {
            loadCriminals();
        }     
    }//GEN-LAST:event_SearchbtnActionPerformed

    private void AddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddbtnActionPerformed
        AddCriminalForm criminalForm = new AddCriminalForm(this);
        criminalForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AddbtnActionPerformed

    private void DeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletebtnActionPerformed
        int selectedRow = SearchResultsTable.getSelectedRow();
        if (selectedRow == -1)
        {
            JOptionPane.showMessageDialog(this, "Please select a Criminal to delete", 
                                        "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String criminalID = (String) tableModel.getValueAt(selectedRow, 0);
        int result = JOptionPane.showConfirmDialog(this, 
            "Delete Criminal " + criminalID + "?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            
        if (result == JOptionPane.YES_OPTION) 
        {
            try {
                CSVHandler csvHandler = new CSVHandler();
                csvHandler.deleteCriminal(criminalID);
                loadCriminals();
                JOptionPane.showMessageDialog(this, "Criminal deleted successfully!");
            } 
            catch (IOException e) 
            {
                JOptionPane.showMessageDialog(this, "Error deleting Criminal: " + e.getMessage(), 
                                             "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_DeletebtnActionPerformed

    private void UpdatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatebtnActionPerformed
        int selectedRow = SearchResultsTable.getSelectedRow();
        if (selectedRow < 0) 
        {
            JOptionPane.showMessageDialog(this, "Please select a criminal first");
            return;
        }

        String[] fields = 
        {
            "Criminal ID", "Criminal Name", "CNIC", "Address", "ImagePath", 
            "No of Crimes", "ArrestStatus", "Date of Arrest", "DescriptionForArrest"
        };

        JTextField[] inputs = new JTextField[fields.length - 1]; 
        Object[] rowData = new Object[fields.length];

        for (int i = 0; i < fields.length; i++) 
        {
            rowData[i] = tableModel.getValueAt(selectedRow, i);
        }

        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));

        panel.add(new JLabel("Criminal ID:"));
        panel.add(new JLabel(rowData[0].toString()));

        for (int i = 1; i < fields.length; i++) 
        {
            panel.add(new JLabel(fields[i] + ":"));
            inputs[i-1] = new JTextField(rowData[i] != null ? rowData[i].toString() : "", 20);
            panel.add(inputs[i-1]);
        }

        int option = JOptionPane.showConfirmDialog(
            this, panel, "Update Criminal", 
            JOptionPane.OK_CANCEL_OPTION
        );

        if (option == JOptionPane.OK_OPTION) 
        {
            try 
            {
                Criminal updated = new Criminal(
                    rowData[0].toString(),    // ID
                    inputs[0].getText(),      // Name
                    inputs[1].getText(),      // CNIC
                    inputs[2].getText(),      // Address
                    inputs[3].getText(),      // ImagePath
                    inputs[4].getText(),      // No of Crimes
                    inputs[5].getText(),      // ArrestStatus
                    inputs[6].getText(),      // Date of Arrest
                    inputs[7].getText()       // DescriptionForArrest
                );

                new CSVHandler().updateCriminal(updated);
                loadCriminals(); 
                JOptionPane.showMessageDialog(this, "Update successful!");
                
            } 
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_UpdatebtnActionPerformed

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        new CriminalForm(loggedInUsername).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackbtnActionPerformed

    private void searchbartxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbartxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbartxtActionPerformed

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
            java.util.logging.Logger.getLogger(CriminalManagementForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CriminalManagementForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CriminalManagementForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriminalManagementForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriminalManagementForm(loggedInUsername).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addbtn;
    private javax.swing.JButton Backbtn;
    private javax.swing.JButton Deletebtn;
    private javax.swing.JTable SearchResultsTable;
    private javax.swing.JButton Searchbtn;
    private javax.swing.JButton Updatebtn;
    private javax.swing.JLabel headinglbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblsearcherr;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchbartxt;
    private javax.swing.JLabel searchlbl;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables

    public void addCriminalToCSV(String id, String name, String cnic, String address, String imagePath,
                                 String noOfCrimes, String arrestStatus, String dateOfArrest, String descriptionForArrest) 
    {
        try 
        {
            CSVHandler csvHandler = new CSVHandler();
            Criminal criminal = new Criminal(id, name, cnic, address, imagePath, 
                                           noOfCrimes, arrestStatus, dateOfArrest, descriptionForArrest);
            csvHandler.addCriminal(criminal);
            loadCriminals(); 
        }
        catch (IOException e) 
        {
            JOptionPane.showMessageDialog(this, "Error saving to CSV: " + e.getMessage(), 
                                        "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


