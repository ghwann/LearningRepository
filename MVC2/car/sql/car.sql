use javaadd;

drop table if exists car;
drop table if exists vendor;
drop table if exists user;

create table if not exists vendor(
vcode char(2) primary key,
vname varchar(10) not null
);
insert into vendor values("10","삼성");
insert into vendor values("20","현대");
insert into vendor values("30","기아");
commit;

create table if not exists car(
num char(6) primary key,
model varchar(10) not null,
price int(6) default 0,
vcode char(2),
foreign key(vcode) references vendor(vcode)
);
insert into car values('S20JUN','SM6',   3300,'10');
insert into car values('H20APR','SONATA',3200,'20');
insert into car values('K20MAY','K5',    3100,'30');
commit;

create table if not exists user(
id varchar(10) primary key,
pw varchar(10) not null
);
insert into user values("ssafy","1111");
commit;

select * from vendor;
select * from car;
select * from user;

select num,model,price,car.vcode,vname
from car,vendor
where car.vcode=vendor.vcode;
