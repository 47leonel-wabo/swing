package gui;

/**
 *
 * @author ddok
 */
public class ActivityForm {

    private String name;
    private String occupation;
    private String age;
    private String employment;
    private boolean citizen;
    private String taxId;
    private String gender;

    public ActivityForm(String name, String occupation, String age, String employment, boolean citizen, String taxId, String gender) {
        this.name = name;
        this.occupation = occupation;
        this.age = age;
        this.employment = employment;
        this.citizen = citizen;
        this.taxId = taxId;
        this.gender = gender;
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
        return "ActivityForm{" + "name=" + name + ", occupation=" + occupation + ", age=" + age + ", employment=" + employment + ", citizen=" + citizen + ", taxId=" + taxId + ", gender=" + gender + '}';
    }

}