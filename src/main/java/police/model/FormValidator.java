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
        JTextField txtID, JLabel lblerrID,
        JTextField ComplainerNametxt, JLabel lblerrname,
        JTextField txtcomplainfather, JLabel lblerrfather,
        JTextField ComplainerContacttxt, JLabel lblerrcontact,
        JTextField txtaddress, JLabel lblerraddress,
        JTextField ComplainerCNICtxt, JLabel lblerrcnic,
        JDateChooser dateChoosertxt, JLabel lblerrdate,
        TimePicker IncidentTimetxt, JLabel lblerrtime, 
        JTextField Locationtxt, JLabel lblerrlocation,
        JTextArea Descriptiontxt, JLabel lblerrdescrip,
        JTextField txtcrimetype, JLabel lblcrimetype
    ) {
        boolean isValid = true;

        // clear all error labels
        lblerrID.setText("");
        lblerrname.setText("");
        lblerrfather.setText("");
        lblerrcontact.setText("");
        lblerraddress.setText("");
        lblerrcnic.setText("");
        lblerrdate.setText("");
        lblerrtime.setText("");
        lblerrlocation.setText("");
        lblerrdescrip.setText("");
        lblcrimetype.setText("");

        if (ComplainerNametxt.getText().trim().isEmpty()) {
            lblerrname.setText("<html><span style='color:red; font-weight:bold;'>Name is required.</span></html>");
            isValid = false;
        }
        if (txtcrimetype.getText().trim().isEmpty()) {
            lblcrimetype.setText("<html><span style='color:red; font-weight:bold;'>Type is required.</span></html>");
            isValid = false;
        }
        if (txtID.getText().trim().isEmpty()) {
            lblerrID.setText("<html><span style='color:red; font-weight:bold;'>ID is required.</span></html>");
            isValid = false;
        }
        if (txtcomplainfather.getText().trim().isEmpty()) {
            lblerrfather.setText("<html><span style='color:red; font-weight:bold;'>Father name is required.</span></html>");
            isValid = false;
        }
        if (txtaddress.getText().trim().isEmpty()) {
            lblerraddress.setText("<html><span style='color:red; font-weight:bold;'>Address is required.</span></html>");
            isValid = false;
        }
        if (!validateCNIC(ComplainerCNICtxt, lblerrcnic)) {
            isValid = false;
        }
         Date selectedDate = dateChoosertxt.getDate();
        Date today = new Date();

        if (selectedDate == null) {
            lblerrdate.setText("<html><span style='color:red; font-weight:bold;'>Date is required.</span></html>");
            isValid = false;
        } else if (selectedDate.after(today)) {
            lblerrdate.setText("<html><span style='color:red; font-weight:bold;'>Future date not allowed.</span></html>");
            isValid = false;
        } else {
            lblerrdate.setText("");  // Clear error
        }

        String phone = ComplainerContacttxt.getText().trim();
        if (phone.isEmpty()) {
            lblerrcontact.setText("<html><span style='color:red; font-weight:bold;'>Phone number is required.</span></html>");
            isValid = false;
        } else if (!phone.matches("\\d{11}")) {
            lblerrcontact.setText("<html><span style='color:red; font-weight:bold;'>Enter 11 digit phone number.</span></html>");
            isValid = false;
        }
     if (IncidentTimetxt.getText().trim().isEmpty()) {
    lblerrtime.setText("<html><span style='color:red; font-weight:bold;'>Time required.</span></html>");
    isValid = false;
}

        if (Locationtxt.getText().trim().isEmpty()) {
            lblerrlocation.setText("<html><span style='color:red; font-weight:bold;'>Location is required.</span></html>");
            isValid = false;
        }

        String description = Descriptiontxt.getText().trim();
        int wordCount = description.isEmpty() ? 0 : description.split("\\s+").length;
        if (description.isEmpty()) {
            lblerrdescrip.setText("<html><span style='color:red; font-weight:bold;'>Description is required.</span></html>");
            isValid = false;
        } else if (wordCount > 100) {
            lblerrdescrip.setText("<html><span style='color:red; font-weight:bold;'>Max 100 words allowed. Currently: </span></html>" + wordCount);
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
    public static boolean searerr(JTextField searchbartxt,JLabel lblsearcherr){
        boolean isvalid = true;
        lblsearcherr.setText("");
        
        if(searchbartxt.getText().trim().isEmpty()){
            lblsearcherr.setText("<html><span style='color:red; font-weight:bold;'>Must enter the ID (for search).</span></html>");
         return isvalid = false;
                 
        }else {
           lblsearcherr.setText("");
        }        
        return isvalid;
    }
}
