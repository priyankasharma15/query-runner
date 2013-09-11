CREATE TABLE QUERY_INFO
  (
    ID                NUMBER(4) PRIMARY KEY ,
    QUERY_NAME        VARCHAR2(100) ,
    QUERY_DESCRIPTION VARCHAR2(1000) ,
    SQL_QUERY         VARCHAR2(2000) ,
    NUM_PARAMS        NUMBER ,
    PARAMS            VARCHAR2 (200),
    STATUS            CHAR(1)
  );
  INSERT
INTO QUERY_INFO
  (
    ID,
    QUERY_NAME ,
    QUERY_DESCRIPTION,
    SQL_QUERY,
    NUM_PARAMS,
    PARAMS,
    STATUS
  )
  VALUES
  (
    1 ,
    'Test Query' ,
    'Query for Test',
    'Select Current_Date from Dual' ,
    0 ,
    null,
    'Y'
  ); 
  CREATE TABLE CONNECTION_INFO
  (
    ID                     NUMBER(4) PRIMARY KEY ,
    GROUP_NAME             VARCHAR2(50),
    CONNECTION_NAME        VARCHAR2(100) ,
    CONNECTION_DESCRIPTION VARCHAR2(200) ,
    URL                    VARCHAR2(200) ,
    USERNAME               VARCHAR2 (50),
    PASSWORD               VARCHAR2 (50),
    STATUS                 CHAR(1)
  );
INSERT
INTO CONNECTION_INFO
  (
    ID,
    GROUP_NAME,
    CONNECTION_NAME,
    CONNECTION_DESCRIPTION,
    URL,
    USERNAME,
    PASSWORD,
    STATUS
  )
  VALUES
  (
     1,
    'QA',
    'Test',
    'Test Connection' ,
    'jdbc:oracle:thin:@127.0.0.1:1521:XE',
    'edit_me',
    'edit_me' ,
    'Y'
  );

CREATE TABLE USER_INFO
(
	USERNAME	VARCHAR2(100),
	PASSWORD	VARCHAR2(100) ,  
	STATUS		CHAR(1)
 );

INSERT
INTO USER_INFO
(
	USERNAME,                  
	PASSWORD,                     
	STATUS                    
 )
VALUES(
	'admin',
	'admin',
	'Y'
);