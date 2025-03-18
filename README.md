# MyAwesomeJobPortal

![Java](https://img.shields.io/badge/Java-23-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7.9-green.svg)
![MySQL](https://img.shields.io/badge/Database-MySQL-blue.svg)
![React](https://img.shields.io/badge/Frontend-React-blue.svg)

## 📝 Project Description
MyAwesomeJobPortal is a full-stack job portal designed to connect job seekers with employers. It enables users to browse job listings, apply for jobs, and manage applications efficiently. Employers can post jobs, review applications, and manage hiring processes seamlessly.

## 🚀 Tech Stack
### Backend
- **Java 23**
- **Spring Boot 2.7.9**
- **Spring Security** (for authentication & authorization)
- **Spring Data JPA** (for database interactions)
- **MySQL 8.0.41** (Database)
- **Hibernate ORM**
- **HikariCP** (Connection pooling)

### Frontend
- **React.js** (for UI)
- **Bootstrap / TailwindCSS** (for styling)
- **Axios** (for API requests)

### DevOps / Tools
- **IntelliJ IDEA 2024.3.4.1**
- **Maven 3.9.9** (for dependency management)
- **Git & GitHub** (for version control)
- **Postman** (for API testing)

## 🔥 Features
### ✅ User Features
- Sign up & login (JWT authentication)
- Browse job listings
- Apply for jobs
- Track application status

### ✅ Employer Features
- Post job listings
- Review applications
- Approve or reject candidates

### ✅ Admin Features
- Manage users and employers
- Approve or reject job postings

## 📂 Project Structure
```
myawesomejobportal/
├── backend/
│   ├── src/main/java/com/example/myawesomejobportal/
│   │   ├── controllers/
│   │   ├── entities/
│   │   ├── repositories/
│   │   ├── services/
│   │   ├── security/
│   │   ├── MyAwesomeJobPortalApplication.java
│   ├── src/main/resources/
│   │   ├── application.properties
│   ├── pom.xml
│
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   ├── pages/
│   │   ├── services/
│   ├── package.json
│   ├── public/
│   ├── index.html
│
├── README.md
```

## 🔧 Setup Instructions
### Backend Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/myawesomejobportal.git
   cd myawesomejobportal/backend
   ```
2. Configure the database connection in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/job_portal
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```
3. Build and run the application:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

### Frontend Setup
1. Navigate to the frontend directory:
   ```bash
   cd ../frontend
   ```
2. Install dependencies:
   ```bash
   npm install
   ```
3. Start the React development server:
   ```bash
   npm start
   ```

## 🔗 API Endpoints
| Method | Endpoint | Description |
|--------|---------|-------------|
| POST | `/api/auth/register` | Register a new user |
| POST | `/api/auth/login` | Login and get JWT token |
| GET | `/api/jobs` | Get all job listings |
| POST | `/api/jobs` | Post a new job (Employer only) |
| POST | `/api/applications` | Apply for a job |
| GET | `/api/applications/user/{id}` | Get applications by user |

## 🛠️ Troubleshooting
- **Database Connection Issue**: Ensure MySQL is running and credentials are correct.
- **Port Conflict**: Change the backend port in `application.properties` (`server.port=8081`).
- **Frontend API Connection Error**: Update `proxy` in `package.json` to match backend URL.

## 📜 License
This project is licensed under the MIT License.

## 💡 Future Enhancements
- Implement job recommendations using **AI/ML**
- Add **email notifications** for job updates
- Enable **OAuth2 authentication**

## 🙌 Contributing
Pull requests are welcome! Fork the repo, create a new branch, and submit a PR.

---
**Developed by Ike Mathebula** 🎯

