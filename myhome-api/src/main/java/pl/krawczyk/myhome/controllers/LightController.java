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
import pl.krawczyk.myhome.dto.light.LightDTO;
import pl.krawczyk.myhome.dto.light.LightsListDTO;
import pl.krawczyk.myhome.dto.light.UpdateRequestDTO;
import pl.krawczyk.myhome.entities.LightEntity;
import pl.krawczyk.myhome.entities.containers.LightsList;
import pl.krawczyk.myhome.exceptions.EntityNotFoundException;
import pl.krawczyk.myhome.services.interfaces.LightService;

/**
 *
 * @author Łukasz
 */
@RestController
@RequestMapping("/api")
public class LightController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private LightService lightService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public LightDTO findById(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LightEntity light = lightService.findById(id);
        return modelMapper.map(light, LightDTO.class);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public LightDTO create(@RequestBody @Valid LightDTO request) {
        LightEntity light = modelMapper.map(request, LightEntity.class);
        light = lightService.create(light);
        return modelMapper.map(light, LightDTO.class);
    }

    @RequestMapping(method = RequestMethod.GET)
    public LightsListDTO findAll(Pageable request) {
        LightsList lights = lightService.findAll(request);
        return modelMapper.map(lights, LightsListDTO.class);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public LightDTO update(@RequestBody @Valid UpdateRequestDTO request) throws EntityNotFoundException {
        LightEntity light = modelMapper.map(request, LightEntity.class);
        light = lightService.update(light);
        return modelMapper.map(light, LightDTO.class);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public LightDTO delete(@PathVariable Integer id) throws EntityNotFoundException {
        LightEntity light = lightService.delete(id);
        return modelMapper.map(light, LightDTO.class);
    }
}
