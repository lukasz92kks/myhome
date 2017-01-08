package pl.krawczyk.myhome.entities.containers;

import java.util.ArrayList;
import java.util.Collection;
import pl.krawczyk.myhome.entities.BlindEntity;

/**
 *
 * @author Łukasz
 */
public class BlindsList extends ArrayList<BlindEntity> {
    
    public BlindsList() {
    }
    
    public BlindsList(Collection<? extends BlindEntity> list) {
        super(list);
    }
}
