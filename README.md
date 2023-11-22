# Selenium Test Automation for Sauce Labs with Java and TestNG

## Overview

This project demonstrates Selenium test automation for Sauce Labs using Java and TestNG. It follows the Page Object Model (POM) architecture with three different packages:

- **locators:** Contains classes for storing locators.
- **pages:** Contains classes with methods for each page.
- **utilities:** Contains common utility classes.

Test cases are written for login and product pages, covering various scenarios to ensure robust automation.

## Project Structure

```plaintext

├── src
│   ├── main
│   │   └── java
│   │        ├── locators
│   │        ├── pages           
│   │        └── utilities                       
│   └── test
│       └── java
│         └── tests   
│              ├── LoginTests.java        
│              └── ProductTests.java        
│                           
├── .gitignore
├── pom.xml
├── testng.xml
└── README.md
