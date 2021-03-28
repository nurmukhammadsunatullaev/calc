package uz.undp.calc.models.security;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * DTO class for authentication (login) request.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@Data
public class AuthorizationModel {
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String username;

    @NotBlank
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$")
    private String password;
}
