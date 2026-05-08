# 🚀 UI Automation Framework (Selenium + Java + TestNG)

A robust and scalable **UI Automation Testing Framework** built using **Java, Selenium WebDriver, TestNG, Maven, and Extent Reports**.  

The framework is designed using the **Page Object Model (POM)** pattern and includes advanced features such as reporting, screenshot capture, checkpoints, and structured test execution flow.

---

## ⚙️ Tech Stack

- Java 17  
- Selenium WebDriver 4  
- TestNG  
- Maven  
- Extent Reports 5  
- WebDriverManager  
- Apache Commons IO  

---

## 📁 Project Structure
src
└── main
└── java
└── org.example
├── base → BaseTest (setup, teardown, reporting, checkpoints)
├── pages → Page Object Model classes
├── tests → Test classes (Login, Checkout, etc.)
└── utils → Utility classes (Screenshot, Report Manager, SlowDown)


---

## 🚀 Key Features

- ✔ Page Object Model (POM) architecture  
- ✔ Centralized BaseTest for setup and teardown  
- ✔ Extent Reports HTML reporting system  
- ✔ Screenshot capture on test failure  
- ✔ Screenshot capture on validation checkpoints (invalid test cases)  
- ✔ Structured logging for each test step  
- ✔ Slow execution utility for debugging visibility  
- ✔ Clean separation between test logic and page logic  
- ✔ Reusable utility components  

---

## 🧪 Test Coverage

### 🔐 Login Module
- Valid login scenarios  
- Invalid login scenarios (empty username/password validation)

### 🛒 Checkout Module
- End-to-end checkout flow  
- Valid input scenarios  
- Invalid input validation (firstname, lastname, postal code)

---

## 📸 Reporting

After execution, an HTML report is generated using Extent Reports:


### The report includes:
- Test execution status (PASS / FAIL / SKIP)
- Step-by-step logs
- Screenshots for failures
- Screenshots for validation checkpoints

---

## 📸 Screenshot Strategy

- ✔ On Failure → Automatic screenshot attached to report  
- ✔ On Invalid validation (checkpoint) → Screenshot + log  
- ✔ Embedded directly into Extent Report  

---

## 🧠 Key Concepts Applied

- Page Object Model (POM) design pattern  
- TestNG annotations and lifecycle management  
- Custom checkpoint validation mechanism  
- Screenshot utility abstraction  
- Extent Reports integration  
- Clean and maintainable test architecture  

---

## ▶️ How to Run

1. Clone the repository:
```bash
