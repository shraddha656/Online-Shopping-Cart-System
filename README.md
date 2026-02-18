# 🛒 Online Shopping Cart System

A full-featured **Java Dynamic Web Application** that allows users to browse products, manage a shopping cart, and place orders with multiple payment options.

This project is developed using:

- Java (Servlet & JSP)
- JDBC
- MySQL
- HTML, CSS
- Apache Tomcat Server
- Eclipse IDE

It follows the **MVC (Model-View-Controller)** architecture.

---

# 📌 Project Overview

The Online Shopping Cart System is an e-commerce web application where:

- Users can register and log in
- Browse available products
- Add products to cart
- Update cart quantity
- Remove items from cart
- Checkout and place orders
- Select payment method
- View order history

Admin users can manage products and view system data.

---

# 🚀 Features

## 👤 User Module

- User Registration
- User Login
- Browse Products
- Add to Cart
- Update Cart Quantity
- Remove from Cart
- Checkout
- Payment Options:
  - Cash on Delivery (COD)
  - Card Payment
  - UPI Payment
- View Order History
- Logout

---

## 👨‍💼 Admin Module

- Admin Login
- Add Product
- Update Product
- Delete Product
- View All Products
- View All Orders
- View All Users

---

# 🏗️ Project Architecture

This project follows **MVC Architecture**:

## 1️⃣ Model Layer
Contains:
- Java Beans (Entity Classes)
- DAO Classes (Database Logic)
- Database Connection Class

## 2️⃣ View Layer
Contains:
- JSP Pages
- HTML
- CSS

## 3️⃣ Controller Layer
Contains:
- Servlet Classes
- Handles requests and responses

---

# 🗂️ Project Structure

```
OnlineShoppingCartSystem
│
├── src/
│   ├── com.dao/
│   ├── com.model/
│   ├── com.servlet/
│   └── com.connection/
│
├── WebContent/
│   ├── css/
│   ├── images/
│   ├── admin/
│   ├── user/
│   ├── index.jsp
│   ├── login.jsp
│   ├── register.jsp
│   └── cart.jsp
│
├── WEB-INF/
│   └── web.xml
│
└── README.md
```

---

# 🛠️ Technologies Used

- Java (JDK 8 or above)
- Servlet API
- JSP
- JDBC
- MySQL
- Apache Tomcat 9
- Eclipse IDE
- HTML5
- CSS3

---

# 🗄️ Database Configuration

## Step 1: Create Database

```sql
CREATE DATABASE shopping_cart;
USE shopping_cart;
```

## Step 2: Create Required Tables

Example: Users Table

```sql
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    role VARCHAR(20)
);
```

(Create other tables like products, cart, orders accordingly.)

---

# ⚙️ How To Run The Project

## Step 1: Install Required Software

- Install JDK 8+
- Install Eclipse IDE
- Install MySQL Server
- Install Apache Tomcat 9

---

## Step 2: Import Project in Eclipse

1. Open Eclipse
2. Click File → Import
3. Select "Existing Projects into Workspace"
4. Choose your project folder
5. Click Finish

---

## Step 3: Configure Apache Tomcat

1. Go to Servers tab
2. Add Apache Tomcat v9
3. Add your project to server

---

## Step 4: Configure Database

1. Open MySQL
2. Create database
3. Update DB connection file:

```java
String url = "jdbc:mysql://localhost:3306/shopping_cart";
String username = "root";
String password = "your_password";
```

---

## Step 5: Run the Project

1. Right click project
2. Run As → Run on Server
3. Open browser
