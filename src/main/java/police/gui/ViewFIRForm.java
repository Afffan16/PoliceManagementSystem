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
import java.util.ArrayList;
import javax.swing.table.*;
import java.util.List;
/**
 *
 * @author HP
 */
public class ViewFIRForm extends javax.swing.JFrame 
{

    /**
     * Creates new form ViewFIRForm
     */
    
    private static String loggedInUsername;
    private DefaultTableModel tableModel;
    private List<FIR> firs = new ArrayList<>();;
    public ViewFIRForm(String loggedInUsername) 
    {
        this.loggedInUsername = loggedInUsername;
        initComponents();
        firs = new ArrayList<>();
        setLocationRelativeTo(null);
        configureTable();
        tableModel = new DefaultTableModel();
        SearchResultsTable.setModel(tableModel);
        loadFIRs();
    }
    private void configureTable() 
    {
        SearchResultsTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        SearchResultsTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        SearchResultsTable.getColumnModel().getColumn(2).setPreferredWidth(120);
        SearchResultsTable.getColumnModel().getColumn(3).setPreferredWidth(120);
        SearchResultsTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        SearchResultsTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        SearchResultsTable.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        SearchResultsTable.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JCheckBox()));
    }   
    public void loadFIRs()
    {
        List<FIR> loadedFIRs = CSVHandler.loadFIRs();
        firs = (loadedFIRs != null) ? loadedFIRs : new ArrayList<>();
        System.out.println("Loaded FIRs in ViewFIRForm: " + firs.size());
        String[] columnNames = {"FIR ID", "Complainant Name", "Contact", "NIC", "Crime Type", "View Details"};
        Object[][] data = new Object[firs.size()][6];
        for (int i = 0; i < firs.size(); i++) 
        {
            FIR f = firs.get(i);
            data[i][0] = f.getFirId();
            data[i][1] = f.getComplainantName();
            data[i][2] = f.getContact() != null ? f.getContact() : "";
            data[i][3] = f.getNicNumber() != null ? f.getNicNumber() : "";
            data[i][4] = f.getCrimeType() != null ? f.getCrimeType() : "";
            data[i][5] = "View Details";
        }
        tableModel.setDataVector(data, columnNames);
        SearchResultsTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        SearchResultsTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        SearchResultsTable.getColumnModel().getColumn(2).setPreferredWidth(120);
        SearchResultsTable.getColumnModel().getColumn(3).setPreferredWidth(120);
        SearchResultsTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        SearchResultsTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        SearchResultsTable.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        SearchResultsTable.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JCheckBox()));
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
        private String firId;
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
            firId = (String) table.getValueAt(row, 0);
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
                    List<FIR> firs = csvHandler.searchFIRs(firId);
                    if (!firs.isEmpty()) 
                    {
                        new DetailedFIRViewForm(firs.get(0),loggedInUsername).setVisible(true);
                    }
                } 
                catch (IOException e) 
                {
                    JOptionPane.showMessageDialog(null, "Error loading FIR details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        setTitle("Search?View FIRs");
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(153, 153, 255));
        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        searchPanel.setBackground(new java.awt.Color(204, 204, 255));

        searchlbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        searchlbl.setForeground(new java.awt.Color(0, 0, 204));
        searchlbl.setText("Search by FIR ID : ");

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
                .addGap(35, 35, 35)
                .addComponent(searchlbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchbartxt, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(16, Short.MAX_VALUE))
        );

        headinglbl.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        headinglbl.setText("View / Search FIRs");

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
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
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
                .addContainerGap(46, Short.MAX_VALUE))
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

    private void SearchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchbtnActionPerformed
        String searchText = searchbartxt.getText().trim().toLowerCase();
        System.out.println("Search button clicked with text: " + searchText);
        if (tableModel == null) {
            System.err.println("Error: tableModel is null in SearchbtnActionPerformed");
            tableModel = new DefaultTableModel();
            SearchResultsTable.setModel(tableModel);
            return;
        }
        tableModel.setRowCount(0);
        for (FIR f : firs) 
        {
            if (f.getFirId().toLowerCase().contains(searchText) ||
                f.getComplainantName().toLowerCase().contains(searchText) ||
                (f.getCrimeType() != null && f.getCrimeType().toLowerCase().contains(searchText))) 
            {
                tableModel.addRow(new Object[] 
                {
                    f.getFirId(),
                    f.getComplainantName(),
                    f.getContact() != null ? f.getContact() : "",
                    f.getNicNumber() != null ? f.getNicNumber() : "",
                    f.getCrimeType() != null ? f.getCrimeType() : "",
                    "View Details"
                });
            }
        }
        System.out.println("Filtered FIRs: " + tableModel.getRowCount());  
    }//GEN-LAST:event_SearchbtnActionPerformed

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        new FIRForm(loggedInUsername).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackbtnActionPerformed

    private void SearchResultsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchResultsTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchResultsTableMouseClicked

    private void searchbartxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbartxtKeyReleased
        String searchText = searchbartxt.getText().trim().toLowerCase();
        System.out.println("Searching FIRs in ViewFIRForm: " + searchText);
        if (tableModel == null) {
            System.err.println("Error: tableModel is null in searchbartxtKeyReleased");
            tableModel = new DefaultTableModel();
            SearchResultsTable.setModel(tableModel);
            return;
        }
        tableModel.setRowCount(0);
        for (FIR f : firs) 
        {
            if (f.getFirId().toLowerCase().contains(searchText) ||
                f.getComplainantName().toLowerCase().contains(searchText) ||
                (f.getCrimeType() != null && f.getCrimeType().toLowerCase().contains(searchText))) {
                tableModel.addRow(new Object[] {
                    f.getFirId(),
                    f.getComplainantName(),
                    f.getContact() != null ? f.getContact() : "",
                    f.getNicNumber() != null ? f.getNicNumber() : "",
                    f.getCrimeType() != null ? f.getCrimeType() : "",
                    "View Details"
                });
            }
        }
        System.out.println("Filtered FIRs: " + tableModel.getRowCount());
    }//GEN-LAST:event_searchbartxtKeyReleased

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
            java.util.logging.Logger.getLogger(ViewFIRForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewFIRForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewFIRForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewFIRForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewFIRForm(loggedInUsername).setVisible(true);
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
