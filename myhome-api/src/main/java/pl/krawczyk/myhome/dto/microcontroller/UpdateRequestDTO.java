package pl.krawczyk.myhome.dto.microcontroller;

/**
 *
 * @author Łukasz
 */
public class UpdateRequestDTO extends CreateRequestDTO {
    
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
