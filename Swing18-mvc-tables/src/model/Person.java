package model;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author ddok
 */
public class Person {
    
    private final static AtomicLong index = new AtomicLong();

    private Long id;
    private String name;
    private String occupation;
    private AgeCategory ageCategory;
    private EmployementCategory empCategory;
    private String taxId;
    private boolean usCitizen;
    private GenderCategory gender;

    public Person() {
    }

    public Person(String name, 
            String occupation, 
            AgeCategory ageCategory, 
            EmployementCategory empCategory, 
            String taxId, 
            boolean usCitizen, 
            GenderCategory gender) {
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.empCategory = empCategory;
        this.taxId = taxId;
        this.usCitizen = usCitizen;
        this.gender = gender;
        // Auto-increment ID for each person created
        this.id = index.incrementAndGet();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    public EmployementCategory getEmpCategory() {
        return empCategory;
    }

    public void setEmpCategory(EmployementCategory empCategory) {
        this.empCategory = empCategory;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public boolean isUsCitizen() {
        return usCitizen;
    }

    public void setUsCitizen(boolean usCitizen) {
        this.usCitizen = usCitizen;
    }

    public GenderCategory getGender() {
        return gender;
    }

    public void setGender(GenderCategory gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", occupation=" + occupation + ", ageCategory=" + ageCategory + ", empCategory=" + empCategory + ", taxId=" + taxId + ", usCitizen=" + usCitizen + ", gender=" + gender + '}';
    }

}
