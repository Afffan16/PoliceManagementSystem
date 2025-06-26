Project Setup and Usage Guide

Welcome to the project! This guide will walk you through setting up and using the application after cloning the repository from GitHub.

Initial Setup

Clone the Repository:
Clone the project to your local machine using: git clone <repository-url></repository-url>

Open the Project:
Open the project in your preferred IDE or editor.

Clean and Build:
Clean and build the project to ensure all dependencies are resolved and the project is compiled correctly.

Run the Project:
Run the application. Upon running, all required CSV files will be automatically created, but they will be empty initially.

Getting Started

The application requires some initial data setup to function properly. Follow these steps to add data and explore the features.

Step 1: Admin Login

Use the default admin credentials to log in:
Username: Admin
Password: Admin123
Navigate to Officer Management > Manage Officers > Add to create a new officer account.
This officer account will be used for further actions in the application.

Step 2: Officer Login

Log out of the admin account and log in using the credentials of the officer account you just created.


Step 3: Reporting a Complaint

From the Report Complaint Page, submit a new complaint.
This will create a record that can be managed in the next steps.

Step 4: Managing Complaints and FIRs

Log in with the officer account.
Navigate to FIR Module > Check Complaint > View Details.
Change the complaint status to Approved.
This action will automatically generate an FIR and a Case.
Go to Manage FIRs to verify that the new FIR has been created.
You can update FIR details if needed.


Step 5: Investigations

Navigate to Investigations Module > Ongoing Investigations.
You will see the newly created investigation, but it can only be viewed/edited by assigned officers.
Switch back to the Admin Login.
Go to Investigations Module > Ongoing Cases > Assign Officers to assign officers to the case.
Log in as the assigned officer to view and edit the case investigation.
Note: Only the lead officer can close the case.



Step 6: Analytics and Reporting

Navigate to the Analytics and Reporting Module.
View charts displaying data on complaints and investigations.
Note: Charts will reflect data only after complaints and investigations are added.



Step 7: Criminal Module

Go to the Criminal Module and add a criminal record as needed.



Important Notes :


Empty Data: The CSV files are empty upon creation. You must add data (e.g., officers, complaints, criminals) to use the application effectively.


Ensure
- the CNIC is 13 digits long
- the Phone No is 11 digits long
- Image Paths ( Evidence Paths are correct )
- Date is in Format MM/dd/yyyy
- Time is in format HH : MM (AM/PM)

Permissions: Certain actions, like viewing investigations or closing cases, are restricted to specific roles (e.g., assigned officers or lead officers).
Only Admin can assign officers to the cases...

Testing: Ensure you add sufficient data to test all modules, as the application relies on user-generated data.
Troubleshooting


If CSV files are not created, ensure the application has write permissions in the project directory.
Verify login credentials if you encounter access issues.

Logins Already Setted Up:

Admin Login :
Username : Admin
Password : Admin123

Officer Login :

1. Officer 01 
Username : user1
Password : user1

2. Officer 02
Username : user2
Password : user2


In Resources -> Other Stuff we have SuccessStories.html download images respectively and change the path of the images in the code 
Please donot remove my name from the pdfs made by me you can give credits to me while still adding your name

For any errors, check the console logs or contact the repository maintainer.

Thank you for using the project! If you have questions or need assistance, feel free to open an issue on the GitHub repository.