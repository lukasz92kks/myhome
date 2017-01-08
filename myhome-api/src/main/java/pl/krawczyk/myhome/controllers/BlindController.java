package pl.krawczyk.myhome.controllers;

import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.krawczyk.myhome.dto.blind.BlindDTO;
import pl.krawczyk.myhome.dto.blind.BlindsListDTO;
import pl.krawczyk.myhome.entities.BlindEntity;
import pl.krawczyk.myhome.entities.containers.BlindsList;
import pl.krawczyk.myhome.exceptions.EntityNotFoundException;
import pl.krawczyk.myhome.services.interfaces.BlindService;

/**
 *
 * @author Łukasz
 */
@RestController
@RequestMapping("/api/blinds")
public class BlindController {
    
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BlindService blindService;
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public BlindDTO findById(@PathVariable String id) throws EntityNotFoundException {
        BlindEntity blind = blindService.findById(id);
        return modelMapper.map(blind, BlindDTO.class);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public BlindDTO create(@RequestBody @Valid BlindDTO request) {
        BlindEntity blind = modelMapper.map(request, BlindEntity.class);
        blind = blindService.create(blind);
        return modelMapper.map(blind, BlindDTO.class);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public BlindsListDTO findAll(Pageable request) {
        BlindsList blinds = blindService.findAll(request);
        return modelMapper.map(blinds, BlindsListDTO.class);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public BlindDTO update(@RequestBody @Valid BlindDTO request) throws EntityNotFoundException {
        BlindEntity blind = modelMapper.map(request, BlindEntity.class);
        blind = blindService.update(blind);
        return modelMapper.map(blind, BlindDTO.class);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public BlindDTO delete(@PathVariable String id) throws EntityNotFoundException {
        BlindEntity blind = blindService.delete(id);
        return modelMapper.map(blind, BlindDTO.class);
    }
}
