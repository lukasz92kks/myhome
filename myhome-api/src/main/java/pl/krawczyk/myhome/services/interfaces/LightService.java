package pl.krawczyk.myhome.services.interfaces;

import org.springframework.data.domain.Pageable;
import pl.krawczyk.myhome.entities.LightEntity;
import pl.krawczyk.myhome.entities.containers.LightsList;
import pl.krawczyk.myhome.exceptions.EntityNotFoundException;

/**
 *
 * @author Łukasz
 */
public interface LightService {
    
    LightEntity findById(String id) throws EntityNotFoundException;
    
    LightEntity create(LightEntity light);
    
    LightsList findAll(Pageable pageable);

    LightEntity update(LightEntity light) throws EntityNotFoundException;
    
    LightEntity delete(String id) throws EntityNotFoundException;
}
