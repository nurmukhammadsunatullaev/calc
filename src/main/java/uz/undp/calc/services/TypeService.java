package uz.undp.calc.services;

import org.springframework.stereotype.Service;
import uz.undp.calc.entities.content.TypeEntity;
import uz.undp.calc.repositories.TypeRepository;

@Service
public class TypeService {
    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public Iterable<TypeEntity> getAllTypes(){
        return typeRepository.findAll();
    }

    public void save(TypeEntity typeEntity) {
           typeRepository.save(typeEntity);
    }
}
