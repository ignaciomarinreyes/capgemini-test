package com.capgemini.test.code.user.infrastructure.persistance.entity;

import com.capgemini.test.code.user.domain.enums.UserRol;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name =  "name")
    String name;
    @Column(name =  "email")
    String email;
    @Column(name =  "phone")
    String phone;
    @Column(name =  "dni")
    String dni;
    @Column(name =  "role")
    @Enumerated(EnumType.STRING)
    UserRol rol;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private RoomJpaEntity room;

}
