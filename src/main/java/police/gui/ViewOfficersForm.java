/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package police.gui;

import police.*;
import police.model.*;
import javax.swing.*;
import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author HP
 */
public class ViewOfficersForm extends javax.swing.JFrame {

    /**
     * Creates new form ViewOfficersForm
     */
    private DefaultTableModel tableModel;
    private List<Officer> officers = new ArrayList<>();
    private CSVHandler csvHandler;

    public ViewOfficersForm() 
    {
        csvHandler = new CSVHandler();
        System.out.println("CSVHandler initialized successfully.");
        initComponents();
        setLocationRelativeTo(null);
        tableModel = new DefaultTableModel();
        SearchResultsTable.setModel(tableModel);
        loadOfficers();
    }

    private void configureTable() 
    {
        SearchResultsTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        SearchResultsTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        SearchResultsTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        SearchResultsTable.getColumnModel().getColumn(3).setPreferredWidth(120);
        SearchResultsTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        SearchResultsTable.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
        SearchResultsTable.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JCheckBox()));
    }

    public void loadOfficers() 
    {
        try 
        {
            System.out.println("Attempting to load officers...");
            officers = csvHandler.loadOfficers();
            System.out.println("Number of officers loaded: " + officers.size());
            if (officers.isEmpty()) 
            {
                System.out.println("Warning: No officers found.");
            } 
            else 
            {
                for (Officer o : officers) 
                {
                    System.out.println("Loaded Officer: " + o.getOfficerId() + ", " + o.getName());
                }
            }
            String[] columnNames = {"OfficerID", "Name", "Email", "PhoneNo", "View Details"};
            Object[][] data = new Object[officers.size()][5];
            for (int i = 0; i < officers.size(); i++)
            {
                Officer o = officers.get(i);
                data[i][0] = o.getOfficerId();
                data[i][1] = o.getName();
                data[i][2] = o.getEmail();
                data[i][3] = o.getPhone();
                data[i][4] = "View Details";
                System.out.println("Adding to table: " + o.getOfficerId() + ", " + o.getName());
            }
            tableModel.setDataVector(data, columnNames);
            System.out.println("Table model updated with " + officers.size() + " rows.");
            configureTable();
        } 
        catch (IOException e) 
        {
            System.out.println("Error loading officers: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error loading officers: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
        {
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
        private int selectedRow;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox)
        {
            super(checkBox);
            button = new JButton("View Details");
            button.setOpaque(true);
            button.setFont(new Font("Arial", Font.PLAIN, 12));
            button.addActionListener(e -> fireEditingStopped());
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) 
        {
            selectedRow = table.convertRowIndexToModel(row); 
            System.out.println("Selected row index: " + selectedRow);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue()
        {
            if (isPushed && selectedRow >= 0 && selectedRow < officers.size())
            {
                try 
                {
                    String username = officers.get(selectedRow).getUsername();
                    System.out.println("Selected username for View Details: " + username);
                    Officer officer = csvHandler.getOfficerDetails(username);
                    if (officer != null) 
                    {
                        System.out.println("Opening OfficerProfileForm for username: " + username);
                        new OfficerProfileForm(username).setVisible(true);
                    }
                    else
                    {
                        System.out.println("Officer not found for username: " + username);
                        JOptionPane.showMessageDialog(null, "Officer not found for username: " + username, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } 
                catch (IOException e) 
                {
                    System.out.println("Error loading officer details: " + e.getMessage());
                    JOptionPane.showMessageDialog(null, "Error loading officer details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(153, 153, 255));
        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        searchPanel.setBackground(new java.awt.Color(204, 204, 255));

        searchlbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        searchlbl.setForeground(new java.awt.Color(0, 0, 204));
        searchlbl.setText("Search by Officer ID : ");

        searchbartxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchbartxtKeyReleased(evt);
            }
        });

        Searchbtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Searchbtn.setForeground(new java.awt.Color(51, 0, 255));
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
                .addGap(21, 21, 21)
                .addComponent(searchlbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchbartxt, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        headinglbl.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        headinglbl.setText("View / Search Officers");

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

        Backbtn.setFont(new java.awt.Font("Britannic Bold", 0, 14)); // NOI18N
        Backbtn.setForeground(new java.awt.Color(255, 0, 0));
        Backbtn.setText("Back");
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headinglbl, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(244, 244, 244))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(headinglbl, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchbartxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbartxtKeyReleased
        String searchText = searchbartxt.getText().trim().toLowerCase();
        tableModel.setRowCount(0);
        for (Officer o : officers) 
        {
            if (o.getOfficerId().toLowerCase().contains(searchText) || o.getName().toLowerCase().contains(searchText)) {
                tableModel.addRow(new Object[] 
                {
                    o.getOfficerId(), o.getName(), o.getEmail(), o.getPhone(), "View Details"
                });
            }
        }
    }//GEN-LAST:event_searchbartxtKeyReleased

    private void SearchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchbtnActionPerformed
        String searchText = searchbartxt.getText().trim().toLowerCase();
        tableModel.setRowCount(0);
        for (Officer o : officers) 
        {
            if (o.getOfficerId().toLowerCase().contains(searchText) || o.getName().toLowerCase().contains(searchText)) {
                tableModel.addRow(new Object[] 
                {
                    o.getOfficerId(), o.getName(), o.getEmail(), o.getPhone(), "View Details"
                });
            }
        }
    }//GEN-LAST:event_SearchbtnActionPerformed

    private void SearchResultsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchResultsTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchResultsTableMouseClicked

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
         new ManageOfficersForm().setVisible(true);
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
            java.util.logging.Logger.getLogger(ViewOfficersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewOfficersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewOfficersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewOfficersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewOfficersForm().setVisible(true);
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
