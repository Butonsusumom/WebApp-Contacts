package com.tsubulko.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Address {

    private Integer contactId;
    private String country;
    private String region;
    private String locality;
    private Integer postcode;

}
