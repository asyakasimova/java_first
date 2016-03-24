package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Valkyrja on 24.03.2016.
 */
public class ContactAddressTests extends TestBase {
    @BeforeMethod
    public void ensureContactPreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0){
            app.contact().create(new ContactData().withUsername("Asya1").withFamilyName("Kasimova").withHomePhone("+7 111"), true);
        }
    }

    @Test
    public void testContactAddress() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        MatcherAssert.assertThat(contact.getAddress(), CoreMatchers.equalTo(cleaned(contactInfoFromEditForm.getAddress())));
    }

    public String cleaned(String address) {
        return address.replaceAll(" {2,}", " ");
    }
}
