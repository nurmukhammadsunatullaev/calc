package uz.undp.calc.models.security;


import javax.validation.constraints.NotBlank;

public class RegistrationModel extends AuthorizationModel{
    @NotBlank
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }




}
