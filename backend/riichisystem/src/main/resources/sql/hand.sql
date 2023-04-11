create table riichisystem.hand
(
    id                             bigint unsigned auto_increment
        primary key,
    game_id                        bigint unsigned                     null,
    current_round                  int                                 null,
    current_honba                  int                                 null,
    current_riichi_stick_left_over int                                 null,
    current_repeat                 int                                 null,
    create_time                    timestamp default CURRENT_TIMESTAMP null,
    update_time                    timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint hand_game_id_fk
        foreign key (game_id) references riichisystem.game (id)
);

