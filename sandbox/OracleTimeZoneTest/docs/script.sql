CREATE TABLE TIMESTAMP_DEMO ( 
	ID				NUMBER(6) PRIMARY KEY NOT NULL,
	NAME			VARCHAR2(20) NOT NULL,
	TIME_WITH_ZONE	TIMESTAMP(9) WITH TIME ZONE NOT NULL,
	TIME_WITH_ZONE_LOCAL	TIMESTAMP(9) WITH LOCAL TIME ZONE NOT NULL
    ) ;

    
SELECT TZNAME FROM V$TIMEZONE_NAMES;

SELECT TZABBREV FROM V$TIMEZONE_NAMES;

INSERT INTO TIMESTAMP_DEMO (ID, NAME, TIME_WITH_ZONE) VALUES (1, 'A', TO_TIMESTAMP_TZ('2010-12-01 11:00:00 -08:00','YYYY-MM-DD HH:MI:SS TZH:TZM'));
INSERT INTO TIMESTAMP_DEMO (ID, NAME, TIME_WITH_ZONE, TIME_WITH_ZONE_LOCAL) VALUES (1, 'A1', TO_TIMESTAMP_TZ('2010-09-12 18:00:00 Asia/Tokyo','YYYY-MM-DD HH24:MI:SS TZR'), TO_TIMESTAMP_TZ('2010-09-12 18:00:00 Asia/Tokyo','YYYY-MM-DD HH24:MI:SS TZR'));


