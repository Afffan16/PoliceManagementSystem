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
public class FormValidator
{
     public static boolean validateForm(
        JTextField ComplainerNametxt, JLabel jLabel4,
        JTextField ComplainerFatherNametxt, JLabel jLabel12,
        JTextField ComplainerContacttxt, JLabel jLabel6,
        JTextField ComplainerCNICtxt, JLabel jLabel7,
        JTextField Address, JLabel jLabel17,
        JDateChooser dateChoosertxt, JLabel jLabel8,
        TimePicker IncidentTimetxt, JLabel jLabel9, 
        JTextField Locationtxt, JLabel jLabel10,
        JTextArea Descriptiontxt, JLabel jLabel11
    ) 
    {
        boolean isValid = true;

        // clear all error labels
        jLabel4.setText("");
        jLabel6.setText("");
        jLabel12.setText("");
        jLabel7.setText("");
        jLabel17.setText("");
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
        if (Address.getText().trim().isEmpty()) {
            jLabel17.setText("<html><span style='color:red; font-weight:bold;'>Address is required.</span></html>");
            isValid = false;
        }
        if (ComplainerFatherNametxt.getText().trim().isEmpty()) {
            jLabel12.setText("<html><span style='color:red; font-weight:bold;'>Father is required.</span></html>");
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

     
     
     
       public static boolean validateADDupdateForm(
        JTextField ComplainerNametxt, JLabel jLabel1,
        JTextField ComplainerFatherNametxt, JLabel jLabel2,
        JTextField ComplainerContacttxt, JLabel jLabel3,
        JTextField ComplainerCNICtxt, JLabel jLabel4,
        JTextField Address, JLabel jLabel5,
        JDateChooser dateChoosertxt, JLabel jLabel6,
        TimePicker IncidentTimetxt, JLabel jLabel7, 
        JTextField Locationtxt, JLabel jLabel8,
        JTextArea Descriptiontxt, JLabel jLabel9,
        JTextField CrimeType, JLabel jLabel10
    ) {
        boolean isValid = true;

        // clear all error labels
        jLabel1.setText("");
        jLabel2.setText("");
        jLabel3.setText("");
        jLabel4.setText("");
        jLabel5.setText("");
        jLabel6.setText("");
        jLabel7.setText("");
        jLabel8.setText("");
        jLabel9.setText("");
        jLabel10.setText("");

        if (ComplainerNametxt.getText().trim().isEmpty()) {
            jLabel1.setText("<html><span style='color:red; font-weight:bold;'>Name is required.</span></html>");
            isValid = false;
        }
        if (!validateCNIC(ComplainerCNICtxt, jLabel4)) {
            isValid = false;
        }
         Date selectedDate = dateChoosertxt.getDate();
        Date today = new Date();

        if (selectedDate == null) {
            jLabel6.setText("<html><span style='color:red; font-weight:bold;'>Date is required.</span></html>");
            isValid = false;
        } else if (selectedDate.after(today)) {
            jLabel6.setText("<html><span style='color:red; font-weight:bold;'>Future date not allowed.</span></html>");
            isValid = false;
        } else {
            jLabel6.setText("");  // Clear error
        }

        String phone = ComplainerContacttxt.getText().trim();
        if (phone.isEmpty()) {
            jLabel3.setText("<html><span style='color:red; font-weight:bold;'>Phone number is required.</span></html>");
            isValid = false;
        } else if (!phone.matches("\\d{11}")) {
            jLabel3.setText("<html><span style='color:red; font-weight:bold;'>Enter 11 digit phone number.</span></html>");
            isValid = false;
        }
     if (IncidentTimetxt.getText().trim().isEmpty()) {
    jLabel7.setText("<html><span style='color:red; font-weight:bold;'>Time required.</span></html>");
    isValid = false;
        }

        if (Locationtxt.getText().trim().isEmpty()) {
            jLabel8.setText("<html><span style='color:red; font-weight:bold;'>Location is required.</span></html>");
            isValid = false;
        }
        if (Address.getText().trim().isEmpty()) {
            jLabel5.setText("<html><span style='color:red; font-weight:bold;'>Address is required.</span></html>");
            isValid = false;
        }
        if (ComplainerFatherNametxt.getText().trim().isEmpty()) {
            jLabel2.setText("<html><span style='color:red; font-weight:bold;'>Father is required.</span></html>");
            isValid = false;
        }

        String description = Descriptiontxt.getText().trim();
        int wordCount = description.isEmpty() ? 0 : description.split("\\s+").length;
        if (description.isEmpty()) {
            jLabel9.setText("<html><span style='color:red; font-weight:bold;'>Description is required.</span></html>");
            isValid = false;
        } else if (wordCount > 200) {
            jLabel9.setText("<html><span style='color:red; font-weight:bold;'>Max 200 words allowed. Currently: </span></html>" + wordCount);
            isValid = false;
        }

        
        
        if (CrimeType.getText().trim().isEmpty()) {
            jLabel10.setText("<html><span style='color:red; font-weight:bold;'>Crime type is required.</span></html>");
            isValid = false;
        }

        return isValid;
    }

     
     
    
    private static boolean validateCNIC(JTextField txtcnic, JLabel jLabel4) {
        String raw = txtcnic.getText();
        if (raw == null || raw.trim().isEmpty()) {
            jLabel4.setText("<html><span style='color:red; font-weight:bold;'>CNIC is required.</span></html>");
            return false;
        }

        String digits = raw.replaceAll("[-\\s]", "").trim();

        if (!digits.matches("\\d{13}")) {
            jLabel4.setText("<html><span style='color:red; font-weight:bold;'>CNIC must be exactly 13 digits.</span></html>");
            return false;
        }

        jLabel4.setText("");
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

    public static boolean searerr(JTextField searchbartxt, JLabel lblsearcherr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static boolean validateOfficerForm(
        JTextField usernametxt, JLabel lblerrusername,
        JTextField passwordtxt, JLabel lblerrpassword,
        JTextField roletxt, JLabel lblerrrole,
        JTextField nametxt, JLabel lblerrname,
        JTextField badgeNotext, JLabel lblerrBadgeNo,
        JTextField emailtxt, JLabel lblerremail,
        JTextField phoneNotxt, JLabel lblerrphoneNo,
        JTextField serviceYearstxt, JLabel lblerrServiceYears,
        JTextField casesSolvedtxt, JLabel lblerrCasesSolved,
        JTextField successPercentagetxt, JLabel SuccessPercentage
        ) 
    {
        boolean isValid = true;

        // Clear all error labels
        lblerrusername.setText("");
        lblerrpassword.setText("");
        lblerrrole.setText("");
        lblerrname.setText("");
        lblerrBadgeNo.setText("");
        lblerremail.setText("");
        lblerrphoneNo.setText("");
        lblerrServiceYears.setText("");
        lblerrCasesSolved.setText("");
        SuccessPercentage.setText("");
        

        // UserName validation
        if (usernametxt.getText().trim().isEmpty())
        {
            lblerrusername.setText("<html><span style='color:red; font-weight:bold;'>Username is required.</span></html>");
            isValid = false;
        }
        
        // Password validation
        if (passwordtxt.getText().trim().isEmpty())
        {
            lblerrpassword.setText("<html><span style='color:red; font-weight:bold;'>Password is required.</span></html>");
            isValid = false;
        }
        
        // Role validation
        if (roletxt.getText().trim().isEmpty())
        {
            lblerrrole.setText("<html><span style='color:red; font-weight:bold;'>Role is required.</span></html>");
            isValid = false;
        }
        
        // Name validation
        if (nametxt.getText().trim().isEmpty())
        {
            lblerrname.setText("<html><span style='color:red; font-weight:bold;'>Name is required.</span></html>");
            isValid = false;
        }
        
        // BadgeNo validation
        if (badgeNotext.getText().trim().isEmpty())
        {
            lblerrBadgeNo.setText("<html><span style='color:red; font-weight:bold;'>Badge No is required.</span></html>");
            isValid = false;
        }
        
        // Email validation (basic check)
        if (emailtxt.getText().trim().isEmpty()) 
        {
            lblerremail.setText("<html><span style='color:red; font-weight:bold;'>Email is required.</span></html>");
            isValid = false;
        } 
        else if (!emailtxt.getText().trim().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            lblerremail.setText("<html><span style='color:red; font-weight:bold;'>Invalid email format.</span></html>");
            isValid = false;
        }
        
        
        // Phone validation
        String phone = phoneNotxt.getText().trim();
        if (phone.isEmpty())
        {
            lblerrphoneNo.setText("<html><span style='color:red; font-weight:bold;'>Phone number is required.</span></html>");
            isValid = false;
        }
        else if (!phone.matches("\\d{11}"))
        {
            lblerrphoneNo.setText("<html><span style='color:red; font-weight:bold;'>Enter 11 digit phone number.</span></html>");
            isValid = false;
        }

        
        // Service Years validation
        try 
        {
            int serviceYears = Integer.parseInt(serviceYearstxt.getText().trim());
            if (serviceYears < 0) 
            {
                lblerrServiceYears.setText("<html><span style='color:red; font-weight:bold;'>Service Years cannot be negative.</span></html>");
                isValid = false;
            }
        } 
        catch (NumberFormatException e) {
            lblerrServiceYears.setText("<html><span style='color:red; font-weight:bold;'>Service Years must be a valid number.</span></html>");
            isValid = false;
        }

        // Cases Solved validation
        try {
            int casesSolved = Integer.parseInt(casesSolvedtxt.getText().trim());
            if (casesSolved < 0) 
            {
                lblerrCasesSolved.setText("<html><span style='color:red; font-weight:bold;'>Cases Solved cannot be negative.</span></html>");
                isValid = false;
            }
        } 
        catch (NumberFormatException e)
        {
            lblerrCasesSolved.setText("<html><span style='color:red; font-weight:bold;'>Cases Solved must be a valid number.</span></html>");
            isValid = false;
        }

        // Success Percentage validation
        try {
            double successPercentage = Double.parseDouble(successPercentagetxt.getText().trim());
            if (successPercentage < 0 || successPercentage > 100) {
                SuccessPercentage.setText("<html><span style='color:red; font-weight:bold;'>Success Percentage must be between 0 and 100.</span></html>");
                isValid = false;
            }
        } 
        catch (NumberFormatException e)
        {
            SuccessPercentage.setText("<html><span style='color:red; font-weight:bold;'>Success Percentage must be a valid number.</span></html>");
            isValid = false;
        }

        return isValid;
    }  



    }
    
