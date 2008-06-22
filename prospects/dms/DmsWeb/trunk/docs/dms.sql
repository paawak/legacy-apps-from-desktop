--
-- PostgreSQL database dump
--

-- Started on 2008-05-11 16:31:08 IST



--
-- TOC entry 1288 (class 1259 OID 25823)
-- Dependencies: 4
-- Name: complainant; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE complainant (
    complainant_id integer NOT NULL,
    first_name character varying(30) NOT NULL,
    last_name character varying(30) NOT NULL,
    address text NOT NULL,
    city character varying(20) NOT NULL,
    pin_code integer NOT NULL,
    email_id character varying(20),
    home_phone character varying(10),
    hand_phone character varying(10)
);


--
-- TOC entry 1287 (class 1259 OID 25821)
-- Dependencies: 1288 4
-- Name: complainant_complainant_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE complainant_complainant_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1672 (class 0 OID 0)
-- Dependencies: 1287
-- Name: complainant_complainant_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE complainant_complainant_id_seq OWNED BY complainant.complainant_id;


--
-- TOC entry 1300 (class 1259 OID 25869)
-- Dependencies: 4
-- Name: complaint; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE complaint (
    complaint_id integer NOT NULL,
    raised_date date NOT NULL,
    resolved_date date,
    logged_by bigint NOT NULL,
    complainant_id bigint NOT NULL,
    complaint_type_id bigint NOT NULL,
    short_description text NOT NULL,
    details text NOT NULL,
    complaint_status_id integer NOT NULL,
    complaint_priority_id integer NOT NULL,
    assigned_to bigint,
    ward_id integer,
    department_id integer
);


--
-- TOC entry 1299 (class 1259 OID 25867)
-- Dependencies: 4 1300
-- Name: complaint_complaint_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE complaint_complaint_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1673 (class 0 OID 0)
-- Dependencies: 1299
-- Name: complaint_complaint_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE complaint_complaint_id_seq OWNED BY complaint.complaint_id;


--
-- TOC entry 1301 (class 1259 OID 25895)
-- Dependencies: 4
-- Name: complaint_history; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE complaint_history (
    complaint_id bigint NOT NULL,
    changed_by bigint NOT NULL,
    old_state text NOT NULL,
    new_state text NOT NULL,
    changed_at timestamp without time zone
);


--
-- TOC entry 1294 (class 1259 OID 25848)
-- Dependencies: 4
-- Name: complaint_priority; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE complaint_priority (
    complaint_priority_id integer NOT NULL,
    priority character varying(10) NOT NULL
);


--
-- TOC entry 1293 (class 1259 OID 25846)
-- Dependencies: 4 1294
-- Name: complaint_priority_complaint_priority_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE complaint_priority_complaint_priority_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1674 (class 0 OID 0)
-- Dependencies: 1293
-- Name: complaint_priority_complaint_priority_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE complaint_priority_complaint_priority_id_seq OWNED BY complaint_priority.complaint_priority_id;


--
-- TOC entry 1292 (class 1259 OID 25841)
-- Dependencies: 4
-- Name: complaint_status; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE complaint_status (
    complaint_status_id integer NOT NULL,
    status character varying(10) NOT NULL
);


--
-- TOC entry 1291 (class 1259 OID 25839)
-- Dependencies: 4 1292
-- Name: complaint_status_complaint_status_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE complaint_status_complaint_status_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1675 (class 0 OID 0)
-- Dependencies: 1291
-- Name: complaint_status_complaint_status_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE complaint_status_complaint_status_id_seq OWNED BY complaint_status.complaint_status_id;


--
-- TOC entry 1290 (class 1259 OID 25831)
-- Dependencies: 4
-- Name: complaint_type; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE complaint_type (
    complaint_type_id integer NOT NULL,
    short_description text NOT NULL,
    details text NOT NULL
);


--
-- TOC entry 1289 (class 1259 OID 25829)
-- Dependencies: 1290 4
-- Name: complaint_type_complaint_type_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE complaint_type_complaint_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1676 (class 0 OID 0)
-- Dependencies: 1289
-- Name: complaint_type_complaint_type_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE complaint_type_complaint_type_id_seq OWNED BY complaint_type.complaint_type_id;


--
-- TOC entry 1298 (class 1259 OID 25862)
-- Dependencies: 4
-- Name: department; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE department (
    department_id integer NOT NULL,
    name character varying(20),
    short_name character varying(5)
);


