# Project Title: Automation of Web Form using JUnit  

### Project Summary: A web form having fields such as First Name, Last Name, User Email (Mandatory), Gender, User Password (Mandatory), Date of Birth, Nationality, Phone, Country and Terms and Conditions (Mandatory) has been automated using JUnit, a framework of Selenium. Later, the submission has been asserted by matching the message "User successfully registered" below that appthe form.  

## Prerequisites  
* JDK 11
* IntelliJ IDEA
* Gradle
* Library: Selenium

## How to setup the environment?  
* Copy library name from the Gradle section on [https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple/1.1.1](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.22.0) and paste it in build.gradle file in the project folder
* Click on the gradle icon on IntelliJ IDEA
* Click on the 'Reload All Gradle Projects' icon

## How to run?  
Run the following command in the terminal inside the project directory:  
`gradle clean test`  
