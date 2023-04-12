create table if not exists riichisystem.hand_event
(
    id              bigint unsigned auto_increment
        primary key,
    hand_id         bigint unsigned                                             null,
    hand_event_type enum ('Riichi', 'Ron', 'Tsumo', 'Exhausive_draw', 'Chombo') null,
    han             int                                                         null,
    fu              int                                                         null,
    hand_point      int                                                         null comment 'Use to store the point for easy calculation later on',
    tenpai          int                                                         null,
    actor           enum ('EAST', 'SOUTH', 'WEST', 'NORTH')                     null,
    target          enum ('EAST', 'SOUTH', 'WEST', 'NORTH')                     null,
    create_time     timestamp default CURRENT_TIMESTAMP                         null,
    update_time     timestamp default CURRENT_TIMESTAMP                         null on update CURRENT_TIMESTAMP,
    constraint hand_event_hand_id_fk
        foreign key (hand_id) references riichisystem.hand (id)
);

