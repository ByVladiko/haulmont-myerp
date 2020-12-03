alter table MYERP_PURCHASE_PRODUCT add column PRICE decimal(19, 2) ^
update MYERP_PURCHASE_PRODUCT set PRICE = 0 where PRICE is null ;
alter table MYERP_PURCHASE_PRODUCT alter column PRICE set not null ;
