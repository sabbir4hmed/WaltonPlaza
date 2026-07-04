# 🏬 WaltonPlaza Test Automation Framework

### A robust, enterprise-grade Selenium WebDriver test automation framework for the Walton Plaza web application

[![Java](https://img.shields.io/badge/Java-11%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Selenium](https://img.shields.io/badge/Selenium-4.x-43B02A?style=for-the-badge&logo=selenium&logoColor=white)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.x-FF6C37?style=for-the-badge&logo=testng&logoColor=white)](https://testng.org/)
[![Maven](https://img.shields.io/badge/Maven-3.x-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![Allure](https://img.shields.io/badge/Allure-Reports-brightgreen?style=for-the-badge&logo=qameta&logoColor=white)](https://allurereport.org/)
[![Maintained](https://img.shields.io/badge/Maintained-Yes-success?style=for-the-badge)](https://github.com/sabbir4hmed/WaltonPlaza)

---

## 📑 Table of Contents

- [Overview](#-overview--about-the-project)
- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [Prerequisites](#-prerequisites)
- [Installation & Setup](#-installation--setup)
- [Running the Tests](#-running-the-tests)
- [Allure Reports](#-allure-reports)
- [Screenshots](#-screenshots)
- [Author](#-author)

---

## 🔍 Overview / About the Project

**WaltonPlaza** is a professional, production-ready **web automation testing framework** built to validate the functional integrity of the Walton Plaza web application. The framework is architected using the **Page Object Model (POM)** design pattern, which ensures clean separation of concerns, enhanced maintainability, and high reusability of test components.

This project demonstrates industry-standard QA engineering practices — from a scalable folder structure and centralized driver management to rich visual test reporting through Allure. It serves both as a **regression suite** and a **reference implementation** for Selenium-based automation frameworks in Java.

> 📌 **Repository:** [github.com/sabbir4hmed/WaltonPlaza](https://github.com/sabbir4hmed/WaltonPlaza)

---

## ✨ Features

- ✅ **Page Object Model (POM)** — Clean, maintainable, and scalable test design
- ✅ **Centralized Driver Management** — `BaseDriver` and `PageDriver` handle WebDriver lifecycle
- ✅ **TestNG Integration** — Annotation-driven execution with full suite support via `testsuite.xml`
- ✅ **Allure Reporting** — Interactive HTML reports with step-level traceability
- ✅ **Maven Build System** — Dependency management and build lifecycle orchestration
- ✅ **Screenshot Capture** — Visual evidence on test events (e.g., `loginbutton_pass.png`)
- ✅ **Modular Architecture** — Separate layers for Drivers, Pages, Suite Setup, and Tests
- ✅ **CI/CD Friendly** — Integrates smoothly with Jenkins, GitHub Actions, and more

---

## 🛠 Tech Stack

| Category | Technology |
|-----------------------|-------------------------------------|
| **Language** | Java 11+ |
| **Automation Library**| Selenium WebDriver 4.x |
| **Testing Framework** | TestNG 7.x |
| **Build Tool** | Apache Maven 3.x |
| **Reporting** | Allure Reports |
| **Design Pattern** | Page Object Model (POM) |
| **IDE** | IntelliJ IDEA |
| **Version Control** | Git & GitHub |
| **Config File** | testsuite.xml (TestNG Suite) |

---

## 📁 Project Structure

```
WALTONPLAZA-MASTER/
├── .idea/
│   └── .gitignore
├── allure-results/                 # Allure test result data
├── screenshots/
│   └── loginbutton_pass.png        # Captured test evidence
├── src/
│   └── test/
│       └── java/
│           ├── Drivers/
│           │   ├── BaseDriver.java      # WebDriver initialization & teardown
│           │   └── PageDriver.java      # Page object driver management
│           ├── Pages/
│           │   ├── DashboardPage.java   # Dashboard page locators & actions
│           │   ├── HomePage.java        # Home page locators & actions
│           │   └── LoginPage.java       # Login page locators & actions
│           ├── Suite/
│           │   └── SuiteSetup.java      # Test suite setup / base config
│           └── Tests/
│               ├── DashboardTest.java   # Dashboard test cases
│               ├── HomePageTest.java    # Home page test cases
│               └── LoginTest.java       # Login test cases
├── pom.xml                          # Maven build & dependencies
├── README.md                        # Project documentation
└── testsuite.xml                    # TestNG suite definition
```

---

## ⚙️ Prerequisites

Before running the project, make sure you have the following installed:

- ☕ **Java JDK 11 or higher**
- 📦 **Apache Maven 3.x**
- 💡 **IntelliJ IDEA** (or any Java IDE)
- 🔗 **Git**
- 📊 **Allure Command-Line Tool** (for viewing reports)

---

## 🚀 Installation & Setup

```bash
# 1. Clone the repository
git clone https://github.com/sabbir4hmed/WaltonPlaza.git

# 2. Navigate into the project directory
cd WaltonPlaza

# 3. Install dependencies & build the project
mvn clean install
```

---

## ▶️ Running the Tests

```bash
# Run all tests
mvn test

# Run the full suite using the TestNG suite file
mvn clean test -DsuiteXmlFile=testsuite.xml
```

---

## 📊 Allure Reports

After test execution, results are stored in the `allure-results/` directory.

```bash
# Serve the report instantly in your browser
allure serve allure-results

# Or generate a static HTML report
allure generate allure-results --clean -o allure-report
```

---

## 📸 Screenshots

Test evidence is automatically captured and stored in the `screenshots/` directory.

| Screenshot | Description |
|------------------------|-----------------------------------|
| `loginbutton_pass.png` | Login button test — passed ✅ |

---

## 👤 Author

**Sabbir Ahmed**
_Software QA Engineer_

- 🔗 LinkedIn: [linkedin.com/in/s4bbir-ahmed](http://www.linkedin.com/in/s4bbir-ahmed)
- 📧 Email: [sabbirsdet@gmail.com](mailto:sabbirsdet@gmail.com)
- 💻 GitHub: [@sabbir4hmed](https://github.com/sabbir4hmed)

---

> ⭐ If you find this project helpful, feel free to give it a star on GitHub!
