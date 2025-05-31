/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package police.model;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ArrestChartGenerator extends JFrame {

    public static void showArrestChart(JPanel chartPanelContainer, int selectedMonth, int selectedYear, String filePath) {
        int arrestCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // skip header
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length < 8) continue;

                String status = parts[3].trim().toLowerCase(); // assuming 4th column = status
                String dateStr = parts[7].trim().replace("\"", ""); // 8th column = date

                LocalDate date;
                try {
                    date = LocalDate.parse(dateStr, formatter);
                } catch (Exception e) {
                    continue; // skip invalid date format
                }

                if (status.equals("arrested") && date.getMonthValue() == selectedMonth && date.getYear() == selectedYear) {
                    arrestCount++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(chartPanelContainer, "Error reading CSV: " + e.getMessage());
            return;
        }

        // Chart creation
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(arrestCount, "Arrested", "This Month");

        JFreeChart chart = ChartFactory.createBarChart(
                "Number of Arrests - " + selectedMonth + "/" + selectedYear,
                "Status",
                "Count",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(600, 400));

        // Displaying in panel
        chartPanelContainer.removeAll();
        chartPanelContainer.setLayout(new BorderLayout());
        chartPanelContainer.add(chartPanel, BorderLayout.CENTER);
        chartPanelContainer.validate();
    }
}
