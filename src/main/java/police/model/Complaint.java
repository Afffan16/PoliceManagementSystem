/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package police.model;

/**
 *
 * @author HP
 */
public class Complaint {
    
    private String complaintId;
    private String complainantName;
    private String contact;
    private String nicNumber;
    private String incidentDate;
    private String incidentTime;
    private String location;
    private String description;
    private String evidencePath;
    private String status;

    public Complaint(String complaintId, String complainantName, String contact, String nicNumber,
                     String incidentDate, String incidentTime, String location, String description,
                     String evidencePath, String status) {
        this.complaintId = complaintId;
        this.complainantName = complainantName;
        this.contact = contact;
        this.nicNumber = nicNumber;
        this.incidentDate = incidentDate;
        this.incidentTime = incidentTime;
        this.location = location;
        this.description = description;
        this.evidencePath = evidencePath;
        this.status = status;
    }

    public Complaint(String complaintId, String complainantName, String contact, String nicNumber, 
                     String incidentDate, String incidentTime, String location, String description, 
                     String selectedStatus) 
    {
        this.complaintId = complaintId;
        this.complainantName = complainantName;
        this.contact = contact;
        this.nicNumber = nicNumber;
        this.incidentDate = incidentDate;
        this.incidentTime = incidentTime;
        this.location = location;
        this.description = description;
        this.status = status;
    }


    // Getters
    public String getComplaintId() { return complaintId; }
    public String getComplainantName() { return complainantName; }
    public String getContact() { return contact; }
    public String getNicNumber() { return nicNumber; }
    public String getIncidentDate() { return incidentDate; }
    public String getIncidentTime() { return incidentTime; }
    public String getLocation() { return location; }
    public String getDescription() { return description; }
    public String getEvidencePath() { return evidencePath; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}