/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package police.model;

/**
 *
 * @author HP
 */
public class Criminal extends Person
{
    private String criminalId;
    private String criminalName;
    private String cnic;
    private String address;
    private String imagePath;
    private String noOfCrimes;
    private String arrestStatus;
    private String dateOfArrest;
    private String descriptionForArrest;

    public Criminal(String criminalId, String criminalName, String cnic, String address, String imagePath, 
                    String noOfCrimes, String arrestStatus, String dateOfArrest, String descriptionForArrest) {
        this.criminalId = criminalId;
        this.criminalName = criminalName;
        this.cnic = cnic;
        this.address = address;
        this.imagePath = imagePath;
        this.noOfCrimes = noOfCrimes;
        this.arrestStatus = arrestStatus;
        this.dateOfArrest = dateOfArrest;
        this.descriptionForArrest = descriptionForArrest;
    }

    // Getters
    public String getCriminalId() { return criminalId; }
    public String getCriminalName() { return criminalName; }
    public String getCnic() { return cnic; }
    public String getAddress() { return address; }
    public String getImagePath() { return imagePath; }
    public String getNoOfCrimes() { return noOfCrimes; }
    public String getArrestStatus() { return arrestStatus; }
    public String getDateOfArrest() { return dateOfArrest; }
    public String getDescriptionForArrest() { return descriptionForArrest; }
        @Override 
    public String getname(){
        return criminalName;
    }

    @Override
    String getID() {
        return criminalId;
    }
    
   

}