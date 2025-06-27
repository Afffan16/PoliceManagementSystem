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
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class CSVHandler 
{
    private static final String COMPLAINTS_CSV = "resources/complaints.csv";
    private static final String FIRS_CSV = "resources/firs.csv";
    private static final String INVESTIGATIONS_CSV = "resources/investigations.csv";
    private static final String CRIMINALS_CSV = "resources/criminals.csv";
    private static final String OFFICERS_CSV = "resources/officers.csv";

    public void initializeCSVFiles() throws IOException 
    {
        // Complaints CSV
        File complaintsFile = new File(COMPLAINTS_CSV);
        if (!complaintsFile.exists())
        {
            try (FileWriter writer = new FileWriter(complaintsFile)) 
            {
                writer.write("complaintId,complainantName,complainantFatherName,contact,nicNumber,address,incidentDate,incidentTime,location,description,evidencePath,status\n");
            }
        }

        // FIRs CSV
        File firsFile = new File(FIRS_CSV);
        if (!firsFile.exists())
        {
            try (FileWriter writer = new FileWriter(firsFile)) 
            {
                writer.write("firId,complainantName,fathersName,contact,address,nicNumber,incidentDate,incidentTime,location,description,crimeType\n");
            }
        }

        // Investigations CSV
        File file = new File(INVESTIGATIONS_CSV);
        if (!file.exists())
        {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) 
            {
                writer.write("investigationId,firId,creationDate,officerId1,officerId2,evidencePaths,witnessStatements,otherDetails,suspects,caseResult,finalCriminal,status,lastUpdated\n");
            }
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }

        // Criminals CSV
        File criminalsFile = new File(CRIMINALS_CSV);
        if (!criminalsFile.exists())
        {
            try (FileWriter writer = new FileWriter(criminalsFile)) 
            {
                writer.write("CriminalID,CriminalName,CNIC,Address,ImagePath,NoOfCrimes,ArrestStatus,DateOfArrest,DescriptionForArrest\n");
            }
        }


        // Officers CSV
        File officersFile = new File(OFFICERS_CSV);
        if (!officersFile.exists())
        {
            try (FileWriter writer = new FileWriter(officersFile)) 
            {
                writer.write("OfficerId,Username,Password,Role,Name,BadgeNo,Email,Phone,ServiceYears,CasesSolved,SuccessPercentage,ImagePath\n");
            }
        }
    }

                            // Report a Complain //
    
    public void addComplaint(String complaintId, String complainantName, String complainantFatherName,
                             String contact, String nicNumber, String address, String incidentDate,
                             String incidentTime, String location, String description,
                             String evidencePath, String status) throws IOException 
    {
        File file = new File(COMPLAINTS_CSV);
        boolean fileExists = file.exists();
        try (FileWriter writer = new FileWriter(file, true))
        {
            if (!fileExists) 
            {
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
    
    public int getComplaintCount() 
    {
        try 
        {
            List<String[]> complaints = readCSV(COMPLAINTS_CSV);
            return complaints.size();
        }
        catch (Exception e) 
        {
            System.err.println("Error reading complaints.csv: " + e.getMessage());
            return 0;
        }
    }

                        // Officer Login + Details + Manage Officers //
    
    public boolean authenticateOfficer(String username, String password) throws IOException 
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(OFFICERS_CSV))) 
        {
            String line;
            reader.readLine(); 
            while ((line = reader.readLine()) != null) 
            {
                String[] data = line.split(",");
                if (data.length >= 3 && data[1].equals(username) && data[2].equals(password))
                {
                    Session.setLoggedInUsername(username);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isAdmin(String username, String password) 
    {
        return "Admin".equals(username) && "Admin123".equals(password);
    }
    public boolean isAdmin(String username)
    {
        return "Admin".equals(username);
    }
    
    
    public List<Officer> loadOfficers() throws IOException 
    {
        System.out.println("Attempting to read file: " + OFFICERS_CSV);
        List<Officer> officers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(OFFICERS_CSV))) 
        {
            String header = reader.readLine();
            System.out.println("Header: " + header);
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) 
            {
                System.out.println("Reading line " + lineNumber + ": " + line);
                String[] data = splitCSV(line);
                System.out.println("Number of fields: " + data.length);
                if (data.length == 12) 
                {
                    try
                    {
                        int serviceYears = Integer.parseInt(data[8]);
                        int casesSolved = Integer.parseInt(data[9]);
                        double successPercentage = Double.parseDouble(data[10]);
                        String grade = calculateGrade(successPercentage);
                        Officer o = new Officer(
                            data[0], data[1], data[2], data[3], data[4], data[5],
                            data[6], data[7], serviceYears, casesSolved,
                            successPercentage, grade, data[11]
                        );
                        officers.add(o);
                        System.out.println("Successfully parsed officer: " + o.getOfficerId());
                    } 
                    catch (NumberFormatException e) 
                    {
                        System.out.println("Error parsing numbers at line " + lineNumber + ": " + e.getMessage());
                    }
                } 
                else 
                {
                    System.out.println("Skipping line " + lineNumber + ": Expected 12 fields, found " + data.length);
                }
                lineNumber++;
            }
        }
        System.out.println("Total officers loaded: " + officers.size());
        return officers;
    }

    public Officer getOfficerDetails(String username) throws IOException 
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(OFFICERS_CSV))) 
        {
            String line;
            reader.readLine(); 
            while ((line = reader.readLine()) != null)
            {
                String[] data = line.split(",");
                if (data.length >= 12 && data[1].equals(username)) 
                {
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
    
    public void writeCSV(Officer officer) throws IOException
    {
        System.out.println("Current working directory (writeCSV): " + System.getProperty("user.dir"));
        List<Officer> officers = loadOfficers();
        officers.add(officer);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OFFICERS_CSV)))
        {
            writer.write("OfficerID,Username,Password,Role,Name,BadgeNo,Email,Phone,ServiceYears,CasesSolved,SuccessPercentage,ImagePath");
            writer.newLine();
            for (Officer o : officers) 
            {
                writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%d,%d,%.2f,%s",
                    o.getOfficerId(), o.getUsername(), o.getPassword(), o.getRole(), o.getName(),
                    o.getBadgeNumber(), o.getEmail(), o.getPhone(), o.getServiceYears(),
                    o.getCasesSolved(), o.getSuccessPercentage(), o.getImagePath()));
                writer.newLine();
            }
        }
    }

    public void updateOfficer(Officer officer) throws IOException 
    {
        System.out.println("Current working directory (updateOfficer): " + System.getProperty("user.dir"));
        List<Officer> officers = loadOfficers();
        for (int i = 0; i < officers.size(); i++)
        {
            if (officers.get(i).getOfficerId().equals(officer.getOfficerId()))
            {
                officers.set(i, officer);
                break;
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OFFICERS_CSV))) 
        {
            writer.write("OfficerID,Username,Password,Role,Name,BadgeNo,Email,Phone,ServiceYears,CasesSolved,SuccessPercentage,ImagePath");
            writer.newLine();
            for (Officer o : officers)
            {
                writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%d,%d,%.2f,%s",
                    o.getOfficerId(), o.getUsername(), o.getPassword(), o.getRole(), o.getName(),
                    o.getBadgeNumber(), o.getEmail(), o.getPhone(), o.getServiceYears(),
                    o.getCasesSolved(), o.getSuccessPercentage(), o.getImagePath()));
                writer.newLine();
            }
        }
    }
    
    public void deleteOfficer(String officerId) throws IOException 
    {
        System.out.println("Current working directory (deleteOfficer): " + System.getProperty("user.dir"));
        List<Officer> officers = loadOfficers();
        boolean removed = officers.removeIf(o -> o.getOfficerId().equals(officerId));
        if (!removed) 
        {
            throw new IOException("Officer with ID " + officerId + " not found.");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OFFICERS_CSV))) 
        {
            writer.write("OfficerID,Username,Password,Role,Name,BadgeNo,Email,Phone,ServiceYears,CasesSolved,SuccessPercentage,ImagePath");
            writer.newLine();
            for (Officer o : officers)
            {
                writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%d,%d,%.2f,%s",
                    o.getOfficerId(), o.getUsername(), o.getPassword(), o.getRole(), o.getName(),
                    o.getBadgeNumber(), o.getEmail(), o.getPhone(), o.getServiceYears(),
                    o.getCasesSolved(), o.getSuccessPercentage(), o.getImagePath()));
                writer.newLine();
            }
        }
    }

    public int getOfficerCount() 
    {
        try 
        {
            List<Officer> officers = loadOfficers();
            return officers.size();
        } 
        catch (IOException e)
        {
            System.err.println("Error reading officers.csv: " + e.getMessage());
            return 0;
        }
    }

    public String calculateGrade(double successPercentage) 
    {
        if (successPercentage >= 90) return "A+";
        if (successPercentage >= 80) return "A";
        if (successPercentage >= 70) return "B+";
        if (successPercentage >= 60) return "B";
        if (successPercentage >= 50) return "B-";
        return "C";
    }
    
    
    
                                // FIR Module //

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
            pw.println("firId,complainantName,fathersName,contact,address,nicNumber,incidentDate,incidentTime,location,description,crimeType\n");
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
            pw.println("firId,complainantName,fathersName,contact,address,nicNumber,incidentDate,incidentTime,location,description,crimeType\n");
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
    
    
                        // Criminal Module  //
    
    public List<Criminal> getAllCriminals() throws IOException 
    {
        List<Criminal> criminals = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CRIMINALS_CSV)))
        {
            String line;
            reader.readLine(); 
            while ((line = reader.readLine()) != null) 
            {
                String[] data = line.split(",");
                if (data.length >= 9) 
                {
                    criminals.add(new Criminal(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]));
                }
            }
        }
        return criminals;
    }

    public List<Criminal> searchCriminals(String txtID) throws IOException 
    {
        List<Criminal> criminals = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CRIMINALS_CSV)))
        {
            String line;
            reader.readLine(); 
            while ((line = reader.readLine()) != null) 
            {
                String[] data = line.split(",");
                if (data.length >= 9 && data[0].toLowerCase().contains(txtID.toLowerCase()))
                {
                    criminals.add(new Criminal(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]));
                }
            }
        }
        return criminals;
    }

    public void addCriminal(Criminal criminal) throws IOException 
    {
        try (FileWriter writer = new FileWriter(CRIMINALS_CSV, true)) 
        {
            writer.write(String.join(",", 
                criminal.getCriminalId(),
                criminal.getCriminalName(),
                criminal.getCnic(),
                criminal.getAddress(),
                criminal.getImagePath(),
                criminal.getNoOfCrimes(),
                criminal.getArrestStatus(),
                criminal.getDateOfArrest(),
                criminal.getDescriptionForArrest()
            ) + "\n");
        }
    }

    public void updateCriminal(Criminal updatedCriminal) throws IOException 
    {
        List<Criminal> criminals = getAllCriminals(); 
        try (FileWriter writer = new FileWriter(CRIMINALS_CSV)) 
        {
            writer.write("CriminalID,CriminalName,CNIC,Address,ImagePath,NoOfCrimes,ArrestStatus,DateOfArrest,DescriptionForArrest\n");
            for (Criminal criminal : criminals)
            {
                if (criminal.getCriminalId().equals(updatedCriminal.getCriminalId())) 
                {
                    writer.write(String.join(",",
                        updatedCriminal.getCriminalId(),
                        updatedCriminal.getCriminalName(),
                        updatedCriminal.getCnic(),
                        updatedCriminal.getAddress(),
                        updatedCriminal.getImagePath(),
                        updatedCriminal.getNoOfCrimes(),
                        updatedCriminal.getArrestStatus(),
                        updatedCriminal.getDateOfArrest(),
                        updatedCriminal.getDescriptionForArrest()
                    ) + "\n");
                }
                else 
                {
                    writer.write(String.join(",",
                        criminal.getCriminalId(),
                        criminal.getCriminalName(),
                        criminal.getCnic(),
                        criminal.getAddress(),
                        criminal.getImagePath(),
                        criminal.getNoOfCrimes(),
                        criminal.getArrestStatus(),
                        criminal.getDateOfArrest(),
                        criminal.getDescriptionForArrest()
                    ) + "\n");
                }
            }
        }
    }

    public void deleteCriminal(String criminalID) throws IOException 
    {
        List<Criminal> criminals = getAllCriminals();
        try (FileWriter writer = new FileWriter(CRIMINALS_CSV))
        {
            writer.write("CriminalID,CriminalName,CNIC,Address,ImagePath,NoOfCrimes,ArrestStatus,DateOfArrest,DescriptionForArrest\n");
            for (Criminal cri : criminals) 
            { 
                if (!cri.getCriminalId().equals(criminalID))
                {
                    writer.write(String.join(",", 
                        cri.getCriminalId(),
                        cri.getCriminalName(),
                        cri.getCnic(),
                        cri.getAddress(),
                        cri.getImagePath(),
                        cri.getNoOfCrimes(),
                        cri.getArrestStatus(),
                        cri.getDateOfArrest(),
                        cri.getDescriptionForArrest()
                    ) + "\n");
                }
            }
        }
    }    
    
    public int getCriminalCount() throws IOException 
    {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(CRIMINALS_CSV))) {
            reader.readLine(); // Skip header
            while (reader.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            System.err.println("Error reading criminals.csv: " + e.getMessage());
        }
        return count;
    }
    
                        // Registering FIR through complains //
    
    
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

    public static String escapeCSV(String value) 
    {
        if (value == null || value.isEmpty()) 
        {
            return "";
        }
        value = value.replace("\n", " ").replace("\r", " ");
        if (value.contains(",") || value.contains("\"")) 
        {
            value = "\"" + value.replace("\"", "\"\"") + "\"";
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
    
                    //  Case Investigation Module //
    
    public void createInvestigationFromFIR(String firId) 
    {
        if (!firExists(firId)) 
        {
            throw new IllegalArgumentException("FIR ID " + firId + " does not exist.");
        }
        FIRData firData = getFIRData(firId);
        Investigation investigation = new Investigation(firId);
        investigation.setFirId(firId);
        investigation.setCreationDate(firData.getIncidentDate() != null ? firData.getIncidentDate() : new Date());
        investigation.setStatus("Active");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INVESTIGATIONS_CSV, true))) 
        {
            writer.write(investigation.toString() + "\n");
        } 
        catch (IOException e)
        {
            System.err.println("Failed to write investigation: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void addInvestigationDetails(Investigation investigation) 
    {
        List<Investigation> investigations = loadInvestigations();
        boolean updated = false;
        for (int i = 0; i < investigations.size(); i++) {
            
            if (investigations.get(i).getInvestigationId().equals(investigation.getInvestigationId())) 
            {
                investigations.set(i, investigation);
                updated = true;
                break;
            }
        }
        if (!updated) 
        {
            investigations.add(investigation);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INVESTIGATIONS_CSV))) 
        {
            writer.write("investigationId,firId,creationDate,officerId1,officerId2,evidencePaths,witnessStatements,otherDetails,suspects,caseResult,finalCriminal,status,lastUpdated\n");
            for (Investigation inv : investigations)
            {
                writer.write(inv.toString() + "\n");
            }
        }
        catch (IOException e) 
        {
            System.err.println("Failed to update investigations.csv: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Investigation> loadInvestigations()
    {
        List<Investigation> investigations = new ArrayList<>();
        File file = new File(INVESTIGATIONS_CSV);
        System.out.println("Loading investigations from: " + file.getAbsolutePath());
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
        {
            String line = reader.readLine();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) 
            {
                lineNumber++;
                System.out.println("Parsing line " + lineNumber + ": " + line);
                String[] data = line.split(",", -1);
                if (data.length >= 13) 
                {
                    List<String> evidencePaths = data[5].isEmpty() ? new ArrayList<>() :
                        Arrays.asList(data[5].split(";", -1)).stream()
                            .map(path -> path.replace(";", ","))
                            .collect(Collectors.toList());
                    try 
                    {
                        Investigation inv = new Investigation(
                            data[0],
                            data[1],
                            data[2].isEmpty() ? new Date() : sdf.parse(data[2]),
                            data[3].isEmpty() ? null : data[3],
                            data[4].isEmpty() ? null : data[4],
                            evidencePaths,
                            data[6].isEmpty() ? null : data[6].replace(";", ","),
                            data[7].isEmpty() ? null : data[7].replace(";", ","),
                            data[8].isEmpty() ? null : data[8].replace(";", ","),
                            data[9].isEmpty() ? null : data[9].replace(";", ","),
                            data[10].isEmpty() ? null : data[10].replace(";", ","),
                            data[11],
                            data[12].isEmpty() ? new Date() : sdf.parse(data[12])
                        );
                        investigations.add(inv);
                    }
                    catch (Exception e)
                    {
                        System.err.println("Error parsing line " + lineNumber + ": " + e.getMessage());
                        e.printStackTrace();
                    }
                } 
                else
                {
                    System.err.println("Invalid line format at line " + lineNumber + ": " + line);
                }
            }
        }
        catch (IOException e) 
        {
            System.err.println("Failed to read investigations.csv: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Loaded " + investigations.size() + " investigations.");
        return investigations;
    }

    public List<Investigation> loadOngoingInvestigations() 
    {
        List<Investigation> ongoing = new ArrayList<>();
        for (Investigation inv : loadInvestigations())
        {
            if (inv.getStatus() != null && (inv.getStatus().equals("Initiated") || inv.getStatus().equals("Active")))
            {
                ongoing.add(inv);
            }
        }
        return ongoing;
    }

    public Investigation findInvestigationById(String investigationId)
    {
        for (Investigation inv : loadInvestigations()) 
        {
            if (inv.getInvestigationId() != null && inv.getInvestigationId().equals(investigationId))
            {
                return inv;
            }
        }
        return null;
    }
    
    
    public String getOfficerIdFromUsername(String username) 
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(OFFICERS_CSV))) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) 
            {
                String[] data = line.split(",", -1);
                if (data.length >= 12 && data[1].equals(username)) 
                {
                    return data[0]; 
                }
            }
        }
        catch (IOException e)
        {
            System.err.println("Failed to read officers.csv: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    
    public FIRData getFIRData(String firId) 
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(FIRS_CSV))) 
        {
            String line = reader.readLine(); 
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            int lineNumber = 1;
            while ((line = reader.readLine()) != null)
            {
                lineNumber++;
                String[] data = line.split(",", -1);
                if (data.length >= 11 && data[0].equals(firId)) 
                {
                    Date incidentDate = null;
                    try 
                    {
                        if (!data[6].isEmpty())
                        { 
                            incidentDate = sdf.parse(data[6]);
                        }
                    }
                    catch (Exception e)
                    {
                        System.err.println("Error parsing incidentDate at line " + lineNumber + ": '" + data[6] + "'. Expected format: MM/dd/yyyy");
                        e.printStackTrace();
                    }
                    return new FIRData
                    (
                        data[0], 
                        data[1].isEmpty() ? null : data[1].replace(";", ","),
                        data[2].isEmpty() ? null : data[2].replace(";", ","), 
                        data[3].isEmpty() ? null : data[3].replace(";", ","),
                        data[4].isEmpty() ? null : data[4].replace(";", ","), 
                        data[5].isEmpty() ? null : data[5].replace(";", ","), 
                        incidentDate, 
                        data[7].isEmpty() ? null : data[7], 
                        data[8].isEmpty() ? null : data[8].replace(";", ","),
                        data[9].isEmpty() ? null : data[9].replace(";", ","), 
                        data[10].isEmpty() ? null : data[10].replace(";", ",")
                    );
                }
            }
        }
        catch (Exception e) 
        {
            System.err.println("Failed to read firs.csv: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    private boolean firExists(String firId)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(FIRS_CSV))) 
        {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null)
            {
                String[] data = line.split(",", -1);
                if (data.length > 0 && data[0].equals(firId))
                {
                    return true;
                }
            }
        }
        catch (IOException e)
        {
            System.err.println("Failed to check firs.csv: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    
    
    public List<String[]> readCSV(String fileName) 
    {
        List<String[]> data = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) 
        {
            System.err.println("File not found: " + fileName);
            return data;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) 
        {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null)
            {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                if (line.trim().isEmpty())
                {
                    continue;
                }
                String[] row = line.split(",");
                data.add(row);
            }
        }
        catch (IOException e) 
        {
            System.err.println("Error reading " + fileName + ": " + e.getMessage());
        }
        return data;
    }

    public int getFirCount() 
    {
        try 
        {
            List<String[]> firs = readCSV(FIRS_CSV);
            return firs.size();
        }
        catch (Exception e) 
        {
            System.err.println("Error reading firs.csv: " + e.getMessage());
            return 0;
        }
    }

    public int getInvestigationCount() {
        try 
        {
            List<String[]> investigations = readCSV(INVESTIGATIONS_CSV);
            return investigations.size();
        } 
        catch (Exception e)
        {
            System.err.println("Error reading investigations.csv: " + e.getMessage());
            return 0;
        }
    }



    
    
    public static class FIRData 
    {
        private String firId;
        private String complainantName;
        private String fathersName;
        private String contact;
        private String address;
        private String nicNumber;
        private Date incidentDate;
        private String incidentTime;
        private String location;
        private String description;
        private String crimeType;

        public FIRData(String firId, String complainantName, String fathersName, String contact,
                       String address, String nicNumber, Date incidentDate, String incidentTime,
                       String location, String description, String crimeType) 
        {
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

        public String getFirId() { return firId; }
        public String getComplainantName() { return complainantName; }
        public String getFathersName() { return fathersName; }
        public String getContact() { return contact; }
        public String getAddress() { return address; }
        public String getNicNumber() { return nicNumber; }
        public Date getIncidentDate() { return incidentDate; }
        public String getIncidentTime() { return incidentTime; }
        public String getLocation() { return location; }
        public String getDescription() { return description; }
        public String getCrimeType() { return crimeType; }
    }
    
}
