-- begin MYERP_PURCHASE_PRODUCT
create table MYERP_PURCHASE_PRODUCT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PRODUCT_ID uuid not null,
    PURCHASE_ID uuid not null,
    PRICE decimal(19, 2) not null,
    COUNT_ integer not null,
    --
    primary key (ID)
)^
-- end MYERP_PURCHASE_PRODUCT
-- begin MYERP_STORE
create table MYERP_STORE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ADDRESS_CITY varchar(255) not null,
    ADDRESS_STREET varchar(255) not null,
    ADDRESS_HOUSE varchar(255) not null,
    --
    NUMBER_ varchar(255) not null,
    NAME varchar(255) not null,
    COMMERCIAL_NETWORK_ID uuid not null,
    --
    primary key (ID)
)^
-- end MYERP_STORE
-- begin MYERP_PURCHASE
create table MYERP_PURCHASE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    STORE_ID uuid not null,
    --
    primary key (ID)
)^
-- end MYERP_PURCHASE
-- begin MYERP_MANUFACTURER
create table MYERP_MANUFACTURER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ADRESS_CITY varchar(255) not null,
    ADRESS_STREET varchar(255) not null,
    ADRESS_HOUSE varchar(255) not null,
    --
    NAME varchar(255) not null,
    FULL_NAME varchar(1024),
    USER_ID uuid,
    --
    primary key (ID)
)^
-- end MYERP_MANUFACTURER
-- begin MYERP_COMMERCIAL_NETWORK
create table MYERP_COMMERCIAL_NETWORK (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    FULL_NAME varchar(1024),
    --
    primary key (ID)
)^
-- end MYERP_COMMERCIAL_NETWORK
-- begin MYERP_PRICE_HISTORY
create table MYERP_PRICE_HISTORY (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PRODUCT_ID uuid not null,
    STORE_ID uuid,
    DATE_CHANGED timestamp not null,
    --
    primary key (ID)
)^
-- end MYERP_PRICE_HISTORY
-- begin MYERP_PRODUCT
create table MYERP_PRODUCT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    MANUFACTURER_ID uuid not null,
    MANUFACTURER_PRICE decimal(19, 2) not null,
    --
    primary key (ID)
)^
-- end MYERP_PRODUCT
-- begin MYERP_STORE_PRODUCT
create table MYERP_STORE_PRODUCT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    STORE_ID uuid not null,
    PRODUCT_ID uuid not null,
    PRICE decimal(19, 2) not null,
    COUNT_ integer,
    --
    primary key (ID)
)^
-- end MYERP_STORE_PRODUCT
