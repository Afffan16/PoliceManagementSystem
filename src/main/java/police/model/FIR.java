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
    private String contact;
    private String nicNumber;
    private String incidentDate;
    private String incidentTime;
    private String location;
    private String description;

    public FIR(String firId, String complainantName, String contact, String nicNumber,
               String incidentDate, String incidentTime, String location, String description) {
        this.firId = firId;
        this.complainantName = complainantName;
        this.contact = contact;
        this.nicNumber = nicNumber;
        this.incidentDate = incidentDate;
        this.incidentTime = incidentTime;
        this.location = location;
        this.description = description;
    }

    // Getters
    public String getFirId() { return firId; }
    public String getComplainantName() { return complainantName; }
    public String getContact() { return contact; }
    public String getNicNumber() { return nicNumber; }
    public String getIncidentDate() { return incidentDate; }
    public String getIncidentTime() { return incidentTime; }
    public String getLocation() { return location; }
    public String getDescription() { return description; }
}