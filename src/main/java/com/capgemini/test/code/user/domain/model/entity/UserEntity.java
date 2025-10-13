package com.capgemini.test.code.user.domain.model.entity;

import com.capgemini.test.code.user.domain.enums.RoleUser;
import com.capgemini.test.code.user.domain.model.valueobject.DniVo;
import com.capgemini.test.code.user.domain.model.valueobject.EmailVo;

public class UserEntity {
    private String name;
    private EmailVo email;
    private String phone;
    private RoleUser rol;
    private DniVo dni;
    private RoomEntity room;

    public UserEntity(String name, EmailVo email, String phone, RoleUser rol, DniVo dni) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.rol = rol;
        this.dni = dni;
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

    public RoleUser getRol() {
        return rol;
    }

    public void setRol(RoleUser rol) {
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
