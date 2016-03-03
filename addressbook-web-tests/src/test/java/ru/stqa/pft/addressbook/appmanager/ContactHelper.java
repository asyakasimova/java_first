package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Valkyrja on 03.03.2016.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
      click(By.linkText("home"));
    }

    public void submittingNewContact() {
      click(By.cssSelector("input[type=\"submit\"]"));
    }

    public void fillingContactParameters(ContactData contactData) {
        type(By.name("firstname"), contactData.getUsername());
        type(By.name("lastname"), contactData.getFamilyName());
        type(By.name("home"), contactData.getPhoneNumber());
        type(By.name("home"), contactData.getAddress());
        type(By.name("email"), contactData.getEmail());
      // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
    }

    public void contactCreationPage() {
      click(By.linkText("add new"));
    }
}
