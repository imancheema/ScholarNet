## ScholarNet: Scholarship Management System

The scholarship search process can be a challenging and time consuming experience for many students, especially when they have to navigate multiple websites 
to find the scholarships that fit their needs and eligibility requirements.

ScholarNet is a **microservice-based** web application that offers a centralized platform for students to find and apply to scholarships posted by numerous organizations.

# ER Diagram
The ER diagram consists of entities including Account, Scholarship, Application, and User. Among these, the User entity is a superclass that is further divided into two subclasses,
Applicant and Organization. The disjoint relationship between these subclasses shows that the user can be either the applicant or organization, but not both at the same time. 
Based off this diagram, SQL tables were created.

![image](https://github.com/user-attachments/assets/e6d727aa-144f-4fc1-980c-cb7d6375e58b)

# Microservices
1. Frontend Microservice: responsible for providing graphical user interface (GUI) and sends user interactions to the backend microservices for processing, as
well as receives data from other microservices and displays it to the user. Further, it checks the
login and applies authentication mechanisms.
