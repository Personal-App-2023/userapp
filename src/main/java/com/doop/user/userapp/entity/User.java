package com.doop.user.userapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    Integer userId;
    String email;
    String name;
}
