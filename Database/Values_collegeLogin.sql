use find_college_db;
DELETE  FROM LOGIN_COLLEGES;
ALTER TABLE LOGIN_COLLEGES AUTO_INCREMENT = 1;
INSERT INTO LOGIN_COLLEGES(EMAIL,PASSWRD) VALUES("atria@atria.edu","password");
select COLLEGE_ID from LOGIN_COLLEGES where EMAIL="atria@atria.edu" and PASSWRD="password";
SELECT * from LOGIN_COLLEGES;
#'atria@atria.edu'