package model;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author ddok
 */
public class Person {
    
    private static final AtomicInteger index = new AtomicInteger();

    private long id;
    private String firstname;
    private String lastname;
    private String occupation;
    private String role;
    private String gender;
    private String address;

    public Person(String firstname, String lastname, String occupation, String role, String gender, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.occupation = occupation;
        this.role = role;
        this.gender = gender;
        this.address = address;
        
        this.id = index.incrementAndGet();
    }

    public Person() {
        this.id = index.incrementAndGet();
    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", occupation=" + occupation + ", role=" + role + ", gender=" + gender + ", address=" + address + '}';
    }

}
