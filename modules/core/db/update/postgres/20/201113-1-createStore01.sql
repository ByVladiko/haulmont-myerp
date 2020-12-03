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
    ADRESS_CITY varchar(255) not null,
    ADRESS_STREET varchar(255) not null,
    ADRESS_HOUSE varchar(255) not null,
    --
    NUMBER_ varchar(255) not null,
    NAME varchar(255) not null,
    COMMERCIAL_NETWORK_ID uuid not null,
    --
    primary key (ID)
);