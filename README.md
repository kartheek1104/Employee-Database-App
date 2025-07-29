# Employee-Database-App

A comprehensive Java desktop application to manage employee records with MySQL database integration. The app supports both CLI and Swing GUI interfaces, enabling efficient employee management including CRUD operations, search, and data export.

## Features

- Connects to MySQL database using JDBC
- CRUD operations on employees (Add, View, Update, Delete)

## Prerequisites

- Java JDK 8 or higher  
- MySQL Server installed and running  
- MySQL Connector/J JDBC driver (`mysql-connector-j-9.3.0.jar`) placed in the `lib/` folder  
- Git (optional, for version control)  

## Database Setup

Create the database and `employees` table in MySQL:

```sql
CREATE DATABASE EmployeeDB;

USE EmployeeDB;

CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    position VARCHAR(100),
    salary DOUBLE
);
Project Structure
DBConnection.java — Handles MySQL connection setup

Employee.java — Employee model class with id, name, position, salary

EmployeeAlreadyExistsException.java — Custom exception for duplicate employee IDs

EmployeeDAO.java — Data Access Object for all database operations

EmployeeApp.java — CLI-based employee management application

EmployeeGUI.java — Swing GUI application with tabbed interface for CRUD, search, and export

Compilation and Execution
Compile all Java files and include the MySQL connector JAR in the classpath:

```bash

javac -cp ".;lib/mysql-connector-j-9.3.0.jar" *.java

```
## How to Run
 ```bash
 javac -cp ".;lib/mysql-connector-j-9.3.0.jar" *.java
 java -cp ".;lib/mysql-connector-j-9.3.0.jar" EmployeeGUI
 ```
