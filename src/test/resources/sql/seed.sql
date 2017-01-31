use carstest;

set FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE cities;
TRUNCATE TABLE drivers;
TRUNCATE TABLE cars;
TRUNCATE TABLE passengers;
set FOREIGN_KEY_CHECKS = 1;

INSERT INTO cities(name,state,day_rate,night_rate) VALUES
  ('bangalore','karnataka',50,75);

INSERT INTO drivers(name,age,gender) VALUES
  ('rohit',24,'MALE');

INSERT INTO cars(make,model,year,car_type,driver_id) VALUES
  ('BMW','DSFG343',2000,'LUX',1);

INSERT INTO cars(make,model,year,car_type,driver_id) VALUES
  ('dfg','DSFG3dffd43',2050,'LUX',1);


INSERT INTO passengers(name,age,gender,credit_balance) VALUES
  ('vinit',24,'MALE',3000);