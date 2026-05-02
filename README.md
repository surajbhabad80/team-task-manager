 Team Task Manager (Full Stack Project)

1) About Project
This project is a simple Team Task Manager application.  
In this system, users can create projects, assign tasks to team members, and track task progress.

There are two roles:
- Admin → can create projects and tasks
- Member → can view and update task status

---

2) Features
- User Signup and Login
- Role-based access (Admin / Member)
- Create and manage projects
- Create and assign tasks
- Update task status (TODO → IN_PROGRESS → COMPLETED)
- Dashboard to see total tasks, completed tasks, and overdue tasks
- REST APIs for backend testing
- Database integration using MySQL
- Deployed on Railway

---

3) Tech Used
- Java & Spring Boot
- Spring Security
- Spring Data JPA (Hibernate)
- MySQL Database
- Thymeleaf 
- REST APIs
- Railway (Deployment)

---

4) Live Project
https://team-task-manager-production-de89.up.railway.app/login
---

5) GitHub Repo
https://github.com/surajbhabad80/team-task-manager
---

# How to Run Project Locally
1. Clone this repository
2. Create MySQL database named `team_task_manager`
3. Update database username and password in `application.properties`
4. Run the Spring Boot application
5. Open browser and go to `http://localhost:8080`

---

6) API Testing (Postman)
- GET /api/projects → get all projects
- POST /api/projects → create project
- GET /api/tasks → get all tasks
- POST /api/tasks → create task
- PUT /api/tasks/{id}/status/{status} → update task status

---

