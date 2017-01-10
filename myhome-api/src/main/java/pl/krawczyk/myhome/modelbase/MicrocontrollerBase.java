package pl.krawczyk.myhome.modelbase;

/**
 *
 * @author Łukasz
 */
public class MicrocontrollerBase {
    
    private String name;
    private String ipAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
