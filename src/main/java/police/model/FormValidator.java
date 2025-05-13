/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package police.model;

import com.github.lgooddatepicker.components.TimePicker;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.*;
/**
 *
 * @author CC
 */
public class FormValidator {
     public static boolean validateForm(
        JTextField ComplainerNametxt, JLabel jLabel4,
        JTextField ComplainerContacttxt, JLabel jLabel6,
        JTextField ComplainerCNICtxt, JLabel jLabel7,
        JDateChooser dateChoosertxt, JLabel jLabel8,
        TimePicker IncidentTimetxt, JLabel jLabel9, 
        JTextField Locationtxt, JLabel jLabel10,
        JTextArea Descriptiontxt, JLabel jLabel11
    ) {
        boolean isValid = true;

        // clear all error labels
        jLabel4.setText("");
        jLabel6.setText("");
        jLabel7.setText("");
        jLabel8.setText("");
        jLabel9.setText("");
        jLabel10.setText("");
        jLabel11.setText("");

        if (ComplainerNametxt.getText().trim().isEmpty()) {
            jLabel4.setText("<html><span style='color:red; font-weight:bold;'>Name is required.</span></html>");
            isValid = false;
        }
        if (!validateCNIC(ComplainerCNICtxt, jLabel7)) {
            isValid = false;
        }
         Date selectedDate = dateChoosertxt.getDate();
        Date today = new Date();

        if (selectedDate == null) {
            jLabel8.setText("<html><span style='color:red; font-weight:bold;'>Date is required.</span></html>");
            isValid = false;
        } else if (selectedDate.after(today)) {
            jLabel8.setText("<html><span style='color:red; font-weight:bold;'>Future date not allowed.</span></html>");
            isValid = false;
        } else {
            jLabel8.setText("");  // Clear error
        }

        String phone = ComplainerContacttxt.getText().trim();
        if (phone.isEmpty()) {
            jLabel6.setText("<html><span style='color:red; font-weight:bold;'>Phone number is required.</span></html>");
            isValid = false;
        } else if (!phone.matches("\\d{11}")) {
            jLabel6.setText("<html><span style='color:red; font-weight:bold;'>Enter 11 digit phone number.</span></html>");
            isValid = false;
        }
     if (IncidentTimetxt.getText().trim().isEmpty()) {
    jLabel9.setText("<html><span style='color:red; font-weight:bold;'>Time required.</span></html>");
    isValid = false;
}

        if (Locationtxt.getText().trim().isEmpty()) {
            jLabel10.setText("<html><span style='color:red; font-weight:bold;'>Location is required.</span></html>");
            isValid = false;
        }

        String description = Descriptiontxt.getText().trim();
        int wordCount = description.isEmpty() ? 0 : description.split("\\s+").length;
        if (description.isEmpty()) {
            jLabel11.setText("<html><span style='color:red; font-weight:bold;'>Description is required.</span></html>");
            isValid = false;
        } else if (wordCount > 200) {
            jLabel11.setText("<html><span style='color:red; font-weight:bold;'>Max 200 words allowed. Currently: </span></html>" + wordCount);
            isValid = false;
        }

        return isValid;
    }

    private static boolean validateCNIC(JTextField txtcnic, JLabel jLabel3) {
        String raw = txtcnic.getText();
        if (raw == null || raw.trim().isEmpty()) {
            jLabel3.setText("<html><span style='color:red; font-weight:bold;'>CNIC is required.</span></html>");
            return false;
        }

        String digits = raw.replaceAll("[-\\s]", "").trim();

        if (!digits.matches("\\d{13}")) {
            jLabel3.setText("<html><span style='color:red; font-weight:bold;'>CNIC must be exactly 13 digits.</span></html>");
            return false;
        }

        jLabel3.setText("");
        applyCnicaDash(txtcnic, digits);  // now we pass digits to format
        return true;
    }

    public static void applyCnicaDash(JTextField txtcnic, String digitsOnly) {
        // digitsOnly must already be 13 digits with no dashes
        if (digitsOnly.length() == 13) {
            String formatted = digitsOnly.substring(0, 5) + "-" 
                             + digitsOnly.substring(5, 12) + "-" 
                             + digitsOnly.substring(12);
            txtcnic.setText(formatted);
        }
    }
}
