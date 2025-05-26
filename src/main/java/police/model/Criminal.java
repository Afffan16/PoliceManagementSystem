/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package police.model;

/**
 *
 * @author HP
 */
public class Criminal {
     private String txtID;
    private String complainantName;
    private String Status;
    private String contact;
    private String address;
    private String cnic;
    private String dateofBirth;
    private String time;
    private String description;
    

    public Criminal(String txtID, String complainantName, String Status, String contact, String address, String cnic,
               String dateofBirth, String time, String description) {
        this.txtID = txtID;
        this.complainantName = complainantName;
        this.contact = contact;
        this.Status = Status;
        this.address = address;
        this.cnic = cnic;
        this.dateofBirth = dateofBirth;
        this.description = description;
        this.dateofBirth = dateofBirth;
        this.address = address;
        this.time = time;
    }

    // Getters
    public String getCriminalId() { return txtID; }
    public String getComplainantName() { return complainantName; }
    public String getStatus() { return Status; }
    public String getContact() { return contact; }
    public String getAddress() { return address; }
    public String getNicNumber() { return cnic; }
    public String getdateofBirth() { return dateofBirth; }
    public String getTime() { return time; }
    public String getDescription() { return description; }
}
