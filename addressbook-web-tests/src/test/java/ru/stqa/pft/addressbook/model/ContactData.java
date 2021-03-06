package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("contact")
public class ContactData {
    @XStreamOmitField
    private int id = Integer.MAX_VALUE;
    @Expose
    private String username;
    @Expose
    private String familyName;

    @Expose
    private String email;
    @Expose
    private String group;
    @Expose
    private String address;
    @Expose
    private String home;
    @Expose
    private String mobile;
    @Expose
    private String work;
    @Expose
    private String allPhones;
    @Expose
    private String mail1;
    @Expose
    private String mail2;
    @Expose
    private String mail3;
    @Expose
    private String emails;
    @Expose
    private String photoname;

    public Phones getPhones() {
        return phones;
    }

    public ContactData withPhones(Phones phones) {
        this.phones = phones;
        return this;
    }

    @Expose
    Phones phones;


    public String getPhotoname() {
        return photoname;
    }

    public ContactData withPhotoname(String photo) {
        this.photoname = photo;
        return this;
    }

    public String getEmails() {
        return emails;
    }

    public ContactData withEmails(String emails) {
        this.emails = emails;
        return this;
    }

    public String getMail1() {
        return mail1;
    }

    public ContactData withMail1(String mail1) {
        this.mail1 = mail1;
        return this;
    }

    public String getMail2() {
        return mail2;
    }

    public ContactData withMail2(String mail2) {
        this.mail2 = mail2;
        return this;
    }

    public String getMail3() {
        return mail3;
    }

    public ContactData withMail3(String mail3) {
        this.mail3 = mail3;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getHomePhone() {
        return home;
    }

    public String getMobilePhone() {
        return mobile;
    }

    public String getWorkPhone() {
        return work;
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

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHomePhone(String home) {
        this.home = home;
        return this;
    }

    public ContactData withMobilePhone(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactData withWorkPhone(String work) {
        this.work = work;
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

        if (id != that.id) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        return familyName != null ? familyName.equals(that.familyName) : that.familyName == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (familyName != null ? familyName.hashCode() : 0);
        return result;
    }
}
