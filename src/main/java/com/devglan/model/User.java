package com.devglan.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "users")
public class User {

    public static final String SEQ_NAME = "users";
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String firmName;
    @Indexed(unique = true)
    private String mobile;
    private String email;
    private String username;
    private Date createdOn = new Date();
    private String createdBy;
    private String role;

}
