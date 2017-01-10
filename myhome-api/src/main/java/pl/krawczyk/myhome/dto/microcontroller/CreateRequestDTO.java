package pl.krawczyk.myhome.dto.microcontroller;

import java.util.ArrayList;
import java.util.List;
import pl.krawczyk.myhome.modelbase.MicrocontrollerBase;

/**
 *
 * @author Łukasz
 */
public class CreateRequestDTO extends MicrocontrollerBase {
    
    private List<String> lights = new ArrayList<>();
    private List<String> blinds = new ArrayList<>();

    public List<String> getLights() {
        return lights;
    }

    public void setLights(List<String> lights) {
        this.lights = lights;
    }

    public List<String> getBlinds() {
        return blinds;
    }

    public void setBlinds(List<String> blinds) {
        this.blinds = blinds;
    }
}
