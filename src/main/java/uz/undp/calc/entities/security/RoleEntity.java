package uz.undp.calc.entities.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tb_role")
public class RoleEntity  implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String authority;

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    private List<UserEntity> users;

    public RoleEntity() {

    }

    public RoleEntity(String authority) {
        this.authority = authority;
    }


}
