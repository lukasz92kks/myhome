package pl.krawczyk.myhome.dto.microcontroller;

import pl.krawczyk.myhome.modelbase.MicrocontrollerBase;

/**
 *
 * @author Łukasz
 */
public class MicrocontrollerDTO extends MicrocontrollerBase {
    
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
