update MYERP_STORE set ADDRESS_HOUSE = '' where ADDRESS_HOUSE is null ;
alter table MYERP_STORE alter column ADDRESS_HOUSE set not null ;
update MYERP_STORE set ADDRESS_STREET = '' where ADDRESS_STREET is null ;
alter table MYERP_STORE alter column ADDRESS_STREET set not null ;
update MYERP_STORE set ADDRESS_CITY = '' where ADDRESS_CITY is null ;
alter table MYERP_STORE alter column ADDRESS_CITY set not null ;
