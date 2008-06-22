
CREATE DATABASE dms;


-- table for people who raise complaints

CREATE TABLE complainant (
    complainant_id serial NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    address text NOT NULL,
    city VARCHAR(20) NOT NULL,
    pin_code integer NOT NULL,
    email_id VARCHAR(20),
    home_phone VARCHAR(10),
    hand_phone VARCHAR(10)
);


CREATE TABLE complaint_type (
	complaint_type_id serial  primary key,
	short_description text NOT NULL,
details text NOT NULL
);

CREATE TABLE complaint_status (
	complaint_status_id serial  primary key,
	status VARCHAR(10) NOT NULL
);

CREATE TABLE complaint_priority (
	complaint_priority_id serial  primary key,
	priority VARCHAR(10) NOT NULL
);

CREATE TABLE ward (
	ward_id serial  primary key,
	name VARCHAR(20) NOT NULL	
);

CREATE TABLE department (
    department_id serial  primary key,
    name varchar(20),
    short_name varchar(5)    
);

CREATE TABLE complaint (
    complaint_id serial NOT NULL,
    raised_date date NOT NULL,
    resolved_date date,
--the employee who logged this complaint, refernces employee
    logged_by bigint NOT NULL,
    complainant_id bigint NOT NULL,
	complaint_type_id bigint NOT NULL,
    short_description text NOT NULL,
    details text NOT NULL,
    complaint_status_id integer NOT NULL references complaint_status(complaint_status_id),
    complaint_priority_id integer NOT NULL references complaint_priority (complaint_priority_id),
--the employee to whom this is assigned 
    assigned_to bigint,
ward_id integer references ward(ward_id),
department_id integer references department(department_id)
);





CREATE TABLE complaint_history (
    complaint_id bigint NOT NULL,
--the employee who changed this complaint
    changed_by bigint NOT NULL,
    old_state text NOT NULL,
    new_state text NOT NULL,
    changed_at timestamp without time zone
);




CREATE TABLE employee (
    employee_id serial NOT NULL,
    department_id bigint NOT NULL REFERENCES department(department_id),
    first_name varchar(20),
    last_name varchar(20),
    date_of_birth date,
    join_date date,
    address text NOT NULL,
    city VARCHAR(20) NOT NULL,
    pin_code integer NOT NULL,
    email_id VARCHAR(20),
    home_phone VARCHAR(10),
    hand_phone VARCHAR(10)

);


--
-- TOC entry 1611 (class 2606 OID 25724)
-- Dependencies: 1273 1273
-- Name: complainant_id_pk; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY complainant
    ADD CONSTRAINT complainant_id_pk PRIMARY KEY (complainant_id);


--
-- TOC entry 1613 (class 2606 OID 25733)
-- Dependencies: 1274 1274
-- Name: complaint_id_pk; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY complaint
    ADD CONSTRAINT complaint_id_pk PRIMARY KEY (complaint_id);


--
-- TOC entry 1609 (class 2606 OID 25717)
-- Dependencies: 1272 1272
-- Name: employee_id_pk; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_id_pk PRIMARY KEY (employee_id);


--
-- TOC entry 1614 (class 2606 OID 25739)
-- Dependencies: 1274 1273 1610
-- Name: complaint_complainant_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY complaint
    ADD CONSTRAINT complaint_complainant_fk FOREIGN KEY (complainant_id) REFERENCES complainant(complainant_id);


--
-- TOC entry 1615 (class 2606 OID 25744)
-- Dependencies: 1274 1608 1272
-- Name: complaint_employee_assigned_to_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY complaint
    ADD CONSTRAINT complaint_employee_assigned_to_fk FOREIGN KEY (assigned_to) REFERENCES employee(employee_id);


--
-- TOC entry 1616 (class 2606 OID 25749)
-- Dependencies: 1274 1608 1272
-- Name: complaint_emplyee_logged_by; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY complaint
    ADD CONSTRAINT complaint_emplyee_logged_by FOREIGN KEY (logged_by) REFERENCES employee(employee_id);


--
-- TOC entry 1617 (class 2606 OID 25754)
-- Dependencies: 1275 1612 1274
-- Name: complaint_history_complaint_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY complaint_history
    ADD CONSTRAINT complaint_history_complaint_fk FOREIGN KEY (complaint_id) REFERENCES complaint(complaint_id);



