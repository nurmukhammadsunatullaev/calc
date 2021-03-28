package uz.undp.calc.models.security;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegistrationModel extends AuthorizationModel{
    @NotBlank
    private String fullName;
}