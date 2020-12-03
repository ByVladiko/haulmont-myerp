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
);