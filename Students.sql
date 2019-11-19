SELECT DATABASE();
show databases;
#create database FIND_COLLEGE_DB;
CREATE DATABASE IF NOT EXISTS FIND_COLLEGE_DB;
use find_college_db;
CREATE TABLE students (
    STUDENT_ID INT AUTO_INCREMENT PRIMARY KEY,
    FNAME VARCHAR(255) NOT NULL,
    MNAME VARCHAR(255),
    LNAME VARCHAR(255) NOT NULL,
    DOB DATE NOT NULL,
    GENDER VARCHAR(10) NOT NULL,
    AGE TINYINT,
    EMAIL VARCHAR(255) NOT NULL,
    LOCATION VARCHAR(255)
);
ALTER TABLE students AUTO_INCREMENT=1;
CREATE TABLE colleges (
    COLLEGE_ID INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    MIN_PERCENTAGE decimal(2,2),
    FEES INT NOT NULL,
    LOCATION VARCHAR(255),
    CONTACT INT(10) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    WEBSITE VARCHAR(255) NOT NULL
);
ALTER TABLE colleges AUTO_INCREMENT=1;

CREATE TABLE LOGIN_STUDENTS (
    STUDENT_ID INT,
    EMAIL VARCHAR(255) NOT NULL,
    PASSWRD VARCHAR(255) NOT NULL,
    FOREIGN KEY (STUDENT_ID)
        REFERENCES STUDENTS (STUDENT_ID)
        ON DELETE CASCADE,
    FOREIGN KEY (EMAIL)
        REFERENCES STUDENTS (EMAIL)
        ON DELETE CASCADE
);

CREATE TABLE LOGIN_COLLEGES (
    COLLEGE_ID INT,
    EMAIL VARCHAR(255) NOT NULL,
    PASSWRD VARCHAR(255) NOT NULL,
    FOREIGN KEY (COLLEGE_ID)
        REFERENCES COLLEGES (COLLEGE_ID)
        ON DELETE CASCADE,
    FOREIGN KEY (EMAIL)
        REFERENCES COLLEGES (EMAIL)
        ON DELETE CASCADE
);

CREATE TABLE MARKS (
    STUDENT_ID INT,
    ENGLISH INT(3) NOT NULL,
    HINDI INT(3) NOT NULL,
    MATHS INT(3) NOT NULL,
    PHYSICS INT(3) NOT NULL,
    CHEMISTRY INT(3) NOT NULL,
    BIOLOGY INT(3) NOT NULL,
    COMPUTER INT(3) NOT NULL,
    TOTAL_MARKS INT(3) NOT NULL,
    PERCENTAGE DECIMAL(3 , 2 ) NOT NULL,
    FOREIGN KEY (STUDENT_ID)
        REFERENCES STUDENT (STUDENT_ID)
        ON DELETE CASCADE
);
    
    
