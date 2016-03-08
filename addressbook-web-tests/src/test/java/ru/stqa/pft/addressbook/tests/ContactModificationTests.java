package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Valkyrja on 03.03.2016.
 */
public class ContactModificationTests extends TestBase {

    @Test

    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Asya1", "Kasimova", "test1", "test address", "+7 495 111 11 11",  "asya.kasimova@something.ru"), true);
        }
        app.getContactHelper().openEditForm();
        app.getContactHelper().fillingContactParameters(new ContactData("Asechka", "Kasimova", null, "test address", "+7 495 123 45 78",  "asya.kasimova@test.ru"), false);
        app.getContactHelper().submitContactModifitation();
        app.getNavigationHelper().gotoHomePage();
    }
}
