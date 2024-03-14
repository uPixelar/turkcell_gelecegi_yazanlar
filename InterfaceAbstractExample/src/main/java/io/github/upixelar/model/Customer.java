package io.github.upixelar.model;

public class Customer extends BaseEntity{
    private String nationalId;
    private String firstName;
    private String lastName;
    private short birthYear;

    public Customer(String nationalId, String firstName, String lastName, int birthYear) {
        this.nationalId = nationalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = (short) birthYear;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public short getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(short birthYear) {
        this.birthYear = birthYear;
    }
}
