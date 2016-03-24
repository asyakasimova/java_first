package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Valkyrja on 03.03.2016.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensureContactPreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size() == 0){
            app.contact().create(new ContactData().withUsername("Asya1").withFamilyName("Kasimova"), true);
        }
    }

    @Test
    public void testContactModification() {

        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        ContactData contact = new ContactData()
                .withId(before.get(index).getId()). withUsername("Asya22").withFamilyName("KasKas").withGroup(null).withAddress("test address").withPhoneNumber("+7 495 123 45 78").withEmail("asya.kasimova@test.ru");
        app.contact().modify(index, contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);

        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }


}
