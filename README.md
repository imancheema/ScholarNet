# ScholarNet: Scholarship Management System

The scholarship search process can be a challenging and time consuming experience for many students, especially when they have to navigate multiple websites 
to find the scholarships that fit their needs and eligibility requirements.

ScholarNet is a **microservice-based** web application that offers a centralized platform for students to find and apply to scholarships posted by numerous organizations.

## ER Diagram
The ER diagram consists of entities including Account, Scholarship, Application, and User. Among these, the User entity is a superclass that is further divided into two subclasses,
Applicant and Organization. The disjoint relationship between these subclasses shows that the user can be either the applicant or organization, but not both at the same time. 
Based off this diagram, SQL tables were created.

![image](https://github.com/user-attachments/assets/e6d727aa-144f-4fc1-980c-cb7d6375e58b)

## Microservices
- **Frontend Microservice**: Provides the Graphical User Interface (GUI) for user interactions, communicates with backend services, displays data, and manages login and authentication.
- **Apply Scholarships Microservice**: Manages the scholarship application process by collecting user information and storing it in the APPLY_SMS database's SCHOLARSHIP_APPLY table. It consists of.
  - Business Layer: Contains the ‘ApplyBusiness’ class, which implements the application process logic.
  - Endpoint Layer: Includes ApplicationConfig and ApplyResource classes to manage the REST API.
  - Helper Layer: Contains the ScholarshipApply class for reusable functions.
  - Persistence Layer: Has the 'Apply_CRUD' class to connect to the database and handle application storage.
- **Register Microservice**: Handles user registration for website access by validating information and creating new accounts in the REGISTER_SMS database's REGISTER_USER table. It includes:
   - Business Layer: Contains the 'RegisterBusiness' class for registration logic.
   - Endpoint Layer: Features ApplicationConfig and RegisterResource classes for the REST API.
   - Helper Layer: Contains the UserRegistration class for user data management, defining a constructor with parameters like email, username, and first name, along with getter methods for value retrieval by other layers.
   - Persistence Layer: Features the Register_CRUD class to connect to the database and insert user data.





