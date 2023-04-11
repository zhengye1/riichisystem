create table riichisystem.game_rule
(
    id                      bigint unsigned auto_increment
        primary key,
    game_rule_name          varchar(255)                           null,
    starting_point          int                                    null,
    noten_penalty           int                                    null,
    honba_size              int                                    null,
    tiebreaker              enum ('DIVIDE_EQUALLY', 'CLOSED_WIND') null,
    uma_0_over              varchar(255)                           null,
    uma_1_over              varchar(255)                           null,
    uma_2_over              varchar(255)                           null,
    uma_3_over              varchar(255)                           null,
    chombo_penalty          int                                    null,
    is_kiriage_mangan       tinyint(1)                             null,
    is_multi_yakuman        tinyint(1)                             null,
    riichi_stick_resolution enum ('LOST_FOREVER', 'TOP')           null,
    create_time             timestamp default CURRENT_TIMESTAMP    null,
    update_time             timestamp default CURRENT_TIMESTAMP    null on update CURRENT_TIMESTAMP
);

