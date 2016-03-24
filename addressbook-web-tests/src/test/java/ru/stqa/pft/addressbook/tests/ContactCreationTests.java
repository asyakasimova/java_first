package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreationTests() throws Exception {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withUsername("Asya1").withFamilyName("KasKas").withGroup("test1").withAddress("test address").withPhoneNumber("+7 495 111 11 11").withEmail("asya.kasimova@something.ru");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }

  @Test
  public void testBadContactCreationTests() throws Exception {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withUsername("Asya1'").withFamilyName("KasKas").withGroup("test1").withAddress("test address").withPhoneNumber("+7 495 111 11 11").withEmail("asya.kasimova@something.ru");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));

  }


}
