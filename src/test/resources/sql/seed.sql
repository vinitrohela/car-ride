use carstest;

set FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE cities;
TRUNCATE TABLE drivers;
TRUNCATE TABLE cars;
TRUNCATE TABLE passengers;
TRUNCATE TABLE trips;
set FOREIGN_KEY_CHECKS = 1;

INSERT INTO cities(name,state,day_rate,night_rate) VALUES
  ('bangalore','karnataka',50,75),
  ('blr','knt',40,60);

INSERT INTO drivers(name,age,gender) VALUES
  ('rohit',24,'MALE'),
  ('sameer',23,'MALE');

INSERT INTO cars(make,model,year,car_type,driver_id)VALUES
  ('hyundai','i20',2010,'BASIC',1),
  ('Honda','i10',2011,'BASIC',1);

INSERT INTO passengers(name,age,gender,credit_balance) VALUES
  ('vinit',24,'MALE',3000),
  ('pankaj',24,'MALE',2000);

INSERT INTO trips(city_id,car_id,passenger_id,driver_id,kms_driven,cost,tip,total_cost)VALUES
  (1,1,1,1,10,100,10,110),
  (1,1,1,1,20,100,10,110);