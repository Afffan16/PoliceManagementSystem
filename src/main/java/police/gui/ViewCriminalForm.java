/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package police.gui;
import police.CSVHandler;
import police.model.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.swing.table.*;
import java.util.List;
/**
 *
 * @author waqar
 */
public class ViewCriminalForm extends javax.swing.JFrame {

    /**
     * Creates new form ViewCriminalForm
     */
    private static String loggedInUsername;
    private DefaultTableModel tableModel;
    public ViewCriminalForm(String loggedInUsername) 
    {
        this.loggedInUsername = loggedInUsername;
        initComponents();
        setLocationRelativeTo(null);
        tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] {"Criminal ID", "Criminal Name", "CNIC", "Address", "ImagePath", 
                         "No of Crimes", "ArrestStatus", "Date of Arrest", "View Details"}
        );
        SearchResultsTable.setModel(tableModel);
        configureTable();
        loadCriminals();
    }
    private void configureTable() 
    {
        SearchResultsTable.getColumnModel().getColumn(0).setPreferredWidth(80);  
        SearchResultsTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        SearchResultsTable.getColumnModel().getColumn(3).setPreferredWidth(200); 
        SearchResultsTable.getColumnModel().getColumn(8).setPreferredWidth(100); 
        SearchResultsTable.getColumnModel().getColumn(8).setCellRenderer(new ButtonRenderer());
        SearchResultsTable.getColumnModel().getColumn(8).setCellEditor(new ButtonEditor(new JCheckBox()));
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
                    "View Details"
                });
            }
        } 
        catch (IOException e)   
        {
            JOptionPane.showMessageDialog(this, "Error loading Criminals: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    class ButtonRenderer extends JButton implements TableCellRenderer 
    {
        public ButtonRenderer() 
        {
            setOpaque(true);
            setText("View Details");
            setFont(new Font("Arial", Font.PLAIN, 12));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) 
            {
                setBackground(table.getSelectionBackground());
                setForeground(table.getSelectionForeground());
            } 
            else 
            {
                setBackground(Color.WHITE);
                setForeground(Color.BLACK);
            }
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor 
    {
        private JButton button;
        private String CriminalId;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton("View Details");
            button.setOpaque(true);
            button.setFont(new Font("Arial", Font.PLAIN, 12));
            button.addActionListener(e -> fireEditingStopped());
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) 
        {
            CriminalId = (String) table.getValueAt(row, 0);
            isPushed = true;
            return button;
        }
        
        @Override
        public Object getCellEditorValue() 
        {
            if (isPushed) 
            {
                try 
                {
                    CSVHandler csvHandler = new CSVHandler();
                    List<Criminal> criminal = csvHandler.searchCriminals(CriminalId);
                    if (!criminal.isEmpty()) 
                    {
                        new DetailedCriminalViewForm(criminal.get(0),loggedInUsername).setVisible(true);
                    }
                } 
                catch (IOException e) 
                {
                    JOptionPane.showMessageDialog(null, "Error loading Criminal details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            isPushed = false;
            return "View Details";
        }

        @Override
        public boolean stopCellEditing() 
        {
            isPushed = false;
            return super.stopCellEditing();
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
        searchPanel = new javax.swing.JPanel();
        searchlbl = new javax.swing.JLabel();
        searchbartxt = new javax.swing.JTextField();
        Searchbtn = new javax.swing.JButton();
        headinglbl = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        tableScrollPane = new javax.swing.JScrollPane();
        SearchResultsTable = new javax.swing.JTable();
        Backbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(0, 0, 102));
        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        mainPanel.setForeground(new java.awt.Color(51, 51, 0));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchPanel.setBackground(new java.awt.Color(0, 0, 0));
        searchPanel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N

        searchlbl.setText("Search by Criminal ID : ");
        searchlbl.setBackground(new java.awt.Color(255, 255, 255));
        searchlbl.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        searchlbl.setForeground(new java.awt.Color(255, 255, 255));

        searchbartxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchbartxtKeyReleased(evt);
            }
        });

        Searchbtn.setText("Search");
        Searchbtn.setBackground(new java.awt.Color(51, 204, 0));
        Searchbtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Searchbtn.setForeground(new java.awt.Color(255, 255, 255));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchbartxt, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchbartxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchlbl)
                    .addComponent(Searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        mainPanel.add(searchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 79, 810, -1));

        headinglbl.setText("VIEW / SEARCH CRIMINAL");
        headinglbl.setBackground(new java.awt.Color(255, 255, 0));
        headinglbl.setFont(new java.awt.Font("Wide Latin", 1, 18)); // NOI18N
        headinglbl.setForeground(new java.awt.Color(255, 255, 0));
        mainPanel.add(headinglbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 530, 43));

        SearchResultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String[] {"FIR ID", "Complainant", "Father's Name", "Contact", "Address", "NIC Number", "Date", "Time", "Location", "Description", "Crime Type", "View Details"}
        ));
        SearchResultsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchResultsTableMouseClicked(evt);
            }
        });
        tableScrollPane.setViewportView(SearchResultsTable);

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(tablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        Backbtn.setBackground(new java.awt.Color(204, 0, 0));
        Backbtn.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        Backbtn.setForeground(new java.awt.Color(255, 255, 255));
        Backbtn.setText("Back");
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });
        mainPanel.add(Backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 530, 92, 33));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
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
            tableModel.setRowCount(0);
            try
            {
                CSVHandler csvHandler = new CSVHandler();
                List<Criminal> criminals = csvHandler.searchCriminals(searchbartxt.getText());
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
                        "View Details"
                    });
                }
            }
            catch (IOException e)
            {
                JOptionPane.showMessageDialog(this, "Error searching Criminals: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_searchbartxtKeyReleased

    private void SearchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchbtnActionPerformed
        if (searchbartxt.getText().isEmpty())
        {
            loadCriminals();
        }
        else
        {
            tableModel.setRowCount(0);
            try
            {
                CSVHandler csvHandler = new CSVHandler();
                List<Criminal> criminals = csvHandler.searchCriminals(searchbartxt.getText());
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
                        "View Details"
                    });
                }
            }
            catch (IOException e)
            {
                JOptionPane.showMessageDialog(this, "Error searching Criminals: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_SearchbtnActionPerformed

    private void SearchResultsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchResultsTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchResultsTableMouseClicked

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        new CriminalForm(loggedInUsername).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(ViewCriminalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCriminalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCriminalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCriminalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run()
            {
                new ViewCriminalForm(loggedInUsername).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Backbtn;
    private javax.swing.JTable SearchResultsTable;
    private javax.swing.JButton Searchbtn;
    private javax.swing.JLabel headinglbl;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchbartxt;
    private javax.swing.JLabel searchlbl;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables
}
