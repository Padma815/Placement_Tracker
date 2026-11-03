# 🎯 Placement Preparation Tracker

A beginner-friendly full-stack Java web application built with **Spring Boot**, **Maven**, **MySQL**, and **HTML/CSS/JavaScript**.

---

## 📁 Project Architecture & Folder Breakdown

```text
Placement_Tracker/
├── pom.xml                                      # Maven configuration & dependencies
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/placement/tracker/
│   │   │       ├── PlacementTrackerApplication.java  # Application entry point
│   │   │       ├── controller/                       # Handles HTTP requests (REST API)
│   │   │       ├── model/                            # Database Entity classes (Tables)
│   │   │       ├── repository/                       # Database queries (Spring Data JPA)
│   │   │       └── service/                          # Business logic & validation
│   │   └── resources/
│   │       ├── application.properties                # Database & server configuration
│   │       └── static/                               # Frontend user interface
│   │           ├── css/
│   │           │   └── style.css                     # Custom styles
│   │           ├── js/
│   │           │   └── app.js                        # Client-side API calls & interactivity
│   │           └── index.html                        # Main web page
│   └── test/
│       └── java/
│           └── com/placement/tracker/
│               └── PlacementTrackerApplicationTests.java # Context loading test
└── README.md                                    # Documentation & setup guide
```

---

## 🛠️ Technology Stack

| Layer | Technology | Role |
|---|---|---|
| **Backend** | Java 17+, Spring Boot 3 | Application framework and REST API |
| **Database** | MySQL | Persistent relational database |
| **ORM / Data Access** | Spring Data JPA (Hibernate) | Maps Java objects to MySQL tables without raw SQL |
| **Build Tool** | Apache Maven | Manages libraries and builds the project |
| **Frontend** | HTML5, CSS3, JavaScript (Fetch API) | Lightweight, responsive user interface |

---

## 🚀 How to Run the Application

1. **MySQL Setup**:
   - Ensure MySQL Server is running on your machine.
   - Update your MySQL credentials in `src/main/resources/application.properties`:
     ```properties
     spring.datasource.username=YOUR_MYSQL_USERNAME
     spring.datasource.password=YOUR_MYSQL_PASSWORD
     ```
   - The database `placement_tracker_db` will be created automatically on the first run.

2. **Run via IDE (Recommended for Beginners)**:
   - Open this folder in **IntelliJ IDEA**, **Eclipse / STS**, or **VS Code**.
   - Navigate to `src/main/java/com/placement/tracker/PlacementTrackerApplication.java`.
   - Right-click and choose **Run 'PlacementTrackerApplication'**.

3. **Access the App**:
   - Open your browser and visit: `http://localhost:8080`
