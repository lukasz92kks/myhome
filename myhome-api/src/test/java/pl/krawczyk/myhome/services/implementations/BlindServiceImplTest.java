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
import pl.krawczyk.myhome.dao.interfaces.BlindRepository;
import pl.krawczyk.myhome.entities.BlindEntity;
import pl.krawczyk.myhome.entities.containers.BlindsList;
import pl.krawczyk.myhome.exceptions.EntityNotFoundException;
import pl.krawczyk.myhome.services.interfaces.BlindService;

/**
 *
 * @author Łukasz
 */
@RunWith(MockitoJUnitRunner.class)
public class BlindServiceImplTest {
    
    @Mock
    private BlindRepository repository;
    
    private BlindService blindService;
    
    private final String id = "123";
    private BlindEntity expected;
    
    @Before
    public void setUp() {
        blindService = new BlindServiceImpl(repository);
        
        expected = new BlindEntity();
        expected.setId(id);
        expected.setName("blind1");
        expected.setOpen(true);
    }

    @Test
    public void findById_shallReturnObject() throws Exception {
        // given
        when(repository.findOne(id)).thenReturn(expected);
        
        // when
        BlindEntity blind = blindService.findById(id);
        
        // then
        Assertions.assertThat(blind)
                .isEqualToComparingFieldByField(expected);
    }
    
    @Test(expected = EntityNotFoundException.class)
    public void findById_shallThrowException() throws Exception {
        // when
        blindService.findById(id);
    }

    @Test
    public void create_shallSaveObject() {
        // given
        BlindEntity newBlind = new BlindEntity();
        newBlind.setId(id);
        newBlind.setName("blind1");
        newBlind.setOpen(true);
        
        when(repository.save(newBlind)).thenReturn(expected);
        
        // when
        BlindEntity blind = blindService.create(newBlind);
        
        // then
        Assertions.assertThat(blind)
                .isEqualToComparingFieldByField(expected);
    }

    @Test
    public void findAll_shallReturnList() {
        // given
        BlindEntity expected2 = new BlindEntity();
        expected2.setId("222");
        expected2.setName("blind2");
        BlindsList expectedList = new BlindsList();
        expectedList.add(expected);
        expectedList.add(expected2);
        Page page = new PageImpl(expectedList);
        
        Pageable pageable = new PageRequest(0, 10);
        when(repository.findAll(pageable)).thenReturn(page);
        
        // when
        BlindsList list = blindService.findAll(pageable);
        
        // then
        Assertions.assertThat(list)
                .hasSize(expectedList.size())
                .contains(expected, expected2);
    }
    
    @Test
    public void findAll_shallReturnPageableList() {
        // given
        BlindEntity expected2 = new BlindEntity();
        expected2.setId("222");
        expected2.setName("blind2");
        BlindsList expectedList = new BlindsList();
        expectedList.add(expected2);
        Page page = new PageImpl(expectedList);
        
        Pageable pageable = new PageRequest(1, 1);
        when(repository.findAll(pageable)).thenReturn(page);
        
        // when
        BlindsList list = blindService.findAll(pageable);
        
        // then
        Assertions.assertThat(list)
                .hasSize(1)
                .contains(expected2);
    }

    @Test
    public void update_shallUpdateObject() throws Exception {
        // given
        BlindEntity updatedBlind = new BlindEntity();
        updatedBlind.setId(id);
        updatedBlind.setName("blind1");
        updatedBlind.setOpen(false);
        
        BlindEntity request = new BlindEntity();
        request.setId(id);
        request.setOpen(true);
        
        when(repository.findOne(id)).thenReturn(updatedBlind);
        when(repository.save(updatedBlind)).thenReturn(expected);
        
        // when
        BlindEntity blind = blindService.update(request);
        
        // then
        Assertions.assertThat(blind)
                .isEqualToComparingFieldByField(expected);
    }
    
    @Test(expected = EntityNotFoundException.class)
    public void update_shallThrowException() throws Exception {
        // given
        BlindEntity request = new BlindEntity();
        request.setId(id);
        request.setOpen(false);
        
        when(repository.save(request)).thenReturn(expected);
        
        // when
        blindService.update(request);
    }

    @Test
    public void delete_shallDeleteObject() throws Exception {
        // given
        when(repository.findOne(id)).thenReturn(expected);
        
        // when
        BlindEntity blind = blindService.delete(id);
        
        // then
        Assertions.assertThat(blind)
                .isEqualToComparingFieldByField(expected);
    }
    
    @Test(expected = EntityNotFoundException.class)
    public void delete_shallThrowException() throws Exception {
        // when
        blindService.delete(id);
    }
}
