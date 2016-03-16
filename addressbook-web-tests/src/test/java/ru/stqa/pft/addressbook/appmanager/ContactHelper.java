package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

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

    public void fillingContactParameters(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getUsername());
        type(By.name("lastname"), contactData.getFamilyName());
        type(By.name("home"), contactData.getPhoneNumber());
        type(By.name("address"), contactData.getAddress());
        type(By.name("email"), contactData.getEmail());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
      // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
    }

    public void contactCreationPage() {
      click(By.linkText("add new"));
    }
    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void acceptContactDeletion() {
        alertAccept();
    }

    public void openEditForm(int index) {

        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModifitation() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void createContact(ContactData contact, boolean b) {
        contactCreationPage();
        fillingContactParameters(contact, true);
        submittingNewContact();
        returnToHomePage();
    }

    public boolean isThereAContact() {

        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("entry")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String username = element.findElement(By.xpath("./td[2]")).getText();
            String familyName = element.findElement(By.xpath("./td[1]")).getText();
            ContactData contact = new ContactData("Asya", "KasKas", null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
