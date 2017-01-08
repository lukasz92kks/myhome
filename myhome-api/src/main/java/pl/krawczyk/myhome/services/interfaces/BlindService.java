package pl.krawczyk.myhome.services.interfaces;

import org.springframework.data.domain.Pageable;
import pl.krawczyk.myhome.entities.BlindEntity;
import pl.krawczyk.myhome.entities.containers.BlindsList;
import pl.krawczyk.myhome.exceptions.EntityNotFoundException;

/**
 *
 * @author Łukasz
 */
public interface BlindService {
    
    BlindEntity findById(String id) throws EntityNotFoundException;
    
    BlindEntity create(BlindEntity blind);
    
    BlindsList findAll(Pageable pageable);

    BlindEntity update(BlindEntity blind) throws EntityNotFoundException;
    
    BlindEntity delete(String id) throws EntityNotFoundException;
}
