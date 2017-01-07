package pl.krawczyk.myhome.entities;

import org.springframework.data.annotation.Id;
import pl.krawczyk.myhome.modelbase.LightBase;

/**
 *
 * @author Łukasz
 */
public class LightEntity extends LightBase {
    
    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
