package com.tsubulko.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Photo {

    private Integer contactId;
    private String path;

}