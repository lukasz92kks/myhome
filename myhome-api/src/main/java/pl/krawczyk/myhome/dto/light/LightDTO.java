package pl.krawczyk.myhome.dto.light;

import pl.krawczyk.myhome.modelbase.LightBase;

/**
 *
 * @author Łukasz
 */
public class LightDTO extends LightBase {
    
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
