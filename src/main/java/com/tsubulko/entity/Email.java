package com.tsubulko.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Email {

    private String from;
    private String to;
    private String subject;
    private String text;
}
