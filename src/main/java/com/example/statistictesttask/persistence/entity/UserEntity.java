package com.example.statistictesttask.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "user")
@EqualsAndHashCode
public class UserEntity {

    @Id
    private String id;

    private String userName;

    @Indexed(unique=true)
    private String email;

    private String password;
}
