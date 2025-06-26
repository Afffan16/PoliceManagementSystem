# Police Management System

## Overview

The **Police Management System** is a Java-based desktop application built using OOP Concepts designed to streamline police operations, including complaint registration, FIR management, Criminal tracking, Case investigations, Officer management, and Analytics/Reporting. Built with Java Swing and NetBeans GUI Builder, it uses CSV files for lightweight data storage, ensuring accessibility and simplicity. The system caters to officers, admins, and civilians with role-based access and a user-friendly interface.

## Features

- **Home Page:**

  - Accessible to all users (officers, civilians, admins).
  - Options to report complaints or access police/admin login.

- **Complaint Registration Module:**

  - Civilians can submit complaints, stored in `complaints.csv` with a `PENDING` status.
  - Officers can approve/disapprove complaints, triggering FIR and case creation for approved complaints.

- **Login Module:**

  - Secure authentication for police officers and admins.
  - Role-based access with username/password validation.
  - Session management for login/logout functionality.

- **Police Dashboard (For Officers):**

  - Displays instructions and navigation options for officers.
  - Access to Officer Profile, FIR Module, Case Investigations Module, Criminals Module, Analytics/Reporting Module, and Logout.

- **Officer Profile Module:**

  - View Officer details (name, ID, contact, rank).

- **FIR Module:**

  - View and search complaints by `complaintId` (pending status only).
  - Approve/disapprove complaints with crime type assignment, auto-generating FIRs and cases.
  - View and search FIRs by `firId` with detailed information.
  - Add, update, and delete FIRs, stored in `firs.csv`.

- **Case Investigations Module:**

  - View ongoing and completed cases with search functionality.
  - Edit case details (restricted to assigned officers or admin).
  - Assign officers to cases (admin-only).
  - Change case status to `COMPLETED` (lead officer or admin only).

- **Criminals Module:**

  - View and search criminal records with detailed information.
  - Add, update, and delete criminal records, stored in `criminals.csv`.

- **Analytics & Reporting Module:**

  - Visualize complaint data (registered, approved, pending, disapproved) with bar charts by month/year.
  - Analyze criminals caught, month-wise and year-wise, with bar charts.
  - Display completed vs. pending cases with bar charts for performance analysis.

- **Admin Dashboard:**

  - Full access to all modules with additional admin features.
  - Manage officers instead of viewing a personal profile.

- **Officer Management Module (Admin-Only):**

  - View and search officer records with detailed information.
  - Add, update, and delete officers, including creating login credentials and removing access, stored in `officers.csv`.

- **Key Functionalities:**

  - Image and file uploads for investigations (e.g., officer photos, criminal photos, evidence) using `JFileChooser`.
  - Data validation for inputs (e.g., phone number: 11 digits, NIC: 13 digits, no future dates).
  - Role-based access control for officers and admins.

## OOP Concepts Implemented

- **Encapsulation:**

  - Uses private fields with getter methods to protect data and expose only necessary functionality (e.g., `Criminal.java` with private attributes like `criminalId` and public getters).

- **Abstraction:**

  - Implements abstract classes or interfaces for code hiding and reuse (e.g., an `AbstractDataHandler` or interface like `DataValidator` to abstract CSV operations or input validation).

- **Polymorphism:**

  - Utilizes method overriding and method overloading for the same methods with different functionalities (e.g., overloaded `saveToCSV` methods in `CSVHandler.java` for different data types or overridden methods in `FormValidator` for specific validations).

- **Inheritance:**

  - Extends classes for code reuse (e.g., `Officer` and `Admin` extending a base `User` class to share common attributes and methods).

- **Association:**

  - Establishes relationships between classes (e.g., a `Criminal` class associated with an `Investigation` class to link criminal records with ongoing cases).

- **Object Creation and Static References:**

  - Creates objects to access variables and store data (e.g., `Criminal` objects for each record).
  - Uses static class references for accessing shared resources or utilities (e.g., `CSVHandler.getInstance()` for a singleton-like access).

## Project Structure

- **Maven-based project**:
  - `src/main/java/police/gui`: Contains all Java Swing forms (e.g., `PoliceDashboardForm.java`, `AddCriminalForm.java`).
  - `src/main/java/police/model`: Data models for each module (e.g., `Criminal.java`, `Investigation.java`) with attributes and getters.
  - `src/main/java/police`: Contains `Main.java`, `CSVHandler.java` (for CSV operations), and `Session.java` (for session management).
  - `resources/`: Stores CSV files (`complaints.csv`, `firs.csv`, `investigations.csv`, `criminals.csv`, `officers.csv`) and an `images/` folder for images.
- CSV files manage data persistence for complaints, FIRs, investigations, criminals, and officers.

## Setup

### Prerequisites

- Java JDK 23 (configured in `pom.xml` with `--enable-preview`)
- Apache Maven
- NetBeans IDE (recommended for GUI Builder)
- CSV files in `resources/`: `complaints.csv`, `firs.csv`, `investigations.csv`, `criminals.csv`, `officers.csv`
- Folder `resources/images/` for storing images

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/Afffan16/PoliceManagementSystem.git
   cd PoliceManagementSystem
   ```
2. Import project in NetBeans:
   - File → Open Project → Select `PoliceManagementSystem`.
3. Build and run:
   - Right-click project → `Build`.
   - Run `src/main/java/police/gui/LoginForm.java`.
4. Ensure CSV files in `resources/`:
   - `complaints.csv` format:

     ```
     complaintId,complainantName,fathersName,contact,address,nicNumber,incidentDate,incidentTime,location,description,status
     CMP20250513120000,John Doe,James Doe,5550101234,123 Main St,1234567890123,2025-05-01,14:30,Downtown,Theft reported,PENDING
     ```
   - `firs.csv` format:

     ```
     firId,complainantName,fathersName,contact,address,nicNumber,incidentDate,incidentTime,location,description,crimeType
     FIR20250513120000,John Doe,James Doe,5550101234,123 Main St,1234567890123,2025-05-01,14:30,Downtown,Theft reported,Theft
     ```
   - `investigations.csv`, `criminals.csv`, `officers.csv` follow similar structured formats.

### Dependencies

- Java Swing (standard library)
- Maven for build management
- External libraries:
  - `com.toedter:jcalendar:1.4` (for `JDateChooser`)
  - `org.jfree:jfreechart:1.0.19` (for bar charts in Analytics Module)
  - `org.jfree:jcommon:1.0.23` (dependency for `jfreechart`)
  - `com.github.lgooddatepicker:LGoodDatePicker:11.2.1` (additional date picker library)
  - `org.netbeans.external:AbsoluteLayout:RELEASE240` (for layout management in Swing forms)
  - `org.apache.poi:poi:5.2.3` and `org.apache.poi:poi-ooxml:5.2.3` (for potential Excel export in Analytics Module)

## Team

| Name | Role | Contributions |
| --- | --- | --- |
| Muhammad Affan Bin Aamir | Team Lead, Developer | Project Setup, FIR Module, Case Investigation Module, Admin Features, Sprint Planning, Coordination |
| Dawood Khurram | Developer, Designer | Home Page, Report Complaint Page, Police/Admin Login Modules, Dashboards, Designing, Documentation |
| Muhammad Umar | Developer | Officer Profile Module (view-only), Manage Officers Module (CRUD operations), Criminals Module, Designing |
| Samiullah Baig | Developer, Tester | FIR Module, Analytics & Reporting Module, Detailed Testing |

## License

MIT License. See LICENSE for details.
