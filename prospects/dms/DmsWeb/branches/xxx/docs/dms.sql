--
-- PostgreSQL database dump
--

-- Started on 2008-06-22 14:53:59 IST

SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 1662 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'Standard public schema';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1285 (class 1259 OID 26765)
-- Dependencies: 4
-- Name: complainant; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE complainant (
    complainant_id integer NOT NULL,
    address character varying(255) NOT NULL,
    city character varying(20) NOT NULL,
    email_id character varying(20),
    first_name character varying(30) NOT NULL,
    hand_phone character varying(10),
    home_phone character varying(10),
    last_name character varying(30) NOT NULL,
    pin_code integer NOT NULL
);


ALTER TABLE public.complainant OWNER TO postgres;

--
-- TOC entry 1294 (class 1259 OID 26862)
-- Dependencies: 4
-- Name: complainant_complainant_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE complainant_complainant_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.complainant_complainant_id_seq OWNER TO postgres;

--
-- TOC entry 1286 (class 1259 OID 26769)
-- Dependencies: 4
-- Name: complaint; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE complaint (
    complaint_id integer NOT NULL,
    details character varying(255),
    raised_date date NOT NULL,
    resolved_date date,
    assigned_to integer,
    ward_id integer NOT NULL,
    complainant_id integer NOT NULL,
    complaint_priority_id integer NOT NULL,
    logged_by integer NOT NULL,
    department_id integer NOT NULL,
    complaint_status_id integer NOT NULL,
    complaint_type_id integer NOT NULL
);


ALTER TABLE public.complaint OWNER TO postgres;

--
-- TOC entry 1287 (class 1259 OID 26773)
-- Dependencies: 4
-- Name: complaint_history; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE complaint_history (
    changed_at timestamp without time zone NOT NULL,
    changed_by bigint NOT NULL,
    complaint_id bigint NOT NULL,
    new_state character varying(255) NOT NULL,
    old_state character varying(255) NOT NULL
);


ALTER TABLE public.complaint_history OWNER TO postgres;

--
-- TOC entry 1288 (class 1259 OID 26780)
-- Dependencies: 4
-- Name: complaint_priority; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE complaint_priority (
    complaint_priority_id integer NOT NULL,
    priority character varying(10) NOT NULL
);


ALTER TABLE public.complaint_priority OWNER TO postgres;

--
-- TOC entry 1295 (class 1259 OID 26864)
-- Dependencies: 4
-- Name: complaint_priority_complaint_priority_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE complaint_priority_complaint_priority_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.complaint_priority_complaint_priority_id_seq OWNER TO postgres;

--
-- TOC entry 1289 (class 1259 OID 26784)
-- Dependencies: 4
-- Name: complaint_status; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE complaint_status (
    complaint_status_id integer NOT NULL,
    status character varying(10) NOT NULL
);


ALTER TABLE public.complaint_status OWNER TO postgres;

--
-- TOC entry 1296 (class 1259 OID 26866)
-- Dependencies: 4
-- Name: complaint_status_complaint_status_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE complaint_status_complaint_status_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.complaint_status_complaint_status_id_seq OWNER TO postgres;

--
-- TOC entry 1290 (class 1259 OID 26788)
-- Dependencies: 4
-- Name: complaint_type; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE complaint_type (
    complaint_type_id integer NOT NULL,
    details character varying(255) NOT NULL,
    short_description character varying(255) NOT NULL
);


ALTER TABLE public.complaint_type OWNER TO postgres;

--
-- TOC entry 1297 (class 1259 OID 26868)
-- Dependencies: 4
-- Name: complaint_type_complaint_type_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE complaint_type_complaint_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.complaint_type_complaint_type_id_seq OWNER TO postgres;

--
-- TOC entry 1291 (class 1259 OID 26795)
-- Dependencies: 4
-- Name: department; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE department (
    department_id integer NOT NULL,
    name character varying(20),
    short_name character varying(5)
);


ALTER TABLE public.department OWNER TO postgres;

--
-- TOC entry 1298 (class 1259 OID 26870)
-- Dependencies: 4
-- Name: department_department_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE department_department_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.department_department_id_seq OWNER TO postgres;

