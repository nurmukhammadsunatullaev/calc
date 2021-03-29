package uz.undp.calc.services;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.undp.calc.entities.security.RoleEntity;
import uz.undp.calc.entities.security.UserEntity;
import uz.undp.calc.repositories.RoleRepository;
import uz.undp.calc.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = getUserByName(username);

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }

        return user.get();
    }

    public List<UserEntity> getAllUsers(){
        List<UserEntity> users=new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public List<RoleEntity> getAllRoles() {
        List<RoleEntity> roles=new ArrayList<>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    public Optional<UserEntity> getUserByName(String name){
        return userRepository.findByUsername(name);
    }
    public Optional<RoleEntity> getRoleByName(String name){
        return roleRepository.findByAuthority(name);
    }

    public void saveUser(UserEntity userEntity) {
        this.userRepository.save(userEntity);
    }

    public void saveRole(RoleEntity roleEntity) {
        roleRepository.save(roleEntity);
    }


}
