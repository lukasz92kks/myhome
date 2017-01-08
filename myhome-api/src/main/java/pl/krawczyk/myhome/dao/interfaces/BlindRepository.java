package pl.krawczyk.myhome.dao.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.krawczyk.myhome.entities.BlindEntity;

/**
 *
 * @author Łukasz
 */
public interface BlindRepository extends MongoRepository<BlindEntity, String> {
    
}
