package pl.krawczyk.myhome.dao.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.krawczyk.myhome.entities.LightEntity;

/**
 *
 * @author Łukasz
 */
public interface LightRepository extends MongoRepository<LightEntity, Integer> {
    
}
