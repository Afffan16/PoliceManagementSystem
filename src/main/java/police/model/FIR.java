/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package police.model;

/**
 *
 * @author HP
 */
public class FIR 
{
    private String firId;
    private String complainantName;
    private String fathersName;
    private String contact;
    private String address;
    private String nicNumber;
    private String incidentDate;
    private String incidentTime;
    private String location;
    private String description;
    private String crimeType;

    public FIR(String firId, String complainantName, String fathersName, String contact, String address, String nicNumber,
               String incidentDate, String incidentTime, String location, String description, String crimeType) {
        this.firId = firId;
        this.complainantName = complainantName;
        this.contact = contact;
        this.nicNumber = nicNumber;
        this.incidentDate = incidentDate;
        this.incidentTime = incidentTime;
        this.location = location;
        this.description = description;
        this.fathersName = fathersName;
        this.address = address;
        this.crimeType = crimeType;
    }

    // Getters
    public String getFirId() { return firId; }
    public String getComplainantName() { return complainantName; }
    public String getFathersName() { return fathersName; }
    public String getContact() { return contact; }
    public String getAddress() { return address; }
    public String getNicNumber() { return nicNumber; }
    public String getIncidentDate() { return incidentDate; }
    public String getIncidentTime() { return incidentTime; }
    public String getLocation() { return location; }
    public String getDescription() { return description; }
    public String getCrimeType() { return crimeType; }
}