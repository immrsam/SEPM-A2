
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
3. Forgot password feature completed
4. Classes created - LoadData, Menu, StaffMember, Technician, Ticket, TicketSeverity, TicketStatus, User and CincoApp, StaffMenu, TechMenu

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
    - Login
    - Forgot Password
    - Quit
    
    ```
    ----------------------
    CINCO TICKETING SYSTEM
    ----------------------
    1. Staff Login
    2. Technician Login
    3. Forgot Password
    4. Quit
    Enter your choice: 
    ```

2.  Once the user selects `Staff Login` [1] - The Client can use the following user credentials for testing purposes only: 
    - email: b.smith@cinco.com
    - password: qwerty123
    
    ```
    -----------
    Staff Login 
    -----------

    Enter email: b.smith@cinco.com
    Enter password: qwerty123
    Found user: 5645
    Name: Bill Smith
    Phone: 044498765456
    Email: b.smith@cinco.com
    ```

3. If the user selects `Forgot Password` - The Client can use this feature to reset the password:

    ```
    Enter your choice: 2
    --------------
    Forgot Password selected
    --------------
    Enter email: b.smith@cinco.com
    Enter new password: qwerty1234
    --Password Updated--
    ```
4. Once the staff has logged in - They are presented with the following options:
    
    ```
    ----------
    MAIN MENU
    ----------
    1. Submit new IT issue
    2. View existing IT issue(s)
    3. Return to Main Menu
    Enter your choice: 1
    --------------------
    Submit new IT issue 
    --------------------

    Enter IT issue description: ForDemo
    Select Severity:
    1. Low
    2. Medium
    3. High
    Enter your choice: 2
    ----------
    MAIN MENU
    ----------
    1. Submit new IT issue
    2. View existing IT issue(s)
    3. Return to Main Menu
    Enter your choice: 2

    --------------------------
    View existing IT issue(s) 
    --------------------------

    ----------------------------------------
    TicketID: 1
    Ticket Description: ForDemo
    Ticket Severity: MEDIUM
    ----------
    MAIN MENU
    ----------
    1. Submit new IT issue
    2. View existing IT issue(s)
    3. Return to Main Menu
    Enter your choice: 
    ```
5. When the Technician login is selected - The client can use the following credentials for testing purposes only:
    - email: zayn.malik@cinco.com
    - password: zaynmalik2
    
    ```
    -----------------
    Technician Login 
    -----------------

    Enter email: zayn.malik@cinco.com
    Enter password: zaynmalik2
    Found user: 1004
    Name: Zayn Malik
    Phone: 61412345678
    Email: zayn.malik@cinco.com
    Level: 2
    Tasks: 0
    ----------
    MAIN MENU
    ----------
    1. View OPEN Tickets
    2. View CLOSED Tickets
    3. Return to Main Menu
    Enter your choice: 1
    NO TICKETS CURRENTLY
    ----------
    MAIN MENU
    ----------
    1. View OPEN Tickets
    2. View CLOSED Tickets
    3. Return to Main Menu
    Enter your choice: 2
    NO TICKETS CURRENTLY
    ----------
    MAIN MENU
    ----------
    1. View OPEN Tickets
    2. View CLOSED Tickets
    3. Return to Main Menu
    Enter your choice: 3
    ----------------------
    CINCO TICKETING SYSTEM
    ----------------------
    1. Staff Login
    2. Technician Login
    3. Forgot Password
    4. Quit
    Enter your choice: 4
    Quitting...
    ```
    
## Contributors
1. Samuel Bradbury 
    - Assigment 2 Sprint 1 Scrum leader initial stand up meeting/Created java project/Designed UML diagram for program planning/Contributed to the product backlog
2. Mohamed Ali
    - Contributed to the product backlog/Reviewed java program 
3. Vignesh Menon
    - Assignmen 2 Sprint 2 Scrum leader/Contributed to the java project/Contributed to product backlog
4. Idris Anwar
    - Contributed to the product backlog/Reviewed Java program


