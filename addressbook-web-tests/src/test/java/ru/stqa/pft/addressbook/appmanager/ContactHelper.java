package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

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
        attach(By.name("photo"), contactData.getPhoto());
 //       if (creation) {
 //           new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
 //       } else {
 //           Assert.assertFalse(isElementPresent(By.name("new_group")));
 //       }
      // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
    }

    public void contactCreationPage() {
      click(By.linkText("add new"));
    }
    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void acceptContactDeletion() {
        alertAccept();
    }

/*    public void openEditForm(int index) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        WebElement row = elements.get(index);
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    } */

    public void openEditFormById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    }



    public void submitContactModifitation() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void create(ContactData contact, boolean b) {
        contactCreationPage();
        fillingContactParameters(contact, true);
        submittingNewContact();
        contactCache = null;
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        openEditFormById(contact.getId());
        fillingContactParameters(contact, false);
        submitContactModifitation();
        contactCache = null;
        returnToHomePage();
    }

    public String view(ContactData contact){
        initContactViewById(contact.getId());
        String pageText = wd.findElement(By.id("content")).getText();
        return pageText;
    }

     public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        acceptContactDeletion();
        contactCache = null;
        returnToHomePage();
    }

    public boolean isThereAContact() {

        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("entry")).size();
    }

    private Contacts contactCache = null;


    public Contacts all() {
        if(contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String firstname = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            String allPhones = cells.get(5).getText();
            String address = cells.get(3).getText();
            String emails = cells.get(4).getText();

            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contactCache.add(new ContactData().withId(id).withUsername(firstname).withFamilyName(lastname).withAllPhones(allPhones)
                    .withAddress(address).withEmails(emails));
        }
        return new Contacts(contactCache);
    }


    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String mail1 = wd.findElement(By.name("email")).getAttribute("value");
        String mail2 = wd.findElement(By.name("email2")).getAttribute("value");
        String mail3 = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withUsername(firstname).withFamilyName(lastname).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
                .withMail1(mail1).withMail2(mail2).withMail3(mail3).withAddress(address);
    }

    private void initContactModificationById(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    }

    private void initContactViewById(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();
    }

 /*   public ContactData infoFromViewForm(ContactData contact) {
        initContactViewById(contact.getId());
        String pageText = wd.findElement(By.id("content")).getText();
        return new ContactData().withPageText(pageText);
    }*/

}
