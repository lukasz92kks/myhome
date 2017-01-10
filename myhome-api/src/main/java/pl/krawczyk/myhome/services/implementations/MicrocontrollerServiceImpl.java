package pl.krawczyk.myhome.services.implementations;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.krawczyk.myhome.dao.interfaces.BlindRepository;
import pl.krawczyk.myhome.dao.interfaces.MicrocontrollerRepository;
import pl.krawczyk.myhome.dao.interfaces.LightRepository;
import pl.krawczyk.myhome.entities.MicrocontrollerEntity;
import pl.krawczyk.myhome.entities.containers.MicrocontrollersList;
import pl.krawczyk.myhome.exceptions.EntityNotFoundException;
import pl.krawczyk.myhome.services.interfaces.MicrocontrollerService;

/**
 *
 * @author Łukasz
 */
@Service
public class MicrocontrollerServiceImpl implements MicrocontrollerService {

    private final MicrocontrollerRepository microcontrollerRepository;
    private final LightRepository lightRepository;
    private final BlindRepository blindRepository;
    
    @Autowired
    public MicrocontrollerServiceImpl(MicrocontrollerRepository microcontrollerRepository, LightRepository lightRepository, BlindRepository blindRepository) {
        this.microcontrollerRepository = microcontrollerRepository;
        this.lightRepository = lightRepository;
        this.blindRepository = blindRepository;
    }
    
    @Override
    public MicrocontrollerEntity findById(String id) throws EntityNotFoundException {
        MicrocontrollerEntity microcontroller = microcontrollerRepository.findOne(id);
        if (microcontroller == null) {
            throw new EntityNotFoundException("Microcontroller entity identify by id #" + id + " not found");
        }
        return microcontroller;
    }

    @Override
    public MicrocontrollerEntity create(MicrocontrollerEntity microcontroller, List<String> lights, List<String> blinds) {
        microcontroller = microcontrollerRepository.save(microcontroller);
        return microcontroller;
    }

    @Override
    public MicrocontrollersList findAll(Pageable pageable) {
        ArrayList<MicrocontrollerEntity> page = Lists.newArrayList(microcontrollerRepository.findAll(pageable));
        MicrocontrollersList list = new MicrocontrollersList(page);
        return list;
    }

    @Override
    public MicrocontrollerEntity update(MicrocontrollerEntity microcontroller) throws EntityNotFoundException {
        MicrocontrollerEntity updated = microcontrollerRepository.findOne(microcontroller.getId());
        if (updated == null) {
            throw new EntityNotFoundException("Microcontroller entity identify by id #" + microcontroller.getId() + " not found");
        }
        if (StringUtils.isNotBlank(microcontroller.getName())) {
            updated.setName(microcontroller.getName());
        }
        if (StringUtils.isNotBlank(microcontroller.getIpAddress())) {
            updated.setIpAddress(microcontroller.getIpAddress());
        }
        updated.setBlinds(microcontroller.getBlinds());
        updated.setLights(microcontroller.getLights());
        microcontrollerRepository.save(updated);
        return updated;
    }

    @Override
    public MicrocontrollerEntity delete(String id) throws EntityNotFoundException {
        MicrocontrollerEntity microcontroller = microcontrollerRepository.findOne(id);
        if (microcontroller == null) {
            throw new EntityNotFoundException("Microcontroller entity identify by id #" + id + " not found");
        }
        microcontrollerRepository.delete(microcontroller);
        return microcontroller;
    }
}
