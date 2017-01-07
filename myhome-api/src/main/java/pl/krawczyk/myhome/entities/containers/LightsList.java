package pl.krawczyk.myhome.entities.containers;

import java.util.ArrayList;
import java.util.Collection;
import pl.krawczyk.myhome.entities.LightEntity;

/**
 *
 * @author Łukasz
 */
public class LightsList extends ArrayList<LightEntity> {
    
    public LightsList() {
    }
    
    public LightsList(Collection<? extends LightEntity> list) {
        super(list);
    }
}
