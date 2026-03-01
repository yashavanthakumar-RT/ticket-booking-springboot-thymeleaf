# 🎬 Book My Ticket – Online Movie Ticket Booking System

A full-stack movie ticket booking web application that allows users to browse movies, select seats in real time, make secure payments, and receive QR-based digital tickets. The system includes role-based access for Admin and Users and ensures booking integrity through backend validation.

 ## 🚀 Features

### 👤 User Module
- User registration with OTP email verification
- Secure login with authentication & authorization
- Browse movies and show timings
- Real-time seat selection with availability check
- Online payment integration
- QR-based ticket generation after booking
- Booking history tracking

### 🛠️ Admin Module
- Add / update / delete movies
- Manage theaters and shows
- Upload movie posters & media
- View booking reports and users
- 
 ## 🏗️ Architecture

The application follows a layered MVC architecture:

- **Controller Layer** – Handles HTTP requests and responses  
- **Service Layer** – Business logic and validations  
- **Repository Layer** – Database interaction using JPA/Hibernate  

Designed RESTful APIs with proper separation of concerns.

---

## 🔐 Security

- Spring Security based authentication & authorization
- Role-based access control (Admin/User)
- OTP email verification using JavaMailSender
- Payment verification using webhook callbacks

---

## 💳 Payment Integration

- Integrated Razorpay payment gateway
- Secure order creation and verification
- Webhook-based transaction confirmation

---

## ☁️ Cloud Storage

- Media files stored using Cloudinary
- Optimized image handling and delivery

---

## 🎟️ Ticket System

- Automatic ticket generation after booking
- QR code encoded ticket validation
- Prevents duplicate bookings using DB-level checks

---

## 🗄️ Database Design

- MySQL relational schema with normalization
- Spring Data JPA + Hibernate ORM
- Efficient query handling and transaction management

---

## 🖥️ Tech Stack

**Backend**
- Java
- Spring Boot
- Spring Security
- Spring Data JPA / Hibernate

**Frontend**
- Thymeleaf
- HTML / CSS / JavaScript

**Database**
- MySQL

**Integrations**
- Razorpay Payment Gateway
- Cloudinary Media Storage
- JavaMailSender Email Service

---

## 📸 Screenshots
 <img width="1863" height="886" alt="Login" src="https://github.com/user-attachments/assets/580b47b0-e2a1-46d1-8e16-72ae5c83fab7" />
  ![Home Page](https://github.com/user-attachments/assets/27eca759-2455-4e80-a185-fd3674f0410f)

 <img width="1812" height="527" alt="movie Managame" src="https://github.com/user-attachments/assets/c135b308-3bbf-4dd6-92d6-294a323dcf1a" />
 ![Theater Manage](https://github.com/user-attachments/assets/16f75c70-466a-4c7a-b07f-7bb26e08efd4)

 <img width="1218" height="858" alt="Manage Theater" src="https://github.com/user-attachments/assets/0eebb5cb-64b1-41e7-a910-178a02e244f9" />
 <img width="1892" height="574" alt="Manage Users" src="https://github.com/user-attachments/assets/f6229f23-5180-46d8-88d0-df54a1794ead" />









 
