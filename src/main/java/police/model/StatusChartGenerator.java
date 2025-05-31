/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package police.model;

/**
 *
 * @author CC
 */

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class StatusChartGenerator extends JFrame {

    public static void showStatusChart(JPanel chartPanelContainer, String filePath) {
        int activeCount = 0;
        int completedCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // skip header
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length < 12) continue; // 12th column = index 11

                String status = parts[11].trim().toLowerCase();

                if (status.equals("active")) activeCount++;
                else if (status.equals("completed")) completedCount++;
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(chartPanelContainer, "Error reading CSV: " + e.getMessage());
            return;
        }

        // Creating dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(activeCount, "Status", "Active");
        dataset.addValue(completedCount, "Status", "Completed");

        // Creating chart
        JFreeChart chart = ChartFactory.createBarChart(
                "Active vs Completed Status",
                "Status",
                "Count",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(600, 400));

        // Display in panel
        chartPanelContainer.removeAll();
        chartPanelContainer.setLayout(new BorderLayout());
        chartPanelContainer.add(chartPanel, BorderLayout.CENTER);
        chartPanelContainer.validate();
    }
}
