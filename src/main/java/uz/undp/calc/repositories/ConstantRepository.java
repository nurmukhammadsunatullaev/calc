package uz.undp.calc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.undp.calc.entities.content.ConstantEntity;

@Repository
public interface ConstantRepository extends CrudRepository<ConstantEntity,Integer> {

}
