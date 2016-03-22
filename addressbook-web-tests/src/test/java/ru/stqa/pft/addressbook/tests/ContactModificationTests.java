package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Valkyrja on 03.03.2016.
 */
public class ContactModificationTests extends TestBase {

    @Test(enabled = false)

    public void testContactModification() {
        app.goTo().gotoHomePage();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Asya1", "Kasimova", "test1", "test address", "+7 495 111 11 11",  "asya.kasimova@something.ru"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().openEditForm(before.size() - 1);

        ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Asya22", "KasKas", null, "test address", "+7 495 123 45 78",  "asya.kasimova@test.ru");
        app.getContactHelper().fillingContactParameters(contact, false);
        app.getContactHelper().submitContactModifitation();
        app.goTo().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);

        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }
}
