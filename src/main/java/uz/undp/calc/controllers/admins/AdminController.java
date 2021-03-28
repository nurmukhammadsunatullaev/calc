package uz.undp.calc.controllers.admins;

import org.springframework.web.bind.annotation.*;
import uz.undp.calc.entities.security.RoleEntity;
import uz.undp.calc.entities.security.UserEntity;
import uz.undp.calc.models.ResponseData;
import uz.undp.calc.models.security.UserModel;
import uz.undp.calc.services.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*" )
@RequestMapping("/rest/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;

    }

    //Users CRUD
    @GetMapping("/users/list")
    public ResponseData<List<UserModel>> getAllUsers(){
        return new ResponseData<>(userService.getAllUsers().stream().map(UserModel::new).collect(Collectors.toList()));
    }

    // Role CRUD
    @GetMapping("/roles/list")
    public ResponseData<List<String>> getAllRoles(){
        return new ResponseData(userService.getAllRoles().stream().map(RoleEntity::getAuthority).collect(Collectors.toList()));
    }

    @PostMapping("/user/change_role")
    public ResponseData changeRole(@RequestBody UserModel userRoleModel) {
        Optional<UserEntity> optionalUser= userService.getUserByName(userRoleModel.getUsername());

        if(!optionalUser.isPresent()){
            return new ResponseData("User not found!",404);
        }

        UserEntity userEntity=optionalUser.get();

        userRoleModel.getAuthorities().forEach(role->{
            Optional<RoleEntity> optionalRole=userService.getRoleByName(role);
            if(optionalRole.isPresent()){
                userEntity.getAuthorities().add(optionalRole.get());
            }
        });

        userService.saveUser(userEntity);
        return new ResponseData(new UserModel(userEntity));
    }


    @GetMapping("/roles/add/{roleName}")
    public ResponseData addRole(@PathVariable String roleName) {
        if (userService.getRoleByName(roleName).isPresent()) {
            return new ResponseData<>("Already exist!", 210);
        }

        RoleEntity roleEntity = new RoleEntity(roleName);
        userService.saveRole(roleEntity);
        return new ResponseData("Success!", 200);
    }







}
