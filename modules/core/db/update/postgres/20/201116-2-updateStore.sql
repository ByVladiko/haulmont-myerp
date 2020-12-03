alter table MYERP_STORE rename column adress_house to adress_house__u45975 ;
alter table MYERP_STORE alter column adress_house__u45975 drop not null ;
alter table MYERP_STORE rename column adress_street to adress_street__u97658 ;
alter table MYERP_STORE alter column adress_street__u97658 drop not null ;
alter table MYERP_STORE rename column adress_city to adress_city__u76830 ;
alter table MYERP_STORE alter column adress_city__u76830 drop not null ;
alter table MYERP_STORE add column ADDRESS_HOUSE varchar(255) ^
update MYERP_STORE set ADDRESS_HOUSE = '' where ADDRESS_HOUSE is null ;
alter table MYERP_STORE alter column ADDRESS_HOUSE set not null ;
alter table MYERP_STORE add column ADDRESS_STREET varchar(255) ^
update MYERP_STORE set ADDRESS_STREET = '' where ADDRESS_STREET is null ;
alter table MYERP_STORE alter column ADDRESS_STREET set not null ;
alter table MYERP_STORE add column ADDRESS_CITY varchar(255) ^
update MYERP_STORE set ADDRESS_CITY = '' where ADDRESS_CITY is null ;
alter table MYERP_STORE alter column ADDRESS_CITY set not null ;
