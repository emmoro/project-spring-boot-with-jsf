CREATE TABLE CLIENT (
 ID                   BIGINT(20)   AUTO_INCREMENT ,
 EMAIL                VARCHAR(255)                ,
 NAME                 VARCHAR(255)                ,
 ADDRESS              VARCHAR(255)                ,
 BIRTH_DATE           DATE                        ,
 CELLPHONE            VARCHAR(255)                ,
 CITY                 VARCHAR(255)                ,
 CODE_STATE           VARCHAR(255)                ,
 DATA_CREATION        DATETIME                    ,
 IDENTIFICATION       VARCHAR(255)                ,
 NATIONALITY          VARCHAR(255)                ,
 NUMBER               VARCHAR(255)                ,
 PHONE                VARCHAR(255)                ,
 SEX                  VARCHAR(255)                ,
 STATE                VARCHAR(255)                ,
 STATUS               INT(11)                     ,
 REASON_CANCELLATION  VARCHAR(255)  ,
 PRIMARY KEY (ID)); 
 
 CREATE TABLE EMPLOYEE (
 ID                   BIGINT(20) AUTO_INCREMENT ,
 ADDRESS              VARCHAR(255) ,
 BIRTH_DATE           DATE         ,
 CELLPHONE            VARCHAR(255) ,
 CITY                 VARCHAR(255) ,
 CODE_STATE           VARCHAR(255) ,
 DATA_CREATION        DATETIME     ,
 EMAIL                VARCHAR(255) ,
 END_DATE             DATE         ,
 IDENTIFICATION       VARCHAR(255) ,
 NAME                 VARCHAR(255) ,
 NATIONALITY          VARCHAR(255) ,
 NUMBER               VARCHAR(255) ,
 PHONE                VARCHAR(255) ,
 REASON_LEAVING       VARCHAR(255) ,
 START_DATE           DATE         ,
 STATUS               INT(11)      ,
 REASON_CANCELLATION  VARCHAR(255) ,
 PRIMARY KEY (ID));
 
 CREATE TABLE REMINDER (
 ID             INT(11)   AUTO_INCREMENT,
 DATA_CREATION  DATETIME     ,
 DESCRIPTION    VARCHAR(255) ,
 MESSAGE_READ   BIT(1)       ,
 TITLE          VARCHAR(255) ,
 PRIMARY KEY (ID));
 
 
CREATE TABLE USER (
id int(11) auto_increment,
active bit(1),
date_create date,
email varchar(255),
password varchar(255),
username varchar(255),
id_role int(11));

insert into user values (
1 , "0", "2020-10-10", "teste@teste.com" , "$2a$10$6Xi8MIwBnup0S7L5zHY6pe0e6FL1LluL.nU70HZo4P6UHzx3iCZ4q" , "teste" , "1");
senha = 123456

CREATE TABLE user_role (
id  int(11) auto_increment,
role varchar(255));

insert into user_role values (1, "ADMIN");