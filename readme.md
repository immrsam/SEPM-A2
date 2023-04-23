
# CINCO Ticketing System

IT Service Desk ticketing system for a small startup company called Cinco. The program allows the staff members of the company to login in to the system and submit an IT issue.

## Features
This application aims to have the following features:
1. Staff members can create accounts and use their login details to login and submit an IT issue ticket:
2. Submit an IT issue with description, severity of the issue (i.e., low, medium, high). The system also keeps track of the status of the issue (i.e., open / closed)
3. Depending on the severity of the issue, the appropriate IT service desk is allocated to the issue (Level 1 gets allocated low/medium severity issues and Level 2 gets high severity issues)
4. The system automatically assigns the IT technician with least amount of jobs with any new jobs
5. Technicians can change the severity of the issue once they have reviewed it. Once they have completed the job they can also close the job/mark it as unresolved, etc. 
6. Closed tickets are archived for upto 24hrs during which time the technician can view the ticket but cannot change the status of the ticket (i.e., from closed to open)

## Progress
1. Login feature implemented - Staff login and Technician Login
2. Data loaded directly from 2-D arrays rather than csv files
3. Staff menu options allows users to submit IT issue tickets and View existing tickets
4. Technician menu allows technician to view open ticket (if they exist) and closed ticket ONLY after a open ticket has been closed (exception handling on this is will be completed on next iteration)
5. Technicians can escalate tasks from LOW or MEDIUM to HIGH (i.e., level 1 technicians can moved the task to level 2)
6. Tehcnicians can close the task and mark then as resolved or unresolved
7. Technicians can view closed tasks (re-opening tasks and storing tasks for only 24 hrs will be implemented in next iteration)
8. Forgot password feature completed
9. Classes created - LoadData, Menu, StaffMember, Technician, Ticket, TicketSeverity, TicketStatus, User and CincoApp, StaffMenu, TechMenu
10. Creating user login will be implemented in next iteration along with exception handling for all possible error cases.

## Installation/Usage

### Software requirement
Download the Eclipse 2022-09 (version 4.25) from the following link: https://www.eclipse.org/downloads/packages/release/2022-09/r

### Getting Started
1. Create a new workspace folder in your documents folder for the project - name it appropriately (i.e. cinco_system or A2, etc.)
2. Extract the .zip folder into the workspace folder
3. Load Eclipse
4. Select the workspace folder created earlier in Eclipse
5. Click on Window menu then, click on Show View and select Project Explorer
6. Select `File` > `Import` > `General` > 'Existing Projects into workspace`
7. Navigate to the workspace folder created previously (e.g. H:\Documents\Workspace) then select the folder to Import
8. Select `Finish`
9. Select `Run` Tab and select `Run` or `CTRL + F11`

### In your console Window
1. When the application is running - The user can select one of the following:
    - System Owner Login
    - Staff Login
    - Technician Login
    - Forgot password
    - Quit
    
    ```
    ----------------------------------------------------
    CINCO TICKETING SYSTEM
    ----------------------------------------------------
    [0] System Owner Login
    [1] Staff Login
    [2] Technician Login
    [3] Forgot Password
    [4] Quit
    Enter your choice:
    ```
    Note: Invalid entries other than the numbers will give this warning
    
    ```
    Enter your choice: a
    Invalid input, please enter a number.    
    ```
    
2.  Once the user selects `[1] Staff Login` and enters the correct login credentials, the system displays staff main menu where the staff can submit new IT issue tickets or view their previously submitted tickets - The Client can use the following user credentials for testing purposes only: 
    - email: bill.smith@cinco.com
    - password: qwerty123
    
    ```
    ----------------------------------------------------
    STAFF LOGIN
    ----------------------------------------------------

    Enter email: bill.smith@cinco.com
    Enter password: qwerty123
    Found user: 2005
    Name: Bill Smith
    Phone: 61412345678
    Email: bill.smith@cinco.com

    ----------------------------------------------------
    STAFF MAIN MENU
    ----------------------------------------------------

    [1] Submit new IT issue
    [2] View my existing open IT issue(s)
    [3] Return to Main Menu
    Enter your choice:
    ```
    Note: Incorrect password will give this warning
    
    ```
    Enter email: bill.smith@cinco.com
    Enter password: billsmith1
    Incorrect password
    ```
3.  There are the options for Staff Main Menu:
    ```
    ----------------------------------------------------
    SUBMIT NEW I.T. ISSUE
    ----------------------------------------------------

    Enter IT issue description:
    For Demo Only
    ----------------------------------------------------
    SELECT I.T. ISSUE SEVERITY
    ----------------------------------------------------
    [1] Low
    [2] Medium
    [3] High
    Enter your choice: 1

    ----------------------------------------------------
    STAFF MAIN MENU
    ----------------------------------------------------

    [1] Submit new IT issue
    [2] View my existing open IT issue(s)
    [3] Return to Main Menu
    Enter your choice: 2

    ----------------------------------------------------
    VIEW MY EXISTING OPEN I.T. ISSUE(S)
    ----------------------------------------------------

    --------------------------
    TicketID: 1
    Ticket Description: For Demo Only
    Ticket Severity: LOW

    ----------------------------------------------------
    STAFF MAIN MENU
    ----------------------------------------------------

    [1] Submit new IT issue
    [2] View my existing open IT issue(s)
    [3] Return to Main Menu
    Enter your choice: 3
    ----------------------------------------------------
    CINCO TICKETING SYSTEM
    ----------------------------------------------------
    [0] System Owner Login
    [1] Staff Login
    [2] Technician Login
    [3] Forgot Password
    [4] Quit
    Enter your choice:
    ```

