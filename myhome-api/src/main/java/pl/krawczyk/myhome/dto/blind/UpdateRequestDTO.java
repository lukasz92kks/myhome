package pl.krawczyk.myhome.dto.blind;

import pl.krawczyk.myhome.modelbase.BlindBase;

/**
 *
 * @author Łukasz
 */
public class UpdateRequestDTO extends BlindBase {
    
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
