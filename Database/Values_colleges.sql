use find_college_db;
DELETE FROM colleges;
ALTER TABLE colleges AUTO_INCREMENT = 1;
INSERT INTO colleges(CNAME,MIN_PERCENTAGE,FEES,LOCATION,CONTACT,EMAIL,WEBSITE) 	VALUES("Atria Institute of Technology",50.00,86000,"Bangalore","9999999999","atria@atria.edu","www.atria.com");
INSERT INTO colleges(CNAME,MIN_PERCENTAGE,FEES,LOCATION,CONTACT,EMAIL,WEBSITE) 	VALUES("Ramaiah Institute of Technology",85.00,86000,"Bangalore","9536521478","Ramaiah@Ramaiah.edu","www.Ramaiah.com");
INSERT INTO colleges(CNAME,MIN_PERCENTAGE,FEES,LOCATION,CONTACT,EMAIL,WEBSITE) 	VALUES("BMS Institute of Technology and Management",75.00,86000,"Bangalore","8569741256","BMS@BMS.edu","www.BMS.com");
INSERT INTO colleges(CNAME,MIN_PERCENTAGE,FEES,LOCATION,CONTACT,EMAIL,WEBSITE) 	VALUES("RNS Institute of Technology",60.00,86000,"Bangalore","9658745236","RNS@RNS.edu","www.RNS.com");
INSERT INTO colleges(CNAME,MIN_PERCENTAGE,FEES,LOCATION,CONTACT,EMAIL,WEBSITE) 	VALUES("Ambedkar Institute of Technology",80.00,86000,"Bangalore","8547152369","Ambedkar@Ambedkar.edu","www.Ambedkar.com");
SELECT * from colleges;