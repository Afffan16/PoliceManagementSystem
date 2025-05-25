/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package police.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;


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

    public FIR(String firId, String complainantName, String fathersName, String contact, String address,
               String nicNumber, String incidentDate, String incidentTime, String location, String description,
               String crimeType) throws IllegalArgumentException 
    {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(false);
        try
        {
            if (incidentDate != null && !incidentDate.isEmpty()) 
            {
                sdf.parse(incidentDate);
            }
        } 
        catch (ParseException e) 
        {
            throw new IllegalArgumentException("Invalid date format for incidentDate: " + incidentDate + ". Use MM/dd/yyyy.");
        }
        this.firId = firId;
        this.complainantName = complainantName;
        this.fathersName = fathersName;
        this.contact = contact;
        this.address = address;
        this.nicNumber = nicNumber;
        this.incidentDate = incidentDate;
        this.incidentTime = incidentTime;
        this.location = location;
        this.description = description;
        this.crimeType = crimeType;
    }

    // Getters and Setters
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

    public void setIncidentDate(String incidentDate) 
    {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(false);
        try
        {
            if (incidentDate != null && !incidentDate.isEmpty()) 
            {
                sdf.parse(incidentDate);
            }
            this.incidentDate = incidentDate;
        } 
        catch (ParseException e) 
        {
            throw new IllegalArgumentException("Invalid date format: " + incidentDate + ". Use MM/dd/yyyy.");
        }
    }

    @Override
    public String toString()
    {
        return "FIR{firId=" + firId + ", complainantName=" + complainantName + ", incidentDate=" + incidentDate + "}";
    }
}