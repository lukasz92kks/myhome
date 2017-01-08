package pl.krawczyk.myhome.services.implementations;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.krawczyk.myhome.dao.interfaces.BlindRepository;
import pl.krawczyk.myhome.entities.BlindEntity;
import pl.krawczyk.myhome.entities.containers.BlindsList;
import pl.krawczyk.myhome.exceptions.EntityNotFoundException;
import pl.krawczyk.myhome.services.interfaces.BlindService;

/**
 *
 * @author Łukasz
 */
@Service
public class BlindServiceImpl implements BlindService {
    
    private final BlindRepository blindRepository;
    
    @Autowired
    public BlindServiceImpl(BlindRepository blindRepository) {
        this.blindRepository = blindRepository;
    }

    @Override
    public BlindEntity findById(String id) throws EntityNotFoundException {
        BlindEntity blind = blindRepository.findOne(id);
        if (blind == null) {
            throw new EntityNotFoundException("Blind entity identify by id #" + id + " not found");
        }
        return blind;
    }

    @Override
    public BlindEntity create(BlindEntity blind) {
        blind = blindRepository.save(blind);
        return blind;
    }

    @Override
    public BlindsList findAll(Pageable pageable) {
        ArrayList<BlindEntity> page = Lists.newArrayList(blindRepository.findAll(pageable));
        BlindsList list = new BlindsList(page);
        return list;
    }

    @Override
    public BlindEntity update(BlindEntity blind) throws EntityNotFoundException {
        BlindEntity updated = blindRepository.findOne(blind.getId());
        if (updated == null) {
            throw new EntityNotFoundException("Blind entity identify by id #" + blind.getId() + " not found");
        }
        if (StringUtils.isNotBlank(blind.getName())) {
            updated.setName(blind.getName());
        }
        updated.setOpen(blind.isOpen());
        updated = blindRepository.save(updated);
        return updated;
    }

    @Override
    public BlindEntity delete(String id) throws EntityNotFoundException {
        BlindEntity blind = blindRepository.findOne(id);
        if (blind == null) {
            throw new EntityNotFoundException("Blind entity identify by id #" + id + " not found");
        }
        blindRepository.delete(blind);
        return blind;
    }
    
}
