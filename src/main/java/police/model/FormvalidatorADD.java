/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package police.model;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.*;
import static police.model.FormValidator.applyCnicaDash;
/**
 *
 * @author CC
 */
public class FormvalidatorADD {
    public static boolean ValidateAddCriminalForm(JTextField name, JLabel lblerrname,
                                              JTextField cnic, JLabel lblerrcnic,
                                              JTextField address, JLabel lblerraddress,
                                              JTextField crime, JLabel lblerrcrime,
                                              JTextField status, JLabel lblerrstatus,
                                              JDateChooser date, JLabel lblerrdate,
                                              JTextArea description, JLabel lblerrdescription) {

    boolean isValid = true;

    // Clear previous error messages
    lblerrname.setText("");
    lblerrcnic.setText("");
    lblerraddress.setText("");
    lblerrcrime.setText("");
    lblerrstatus.setText("");
    lblerrdate.setText("");
    lblerrdescription.setText("");
   

    // Validate Name
    if (name.getText().trim().isEmpty()) {
        lblerrname.setText("<html><span style='color:red; font-weight:bold;'>Name is required.</span></html>");
        isValid = false;
    }

    // Validate CNIC
    if (!validateCNIC(cnic, lblerrcnic)) {
        isValid = false;
    }

    // Validate Address
    if (address.getText().trim().isEmpty()) {
        lblerraddress.setText("<html><span style='color:red; font-weight:bold;'>Address is required.</span></html>");
        isValid = false;
    }

    // Validate Crime
    if (crime.getText().trim().isEmpty()) {
        lblerrcrime.setText("<html><span style='color:red; font-weight:bold;'>Crime is required.</span></html>");
        isValid = false;
    }

    // Validate Status
    if (status.getText().trim().isEmpty()) {
        lblerrstatus.setText("<html><span style='color:red; font-weight:bold;'>Status is required.</span></html>");
        isValid = false;
    }

    // Validate Date
   Date selectedDate = date.getDate();
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

    // Validate Description
    if (description.getText().trim().isEmpty()) {
        lblerrdescription.setText("<html><span style='color:red; font-weight:bold;'>Description is required.</span></html>");
        isValid = false;
    }

    // Validate Image (check if user selected something)
  

    return isValid;
}

    
    public static boolean validateCNIC(JTextField txtcnic, JLabel lblerrcnic) {
    String raw = txtcnic.getText();

    lblerrcnic.setText("");

    if (raw == null || raw.trim().isEmpty()) {
        lblerrcnic.setText("<html><span style='color:red; font-weight:bold;'>CNIC is required.</span></html>");
        return false;
    }

    String digits = raw.replaceAll("[-\\s]", "").trim();

    if (!digits.matches("\\d{13}")) {
        lblerrcnic.setText("<html><span style='color:red; font-weight:bold;'>CNIC must be exactly 13 digits.</span></html>");
        return false;
    }

    applyCnicaDash(txtcnic, digits);
    return true;
}

}
