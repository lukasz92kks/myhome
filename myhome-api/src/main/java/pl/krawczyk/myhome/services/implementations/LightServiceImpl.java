package pl.krawczyk.myhome.services.implementations;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.krawczyk.myhome.dao.interfaces.LightRepository;
import pl.krawczyk.myhome.entities.LightEntity;
import pl.krawczyk.myhome.entities.containers.LightsList;
import pl.krawczyk.myhome.exceptions.EntityNotFoundException;
import pl.krawczyk.myhome.services.interfaces.LightService;

/**
 *
 * @author Łukasz
 */
@Service
public class LightServiceImpl implements LightService {
    
    private final LightRepository lightRepository;
    
    @Autowired
    public LightServiceImpl(LightRepository lightRepository) {
        this.lightRepository = lightRepository;
    }

    @Override
    public LightEntity findById(String id) throws EntityNotFoundException {
        LightEntity light = lightRepository.findOne(id);
        if (light == null) {
            throw new EntityNotFoundException("Light entity identify by id #" + id + " not found");
        }
        return light;
    }
    
    @Override
    public LightEntity create(LightEntity light) {
        light = lightRepository.save(light);
        return light;
    }
    
    @Override
    public LightsList findAll(Pageable pageable) {
        ArrayList<LightEntity> page = Lists.newArrayList(lightRepository.findAll(pageable));
        LightsList list = new LightsList(page);
        return list;
    }

    @Override
    public LightEntity update(LightEntity light) throws EntityNotFoundException {
        LightEntity updated = lightRepository.findOne(light.getId());
        if (updated == null) {
            throw new EntityNotFoundException("Light entity identify by id #" + light.getId() + " not found");
        }
        if (StringUtils.isNotBlank(light.getName())) {
            updated.setName(light.getName());
        }
        updated.setOn(light.isOn());
        updated = lightRepository.save(updated);
        return updated;
    }

    @Override
    public LightEntity delete(String id) throws EntityNotFoundException {
        LightEntity light = lightRepository.findOne(id);
        if (light == null) {
            throw new EntityNotFoundException("Light entity identify by id #" + id + " not found");
        }
        lightRepository.delete(light);
        return light;
    }
}
