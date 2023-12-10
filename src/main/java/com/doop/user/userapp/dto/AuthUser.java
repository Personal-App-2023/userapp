package com.doop.user.userapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthUser {
    String sub;
    String name;
    String picture;
    String email;
}
