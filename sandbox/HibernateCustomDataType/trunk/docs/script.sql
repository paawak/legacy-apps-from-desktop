CREATE SEQUENCE CUSTOM_DEMO_SEQ 
START WITH 1
INCREMENT BY 1;


CREATE TABLE CUSTOM_DEMO ( 
	ID				INTEGER PRIMARY KEY NOT NULL,
	NAME			VARCHAR2(20) NOT NULL,
	TIME_WITH_ZONE	VARCHAR2(100) NOT NULL
    ) ;
    

    
