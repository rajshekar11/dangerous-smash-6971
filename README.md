# Spring Boot REST API for an Online Trip Management System

## Description

- This REST API was created for an online trip management system. This API handles all of the basic CRUD functions of any Trip Management Application platform, including user validation at each stage.
- During project week at Masai School, a team of 5 Back-End Developers worked on this project.

## Contributors

- [@Rajashekar A.E](https://github.com/rajshekar11)
- [@Shashwat Srivastava](https://github.com/JavaDevShashwat)
- [@Rishabh Srivastava](https://github.com/rish2408)
- [@Yethu Nanthan](https://github.com/yedhunanthan)
- [@Niraj Kendre](https://github.com/NirajKendre)

## Tech Stack

- Core Java
- MySQL
- Spring Framework
- Spring Boot
- Spring Data JPA with Hibernate
- Rest Controller
- PostMan
- Swagger
- Lombok

## Modules

# Admin

- Login into the Application
- User Management
- Tours/Travels Package Management
- Route and Bus Management
- Ticket and Hotel Booking Management
- View Reports

# Customer

- Login as Customer
- View Routes
- View Tours/Travels Packages
- Book / Print / Cancel Tickets
- Payment
- Provide/View Testimonials

## Features

- Authentication and validation of users and administrators using session uuids.
- Admin Features:
  - The application's administrator role
  - Only logged-in admin with active session tokens can add, alter, or delete customers, hotels, routes, or packages from the main database.
  - The admin has access to information on various routes, buses, packages, ticket data, customer feedback, reports, etc.
- Customer Features:
  - On the platform, a customer can sign up for themselves.
  - Customer can check the availability of hotels and travel packages.
  - After making a reservation, customer will receive booking information for the whole Package. This information will include all pertinent information, such as ticket information and pricing.
  - The consumer has the option to cancel their booking.



## Database Installation

- You should update the database configuration in the [application.properties] file before starting the API server.
- According to your local database configuration, update the port number, username, and password.

```
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/dbname;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=dbusername
    spring.datasource.password=dbpassword

```

## API Root Endpoint

`https://localhost:8080/`

`http://localhost:8080/swagger-ui/`

## API Module Endpoints

### Login Module

- `POST //api/userlogin` : User can login with mobile number and password provided at the time of registation
<!--

### Sample API Response for Admin Login

`POST localhost:8080/login/userlogin`

- Request Body

```
    {
        "mobileNo": "9918235456",
        "password": "rishabh@123"
    }
```

- Response

```
   CurrentAdminSession(id=11, userId=1, uuid=356152, localDateTime=2022-11-13T12:18:35.886153526)

```

## Video Explainer of flow control

<a href="#">**Video Drive Link** </a>

### Swagger UI

---

![image](https://user-images.githubusercontent.com/36689521/201520958-c09b9284-32f0-4a4d-bd82-1073330a234b.png)

---

### Login Controller

---

![image](https://user-images.githubusercontent.com/36689521/201521005-f077cf00-1986-466f-b45a-2150a755f88a.png)

---

### Admin Controller

---

![image](https://user-images.githubusercontent.com/36689521/201521028-2ae4d136-e705-4708-9fd2-ee9717ed69da.png)

---

### Booking and Bus Controller

---

![image](https://user-images.githubusercontent.com/36689521/201521096-bfef2c75-6e4b-4195-8f58-ddcecc9cca4d.png)

---

### Feedback and Hotel Controller

---

![image](https://user-images.githubusercontent.com/36689521/201521123-51f504ac-777e-4ca0-8ea7-fe88b26e65fd.png)

### Package, Report and Travel Controller

---

![image](https://user-images.githubusercontent.com/36689521/201521157-a6b2ff36-13aa-47bc-8f2f-7caea3405620.png)

---

---

![image](https://user-images.githubusercontent.com/36689521/201521235-e0721049-dc24-4260-a824-c439b9fea9fc.png)

---
