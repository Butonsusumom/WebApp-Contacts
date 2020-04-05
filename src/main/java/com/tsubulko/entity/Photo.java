package com.tsubulko.entity;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Photo implements Serializable {

    private Integer contactId;
    private String path;

}