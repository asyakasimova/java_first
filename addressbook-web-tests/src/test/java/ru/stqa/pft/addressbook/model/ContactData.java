package ru.stqa.pft.addressbook.model;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private String username;
    private String familyName;
    private String phoneNumber;
    private String email;
    private String group;
    private String address;


    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withUsername(String username) {
        this.username = username;
        return this;
    }

    public ContactData withFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public ContactData withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +

                ", familyName='" + familyName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        return familyName != null ? familyName.equals(that.familyName) : that.familyName == null;

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (familyName != null ? familyName.hashCode() : 0);
        return result;
    }

}
