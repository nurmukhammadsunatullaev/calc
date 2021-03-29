package uz.undp.calc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.undp.calc.entities.content.TypeEntity;

@Repository
public interface TypeRepository extends CrudRepository<TypeEntity, Integer> {
}
