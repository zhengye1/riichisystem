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
@Entity(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String lastName;

    @Column
    String firstName;

    @Column
    String username;

    @Column
    String email;

    @Column
    String password;

    @Column (name = "create_time")
    LocalDateTime createdAt;

    @Column (name = "update_time")
    LocalDateTime updatedAt;

    @OneToOne
    Role role;

}
