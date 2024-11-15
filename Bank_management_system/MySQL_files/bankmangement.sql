-- Create a new database for the bank management system
CREATE DATABASE bankmanagementsystem;

-- Show all databases to verify the creation of the new database
SHOW DATABASES;

-- Use the newly created database for subsequent operations
USE bankmanagementsystem;

-- Create a table for user login credentials
CREATE TABLE login (
    formno VARCHAR(20),        -- Unique form number for each user
    cardnumber VARCHAR(25),   -- Card number associated with the user account
    pin_number VARCHAR(10)    -- PIN number for account access
);

-- Create a table for user sign-up details
CREATE TABLE signup (
    formNo VARCHAR(20),          -- Unique form number for each user
    name VARCHAR(30),            -- User's name
    fname VARCHAR(20),           -- Father's name
    dob VARCHAR(20),             -- Date of birth
    gender VARCHAR(20),          -- Gender of the user
    email VARCHAR(30),           -- User's email address
    martial VARCHAR(20),         -- Marital status
    address VARCHAR(50),         -- Residential address
    city VARCHAR(25),            -- City of residence
    state VARCHAR(20),           -- State of residence
    pin VARCHAR(20)              -- PIN code for the address
);

-- Create a second sign-up table for additional personal details
CREATE TABLE signuptwo (
    formNo VARCHAR(20),                     -- Unique form number for each user
    religion VARCHAR(30),                   -- User's religion
    caste VARCHAR(20),                      -- User's caste
    income VARCHAR(20),                     -- User's income
    education_qualification VARCHAR(20),    -- User's education qualification
    occupation VARCHAR(30),                 -- User's occupation
    pan_num VARCHAR(20),                    -- PAN number for tax purposes
    aadhar_num VARCHAR(50),                 -- Aadhar number for identification
    senior_citizen VARCHAR(25),             -- Indicator if the user is a senior citizen
    existing_account VARCHAR(20)             -- Indicator if the user has an existing bank account
);

-- Create a third sign-up table for account-specific details
CREATE TABLE signupthree (
    formno VARCHAR(20),              -- Unique form number for each user
    accounttype VARCHAR(40),         -- Type of bank account (e.g., savings, current)
    card_number VARCHAR(25),         -- Card number for the account
    pin_number VARCHAR(10),          -- PIN number for the account
    facility VARCHAR(20)             -- Additional facilities associated with the account
);

-- Create a table to record banking transactions
CREATE TABLE bank (
    pin VARCHAR(10),         -- PIN associated with the transaction
    date VARCHAR(50),        -- Date of the transaction
    type VARCHAR(20),        -- Type of transaction (e.g., deposit, withdrawal)
    amnt VARCHAR(20)        -- Amount involved in the transaction
);

-- Show all tables in the current database to verify their creation
SHOW TABLES;

-- Select all records from the signup table
SELECT * FROM signup;

-- Select all records from the signuptwo table
SELECT * FROM signuptwo;

-- Select all records from the signupthree table
SELECT * FROM signupthree;

-- Select all records from the login table
SELECT * FROM login;

-- Select all records from the bank table
SELECT * FROM bank;