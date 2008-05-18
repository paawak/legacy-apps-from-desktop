
--CREATE DATABASE dms;


-- table for people who raise complaints
CREATE TABLE complainant (
    complainant_id SERIAL PRIMARY KEY,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    address TEXT NOT NULL,
    city VARCHAR(20) NOT NULL,
    pin_code INTEGER NOT NULL,
    email_id VARCHAR(20),
    home_phone VARCHAR(10),
    hand_phone VARCHAR(10)
);


CREATE TABLE complaint_type (
	complaint_type_id SERIAL  PRIMARY KEY,
	short_description TEXT NOT NULL,
    details TEXT NOT NULL
);

CREATE TABLE complaint_status (
	complaint_status_id SERIAL  PRIMARY KEY,
	status VARCHAR(10) NOT NULL
);

CREATE TABLE complaint_priority (
	complaint_priority_id SERIAL  PRIMARY KEY,
	priority VARCHAR(10) NOT NULL
);

CREATE TABLE ward (
	ward_id SERIAL  PRIMARY KEY,
	name VARCHAR(20) NOT NULL	
);

CREATE TABLE department (
    department_id SERIAL  PRIMARY KEY,
    name varchar(20),
    short_name varchar(5)    
);

CREATE TABLE employee (
    employee_id SERIAL PRIMARY KEY,
    department_id bigint NOT NULL REFERENCES department(department_id),
    first_name varchar(20),
    last_name varchar(20),
    date_of_birth date,
    join_date date,
    address TEXT NOT NULL,
    city VARCHAR(20) NOT NULL,
    pin_code INTEGER NOT NULL,
    email_id VARCHAR(20),
    home_phone VARCHAR(10),
    hand_phone VARCHAR(10)

);

CREATE TABLE complaint (
    complaint_id SERIAL PRIMARY KEY,
    raised_date date NOT NULL,
    resolved_date date,
    --the employee who logged this complaint, refernces employee
    logged_by bigint NOT NULL REFERENCES employee(employee_id),
    complainant_id bigint NOT NULL REFERENCES complainant(complainant_id),
	complaint_type_id INTEGER NOT NULL REFERENCES complaint_type(complaint_type_id),
    details TEXT,
    complaint_status_id INTEGER NOT NULL REFERENCES complaint_status(complaint_status_id),
    complaint_priority_id INTEGER NOT NULL REFERENCES complaint_priority (complaint_priority_id),
    --the employee to whom this is assigned 
    assigned_to bigint REFERENCES employee(employee_id),
    ward_id INTEGER NOT NULL REFERENCES ward(ward_id),
    --the department to which this complaint belongs
    department_id INTEGER NOT NULL REFERENCES department(department_id)
);





CREATE TABLE complaint_history (
    complaint_id bigint NOT NULL REFERENCES complaint(complaint_id),
    --the employee who changed this complaint
    changed_by bigint NOT NULL REFERENCES employee(employee_id),
    old_state TEXT NOT NULL,
    new_state TEXT NOT NULL,
    changed_at timestamp without time zone
);

