package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Valkyrja on 03.03.2016.
 */
public class ContactHelper extends HelperBase {



    public ContactHelper(WebDriver wd) {
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
        type(By.name("address"), contactData.getAddress());
        type(By.name("email"), contactData.getEmail());
      // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
    }

    public void contactCreationPage() {
      click(By.linkText("add new"));
    }
    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void acceptContactDeletion() {
        alertAccept();
    }

    public void openEditForm() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModifitation() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }
}
