create table riichisystem.app_user
(
    id          bigint unsigned auto_increment
        primary key,
    last_name   varchar(255)                        null,
    first_name  varchar(255)                        null,
    username    varchar(255)                        null,
    email       varchar(255)                        null,
    password    varchar(255)                        null,
    create_time timestamp default CURRENT_TIMESTAMP null,
    update_time timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    role_id     bigint unsigned                     null,
    constraint app_user_app_role_id_fk
        foreign key (role_id) references riichisystem.app_role (id)
);

