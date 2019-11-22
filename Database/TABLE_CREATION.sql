drop database FIND_COLLEGE_DB;
#create database FIND_COLLEGE_DB;
CREATE DATABASE IF NOT EXISTS FIND_COLLEGE_DB;
use find_college_db;
DROP TABLE IF EXISTS students;

CREATE TABLE students (
    STUDENT_ID INT AUTO_INCREMENT PRIMARY KEY,
    FNAME VARCHAR(255) NOT NULL,
    MNAME VARCHAR(255) DEFAULT NULL,
    LNAME VARCHAR(255) NOT NULL,
    DOB DATE NOT NULL,
    GENDER VARCHAR(10) NOT NULL,
    AGE TINYINT,
    CONTACT VARCHAR(10) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    LOCATION VARCHAR(255)
);
ALTER TABLE students ADD INDEX EMAIL_idx (EMAIL);
ALTER TABLE students AUTO_INCREMENT=1;
DROP TABLE IF EXISTS colleges;

CREATE TABLE colleges (
    COLLEGE_ID INT AUTO_INCREMENT,
    CNAME VARCHAR(255) NOT NULL,
    MIN_PERCENTAGE DECIMAL(4 , 2 ) NOT NULL,
    FEES INT NOT NULL,
    LOCATION VARCHAR(255) NOT NULL,
    CONTACT VARCHAR(10) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    WEBSITE VARCHAR(255) NOT NULL,
    PRIMARY KEY (COLLEGE_ID , CNAME)
);
ALTER TABLE colleges ADD INDEX EMAIL_idx (EMAIL);
ALTER TABLE colleges AUTO_INCREMENT=1;

DROP TABLE IF EXISTS LOGIN_COLLEGES;
CREATE TABLE LOGIN_COLLEGES (
    COLLEGE_ID INT AUTO_INCREMENT,
    EMAIL VARCHAR(255) NOT NULL,
    PASSWRD VARCHAR(255) NOT NULL,
    FOREIGN KEY (COLLEGE_ID)
        REFERENCES colleges (COLLEGE_ID)
        ON DELETE CASCADE,
    FOREIGN KEY (EMAIL)
        REFERENCES colleges (EMAIL)
        ON DELETE CASCADE
);



ALTER TABLE LOGIN_COLLEGES AUTO_INCREMENT=1;
DROP TABLE IF EXISTS LOGIN_STUDENTS;
CREATE TABLE LOGIN_STUDENTS (
    STUDENT_ID INT AUTO_INCREMENT,
    EMAIL VARCHAR(255) NOT NULL,
    PASSWRD VARCHAR(255) NOT NULL,
    FOREIGN KEY (STUDENT_ID)
        REFERENCES STUDENTS (STUDENT_ID)
        ON DELETE CASCADE,
    FOREIGN KEY (EMAIL)
        REFERENCES STUDENTS (EMAIL)
        ON DELETE CASCADE
);


DROP TABLE IF EXISTS MARKS;
CREATE TABLE MARKS (
    STUDENT_ID INT NOT NULL AUTO_INCREMENT,
    ENGLISH INT(3) NOT NULL,
    HINDI_KANNADA INT(3) NOT NULL,
    MATHS INT(3) NOT NULL,
    PHYSICS INT(3) NOT NULL,
    CHEMISTRY INT(3) NOT NULL,
    COMPUTER_BIOLOGY INT(3) NOT NULL,
    TOTAL_MARKS INT(3),
    PERCENTAGE DECIMAL(5 , 2 ),
    FOREIGN KEY (STUDENT_ID)
        REFERENCES STUDENTS (STUDENT_ID)
        ON DELETE CASCADE
);

ALTER TABLE MARKS AUTO_INCREMENT=1;
ALTER TABLE MARKS ADD INDEX STUDENT_ID_idx (STUDENT_ID);
DELIMITER $$
CREATE TRIGGER marks_check 
BEFORE INSERT ON MARKS FOR EACH ROW 
BEGIN
IF NEW.ENGLISH < 0 THEN
SET NEW.ENGLISH = 0; END IF;
IF NEW.HINDI_KANNADA < 0 THEN 
SET NEW.HINDI_KANNADA = 0; END IF;
IF NEW.MATHS < 0 THEN 
SET NEW.MATHS = 0; END IF;
IF NEW.PHYSICS < 0 THEN 
SET NEW.PHYSICS = 0; END IF;
IF NEW.CHEMISTRY < 0 THEN 
SET NEW.CHEMISTRY = 0; END IF;
IF NEW.COMPUTER_BIOLOGY < 0 THEN 
SET NEW.COMPUTER_BIOLOGY = 0; END IF;
END$$     
DELIMITER ;

DELIMITER $$
CREATE TRIGGER find_age 
before INSERT ON students FOR EACH ROW 
BEGIN
set new.age = TIMESTAMPDIFF(YEAR, new.DOB, CURDATE());
END$$     
DELIMITER ;
#desc marks;
#desc login_students;
    
    
