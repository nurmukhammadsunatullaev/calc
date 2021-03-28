package uz.undp.calc.controllers;

import com.google.common.collect.ImmutableSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import uz.undp.calc.entities.content.ConstantEntity;
import uz.undp.calc.entities.content.TypeEntity;
import uz.undp.calc.entities.security.RoleEntity;
import uz.undp.calc.entities.security.UserEntity;
import uz.undp.calc.models.ResponseData;
import uz.undp.calc.models.security.AuthorizationModel;
import uz.undp.calc.models.security.RegistrationModel;
import uz.undp.calc.repositories.ConstantRepository;
import uz.undp.calc.security.JwtTokenProvider;
import uz.undp.calc.services.TypeService;
import uz.undp.calc.services.TypeService;
import uz.undp.calc.services.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/rest/info")
public class IndexController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;
    private final TypeService typeService;
    @Autowired
    private ConstantRepository repository;

    private final BCryptPasswordEncoder encoder;


    @Autowired
    public IndexController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider,
                           UserService userService, TypeService typeService, BCryptPasswordEncoder encoder) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.typeService=typeService;
        this.userService = userService;
        this.encoder = encoder;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody  AuthorizationModel authorization) {
        try {
            Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authorization.getUsername(), authorization.getPassword()));
            UserEntity user = userService.getUserByName(authorization.getUsername()).get();

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + authorization.getUsername() + " not found");
            }

            String token = jwtTokenProvider.createToken(authorization.getUsername(), user.getAuthorities());

            Map<Object, Object> response = new HashMap<>();
            response.put("username", authorization.getUsername());
            response.put("token", token);


            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @PostMapping("registration")
    public ResponseData registration(@RequestBody RegistrationModel registration)  {

            if(userService.getUserByName(registration.getUsername()).isPresent()) {
                return new ResponseData<>("Not empty username!",207);
            }

            UserEntity userEntity=new UserEntity(registration.getFullName(), registration.getUsername(), encoder.encode(registration.getPassword()));
            RoleEntity roleEntity=userService.getRoleByName("USER").get();
            userEntity.setAuthorities(ImmutableSet.of(roleEntity));
            userService.saveUser(userEntity);

            return new ResponseData<>("Success!",200);
    }

    @GetMapping("types")
    public ResponseData getTypes()  {

//        ConstantEntity constantEntity=new ConstantEntity();
//        constantEntity.setConstantName("Базавый хисоблаш микдори");
//        constantEntity.setConstantValue(245000.0);
//        repository.save(constantEntity);
//
//
//        TypeEntity typeEntity=new TypeEntity();
//        typeEntity.setTypeName("Мулкий тусдаги даъво аризаларидан");
//        typeEntity.setPercent(4.0);
//        typeEntity.setConstantEntity(constantEntity);
//        typeService.save(typeEntity);

        return new ResponseData(typeService.getAllTypes());
    }





}
