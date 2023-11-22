# Selenium Test Automation for Sauce Labs with Java and TestNG

## Overview

This project demonstrates Selenium test automation for <a href="https://www.saucedemo.com/">Sauce Labs</a> and <a href="https://the-internet.herokuapp.com/">HerokuApp</a> using Java and TestNG. It follows the Page Object Model (POM) architecture with three different packages:

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
│              └── HerokuTests.java       
│                           
├── .gitignore
├── pom.xml
├── testng.xml
└── README.md
```
## Test Cases

## Heroku - HerokuApp
<ol>
  <li>
    Accessing Page using Basic Auth
  </li>
  <li>
    Broken image validation using HTTP Response Code
  </li>
  <li>
    Handling CheckBox
  </li>
  <li>
    Handling ContexAlert and Right Click
  </li>
  <li>
    Handling Ad popups
  </li>
   <li>
    Handling Drag and Drop [2 different Methods]
  </li>
  <li>
    Handling dropdown
  </li>
</ol>

## Login Tests - Suace Labs
<ol><li>Login without Password:</li>
<ul> 
<li>Description: Verify that the user cannot log in without providing a password.</li>
<li>Test Class: LoginTests</li>
</ul>
<li>Login without Username:</li>
<ul>
<li>  
Description: Verify that the user cannot log in without providing a username.
</li>
<li>
Test Class: LoginTests
</li>
</ul>
<li>Login with Invalid Password:</li>
<ul>
<li> 
Description: Verify that the user cannot log in with an invalid password.
</li>
<li>
Test Class: LoginTests
</li>
</ul>
<li>Locked Out User Login:</li>
<ul>
<li> 
Description: Verify that a locked-out user cannot log in.</li>
<li>
Test Class: LoginTests</li>
</ul>
<li>Successful Login:</li>
<ul>
<li> 
Description: Verify successful login with valid credentials.</li>
  <li>
Test Class: LoginTests</li>
</ul></ol>

## Product Tests - Sauce Labs
<ol>
  <li>
List All Products:</li>
<ul>
  <li>
Description: Verify that all products are listed on the product page.</li>
<li>Test Class: ProductTests</li>
</ul>
<li>Verify the Products Listed:</li>
<ul>
  <li>
Description: Verify the accuracy of the listed products on the product page.</li>
<li>Test Class: ProductTests</li>
</ul>
<li>Add Product to Cart:</li>
<ul>
  <li>
Description: Verify the functionality to add a product to the cart.</li>
<li>Test Class: ProductTests</li>
</ul>
<li>Remove Product from Cart:</li>
<ul>
  <li>
Description: Verify the functionality to remove a product from the cart.</li>
<li>Test Class: ProductTests</li>
</ul>
</ol>
