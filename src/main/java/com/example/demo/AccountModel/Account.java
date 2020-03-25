package com.example.demo.AccountModel;

import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Account {
    private Integer id;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String  lastname;
    @NotNull
    @NotEmpty
    private String  person_id;
    @NotNull
    @NotEmpty
    private String phone;

    public Account(Integer id, String name, String lastname, String person_id, String phone) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.person_id = person_id;
        this.phone = phone;
    }
    public Account(String name, String lastname, String person_id, String phone) {

        this.name = name;
        this.lastname = lastname;
        this.person_id = person_id;
        this.phone = phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPerson_id() {
        return person_id;
    }

    public String getPhone() {
        return phone;
    }
}
