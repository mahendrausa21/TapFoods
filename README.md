# TapFoods 🍽️ - Food Delivery Web Application

A full-fledged Java-based Maven web application simulating a real-world food delivery platform like Swiggy/Zomato. This project showcases backend handling, servlet management, JSP rendering, and a structured MySQL database.

---# TapFoods 🍽️ - Food Delivery Web Application

A full-fledged Java-based Maven web application simulating a real-world food delivery platform like Swiggy/Zomato. This project showcases backend handling, servlet management, JSP rendering, and a structured MySQL database.

---

## 🚀 Features

- User Registration & Login (with session handling)
- Restaurants Display
- Food Menu Display
- Add to Cart & Cart Management
- Checkout Process with Payment Mode Selection
- Order Confirmation Page
- Database Integration (MySQL)

---

## 🏗️ Technologies Used

| Technology   | Purpose                |
|-------------|------------------------|
| Java        | Backend development (Servlets, JSP) |
| Maven       | Dependency management & build tool |
| MySQL       | Database for storing users, restaurants, orders |
| HTML/CSS    | Frontend UI (Login, Signup, Menu, etc.) |
| JSP         | Dynamic content rendering |
| Servlets    | Controller to handle business logic |

---
---

## 📂 Project Structure

```
TapFoods/
│
├── src/main/java/
│ ├── com.tap.model # Java Beans (Menu, Order, Cart etc.)
│ ├── com.tap.Servlet # Servlets (LoginServlet, MenuServlet, CheckoutServlet etc.)
│ ├── com.tap.Dao # DAO Interfaces
│ ├── com.tapDaoImp # DAO Implementations
│
├── src/main/webapp/
│ ├── css/ # CSS files
│ ├── images/ # Food & Restaurant images
│ ├── include/ # Header & Footer JSPs
│ ├── index.jsp # Homepage (with restaurants)
│ ├── login.jsp # Login Page
│ ├── signup.jsp # Signup Page
│ ├── menu.jsp # Menu listing page
│ ├── cart.jsp # Cart view page
│ ├── checkout.jsp # Payment method selection
│ ├── orderConfirmation.jsp # Final order confirmation
│
├── pom.xml # Maven dependencies file
└── README.md # This file



## 🖼️ Screenshots  was there in screenshot folder check it out 

Login Page --- Sign Up Page
---

Restaurant Page -→  Menu page of Restaurant  


Cart Page -→ CheckOut Page -→ OrderConfirmation Page


## ⚙️ How to Run This Project Locally

### 1. **Pre-requisites**

- Java JDK 8 or above
- Apache Tomcat 9 or above
- MySQL Server
- Maven 3.6+
- Eclipse IDE (recommended) or any Java IDE

### 2. **Clone the Repository**

```
git clone https://github.com/mahendrausa21/TapFoods.git
```

### 3. **Import as Maven Project**

1. Open Eclipse
2. File > Import > Existing Maven Projects
3. Browse to the cloned `TapFoods` folder and click Finish.

### 4. **Configure MySQL Database**

#### i. Create a new database:

```
CREATE DATABASE tapfoods;
```

#### ii. Import the tables:

Execute your SQL scripts to create tables such as `User`, `Menu`, `Order`, `OrderItem`, `OrderHistory`, `Restaurant`.

#### iii. Update DB Credentials:

In the file: `src/main/java/com/tapDaoIMp/ConnectionFactory.java`

```
private static final String URL = "jdbc:mysql://localhost:3306/tapfoods";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

### 5. **Run on Tomcat Server**

1. Right-click the project > Run As > Run on Server
2. Choose Apache Tomcat
3. Access it via:

```
http://localhost:8080/TapFoods
```

---


## 🙋‍♂️ Author

**Mahendra Usirikayala**\
📧  mahendrausirikayala@gmail.com
🌐 GitHub

---

## 📃 License

This project is licensed under the MIT License.

