package uz.undp.calc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.undp.calc.entities.security.RoleEntity;
import uz.undp.calc.entities.security.UserEntity;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
    List<UserEntity> findAllByAuthoritiesIn(List<RoleEntity> authorities);
}
