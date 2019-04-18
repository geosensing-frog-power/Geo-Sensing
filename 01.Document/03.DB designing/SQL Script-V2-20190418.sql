--T_parking_slots
create table karl.T_parking_slots (
parking_id    varchar2  (10) not null,
Slot_id      varchar2  (10) not null,
parking_station  varchar2  (2 ),
charging_from  date     ,
charging_to    date     ,
location_x    varchar2	(10),
location_y		varchar2	(10)
);

create unique index karl.i_parking_slots_p_s on  karl.T_parking_slots(parking_id,slot_Id) ; 
alter table karl.T_parking_slots add constraint pk_parking_slots primary key (parking_id,slot_Id) using index; 


--T_mapping_zone
create table karl.T_mapping_zone (
parking_id			varchar2	(10),
parking_zone_color	varchar2	(30),
location_x			varchar2	(10),
location_y			varchar2	(10)
);


--T_order_details
create table karl.T_order_details (
order_id			varchar2	(10) not null,
start_time	date	        ,
end_time	date	        ,
parking_id		varchar2	(10),
slot_id			varchar2	(10),
recepit_no		varchar2	(30),
order_status	varchar2	(1 ),
Amount			number		(10),
user_id         varchar2    (10)
);

create unique index karl.pk_order_details on  karl.T_order_details(order_id) ; 
alter table karl.T_order_details add constraint pk_order_details primary key (order_id) using index;



--T_user_info
create table karl.T_user_info (
user_id		varchar2	(10) not null,
firstname	varchar2	(30) not null,
lastname	varchar2	(30) not null,
email		varchar2	(30) not null,
password	varchar2	(30) not null,
phone_number	number	(10) ,--not null,
bsb_number		number	(6 ) ,
acc_number		number	(8 ) ,
cvv_number		number	(3 ) 
);

create unique index karl.pk_user_info on  karl.T_user_info(user_id) ; 
alter table karl.T_user_info add constraint pk_user_info primary key (user_id) using index; 

create index karl.i_user_info_name on karl.t_user_info(firstname,lastname);
create unique index karl.i_user_info_email on karl.t_user_info(email);
create unique index karl.i_user_info_phone on karl.t_user_info(phone_number);
create unique index karl.i_user_info_bsb on karl.t_user_info(bsb_number);


--create 
CREATE SEQUENCE karl.Q_user_info
MINVALUE 1 
NOMAXVALUE 
INCREMENT BY 1 
START WITH 1 cache 20;
