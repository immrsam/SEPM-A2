
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
1. Login feature implemented
2. Technician data loaded to .csv file and the program uses ImportData class to import the hardcoded technician information during login attempts
3. Forgot password feature added
4. Classes created - ImportData, Menu, StaffMember, Technician, Ticket, TicketSeverity, TicketStatus, User and MyApp

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
    1. Login
    2. Forgot Password
    3. Quit
    Enter your choice:
    ```

2.  Once the user selects `Login` [1] - The Client can use the following user credentials for testing purposes only: 
    - email: b.smith@cinco.com
    - password: qwerty123
    
    ```
    -----------
    User Login 
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

## Contributors
1. Samuel Bradbury 
    - Scrum leader initial stand up meeting/Created java project/Designed UML diagram for program planning/Contributed to the product backlog
2. Mohamed Ali
    - Contributed to the product backlog/Reviewed java program 
3. Vignesh Menon
    - Contributed to the ReadMe.txt/Reviewed java program 
4. Idris Anwar
    - Reviewed Java program


