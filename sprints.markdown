# Police Management System Sprint Plan

## Overview

The **Police Management System** project was divided into four sprints from May 5 to June 3, 2025, to meet the final submission deadline of June 3, 2025. Each sprint focused on module development, UI design, testing, and documentation to deliver a comprehensive police operations system.

## Sprint 1: Requirements, Project Structure, and Login Module 

- **Duration**: May 5–10, 2025
- **Goals**:
  - Set up Maven project structure (`src/main/java/police/gui`, `police/model`, `resources`).
  - Implement Login Module for secure authentication.
- **Deliverables**:
  - `LoginForm.java`: Username/password validation, role-based access.
  - `pom.xml`: Maven dependencies.
  - CSV files: `complaints.csv`, `firs.csv`, `investigations.csv`, `criminals.csv`, `officers.csv`.
- **Team**:
  - M. Affan: Project setup, coordination.
  - Dawood: Login module implementation.
- **Status**: Completed.

## Sprint 2: Police Profile, FIR, Criminal Modules, and Dashboards 

- **Duration**: May 11–20, 2025
- **Goals**:
  - Complete Police Profile Module for officer management (view-only).
  - Finalize FIR Module (complaint-to-FIR flow, search, view).
  - Implement Criminal Module for record tracking.
  - Add Police Login, Admin Login, Police Dashboard, and Admin Dashboard.
- **Deliverables**:
  - `PoliceProfileForm.java`: Officer details display (view-only).
  - `FIRManagementForm.java`, `ViewSearchFIRForm.java`, `CheckComplaintsForm.java`, `AddUpdateFIRForm.java`: FIR functionality.
  - `CriminalForm.java`: Criminal record management.
  - `PoliceDashboardForm.java`, `AdminDashboard.java`: Dashboards for navigation.
  - Two fields (e.g., `address`) added to relevant forms.
- **Team**:
  - M. Affan: FIR module, Sprint coordination.
  - Dawood: Police Profile Module (view-only), Police Dashboard, Admin Dashboard.
  - Umar: Manage Officers Module (CRUD operations).
  - Samiullah: Complaint Registration, FIR Module, Testing.
- **Status**: Completed.

## Sprint 3: UI Design and New Modules 

- **Duration**: May 21–28, 2025
- **Goals**:
  - Enhance UI for login, police profile, FIR, and criminal modules (light gray theme, Arial, 20px padding).
  - Implement Case Investigation Module (case tracking, evidence).
  - Develop Analytics and Reporting Module (crime stats, reports).
  - Build Manage Officers Module (officer management for admins).
- **Deliverables**:
  - Updated UI: `LoginForm.java`, `PoliceProfileForm.java`, `FIRManagementForm.java`, `ViewSearchFIRForm.java`, `CriminalForm.java`.
  - `CaseInvestigationForm.java`: Case assignment, evidence tracking.
  - `AnalyticsReportForm.java`: Crime trend charts, CSV report exports.
  - `ManageOfficersForm.java`: Officer management (add, update, delete officers).
- **Team**:
  - M. Affan: Case Investigation, coordination.
  - Samiullah: Analytics and Reporting, testing.
  - Umar: Manage Officers Module (CRUD operations).
  - Dawood: UI design for existing modules.
- **Status**: Completed.

## Sprint 4: Final Design, Testing, and Submission 

- **Duration**: May 29–June 3, 2025
- **Goals**:
  - Finalize UI design for all modules (consistent fonts, colors).
  - Conduct testing (unit, integration, user acceptance).
  - Write project report (architecture, features, challenges).
  - Prepare submission package.
- **Deliverables**:
  - Polished UI across all forms (Arial, RGB 240,240,240, 20px padding).
  - Test reports: Bug fixes, test case results (unit, integration, UAT).
  - `ProjectReport.pdf`: System overview, implementation details, outcomes.
  - GitHub release: `v1.0.0`.
  - Submission package: Source code, report, demo video.
- **Team**:
  - M. Affan: Report, testing, submission coordination.
  - Dawood: UI finalization, Report Contributions.
  - Samiullah: Comprehensive testing.
  - Umar: UI finalizing contributions, Report contributions.
- **Status**: Completed.

## Timeline

| Sprint | Duration | Key Deliverables |
| --- | --- | --- |
| 1 | May 5–10, 2025 | Requirements Gathering, Project structure, Login Module |
| 2 | May 11–20, 2025 | Police Profile (view-only), FIR, Criminal Modules, Report Complaint, Police Dashboard, Admin Dashboard |
| 3 | May 21–28, 2025 | UI Design, Case Investigation, Analytics & Reporting, Manage Officers |
| 4 | May 29–June 3, 2025 | Final UI, Testing, Report, Submission |

## Notes

- **Repository**: `https://github.com/Afffan16/PoliceManagementSystem`
- **Branch**: Merged to `main` after completion of all sprints.
- **Tools**: Java, Swing, NetBeans GUI Builder, Maven, CSV storage.
- **Team Communication**: Daily standups via WhatsApp, GitHub Issues for task tracking.
- **Submission Deadline**: June 3, 2025.
- **Status**: Completed.