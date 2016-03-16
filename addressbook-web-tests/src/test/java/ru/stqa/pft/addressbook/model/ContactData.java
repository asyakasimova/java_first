package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String id;
    private final String username;
    private final String familyName;
    private final String phoneNumber;
    private final String email;
    private String group;
    private final String address;



    public ContactData(String username, String familyName, String group, String address, String phoneNumber, String email) {
        this.id = null;
        this.username = username;
        this.familyName = familyName;
        this.group = group;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;

    }

    public ContactData(String id, String username, String familyName, String group, String address, String phoneNumber, String email) {
        this.id = id;
        this.username = username;
        this.familyName = familyName;
        this.group = group;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;

    }

    public String getId() {
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

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        return familyName != null ? familyName.equals(that.familyName) : that.familyName == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (familyName != null ? familyName.hashCode() : 0);
        return result;
    }
}
