/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package police;
/**
 *
 * @author HP
 */
import police.model.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;

public class CSVHandler 
{
    private static final String COMPLAINTS_CSV = "resources/complaints.csv";
    private static final String FIRS_CSV = "resources/firs.csv";
    private static final String INVESTIGATIONS_CSV = "resources/investigations.csv";
    private static final String CRIMINALS_CSV = "resources/criminals.csv";
    private static final String COURT_CSV = "resources/court.csv";
    private static final String OFFICERS_CSV = "resources/officers.csv";

    public void initializeCSVFiles() throws IOException {
        // Complaints CSV
        File complaintsFile = new File(COMPLAINTS_CSV);
        if (!complaintsFile.exists()) {
            try (FileWriter writer = new FileWriter(complaintsFile)) {
                writer.write("complaintId,complainantName,contact,nicNumber,incidentDate,incidentTime,location,description,evidencePath,status\n");
            }
        }

        // FIRs CSV
        File firsFile = new File(FIRS_CSV);
        if (!firsFile.exists()) {
            try (FileWriter writer = new FileWriter(firsFile)) {
                writer.write("firId,complainantName,fathersName,contact,address,nicNumber,incidentDate,incidentTime,location,description,crimeType\n");
            }
        }

        // Investigations CSV
        File investigationsFile = new File(INVESTIGATIONS_CSV);
        if (!investigationsFile.exists()) {
            try (FileWriter writer = new FileWriter(investigationsFile)) {
                writer.write("caseId,assignedOfficer,status,startDate,lastUpdated,notes\n");
            }
        }

        // Criminals CSV
        File criminalsFile = new File(CRIMINALS_CSV);
        if (!criminalsFile.exists()) {
            try (FileWriter writer = new FileWriter(criminalsFile)) {
                writer.write("criminalId,name,nicNumber,photoPath,fingerprints,criminalHistory\n");
            }
        }

        // Court CSV
        File courtFile = new File(COURT_CSV);
        if (!courtFile.exists()) {
            try (FileWriter writer = new FileWriter(courtFile)) {
                writer.write("caseId,courtDate,documentPath,reminderStatus\n");
            }
        }

        // Officers CSV
        File officersFile = new File(OFFICERS_CSV);
        if (!officersFile.exists()) {
            try (FileWriter writer = new FileWriter(officersFile)) {
                writer.write("officerId,username,password,role,name,badgeNumber,email,phone,serviceYears,casesSolved,successPercentage,imagePath\n");
                writer.write("BDG-001,Affan,Afffan16,Head Constable,Muhammad Affan bin Aamir,BDG001,affan.aamir@police.gov,123-456-789,15,70,82.5,resources/images/affan.jpeg\n");                
                writer.write("BDG-002,Umar,UmarAzhar24,Inspector,Muhammad Umar Azhar,BDG002,umar.azhar@police.gov,987-654-321,6,48,95,resources/images/umar.jpeg\n");
            }
        }
    }

    public void addComplaint(String complaintId, String complainantName,String complainerFathername, 
                              String contact, String nicNumber,String Address,
                             String incidentDate, String incidentTime, String location, String description,
                             String evidencePath, String status) throws IOException {
        try (FileWriter writer = new FileWriter(COMPLAINTS_CSV, true)) {
            writer.write(String.join(",", complaintId, complainantName ,complainerFathername, contact, nicNumber,Address, incidentDate,
                incidentTime, location, description, evidencePath, status) + "\n");
        }
    }

