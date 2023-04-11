create table riichisystem.app_role
(
    id          bigint unsigned auto_increment
        primary key,
    name        varchar(255)                        null,
    create_time timestamp default CURRENT_TIMESTAMP null,
    update_time timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
);

