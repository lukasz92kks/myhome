package pl.krawczyk.myhome.controllers;

import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.krawczyk.myhome.dto.microcontroller.MicrocontrollerDTO;
import pl.krawczyk.myhome.dto.microcontroller.MicrocontrollersListDTO;
import pl.krawczyk.myhome.dto.microcontroller.CreateRequestDTO;
import pl.krawczyk.myhome.dto.microcontroller.UpdateRequestDTO;
import pl.krawczyk.myhome.entities.MicrocontrollerEntity;
import pl.krawczyk.myhome.entities.containers.MicrocontrollersList;
import pl.krawczyk.myhome.exceptions.EntityNotFoundException;
import pl.krawczyk.myhome.services.interfaces.BlindService;
import pl.krawczyk.myhome.services.interfaces.MicrocontrollerService;
import pl.krawczyk.myhome.services.interfaces.LightService;

/**
 *
 * @author Łukasz
 */
@RestController
@RequestMapping("/api/microcontrollers")
public class MicrocontrollerController {
    
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MicrocontrollerService microcontrollerService;
    @Autowired
    private LightService lightService;
    @Autowired
    private BlindService blindService;
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public MicrocontrollerDTO findById(@PathVariable String id) throws EntityNotFoundException {
        MicrocontrollerEntity microcontroller = microcontrollerService.findById(id);
        return modelMapper.map(microcontroller, MicrocontrollerDTO.class);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public MicrocontrollerDTO create(@RequestBody @Valid CreateRequestDTO request) {
        MicrocontrollerEntity microcontroller = modelMapper.map(request, MicrocontrollerEntity.class);
        microcontroller = microcontrollerService.create(microcontroller, request.getLights(), request.getBlinds());
        return modelMapper.map(microcontroller, MicrocontrollerDTO.class);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public MicrocontrollersListDTO findAll(Pageable pageable) {
        MicrocontrollersList list = microcontrollerService.findAll(pageable);
        return modelMapper.map(list, MicrocontrollersListDTO.class);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public MicrocontrollerDTO update(@RequestBody @Valid UpdateRequestDTO request) throws EntityNotFoundException {
        MicrocontrollerEntity microcontroller = modelMapper.map(request, MicrocontrollerEntity.class);
        microcontroller = microcontrollerService.update(microcontroller);
        return modelMapper.map(microcontroller, MicrocontrollerDTO.class);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public MicrocontrollerDTO delete(@PathVariable String id) throws EntityNotFoundException {
        MicrocontrollerEntity microcontroller = microcontrollerService.delete(id);
        return modelMapper.map(microcontroller, MicrocontrollerDTO.class);
    }
}