    public boolean authenticateOfficer(String username, String password) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(OFFICERS_CSV))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 3 && data[1].equals(username) && data[2].equals(password)) {
                    Session.setLoggedInUsername(username);
                    return true;
                }
            }
        }
        return false;
    }

    public Officer getOfficerDetails(String username) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(OFFICERS_CSV))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 12 && data[1].equals(username)) {
                    int serviceYears = Integer.parseInt(data[8]);
                    int casesSolved = Integer.parseInt(data[9]);
                    double successPercentage = Double.parseDouble(data[10]);
                    String grade = calculateGrade(successPercentage);
                    return new Officer(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7],
                        serviceYears, casesSolved, successPercentage, grade, data[11]);
                }
            }
        }
        return null;
    }

    private String calculateGrade(double successPercentage) {
        if (successPercentage >= 90) return "A+";
        if (successPercentage >= 80) return "A";
        if (successPercentage >= 70) return "B+";
        if (successPercentage >= 60) return "B";
        if (successPercentage >= 50) return "B-";
        return "C";
    }

    public static void addFIR(FIR fir) 
    {
        try (PrintWriter pw = new PrintWriter(new FileWriter("resources/firs.csv", true))) 
        {
            pw.println(fir.getFirId() + "," + 
                    (fir.getComplainantName() != null ? fir.getComplainantName() : "") + "," +
                    (fir.getFathersName() != null ? fir.getFathersName() : "") + "," +
                    (fir.getContact() != null ? fir.getContact() : "") + "," +
                    (fir.getAddress() != null ? fir.getAddress() : "") + "," +
                    (fir.getNicNumber() != null ? fir.getNicNumber() : "") + "," +
                    (fir.getIncidentDate() != null ? fir.getIncidentDate() : "") + "," +
                    (fir.getIncidentTime() != null ? fir.getIncidentTime() : "") + "," +
                    (fir.getLocation() != null ? fir.getLocation() : "") + "," +
                    (fir.getDescription() != null ? fir.getDescription() : "") + "," +
                    (fir.getCrimeType() != null ? fir.getCrimeType() : ""));
        } 
        catch (IOException e) 
        {
            JOptionPane.showMessageDialog(null, "Failed to register FIR: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static List<FIR> loadFIRs() 
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<FIR> firs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("resources/firs.csv")))
        {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) 
            {
                String[] data = line.split(",", -1);
                  Date incidentDate = null;
            try {
                incidentDate = sdf.parse(data[6]); // assuming 7th index is date string
            } catch (ParseException e) {
              e.printStackTrace();
            }
                firs.add(new FIR(data[0], data[1], data[2], data[3], data[4], data[5], incidentDate, data[7], data[8], data[9], data[10]));
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Failed to load FIRs: " + e.getMessage()); 
            e.printStackTrace();
        }
        return firs;
    }

    public List<FIR> searchFIRs(String firId) throws IOException {
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<FIR> firs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FIRS_CSV))) {
            String line;
            reader.readLine(); 
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                 Date incidentDate = null;
            try {
                incidentDate = sdf.parse(data[6]); // assuming 7th index is date string
            } catch (ParseException e) {
              e.printStackTrace();
            }
                if (data.length >= 11 && data[0].toLowerCase().contains(firId.toLowerCase())) {
                    firs.add(new FIR(data[0], data[1], data[2], data[3], data[4], data[5], incidentDate, data[7], data[8], data[9], data[10]));
                }
            }
        }
        return firs;
    }

    public static void updateFIR(FIR updatedFIR) throws IOException 
    {
        List<FIR> firs = loadFIRs();
        firs.removeIf(f -> f.getFirId().equals(updatedFIR.getFirId()));
        firs.add(updatedFIR);
        try (PrintWriter pw = new PrintWriter(new FileWriter("resources/firs.csv"))) 
        {
            pw.println("firId,complainantName,fathersName,contact,address,nicNumber,incidentDate,incidentTime,location,description,crimeType");
            for (FIR f : firs) 
            {
                pw.println(f.getFirId() + "," + 
                        (f.getComplainantName() != null ? f.getComplainantName() : "") + "," +
                        (f.getFathersName() != null ? f.getFathersName() : "") + "," +
                        (f.getContact() != null ? f.getContact() : "") + "," +
                        (f.getAddress() != null ? f.getAddress() : "") + "," +
                        (f.getNicNumber() != null ? f.getNicNumber() : "") + "," +
                        (f.getIncidentDate() != null ? f.getIncidentDate() : "") + "," +
                        (f.getIncidentTime() != null ? f.getIncidentTime() : "") + "," +
                        (f.getLocation() != null ? f.getLocation() : "") + "," +
                        (f.getDescription() != null ? f.getDescription() : "") + "," +
                        (f.getCrimeType() != null ? f.getCrimeType() : ""));
            }
        } 
        catch (IOException e) 
        {
            JOptionPane.showMessageDialog(null, "Failed to update FIR: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static void deleteFIR(String firId) 
    {
        List<FIR> firs = loadFIRs();
        boolean deleted = firs.removeIf(f -> f.getFirId().equals(firId));
        if (!deleted) 
        {
            System.out.println("Failed to delete FIR: " + firId);
            return;
        }
     try (BufferedWriter bw = new BufferedWriter(new FileWriter("resources/firs.csv"))) 
{
    bw.write("firId,complainantName,fathersName,contact,address,nicNumber,incidentDate,incidentTime,location,description,crimeType");
    bw.newLine();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    for (FIR f : firs) 
    {
        String incidentDateStr = f.getIncidentDate() != null ? sdf.format(f.getIncidentDate()) : "";
        
        bw.write(String.join(",", 
            f.getFirId(), 
            f.getComplainantName(), 
            f.getFathersName(),
            f.getContact(), 
            f.getAddress(), 
            f.getNicNumber(), 
            incidentDateStr,
            f.getIncidentTime(), 
            f.getLocation(), 
            f.getDescription(), 
            f.getCrimeType()
        ));
        bw.newLine();
    }
    System.out.println("FIR deleted successfully: " + firId);
}
        catch (IOException e) 
        {
            System.out.println("Failed to delete FIR from CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }

    
    public static List<Complaint> loadComplaints() 
    {
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Complaint> complaints = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("resources/complaints.csv"))) 
        {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) 
            {
                String[] data = line.split(",", -1); // Handle empty fields
                 Date incidentDate = null;
            try {
                incidentDate = sdf.parse(data[4]); // assuming 7th index is date string
            } catch (ParseException e) {
              e.printStackTrace();
            }
                complaints.add(new Complaint(
                    data[0], data[1], data[2], data[3], incidentDate, data[5], data[6], data[7], data[8], data[9]
                ));
            }
        }
        catch (IOException e)   
        {
            e.printStackTrace();
        }
        return complaints;
    }
    
    public static void deleteComplaint(String complaintId) 
    {
        List<Complaint> complaints = loadComplaints();
        complaints.removeIf(c -> c.getComplaintId().equals(complaintId));
        try (PrintWriter pw = new PrintWriter(new FileWriter("resources/complaints.csv"))) 
        {
            pw.println("complaintId,complainantName,contact,nicNumber,incidentDate,incidentTime,location,description,evidencePath,status");
            for (Complaint c : complaints) 
            {
                pw.println(c.getComplaintId() + "," + c.getComplainantName() + "," +
                    (c.getContact() != null ? c.getContact() : "") + "," +
                    (c.getNicNumber() != null ? c.getNicNumber() : "") + "," +
                    (c.getIncidentDate() != null ? c.getIncidentDate() : "") + "," +
                    (c.getIncidentTime() != null ? c.getIncidentTime() : "") + "," +
                    (c.getLocation() != null ? c.getLocation() : "") + "," +
                    (c.getDescription() != null ? c.getDescription() : "") + "," +
                    (c.getEvidencePath() != null ? c.getEvidencePath() : "") + "," +
                    c.getStatus());
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
}