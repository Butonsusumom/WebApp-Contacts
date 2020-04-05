package com.tsubulko.entity;

import lombok.*;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Attachment {

    private Integer id;
    private Integer contactId;
    private String name;
    private Date uploaded;
    private String path;
    private String comment;

    public boolean valid() {
        return name != null && !name.isEmpty();
    }

}