---

## ⭐️ Show your support

If you like this project, please ⭐️ this repository and share it to help others!

---

## ⚠️ Note

This is a local deployable educational project. For real hosting, platforms like Heroku or Render are required for backend deployment (Java), but may involve extra configuration and costs.




## 🚀 Features

- User Registration & Login (with session handling)
- Restaurants Display
- Food Menu Display
- Add to Cart & Cart Management
- Checkout Process with Payment Mode Selection
- Order Confirmation Page
- Database Integration (MySQL)

---

## 🏗️ Technologies Used

| Technology   | Purpose                |
|-------------|------------------------|
| Java        | Backend development (Servlets, JSP) |
| Maven       | Dependency management & build tool |
| MySQL       | Database for storing users, restaurants, orders |
| HTML/CSS    | Frontend UI (Login, Signup, Menu, etc.) |
| JSP         | Dynamic content rendering |
| Servlets    | Controller to handle business logic |

---
---

## 📂 Project Structure

```
TapFoods/
│
├── src/main/java/
│ ├── com.tap.model # Java Beans (Menu, Order, Cart etc.)
│ ├── com.tap.Servlet # Servlets (LoginServlet, MenuServlet, CheckoutServlet etc.)
│ ├── com.tap.Dao # DAO Interfaces
│ ├── com.tapDaoImp # DAO Implementations
│
├── src/main/webapp/
│ ├── css/ # CSS files
│ ├── images/ # Food & Restaurant images
│ ├── include/ # Header & Footer JSPs
│ ├── index.jsp # Homepage (with restaurants)
│ ├── login.jsp # Login Page
│ ├── signup.jsp # Signup Page
│ ├── menu.jsp # Menu listing page
│ ├── cart.jsp # Cart view page
│ ├── checkout.jsp # Payment method selection
│ ├── orderConfirmation.jsp # Final order confirmation
│
├── pom.xml # Maven dependencies file
└── README.md # This file



## 🖼️ Screenshots  was there in screenshot folder check it out 

Login Page --- Sign Up Page
---

Restaurant Page -→  Menu page of Restaurant  


Cart Page -→ CheckOut Page -→ OrderConfirmation Page


## ⚙️ How to Run This Project Locally

### 1. **Pre-requisites**

- Java JDK 8 or above
- Apache Tomcat 9 or above
- MySQL Server
- Maven 3.6+
- Eclipse IDE (recommended) or any Java IDE

### 2. **Clone the Repository**

```
git clone https://github.com/mahendrausa21/TapFoods.git
```

### 3. **Import as Maven Project**

1. Open Eclipse
2. File > Import > Existing Maven Projects
3. Browse to the cloned `TapFoods` folder and click Finish.

### 4. **Configure MySQL Database**

#### i. Create a new database:

```
CREATE DATABASE tapfoods;
```

#### ii. Import the tables:

Execute your SQL scripts to create tables such as `User`, `Menu`, `Order`, `OrderItem`, `OrderHistory`, `Restaurant`.

#### iii. Update DB Credentials:

In the file: `src/main/java/com/tapDaoIMp/ConnectionFactory.java`

```
private static final String URL = "jdbc:mysql://localhost:3306/tapfoods";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

### 5. **Run on Tomcat Server**

1. Right-click the project > Run As > Run on Server
2. Choose Apache Tomcat
3. Access it via:

```
http://localhost:8080/TapFoods
```

---


## 🙋‍♂️ Author

**Mahendra Usirikayala**\
📧  mahendrausirikayala@gmail.com
🌐 GitHub

---

## 📃 License

This project is licensed under the MIT License.

---

## ⭐️ Show your support

If you like this project, please ⭐️ this repository and share it to help others!

---

## ⚠️ Note

This is a local deployable educational project. For real hosting, platforms like Heroku or Render are required for backend deployment (Java), but may involve extra configuration and costs.


