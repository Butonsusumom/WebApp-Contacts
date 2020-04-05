package com.tsubulko.entity;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Phone{
    public enum PhoneType {
        MOBILE,
        HOME;
    }

    private Integer id;
    private Integer idContact;
    private String countryCode;
    private String operatorCode;
    private String number;
    private PhoneType type;
    private String comment;

}
