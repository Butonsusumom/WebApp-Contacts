package com.tsubulko.entity;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Address implements Serializable {

    private Integer contactId;
    private String country;
    private String region;
    private String locality;
    private Integer postcode;

}
