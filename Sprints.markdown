# Police Management System Sprint Plan

## Overview

The **Police Management System** project is divided into four sprints from May 5 to June 4, 2025, to meet the final submission deadline of June 4, 2025. Each sprint focuses on module development, UI design, testing, and documentation to deliver a comprehensive police operations system.

## Sprint 1: Requirements, Project Structure and Login Module ✅

- **Duration**: May 5–10, 2025 (Completed)
- **Goals**:
  - Set up Maven project structure (`src/main/java/police/gui`, `police/model`, `resources`).
  - Implement Login Module for secure authentication.
- **Deliverables**:
  - `LoginForm.java`: Username/password validation, role-based access.
  - `pom.xml`: Maven dependencies.
  - CSV files: `firs.csv`, `complaints.csv`.
- **Team**:
  - M. Affan: Project setup, coordination.
  - Dawood: Login module implementation.
- **Status**: Completed.

## Sprint 2: Police Profile, FIR, and Criminal Modules

- **Duration**: May 11–17, 2025 (Due Saturday)
- **Goals**:
  - Complete Police Profile Module for officer management.
  - Finalize FIR Module (complaint-to-FIR flow, search, view).
  - Implement Criminal Module for record tracking.
- **Deliverables**:
  - `PoliceProfileForm.java`: Officer CRUD operations.
  - `FIRManagementForm.java`, `ViewSearchFIRForm.java`, `CheckComplaintsForm.java`, `AddUpdateFIRForm.java`: FIR functionality (✅ Completed May 15, 2025).
  - `CriminalForm.java`: Criminal record management.
  - Two fields (e.g., `address`) added to relevant forms.
- **Team**:
  - M. Affan: FIR module, Sprint coordination.
  - Dawood: Police Profile Module, Police Dashboard.
  - Umar: Criminal Module.
  - Samiullah: Complaint Registration, FIR Module, Testing
- **Status**: In progress (FIR module completed, police profile and criminal modules due May 17, 2025).
- **Risks**:
  - Tight deadline for criminal module.
  - **Mitigation**: Parallel development by Umar and Samiullah, daily check-ins.

## Sprint 3: UI Design and New Modules

- **Duration**: May 18–24, 2025 (7 days)
- **Goals**:
  - Enhance UI for login, police profile, FIR, and criminal modules (light gray theme, Arial, 20px padding).
  - Implement Case Investigation Module (case tracking, evidence).
  - Develop Analytics and Reporting Module (crime stats, reports).
  - Build Court and Judges Module (schedules, records).
- **Deliverables**:
  - Updated UI: `LoginForm.java`, `PoliceProfileForm.java`, `FIRManagementForm.java`, `ViewSearchFIRForm.java`, `CriminalForm.java`.
  - `CaseInvestigationForm.java`: Case assignment, evidence tracking.
  - `AnalyticsReportForm.java`: Crime trend charts, CSV report exports.
  - `CourtJudgesForm.java`: Court schedules, judge assignments.
- **Team**:
  - M. Affan: Case Investigation, coordination.
  - Samiullah: Analytics and Reporting, testing.
  - Umar: Court and Judges.
  - Dawood: UI design for existing modules.
- **Status**: Planned.
- **Risks**:
  - Multiple modules in one sprint.
  - **Mitigation**: Prioritize Case Investigation, start testing in parallel via Samiullah.

## Sprint 4: Final Design, Testing, and Submission

- **Duration**: May 25–June 4, 2025 (10 days)
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
  - Dawood: UI finalization, Report Contributions
  - Samiullah: Comprehensive testing.
  - Umar: UI finalizing contributions, Report contributions.
- **Status**: Planned.
- **Risks**:
  - Submission deadline pressure.
  - **Mitigation**: Draft report in Sprint 3, allocate testing across team.

## Timeline

| Sprint | Duration | Key Deliverables |
| --- | --- | --- |
| 1 | May 5–10, 2025 | Requirements Gathering, Project structure, Login Module |
| 2 | May 11–17, 2025 | Police Profile, FIR, Criminal Modules, Report Complaint, Police Dashboard |
| 3 | May 18–24, 2025 | UI Design, Case Investigation, Analytics & Reporting, Court & Legalities |
| 4 | May 25–June 4, 2025 | Final UI, Testing, Report, Submission |

## Notes

- **Repository**: `https://github.com/Afffan16/PoliceManagementSystem`
- **Branch**: `fir-module-dev` for Sprint 2, merge to `main` for Sprint 3.
- **Tools**: Java, Swing, NetBeans GUI Builder, Maven, CSV storage.
- **Team Communication**: Daily standups via WhatsApp, GitHub Issues for task tracking.
- **Submission Deadline**: June 4, 2025.