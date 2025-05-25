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
                writer.write("complaintId,complainantName,complainantFatherName,contact,nicNumber,address,incidentDate,incidentTime,location,description,evidencePath,status\n");
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
            }
        }
    }

    public void addComplaint(String complaintId, String complainantName, String complainantFatherName,
                             String contact, String nicNumber, String address, String incidentDate,
                             String incidentTime, String location, String description,
                             String evidencePath, String status) throws IOException {
        File file = new File(COMPLAINTS_CSV);
        boolean fileExists = file.exists();
        try (FileWriter writer = new FileWriter(file, true)) {
            if (!fileExists) {
                writer.write("complaintId,complainantName,complainantFatherName,contact,nicNumber,address,incidentDate,incidentTime,location,description,evidencePath,status\n");
            }
            writer.write(String.join(",", 
                complaintId, 
                complainantName != null ? complainantName : "",
                complainantFatherName != null ? complainantFatherName : "",
                contact != null ? contact : "",
                nicNumber != null ? nicNumber : "",
                address != null ? address : "",
                incidentDate != null ? incidentDate : "",
                incidentTime != null ? incidentTime : "",
                location != null ? location : "",
                description != null ? description : "",
                evidencePath != null ? evidencePath : "",
                status != null ? status : "") + "\n");
            System.out.println("Added complaint to CSV: " + complaintId);
        }
    }

    public boolean authenticateOfficer(String username, String password) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(OFFICERS_CSV))) {
            String line;
            reader.readLine(); 
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
            reader.readLine(); 
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

    private String calculateGrade(double successPercentage) 
    {
        if (successPercentage >= 90) return "A+";
        if (successPercentage >= 80) return "A";
        if (successPercentage >= 70) return "B+";
        if (successPercentage >= 60) return "B";
        if (successPercentage >= 50) return "B-";
        return "C";
    }

    public static void addFIR(FIR fir)
    {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FIRS_CSV, true))) 
        {
            pw.println(String.join(",",
                escapeCSV(fir.getFirId()),
                escapeCSV(fir.getComplainantName()),
                escapeCSV(fir.getFathersName() != null ? fir.getFathersName() : ""),
                escapeCSV(fir.getContact() != null ? fir.getContact() : ""),
                escapeCSV(fir.getAddress() != null ? fir.getAddress() : ""),
                escapeCSV(fir.getNicNumber() != null ? fir.getNicNumber() : ""),
                escapeCSV(fir.getIncidentDate() != null ? fir.getIncidentDate() : ""),
                escapeCSV(fir.getIncidentTime() != null ? fir.getIncidentTime() : ""),
                escapeCSV(fir.getLocation() != null ? fir.getLocation() : ""),
                escapeCSV(fir.getDescription() != null ? fir.getDescription() : ""),
                escapeCSV(fir.getCrimeType() != null ? fir.getCrimeType() : "")
            ));
            System.out.println("FIR added: " + fir);
        }
        catch (IOException e) 
        {
            System.err.println("Failed to add FIR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Failed to register FIR: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static List<FIR> loadFIRs() 
    {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat fallbackSdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        List<FIR> firs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FIRS_CSV))) 
        {
            br.readLine();
            String line;
            int lineNumber = 1;
            while ((line = br.readLine()) != null)
            {
                lineNumber++;
                String[] data = splitCSV(line);
                if (data.length >= 11)
                {
                    try
                    {
                        String parsedDate = data[6];
                        if (!data[6].isEmpty()) 
                        {
                            try 
                            {
                                sdf.parse(data[6]);
                            } 
                            catch (ParseException e) 
                            {
                                parsedDate = convertDateFormat(data[6], fallbackSdf, sdf);
                                System.out.println("Converted date at line " + lineNumber + ": " + data[6] + " to " + parsedDate);
                            }
                        }
                        firs.add(new FIR(data[0], data[1], data[2], data[3], data[4], data[5], parsedDate, data[7], data[8], data[9], data[10]));
                        System.out.println("Loaded FIR: " + data[0] + " at line " + lineNumber);
                    } 
                    catch (Exception e) 
                    {
                        System.err.println("Invalid FIR data at line " + lineNumber + ": " + line + " - " + e.getMessage());
                    }
                } 
                else 
                {
                    System.err.println("Malformed FIR data at line " + lineNumber + ": " + line);
                }
            }
        } 
        catch (IOException e) 
        {
            System.err.println("Failed to load FIRs: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Total FIRs loaded: " + firs.size());
        return firs;
    }

    public static List<FIR> searchFIRs(String firId) throws IOException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat fallbackSdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        List<FIR> firs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FIRS_CSV))) 
        {
            String line;
            reader.readLine(); 
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) 
            {
                lineNumber++;
                String[] data = splitCSV(line);
                if (data.length >= 11 && data[0].toLowerCase().contains(firId.toLowerCase())) 
                {
                    try 
                    {
                        String parsedDate = data[6];
                        if (!data[6].isEmpty()) 
                        {
                            try
                            {
                                sdf.parse(data[6]);
                            }
                            catch (ParseException e)
                            {
                                parsedDate = convertDateFormat(data[6], fallbackSdf, sdf);
                                System.out.println("Converted date in search at line " + lineNumber + ": " + data[6] + " to " + parsedDate);
                            }
                        }
                        firs.add(new FIR(data[0], data[1], data[2], data[3], data[4], data[5], parsedDate, data[7], data[8], data[9], data[10]));
                        System.out.println("Found FIR: " + data[0] + " at line " + lineNumber);
                    } 
                    catch (Exception e) 
                    {
                        System.err.println("Invalid FIR data in search at line " + lineNumber + ": " + line + " - " + e.getMessage());
                    }
                }
            }
        }
        System.out.println("FIRs found for ID " + firId + ": " + firs.size());
        return firs;
    }

    public static void updateFIR(FIR updatedFIR) throws IOException 
    {
        List<FIR> firs = loadFIRs();
        firs.removeIf(f -> f.getFirId().equals(updatedFIR.getFirId()));
        firs.add(updatedFIR);
        try (PrintWriter pw = new PrintWriter(new FileWriter(FIRS_CSV)))
        {
            pw.println("firId,complainantName,fathersName,contact,address,nicNumber,incidentDate,incidentTime,location,description,crimeType");
            for (FIR f : firs) 
            {
                pw.println(String.join(",",
                    escapeCSV(f.getFirId()),
                    escapeCSV(f.getComplainantName()),
                    escapeCSV(f.getFathersName() != null ? f.getFathersName() : ""),
                    escapeCSV(f.getContact() != null ? f.getContact() : ""),
                    escapeCSV(f.getAddress() != null ? f.getAddress() : ""),
                    escapeCSV(f.getNicNumber() != null ? f.getNicNumber() : ""),
                    escapeCSV(f.getIncidentDate() != null ? f.getIncidentDate() : ""),
                    escapeCSV(f.getIncidentTime() != null ? f.getIncidentTime() : ""),
                    escapeCSV(f.getLocation() != null ? f.getLocation() : ""),
                    escapeCSV(f.getDescription() != null ? f.getDescription() : ""),
                    escapeCSV(f.getCrimeType() != null ? f.getCrimeType() : "")
                ));
            }
            System.out.println("FIR updated: " + updatedFIR.getFirId());
        }
    }

    public static void deleteFIR(String firId) 
    {
        List<FIR> firs = loadFIRs();
        boolean deleted = firs.removeIf(f -> f.getFirId().equals(firId));
        if (!deleted) 
        {
            System.err.println("Failed to delete FIR: " + firId);
            return;
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(FIRS_CSV)))
        {
            pw.println("firId,complainantName,fathersName,contact,address,nicNumber,incidentDate,incidentTime,location,description,crimeType");
            for (FIR f : firs)
            {
                pw.println(String.join(",",
                    escapeCSV(f.getFirId()),
                    escapeCSV(f.getComplainantName()),
                    escapeCSV(f.getFathersName() != null ? f.getFathersName() : ""),
                    escapeCSV(f.getContact() != null ? f.getContact() : ""),
                    escapeCSV(f.getAddress() != null ? f.getAddress() : ""),
                    escapeCSV(f.getNicNumber() != null ? f.getNicNumber() : ""),
                    escapeCSV(f.getIncidentDate() != null ? f.getIncidentDate() : ""),
                    escapeCSV(f.getIncidentTime() != null ? f.getIncidentTime() : ""),
                    escapeCSV(f.getLocation() != null ? f.getLocation() : ""),
                    escapeCSV(f.getDescription() != null ? f.getDescription() : ""),
                    escapeCSV(f.getCrimeType() != null ? f.getCrimeType() : "")
                ));
            }
            System.out.println("FIR deleted successfully: " + firId);
        } 
        catch (IOException e)
        {
            System.err.println("Failed to delete FIR from CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String convertDateFormat(String inputDate, SimpleDateFormat fromFormat, SimpleDateFormat toFormat) throws ParseException
    {
        if (inputDate == null || inputDate.isEmpty()) return "";
        try 
        {
            fromFormat.setLenient(false);
            Date date = fromFormat.parse(inputDate);
            return toFormat.format(date);
        } 
        catch (ParseException e) 
        {
            throw new ParseException("Cannot convert date: " + inputDate, 0);
        }
    }

    private static String[] splitCSV(String line) 
    {
        List<String> result = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder field = new StringBuilder();
        for (int i = 0; i < line.length(); i++) 
        {
            char c = line.charAt(i);
            if (c == '"') 
            {
                inQuotes = !inQuotes;
            } 
            else if (c == ',' && !inQuotes) 
            {
                result.add(field.toString());
                field = new StringBuilder();
            } 
            else 
            {
                field.append(c);
            }
        }
        result.add(field.toString());
        return result.toArray(new String[0]);
    }

    private static String escapeCSV(String value) 
    {
        if (value == null) return "";
        if (value.contains(",") || value.contains("\"") || value.contains("\n"))
        {
            return "\"" + value.replace("\"", "\"\"") + "\"";
        }
        return value;
    } 
     
    public static List<Complaint> loadComplaints() 
    {
        List<Complaint> complaints = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(COMPLAINTS_CSV))) 
        {
            br.readLine(); 
            String line;
            while ((line = br.readLine()) != null) 
            {
                String[] data = line.split(",", -1);
                if (data.length >= 12) 
                {
                    complaints.add(new Complaint(
                        data[0], // complaintId
                        data[1], // complainantName
                        data[2], // complainantFatherName
                        data[3], // contact
                        data[4], // nicNumber
                        data[5], // address
                        data[6], // incidentDate (MM/dd/yyyy)
                        data[7], // incidentTime
                        data[8], // location
                        data[9], // description
                        data[10], // evidencePath
                        data[11] // status
                    ));
                } 
                else
                {
                    System.err.println("Invalid complaint row: " + line);
                }
            }
            System.out.println("Loaded " + complaints.size() + " complaints");
        } 
        catch (IOException e)       
        {
            System.err.println("Failed to load complaints: " + e.getMessage());
            e.printStackTrace();
        }
        return complaints;
    }

       
    public static void updateComplaintStatus(String complaintId, String newStatus) throws IOException
    {
        System.out.println("Updating complaint " + complaintId + " to status: " + newStatus);
        File file = new File(COMPLAINTS_CSV);
        List<String> lines = new ArrayList<>();
        boolean found = false;
        int statusColumnIndex = 11; 
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
        {
            String header = reader.readLine();
            if (header == null) 
            {
                System.err.println("Error: complaints.csv is empty");
                throw new IOException("Empty complaints.csv");
            }
            lines.add(header);
            String line;
            while ((line = reader.readLine()) != null) 
            {
                String[] parts = line.split(",", -1);
                if (parts.length > statusColumnIndex && parts[0].equals(complaintId)) 
                {
                    System.out.println("Found complaint: " + line);
                    parts[statusColumnIndex] = newStatus;
                    line = String.join(",", parts);
                    found = true;
                }
                lines.add(line);
            }
        }
        if (!found) 
        {
            System.err.println("Complaint ID " + complaintId + " not found in complaints.csv");
            throw new IOException("Complaint ID " + complaintId + " not found");
        }
        try (FileWriter writer = new FileWriter(COMPLAINTS_CSV)) 
        {
            for (String line : lines)
            {
                writer.write(line + "\n");
            }
            System.out.println("Updated complaints.csv for complaint: " + complaintId);
        }
    }
    
    
    
    
}
