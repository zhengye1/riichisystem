create table riichisystem.game
(
    id                bigint unsigned auto_increment
        primary key,
    game_rule_id      bigint unsigned                     null,
    game_status       enum ('IN_PROGRESS', 'COMPLETED')   null,
    game_container_id bigint unsigned                     null,
    create_time       timestamp default CURRENT_TIMESTAMP null,
    update_time       timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint game_game_container_id_fk
        foreign key (game_container_id) references riichisystem.game_container (id),
    constraint game_game_rule_id_fk
        foreign key (game_rule_id) references riichisystem.game_rule (id)
);

