package com.capgemini.test.code.user.infrastructure.persistance.entity;

import com.capgemini.test.code.user.domain.enums.UserRol;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name =  "name")
    String name;
    @Column(name =  "email")
    String email;
    @Column(name =  "role")
    @Enumerated(EnumType.STRING)
    UserRol rol;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private RoomJpaEntity room;

    public UserJpaEntity(String name, String email, UserRol rol, RoomJpaEntity roomJpaEntity) {
        this.name = name;
        this.email = email;
        this.rol = rol;
        this.room = roomJpaEntity;
    }

    public UserJpaEntity() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRol getRol() {
        return rol;
    }

    public void setRol(UserRol rol) {
        this.rol = rol;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoomJpaEntity getRoom() {
        return room;
    }

    public void setRoom(RoomJpaEntity room) {
        this.room = room;
    }
}
