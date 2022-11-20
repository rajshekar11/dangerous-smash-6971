### Online Trip Management System REST API

- This REST API was created by us for an Online Trip Management System. This API handles all of the basic CRUD functions of any Trip Management Application platform, including user validation at each stage.
- During project week at Masai School, a group of 5 back-end developers worked on this project.

## Contributors

- [@Rishabh Srivastava](https://github.com/rish2408)
- [@Shashwat Srivastava](https://github.com/JavaDevShashwat)
- [@Rajashekar A.E](https://github.com/rajshekar11)
- [@Yethu Nanthan s](https://github.com/yedhunanthan)
- [@Niraj Kendre](https://github.com/NirajKendre)

## Tech Stack

- Core Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- PostMan
- Swagger
- Lombok

## User Module

# User should  be able to perform below operations:  

- Login as Customer
- View Routes 
- View  Tours/Travels  Packages
- Book / Print / Cancel  Tickets
- Payment  
- Provide/View Testimonials 

## Admin Module

# Admin should be able to perform below operations:

- Login into the Application
- User Management
- Tours/Travels Package Management
- Route and Bus Management
- Ticket  and Hotel Booking Management
- View Reports 

### Features

## Authentication and validation for customer and admin using the session uuid.

# Admin Features :

  - Role of the entire application's administrator.
  - Only logged-in admin with active session tokens can add, update, or delete customers, hotels, routes, or packages from the main database.
  - The admin has access to information on various routes, buses, packages, ticket data, customer feedback, reports, etc.

# Customer Features :

  - On the platform, a customer can register him.
  - Customer can check the availability of hotels and travel packages.
  - After booking a hotel, he will receive booking information for the whole Package. This information will include all important information, such as ticket information and pricing.
  - The customer has the option to cancel the booking.

## Installation & Run

- You need update the database configuration in the [application.properties](https://github.com/rajshekar11/dangerous-smash-6971/blob/main/TripMaker/src/main/resources/application.properties) file before launching the API server.
- Change the port number, username, and password to match your local database configuration.

```
    server.port=8880

    spring.datasource.url=jdbc:mysql://localhost:3306/tripmaker;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=dbusername
    spring.datasource.password=dbpassword

```

## API Root Endpoint

`http://localhost:8880/swagger-ui/`

## API Module Endpoints

### Login Module

- `POST //api/userlogin` : Customer can login with mobile number and password provided at the time of registation

### Sample API Response for Customer Login

`POST localhost:8080/login/userlogin`

- Request Body

```
    {
        "mobileNo": "9425152246",
        "password": "rishabh@1111"
    }
```

- Response

```
   CurrentCustomerSession(id=3, userId=2, uuid=415935, localDateTime=2022-11-20T12:56:05.984284400)

```

## Video Explainer of flow control

<a href="https://drive.google.com/drive/folders/1W0QCLnISJj18auYY4vOCRkLRrc8qzamo">**Video Drive Link** </a>

### E-R Diagram Of TripMaker Application

---

![E-R Diagram](https://user-images.githubusercontent.com/36689521/202891447-05f6857d-80a2-4c60-87b3-4072dd94e780.jpeg)

---

### Swagger UI

---

![1](https://user-images.githubusercontent.com/36689521/202891556-faffef5f-d441-467f-9572-dba8b36d9c0e.png)

---

### Login Controller

---

![2](https://user-images.githubusercontent.com/36689521/202891590-4f37a412-1869-4fa0-b64c-730044274084.png)

---

### Admin Controller

---



---

### Customer Controller

---



---

### Booking, Bus and Feedback Controller

---



---

### Hotel and Package Controller

---



---

### Report and Travel Controller

---



---



---
