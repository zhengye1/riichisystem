create table riichisystem.game_container
(
    id                  bigint unsigned auto_increment
        primary key,
    game_container_name varchar(255)                        null,
    parent_id           bigint unsigned                     null,
    create_time         timestamp default CURRENT_TIMESTAMP null,
    update_time         timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint game_container_game_container_id_fk
        foreign key (parent_id) references riichisystem.game_container (id)
);

