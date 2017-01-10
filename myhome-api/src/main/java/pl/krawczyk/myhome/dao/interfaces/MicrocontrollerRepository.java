package pl.krawczyk.myhome.dao.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.krawczyk.myhome.entities.MicrocontrollerEntity;

/**
 *
 * @author Łukasz
 */
public interface MicrocontrollerRepository extends MongoRepository<MicrocontrollerEntity, String> {
    
}
