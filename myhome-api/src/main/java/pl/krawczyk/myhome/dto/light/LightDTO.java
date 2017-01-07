package pl.krawczyk.myhome.dto.light;

import pl.krawczyk.myhome.modelbase.LightBase;

/**
 *
 * @author Łukasz
 */
public class LightDTO extends LightBase {
    
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
