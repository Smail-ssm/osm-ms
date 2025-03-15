package com.osm.securityservice.service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class UserDTO implements Serializable {

    @NotNull
    @Size(min = 1, max = 50)
    private String username;

    @NotNull
    @Size(min = 1, max = 50)
    private String phone;

    @Email
    @Size(min = 5, max = 254)
    private String email;

    @NotNull
    private String password;

    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String lastName;

    private boolean activated = false;

    @Size(min = 2, max = 10)
    private String langKey;

    // getters and setters
}
