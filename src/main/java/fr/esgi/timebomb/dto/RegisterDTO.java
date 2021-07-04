package fr.esgi.timebomb.dto;

import fr.esgi.timebomb.domain.Role;
import lombok.Data;

@Data
public class RegisterDTO {

    private String username;
    private String password;

    private Role role;
}
