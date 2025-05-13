/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package police.model;

/**
 *
 * @author HP
 */
public class Investigation {
    
    private String caseId; 
    private String assignedOfficer;
    private String status;
    private String startDate;
    private String lastUpdated;
    private String notes;

    public Investigation(String caseId, String assignedOfficer, String status,
                         String startDate, String lastUpdated, String notes) {
        this.caseId = caseId;
        this.assignedOfficer = assignedOfficer;
        this.status = status;
        this.startDate = startDate;
        this.lastUpdated = lastUpdated;
        this.notes = notes;
    }

    // Getters
    public String getCaseId() { return caseId; }
    public String getAssignedOfficer() { return assignedOfficer; }
    public String getStatus() { return status; }
    public String getStartDate() { return startDate; }
    public String getLastUpdated() { return lastUpdated; }
    public String getNotes() { return notes; }
}