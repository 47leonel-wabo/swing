package gui;

/**
 *
 * @author ddok
 */
public class ActivityForm {

    private String name;
    private String occupation;
    private String age;

    public ActivityForm(String name, String occupation, String age) {
        this.name = name;
        this.occupation = occupation;
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public ActivityForm(String name, String occupation) {
        this.name = name;
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "ActivityForm{" + "name=" + name + ", occupation=" + occupation + ", age=" + age + '}';
    }

}