4. When the Technician login is selected - The client can use the following credentials for testing purposes only:
    - email: harry.styles@cinco.com (level 1)
    - password: harrystyles1
    - email: louis.tomlinson@cinco.com (level 2)
    - password: louistomlinson2
    
    ```
    ----------------------------------------------------
    TECHNICIAN LOGIN
    ----------------------------------------------------

    Enter email: harry.styles@cinco.com
    Enter password: harrystyles1
    Found user: 1000
    Name: Harry Styles
    Phone: 61412345678
    Email: harry.styles@cinco.com
    Level: 1
    Tasks: 1

    ----------------------------------------------------
    TECHNICIAN MAIN MENU
    ----------------------------------------------------

    1. View OPEN Tickets
    2. View CLOSED Tickets
    3. View ARCHIVED Tickets
    4. Return to Main Menu
    Enter your choice: 1

    ----------------------------------------------------
    OPEN TICKET(S) ASSIGNED TO YOU
    ----------------------------------------------------

    TicketID: 1
    UserID: 2004
    Ticket Description: For Demo Only
    Ticket Severity: LOW
    ++++++++++++++++++++++++++++++++++++++++++++++++++++

    ----------------------------------------------------
    PROCESS A TICKET OR RETURN TO PREVIOUS MENU
    ----------------------------------------------------

    1. Process a ticket
    2. Return to previous menu
    Enter a choice: 1
    Enter ticket ID to process: 1

    ----------------------------------------------------
    PROCESS THIS TICKET
    ----------------------------------------------------

    1. Mark as CLOSED - RESOLVED
    2. Mark as CLOSED - UNRESOLVED
    3. Escalate to Level 2
    Enter your choice: 3

    ----------------------------------------------------
    TECHNICIAN MAIN MENU
    ----------------------------------------------------

    1. View OPEN Tickets
    2. View CLOSED Tickets
    3. View ARCHIVED Tickets
    4. Return to Main Menu
    Enter your choice: 2

    ----------------------------------------------------
    CLOSED TICKET(S) THAT WERE ASSIGNED TO YOU
    ----------------------------------------------------


    ----------------------------------------------------
    PROCESS A TICKET OR RETURN TO PREVIOUS MENU
    ----------------------------------------------------

    1. Process a ticket
    2. Return to previous menu
    Enter a choice: 2

    ----------------------------------------------------
    TECHNICIAN MAIN MENU
    ----------------------------------------------------

    1. View OPEN Tickets
    2. View CLOSED Tickets
    3. View ARCHIVED Tickets
    4. Return to Main Menu
    Enter your choice: 1

    ----------------------------------------------------
    OPEN TICKET(S) ASSIGNED TO YOU
    ----------------------------------------------------


    ----------------------------------------------------
    PROCESS A TICKET OR RETURN TO PREVIOUS MENU
    ----------------------------------------------------

    1. Process a ticket
    2. Return to previous menu
    Enter a choice: 2
    ```
    As Harry Styles (Level 1 Technician) escalated this issue to level 2: Louis Tomlinson (Level 2 Technician will be assigned this task)
    ```
    ----------------------------------------------------
    TECHNICIAN LOGIN
    ----------------------------------------------------

    Enter email: louis.tomlinson@cinco.com
    Enter password: louistomlinson2
    Found user: 1003
    Name: Louis Tomlinson
    Phone: 61412345678
    Email: louis.tomlinson@cinco.com
    Level: 2
    Tasks: 1

    ----------------------------------------------------
    TECHNICIAN MAIN MENU
    ----------------------------------------------------

    1. View OPEN Tickets
    2. View CLOSED Tickets
    3. View ARCHIVED Tickets
    4. Return to Main Menu
    Enter your choice: 1

    ----------------------------------------------------
    OPEN TICKET(S) ASSIGNED TO YOU
    ----------------------------------------------------

    TicketID: 1
    UserID: 2004
    Ticket Description: For Demo Only
    Ticket Severity: HIGH
    ++++++++++++++++++++++++++++++++++++++++++++++++++++

    ----------------------------------------------------
    PROCESS A TICKET OR RETURN TO PREVIOUS MENU
    ----------------------------------------------------

    1. Process a ticket
    2. Return to previous menu
    Enter a choice: 1
    Enter ticket ID to process: 1

    ----------------------------------------------------
    PROCESS THIS TICKET
    ----------------------------------------------------

    1. Mark as CLOSED - RESOLVED
    2. Mark as CLOSED - UNRESOLVED
    Enter your choice: 1

    ----------------------------------------------------
    TECHNICIAN MAIN MENU
    ----------------------------------------------------

    1. View OPEN Tickets
    2. View CLOSED Tickets
    3. View ARCHIVED Tickets
    4. Return to Main Menu
    Enter your choice: 2

    ----------------------------------------------------
    CLOSED TICKET(S) THAT WERE ASSIGNED TO YOU
    ----------------------------------------------------

    TicketID: 1
    UserID: 2004
    Ticket Description: For Demo Only
    Ticket Severity: HIGH
    Ticket Status: CLOSE_RESOLVED
    ++++++++++++++++++++++++++++++++++++++++++++++++++++

    ----------------------------------------------------
    PROCESS A TICKET OR RETURN TO PREVIOUS MENU
    ----------------------------------------------------

    1. Process a ticket
    2. Return to previous menu
    Enter a choice: 1
    Enter ticket ID to process: 1
    TicketID: 1
    UserID: 2004
    Ticket Description: For Demo Only
    Ticket Severity: HIGH
    Ticket Status: CLOSE_RESOLVED

    ----------------------------------------------------
    PROCESS THIS CLOSED TICKET
    ----------------------------------------------------

    1. Mark as OPEN
    Enter your choice: 1

    ----------------------------------------------------
    TECHNICIAN MAIN MENU
    ----------------------------------------------------

    1. View OPEN Tickets
    2. View CLOSED Tickets
    3. View ARCHIVED Tickets
    4. Return to Main Menu
    Enter your choice: 1

    ----------------------------------------------------
    OPEN TICKET(S) ASSIGNED TO YOU
    ----------------------------------------------------

    TicketID: 1
    UserID: 2004
    Ticket Description: For Demo Only
    Ticket Severity: HIGH
    ++++++++++++++++++++++++++++++++++++++++++++++++++++
    ```