--
-- TOC entry 1297 (class 1259 OID 25860)
-- Dependencies: 4 1298
-- Name: department_department_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE department_department_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1677 (class 0 OID 0)
-- Dependencies: 1297
-- Name: department_department_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE department_department_id_seq OWNED BY department.department_id;


--
-- TOC entry 1303 (class 1259 OID 25902)
-- Dependencies: 4
-- Name: employee; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE employee (
    employee_id integer NOT NULL,
    department_id bigint NOT NULL,
    first_name character varying(20),
    last_name character varying(20),
    date_of_birth date,
    join_date date,
    address text NOT NULL,
    city character varying(20) NOT NULL,
    pin_code integer NOT NULL,
    email_id character varying(20),
    home_phone character varying(10),
    hand_phone character varying(10)
);


--
-- TOC entry 1302 (class 1259 OID 25900)
-- Dependencies: 1303 4
-- Name: employee_employee_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE employee_employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1678 (class 0 OID 0)
-- Dependencies: 1302
-- Name: employee_employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE employee_employee_id_seq OWNED BY employee.employee_id;


--
-- TOC entry 1296 (class 1259 OID 25855)
-- Dependencies: 4
-- Name: ward; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE ward (
    ward_id integer NOT NULL,
    name character varying(20) NOT NULL
);


--
-- TOC entry 1295 (class 1259 OID 25853)
-- Dependencies: 4 1296
-- Name: ward_ward_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE ward_ward_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1679 (class 0 OID 0)
-- Dependencies: 1295
-- Name: ward_ward_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE ward_ward_id_seq OWNED BY ward.ward_id;


--
-- TOC entry 1634 (class 2604 OID 25825)
-- Dependencies: 1288 1287 1288
-- Name: complainant_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE complainant ALTER COLUMN complainant_id SET DEFAULT nextval('complainant_complainant_id_seq'::regclass);


--
-- TOC entry 1640 (class 2604 OID 25871)
-- Dependencies: 1299 1300 1300
-- Name: complaint_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE complaint ALTER COLUMN complaint_id SET DEFAULT nextval('complaint_complaint_id_seq'::regclass);


--
-- TOC entry 1637 (class 2604 OID 25850)
-- Dependencies: 1293 1294 1294
-- Name: complaint_priority_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE complaint_priority ALTER COLUMN complaint_priority_id SET DEFAULT nextval('complaint_priority_complaint_priority_id_seq'::regclass);


--
-- TOC entry 1636 (class 2604 OID 25843)
-- Dependencies: 1292 1291 1292
-- Name: complaint_status_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE complaint_status ALTER COLUMN complaint_status_id SET DEFAULT nextval('complaint_status_complaint_status_id_seq'::regclass);


--
-- TOC entry 1635 (class 2604 OID 25833)
-- Dependencies: 1290 1289 1290
-- Name: complaint_type_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE complaint_type ALTER COLUMN complaint_type_id SET DEFAULT nextval('complaint_type_complaint_type_id_seq'::regclass);


--
-- TOC entry 1639 (class 2604 OID 25864)
-- Dependencies: 1298 1297 1298
-- Name: department_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE department ALTER COLUMN department_id SET DEFAULT nextval('department_department_id_seq'::regclass);


--
-- TOC entry 1641 (class 2604 OID 25904)
-- Dependencies: 1303 1302 1303
-- Name: employee_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE employee ALTER COLUMN employee_id SET DEFAULT nextval('employee_employee_id_seq'::regclass);


--
-- TOC entry 1638 (class 2604 OID 25857)
-- Dependencies: 1295 1296 1296
-- Name: ward_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ward ALTER COLUMN ward_id SET DEFAULT nextval('ward_ward_id_seq'::regclass);


--
-- TOC entry 1643 (class 2606 OID 25914)
-- Dependencies: 1288 1288
-- Name: complainant_id_pk; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY complainant
    ADD CONSTRAINT complainant_id_pk PRIMARY KEY (complainant_id);


--
-- TOC entry 1655 (class 2606 OID 25916)
-- Dependencies: 1300 1300
-- Name: complaint_id_pk; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY complaint
    ADD CONSTRAINT complaint_id_pk PRIMARY KEY (complaint_id);


