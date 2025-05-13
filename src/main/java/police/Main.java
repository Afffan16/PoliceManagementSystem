/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package police;

/**
 *
 * @author HP
 */

import java.io.*;
import police.gui.HomePageForm;
import javax.swing.*;

public class Main {
    public static void main(String[] args) 
    {
        CSVHandler csvHandler = new CSVHandler();
        try 
        {
            csvHandler.initializeCSVFiles();
        } 
        catch (IOException e) 
        {
            JOptionPane.showMessageDialog(null, "Error initializing CSV files: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        // Run GUI on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            HomePageForm homePage = new HomePageForm();
            homePage.setVisible(true);
        });
    }
}