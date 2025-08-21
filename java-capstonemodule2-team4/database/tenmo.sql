-- database tenmo
START TRANSACTION;

-- *************************************************************************************************
-- Drop all db tables
-- *************************************************************************************************
DROP TABLE IF EXISTS tenmo_user;

-- *************************************************************************************************
-- Create the tables and constraints
-- *************************************************************************************************
--INT GENERATED ALWAYS AS IDENTITY behaves similarly to SERIAL and creates an auto-incrementing
--integer value on inserting into the table
CREATE TABLE tenmo_user (
	user_id INT GENERATED ALWAYS AS IDENTITY,
	username VARCHAR(50) NOT NULL UNIQUE,
	password_hash VARCHAR(200) NOT NULL,
	role VARCHAR(50) NOT NULL,
	CONSTRAINT pk_user PRIMARY KEY (user_id)
);

-- *************************************************************************************************
-- Insert some sample starting data
-- *************************************************************************************************
-- Password for all users is password
INSERT INTO
	tenmo_user (username, password_hash, role)
VALUES
	('user','$2a$10$tmxuYYg1f5T0eXsTPlq/V.DJUKmRHyFbJ.o.liI1T35TFbjs2xiem','ROLE_USER'),
	('admin','$2a$10$tmxuYYg1f5T0eXsTPlq/V.DJUKmRHyFbJ.o.liI1T35TFbjs2xiem','ROLE_ADMIN');

CREATE TABLE account (
	account_id serial,
	user_id serial,
	account_type varchar(50) NOT NULL,
	balance decimal(8,2),
	CONSTRAINT PK_account PRIMARY KEY(account_id),
	CONSTRAINT FK_user_account FOREIGN KEY(user_id) REFERENCES tenmo_user(user_id)
);

CREATE TABLE transfer (
	transfer_id serial,
	transfer_type varchar(50) NOT NULL,
	transfer_status varchar(50) NOT NULL,
	account_from int,
	account_to int,
	amount decimal(8,2),
	description varchar(200),
	status varchar(50),
	CONSTRAINT PK_transfer_id PRIMARY KEY(transfer_id),
	CONSTRAINT FK_account_from FOREIGN KEY(account_from) REFERENCES account(account_id),
	CONSTRAINT FK_account_to FOREIGN KEY(account_to) REFERENCES account(account_id)
);

COMMIT;