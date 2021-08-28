INSERT INTO USER (EMAIL, PASSWORD, USERNAME) VALUES ('test@user.com', '$2a$10$lWJnkoiTbdL6u8cI6CV/sOVQVusjUuZWAj.3Kblxl/lbzRdw2DhLW', 'User1');
INSERT INTO USER (EMAIL, PASSWORD, USERNAME) VALUES ('test2@user.com', '$2a$10$lWJnkoiTbdL6u8cI6CV/sOVQVusjUuZWAj.3Kblxl/lbzRdw2DhLW', 'User2');

INSERT INTO CAR (BRAND, CAR_MILEAGE, FUEL_TYPE, GENERATION, MODEL, PRODUCTION_YEAR) VALUES ( 'BMW', 100000.00, 'PETROL', null, 'M3', 2010);
INSERT INTO CAR (BRAND, CAR_MILEAGE, FUEL_TYPE, GENERATION, MODEL, PRODUCTION_YEAR) VALUES ( 'BMW', 300000.00, 'DIESEL', null, 'X5', 2020);
INSERT INTO CAR (BRAND, CAR_MILEAGE, FUEL_TYPE, GENERATION, MODEL, PRODUCTION_YEAR) VALUES ( 'BMW', 30000.00, 'ELECTRIC', null, 'i8', 2014);
INSERT INTO CAR (BRAND, CAR_MILEAGE, FUEL_TYPE, GENERATION, MODEL, PRODUCTION_YEAR) VALUES ( 'Audi', 242000.00, 'PETROL', null, 'A4', 2008);
INSERT INTO CAR (BRAND, CAR_MILEAGE, FUEL_TYPE, GENERATION, MODEL, PRODUCTION_YEAR) VALUES ( 'Audi', 142000.00, 'PETROL', null, 'A5', 2008);
INSERT INTO CAR (BRAND, CAR_MILEAGE, FUEL_TYPE, GENERATION, MODEL, PRODUCTION_YEAR) VALUES ( 'Audi', 342000.00, 'PETROL', null, 'A6', 2005);

INSERT INTO SALE_ANNOUNCEMENT (IMAGEURL, PRICE, CAR_ID, OWNER_ID) VALUES ( 'https://pablosgarage.pl/wp-content/uploads/2019/05/hehehe.jpg',  200000.00, 1, 1);
INSERT INTO SALE_ANNOUNCEMENT (IMAGEURL, PRICE, CAR_ID, OWNER_ID) VALUES ( 'https://www.iparts.pl/gfx/iparts/images/modele/czesci-audi-a4-b5.jpg',  30000.00, 4, 1);
INSERT INTO SALE_ANNOUNCEMENT (IMAGEURL, PRICE, CAR_ID, OWNER_ID) VALUES ( 'https://d-mf.ppstatic.pl/art/6a/m3/cjemhp8g08gggkwkowwg/bmw-i8-1.1200.jpg',  460000.00, 3, 2);
INSERT INTO SALE_ANNOUNCEMENT (IMAGEURL, PRICE, CAR_ID, OWNER_ID) VALUES ( 'https://www.wyborkierowcow.pl/wp-content/uploads/2018/07/Audi-A5.jpg',  50000.00, 5, 2);