package gui;

/**
 *
 * @author ddok
 */
public class AgeCat {

    private long id;
    private String value;

    public AgeCat() {
    }

    public AgeCat(long id, String value) {
        this.id = id;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