5. If the user selects `Forgot Password` - The Client can use this feature to reset the password:

    ```
    ----------------------------------------------------
    FORGOT PASSWORD MENU
    ----------------------------------------------------

    Enter email: bill.smith@cinco.com
    Enter new password: qwerty1234 
    --Password Updated--
    ```
6. System owner can view reports - The client can use the following credentials for testing purposes only:
    - email: system@cinco.com
    - password: admin1
    ```
    ----------------------------------------------------
    SYSTEM OWNER LOGIN
    ----------------------------------------------------

    Enter email: system@cinco.com
    Enter password: admin1
    Found user: 9001
    Name: System Owner
    Phone: 61440000000
    Email: system@cinco.com

    ----------------------------------------------------
    SYSTEM OWNER MAIN MENU
    ----------------------------------------------------

    1. Create Reports
    2. Return to Main Menu
    Enter your choice: 1

    ----------------------------------------------------
    CREATE REPORTS MENU
    ----------------------------------------------------

    View reports for the last x numbers of days (e.g. 1 day or 7 days)    
    Enter numbers of days: 1
    ----------------------------------------------------
    SYSTEM SUMMARY REPORT FOR 1 DAYS
    ----------------------------------------------------
    Total tickets: 1
    Total open tickets: 0
    Total closed resolved tickets: 1
    Total closed unresolved tickets: 0
    Total archived tickets: 0
    ----------------------------------------------------
    OPEN TICKETS REPORT FOR 1 DAYS
    ----------------------------------------------------
    ----------------------------------------------------
    CLOSED RESOLVED TICKETS REPORT FOR 1 DAYS
    ----------------------------------------------------
    Created Time: Sun Apr 23 15:08:18 AEST 2023
    StaffID: 2004
    Ticket Severity: HIGH
    Processed by: 1003
    Attended to within: 0 hrs
    ++++++++++++++++++++++++++++++++++++++++++++++++++++
    ----------------------------------------------------
    CLOSED UNRESOLVED TICKETS REPORT FOR 1 DAYS
    ----------------------------------------------------
    ----------------------------------------------------
    ARCHIVED TICKETS REPORT FOR 1 DAYS
    ----------------------------------------------------

    ----------------------------------------------------
    ```
## Contributors
1. Samuel Bradbury 
    - Assigment 2 Sprint 1 Scrum leader initial stand up meeting
    - Created java project
    - Designed UML diagram for program planning
    - Contributed to the product backlog
    - Sprint Retrospective Notes
2. Mohamed Ali
    -  Assigment 2 Sprint 3 Scrum leader
    -  Contributed to the product backlog
    -  Reviewed java program
    -  Sprint 3 Review notes
    -  Sprint Planning Notes
3. Vignesh Menon
    - Assignmen 2 Sprint 2 Scrum leader
    - Contributed to the java project Sprint 2 + 3
    - Added the Sprint 3 System Owner Features
    - Contributed to product backlog
    - Readme.txt
4. Idris Anwar
    - Assigment 2 Sprint 3 Scrum leader
    - Contributed to the product backlog
    - Reviewed Java program
    - Sprint 3 Retrospective Notes


