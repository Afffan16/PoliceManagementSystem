# Police Management System

## Overview

The **Police Management System** is a Java-based desktop application designed to streamline police operations, including complaint registration, FIR management, criminal tracking, and officer profile management. Built with Java Swing and NetBeans GUI Builder, it uses CSV files (`firs.csv`, `complaints.csv`) for lightweight data storage, ensuring accessibility and simplicity.

## Features

- **Login Module**:
  - Secure authentication for police officers and admins.
  - Role-based access with username/password validation.
- **Police Profile Module**:
  - Manage officer details (name, ID, contact, rank).
  - Create, read, update, and delete (CRUD) officer records.
- **FIR Module**:
  - Register FIRs from approved complaints via `CheckComplaintsForm.java`.
  - Search FIRs by `firId` only in `ViewSearchFIRForm.java` (case-insensitive, partial match).
  - View detailed FIR information (e.g., complainant name, address, crime type) using "View Details" button in JTable.
  - Add, update, and delete FIRs in `FIRManagementForm.java`.
- **Criminal Module**:
  - Track criminal records (name, crimes, status).
  - Search and update criminal profiles.
- **Project Structure**:
  - Maven-based project with `src/main/java/police/gui` for UI, `police/model` for data models, and `resources` for CSV files.

## Recent Changes

- **May 15, 2025**:
  - Completed FIR Module:
    - Fixed `NullPointerException` in `FIRManagementForm.java` for search functionality.
    - Updated `ViewSearchFIRForm.java` to search by `firId` only and added "View Details" button in JTable.
    - Pushed to `fir-module-dev` branch.
  - Sprint 2 progress: Police profile and criminal modules on track for completion by May 17, 2025.
  - Team members (Dawood, Samiullah, Umar) are adding two fields (e.g., `address` in `ReportComplaintForm.java`).

## Development Progress

See the Sprint Plan for detailed sprint timelines, module deliverables, and team responsibilities.

## Setup

### Prerequisites

- Java JDK 8 or higher
- Apache Maven
- NetBeans IDE (recommended for GUI Builder)
- CSV files: `firs.csv`, `complaints.csv` in `resources/`

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

   - `firs.csv` format:

     ```
     firId,complainantName,fathersName,contact,address,nicNumber,incidentDate,incidentTime,location,description,crimeType
     FIR20250513120000,John Doe,James Doe,555-0101,123 Main St,1234567890,2025-05-01,14:30,Downtown,Theft reported,Theft
     ```

   - `complaints.csv`: Stores complaint data for FIR generation.

### Dependencies

- Java Swing (standard library)
- Maven for build management
- No external libraries beyond standard Java

## Team

| Name | Role | Contributions |
| --- | --- | --- |
| M. Affan | Project Lead, Developer | Project Setup, FIR Module, Case Investigation Module, Sprint planning, Coordination |
| Dawood | Developer, Designer | Login Module, Police Profile Module, Police Dashboard, Desigining |
| Umar | Developer | Criminal Module, Court & Legalities Module |
| Samiullah | Developer, Tester | FIR Module, Complaint Registration Module, Analytics & Reporting Module, Detailed Testing  |

## Contributing

- Fork the repository.
- Create a branch (`git checkout -b feature/your-feature`).
- Commit changes (`git commit -m "Add your feature"`).
- Push to branch (`git push origin feature/your-feature`).
- Open a Pull Request.

## License

MIT License. See LICENSE for details.