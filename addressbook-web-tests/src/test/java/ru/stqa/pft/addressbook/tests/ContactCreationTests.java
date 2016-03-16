package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreationTests() throws Exception {
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new ContactData("Asya1", "Kasimova", "test1", "test address", "+7 495 111 11 11",  "asya.kasimova@something.ru"), true);
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);

  }

}
