package pl.krawczyk.myhome.services.interfaces;

import java.util.List;
import org.springframework.data.domain.Pageable;
import pl.krawczyk.myhome.entities.MicrocontrollerEntity;
import pl.krawczyk.myhome.entities.containers.MicrocontrollersList;
import pl.krawczyk.myhome.exceptions.EntityNotFoundException;

/**
 *
 * @author Łukasz
 */
public interface MicrocontrollerService {
    
    MicrocontrollerEntity findById(String id) throws EntityNotFoundException;
    
    MicrocontrollerEntity create(MicrocontrollerEntity microcontroller, List<String> lights, List<String> blinds);
    
    MicrocontrollersList findAll(Pageable pageable);

    MicrocontrollerEntity update(MicrocontrollerEntity microcontroller) throws EntityNotFoundException;
    
    MicrocontrollerEntity delete(String id) throws EntityNotFoundException;
}
