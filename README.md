# HRMS-System-Using-JWT-Token
The HRMS (Human Resource Management System) described here is a modern and highly efficient software application designed to streamline HR-related tasks and processes.It's built using a microservices architecture, making it modular and flexible. Here's a basic description of the key components and functionalities:

Microservices Architecture: The HRMS is composed of multiple small, specialized services that work together cohesively. This architecture allows for easy scalability and maintenance.

Eureka Discovery Client and Server: Eureka is used to manage service discovery. Microservices can register themselves with Eureka, making it easier for them to find and communicate with each other dynamically.

Spring Security with JWT Authentication: Security is a top priority in this system. Spring Security, combined with JWT authentication, ensures that only authorized users and services can access the HRMS. JWTs provide secure and stateless authentication.

IAM (Identity and Access Management) Service: This service is responsible for user management, including registration, login, and role management. It generates and verifies JWT tokens to control access.

Employee Service: This service handles employee-related data, such as employee profiles, contact information, and work history. It enables HR staff to manage employee records efficiently.

HR Service: The HR service is dedicated to HR-specific operations, such as leave requests, attendance tracking, and performance evaluations. It simplifies HR process management.

Message Service: This service facilitates communication within the HRMS by sending notifications, alerts, and messages to employees and HR staff. It enhances communication related to HR activities.

Service Registry: The service registry maintains a catalog of all registered microservices and their network locations. This simplifies service discovery and communication.

API Gateway: The API gateway acts as a unified entry point for external clients, managing requests and responses to and from the microservices. It also provides additional security and load balancing capabilities.

Communication via Eureka and RestTemplate: Communication between microservices relies on Eureka for service discovery and RestTemplate for making HTTP requests. This ensures seamless interaction between components.

Overall, this HRMS is a comprehensive solution for HR departments, offering secure data management, discoverability of services, and efficient communication. The microservices architecture enhances scalability and maintainability, making it a valuable tool for managing a workforce effectively.