--
-- TOC entry 1649 (class 2606 OID 25852)
-- Dependencies: 1294 1294
-- Name: complaint_priority_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY complaint_priority
    ADD CONSTRAINT complaint_priority_pkey PRIMARY KEY (complaint_priority_id);


--
-- TOC entry 1647 (class 2606 OID 25845)
-- Dependencies: 1292 1292
-- Name: complaint_status_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY complaint_status
    ADD CONSTRAINT complaint_status_pkey PRIMARY KEY (complaint_status_id);


--
-- TOC entry 1645 (class 2606 OID 25838)
-- Dependencies: 1290 1290
-- Name: complaint_type_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY complaint_type
    ADD CONSTRAINT complaint_type_pkey PRIMARY KEY (complaint_type_id);


--
-- TOC entry 1653 (class 2606 OID 25866)
-- Dependencies: 1298 1298
-- Name: department_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY department
    ADD CONSTRAINT department_pkey PRIMARY KEY (department_id);


--
-- TOC entry 1657 (class 2606 OID 25918)
-- Dependencies: 1303 1303
-- Name: employee_id_pk; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_id_pk PRIMARY KEY (employee_id);


--
-- TOC entry 1651 (class 2606 OID 25859)
-- Dependencies: 1296 1296
-- Name: ward_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY ward
    ADD CONSTRAINT ward_pkey PRIMARY KEY (ward_id);


--
-- TOC entry 1662 (class 2606 OID 25919)
-- Dependencies: 1642 1300 1288
-- Name: complaint_complainant_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY complaint
    ADD CONSTRAINT complaint_complainant_fk FOREIGN KEY (complainant_id) REFERENCES complainant(complainant_id);


--
-- TOC entry 1659 (class 2606 OID 25880)
-- Dependencies: 1300 1294 1648
-- Name: complaint_complaint_priority_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY complaint
    ADD CONSTRAINT complaint_complaint_priority_id_fkey FOREIGN KEY (complaint_priority_id) REFERENCES complaint_priority(complaint_priority_id);


--
-- TOC entry 1658 (class 2606 OID 25875)
-- Dependencies: 1300 1646 1292
-- Name: complaint_complaint_status_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY complaint
    ADD CONSTRAINT complaint_complaint_status_id_fkey FOREIGN KEY (complaint_status_id) REFERENCES complaint_status(complaint_status_id);


--
-- TOC entry 1661 (class 2606 OID 25890)
-- Dependencies: 1652 1300 1298
-- Name: complaint_department_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY complaint
    ADD CONSTRAINT complaint_department_id_fkey FOREIGN KEY (department_id) REFERENCES department(department_id);


--
-- TOC entry 1663 (class 2606 OID 25924)
-- Dependencies: 1300 1656 1303
-- Name: complaint_employee_assigned_to_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY complaint
    ADD CONSTRAINT complaint_employee_assigned_to_fk FOREIGN KEY (assigned_to) REFERENCES employee(employee_id);


--
-- TOC entry 1664 (class 2606 OID 25929)
-- Dependencies: 1300 1303 1656
-- Name: complaint_emplyee_logged_by; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY complaint
    ADD CONSTRAINT complaint_emplyee_logged_by FOREIGN KEY (logged_by) REFERENCES employee(employee_id);


--
-- TOC entry 1665 (class 2606 OID 25934)
-- Dependencies: 1301 1300 1654
-- Name: complaint_history_complaint_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY complaint_history
    ADD CONSTRAINT complaint_history_complaint_fk FOREIGN KEY (complaint_id) REFERENCES complaint(complaint_id);


--
-- TOC entry 1660 (class 2606 OID 25885)
-- Dependencies: 1300 1296 1650
-- Name: complaint_ward_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY complaint
    ADD CONSTRAINT complaint_ward_id_fkey FOREIGN KEY (ward_id) REFERENCES ward(ward_id);


--
-- TOC entry 1666 (class 2606 OID 25908)
-- Dependencies: 1303 1298 1652
-- Name: employee_department_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_department_id_fkey FOREIGN KEY (department_id) REFERENCES department(department_id);


--
-- TOC entry 1671 (class 0 OID 0)
-- Dependencies: 4
-- Name: public; Type: ACL; Schema: -; Owner: -
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2008-05-11 16:31:09 IST

--
-- PostgreSQL database dump complete
--

