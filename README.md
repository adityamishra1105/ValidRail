# ValidRail – Admin & User Validation System (Java CLI)

ValidRail is a **Java-based command-line application** that simulates a secure user validation and registration system for a railway portal.  It includes admin login, credential updates, full input validation, and file-based data persistence.

---

## Problem Statement

Railway systems require secure and structured user data entry. This project simulates an **admin-managed registration system** where:
- Admin credentials are validated and updatable
- User inputs are rigorously validated (name, email, DOB, etc.)
- Validated data is saved in a persistent file (`users.txt`)

---

## Features

- Admin Login via `.properties` file  
- Create New Admin users from the CLI  
- Full User Registration Form with Validation  
- Retry on invalid input  
- Stores data in `users.txt`  
- Menu-driven navigation  
- Modular & clean Java code

---

## Tech Stack

- Java (Core, CLI)
- File I/O (`BufferedWriter`, `Properties`)
- Regex (for email, phone validation)
- Scanner for user input

---

## Folder Structure
<pre>
ValidRail/
├── src/
│ └── AssignmentProgram.java
├── resources/
│ ├── userLogin.properties
│ └── users.txt
├── .gitignore
├── README.md
└── LICENSE
</pre>pre>


---

## How to Run

1. **Clone this repo**
   ```bash
   git clone https://github.com/adityamishra1105/ValidRail-CLI.git
   cd ValidRail-CLI

2. Ensure Java is installed (JDK 8 or above)

3. cd src
javac AssignmentProgram.java
java AssignmentProgram




## Admin Credentials
Default credentials stored in resources/userLogin.properties

properties
Copy
Edit
adminUserId=admin
adminPassword=admin123
You can change or reset using the "Create New Admin" menu option.


## Future Enhancements
1. Switch from File to PostgreSQL DB using JDBC
2. DAO design pattern
3. Add booking/ticketing modules
4. GUI using JavaFX or Web-based frontend
5. Encrypted password handling

## By 
Aditya Mishra. 
Happy Coding </>.
