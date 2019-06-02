--T_parking_slots
drop table karl.T_parking_slots;
create table karl.T_parking_slots (
parking_id    varchar2  (10) not null,
Slot_id      varchar2  (10) not null,
parking_station  varchar2  (30),
charging_from  varchar2  (8)     ,   --'08:00 AM'
charging_to    varchar2  (8)     ,   --'16:00 PM'
location_lat    varchar2	(30),
location_lng	varchar2	(30),
status       varchar2	(15),
price        number(10)
);

create unique index karl.i_parking_slots_p_s on  karl.T_parking_slots(parking_id,slot_Id) ; 
alter table karl.T_parking_slots add constraint pk_parking_slots primary key (parking_id,slot_Id) using index; 


--insert slots data
set define off;

insert into karl.T_parking_slots values
('A','01','Purple A','08:00','16:00','-12.371799145462651','130.86761444807055','Available',3);
insert into karl.T_parking_slots values
('A','02','Purple A','08:00','16:00','-12.371799145462651','130.86761444807055','Available',3);
insert into karl.T_parking_slots values
('A','03','Purple A','08:00','16:00','-12.371799145462651','130.86761444807055','Available',3);
insert into karl.T_parking_slots values
('A','04','Purple A','08:00','16:00','-12.371799145462651','130.86761444807055','Available',3);

insert into karl.T_parking_slots values
('A','05','Purple A','08:00','16:00','-12.371799145462651','130.86761444807055','Available',3);
insert into karl.T_parking_slots values
('A','06','Purple A','08:00','16:00','-12.371799145462651','130.86761444807055','Available',3);
--insert into karl.T_parking_slots values
('A','07','Purple A','08:00','16:00','-12.371799145462651','130.86761444807055','Available',3);
--insert into karl.T_parking_slots values
('A','08','Purple A','08:00','16:00','-12.371799145462651','130.86761444807055','Available',3);

commit;


--T_mapping_zone
drop table karl.T_mapping_zone;
create table karl.T_mapping_zone (
parking_id			varchar2	(10),
parking_zone_color	varchar2	(30),
location_lat		varchar2	(30),
location_lng		varchar2	(30)
);


--T_order_details
drop table karl.T_order_details;
create table karl.T_order_details (
order_id		varchar2	(10) not null,
parking_id		varchar2	(10),
slot_id			varchar2	(10),
start_time		date	        ,
end_time		date	        ,
recepit_no		varchar2	(30),  --start with 5 bit number
order_status	varchar2	(10),  --0' - unpaid  '1'- paid
Amount			number		(10),
email         varchar2    (30),
Send_email_status varchar2(10)     --'yes' --null by default
);

create unique index karl.pk_order_details on  karl.T_order_details(order_id) ; 
alter table karl.T_order_details add constraint pk_order_details primary key (order_id) using index;


--create 
CREATE SEQUENCE karl.Q_order_details
MINVALUE 1 
NOMAXVALUE 
INCREMENT BY 1 
START WITH 1 cache 20;

CREATE SEQUENCE karl.Q_order_details_recepit
MINVALUE 1 
NOMAXVALUE 
INCREMENT BY 1 
START WITH 10000001 cache 20;

--insert SQL
--INSERT INTO KARL.T_ORDER_DETAILS VALUES (KARL.Q_ORDER_DETAILS.NEXTVAL,?,?,SYSDATE,SYSDATE+120/1440,KARL.Q_ORDER_DETAILS_RECEPIT.NEXTVAL,'PAID',?,?)
--calculate amout of hour booking that needs to be charged, defaut booking time is 2 hours
--input value(sysdate) = T_order_details.start_time
--SELECT (CASE  WHEN to_char(sysdate,'HH24:mi') > '06:00' and to_char(sysdate,'HH24:mi') < '07:00'
--       THEN 1           
--       WHEN to_char(sysdate,'HH24:mi') >= '07:00' and to_char(sysdate,'HH24:mi') <= '15:00'     
--       THEN 2           
--       WHEN to_char(sysdate,'HH24:mi') > '15:00' and to_char(sysdate,'HH24:mi') < '16:00'     
--       THEN 1      
--       ELSE 0  END) * 3 'AMOUT' ,sysdate
--from dual;     

--T_user_info
drop table karl.T_user_info;
create table karl.T_user_info (
user_id		varchar2	(10) not null,
firstname	varchar2	(30) not null,
lastname	varchar2	(30) not null,
email		varchar2	(30) not null,
password	varchar2	(30) not null,
phone_number	number	(10) ,--not null,
cc_number	number	(6 ) ,
cc_expiration	date ,
cc_cvv		number	(3 ) ,
cc_name  varchar2(30)
);

create unique index karl.pk_user_info on  karl.T_user_info(user_id) ; 
alter table karl.T_user_info add constraint pk_user_info primary key (user_id) using index; 

create index karl.i_user_info_name on karl.t_user_info(firstname,lastname);
create unique index karl.i_user_info_email on karl.t_user_info(email);
create unique index karl.i_user_info_phone on karl.t_user_info(phone_number);
create unique index karl.i_user_info_cc_no on karl.t_user_info(cc_number);


--create 
CREATE SEQUENCE karl.Q_user_info
MINVALUE 1 
NOMAXVALUE 
INCREMENT BY 1 
START WITH 1 cache 20;
