/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package police.model;

/**
 *
 * @author HP
 */


public class Officer 
{
    private String officerId;
    private String username;
    private String password;
    private String role;
    private String name;
    private String badgeNumber;
    private String email;
    private String phone;
    private int serviceYears;
    private int casesSolved;
    private double successPercentage;
    private String grade;
    private String imagePath;

    public Officer(String officerId, String username, String password, String role,
                   String name, String badgeNumber, String email, String phone,
                   int serviceYears, int casesSolved, double successPercentage,
                   String grade, String imagePath) {
        this.officerId = officerId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.badgeNumber = badgeNumber;
        this.email = email;
        this.phone = phone;
        this.serviceYears = serviceYears;
        this.casesSolved = casesSolved;
        this.successPercentage = successPercentage;
        this.grade = grade;
        this.imagePath = imagePath;
    }

    // Getters
    public String getOfficerId() { return officerId; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public String getName() { return name; }
    public String getBadgeNumber() { return badgeNumber; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public int getServiceYears() { return serviceYears; }
    public int getCasesSolved() { return casesSolved; }
    public double getSuccessPercentage() { return successPercentage; }
    public String getGrade() { return grade; }
    public String getImagePath() { return imagePath; }
}