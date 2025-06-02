/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package police.model;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

import javax.swing.JPanel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author CC
 */
public class AnalyticsHelper {
    
public static void showChart(JPanel chartPanelContainer, int selectedMonth, int selectedYear, String filePath) {
    int pending = 0, approved = 0, disapproved = 0;

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        boolean firstLine = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println("Selected Month: " + selectedMonth);
        System.out.println("Selected Year: " + selectedYear);
        System.out.println("Reading file: " + filePath);

        while ((line = br.readLine()) != null) {
            if (firstLine) {
                firstLine = false; 
                continue;
            }

            String[] parts = line.split(",");
            if (parts.length < 12) continue;  // Changed from 10 to 12 since we need at least 12 columns

            String dateStr = parts[6].replace("\"", "").trim();  // Changed from 4 to 6 for 7th column
            String status = parts[11].replace("\"", "").trim().toLowerCase();  // Changed from 9 to 11 for 12th column

            LocalDate date;
            try {
                date = LocalDate.parse(dateStr, formatter);
            } catch (Exception e) {
                continue; 
            }

            if (date.getMonthValue() == selectedMonth && date.getYear() == selectedYear) {
                System.out.println("Matched Row -> Date: " + date + " | Status: " + status);

                switch (status) {
                    case "pending":
                        pending++;
                        break;
                    case "approved":
                        approved++;
                        break;
                    case "disapproved":
                        disapproved++;
                        break;
                    default:
                        System.out.println("Unknown status found: " + status);
                }
            } else {
                System.out.println("Skipped Row -> Date: " + date + " | Not matching month/year");
            }
            System.out.println("-----------");
            System.out.println("Date: " + date + ", Status: " + status);
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(chartPanelContainer, "Error reading CSV: " + e.getMessage());
        return;
    }

    // Create bar chart
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    dataset.addValue(pending, "Status", "Pending");
    dataset.addValue(approved, "Status", "Approved");
    dataset.addValue(disapproved, "Status", "Disapproved");

    JFreeChart chart = ChartFactory.createBarChart(
            "Application Status",
            "Status",
            "Count",
            dataset,
            PlotOrientation.VERTICAL,
            false, true, false
    );
    System.out.println("Counts - Pending: " + pending + ", Approved: " + approved + ", Disapproved: " + disapproved);

    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new Dimension(500, 300));

    chartPanelContainer.removeAll();
    chartPanelContainer.setLayout(new BorderLayout());
    chartPanelContainer.add(chartPanel, BorderLayout.CENTER);
    chartPanelContainer.validate();
}
}
