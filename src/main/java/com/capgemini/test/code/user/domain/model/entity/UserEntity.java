package com.capgemini.test.code.user.domain.model.entity;

import com.capgemini.test.code.user.domain.enums.UserRol;
import com.capgemini.test.code.user.domain.model.valueobject.DniVo;
import com.capgemini.test.code.user.domain.model.valueobject.EmailVo;

public class UserEntity {
    private Long id;
    private String name;
    private EmailVo email;
    private String phone;
    private UserRol rol;
    private DniVo dni;
    private RoomEntity room;

    public UserEntity(Long id, String name, EmailVo email, String phone, UserRol rol, DniVo dni, RoomEntity room) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.rol = rol;
        this.dni = dni;
        this.room = room;
    }

    public UserEntity(String name, EmailVo email, String phone, UserRol rol, DniVo dni) {
        this(null, name, email, phone, rol, dni, null);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmailVo getEmail() {
        return email;
    }

    public void setEmail(EmailVo email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserRol getRol() {
        return rol;
    }

    public void setRol(UserRol rol) {
        this.rol = rol;
    }

    public DniVo getDni() {
        return dni;
    }

    public void setDni(DniVo dni) {
        this.dni = dni;
    }

    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }
}
