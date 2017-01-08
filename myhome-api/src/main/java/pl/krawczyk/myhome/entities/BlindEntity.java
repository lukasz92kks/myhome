package pl.krawczyk.myhome.entities;

import org.springframework.data.annotation.Id;
import pl.krawczyk.myhome.modelbase.BlindBase;

/**
 *
 * @author Łukasz
 */
public class BlindEntity extends BlindBase {
    
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
