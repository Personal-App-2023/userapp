package com.doop.user.userapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usersequence")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSequence {
    private int usernum;
}