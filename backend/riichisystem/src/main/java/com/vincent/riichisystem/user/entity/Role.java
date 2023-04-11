package com.vincent.riichisystem.user.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Vincent Zheng
 */
@Getter
@Setter
@Entity(name = "app_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String name;

    @Column(name = "create_time")
    LocalDateTime createdAt;

    @Column(name = "update_time")
    LocalDateTime updatedAt;
}
