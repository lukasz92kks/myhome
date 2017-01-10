package pl.krawczyk.myhome.entities.containers;

import java.util.ArrayList;
import java.util.Collection;
import pl.krawczyk.myhome.entities.MicrocontrollerEntity;

/**
 *
 * @author Łukasz
 */
public class MicrocontrollersList extends ArrayList<MicrocontrollerEntity> {
    
    public MicrocontrollersList() {
    }
    
    public MicrocontrollersList(Collection<? extends MicrocontrollerEntity> list) {
        super(list);
    }
}
