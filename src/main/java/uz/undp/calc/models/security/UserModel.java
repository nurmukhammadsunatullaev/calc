package uz.undp.calc.models.security;


import uz.undp.calc.entities.security.RoleEntity;
import uz.undp.calc.entities.security.UserEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class UserModel {


   private String username;
   private Set<String> authorities;

   public UserModel(UserEntity userEntity){
      this.username=userEntity.getUsername();
      this.authorities=userEntity.getAuthorities().stream().map(RoleEntity::getAuthority).collect(Collectors.toSet());
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public Set<String> getAuthorities() {
      return authorities;
   }

   public void setAuthorities(Set<String> authorities) {
      this.authorities = authorities;
   }
}
