package pl.krawczyk.myhome.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.krawczyk.myhome.entities.containers.BlindsList;
import pl.krawczyk.myhome.entities.containers.LightsList;
import pl.krawczyk.myhome.modelbase.MicrocontrollerBase;

/**
 *
 * @author Łukasz
 */
@Document(collection = "microcontrollers")
public class MicrocontrollerEntity extends MicrocontrollerBase {
    
    @Id
    private String id;
    @DBRef
    private LightsList lights = new LightsList();
    @DBRef
    private BlindsList blinds = new BlindsList();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public LightsList getLights() {
        return lights;
    }

    public void setLights(LightsList lights) {
        this.lights = lights;
    }
    
    public void addLight(LightEntity light) {
        this.lights.add(light);
    }
    
    public void removeLight(LightEntity light) {
        this.lights.remove(light);
    }

    public BlindsList getBlinds() {
        return blinds;
    }

    public void setBlinds(BlindsList blinds) {
        this.blinds = blinds;
    }
    
    public void addBlind(BlindEntity blind) {
        this.blinds.add(blind);
    }
    
    public void removeBlind(BlindEntity blind) {
        this.blinds.remove(blind);
    }
}
