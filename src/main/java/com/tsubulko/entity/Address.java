package com.tsubulko.entity;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Address implements Serializable {

    private int contactId;
    private String country;
    private String city;
    private String street;
    private Integer house;
    private Integer zip;

    public Address(int i, String belarus, String minsk_region, String minsk, int i1) {
    }
}
