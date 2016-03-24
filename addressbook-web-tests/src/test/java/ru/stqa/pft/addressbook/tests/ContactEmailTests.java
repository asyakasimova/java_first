package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Valkyrja on 24.03.2016.
 */
public class ContactEmailTests extends TestBase {
    @BeforeMethod
    public void ensureContactPreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0){
            app.contact().create(new ContactData().withUsername("Asya1").withFamilyName("Kasimova").withHomePhone("+7 111"), true);
        }
    }

    @Test
    public void testContactEmails() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getMail1(), equalTo(cleaned(contactInfoFromEditForm.getMail1())));
        assertThat(contact.getMail2(), equalTo(cleaned(contactInfoFromEditForm.getMail2())));
        assertThat(contact.getMail3(), equalTo(cleaned(contactInfoFromEditForm.getMail3())));
    }

    public String cleaned(String mail) {
        return mail.replaceAll("\\n", " ").replaceAll("", "");
    }
}
