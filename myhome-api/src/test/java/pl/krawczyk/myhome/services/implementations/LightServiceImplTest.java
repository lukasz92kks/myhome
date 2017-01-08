package pl.krawczyk.myhome.services.implementations;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import pl.krawczyk.myhome.dao.interfaces.LightRepository;
import pl.krawczyk.myhome.entities.LightEntity;
import pl.krawczyk.myhome.entities.containers.LightsList;
import pl.krawczyk.myhome.exceptions.EntityNotFoundException;
import pl.krawczyk.myhome.services.interfaces.LightService;

/**
 *
 * @author Łukasz
 */
@RunWith(MockitoJUnitRunner.class)
public class LightServiceImplTest {
    
    @Mock
    private LightRepository repository;
    
    private LightService lightService;
    
    private final String id = "123";
    private LightEntity expected;
    
    @Before
    public void setUp() {
        lightService = new LightServiceImpl(repository);
        
        expected = new LightEntity();
        expected.setId(id);
        expected.setName("light1");
        expected.setOn(true);
    }

    @Test
    public void findById_shallReturnObject() throws Exception {
        // given
        when(repository.findOne(id)).thenReturn(expected);
        
        // when
        LightEntity light = lightService.findById(id);
        
        // then
        Assertions.assertThat(light)
                .isEqualToComparingFieldByField(expected);
    }
    
    @Test(expected = EntityNotFoundException.class)
    public void findById_shallThrowException() throws Exception {
        // when
        LightEntity light = lightService.findById(id);
    }

    @Test
    public void create_shallSaveNewObject() {
        // given
        LightEntity newLight = new LightEntity();
        newLight.setId(id);
        newLight.setName("light1");
        newLight.setOn(true);
        
        when(repository.save(newLight)).thenReturn(expected);
        
        // when
        LightEntity light = lightService.create(newLight);
        
        // then
        Assertions.assertThat(light)
                .isEqualToComparingFieldByField(expected);
    }

    @Test
    public void findAll_shallReturnList() {
        // given
        LightEntity expected2 = new LightEntity();
        expected2.setId("222");
        expected2.setName("light2");
        LightsList expectedList = new LightsList();
        expectedList.add(expected);
        expectedList.add(expected2);
        Page page = new PageImpl(expectedList);
        
        Pageable pageable = new PageRequest(0, 10);
        when(repository.findAll(pageable)).thenReturn(page);
        
        // when
        LightsList list = lightService.findAll(pageable);
        
        // then
        Assertions.assertThat(list)
                .hasSize(expectedList.size())
                .contains(expected, expected2);
    }
    
    @Test
    public void findAll_shallReturnPageableList() {
        // given
        LightEntity expected2 = new LightEntity();
        expected2.setId("222");
        expected2.setName("light2");
        LightsList expectedList = new LightsList();
        expectedList.add(expected2);
        Page page = new PageImpl(expectedList);
        
        Pageable pageable = new PageRequest(1, 1);
        when(repository.findAll(pageable)).thenReturn(page);
        
        // when
        LightsList list = lightService.findAll(pageable);
        
        // then
        Assertions.assertThat(list)
                .hasSize(1)
                .contains(expected2);
    }

    @Test
    public void update_shallUpdateObject() throws Exception {
        // given
        LightEntity updatedLight = new LightEntity();
        updatedLight.setId(id);
        updatedLight.setName("light1");
        updatedLight.setOn(false);
        
        LightEntity request = new LightEntity();
        request.setId(id);
        request.setOn(true);
        
        when(repository.findOne(id)).thenReturn(updatedLight);
        when(repository.save(updatedLight)).thenReturn(expected);
        
        // when
        LightEntity light = lightService.update(request);
        
        // then
        Assertions.assertThat(light)
                .isEqualToComparingFieldByField(expected);
    }
    
    @Test(expected = EntityNotFoundException.class)
    public void update_shallThrowException() throws Exception {
        // given
        LightEntity request = new LightEntity();
        request.setId(id);
        request.setOn(false);
        
        when(repository.save(request)).thenReturn(expected);
        
        // when
        LightEntity light = lightService.update(request);
    }

    @Test
    public void delete_shallDeleteObject() throws Exception {
        // given
        when(repository.findOne(id)).thenReturn(expected);
        
        // when
        LightEntity light = lightService.delete(id);
        
        // then
        Assertions.assertThat(light)
                .isEqualToComparingFieldByField(expected);
    }
    
    @Test(expected = EntityNotFoundException.class)
    public void delete_shallThrowException() throws Exception {
        // when
        LightEntity light = lightService.delete(id);
    }
}
