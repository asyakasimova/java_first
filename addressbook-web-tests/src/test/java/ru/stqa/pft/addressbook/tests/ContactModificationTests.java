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
        app.getContactHelper().openEditForm();
        app.getContactHelper().fillingContactParameters(new ContactData("Asechka", "Kasimova", "test address", "+7 495 123 45 78",  "asya.kasimova@test.ru"));
        app.getContactHelper().submitContactModifitation();
        app.getNavigationHelper().gotoHomePage();
    }
}
