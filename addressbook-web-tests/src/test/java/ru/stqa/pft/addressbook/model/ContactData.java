package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String username;
    private final String familyName;
    private final String phoneNumber;
    private final String email;
    private final String address;

    public ContactData(String username, String familyName, String address, String phoneNumber, String email) {
        this.username = username;
        this.familyName = familyName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;

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