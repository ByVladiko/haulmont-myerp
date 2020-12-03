update MYERP_MANUFACTURER set ADRESS_CITY = '' where ADRESS_CITY is null ;
alter table MYERP_MANUFACTURER alter column ADRESS_CITY set not null ;
update MYERP_MANUFACTURER set ADRESS_STREET = '' where ADRESS_STREET is null ;
alter table MYERP_MANUFACTURER alter column ADRESS_STREET set not null ;
update MYERP_MANUFACTURER set ADRESS_HOUSE = '' where ADRESS_HOUSE is null ;
alter table MYERP_MANUFACTURER alter column ADRESS_HOUSE set not null ;
