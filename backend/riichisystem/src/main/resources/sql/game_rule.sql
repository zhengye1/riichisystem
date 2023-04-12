create table riichisystem.game_rule
(
    id                       bigint unsigned auto_increment
        primary key,
    game_type                enum ('YONMA', 'SANMA')               null,
    game_rule_name           varchar(255)                          null,
    starting_score           int                                   null,
    noten_penalty            int                                   null,
    honba_size               int                                   null,
    tiebreaker               enum ('DIVIDE_EQUALLY', 'WIND_ORDER') null,
    uma_0_over               varchar(255)                          null,
    uma_1_over               varchar(255)                          null,
    uma_2_over               varchar(255)                          null,
    uma_3_over               varchar(255)                          null,
    oka                      int                                   null,
    chombo_penalty           int                                   null,
    is_multi_ron_enable      tinyint(1)                            null,
    is_kiriage_mangan_enable tinyint(1)                            null,
    is_multi_yakuman_enable  tinyint(1)                            null,
    riichi_stick_resolution  enum ('LOST_FOREVER', 'FIRST_PLACE')  null,
    create_time              timestamp default CURRENT_TIMESTAMP   null,
    update_time              timestamp default CURRENT_TIMESTAMP   null on update CURRENT_TIMESTAMP
);

