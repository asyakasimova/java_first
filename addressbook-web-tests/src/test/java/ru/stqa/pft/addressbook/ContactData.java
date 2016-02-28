package ru.stqa.pft.addressbook;

public class ContactData {
    private final String username;
    private final String familyName;
    private final String phoneNumber;
    private final String email;
    private final String address;

    public ContactData(String username, String familyName, String phoneNumber, String address, String email) {
        this.username = username;
        this.familyName = familyName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
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
}
