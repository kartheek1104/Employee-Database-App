# Employee-Database-App

A simple Java desktop application to manage employees using JDBC and MySQL.

## Features

- Connects to MySQL database using JDBC
- CRUD operations on employees (Add, View, Update, Delete)

## Prerequisites

- Java JDK 8 or higher
- MySQL Server installed and running
- MySQL Connector/J JDBC driver (`mysql-connector-j-9.3.0.jar`) placed in the `lib/` folder
- Git (optional, for version control)

## Setup and Run

1. Create the database and table in MySQL:

```sql
CREATE DATABASE EmployeeDB;

USE EmployeeDB;

CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    position VARCHAR(100),
    salary DOUBLE
);
```
## How to Run
 ```bash
 javac -cp ".;lib/mysql-connector-j-9.3.0.jar" *.java
 java -cp ".;lib/mysql-connector-j-9.3.0.jar" EmployeeGUI
 ```
