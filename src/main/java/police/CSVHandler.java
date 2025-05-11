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
import java.util.*;

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

    public void addComplaint(String complaintId, String complainantName, String contact, String nicNumber,
                             String incidentDate, String incidentTime, String location, String description,
                             String evidencePath, String status) throws IOException {
        try (FileWriter writer = new FileWriter(COMPLAINTS_CSV, true)) {
            writer.write(String.join(",", complaintId, complainantName, contact, nicNumber, incidentDate,
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

    public void addFIR(FIR fir) throws IOException {
        try (FileWriter writer = new FileWriter(FIRS_CSV, true)) {
            writer.write(String.join(",", fir.getFirId(), fir.getComplainantName(), fir.getFathersName(),
                fir.getContact(), fir.getAddress(), fir.getNicNumber(), fir.getIncidentDate(),
                fir.getIncidentTime(), fir.getLocation(), fir.getDescription(), fir.getCrimeType()) + "\n");
        }
    }
    

    public List<FIR> getAllFIRs() throws IOException {
        List<FIR> firs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FIRS_CSV))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 11) {
                    firs.add(new FIR(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10]));
                }
            }
        }
        return firs;
    }

    public List<FIR> searchFIRs(String firId) throws IOException {
        List<FIR> firs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FIRS_CSV))) {
            String line;
            reader.readLine(); 
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 11 && data[0].toLowerCase().contains(firId.toLowerCase())) {
                    firs.add(new FIR(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10]));
                }
            }
        }
        return firs;
    }

    public void updateFIR(FIR updatedFIR) throws IOException {
        List<FIR> firs = getAllFIRs();
        try (FileWriter writer = new FileWriter(FIRS_CSV)) {
            writer.write("firId,complainantName,fathersName,contact,address,nicNumber,incidentDate,incidentTime,location,description,crimeType\n");
            for (FIR fir : firs) {
                if (fir.getFirId().equals(updatedFIR.getFirId())) {
                    writer.write(String.join(",", updatedFIR.getFirId(), updatedFIR.getComplainantName(),
                        updatedFIR.getFathersName(), updatedFIR.getContact(), updatedFIR.getAddress(),
                        updatedFIR.getNicNumber(), updatedFIR.getIncidentDate(), updatedFIR.getIncidentTime(),
                        updatedFIR.getLocation(), updatedFIR.getDescription(), updatedFIR.getCrimeType()) + "\n");
                } else {
                    writer.write(String.join(",", fir.getFirId(), fir.getComplainantName(), fir.getFathersName(),
                        fir.getContact(), fir.getAddress(), fir.getNicNumber(), fir.getIncidentDate(),
                        fir.getIncidentTime(), fir.getLocation(), fir.getDescription(), fir.getCrimeType()) + "\n");
                }
            }
        }
    }

    public void deleteFIR(String firId) throws IOException {
        List<FIR> firs = getAllFIRs();
        try (FileWriter writer = new FileWriter(FIRS_CSV)) {
            writer.write("firId,complainantName,fathersName,contact,address,nicNumber,incidentDate,incidentTime,location,description,crimeType\n");
            for (FIR fir : firs) {
                if (!fir.getFirId().equals(firId)) {
                    writer.write(String.join(",", fir.getFirId(), fir.getComplainantName(), fir.getFathersName(),
                        fir.getContact(), fir.getAddress(), fir.getNicNumber(), fir.getIncidentDate(),
                        fir.getIncidentTime(), fir.getLocation(), fir.getDescription(), fir.getCrimeType()) + "\n");
                }
            }
        }
    }
}