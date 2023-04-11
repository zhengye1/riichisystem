create table riichisystem.player
(
    id            bigint unsigned auto_increment
        primary key,
    user_id       bigint unsigned                         null,
    game_id       bigint unsigned                         null,
    starting_wind enum ('EAST', 'SOUTH', 'WEST', 'NORTH') null,
    create_time   timestamp default CURRENT_TIMESTAMP     null,
    update_time   timestamp default CURRENT_TIMESTAMP     null on update CURRENT_TIMESTAMP,
    constraint player_pk
        unique (game_id, starting_wind),
    constraint player_app_user_id_fk
        foreign key (user_id) references riichisystem.app_user (id),
    constraint player_game_id_fk
        foreign key (game_id) references riichisystem.game (id)
);

create index player_game_id_index
    on riichisystem.player (game_id);

