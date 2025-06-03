/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package police.model;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 *
 * @author HP
 */

public class Investigation implements Investigatable
{
    private String investigationId;
    private String firId;
    private Date creationDate;
    private String officerId1;
    private String officerId2;
    private List<String> evidencePaths;
    private String witnessStatements;
    private String otherDetails;
    private String suspects;
    private String caseResult; 
    private String finalCriminal;
    private String status;
    private Date lastUpdated;

    public Investigation(String firId) {
        this.investigationId = firId;
        this.firId = firId;
        this.creationDate = new Date();
        this.officerId1 = null;
        this.officerId2 = null;
        this.evidencePaths = new ArrayList<>();
        this.witnessStatements = null;
        this.otherDetails = null;
        this.suspects = null;
        this.caseResult = null;
        this.finalCriminal = null;
        this.status = "Initiated";
        this.lastUpdated = new Date();
    }

    public Investigation(String investigationId, String firId, Date creationDate, String officerId1,
                        String officerId2, List<String> evidencePaths, String witnessStatements,
                        String otherDetails, String suspects, String caseResult, String finalCriminal,
                        String status, Date lastUpdated) {
        this.investigationId = investigationId;
        this.firId = firId;
        this.creationDate = creationDate;
        this.officerId1 = officerId1;
        this.officerId2 = officerId2;
        this.evidencePaths = evidencePaths != null ? evidencePaths : new ArrayList<>();
        this.witnessStatements = witnessStatements;
        this.otherDetails = otherDetails;
        this.suspects = suspects;
        this.caseResult = caseResult;
        this.finalCriminal = finalCriminal;
        this.status = status;
        this.lastUpdated = lastUpdated;
    }

    public String getInvestigationId() { return investigationId; }
    public void setInvestigationId(String investigationId) { this.investigationId = investigationId; }

    public String getFirId() { return firId; }
    public void setFirId(String firId) { this.firId = firId; }

    public Date getCreationDate() { return creationDate; }
    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }

    public String getOfficerId1() { return officerId1; }
    public void setOfficerId1(String officerId1) { this.officerId1 = officerId1; }

    public String getOfficerId2() { return officerId2; }
    public void setOfficerId2(String officerId2) { this.officerId2 = officerId2; }

    public void setEvidencePaths(List<String> evidencePaths) { this.evidencePaths = evidencePaths; }
    public void addEvidencePath(String path) { this.evidencePaths.add(path); }

    public String getWitnessStatements() { return witnessStatements; }
    public void setWitnessStatements(String witnessStatements) { this.witnessStatements = witnessStatements; }

    public String getOtherDetails() { return otherDetails; }
    public void setOtherDetails(String otherDetails) { this.otherDetails = otherDetails; }

    public String getSuspects() { return suspects; }
    public void setSuspects(String suspects) { this.suspects = suspects; }

    public String getCaseResult() { return caseResult; }
    public void setCaseResult(String caseResult) { this.caseResult = caseResult; }

    public String getFinalCriminal() { return finalCriminal; }
    public void setFinalCriminal(String finalCriminal) { this.finalCriminal = finalCriminal; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Date getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(Date lastUpdated) { this.lastUpdated = lastUpdated; }

    @Override
    public String toString()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String evidencePathsStr = evidencePaths.stream()
                .map(path -> path.replace(",", ";"))
                .collect(Collectors.joining(";"));
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                investigationId,
                firId,
                sdf.format(creationDate),
                officerId1 != null ? officerId1 : "",
                officerId2 != null ? officerId2 : "",
                evidencePathsStr,
                witnessStatements != null ? witnessStatements.replace(",", ";") : "",
                otherDetails != null ? otherDetails.replace(",", ";") : "",
                suspects != null ? suspects.replace(",", ";") : "",
                caseResult != null ? caseResult.replace(",", ";") : "",
                finalCriminal != null ? finalCriminal.replace(",", ";") : "",
                status,
                sdf.format(lastUpdated));
    }
    @Override
    public void addEvidence(String path) {
        if (evidencePaths == null) 
        {
            evidencePaths = new ArrayList<>();
        }
        evidencePaths.add(path);
    }

    @Override
    public void updateStatus(String status) {
        this.status = status;
        this.lastUpdated = new Date();
    }

    @Override
    public String getCaseSummary() {
        return String.format("Investigation %s (FIR: %s)\nStatus: %s\nOfficers: %s, %s\nEvidence Items: %d",
                investigationId, firId, status, officerId1, officerId2, 
                evidencePaths != null ? evidencePaths.size() : 0);
    }

    @Override
    public List<String> getEvidencePaths() {
        return evidencePaths;
    }

    @Override
    public String getCurrentStatus() {
        return status;
    }

    
}