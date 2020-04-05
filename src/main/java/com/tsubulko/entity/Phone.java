package com.tsubulko.entity;


import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Phone implements Serializable {
    public Phone(int id, String s, String countryCode, String operatorCode, PhoneType mobile, String s1, int i) {
    }

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
