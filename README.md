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
  - Persistence Layer: Has the “Apply_CRUD” class to connect to the database and handle application storage.
- **Register Microservice**: Handles user registration for website access by validating user information and creating a new account in the database. It has a REGISTER_SMS database with a
REGISTER_USER table.
   - The Business layer contains the “RegisterBusiness” class and is responsible for the business
logic of the registration functionalities, like receiving and adding users to the system. The
endpoint layer includes the “ApplicationConfig” and “RegisterResource” classes and manages
the REST API. The Helper layer consists of a “UserRegistration” class which defines a
constructor (with parameters like email, username, first name) and getter methods to retrieve
values, which other layers can then use. The persistence layer has the “Register_CRUD”
establishes a connection to the database (REGISTER_SMS), receives information from the user,
and inserts a new row into the database.





