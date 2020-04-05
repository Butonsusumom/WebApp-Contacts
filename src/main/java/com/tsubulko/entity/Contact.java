package com.tsubulko.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@JsonFormat(shape=JsonFormat.Shape.ARRAY)
public  class Contact implements Serializable {
    public enum Marital {
        MARRIED,
        WIDOWED,
        DIVORCED,
        SINGLE;
    }

    public enum Sex {
        MALE,
        FEMALE;
    }

    private Integer id;
    private Address address;
    private Phone phone;
    private String name;
    private String surname;
    private String patronymic;
    private Sex sex;
    private Date birth;
    private String nationality;
    private Marital maritalStatus;
    private String site;
    private String email;
    private String workplace;
    private Photo avatar;

}