--
-- TOC entry 1292 (class 1259 OID 26799)
-- Dependencies: 4
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE employee (
    employee_id integer NOT NULL,
    address character varying(255) NOT NULL,
    city character varying(20) NOT NULL,
    date_of_birth date,
    email_id character varying(20),
    first_name character varying(20),
    hand_phone character varying(10),
    home_phone character varying(10),
    join_date date,
    last_name character varying(20),
    "password" character varying(20) NOT NULL,
    pin_code integer NOT NULL,
    department_id integer NOT NULL
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- TOC entry 1299 (class 1259 OID 26872)
-- Dependencies: 4
-- Name: employee_employee_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE employee_employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.employee_employee_id_seq OWNER TO postgres;

--
-- TOC entry 1284 (class 1259 OID 26163)
-- Dependencies: 4
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 1293 (class 1259 OID 26803)
-- Dependencies: 4
-- Name: ward; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ward (
    ward_id integer NOT NULL,
    name character varying(20) NOT NULL
);


ALTER TABLE public.ward OWNER TO postgres;

--
-- TOC entry 1300 (class 1259 OID 26874)
-- Dependencies: 4
-- Name: ward_ward_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ward_ward_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.ward_ward_id_seq OWNER TO postgres;

--
-- TOC entry 1632 (class 2606 OID 26768)
-- Dependencies: 1285 1285
-- Name: complainant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY complainant
    ADD CONSTRAINT complainant_pkey PRIMARY KEY (complainant_id);


--
-- TOC entry 1636 (class 2606 OID 26779)
-- Dependencies: 1287 1287 1287 1287 1287 1287
-- Name: complaint_history_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY complaint_history
    ADD CONSTRAINT complaint_history_pkey PRIMARY KEY (changed_at, changed_by, complaint_id, new_state, old_state);


--
-- TOC entry 1634 (class 2606 OID 26772)
-- Dependencies: 1286 1286
-- Name: complaint_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY complaint
    ADD CONSTRAINT complaint_pkey PRIMARY KEY (complaint_id);


--
-- TOC entry 1638 (class 2606 OID 26783)
-- Dependencies: 1288 1288
-- Name: complaint_priority_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY complaint_priority
    ADD CONSTRAINT complaint_priority_pkey PRIMARY KEY (complaint_priority_id);


--
-- TOC entry 1640 (class 2606 OID 26787)
-- Dependencies: 1289 1289
-- Name: complaint_status_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY complaint_status
    ADD CONSTRAINT complaint_status_pkey PRIMARY KEY (complaint_status_id);


--
-- TOC entry 1642 (class 2606 OID 26794)
-- Dependencies: 1290 1290
-- Name: complaint_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY complaint_type
    ADD CONSTRAINT complaint_type_pkey PRIMARY KEY (complaint_type_id);


--
-- TOC entry 1644 (class 2606 OID 26798)
-- Dependencies: 1291 1291
-- Name: department_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY department
    ADD CONSTRAINT department_pkey PRIMARY KEY (department_id);


--
-- TOC entry 1646 (class 2606 OID 26802)
-- Dependencies: 1292 1292
-- Name: employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (employee_id);


--
-- TOC entry 1648 (class 2606 OID 26806)
-- Dependencies: 1293 1293
-- Name: ward_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ward
    ADD CONSTRAINT ward_pkey PRIMARY KEY (ward_id);


--
-- TOC entry 1659 (class 2606 OID 26857)
-- Dependencies: 1643 1291 1292
-- Name: fk4722e6aee5eebdf2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT fk4722e6aee5eebdf2 FOREIGN KEY (department_id) REFERENCES department(department_id);


--
-- TOC entry 1657 (class 2606 OID 26847)
-- Dependencies: 1287 1645 1292
-- Name: fk9928ad00ca156be8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY complaint_history
    ADD CONSTRAINT fk9928ad00ca156be8 FOREIGN KEY (changed_by) REFERENCES employee(employee_id);


--
-- TOC entry 1658 (class 2606 OID 26852)
-- Dependencies: 1286 1287 1633
-- Name: fk9928ad00ebdc3962; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY complaint_history
    ADD CONSTRAINT fk9928ad00ebdc3962 FOREIGN KEY (complaint_id) REFERENCES complaint(complaint_id);


--
-- TOC entry 1653 (class 2606 OID 26827)
-- Dependencies: 1641 1290 1286
-- Name: fkac5efcab421fe2b9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY complaint
    ADD CONSTRAINT fkac5efcab421fe2b9 FOREIGN KEY (complaint_type_id) REFERENCES complaint_type(complaint_type_id);


--
-- TOC entry 1651 (class 2606 OID 26817)
-- Dependencies: 1631 1286 1285
-- Name: fkac5efcab461f7682; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY complaint
    ADD CONSTRAINT fkac5efcab461f7682 FOREIGN KEY (complainant_id) REFERENCES complainant(complainant_id);


--
-- TOC entry 1652 (class 2606 OID 26822)
-- Dependencies: 1286 1637 1288
-- Name: fkac5efcab66161af9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY complaint
    ADD CONSTRAINT fkac5efcab66161af9 FOREIGN KEY (complaint_priority_id) REFERENCES complaint_priority(complaint_priority_id);


--
-- TOC entry 1649 (class 2606 OID 26807)
-- Dependencies: 1639 1289 1286
-- Name: fkac5efcab9d5bb3f9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY complaint
    ADD CONSTRAINT fkac5efcab9d5bb3f9 FOREIGN KEY (complaint_status_id) REFERENCES complaint_status(complaint_status_id);


--
-- TOC entry 1655 (class 2606 OID 26837)
-- Dependencies: 1286 1645 1292
-- Name: fkac5efcabb0f4b4b2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY complaint
    ADD CONSTRAINT fkac5efcabb0f4b4b2 FOREIGN KEY (assigned_to) REFERENCES employee(employee_id);


--
-- TOC entry 1654 (class 2606 OID 26832)
-- Dependencies: 1645 1286 1292
-- Name: fkac5efcabdec53e5a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY complaint
    ADD CONSTRAINT fkac5efcabdec53e5a FOREIGN KEY (logged_by) REFERENCES employee(employee_id);


--
-- TOC entry 1650 (class 2606 OID 26812)
-- Dependencies: 1291 1286 1643
-- Name: fkac5efcabe5eebdf2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY complaint
    ADD CONSTRAINT fkac5efcabe5eebdf2 FOREIGN KEY (department_id) REFERENCES department(department_id);


--
-- TOC entry 1656 (class 2606 OID 26842)
-- Dependencies: 1286 1293 1647
-- Name: fkac5efcabe8e2efb2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY complaint
    ADD CONSTRAINT fkac5efcabe8e2efb2 FOREIGN KEY (ward_id) REFERENCES ward(ward_id);


--
-- TOC entry 1663 (class 0 OID 0)
-- Dependencies: 4
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2008-06-22 14:53:59 IST

--
-- PostgreSQL database dump complete
--
